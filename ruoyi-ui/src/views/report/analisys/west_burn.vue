<template>
  <div class="container">
    <template>
      <el-card class="box-card" v-if="loaded" body-style="padding:3px">
        <div slot="header" class="clearfix">
          <span><i class="el-icon-s-platform">西区烧结</i></span>
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
          <el-col :span="10">
            <el-card shadow="hover" class="my-card" body-style="padding:1px">
              <div slot="header" class="clearfix">
                <i class="el-icon-s-data"></i>
                <span>烧结矿产量(单位:吨)</span>
              </div>
              <div class="text item">
                <template>
                  <el-table
                    :data="westBurnDayReport.subTable1"
                    style="width: 100%">
                    <el-table-column
                      align="center"
                      width="99"
                      label="项目">
                      <el-table-column align="center" label="班次" prop="colName" width="99"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="产量">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].dailyValue"/>
                    </el-table-column>
                  </el-table>
                </template>
              </div>
            </el-card>
          </el-col>
          <el-col :span="14">
            <el-card shadow="hover" class="my-card h312" body-style="padding:1px;">
              <div slot="header" class="clearfix">
                <i class="el-icon-s-data"></i>
                <span>烧结矿质量(化验成分%)</span>
              </div>
              <div class="text item">
                <template>
                  <el-table
                    :data="westBurnDayReport.subTable2"
                    prop="colName"
                    style="width: 100%">
                    <el-table-column
                      align="center"
                      width="99"
                      prop="colName"
                      label="班次">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="Tfe">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="SiO2">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="CaO">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="MgO">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="FeO">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="AL2O3">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="R">
                    </el-table-column>
                  </el-table>
                </template>
              </div>
            </el-card>
          </el-col>
        </el-row>
        <!--   脱硫脱销start   -->
        <el-row :gutter="10">
          <el-col :span="10">
            <el-card shadow="hover" class="my-card mt5" body-style="padding:1px">
              <div slot="header" class="clearfix">
                <i class="el-icon-s-data"></i>
                <span>烧结机能源消耗</span>
              </div>
              <div class="text item">
                <template>
                  <el-table
                    :data="westBurnDayReport.subTable6"
                    style="width: 100%">
                    <el-table-column
                      prop="name"
                      align="center"
                      label="煤气消耗(m³)">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="电力消耗(m³)">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="氮气消耗(m³)">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="新水消耗(m³)">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                  </el-table>
                </template>
              </div>
            </el-card>
          </el-col>
          <el-col :span="14">
            <el-card shadow="hover" class="my-card mt5 h280" body-style="padding:1px">
              <div slot="header" class="clearfix">
                <i class="el-icon-s-data"></i>
                <span>脱硫脱销</span>
              </div>
              <div class="text item">
                <template>
                  <el-table
                    :data="westBurnDayReport.subTable5"
                    style="width: 100%">
                    <el-table-column
                      prop="name"
                      align="center"
                      label="脱硫白灰消耗(吨)">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="氨水消耗(吨)">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="煤气消耗(m³)">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="工艺水消耗(m³)">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="氮气消耗(m³)">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="压缩空气消耗(m³)">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                    </el-table-column>
                  </el-table>
                </template>
              </div>
            </el-card>
          </el-col>
        </el-row>
        <!--   作业时间start   -->
        <el-row :gutter="10" class="mt5">
          <el-col :span="24">
            <el-card shadow="hover" class="my-card" body-style="padding:1px">
              <div slot="header" class="clearfix">
                <i class="el-icon-s-data"></i>
                <span>作业时间(单位:分)</span>
              </div>
              <div class="text item">
                <template>
                  <el-table
                    :data="westBurnDayReport.subTable1"
                    style="width: 100%">
                    <el-table-column
                      prop="name"
                      align="center"
                      label="3#">
                      <el-table-column align="center" label="作业时间(分)" prop="colData[0].dailyValue">
                        <el-table-column align="center" label="当日" prop="colData[0].totalValue"/>
                        <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                      </el-table-column>
                      <el-table-column align="center" label="作业率" prop="colData[0].totalValue">
                        <el-table-column align="center" label="当日" prop="colData[0].totalValue"/>
                        <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                      </el-table-column>
                      <el-table-column align="center" label="停机时间" prop="colData[0].totalValue">
                        <el-table-column align="center" label="当日" prop="colData[0].totalValue"/>
                        <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                      </el-table-column>
                      <el-table-column align="center" label="利用系数" prop="colData[0].totalValue">
                        <el-table-column align="center" label="当日" prop="colData[0].totalValue"/>
                        <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                      </el-table-column>
                      <el-table-column align="center" label="台时产量" prop="colData[0].totalValue">
                        <el-table-column align="center" label="当日" prop="colData[0].totalValue"/>
                        <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                      </el-table-column>

                    </el-table-column>
                    <el-table-column
                      prop="name"
                      align="center"
                      label="4#">
                      <el-table-column align="center" label="作业时间(分)" prop="colData[0].dailyValue">
                        <el-table-column align="center" label="当日" prop="colData[0].totalValue"/>
                        <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                      </el-table-column>
                      <el-table-column align="center" label="作业率" prop="colData[0].totalValue">
                        <el-table-column align="center" label="当日" prop="colData[0].totalValue"/>
                        <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                      </el-table-column>
                      <el-table-column align="center" label="停机时间" prop="colData[0].totalValue">
                        <el-table-column align="center" label="当日" prop="colData[0].totalValue"/>
                        <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                      </el-table-column>
                      <el-table-column align="center" label="利用系数" prop="colData[0].totalValue">
                        <el-table-column align="center" label="当日" prop="colData[0].totalValue"/>
                        <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                      </el-table-column>
                      <el-table-column align="center" label="台时产量" prop="colData[0].totalValue">
                        <el-table-column align="center" label="当日" prop="colData[0].totalValue"/>
                        <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                      </el-table-column>

                    </el-table-column>
                  </el-table>
                </template>
              </div>
            </el-card>
          </el-col>
        </el-row>
        <!--   原料消耗start   -->
        <el-row :gutter="10">
          <el-card shadow="hover" class="my-card mt5" body-style="padding:1px">
            <div slot="header" class="clearfix">
              <i class="el-icon-s-data"></i>
              <span>原料消耗(单位:吨)</span>
            </div>
            <div class="text item">
              <template>
                <el-table
                  :data="westBurnDayReport.subTable3"
                  style="width: 100%">
                  <el-table-column
                    prop="name"
                    align="center"
                    label="物料"
                    width="180"
                  >
                      <el-table-column align="center" label="班次" prop="colName"/>
                  </el-table-column>
                  <el-table-column
                    prop="name"
                    align="center"
                    label="金布巴"
                    width="180">
                    <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
                  <el-table-column
                    prop="name"
                    align="center"
                    label="纽曼粉"
                    width="180">
                    <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
                  <el-table-column
                    prop="name"
                    align="center"
                    label="铁精粉"
                    width="180">
                    <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
                  <el-table-column
                    prop="name"
                    align="center"
                    label="杨迪粉"
                    width="180">
                    <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
                  <el-table-column
                    prop="name"
                    align="center"
                    label="槽返"
                    width="180">
                    <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
                  <el-table-column
                  prop="name"
                  align="center"
                  label="轻烧镁粉"
                  width="180">
                  <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                  <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                </el-table-column>
                  <el-table-column
                      prop="name"
                      align="center"
                      label="生石灰粉"
                      width="180">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
                  <el-table-column
                    prop="name"
                    align="center"
                    label="巴西粉"
                    width="180">
                    <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
                  <el-table-column
                      prop="name"
                      align="center"
                      label="卡粉"
                      width="180">
                      <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                      <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
                </el-table>
                <el-table
                  :data="westBurnDayReport.subTable3"
                  style="width: 100%">
                  <el-table-column
                    prop="name"
                    align="center"
                    label="物料"
                    width="180"
                  >
                    <el-table-column align="center" label="班次" prop="colName"/>
                  </el-table-column>
                  <el-table-column
                    prop="name"
                    align="center"
                    label="麦克粉"
                    width="180">
                    <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
                  <el-table-column
                    prop="name"
                    align="center"
                    label="球团粉"
                    width="180">
                    <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
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
                    label="来村精粉">
                    <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
                  <el-table-column
                    prop="name"
                    align="center"
                    label="除尘灰">
                    <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
                  <el-table-column
                    prop="name"
                    align="center"
                    label="红泥">
                    <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
                  <el-table-column
                    prop="name"
                    align="center"
                    label="焦粉">
                    <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
                  <el-table-column
                    prop="name"
                    align="center"
                    label="煤粉">
                    <el-table-column align="center" label="当日" prop="colData[0].dailyValue"/>
                    <el-table-column align="center" label="累计" prop="colData[0].totalValue"/>
                  </el-table-column>
                </el-table>
              </template>
            </div>
          </el-card>
        </el-row>
        <!-- 大宗原料进口start   -->
        <el-row :gutter="10">
          <el-col :span="24">
            <el-card shadow="hover" class="my-card mt5" body-style="padding:1px">
              <div slot="header" class="clearfix">
                <i class="el-icon-s-data"></i>
                <span>大宗原料进出存(单位:吨)</span>
              </div>
              <div class="text item">
                <template>
                  <el-table
                    :data="westBurnDayReport.subTable4"
                    style="width: 100%">
                    <el-table-column
                      align="center"
                      prop="colName"
                      label="项目">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="金布巴">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="纽曼粉">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="铁精粉">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="轻烧白云石">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="槽下返粉">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="杨迪粉">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="卡粉">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="巴西粉">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="麦克粉">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="焦粉">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="煤粉">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="球粉">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="来存精粉">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="除尘灰">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="球粉">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="合计">
                    </el-table-column>
                    <el-table-column
                      align="center"
                      prop="colData[0].dailyValue"
                      label="烧结矿库存">
                    </el-table-column>
                  </el-table>
                </template>
              </div>
            </el-card>
          </el-col>
        </el-row>
        <!-- 生产记事start   -->
        <el-row :gutter="10" class="mt5">
          <el-col :span="12">
            <el-card shadow="hover" class="my-card mt5" body-style="padding:1px;">
              <div slot="header" class="clearfix">
                <i class="el-icon-question"></i>
                <span>3#生产记事</span>
              </div>
              <div cass="text item" v-for="t in westBurnDayReport.subTable7">
                <el-alert
                  v-text="t.colData[0].text"
                  type="info"
                  show-icon>
                </el-alert>
              </div>
            </el-card>
          </el-col>
          <el-col :span="12">
            <el-card shadow="hover" class="my-card mt5" body-style="padding:1px;">
              <div slot="header" class="clearfix">
                <i class="el-icon-question"></i>
                <span>4#生产记事</span>
              </div>
              <div cass="text item" v-for="t in westBurnDayReport.subTable7">
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
  name: "west_burn",
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
      //西区烧结日报表
      westBurnDayReport: {
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
              this.westBurnDayReport.subTable1 = response.data
              break;
            case 14:
              this.westBurnDayReport.subTable2 = response.data
              break;
            case 15:
              this.westBurnDayReport.subTable3 = response.data
              break;
            case 16:
              this.westBurnDayReport.subTable4 = response.data
              break;
            case 17:
              this.westBurnDayReport.subTable5 = response.data
              break;
            case 18:
              this.westBurnDayReport.subTable6 = response.data
              break;
            case 19:
              this.westBurnDayReport.subTable7 = response.data
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
.h312{
  height: 312px;
}
.h280{
  height: 280px;
}
</style>
