<template>
  <div>
    <div class="container" v-if="loaded">
      <template>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span><i class="el-icon-s-platform"></i>发电厂日报表</span>
            <div class="header-btn">
              <el-button type="primary" icon="el-icon-finished" size="small" @click="onSubmit">提交</el-button>
              <el-button type="danger" plain icon="el-icon-document-checked" size="small">审核</el-button>
              <el-button type="default" plain icon="el-icon-back" size="small" @click="handleBack">返回</el-button>

            </div>
          </div>

          <el-form ref="form" :model="form" label-width="100px">
            <el-card shadow="hover" style="height: 75px;margin-bottom: 5px">
              <el-row :gutter="20">
                <el-col :span="4">
                  <el-form-item label="选择日期：">
                    <el-date-picker
                      v-model="form.operatorDate"
                      type="date"
                      placeholder="选择日期" style="width: 140px"
                      @change="dateChange"
                      value-format="yyyy-MM-dd"
                      :disabled="dateDisabled"
                    >
                    </el-date-picker>
                  </el-form-item>
                </el-col>
                <el-col :span="5">
                  <el-form-item label="录入人姓名：" label-width="155px">
                    <el-input v-model="form.user.personName" class="w130" prefix-icon="el-icon-user" disabled></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="5">
                  <el-form-item label="企业工号：">
                    <el-input v-model="form.user.personJobNo" class="w130" prefix-icon="el-icon-link" disabled></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="2">
                  <el-form-item label="报表状态：">
                    <el-tag type="warning">编辑</el-tag>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-card>
            <el-row :gutter="10">
              <el-col :span="24">
                <el-card shadow="hover" class="card-table h260">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-marketing"></i>
                    <span>综合指标</span>
                    <el-button style="float: right; padding: 8px 10px" plain type="info" @click="addRow"
                               icon="el-icon-plus">添加行
                    </el-button>
                  </div>
                  <div class="text item">
                    <el-row>
                      <el-col :span="24">
                        <el-table
                          :header-cell-style="{
                                                                'background-color': '#fafafa',
                                                                'color': 'rgb(112,114,115)',
                                                                'border-bottom': '1px rgb(112,114,115) solid'
                                                            }"
                          :data="dynamicList"
                          stripe
                          style="width: 100%">
                          <el-table-column
                            align="center"
                            prop="projectId"
                            label="机组"
                            width="145">
                            <template slot-scope="scope">
                              <el-select v-model="scope.row.data1" placeholder="项目名称" :disabled="disabled"
                              >
                                <el-option
                                  v-for="item in machineList"
                                  :key="item.id"
                                  :label="item.name"
                                  :value="item.name">
                                </el-option>
                              </el-select>
                            </template>
                          </el-table-column>
                          <el-table-column
                            align="center"
                            prop="oxygenDayOutput"
                            label="发电量(万Kw.h)"
                            width="125">
                            <template slot-scope="scope">
                              <el-input v-model="scope.row.data2"
                                        oninput="value=value.replace(/[^0-9.]/g,'')"
                                        :disabled="disabled"
                                        utocomplete="off" size="small" placeholder="氧气日产量"/>
                            </template>
                          </el-table-column>
                          <el-table-column
                            align="center"
                            min-width="9%"
                            prop="oxygenDaySendOutput"
                            label="供电量(万Kw.h)">
                            <template slot-scope="scope">
                              <el-input v-model="scope.row.data3"
                                        oninput="value=value.replace(/[^0-9.]/g,'')"
                                        :disabled="disabled"
                                        utocomplete="off" size="small" placeholder="氧气实际送出量（m³）"/>
                            </template>
                          </el-table-column>
                          <el-table-column
                            align="center"
                            min-width="9%"
                            prop="eleConsumption"
                            label="除盐水量(吨)">
                            <template slot-scope="scope">
                              <el-input v-model="scope.row.data4"
                                        oninput="value=value.replace(/[^0-9.]/g,'')"
                                        :disabled="disabled"
                                        utocomplete="off" size="small" placeholder="用电量（kw.h）"/>
                            </template>
                          </el-table-column>
                          <el-table-column
                            align="center"
                            min-width="9%"
                            prop="waterConsumption"
                            label="煤气量（万Nm³）">
                            <template slot-scope="scope">
                              <el-input v-model="scope.row.data5"
                                        oninput="value=value.replace(/[^0-9.]/g,'')"
                                        :disabled="disabled"
                                        utocomplete="off" size="small" placeholder="用水量（m³）"/>
                            </template>
                          </el-table-column>
                          <el-table-column
                            align="center"
                            min-width="9%"
                            prop="saltConsumption"
                            label="耗水(m³)">
                            <template slot-scope="scope">
                              <el-input v-model="scope.row.data6"
                                        oninput="value=value.replace(/[^0-9.]/g,'')"
                                        :disabled="disabled"
                                        utocomplete="off" size="small" placeholder="工业盐（kg）"/>
                            </template>
                          </el-table-column>
                          <el-table-column
                            align="center"
                            min-width="9%"
                            prop="compressorStopTime"
                            label="运行小时(h)">
                            <template slot-scope="scope">
                              <el-input v-model="scope.row.data7"
                                        oninput="value=value.replace(/[^0-9.]/g,'')"
                                        :disabled="disabled"
                                        utocomplete="off" size="small" placeholder="氧压机停运时间（min）"/>
                            </template>
                          </el-table-column>
                          <el-table-column label="操作" width="110" align="center">
                            <template slot-scope="scope">
                              <el-button size="mini" type="default"
                                         @click="removeRow(scope.$index, scope.row)" icon="el-icon-delete">删除行
                              </el-button>
                            </template>
                          </el-table-column>
                        </el-table>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
            </el-row>
            <el-row :gutter="10" class="mt2">
              <el-col :span="24">
                <el-card shadow="hover" class="h120">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-help"></i>
                    <span>烧结余热发电(单位：万Kw.h)</span>
                  </div>
                  <el-row>
                    <el-col :span="4">
                      <el-form-item label="发电量(万Kw.h)">
                        <el-input v-model="assembleData.subTableDataList[1].data[0].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="供电量(万Kw.h)" label-width="180px">
                        <el-input v-model="assembleData.subTableDataList[1].data[1].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </el-card>
              </el-col>
            </el-row>
            <el-row :gutter="10" class="mt2">
              <el-col :span="24">
                <el-card shadow="hover" class="h120">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-help"></i>
                    <span>煤气柜</span>
                  </div>
                  <el-row>
                    <el-col :span="4">
                      <el-form-item label="输送煤气（万m³)">
                        <el-input v-model="assembleData.subTableDataList[2].data[0].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="回收（炉）" label-width="180px">
                        <el-input v-model="assembleData.subTableDataList[2].data[1].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="排空（炉）">
                        <el-input v-model="assembleData.subTableDataList[2].data[2].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="拒收（炉）" label-width="180px">
                        <el-input v-model="assembleData.subTableDataList[2].data[3].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="吨钢产煤气" label-width="180px">
                        <el-input v-model="assembleData.subTableDataList[2].data[4].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="放散（炉数）" label-width="180px">
                        <el-input v-model="assembleData.subTableDataList[2].data[5].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </el-card>
              </el-col>
            </el-row>

            <el-row :gutter="10" class="mt2">
              <el-col :span="24">
                <el-card shadow="hover" class="h210">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-question"></i>
                    <span>问题反馈</span>
                  </div>
                  <el-row>
                    <el-col :span="10">
                      <el-form-item label="深井运行情况" label-width="140px">
                        <el-input v-model="assembleData.subTableDataList[3].data[0].valueText"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-chat-dot-round"
                                  type="textarea"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="设备存在问题" label-width="140px">
                        <el-input v-model="assembleData.subTableDataList[3].data[1].valueText"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-chat-dot-round"
                                  type="textarea"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="10">
                      <el-form-item label="需公司解决问题" label-width="140px">
                        <el-input v-model="assembleData.subTableDataList[3].data[2].valueText"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-chat-dot-round"
                                  type="textarea"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="昨日问题处理及反馈" label-width="140px">
                        <el-input v-model="assembleData.subTableDataList[3].data[3].valueText"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-chat-dot-round"
                                  type="textarea"></el-input>
                      </el-form-item>
                    </el-col>

                  </el-row>
                </el-card>
              </el-col>
            </el-row>
          </el-form>
        </el-card>

      </template>
    </div>
  </div>
