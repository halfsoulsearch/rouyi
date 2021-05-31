<template>
  <div class="app-container">
    <el-card class="box-card" body-style="padding:10px;">
      <div class="header-btn" style="float: right;">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['report:shift:add']"
        >新增</el-button>
        <el-button
          type="primary"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['report:shift:edit']"
        >修改</el-button>
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['report:shift:remove']"
        >删除</el-button>
        <el-button
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['report:shift:export']"
        >导出</el-button>

        <right-toolbar :showSearch.sync="showSearch" @queryTable="getList" class="ml10"></right-toolbar>
      </div>
      <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
        <el-form-item label="日期">
          <el-date-picker
            v-model="dateRange"
            size="small"
            style="width: 240px"
            value-format="yyyy-MM-dd"
            type="daterange"
            range-separator="-"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
          ></el-date-picker>
        </el-form-item>
        <el-form-item label="报表类型" prop="status">
          <el-select
            v-model="queryParams.mainTableId"
            placeholder="请选择报表"
            clearable
            size="small"
            style="width: 240px">
            <el-option
              v-for="dict in mtableList"
              :key="dict.id"
              :label="dict.name"
              :value="dict.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
          <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
        </el-form-item>
      </el-form>
    </el-card>

    <el-table v-loading="loading" :data="dayReportList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="主表编号" align="center" prop="mainTableId" />
      <el-table-column label="日期" align="center" prop="date" />
      <el-table-column label="表类型" align="center" prop="tableName" />
      <el-table-column label="录入人" align="center" prop="createBy" />
      <el-table-column label="录入时间" align="center" prop="createTime" />
      <el-table-column label="更新时间" align="center" prop="updateTime" />
      <el-table-column label="状态" align="center" prop="status" >
        <template slot-scope="scope">
          <el-tag type="success" v-if="dayReportList[scope.$index].status==0">提交</el-tag>
          <el-tag type="danger" v-if="dayReportList[scope.$index].status==1">审核</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-search"
            @click="handleLook(scope.row)"
            v-hasPermi="['report:shift:edit']"
          >查看</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['report:shift:look']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['report:shift:remove']"
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

    <!-- 添加或修改报表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" label-width="120px">
        <el-form-item label="选择单位">
          <el-radio-group v-model="form.selReportUrl">
            <div>
            <el-radio :label="selReport.url +'/?mainTableId=' + selReport.id" v-for="selReport in mtableList" :key="selReport.id" class="radio-list">
              {{selReport.name}}
            </el-radio>
            </div>
          </el-radio-group>
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
import { listDayReport} from "@/api/report/dayreport";
import { listMtable} from "@/api/report/mtable";

export default {
  name: "dayreport",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedConfigMainTable: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 班次表格数据
      dayReportList: [],
      // 主报表的配置表格数据
      mtableList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 日期范围
      dateRange: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        tableName: null
      },
      // 表单参数
      form: {
        selReportUrl:''
      },
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
    listMtable().then(response=>{
      this.mtableList = response.rows
    });
  },
  methods: {
    /** 查询日报表列表 */
    getList() {
      this.loading = true;
      listDayReport(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        this.dayReportList = response.rows;
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
        mainTableId: null,
        name: null
      };
      this.configMainTableList = [];
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
      this.title = "选择";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      this.$router.push({path:"/report/"+row.url,query:{tid:id,op:'edit'}})
    },
    handleLook(row){
      const id = row.id || this.ids
      this.$router.push({path:"/report/"+row.url,query:{tid:id,op:'look'}})
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.$router.push({path:"/report/"+this.form.selReportUrl})
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除班次编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delShift(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
	/** 主的配置序号 */
    rowConfigMainTableIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 主的配置添加按钮操作 */
    handleAddConfigMainTable() {
      let obj = {};
      obj.name = "";
      this.configMainTableList.push(obj);
    },
    /** 主的配置删除按钮操作 */
    handleDeleteConfigMainTable() {
      if (this.checkedConfigMainTable.length == 0) {
        this.$alert("请先选择要删除的主的配置数据", "提示", { confirmButtonText: "确定", });
      } else {
        this.configMainTableList.splice(this.checkedConfigMainTable[0].index - 1, 1);
      }
    },
    /** 单选框选中数据 */
    handleConfigMainTableSelectionChange(selection) {
      if (selection.length > 1) {
        this.$refs.configMainTable.clearSelection();
        this.$refs.configMainTable.toggleRowSelection(selection.pop());
      } else {
        this.checkedConfigMainTable = selection;
      }
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有班次数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportShift(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
<style scoped>
  .ml10{margin-left: 10px}
  .header-btn{margin-top: 5px}
  .radio-list{
    padding: 10px;width: 120px
  }
</style>
