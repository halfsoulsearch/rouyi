<template>
  <div>
    <div class="container">
      <template>
        <el-card class="box-card" v-if="loaded" body-style="padding:3px">
          <div slot="header" class="clearfix">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item><i class="el-icon-s-platform">西区炼铁日报表</i></el-breadcrumb-item>
              <el-breadcrumb-item>查看</el-breadcrumb-item>
            </el-breadcrumb>

            <div class="header-btn">
              <span>选择时间：</span>
              <el-date-picker
                v-model="queryParams.date"
                type="date"
                placeholder="选择日期" style="width: 140px;margin-right: 10px"
                value-format="yyyy-MM-dd"
              >
              </el-date-picker>
              <el-button
                type="primary"
                size="c"
                @click="handleQuery"
                icon="el-icon-search">搜索
              </el-button>
              <el-button
                type="primary"
                size="medium"
                @click="handleRefresh"
                icon="el-icon-refresh">刷新
              </el-button>
              <el-button
                icon="el-icon-download"
                size="medium"
                type="primary"
                @click="handleExport"
                v-hasPermi="['report:shift:export']"
              >导出
              </el-button>
              <el-button type="default" plain icon="el-icon-back" size="medium" @click="handleBack">返回</el-button>
            </div>
          </div>
          <!--   产量start   -->
          <el-row :gutter="10">
            <el-col :span="24">
              <el-card shadow="hover" class="my-card" body-style="padding:1px">
                <div slot="header" class="clearfix">
                  <i class="el-icon-s-data"></i>
                  <span>高炉产量(单位:吨)</span>
                </div>
                <div class="text item">
                  <template>
                    <el-table
                      :data="westIronDayReport.subTable1"
                      style="width: 100%">
                      <el-table-column
                        prop="name"
                        align="center"
                        label="脱硫白灰消耗(吨)">
                        <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                        <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                      </el-table-column>
                    </el-table>
                  </template>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-card>
      </template>
    </div>
  </div>

</template>

<script>
import {parseTime} from "@/utils/ruoyi";
import {getAnalysisData} from "@/api/report/assembleData";

export default {
  name: "west_iron",
  data() {
    return {
      // 遮罩层
      loading: true,
      loaded: true,
      // 查询参数
      queryParams: {
        mainTableId: 3,
        subTableId: 1,
        date: parseTime(new Date(), '{y}-{m}-{d}'),
      },
      form: {
        user: {
          personId: '455',
          personName: 'llt',
          personJobNo: 'IC20040010',
        },
        shift: 1,
      },
      //西区炼铁日报表
      westIronDayReport: {
        subTable1: [],
        subTable2: [],
        subTable3: [],
        subTable4: [],
        subTable5: [],
        subTable6: [],
        subTable7: [],
        subTable8: []
      },
    }
  },
  mounted() {
    this.loadDayReport();
  },
  methods:{
    //返回上一层
    handleBack() {
      this.$router.go(-1);
    },
    //搜索
    handleQuery() {
      console.log(this.queryParams.date)
      this.loadDayReport();
    },
    handleRefresh(){
      this.loadDayReport();
    },
    loadDayReport() {
      for (let i = 13; i <= 19; i++) {
        this.loading = true;
        this.queryParams.subTableId=i;
        getAnalysisData(this.queryParams).then(response => {
          switch (i){
            case 13:
              this.westIronDayReport.subTable1 = response.data
              break;
            case 14:
              this.westIronDayReport.subTable2 = response.data
              break;
            case 15:
              this.westIronDayReport.subTable3 = response.data
              break;
            case 16:
              this.westIronDayReport.subTable4 = response.data
              break;
            case 17:
              this.westIronDayReport.subTable5 = response.data
              break;
            case 18:
              this.westIronDayReport.subTable6 = response.data
              break;
            case 19:
              this.westIronDayReport.subTable7 = response.data
              break;
          }
        });
      }
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有班次数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function () {
        //return exportShift(queryParams);
      }).then(response => {
        this.download(response.msg);
      })
    }
  }
}
</script>

<style scoped>

</style>
