<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="资产编号" prop="assetsCode">
        <el-input
          v-model="queryParams.assetsCode"
          placeholder="请输入资产编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资产名称" prop="assetsName">
        <el-input
          v-model="queryParams.assetsName"
          placeholder="请输入资产名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资产条码" prop="assetsBarCode">
        <el-input
          v-model="queryParams.assetsBarCode"
          placeholder="请输入资产条码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资产品牌" prop="assetsBrand">
        <el-input
          v-model="queryParams.assetsBrand"
          placeholder="请输入资产品牌"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资产型号" prop="assetsModel">
        <el-input
          v-model="queryParams.assetsModel"
          placeholder="请输入资产型号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="采购日期" prop="purchaseDate">
        <el-date-picker clearable size="small"
          v-model="queryParams.purchaseDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择采购日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="单价" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入单价"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="创建人编号" prop="createCode">-->
<!--        <el-input-->
<!--          v-model="queryParams.createCode"-->
<!--          placeholder="请输入创建人编号"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="创建人姓名" prop="createName">-->
<!--        <el-input-->
<!--          v-model="queryParams.createName"-->
<!--          placeholder="请输入创建人姓名"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="修改人编号" prop="updateCode">-->
<!--        <el-input-->
<!--          v-model="queryParams.updateCode"-->
<!--          placeholder="请输入修改人编号"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="修改人名称" prop="updateName">-->
<!--        <el-input-->
<!--          v-model="queryParams.updateName"-->
<!--          placeholder="请输入修改人名称"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="是否删除 0未删除1删除" prop="isDeleted">-->
<!--        <el-input-->
<!--          v-model="queryParams.isDeleted"-->
<!--          placeholder="请输入是否删除 0未删除1删除"-->
<!--          clearable-->
<!--          size="small"-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
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
          v-hasPermi="['hostel:assets:add']"
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
          v-hasPermi="['hostel:assets:edit']"
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
          v-hasPermi="['hostel:assets:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hostel:assets:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="assetsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="id" align="center" prop="id" />-->
      <el-table-column label="资产编号" align="center" prop="assetsCode" />
      <el-table-column label="资产名称" align="center" prop="assetsName" />
      <el-table-column label="资产条码" align="center" prop="assetsBarCode" />
      <el-table-column label="资产品牌" align="center" prop="assetsBrand" />
      <el-table-column label="资产型号" align="center" prop="assetsModel" />
      <el-table-column label="采购日期" align="center" prop="purchaseDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.purchaseDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="单价" align="center" prop="price" />
<!--      <el-table-column label="创建人编号" align="center" prop="createCode" />-->
<!--      <el-table-column label="创建人姓名" align="center" prop="createName" />-->
<!--      <el-table-column label="修改人编号" align="center" prop="updateCode" />-->
<!--      <el-table-column label="修改人名称" align="center" prop="updateName" />-->
<!--      <el-table-column label="是否删除 0未删除1删除" align="center" prop="isDeleted" />-->
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改资产档案对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="资产编号" prop="assetsCode">
          <el-input v-model="form.assetsCode" placeholder="请输入资产编号" />
        </el-form-item>
        <el-form-item label="资产名称" prop="assetsName">
          <el-input v-model="form.assetsName" placeholder="请输入资产名称 枚举类型" />
        </el-form-item>
        <el-form-item label="资产条码" prop="assetsBarCode">
          <el-input v-model="form.assetsBarCode" placeholder="请输入资产条码" />
        </el-form-item>
        <el-form-item label="资产品牌" prop="assetsBrand">
          <el-input v-model="form.assetsBrand" placeholder="请输入资产品牌" />
        </el-form-item>
        <el-form-item label="资产型号" prop="assetsModel">
          <el-input v-model="form.assetsModel" placeholder="请输入资产型号 枚举类型" />
        </el-form-item>
        <el-form-item label="采购日期" prop="purchaseDate">
          <el-date-picker clearable size="small"
            v-model="form.purchaseDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择采购日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="单价" prop="price">
          <el-input v-model="form.price" placeholder="请输入价格 单价" />
        </el-form-item>
<!--        <el-form-item label="创建人编号" prop="createCode">-->
<!--          <el-input v-model="form.createCode" placeholder="请输入创建人编号" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="创建人姓名" prop="createName">-->
<!--          <el-input v-model="form.createName" placeholder="请输入创建人姓名" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="修改人编号" prop="updateCode">-->
<!--          <el-input v-model="form.updateCode" placeholder="请输入修改人编号" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="修改人名称" prop="updateName">-->
<!--          <el-input v-model="form.updateName" placeholder="请输入修改人名称" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="是否删除 0未删除1删除" prop="isDeleted">-->
<!--          <el-input v-model="form.isDeleted" placeholder="请输入是否删除 0未删除1删除" />-->
<!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listAssets, getAssets, delAssets, addAssets, updateAssets, exportAssets } from "@/api/hostel/assets";

export default {
  name: "Assets",
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
      // 资产档案表格数据
      assetsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        assetsCode: null,
        assetsName: null,
        assetsBarCode: null,
        assetsBrand: null,
        assetsModel: null,
        purchaseDate: null,
        price: null,
        createCode: null,
        createName: null,
        updateCode: null,
        updateName: null,
        isDeleted: null
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
    /** 查询资产档案列表 */
    getList() {
      this.loading = true;
      listAssets(this.queryParams).then(response => {
        this.assetsList = response.rows;
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
        assetsCode: null,
        assetsName: null,
        assetsBarCode: null,
        assetsBrand: null,
        assetsModel: null,
        purchaseDate: null,
        price: null,
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
      this.title = "添加资产档案";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAssets(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改资产档案";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAssets(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAssets(this.form).then(response => {
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
      this.$confirm('是否确认删除资产档案编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delAssets(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有资产档案数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportAssets(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
