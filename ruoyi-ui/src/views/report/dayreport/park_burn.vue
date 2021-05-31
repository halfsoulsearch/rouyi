<template>
  <div class="table-burn">
    <div class="container">
      <template>
        <el-card class="box-card" v-if="loaded">
          <div slot="header" class="clearfix">
            <span>园区烧结日报表-[录入]</span>
            <div class="header-btn">
              <el-button type="primary" icon="el-icon-finished" size="small" @click="onSubmit">提交</el-button>
              <el-button type="danger" plain icon="el-icon-document-checked" size="small">审核</el-button>
              <el-button type="default" plain icon="el-icon-back" size="small" @click="handleBack">返回</el-button>
            </div>
          </div>
          <el-form ref="form" :model="form" label-width="120px">
            <el-card shadow="hover" style="height: 75px;margin-bottom: 5px">
              <el-row :gutter="40">
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
            <!--   基础数据 -->
            <el-row :gutter="10">
              <el-col :span="8">
                <el-card shadow="hover" class="my-card h260">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>基础数据</span>
                  </div>
                  <div class="text item">
                    <div class="text item h120">
                      <table>
                        <thead>
                          <tr>
                            <th>机 号</th>
                            <th>生产量(吨)</th>
                            <th>作业时间</th>
                            <th>停机时间</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>3#</td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[0].data[2][0].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[0].data[0][0].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[0].data[1][0].valueNumber">
                              </el-input>
                            </td>
                          </tr>
                          <tr>
                            <td>4#</td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[0].data[2][1].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[0].data[0][1].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[0].data[1][1].valueNumber">
                              </el-input>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </el-card>
              </el-col>
              <el-col :span="16">
                <el-card shadow="hover" class="my-card h260">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>烧结矿质量（化验成分%）</span>
                  </div>
                  <div class="text item h120">

                    <table>
                      <tr>
                        <th>指标</th>
                        <th>TFe</th>
                        <th>SiO2</th>
                        <th>CaO</th>
                        <th>MgO</th>
                        <th>FeO</th>
                        <th>S</th>
                        <th>R2</th>
                      </tr>
                      <tr>
                        <td>化验值</td>
                        <td>
                          <el-input
                            class="input-width20"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[0].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width20"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[1].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width20"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[2].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width20"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[3].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width20"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[4].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width20"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[5].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width20"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[1].data[6].valueNumber">
                          </el-input>
                        </td>
                      </tr>
                    </table>
                  </div>
                </el-card>
              </el-col>
            </el-row>
            <!--原料消耗-->
            <el-row :gutter="20">
              <el-col :span="24">
                <el-card shadow="hover" class="my-card">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>原料消耗(单位：吨)</span>
                  </div>
                  <div class="text item">
                    <table>
                      <thead>
                      <tr>
                        <th>物 料</th>
                        <th>金布巴</th>
                        <th>纽曼粉</th>
                        <th>铁精粉</th>
                        <th>杨迪粉</th>
                        <th>槽返</th>
                        <th>轻烧镁粉</th>
                        <th>生石灰粉</th>
                        <th>巴西粉</th>
                        <th>麦克粉</th>
                        <th>球团粉</th>
                        <th>来村精粉</th>
                        <th>除尘灰</th>
                        <th>红泥</th>
                        <th>焦粉</th>
                        <th>煤粉</th>
                      </tr>
                      </thead>
                      <tbody>
                      <tr>
                        <td>消&nbsp;&nbsp;耗</td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][0].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][1].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][2].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][3].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][4].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][5].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][6].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][7].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][8].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][9].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][10].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][11].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][12].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][13].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[0][14].valueNumber">
                          </el-input>
                        </td>
                      </tr>
                      <tr>
                        <td>上仓水分</td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][0].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][1].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][2].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][3].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][4].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][5].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][6].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][7].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][8].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][9].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][10].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][11].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][12].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][13].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" :disabled="disabled"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[2].data[1][14].valueNumber">
                          </el-input>
                        </td>
                      </tr>
                      </tbody>
                    </table>
                  </div>
                </el-card>
              </el-col>
            </el-row>

            <el-row :gutter="10">
              <el-col :span="24">
                <el-card shadow="hover">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>大宗原料进出存(单位：吨)</span>
                  </div>
                  <div class="text item">
                    <table>
                      <thead>
                      <tr>
                        <th>物料</th>
                        <th>金布巴</th>
                        <th>妞曼粉</th>
                        <th>铁精粉</th>
                        <th>轻烧白云石</th>
                        <th>槽下返粉</th>
                        <th>杨迪粉</th>
                        <th>卡粉</th>
                        <th>巴西粉</th>
                        <th>麦克粉</th>
                        <th>焦粉</th>
                        <th>煤粉</th>
                        <th>球粉</th>
                        <th>来存精粉</th>
                        <th>除尘灰</th>
                      </tr>
                      </thead>
                      <tbody>
                      <tr>
                        <td>当日进厂</td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[0][0].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[0][1].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[0][2].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[0][3].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[0][4].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[0][5].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[0][6].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[0][7].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[0][8].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[0][9].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[0][10].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[0][11].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[0][12].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[0][13].valueNumber">
                          </el-input>
                        </td>
                      </tr>
                      <tr>
                        <td>当日出库</td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[1][0].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[1][1].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[1][2].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[1][3].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[1][4].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[1][5].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[1][6].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[1][7].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[1][8].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[1][9].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[1][10].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[1][11].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[1][12].valueNumber">
                          </el-input>
                        </td>
                        <td>
                          <el-input
                            class="input-width30"
                            size="mini"
                            placeholder="" disabled
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            v-model="assembleData.subTableDataList[3].data[1][13].valueNumber">
                          </el-input>
                        </td>
                      </tr>
                      </tbody>
                    </table>
                  </div>
                </el-card>
              </el-col>
            </el-row>
            <el-row :gutter="5">
              <el-col :span="16">
                <el-card shadow="hover" class="my-card">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>脱硫脱硝</span>
                  </div>
                  <div class="text item h120">
                    <el-row>
                      <el-col :span="8">
                        <el-form-item label="脱硫白灰消耗(t)">
                          <el-input
                            v-model="assembleData.subTableDataList[4].data[0].valueNumber"
                            oninput="value=value.replace(/[^0-9.]/g,'')"
                            suffix-icon="el-icon-edit"
                            :disabled="disabled"
                          >
                          </el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8">
                        <el-form-item label="氨水消耗(t)">
                          <el-input v-model="assembleData.subTableDataList[4].data[1].valueNumber"
                                    oninput="value=value.replace(/[^0-9.]/g,'')"
                                    suffix-icon="el-icon-edit"
                                    :disabled="disabled"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8">
                        <el-form-item label="煤气消耗(m³)" label-width="160px">
                          <el-input v-model="assembleData.subTableDataList[4].data[2].valueNumber"
                                    oninput="value=value.replace(/[^0-9.]/g,'')"
                                    suffix-icon="el-icon-edit"
                                    :disabled="disabled"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="8">
                        <el-form-item label="工艺水消耗(m³)">
                          <el-input v-model="assembleData.subTableDataList[4].data[3].valueNumber"
                                    oninput="value=value.replace(/[^0-9.]/g,'')"
                                    suffix-icon="el-icon-edit"
                                    :disabled="disabled"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8">
                        <el-form-item label="氮气消耗(m³)">
                          <el-input v-model="assembleData.subTableDataList[4].data[4].valueNumber"
                                    oninput="value=value.replace(/[^0-9.]/g,'')"
                                    suffix-icon="el-icon-edit"
                                    :disabled="disabled"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="8">
                        <el-form-item label="压缩空气消耗(m³)" label-width="160px">
                          <el-input v-model="assembleData.subTableDataList[4].data[5].valueNumber"
                                    oninput="value=value.replace(/[^0-9.]/g,'')"
                                    suffix-icon="el-icon-edit"
                                    :disabled="disabled"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                  </div>
                </el-card>
              </el-col>
              <el-col :span="8">
                <el-card shadow="hover">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>烧秸机能源消耗</span>
                  </div>
                  <div class="text item h120">
                    <el-row>
                      <el-col :span="12">
                        <el-form-item label="煤气消耗(m³)">
                          <el-input v-model="assembleData.subTableDataList[5].data[0].valueNumber"
                                    oninput="value=value.replace(/[^0-9.]/g,'')"
                                    suffix-icon="el-icon-edit"
                                    :disabled="disabled"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item label="电力消耗(kw.h)">
                          <el-input v-model="assembleData.subTableDataList[5].data[1].valueNumber"
                                    oninput="value=value.replace(/[^0-9.]/g,'')"
                                    suffix-icon="el-icon-edit"
                                    :disabled="disabled"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="12">
                        <el-form-item label="氮气消耗(m³)">
                          <el-input v-model="assembleData.subTableDataList[5].data[2].valueNumber"
                                    oninput="value=value.replace(/[^0-9.]/g,'')"
                                    suffix-icon="el-icon-edit"
                                    :disabled="disabled"
                          ></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item label="新水消耗(m³)">
                          <el-input v-model="assembleData.subTableDataList[5].data[3].valueNumber"
                                    oninput="value=value.replace(/[^0-9.]/g,'')"
                                    suffix-icon="el-icon-edit"
                                    :disabled="disabled"
                          ></el-input>
                        </el-form-item>
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
                      <el-col :span="12">
                        <el-form-item label="3#">
                          <el-input v-model="assembleData.subTableDataList[6].data[0].valueText"
                                    :disabled="disabled"
                                    type="textarea"></el-input>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item label="4#">
                          <el-input v-model="assembleData.subTableDataList[6].data[1].valueText"
                                    :disabled="disabled"
                                    type="textarea"></el-input>
                        </el-form-item>
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
          value: 7,
          label: '甲班'
        }, {
          value: 8,
          label: '乙班'
        }, {
          value: 9,
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
        shift: 7,
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
            "mainTableId": 4,
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
            "mainTableId": 4,
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
.h260{
  height: 260px;
}
</style>
