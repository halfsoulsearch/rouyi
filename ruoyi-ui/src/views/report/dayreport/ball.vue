<template>
  <div>
    <div class="container">
      <template>
        <el-card class="box-card" v-if="loaded">
          <div slot="header" class="clearfix">
            <span><i class="el-icon-s-platform">球团厂日报表</i></span>
            <div class="header-btn">
              <el-button type="primary" icon="el-icon-finished" size="small" @click="onSubmit">提交</el-button>
              <el-button type="danger" plain icon="el-icon-document-checked" size="small">审核</el-button>
              <el-button type="default" plain icon="el-icon-back" size="small" @click="handleBack">返回</el-button>

            </div>
          </div>
          <el-form ref="form" :model="form" label-width="100px">
            <el-card shadow="hover" style="height: 75px;margin-bottom: 5px" class="my-card">
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
                    <el-input v-model="form.user.personName" class="w130" disabled
                              prefix-icon="el-icon-user"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="4">
                  <el-form-item label="企业工号：">
                    <el-input v-model="form.user.personJobNo" class="w130" disabled
                              prefix-icon="el-icon-discount"></el-input>
                  </el-form-item>
                </el-col>

                <el-col :span="4">
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
                  <el-form-item label="当前状态：">
                    <el-tag type="primary">编辑</el-tag>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-card>
            <el-row :gutter="10">
              <el-col :span="8">
                <el-card shadow="hover" class="my-card">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>基础数据(单位:吨)</span>
                  </div>
                  <div class="text item h120">
                    <el-row>
                      <el-col :span="12">
                        <el-form-item label="生产量">
                          <el-input v-model="assembleData.subTableDataList[0].data[0].valueNumber"
                                    suffix-icon="el-icon-edit"
                                    :disabled="disabled"
                                    oninput="value=value.replace(/[^0-9.]/g,'')"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item label="转鼓指数">
                          <el-input v-model="assembleData.subTableDataList[0].data[1].valueNumber"
                                    suffix-icon="el-icon-edit"
                                    :disabled="disabled"
                                    oninput="value=value.replace(/[^0-9.]/g,'')"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="12">
                        <el-form-item label="自返粉">
                          <el-input v-model="assembleData.subTableDataList[0].data[2].valueNumber"
                                    suffix-icon="el-icon-edit"
                                    :disabled="disabled"
                                    oninput="value=value.replace(/[^0-9.]/g,'')"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item label="抗压强度">
                          <el-input v-model="assembleData.subTableDataList[0].data[3].valueNumber"
                                    suffix-icon="el-icon-edit"
                                    :disabled="disabled"
                                    oninput="value=value.replace(/[^0-9.]/g,'')"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
              <el-col :span="16">
                <el-card shadow="hover" class="my-card">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-promotion"></i>
                    <span>原料消耗(单位:吨)</span>
                  </div>
                  <div class="text item h120">
                    <el-row class="md10 my-line">
                      <el-col :span="4">
                        <el-link :underline="false" icon="el-icon-coin">物料名称</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-link :underline="false">代县粉</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-link :underline="false">0.25硫乌克兰精粉</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-link :underline="false">0.04硫乌克兰精粉</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-link :underline="false">膨润土</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-link :underline="false">除尘灰</el-link>
                      </el-col>
                    </el-row>
                    <el-row class="md5 my-line">
                      <el-col :span="4">
                        <el-link :underline="false" icon="el-icon-data-analysis">消耗数量</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[0][0].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[0][1].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[0][2].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[0][3].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[0][4].valueNumber">
                        </el-input>
                      </el-col>
                    </el-row>
                    <el-row class="md5 my-line">
                      <el-col :span="4">
                        <el-link :underline="false" icon="el-icon-ship">上仓水分</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[1][0].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[1][1].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[1][2].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[1][3].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[1][4].valueNumber">
                        </el-input>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="8">
                <el-card shadow="hover" class="my-card h236">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-claim"></i>
                    <span>球团矿成份(%)</span>
                  </div>
                  <div class="text item h120">
                    <el-row>
                      <el-col :span="8">
                        <el-form-item label="TFe">
                          <el-input
                            class="input-width20"
                            placeholder=""
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            :disabled="disabled"
                            v-model="assembleData.subTableDataList[2].data[0].valueNumber">
                          </el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8">
                        <el-form-item label="SiO2">
                          <el-input
                            class="input-width20"
                            placeholder=""
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            :disabled="disabled"
                            v-model="assembleData.subTableDataList[2].data[1].valueNumber">
                          </el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8">
                        <el-form-item label="CaO">
                          <el-input
                            class="input-width20"
                            placeholder=""
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            :disabled="disabled"
                            v-model="assembleData.subTableDataList[2].data[2].valueNumber">
                          </el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="8">
                        <el-form-item label="Mg0">
                          <el-input
                            class="input-width20"
                            placeholder=""
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            :disabled="disabled"
                            v-model="assembleData.subTableDataList[2].data[3].valueNumber">
                          </el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8">
                        <el-form-item label="Fe0">
                          <el-input
                            class="input-width20"
                            placeholder=""
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            :disabled="disabled"
                            v-model="assembleData.subTableDataList[2].data[4].valueNumber">
                          </el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8">
                        <el-form-item label="S">
                          <el-input
                            class="input-width20"
                            placeholder=""
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            :disabled="disabled"
                            v-model="assembleData.subTableDataList[2].data[5].valueNumber">
                          </el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="5">
                        <el-form-item label="R2">
                          <el-input
                            class="input-width20"
                            placeholder=""
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            :disabled="disabled"
                            v-model="assembleData.subTableDataList[2].data[6].valueNumber"
                          >
                          </el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
              <el-col :span="16">
                <el-card shadow="hover" class="my-card h236">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-flag"></i>
                    <span>大宗原料进出存(吨)</span>
                  </div>
                  <div class="text item h120">
                    <el-row class="md5 my-line">
                      <el-col :span="4">
                        <el-link :underline="false" icon="el-icon-coin">物料名称</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-link :underline="false">代县粉</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-link :underline="false">0.25硫乌克兰精粉</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-link :underline="false">0.04硫乌克兰精粉</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-link :underline="false">膨润土</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-link :underline="false">除尘灰</el-link>
                      </el-col>
                    </el-row>
                    <el-row class="md5 my-line">
                      <el-col :span="4">
                        <el-link :underline="false" icon="el-icon-bottom-right">当日进厂</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[0][0].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[0][1].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[0][2].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[0][3].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[0][4].valueNumber">
                        </el-input>
                      </el-col>
                    </el-row>
                    <el-row class="md5">
                      <el-col :span="4">
                        <el-link :underline="false" icon="el-icon-bottom-left">当日出库</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[1][0].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[1][1].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[1][2].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[1][3].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[1][4].valueNumber">
                        </el-input>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="24">
                <el-card shadow="hover" class="my-card">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-question">&nbsp;生产记事</i>
                  </div>
                  <div class="text item">
                    <el-row>
                      <el-col :span="24">
                        <el-input type="textarea"
                                  v-model="assembleData.subTableDataList[4].data.valueText"
                                  :disabled="disabled"
                        ></el-input>
                      </el-col>
                    </el-row>
                  </div>
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
  name: 'baseform',
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
          value: 1,
          label: '甲班'
        }, {
          value: 2,
          label: '乙班'
        }, {
          value: 3,
          label: '丙班'
        }
      ],
      first: "first",
      form: {
        operatorDate: new Date(),
        user: {
          personId: '455',
          personName: 'llt',
          personJobNo: 'IC20040010',
        },
        shift: 1,
      }
    };
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
        });
      } else {
        preCreate(
          {
            "mainTableId": 1,
            "shiftId": this.form.shift,
            "userId": 1,
            "date": date
          }
        ).then(response => {
          this.assembleData = response
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
            "mainTableId": 1,
            "shiftId": this.form.shift,
            "userId": 1,
            "date": date
          }
        ).then(response => {
          this.assembleData = response
          this.loaded = true
        });
      }
    },
    onSubmit() {
      createOrUpdate(
        this.assembleData,
      ).then(response => {
        this.$message.success('提交成功！');
      });
    },
    //返回上一层
    handleBack(){
      this.$router.go(-1);
    },
  }
};
</script>
<style>
.el-row {
  margin-bottom: 1px;
}

.input-width30 {
  width: 105px;
}

.input-width20 {
  width: 75px;
}

.md5 {
  margin-bottom: 5px;
}

.md10 {
  margin-bottom: 10px;
}

.h236 {
  height: 236px;
}

.h120 {
  height: 120px;
}

.my-card {
  border: 1px solid #e1dfdf;
}

.my-line {
  line-height: 30px;
  border-bottom: 1px solid #eeeaea;
  padding: 2px
}
</style>
