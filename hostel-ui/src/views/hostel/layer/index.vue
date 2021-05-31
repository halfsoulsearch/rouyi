<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="宿舍楼id" prop="dormitoryId">
        <el-input
          v-model="queryParams.dormitoryId"
          placeholder="请输入宿舍楼id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="层号" prop="layerNumber">
        <el-input
          v-model="queryParams.layerNumber"
          placeholder="请输入层号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="房间数" prop="roomNumber">
        <el-input
          v-model="queryParams.roomNumber"
          placeholder="请输入房间数"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="门禁设备id" prop="accessControlId">
        <el-input
          v-model="queryParams.accessControlId"
          placeholder="请输入门禁设备id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建人编号" prop="createCode">
        <el-input
          v-model="queryParams.createCode"
          placeholder="请输入创建人编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建人姓名" prop="createName">
        <el-input
          v-model="queryParams.createName"
          placeholder="请输入创建人姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改人编号" prop="updateCode">
        <el-input
          v-model="queryParams.updateCode"
          placeholder="请输入修改人编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改人名称" prop="updateName">
        <el-input
          v-model="queryParams.updateName"
          placeholder="请输入修改人名称"
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
          v-hasPermi="['hostel:layer:add']"
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
          v-hasPermi="['hostel:layer:edit']"
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
          v-hasPermi="['hostel:layer:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hostel:layer:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="layerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="宿舍楼id" align="center" prop="dormitoryId" />
      <el-table-column label="层号" align="center" prop="layerNumber" />
      <el-table-column label="房间数" align="center" prop="roomNumber" />
      <el-table-column label="门禁设备id" align="center" prop="accessControlId" />
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
            v-hasPermi="['hostel:layer:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hostel:layer:remove']"
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

    <!-- 添加或修改宿舍楼层档案对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="宿舍楼" prop="dormitoryId">
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
        <el-form-item label="层号" prop="layerNumber">
          <el-input v-model="form.layerNumber" placeholder="请输入层号" />
        </el-form-item>
        <el-form-item label="房间数" prop="roomNumber">
          <el-input v-model="form.roomNumber" placeholder="请输入房间数" />
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
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listLayer, getLayer, delLayer, addLayer, updateLayer, exportLayer } from "@/api/hostel/layer";
import { listAccessControl } from "@/api/hostel/accessControl";
import { listDormitory } from "@/api/hostel/dormitory";

export default {
  name: "Layer",
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
      // 宿舍楼层档案表格数据
      layerList: [],
      // 门禁设备所有数据
      accessControlListAll: [],
      // 楼所有数据
      dormitoryListAll: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        dormitoryId: null,
        layerNumber: null,
        roomNumber: null,
        accessControlId: null,
        createCode: null,
        createName: null,
        updateCode: null,
        updateName: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        dormitoryId: [
          { required: true, message: "宿舍楼不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
    this.getAccessControlListAll();
    this.getDormitoryListAll();
  },
  methods: {
    /** 查询宿舍楼层档案列表 */
    getList() {
      this.loading = true;
      listLayer(this.queryParams).then(response => {
        this.layerList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
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
        dormitoryId: null,
        layerNumber: null,
        roomNumber: null,
        accessControlId: null,
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
      this.title = "添加宿舍楼层档案";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getLayer(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改宿舍楼层档案";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateLayer(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLayer(this.form).then(response => {
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
      this.$confirm('是否确认删除宿舍楼层档案编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delLayer(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有宿舍楼层档案数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportLayer(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    },
    /** 查询门禁设备列表 */
    getAccessControlListAll() {
      listAccessControl().then(response => {
        this.accessControlListAll = response.rows;
      });
    },
    /** 查询楼信息列表 */
    getDormitoryListAll() {
      listDormitory().then(response => {
        this.dormitoryListAll = response.rows;
      });
    },
  }
};
</script>
