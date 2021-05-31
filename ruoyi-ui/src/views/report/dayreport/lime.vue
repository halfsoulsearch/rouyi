<template>
  <div>
    <div class="container">
      <template>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span><i class="el-icon-s-platform">白灰厂日报表</i></span>
            <div class="header-btn">
              <el-button type="primary" icon="el-icon-finished" size="medium" @click="onSubmit">提交</el-button>
              <el-button type="danger" icon="el-icon-document-checked" size="medium">审核</el-button>
              <el-button type="default" plain icon="el-icon-back" size="medium" @click="handleBack">返回</el-button>
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
                <el-col :span="2">
                  <el-form-item label="报表状态：">
                    <el-tag type="warning" effect="plain">编辑</el-tag>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-card>
            <el-row :gutter="10">
              <el-col :span="8">
                <el-card shadow="hover" style="height: 208px" class="my-card">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>当日产量（单位:吨）</span>
                  </div>
                  <div class="text item">
                    <el-row>
                      <el-col :span="12">
                        <el-form-item label="轻烧白云石块">
                          <el-input suffix-icon="el-icon-edit"
                                    v-model="assembleData.subTableDataList[0].data[0].valueNumber"
                                    :disabled="disabled"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item label="块 灰">
                          <el-input suffix-icon="el-icon-edit"
                                    v-model="assembleData.subTableDataList[0].data[1].valueNumber"
                                    :disabled="disabled"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="12">
                        <el-form-item label="轻烧白云石粉">
                          <el-input suffix-icon="el-icon-edit"
                                    v-model="assembleData.subTableDataList[0].data[2].valueNumber"
                                    :disabled="disabled"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item label="灰 粉">
                          <el-input suffix-icon="el-icon-edit"
                                    v-model="assembleData.subTableDataList[0].data[3].valueNumber"
                                    :disabled="disabled"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
              <!--  产量end -->
              <el-col :span="8">
                <el-card shadow="hover" style="height: 208px" class="my-card">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-promotion"></i>
                    <span>大宗原料进出存（单位:吨）</span>
                    <el-button style="float: right; padding: 3px 0" type="text" icon="el-icon-refresh">获取数据</el-button>
                  </div>
                  <div class="text item">
                    <el-row>
                      <el-col :span="12">
                        <el-form-item label="石灰石当日进厂(吨)" label-width="140px">
                          <el-input v-model="assembleData.subTableDataList[4].data[0].valueNumber"
                                    :disabled="disabled"
                                    suffix-icon="el-icon-edit"></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item label="石灰石当日出库(吨)" label-width="140px">
                          <el-input v-model="assembleData.subTableDataList[4].data[1].valueNumber"
                                    :disabled="disabled"
                                    suffix-icon="el-icon-edit"></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="12">
                        <el-form-item label="白云石当日进厂(吨)" label-width="140px">
                          <el-input v-model="assembleData.subTableDataList[4].data[2].valueNumber"
                                    :disabled="disabled"
                                    suffix-icon="el-icon-edit"></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item label="白云石当日出库(吨)" label-width="140px">
                          <el-input v-model="assembleData.subTableDataList[4].data[3].valueNumber"
                                    :disabled="disabled"
                                    suffix-icon="el-icon-edit"></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
              <!--    大宗原料进出存 end  -->
              <el-col :span="8">
                <el-card shadow="hover" style="height: 208px" class="my-card">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-fold"></i>
                    <span>返粉（单位:吨）</span>
                  </div>
                  <el-row>
                    <el-col :span="12">
                      <el-form-item label="块灰返粉量(吨)" label-width="160px">
                        <el-input v-model="assembleData.subTableDataList[5].data[0].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="12">
                      <el-form-item label="轻烧白云石返粉量(吨)" label-width="160px">
                        <el-input v-model="assembleData.subTableDataList[5].data[1].valueNumber"
                                  :disabled="disabled"
                                  suffix-icon="el-icon-edit"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </el-card>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="8">
                <el-card shadow="hover" class="my-card">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-order"></i>
                    <span> 生产时间(单位:分)</span>
                  </div>
                  <div class="text item">
                    <el-row class="md5">
                      <el-col :span="4">
                        <span>炉&nbsp;&nbsp;&nbsp;&nbsp;号</span>
                      </el-col>
                      <el-col :span="6">
                        <blon>生产时间</blon>
                      </el-col>
                      <el-col :span="6">
                        <span>外部停机时间</span>
                      </el-col>
                      <el-col :span="6">
                        <span>内部停机时间</span>
                      </el-col>
                    </el-row>
                    <el-divider></el-divider>
                    <el-row class="md5">
                      <el-col :span="4">
                        <span>块灰1#</span>
                      </el-col>
                      <el-col :span="6">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[0][0].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                      <el-col :span="7">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          type="number"
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[0][1].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                      <el-col :span="7">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[0][2].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                    </el-row>
                    <el-row class="md5">
                      <el-col :span="4">
                        <span>块灰2#</span>
                      </el-col>
                      <el-col :span="6">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[1][0].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                      <el-col :span="7">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[1][1].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                      <el-col :span="7">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[1][2].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                    </el-row>
                    <el-row class="md5">
                      <el-col :span="4">
                        <span>灰粉3#</span>
                      </el-col>
                      <el-col :span="6">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[2][0].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                      <el-col :span="7">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[2][1].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                      <el-col :span="7">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[2][2].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                    </el-row>
                    <el-row class="md5">
                      <el-col :span="4">
                        <span>灰粉4#</span>
                      </el-col>
                      <el-col :span="6">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[3][0].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                      <el-col :span="7">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[3][1].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                      <el-col :span="7">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[3][2].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                    </el-row>
                    <el-row class="md5">
                      <el-col :span="4">
                        <span>白云石块</span>
                      </el-col>
                      <el-col :span="6">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[4][0].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                      <el-col :span="7">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[4][1].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                      <el-col :span="7">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[4][2].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="4">
                        <span>白云石粉</span>
                      </el-col>
                      <el-col :span="6">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[5][0].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                      <el-col :span="7">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[5][1].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                      <el-col :span="7">
                        <el-input
                          class="input-width90"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[3].data[5][2].valueNumber" suffix-icon="el-icon-date">
                        </el-input>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
              <el-col :span="8">
                <el-card shadow="hover" style="height: 392px" class="my-card">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-upload"></i>
                    <span>产品质量(%)</span>
                  </div>
                  <div class="text item">
                    <el-row class="md10" gutter="10">
                      <el-col :span="4">
                        <span>指&nbsp;&nbsp;&nbsp;&nbsp;标</span>
                      </el-col>
                      <el-col :span="4">
                       <span>CaO</span>
                      </el-col>
                      <el-col :span="4">
                        <span>MgO</span>
                      </el-col>
                      <el-col :span="4">
                        <span>SiO2</span>
                      </el-col>
                      <el-col :span="4">
                        <span>活性度</span>
                      </el-col>
                      <el-col :span="4">
                        <span>生过烧率</span>
                      </el-col>
                    </el-row>
                    <el-divider></el-divider>
                    <el-row class="md5">
                      <el-col :span="4">
                        <el-link :underline="false">块&nbsp;&nbsp;&nbsp;&nbsp;灰</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[0][0].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[0][1].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[0][2].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[0][3].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[0][4].valueNumber">                        >
                        </el-input>
                      </el-col>
                    </el-row>
                    <el-row class="md5">
                      <el-col :span="4">
                        <el-link :underline="false">灰&nbsp;&nbsp;&nbsp;&nbsp;粉</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[1][0].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[1][1].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[1][2].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[1][3].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[1][4].valueNumber">                        >
                        </el-input>
                      </el-col>
                    </el-row>
                    <el-row class="md5">
                      <el-col :span="4">
                        <el-link :underline="false">轻烧白云石</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[2][0].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[2][1].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[2][2].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[2][3].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[1].data[2][4].valueNumber">                        >
                        </el-input>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
              <el-col :span="8">
                <el-card shadow="hover" style="height: 390px" class="my-card">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-flag"></i>
                    <span>原燃动力消耗</span>
                  </div>
                  <div class="text item">
                    <el-row class="md5">
                      <el-col :span="4">
                        <span>地&nbsp;&nbsp;&nbsp;点</span>
                      </el-col>
                      <el-col :span="4">
                        <span>煤气(m³)</span>
                      </el-col>
                      <el-col :span="4">
                        <span>电(kwh)</span>
                      </el-col>
                      <el-col :span="4">
                        <span>水(m³)</span>
                      </el-col>
                      <el-col :span="4">
                        <span>氮气(m³)</span>
                      </el-col>
                      <el-col :span="4">
                        <span>石灰石子(t)</span>
                      </el-col>
                    </el-row>
                    <el-divider></el-divider>
                    <el-row class="md5">
                      <el-col :span="4">
                        <span>烧嘴窑</span>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[2].data[0][0].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[2].data[0][1].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[2].data[0][2].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[2].data[0][3].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[2].data[0][4].valueNumber">
                        </el-input>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="4">
                        <el-link :underline="false">套筒窑</el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[2].data[1][0].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[2].data[1][1].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[2].data[1][2].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[2].data[1][3].valueNumber">                        >
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          placeholder=""
                          :disabled="disabled"
                          v-model="assembleData.subTableDataList[2].data[1][4].valueNumber">                        >
                        </el-input>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="24">
                <el-card shadow="hover" class="my-card" body-style="padding:3px">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-question"></i>
                    <span>生产记事</span>
                  </div>
                  <div class="text item">
                    <el-row>
                      <el-col :span="24">
                        <el-input type="textarea" v-model="assembleData.subTableDataList[6].data.valueText" :disabled="disabled"></el-input>
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
  name: 'lime',
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

      first: "first",
      form: {
        user: {
          personId: '455',
          personName: 'llt',
          personJobNo: 'IC20040010',
        },
        operatorDate: new Date(),
      }
    };
  },
  methods: {
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
    handleBack() {
      this.$router.go(-1);
    },
  }
};
</script>
<style>
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

.el-row {
  margin-bottom: 1px;
}

.input-width30 {
  width: 62px;
}

.input-width90 {
  width: 95px;
}

.md5 {
  margin-bottom: 5px;
}

.md10 {
  margin-bottom: 10px;
}

.w130 {
  width: 130px;
}

.my-card {
  border: 1px solid #e1dfdf;
}
</style>
