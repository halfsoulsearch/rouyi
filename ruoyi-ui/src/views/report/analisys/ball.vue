<template>
  <div class="container">
    <template>
      <el-card class="box-card" v-if="loaded" body-style="padding:3px">
        <div slot="header" class="clearfix">
          <span><i class="el-icon-s-platform">球团厂日报表</i></span>
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
              size="medium"
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
          <el-col :span="24">
            <el-card shadow="hover" class="my-card" body-style="padding:1px">
              <div slot="header" class="clearfix">
                <i class="el-icon-s-data"></i>
                <span>基础数据(单位:吨)</span>
              </div>
              <div class="text item">
                <template>
                  <el-table
                    :data="ballDayReport.subTable1"
                    style="width: 100%">
                    <el-table-column
                      label="项目"
                      align="center"
                      width="180">
                      <el-table-column align="center" label="班次" prop="colName"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="生产量"
                      width="180">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="配料量"
                      width="180">
                      <el-table-column align="center" label="当日" prop="colData[1].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[1].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="作业率（%）"
                      width="180">
                      <el-table-column align="center" label="当日" prop="colData[2].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[2].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="自返粉（t）"
                      width="180">
                      <el-table-column align="center" label="当日" prop="colData[3].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[3].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="Tfe合格率（%）"
                      width="180">
                      <el-table-column align="center" label="当日" prop="colData[4].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[4].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="FeO合格率（%）"
                      width="180">
                      <el-table-column align="center" label="当日" prop="colData[5].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[5].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="抗压强度%"
                      width="180">
                      <el-table-column align="center" label="当日" prop="colData[6].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[6].totalValue"/>
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
                <i class="el-icon-s-order"></i>
                <span>原料消耗(单位:吨)</span>
              </div>
              <div class="text item">
                <template>
                  <el-table
                    :cell-style="{'text-align':'center'}"
                    :data="ballDayReport.subTable2"
                    style="width: 100%">
                    <el-table-column
                      label="项目"
                      align="center"
                      width="180">
                      <el-table-column align="center" label="班次" prop="colName"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="代县粉"
                      width="180">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="0.25硫乌克兰精粉"
                      width="180">
                      <el-table-column align="center" label="当日" prop="colData[1].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[1].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="0.04硫乌克兰精粉"
                      width="180">
                      <el-table-column align="center" label="当日" prop="colData[2].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[2].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="膨润土"
                      width="180">
                      <el-table-column align="center" label="当日" prop="colData[3].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[3].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="除尘灰"
                      width="180">
                      <el-table-column align="center" label="当日" prop="colData[4].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[4].totalValue"/>
                    </el-table-column>
                  </el-table>
                </template>
              </div>
            </el-card>
          </el-col>
        </el-row>
        <!--  大宗原料进出存   -->
        <el-row :gutter="10">
          <el-col :span="12">
            <el-card shadow="hover" class="my-card mt5" body-style="padding:1px">
              <div slot="header" class="clearfix">
                <i class="el-icon-s-help"></i>
                <span>球团矿成份（%）</span>
              </div>
              <div class="text item">
                <template>
                  <el-table
                    :cell-style="{'text-align':'center'}"
                    :data="ballDayReport.subTable3"
                    style="width: 100%">
                    <el-table-column align="center" label="班次" prop="colName"/>
                    <el-table-column align="center" label="TFe" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="SiO2" prop="colData[1].dailyValue"/>
                    <el-table-column align="center" label="CaO" prop="colData[2].dailyValue"/>
                    <el-table-column align="center" label="MgO" prop="colData[3].dailyValue"/>
                    <el-table-column align="center" label="FeO" prop="colData[4].dailyValue"/>
                    <el-table-column align="center" label="S" prop="colData[5].dailyValue"/>
                    <el-table-column align="center" label="R2" prop="colData[6].dailyValue"/>
                  </el-table>
                </template>
              </div>
            </el-card>
          </el-col>
          <el-col :span="12">
            <el-card shadow="hover" class="my-card mt5" body-style="padding:1px;height:220px">
              <div slot="header" class="clearfix">
                <i class="el-icon-s-flag"></i>
                <span>大宗原料进出存(单位:吨)</span>
              </div>
              <div class="text item">
                <template>
                  <el-table
                    :cell-style="{'text-align':'center'}"
                    :data="ballDayReport.subTable4"
                    style="width: 100%">
                    <el-table-column align="center" label="项目" prop="colName"/>
                    <el-table-column align="center" label="代县粉" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="0.25硫乌克兰精粉" prop="colData[1].dailyValue"/>
                    <el-table-column align="center" label="0.04硫乌克兰精粉" prop="colData[2].dailyValue"/>
                    <el-table-column align="center" label="膨润土" prop="colData[3].dailyValue"/>
                    <el-table-column align="center" label="除尘灰" prop="colData[4].dailyValue"/>
                  </el-table>
                </template>
              </div>
            </el-card>
          </el-col>
        </el-row>
        <!--  生产记事  -->
        <el-row :gutter="10">
          <el-col :span="24">
            <el-card shadow="hover" class="my-card mt5" body-style="padding:1px;">
              <div slot="header" class="clearfix">
                <i class="el-icon-question"></i>
                <span>生产记事</span>
              </div>
              <div cass="text item">
                <el-alert
                  :title="ballDayReport.subTable5[0].colData[0].text"
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
import {getData, preCreate, getAnalysisData} from "@/api/report/assembleData";
import {parseTime} from "@/utils/ruoyi";

export default {
  name: "ball",
  data() {
    return {
      // 遮罩层
      loading: true,
      loaded: true,
      // 查询参数
      queryParams: {
        mainTableId: 1,
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
      //球团日报表
      ballDayReport: {
        subTable1: [],
        subTable2: [],
        subTable3: [],
        subTable4: [],
        subTable5: []
      },
    }
  },
  created() {
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
      for (let i = 1; i <= 5; i++) {
        this.loading = true;
        this.queryParams.subTableId=i;
        getAnalysisData(this.queryParams).then(response => {
          switch (i){
            case 1:
              this.ballDayReport.subTable1 = response.data
              this.loading = false;
              break;
            case 2:
              this.ballDayReport.subTable2 = response.data
              this.loading = false;
              break;
            case 3:
              this.ballDayReport.subTable3 = response.data
              this.loading = false;
              break;
            case 4:
              this.ballDayReport.subTable4 = response.data
              this.loading = false;
              break;
            case 5:
              this.ballDayReport.subTable5 = response.data
              this.loading = false;
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
