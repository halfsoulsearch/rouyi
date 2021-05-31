<template>
  <div class="container">
    <template>
      <el-card class="box-card" v-if="loaded" body-style="padding:3px">
        <div slot="header" class="clearfix">
          <span><i class="el-icon-s-platform">白灰日报表</i></span>
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
        <el-row :gutter="10">
          <el-col :span="12">
            <el-row>
              <el-card shadow="hover" class="my-card" body-style="padding:1px">
                <div slot="header" class="clearfix">
                  <i class="el-icon-s-data"></i>
                  <span>产量数据(单位:吨)</span>
                </div>
                <div class="text item">
                  <template>
                    <el-table
                      :data="limeDayReport.subTable1"
                      style="width: 100%">
                      <el-table-column
                        prop="name"
                        align="center"
                        label="块灰"
                        width="180">
                        <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                        <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                      </el-table-column>
                      <el-table-column
                        prop="name"
                        align="center"
                        label="灰粉"
                        width="180">
                        <el-table-column align="center" label="当日" prop="colData[1].dailyValue"/>
                        <el-table-column align="center" label="累计" prop="colData[1].totalValue"/>
                      </el-table-column>
                      <el-table-column
                        prop="name"
                        align="center"
                        label="轻烧白云石块"
                        width="180">
                        <el-table-column align="center" label="当日" prop="colData[2].dailyValue"/>
                        <el-table-column align="center" label="累计" prop="colData[2].totalValue"/>
                      </el-table-column>
                      <el-table-column
                        prop="name"
                        align="center"
                        label="轻烧白云石粉"
                        width="180">
                        <el-table-column align="center" label="当日" prop="colData[3].dailyValue"/>
                        <el-table-column align="center" label="累计" prop="colData[3].totalValue"/>
                      </el-table-column>
                    </el-table>
                  </template>
                </div>
              </el-card>
            </el-row>
            <el-row>
              <el-card shadow="hover" class="my-card mt5" body-style="padding:1px">
                <div slot="header" class="clearfix">
                  <i class="el-icon-s-data"></i>
                  <span>大宗原料进出存(单位:吨)</span>
                </div>
                <div class="text item">
                  <template>
                    <el-table
                      :data="limeDayReport.subTable5"
                      style="width: 100%;">
                      <el-table-column
                        label=" 石灰石 "
                        align="center">
                        <el-table-column align="center" label="当日进厂" prop="colData[0].dailyValue"/>
                        <el-table-column align="center" label="累计进厂" prop="colData[0].totalValue"/>
                      </el-table-column>
                      <el-table-column
                        label="白云石"
                        align="center">
                        <el-table-column align="center" label="当日进厂" prop="colData[1].dailyValue"/>
                        <el-table-column align="center" label="累计进厂" prop="colData[1].totalValue"/>
                      </el-table-column>
                    </el-table>
                  </template>
                </div>
              </el-card>
            </el-row>
            <el-row class="mt5">
              <el-card shadow="hover" class="my-card" body-style="padding:1px">
                <div slot="header" class="clearfix">
                  <i class="el-icon-s-data"></i>
                  <span>返粉(单位:吨)</span>
                </div>
                <div class="text item">
                  <template>
                    <el-table
                      :data="limeDayReport.subTable6"
                      style="width: 100%">
                      <el-table-column
                        prop="name"
                        align="center"
                        label="块灰"
                        width="180">
                        <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                        <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                      </el-table-column>
                      <el-table-column
                        prop="name"
                        align="center"
                        label="轻烧白云石"
                        width="180">
                        <el-table-column align="center" label="当日" prop="colData[1].dailyValue"/>
                        <el-table-column align="center" label="累计" prop="colData[1].totalValue"/>
                      </el-table-column>
                    </el-table>

                  </template>
                </div>
              </el-card>
            </el-row>
          </el-col>
          <el-col :span="12">
            <el-card shadow="hover" class="my-card" body-style="padding:1px; height:503px">
              <div slot="header" class="clearfix">
                <i class="el-icon-s-data"></i>
                <span>生产时间(单位:分钟)</span>
              </div>
              <div class="text item">
                <template>
                  <el-table
                    :data="limeDayReport.subTable4"
                    style="width: 100%">
                    <el-table-column
                      label="时间"
                      align="center">
                      <el-table-column align="center" label="炉号" prop="colName"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="生产时间"
                      width="100">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="外部停机时间"
                      width="100">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="内部停机时间"
                      width="100">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="作业率"
                      width="100">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                  </el-table>
                </template>
              </div>
            </el-card>
          </el-col>
        </el-row>
        <el-row :gutter="10">
          <el-col :span="24">
            <el-card shadow="hover" class="my-card mt5" body-style="padding:1px">
              <div slot="header" class="clearfix">
                <i class="el-icon-s-data"></i>
                <span>质量(单位:百分比)</span>
              </div>
              <div class="text item">
                <template>
                  <el-table
                    :data="limeDayReport.subTable2"
                    style="width: 100%;">
                    <el-table-column
                      label="指标"
                      align="center">
                      <el-table-column align="center" label="物料" prop="colName"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="CaO">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="月均" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="MgO">
                      <el-table-column align="center" label="当日" prop="colData[1].dailyValue"/>
                      <el-table-column align="center" label="月均" prop="colData[1].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="SiO2">
                      <el-table-column align="center" label="当日" prop="colData[2].dailyValue"/>
                      <el-table-column align="center" label="月均" prop="colData[2].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="活性度">
                      <el-table-column align="center" label="当日" prop="colData[3].dailyValue"/>
                      <el-table-column align="center" label="月均" prop="colData[3].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="生过烧率">
                      <el-table-column align="center" label="当日" prop="colData[4].dailyValue"/>
                      <el-table-column align="center" label="月均" prop="colData[4].totalValue"/>
                    </el-table-column>
                  </el-table>
                </template>
              </div>
            </el-card>
          </el-col>

        </el-row>
        <el-row :gutter="10" class="mt5">
          <el-col :span="24">
            <el-card shadow="hover" class="my-card" body-style="padding:1px">
              <div slot="header" class="clearfix">
                <i class="el-icon-s-data"></i>
                <span>原燃动力消耗</span>
              </div>
              <div class="text item">
                <template>
                  <el-table
                    :data="limeDayReport.subTable3"
                    style="width: 100%;">
                    <el-table-column
                      label="物料"
                      prop="colName"
                      align="center">
                      <el-table-column align="center" label="物料" prop="colName"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="煤气（m³）">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="电（KW·H）">
                      <el-table-column align="center" label="当日" prop="colData[1].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[1].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="水（m³）">
                      <el-table-column align="center" label="当日" prop="colData[2].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[2].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="氮气（m³）">
                      <el-table-column align="center" label="当日" prop="colData[3].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[3].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="白云石子（T）">
                      <el-table-column align="center" label="当日" prop="colData[4].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[4].totalValue"/>
                    </el-table-column>
                  </el-table>
                </template>
              </div>
            </el-card>
          </el-col>
        </el-row>
        <!--  生产记事  -->
        <el-row :gutter="10" class="mt5">
          <el-col :span="24">
            <el-card shadow="hover" class="my-card mt5" body-style="padding:1px;">
              <div slot="header" class="clearfix">
                <i class="el-icon-question"></i>
                <span>生产记事</span>
              </div>
              <div cass="text item" v-for="t in limeDayReport.subTable7">
                <el-alert
                  v-text="t.colData[0].text"
                  type="info"
                  show-icon>
                </el-alert>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </el-card>

    </template>
  </div>
