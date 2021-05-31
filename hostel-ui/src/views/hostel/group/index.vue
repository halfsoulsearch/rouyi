<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="父级" prop="parentId">
        <el-input
          v-model="queryParams.parentId"
          placeholder="请输入父级"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="祖级列表" prop="ancestors">
        <el-input
          v-model="queryParams.ancestors"
          placeholder="请输入祖级列表"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类别名称" prop="typeName">
        <el-input
          v-model="queryParams.typeName"
          placeholder="请输入类别名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="显示顺序" prop="orderNum">
        <el-input
          v-model="queryParams.orderNum"
          placeholder="请输入显示顺序"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类型组别" prop="typeGroupNum">
        <el-input
          v-model="queryParams.typeGroupNum"
          placeholder="请输入类型组别"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类型组别名称" prop="typeGroupName">
        <el-input
          v-model="queryParams.typeGroupName"
          placeholder="请输入类型组别名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资产类别状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择资产类别状态" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
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
          v-hasPermi="['hostel:group:add']"
        >新增</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="groupList"
      row-key="baseTypeId"
      default-expand-all
      :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
    >
<!--      <el-table-column label="父级" prop="parentId" />-->
<!--      <el-table-column label="祖级列表" align="center" prop="ancestors" />-->
      <el-table-column label="类别名称" align="center" prop="typeName" />
      <el-table-column label="显示顺序" align="center" prop="orderNum" />
      <el-table-column label="类型组别" align="center" prop="typeGroupNum" />
      <el-table-column label="类型组别名称" align="center" prop="typeGroupName" />
      <el-table-column label="资产类别状态" align="center" prop="status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['hostel:group:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-plus"
            @click="handleAdd(scope.row)"
            v-hasPermi="['hostel:group:add']"
          >新增</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hostel:group:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 添加或修改类型组对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="父级" prop="parentId">
          <treeselect v-model="form.parentId" :options="groupOptions" :normalizer="normalizer" placeholder="请选择父级" />
        </el-form-item>
        <el-form-item label="类别名称" prop="typeName">
          <el-input v-model="form.typeName" placeholder="请输入类别名称" />
        </el-form-item>
        <el-form-item label="显示顺序" prop="orderNum">
          <el-input v-model="form.orderNum" placeholder="请输入显示顺序" />
        </el-form-item>
        <el-form-item label="类型组别" prop="typeGroupNum">
          <el-input v-model="form.typeGroupNum" placeholder="请输入类型组别" />
        </el-form-item>
        <el-form-item label="类型组别名称" prop="typeGroupName">
          <el-input v-model="form.typeGroupName" placeholder="请输入类型组别名称" />
        </el-form-item>
        <el-form-item label="资产类别状态">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入删除标志" />
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
import { listGroup, getGroup, delGroup, addGroup, updateGroup, exportGroup } from "@/api/hostel/group";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
  name: "Group",
  components: {
    Treeselect
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 类型组表格数据
      groupList: [],
      // 类型组树选项
      groupOptions: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        parentId: null,
        ancestors: null,
        typeName: null,
        orderNum: null,
        typeGroupNum: null,
        typeGroupName: null,
        status: null,
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
  },
  methods: {
    /** 查询类型组列表 */
    getList() {
      this.loading = true;
      listGroup(this.queryParams).then(response => {
        this.groupList = this.handleTree(response.data, "baseTypeId", "parentId");
        this.loading = false;
      });
    },
    /** 转换类型组数据结构 */
    normalizer(node) {
      if (node.children && !node.children.length) {
        delete node.children;
      }
      return {
        id: node.baseTypeId,
        label: node.typeName,
        children: node.children
      };
    },
	/** 查询类型组下拉树结构 */
    getTreeselect() {
      listGroup().then(response => {
        this.groupOptions = [];
        const data = { baseTypeId: 0, typeName: '顶级节点', children: [] };
        data.children = this.handleTree(response.data, "baseTypeId", "parentId");
        this.groupOptions.push(data);
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
        baseTypeId: null,
        parentId: null,
        ancestors: null,
        typeName: null,
        orderNum: null,
        typeGroupNum: null,
        typeGroupName: null,
        status: "0",
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleAdd(row) {
      this.reset();
      this.getTreeselect();
      if (row != null && row.baseTypeId) {
        this.form.parentId = row.baseTypeId;
      } else {
        this.form.parentId = 0;
      }
      this.open = true;
      this.title = "添加类型组";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getTreeselect();
      if (row != null) {
        this.form.parentId = row.baseTypeId;
      }
      getGroup(row.baseTypeId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改类型组";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.baseTypeId != null) {
            updateGroup(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addGroup(this.form).then(response => {
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
      this.$confirm('是否确认删除类型组编号为"' + row.baseTypeId + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delGroup(row.baseTypeId);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    }
  }
};
</script>