</template>

<script>
import {createOrUpdate, getData, preCreate} from "@/api/report/assembleData";

export default {
  name: 'ElectricityReport',
  mounted() {
    const id = this.$route.query.tid
    const mainTableId = this.$route.query.mainTableId
    const op = this.$route.query.op
    if (op == 'look') {
      this.disabled = true
    }
    if (op == 'look' || op == 'edit') {
      this.dateDisabled = true;
    }
    if (id > 0) {
      getData(
        {
          "baseTableId": id
        }
      ).then(response => {
        this.assembleData = response
        this.form.operatorDate = this.assembleData.commonData.date
        this.genDynamicList()
        this.loaded = true
      });
    } else {
      preCreate(
        {
          "mainTableId": mainTableId,
          "shiftId": -1,
          "userId": 1
        }
      ).then(response => {
        this.assembleData = response
        this.genDynamicList()
        this.loaded = true
      });

    }
  },
  data() {
    return {
      loaded: false,
      assembleData: {},
      disabled: false,
      dateDisabled: false,
      form: {
        operatorDate: new Date(),
        user: {
          personId: '455',
          personName: 'llt',
          personJobNo: 'IC20040010',
        },
        shift: -1,
      }
    }
  },
  methods: {
    dateChange() {
      const date = this.form.operatorDate
      const id = this.$route.query.tid
      if (id > 0) {

      } else {
        preCreate(
          {
            "mainTableId": 11,
            "shiftId": this.form.shift,
            "userId": 1,
            "date": date
          }
        ).then(response => {
          this.assembleData = response
          this.genDynamicList()
          this.loaded = true
        });
      }
    },
    onSubmit() {
      const subTable1 = this.assembleData.subTableDataList[0].data
      for (let i = 0; i < subTable1.length; i++) {
        const line = subTable1[i];
        if (i < this.dynamicList.length) {
          const real = this.dynamicList[i]
          line[0].valueText = real.data1
          line[1].valueNumber = real.data2
          line[2].valueNumber = real.data3
          line[3].valueNumber = real.data4
          line[4].valueNumber = real.data5
          line[5].valueNumber = real.data6
          line[6].valueNumber = real.data7
        } else {
          line[0].valueText = null
          line[1].valueNumber = null
          line[2].valueNumber = null
          line[3].valueNumber = null
          line[4].valueNumber = null
          line[5].valueNumber = null
          line[6].valueNumber = null
        }
      }
      createOrUpdate(
        this.assembleData,
      ).then(response => {
        this.$message.success('提交成功！');
      });
    },
    handleBack() {
      this.$router.go(-1);
    },
    addRow() {
      const length = this.dynamicList.length;
      if (length >= 5) {
        return
      }
      this.dynamicList.push({
        data1: '1#机组',
        data2: 0,
        data3: 0,
        data4: 0,
        data5: 0,
        data6: 0,
        data7: 0,
      })
    },
    removeRow(index, row) {
      this.$confirm('确认删除吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        if (index >= 0) {
          this.dynamicList.splice(index, 1)
        }
      }).catch(() => {
        return;
      });
    },
    genDynamicList() {
      this.dynamicList = []
      const subTable1 = this.assembleData.subTableDataList[0].data
      const firstLine = subTable1[0]
      if (!firstLine[0].valueText) {
        this.dynamicList.push({
          data1: '1#机组',
          data2: 0,
          data3: 0,
          data4: 0,
          data5: 0,
          data6: 0,
          data7: 0,
        })
      } else {
        for (let i = 0; i < subTable1.length; i++) {
          const line = subTable1[i];
          if (line[0].valueText) {
            this.dynamicList.push({
              data1: line[0].valueText,
              data2: line[1].valueNumber,
              data3: line[2].valueNumber,
              data4: line[3].valueNumber,
              data5: line[4].valueNumber,
              data6: line[5].valueNumber,
              data7: line[6].valueNumber,
            })
          }
        }
      }
    }
  }
};
</script>

<style scoped>
.h120 {
  height: 120px;
}

.h210 {
  height: 210px;
}

.h260 {
  height: 260px;
}

.h300 {
  height: 300px;
}

.mt2 {
  margin-top: 2px;
}
</style>
<style>
.card-table .el-card__body {
  padding: 0px;
}
</style>