</template>

<script>
import {parseTime} from "@/utils/ruoyi";
import {getAnalysisData} from "@/api/report/assembleData";

export default {
  name: "lime",
  data() {
    return {
      // 遮罩层
      loading: true,
      loaded: true,
      // 查询参数
      queryParams: {
        mainTableId: 2,
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
      //白灰日报表
      limeDayReport: {
        subTable1: [],
        subTable2: [],
        subTable3: [],
        subTable4: [],
        subTable5: [],
        subTable6: [],
        subTable7: []
      },
    }
  },
  mounted() {
    this.loadDayReport();
  },
  methods: {
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
      for (let i = 6; i <= 12; i++) {
        this.loading = true;
        this.queryParams.subTableId=i;
        getAnalysisData(this.queryParams).then(response => {
          switch (i){
            case 6:
              this.limeDayReport.subTable1 = response.data
              break;
            case 7:
              this.limeDayReport.subTable2 = response.data
              break;
            case 8:
              this.limeDayReport.subTable3 = response.data
              break;
            case 9:
              this.limeDayReport.subTable4 = response.data
              break;
            case 10:
              this.limeDayReport.subTable5 = response.data
              break;
            case 11:
              this.limeDayReport.subTable6 = response.data
              break;
            case 12:
              this.limeDayReport.subTable7 = response.data
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
