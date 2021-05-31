<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="楼号" prop="dormitoryCode">
        <el-input
          v-model="queryParams.dormitoryCode"
          placeholder="请输入楼号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="门禁ID" prop="accessControlId">
        <el-input
          v-model="queryParams.accessControlId"
          placeholder="请输入门禁ID"
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
          v-hasPermi="['hostel:dormitory:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['hostel:dormitory:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['hostel:dormitory:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hostel:dormitory:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="dormitoryList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="楼号" align="center" prop="dormitoryCode" />
      <el-table-column label="楼名" align="center" prop="dormitoryName" />
      <el-table-column label="层数" align="center" prop="layer">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            @click="getlistLayer(scope.row)"
          >
            {{scope.row.layer}}
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="区域" align="center" prop="region" :formatter="regionFormat" />
      <el-table-column label="门禁信息" align="center" prop="accessControlId">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            @click="getAccessControlList(scope.row)"
          >
            {{scope.row.accessControlId}}
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="创建人编号" align="center" prop="createCode" />
      <el-table-column label="创建人姓名" align="center" prop="createName" />
      <el-table-column label="修改人编号" align="center" prop="updateCode" />
      <el-table-column label="修改人名称" align="center" prop="updateName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['hostel:dormitory:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hostel:dormitory:remove']"
          >删除</el-button>
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
    <!-- 添加或修改宿舍楼档案对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="楼号" prop="dormitoryCode">
          <el-input v-model="form.dormitoryCode" placeholder="请输入楼号" />
        </el-form-item>
        <el-form-item label="楼名" prop="dormitoryName">
          <el-input v-model="form.dormitoryName" placeholder="请输入楼名" />
        </el-form-item>
        <el-form-item label="层数" prop="layer">
          <el-input v-model="form.layer" placeholder="请输入层数" />
        </el-form-item>
        <el-form-item label="门禁设备" prop="accessControlId">
          <template>
            <el-select v-model="form.accessControlId" filterable placeholder="请选择门禁">
              <el-option
                v-for="item in accessControlListAll"
                :key="item.id"
                :label="item.acName"
                :value="item.id">
              </el-option>
            </el-select>
          </template>
        </el-form-item>
        <el-form-item label="区域" prop="region">
          <el-select v-model="form.region" placeholder="请选择区域">
            <el-option
              v-for="dict in regionOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 门禁设备详情对话框 -->
    <el-dialog :title="titleAccessControl" :visible.sync="openAccessControl" width="1000px" append-to-body>
      <el-table :data="accessControlList" >
        <el-table-column label="编码" align="center" prop="acCode" />
        <el-table-column label="名称" align="center" prop="acName" />
        <el-table-column label="门禁地址" align="center" prop="acPlace" />
        <el-table-column label="创建人工号" align="center" prop="createDate" />
        <el-table-column label="创建时间" align="center" prop="createDate" />
        <el-table-column label="修改人工号" align="center" prop="updateCode" />
        <el-table-column label="修改时间" align="center" prop="updateDate" />
      </el-table>
    </el-dialog>
    <!-- 层详情列表 -->
    <el-dialog :title="titleLayer" :visible.sync="openLayer" width="1000px" append-to-body>
      <el-table :data="LayerlList" >
        <el-table-column label="宿舍楼id" align="center" prop="dormitoryId" />
        <el-table-column label="层号" align="center" prop="layerNumber" />
        <el-table-column label="房间数" align="center" prop="roomNumber" />
        <el-table-column label="门禁设备id" align="center" prop="accessControlId" />
        <el-table-column label="创建人编号" align="center" prop="createCode" />
        <el-table-column label="创建人姓名" align="center" prop="createName" />
        <el-table-column label="修改人编号" align="center" prop="updateCode" />
        <el-table-column label="修改人名称" align="center" prop="updateName" />
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
import { listDormitory, getDormitory, delDormitory, addDormitory, updateDormitory, exportDormitory } from "@/api/hostel/dormitory";
import { listAccessControl } from "@/api/hostel/accessControl";
import { listLayer } from "@/api/hostel/layer";

export default {
  name: "Dormitory",
  components: {
  },
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
      // 宿舍楼档案表格数据
      dormitoryList: [],
      // 门禁设备表格数据
      accessControlList: [],
      accessControlListAll: [],
      // 楼层列表
      LayerlList: [],
      // 弹出层标题
      title: "",
      titleAccessControl: "",
      titleLayer: "",
      // 是否显示弹出层
      open: false,
      openAccessControl: false,
      openLayer: false,
      // 区域字典
      regionOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        dormitoryCode: null,
        accessControlId: null,
      },
      // 门禁查询参数
      queryAccessControlParams: {
        pageNum: 1,
        pageSize: 10
      },
      // 楼层查询参数
      queryLayerParams: {
        pageNum: 1,
        pageSize: 10
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }

    };
  },
  created() {
    this.getList();
    this.getAccessControlListAll();
    this.getDicts("sys_hostel_area").then(response => {
      this.regionOptions = response.data;
    });
  },
  methods: {
    /** 查询宿舍楼档案列表 */
    getList() {
      this.loading = true;
      listDormitory(this.queryParams).then(response => {
        this.dormitoryList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 区域字典翻译
    regionFormat(row, column) {
      return this.selectDictLabel(this.regionOptions, row.region);
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
        dormitoryCode: null,
        dormitoryName: null,
        layer: null,
        accessControlId: null,
        region: null,
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
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加宿舍楼档案";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDormitory(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改宿舍楼档案";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDormitory(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDormitory(this.form).then(response => {
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
      this.$confirm('是否确认删除宿舍楼档案编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delDormitory(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有宿舍楼档案数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportDormitory(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    },
    /** 查询门禁设备详情列表 */
    getAccessControlList(row) {
      this.queryAccessControlParams.id = row.accessControlId
      listAccessControl(this.queryAccessControlParams).then(response => {
        this.accessControlList = response.rows;
        this.openAccessControl = true;
        this.titleAccessControl = "门禁详情";
      });
    },
    /** 查询门禁设备列表 */
    getAccessControlListAll() {
      listAccessControl().then(response => {
        this.accessControlListAll = response.rows;
      });
    },
    /** 查询楼层详情列表 */
    getlistLayer(row) {
      this.queryLayerParams.dormitoryId = row.id
      listLayer(this.queryLayerParams).then(response => {
        this.LayerlList = response.rows;
        this.openLayer = true;
        this.titleLayer = "楼层详情";
      });
    },
  }
};
</script>
