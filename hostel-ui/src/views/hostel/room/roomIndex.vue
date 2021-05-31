<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="100px">
      <!--      <el-form-item label="id" prop="id">-->
      <!--        <el-input-->
      <!--          v-model="queryParams.id"-->
      <!--          placeholder="请输入id"-->
      <!--          clearable-->
      <!--          size="small"-->
      <!--          @keyup.enter.native="handleQuery"-->
      <!--        />-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="楼层id" prop="layerId">-->
      <!--        <el-input-->
      <!--          v-model="queryParams.layerId"-->
      <!--          placeholder="请输入楼层id"-->
      <!--          clearable-->
      <!--          size="small"-->
      <!--          @keyup.enter.native="handleQuery"-->
      <!--        />-->
      <!--      </el-form-item>-->
      <el-form-item label="房间类型" prop="roomType">
        <el-select v-model="queryParams.roomType" placeholder="请选择房间类型" clearable size="small">
          <el-option
            v-for="dict in roomTypeOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="房间号" prop="roomNumber">
        <el-input
          v-model="queryParams.roomNumber"
          placeholder="请输入房间号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="房间标准" prop="roomStandard">
        <el-select v-model="queryParams.roomStandard" placeholder="请选择房间标准" clearable size="small">
          <el-option
            v-for="dict in roomStandardOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="房间状态" prop="roomState">
        <el-select v-model="queryParams.roomState" placeholder="请选择房间状态" clearable size="small">
          <el-option
            v-for="dict in roomStateOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="房间入住标准" prop="roomRank">
        <el-input
          v-model="queryParams.roomRank"
          placeholder="请输入房间入住标准"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="智能电表编号" prop="electricCode">
        <el-input
          v-model="queryParams.electricCode"
          placeholder="请输入智能电表编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="智能电表地址" prop="electricPlace">
        <el-input
          v-model="queryParams.electricPlace"
          placeholder="请输入智能电表地址"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="智能水表编号" prop="waterCode">
        <el-input
          v-model="queryParams.waterCode"
          placeholder="请输入智能水表编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="只能水表地址" prop="waterPlace">
        <el-input
          v-model="queryParams.waterPlace"
          placeholder="请输入只能水表地址"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['hostel:room:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['hostel:room:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['hostel:room:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hostel:room:export']"
        >导出
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['hostel:room:edit']"
        >入住信息明细
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="roomList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <!--      <el-table-column label="id" align="center" prop="id" />-->
      <!--      <el-table-column label="楼层id" align="center" prop="layerId" />-->
      <el-table-column label="房间类型" align="center" prop="roomType" :formatter="roomTypeFormat"/>
      <el-table-column label="房间号" align="center" prop="roomNumber"/>
      <el-table-column label="房间标准" align="center" prop="roomStandard" :formatter="roomStandardFormat"/>
      <el-table-column label="房间状态" align="center" prop="roomState" :formatter="roomStateFormat"/>
      <el-table-column label="房间入住标准" align="center" prop="roomRank"/>
      <el-table-column label="智能电表编号" align="center" prop="electricCode"/>
      <el-table-column label="智能电表地址" align="center" prop="electricPlace"/>
      <el-table-column label="智能水表编号" align="center" prop="waterCode"/>
      <el-table-column label="只能水表地址" align="center" prop="waterPlace"/>
      <!--      <el-table-column label="创建人编号" align="center" prop="createCode" />-->
      <!--      <el-table-column label="创建人姓名" align="center" prop="createName" />-->
      <!--      <el-table-column label="修改人编号" align="center" prop="updateCode" />-->
      <!--      <el-table-column label="修改人名称" align="center" prop="updateName" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template>
          <el-table
            :data="tableData"
            style="width: 100%">
            <el-table-column
              prop="date"
              label="日期"
              width="180">
            </el-table-column>
            <el-table-column
              prop="name"
              label="姓名"
              width="180">
            </el-table-column>
            <el-table-column
              prop="address"
              label="地址">
            </el-table-column>
          </el-table>
        </template>
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['hostel:room:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hostel:room:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改房间档案对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>

      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="楼信息" prop="dormitoryId">
              <template>
                <el-select v-model="form.dormitoryId" filterable placeholder="请选择宿舍楼">
                  <el-option
                    v-for="item in dormitoryListAll"
                    :key="item.id"
                    :label="item.dormitoryName"
                    :value="item.id">
                  </el-option>
                </el-select>
              </template>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="楼层信息" prop="layerId">
              <template slot-scope="scope">
                <el-select v-model="form.layerId" filterable placeholder="请选择楼层" @click.native="getlistLayer()">
                  <el-option
                    v-for="item in LayerlList"
                    :key="item.id"
                    :label="item.layerNumber"
                    :value="item.id">
                  </el-option>
                </el-select>
              </template>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="房间号" prop="roomNumber">
          <el-input v-model="form.roomNumber" placeholder="请输入房间号"/>
        </el-form-item>
        <el-row>
          <el-col :span="8">
            <el-form-item label="房间类型" prop="roomType">
              <el-select v-model="form.roomType" placeholder="请选择房间类型">
                <el-option
                  v-for="dict in roomTypeOptions"
                  :key="dict.dictValue"
                  :label="dict.dictLabel"
                  :value="dict.dictValue"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="房间标准" prop="roomStandard">
              <el-select v-model="form.roomStandard" placeholder="请选择房间标准">
                <el-option
                  v-for="dict in roomStandardOptions"
                  :key="dict.dictValue"
                  :label="dict.dictLabel"
                  :value="dict.dictValue"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="房间状态" prop="roomState">
              <el-select v-model="form.roomState" placeholder="请选择房间状态">
                <el-option
                  v-for="dict in roomStateOptions"
                  :key="dict.dictValue"
                  :label="dict.dictLabel"
                  :value="dict.dictValue"
                ></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item label="房间入住标准" label-width="100px" prop="roomRank">
          <el-input v-model="form.roomRank" placeholder="请输入房间入住标准"/>
        </el-form-item>
        <el-row>
          <el-col :span="12">
            <el-form-item label="智能电表编号" label-width="100px" prop="electricCode">
              <el-input v-model="form.electricCode" placeholder="请输入智能电表编号"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="智能电表地址" label-width="100px" prop="electricPlace">
              <el-input v-model="form.electricPlace" type="textarea" placeholder="请输入智能电表地址"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="智能水表编号" label-width="100px" prop="waterCode">
              <el-input v-model="form.waterCode" placeholder="请输入智能水表编号"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="智能水表地址" label-width="100px" prop="waterPlace">
              <el-input v-model="form.waterPlace" type="textarea" placeholder="请输入智能水表地址"/>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

    <!-- 门禁设备详情对话框 -->
    <el-dialog :title="titleRoomUserInfo" :visible.sync="openRoomUserInfo" width="1000px" append-to-body>
        <el-table
          :data="tableData"
          style="width: 100%">
          <el-table-column
            prop="date"
            label="日期"
            width="180">
          </el-table-column>
          <el-table-column
            prop="name"
            label="姓名"
            width="180">
          </el-table-column>
          <el-table-column
            prop="address"
            label="地址">
          </el-table-column>
        </el-table>
    </el-dialog>
  </div>
</template>

<script>
  import {listRoom, getRoom, delRoom, addRoom, updateRoom, exportRoom} from "@/api/hostel/room";
  import { listDormitory } from "@/api/hostel/dormitory";
  import { listLayer } from "@/api/hostel/layer";

  export default {
    name: "Room",
    components: {},
    data() {
      return {
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 房间档案表格数据
        roomList: [],
        // 楼所有数据
        dormitoryListAll: [],
        // 楼层列表
        LayerlList: [],
        // 弹出层标题
        title: "",
        // 入住明细弹出标题
        titleRoomUserInfo: "",
        // 是否显示弹出层
        open: false,
        // 是否显示入住明细层
        openRoomUserInfo: false,
        // 房间类型字典
        roomTypeOptions: [],
        // 房间标准字典
        roomStandardOptions: [],
        // 房间状态字典
        roomStateOptions: [],
        tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }],
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          roomType: null,
          roomNumber: null,
          roomStandard: null,
          roomState: null,
          roomRank: '',
          electricCode: null,
          electricPlace: null,
          waterCode: null,
          waterPlace: null,
        },
        // 楼层查询参数
        queryLayerParams: {},
        // 表单参数
        form: {},
        // 表单校验
        rules: {
          dormitoryId: [
            { required: true, message: "楼信息不能为空", trigger: "blur" }
          ],
          layerId: [
            { required: true, message: "楼层信息不能为空", trigger: "blur" }
          ]
        }
      };
    },
    created() {
      this.getList();
      this.getDormitoryListAll();
      this.getDicts("room_type").then(response => {
        this.roomTypeOptions = response.data;
      });
      this.getDicts("room_standard").then(response => {
        this.roomStandardOptions = response.data;
      });
      this.getDicts("room_state").then(response => {
        this.roomStateOptions = response.data;
      });
    },
    methods: {
      /** 查询房间档案列表 */
      getList() {
        this.loading = true;
        listRoom(this.queryParams).then(response => {
          this.roomList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      // 房间类型字典翻译
      roomTypeFormat(row, column) {
        return this.selectDictLabel(this.roomTypeOptions, row.roomType);
      },
      // 房间标准字典翻译
      roomStandardFormat(row, column) {
        return this.selectDictLabel(this.roomStandardOptions, row.roomStandard);
      },
      // 房间状态字典翻译
      roomStateFormat(row, column) {
        return this.selectDictLabel(this.roomStateOptions, row.roomState);
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          id: null,
          layerId: null,
          dormitoryNumber: null,
          layerNumber: null,
          roomType: null,
          roomNumber: null,
          roomStandard: null,
          roomState: null,
          roomRank: null,
          electricCode: null,
          electricPlace: null,
          waterCode: null,
          waterPlace: null,
          createCode: null,
          createName: null,
          updateCode: null,
          updateName: null,
          isDeleted: null
        };
        this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.id)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加房间档案";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        getRoom(id).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改房间档案";
        });
      },
      /** 查看入住明细操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        getRoom(id).then(response => {
          this.form = response.data;
          this.openRoomUserInfo = true;
          this.titleRoomUserInfo = "入住明细";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.id != null) {
              updateRoom(this.form).then(response => {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addRoom(this.form).then(response => {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const ids = row.id || this.ids;
        this.$confirm('是否确认删除房间档案编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function () {
          return delRoom(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
      },
      /** 导出按钮操作 */
      handleExport() {
        const queryParams = this.queryParams;
        this.$confirm('是否确认导出所有房间档案数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function () {
          return exportRoom(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
      },
      /** 查询楼信息列表 */
      getDormitoryListAll() {
        listDormitory().then(response => {
          this.dormitoryListAll = response.rows;
        });
      },
      /** 查询楼层详情列表 */
      getlistLayer() {
        this.queryLayerParams.dormitoryId = this.form.dormitoryId
        listLayer(this.queryLayerParams).then(response => {
          this.LayerlList = response.rows;
        });
      },
    }
  };
</script>
