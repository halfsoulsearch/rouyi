<template>
  <div>
    <div class="container">
      <template>
        <el-card class="box-card" v-if="loaded">
          <div slot="header" class="clearfix">
            <span>园区炼钢日报表</span>
            <div class="header-btn">
              <el-button type="primary" icon="el-icon-finished" size="small" @click="onSubmit">提交</el-button>
              <el-button type="danger" plain icon="el-icon-document-checked" size="small">审核</el-button>
              <el-button type="default" plain icon="el-icon-back" size="small" @click="handleBack">返回</el-button>

            </div>
          </div>

          <el-form ref="form" :model="form" label-width="100px">
            <el-card shadow="hover" style="height: 75px;margin-bottom: 5px">
              <el-row :gutter="20">
                <el-col :span="5">
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
                    <el-input v-model="form.user.personName"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="5">
                  <el-form-item label="企业工号：">
                    <el-input v-model="form.user.personJobNo"></el-input>
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
              <el-col :span="12">
                <el-card shadow="hover">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>连铸</span>
                  </div>
                  <div class="text item">
                    <div class="text item h140">
                      <el-row class="md5">
                        <el-col :span="4">
                          <el-link type="success" :underline="false">机号</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-link :underline="false">HPB400E产量</el-link>
                        </el-col>
                        <el-col :span="4">
                          <el-link :underline="false">HPB400EV产量</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-link :underline="false">Q235产量</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-link :underline="false">浇铸炉数(炉)</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-link :underline="false">最大平均速度</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-link :underline="false">最小平均速度</el-link>
                        </el-col>
                      </el-row>
                      <el-row>
                        <el-col :span="4">
                          <el-link :underline="false">1#</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[0][0].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="4">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[0][1].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[0][2].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[0][3].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[0][4].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[0][5].valueNumber">
                          </el-input>
                        </el-col>
                      </el-row>
                      <el-row>
                        <el-col :span="4">
                          <el-link :underline="false">2#</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[1][0].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="4">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[1][1].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[1][2].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[1][3].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[1][4].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[1][5].valueNumber">
                          </el-input>
                        </el-col>
                      </el-row>
                      <el-row>
                        <el-col :span="4">
                          <el-link :underline="false">3#</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[2][0].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="4">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[2][1].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[2][2].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[2][3].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[2][4].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[2][5].valueNumber">
                          </el-input>
                        </el-col>
                      </el-row>
                      <el-row>
                        <el-col :span="4">
                          <el-link :underline="false">4#</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[3][0].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="4">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[3][1].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[3][2].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[3][3].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[3][4].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[0].data[3][5].valueNumber">
                          </el-input>
                        </el-col>
                      </el-row>
                    </div>
                  </div>
                </el-card>
              </el-col>
              <el-col :span="12">
                <el-card shadow="hover">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>转炉</span>
                  </div>
                  <div class="text item">
                    <div class="text item h140">
                      <el-row class="md5">
                        <el-col :span="3">
                          <el-link type="success" :underline="false">炉号</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-link :underline="false">冶炼炉数(炉)</el-link>
                        </el-col>
                        <el-col :span="5">
                          <el-link :underline="false">冶炼周期(min)</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-link type="success" :underline="false">合金料(t)</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-link :underline="false">HPB400E</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-link :underline="false">HPB400EV</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-link :underline="false">Q235</el-link>
                        </el-col>
                      </el-row>
                      <el-row>
                        <el-col :span="3">
                          <el-link :underline="false">2#</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[0][0].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="5">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[0][1].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-link :underline="false">硅锰</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[0][2].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[0][3].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[0][4].valueNumber">
                          </el-input>
                        </el-col>
                      </el-row>
                      <el-row>
                        <el-col :span="3">
                          <el-link :underline="false">3#</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[1][0].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="5">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[1][1].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-link :underline="false">硅铁</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[1][2].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[1][3].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[1][4].valueNumber">
                          </el-input>
                        </el-col>
                      </el-row>
                      <el-row>
                        <el-col :span="3">
                          <el-link :underline="false">4#</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[2][0].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="5">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[2][1].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-link :underline="false">钒氮合金</el-link>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[2][2].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[2][3].valueNumber">
                          </el-input>
                        </el-col>
                        <el-col :span="3">
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder=""
                            :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[2][4].valueNumber">
                          </el-input>
                        </el-col>
                      </el-row>
                    </div>
                  </div>
                </el-card>
              </el-col>
              <el-col :span="24">
                <el-card shadow="hover">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>直接材料及辅料消耗量(t)</span>
                  </div>
                  <div class="text item">
                    <el-row class="md5">
                      <el-col :span="4">
                        <el-link type="success" :underline="false"></el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">铁水</el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">外购废钢
                        </el-link>
                      </el-col>
                      <el-col :span="4" class="center">
                        <el-link :underline="false">轧钢切头尾、钢筋头、热轧废
                        </el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">高炉返矿
                        </el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">块矿
                        </el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">烧结矿
                        </el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">球团矿
                        </el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">焦丁
                        </el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">石灰块
                        </el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">轻烧白云石
                        </el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">白云石
                        </el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">保护渣
                        </el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">增碳剂
                        </el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">焦粉
                        </el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">石子
                        </el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-link :underline="false">石屑
                        </el-link>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="4">
                        <el-link :underline="false">进厂</el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][0].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][1].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4" class="center">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][2].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][3].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][4].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][5].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][6].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][7].valueNumber">
                        </el-input>
                      </el-col>

                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][8].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][9].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][10].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][11].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][12].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][13].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][14].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[0][15].valueNumber">
                        </el-input>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="4">
                        <el-link :underline="false">消耗</el-link>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][0].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][1].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4" class="center">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][2].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][3].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][4].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][5].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][6].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][7].valueNumber">
                        </el-input>
                      </el-col>

                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][8].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][9].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][10].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][11].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][12].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][13].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][14].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="1">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[2].data[1][15].valueNumber">
                        </el-input>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
            </el-row>
            <el-row :gutter="10">

              <el-col :span="8">
                <el-card shadow="hover">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>加工类消耗量(t)</span>
                  </div>
                  <div class="text item">
                    <el-row class="md5">
                      <el-col :span="4">
                        <el-link :underline="false">加工大铁
                        </el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-link :underline="false">加工中包块
                        </el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-link :underline="false">渣铁
                        </el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-link :underline="false">颗粒铁
                        </el-link>
                      </el-col>
                      <el-col :span="4">
                        <el-link :underline="false">磁选精粉
                        </el-link>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"

                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[3].data[0].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[3].data[1].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[3].data[2].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[3].data[3].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[3].data[4].valueNumber">
                        </el-input>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>

              <el-col :span="16">
                <el-card shadow="hover">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>水处理类消耗量(t)</span>
                  </div>
                  <div class="text item">
                    <el-row class="md5">
                      <el-col :span="3">
                        <el-link :underline="false">工业盐
                        </el-link>
                      </el-col>
                      <el-col :span="3">
                        <el-link :underline="false">缓蚀阻垢剂</el-link>
                      </el-col>
                      <el-col :span="3">
                        <el-link :underline="false">阻垢分散剂

                        </el-link>
                      </el-col>
                      <el-col :span="3">
                        <el-link :underline="false">絮凝沉降剂
                        </el-link>
                      </el-col>
                      <el-col :span="4" class="center">
                        <el-link :underline="false">高效絮凝 沉降剂
                        </el-link>
                      </el-col>
                      <el-col :span="3">
                        <el-link :underline="false">除油剂
                        </el-link>
                      </el-col>
                      <el-col :span="3">
                        <el-link :underline="false">杀菌灭藻剂
                        </el-link>
                      </el-col>
                      <el-col :span="2">
                        <el-link :underline="false">树脂
                        </el-link>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="3">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[4].data[0].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="3">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[4].data[1].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="3">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[4].data[2].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="3">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[4].data[3].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="4" class="center">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[4].data[4].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="3">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[4].data[5].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="3">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[4].data[6].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="2">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[4].data[7].valueNumber">
                        </el-input>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>

              <el-col :span="14">
                <el-card shadow="hover">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>资材消耗量(t)</span>
                  </div>
                  <div class="text item h120">
                    <el-row class="md5">
                      <el-col :span="2">
                        <el-link :underline="false">碳化稻壳
                        </el-link>
                      </el-col>
                      <el-col :span="2">
                        <el-link :underline="false">取样器
                        </el-link>
                      </el-col>
                      <el-col :span="2">
                        <el-link :underline="false">测温管
                        </el-link>
                      </el-col>
                      <el-col :span="2">
                        <el-link :underline="false">挡渣球
                        </el-link>
                      </el-col>
                      <el-col :span="2" class="center">
                        <el-link :underline="false">挡渣塞
                        </el-link>
                      </el-col>
                      <el-col :span="2">
                        <el-link :underline="false">挡渣锥
                        </el-link>
                      </el-col>
                      <el-col :span="2">
                        <el-link :underline="false">石英水口
                        </el-link>
                      </el-col>
                      <el-col :span="2">
                        <el-link :underline="false">铝碳水口
                        </el-link>
                      </el-col>
                      <el-col :span="2">
                        <el-link :underline="false">大包覆盖剂
                        </el-link>
                      </el-col>
                      <el-col :span="2">
                        <el-link :underline="false">中包覆盖剂
                        </el-link>
                      </el-col>
                      <el-col :span="2">
                        <el-link :underline="false">硅铝钡钙
                        </el-link>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="2">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[5].data[0].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="2">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[5].data[1].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="2">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[5].data[2].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="2">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[5].data[3].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="2">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[5].data[4].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="2">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[5].data[5].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="2">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[5].data[6].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="2">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[5].data[7].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="2">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[5].data[8].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="2">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[5].data[9].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="2">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[5].data[10].valueNumber">
                        </el-input>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>

              <el-col :span="10">
                <el-card shadow="hover">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>能源消耗量(m³)</span>
                  </div>
                  <div class="text item h120">
                    <el-row class="md5">
                      <el-col :span="3">
                        <el-link :underline="false">氧气
                        </el-link>
                      </el-col>
                      <el-col :span="3">
                        <el-link :underline="false">氮气
                        </el-link>
                      </el-col>
                      <el-col :span="3">
                        <el-link :underline="false">氩气
                        </el-link>
                      </el-col>
                      <el-col :span="3">
                        <el-link :underline="false">高炉煤气
                        </el-link>
                      </el-col>
                      <el-col :span="3">
                        <el-link :underline="false">电(kw.h)</el-link>
                      </el-col>
                      <el-col :span="3">
                        <el-link :underline="false">水耗
                        </el-link>
                      </el-col>
                      <el-col :span="3">
                        <el-link :underline="false">转炉煤气回收
                        </el-link>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="3">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[6].data[0].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="3">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[6].data[1].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="3">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[6].data[2].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="3">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[6].data[3].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="3">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[6].data[4].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="3">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[6].data[5].valueNumber">
                        </el-input>
                      </el-col>
                      <el-col :span="3">
                        <el-input
                          class="input-width30"
                          size="mini"
                          placeholder=""
                          :disabled="disabled"
                          oninput="value=value.replace(/[^0-9.]/g,'')"
                          v-model="assembleData.subTableDataList[6].data[6].valueNumber">
                        </el-input>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
            </el-row>
            <el-row :gutter="10">
              <el-col :span="24">
                <el-card shadow="hover">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>生产记事</span>
                  </div>
                  <div class="text item">
                    <el-row>
                      <el-col :span="24">
                        <el-input v-model="assembleData.subTableDataList[7].data.valueNumber"
                                  :disabled="disabled"
                                  type="textarea"></el-input>
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
    dateChange() {
      const date = this.form.operatorDate
      const id = this.$route.query.tid
      if (id > 0) {

      } else {
        preCreate(
          {
            "mainTableId": 8,
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

    handleBack() {
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
  width: 65px;
}

.input-width20 {
  width: 45px;
}

.md5 {
  margin-bottom: 5px;
}

.h120 {
  height: 120px;
}

.h140 {
  height: 140px;
}

.center {
  text-align: center;
}

</style>
