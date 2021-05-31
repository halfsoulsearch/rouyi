<template>
  <div>
    <div class="container" v-if="loaded">
      <template>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>园区轧钢日报表</span>
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
                    <el-input v-model="form.user.personName" class="w130" disabled></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="5">
                  <el-form-item label="企业工号：">
                    <el-input v-model="form.user.personJobNo" class="w130" disabled></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="5">
                  <el-form-item label="班次：">
                    <el-select v-model="form.shift" placeholder="请选择班次" @change="shiftChange">
                      <el-option
                        v-for="item in shiftOption"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="2">
                  <el-form-item label="报表状态：">
                    <el-tag type="warning" effect="plain">编辑</el-tag>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-card>
            <el-row :gutter="10">
              <el-col :span="24">
                <el-card shadow="hover" class="card-table h260">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>钢坯消耗（单位:吨）</span>
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
                            prop="steelType"
                            label="材质"
                            width="145">
                            <template slot-scope="scope">
                              <el-select v-model="scope.row.data1" placeholder="材质" :disabled="disabled"
                              >
                                <el-option
                                  v-for="item in steelType"
                                  :key="item.id"
                                  :label="item.name"
                                  :value="item.name">
                                </el-option>
                              </el-select>
                            </template>
                          </el-table-column>
                          <el-table-column
                            align="center"
                            prop="steelModel"
                            label="规格"
                            width="125">
                            <template slot-scope="scope">
                              <el-select v-model="scope.row.data2" placeholder="规格" :disabled="disabled"
                              >
                                <el-option
                                  v-for="item in steelModel"
                                  :key="item.id"
                                  :label="item.name"
                                  :value="item.name">
                                </el-option>
                              </el-select>
                            </template>
                          </el-table-column>
                          <el-table-column
                            align="center"
                            min-width="9%"
                            prop="steelUseWeight"
                            label="钢坯消耗(吨)">
                            <template slot-scope="scope">
                              <el-input v-model="scope.row.data3"
                                        oninput="value=value.replace(/[^0-9.]/g,'')"
                                        :disabled="disabled"

                                        utocomplete="off" size="small" placeholder="钢坯消耗(吨)"/>
                            </template>
                          </el-table-column>
                          <el-table-column
                            align="center"
                            min-width="9%"
                            prop="steelUseNum"
                            label="钢坯支数(支)">
                            <template slot-scope="scope">
                              <el-input v-model="scope.row.data4"
                                        oninput="value=value.replace(/[^0-9.]/g,'')"
                                        :disabled="disabled"

                                        utocomplete="off" size="small" placeholder="钢坯支数(支)"/>
                            </template>
                          </el-table-column>
                          <el-table-column
                            align="center"
                            min-width="9%"
                            prop="qualifiedWeight"
                            label="合格品重量(吨)">
                            <template slot-scope="scope">
                              <el-input v-model="scope.row.data5"
                                        oninput="value=value.replace(/[^0-9.]/g,'')"
                                        :disabled="disabled"

                                        utocomplete="off" size="small" placeholder="合格品重量(吨)"/>
                            </template>
                          </el-table-column>
                          <el-table-column
                            align="center"
                            min-width="9%"
                            prop="qualifiedNum"
                            label="合格品(件)">
                            <template slot-scope="scope">
                              <el-input v-model="scope.row.data6"
                                        oninput="value=value.replace(/[^0-9.]/g,'')"
                                        :disabled="disabled"

                                        utocomplete="off" size="small" placeholder="合格品(件)"/>
                            </template>
                          </el-table-column>
                          <el-table-column
                            align="center"
                            min-width="9%"
                            prop="needBackNum"
                            label="待返品(件)">
                            <template slot-scope="scope">
                              <el-input v-model="scope.row.data7"
                                        oninput="value=value.replace(/[^0-9.]/g,'')"
                                        :disabled="disabled"

                                        utocomplete="off" size="small" placeholder="待返品(件)"/>
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
                    <i class="el-icon-s-data"></i>
                    <span>能源动力消耗（单位:吨）</span>
                  </div>
                  <el-row>
                    <el-col :span="4">
                      <el-form-item label="用水(t)">
                        <el-input v-model="assembleData.subTableDataList[1].data[0].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="用电(kwh)">
                        <el-input v-model="assembleData.subTableDataList[1].data[1].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="高炉煤气(m3)">
                        <el-input v-model="assembleData.subTableDataList[1].data[2].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="转炉煤气(m3)">
                        <el-input v-model="assembleData.subTableDataList[1].data[3].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="氮气(m3)">
                        <el-input v-model="assembleData.subTableDataList[1].data[4].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="氧气(m3)">
                        <el-input v-model="assembleData.subTableDataList[1].data[5].valueNumber"
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
                    <i class="el-icon-s-data"></i>
                    <span>生产时间分类统计(单位:分)</span>
                  </div>
                  <el-row>
                    <el-col :span="4">
                      <el-form-item label="生产总时间">
                        <el-input v-model="assembleData.subTableDataList[2].data[0].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-date"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="换辊|槽工艺检查" label-width="140px">
                        <el-input v-model="assembleData.subTableDataList[2].data[1].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-date"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="设备非计划停机" label-width="140px">
                        <el-input v-model="assembleData.subTableDataList[2].data[2].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-date"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="换规格或计划检修" label-width="140px">
                        <el-input v-model="assembleData.subTableDataList[2].data[3].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-date"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="外部原因安排停机" label-width="140px">
                        <el-input v-model="assembleData.subTableDataList[2].data[4].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-date"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="4">
                      <el-form-item label="其他">
                        <el-input v-model="assembleData.subTableDataList[2].data[5].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-date"></el-input>
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
  name: 'westSteelRollingReport',
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
      shiftOption: [
        {
          value: 12,
          label: 'A班'
        }, {
          value: 13,
          label: 'B班'
        }
      ],
      dynamicList: [],
      steelType: [
        {
          id: 1,
          name: 'HRB400E'
        }, {
          id: 2,
          name: 'HRB400E'
        }
      ],
      steelModel: [
        {
          id: 1,
          name: '∅22*12m'
        },
        {
          id: 2,
          name: '∅25*12m'
        },
        {
          id: 3,
          name: '∅28*12m'
        },
        {
          id: 4,
          name: '∅32*9m'
        }, {
          id: 5,
          name: '∅32*12m'
        }
      ],
      form: {
        operatorDate: new Date(),
        user: {
          personId: '455',
          personName: 'llt',
          personJobNo: 'IC20040010',
        },
        shift: 12,
      }
    }
  },
  methods: {
    shiftChange() {
      const date = this.form.operatorDate
      const id = this.$route.query.tid
      if (id > 0) {
        getData(
          {
            "baseTableId": id,
            "shiftId": this.form.shift
          }
        ).then(response => {
          this.assembleData = response
          this.genDynamicList()
          this.loaded = true
        });
      } else {
        preCreate(
          {
            "mainTableId": 10,
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
    dateChange() {
      const date = this.form.operatorDate
      const id = this.$route.query.tid
      if (id > 0) {

      } else {
        preCreate(
          {
            "mainTableId": 10,
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
          line[1].valueText = real.data2
          line[2].valueNumber = real.data3
          line[3].valueNumber = real.data4
          line[4].valueNumber = real.data5
          line[5].valueNumber = real.data6
          line[6].valueNumber = real.data7
        } else {
          line[0].valueText = null
          line[1].valueText = null
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
        data1: 'HRB400E',
        data2: '∅22*12m',
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
          data1: 'HRB400E',
          data2: '∅22*12m',
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
              data2: line[1].valueText,
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
