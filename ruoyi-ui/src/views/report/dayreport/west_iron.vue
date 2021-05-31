<template>
  <div class="table-burn">
    <div class="container">
      <template>
        <el-card class="box-card" v-if="loaded">
          <div slot="header" class="clearfix">
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item>西区炼铁日报表</el-breadcrumb-item>
              <el-breadcrumb-item>录入</el-breadcrumb-item>
            </el-breadcrumb>

            <div class="header-btn">
              <el-button type="primary" icon="el-icon-finished" size="small" @click="onSubmit">提交</el-button>
              <el-button type="danger" plain icon="el-icon-document-checked" size="small">审核</el-button>
              <el-button type="default" plain icon="el-icon-back" size="small" @click="handleBack">返回</el-button>

            </div>
          </div>
          <el-form ref="form" :model="form" label-width="120px">
            <el-card shadow="hover" style="height: 75px;margin-bottom: 5px" class="my-card">
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
                <el-col :span="2">
                  <el-form-item label="报表状态：">
                    <el-tag type="warning" effect="plain">编辑</el-tag>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-card>
            <!-- 基础数据 -->
            <el-row :gutter="10">
              <el-col :span="24">
                <el-card shadow="hover" class="my-card h338">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>基础数据</span>
                  </div>
                  <div class="text item">
                    <table>
                      <thead>
                        <tr>
                          <th>单 位</th>
                          <th>产量(吨)</th>
                          <th>休风时间(分)</th>
                          <th>TRT发电(KWH)</th>
                          <th>实际用电(KWH)</th>
                          <th>总氧量(m³)</th>
                          <th>总风量(m³)</th>
                          <th>风压()</th>
                          <th>顶压</th>
                          <th>风温</th>
                          <th>顶温</th>
                          <th>Si</th>
                          <th>S</th>
                          <th>渣铁</th>
                          <th>水渣</th>
                          <th>炉渣</th>
                          <th>炉渣1</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>1#高炉</td>
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
                              v-model="assembleData.subTableDataList[0].data[0][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[0][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[0][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[0][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[0][5].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[0][6].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[0][7].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[0][8].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[0][9].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[0][10].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[0][11].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[0][12].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[0][13].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[0][14].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[0][15].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>2#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][0].valueNumber">
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
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][5].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][6].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][7].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][8].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][9].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][10].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][11].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][12].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][13].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][14].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[1][15].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>3#高炉</td>
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
                              v-model="assembleData.subTableDataList[0].data[2][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[2][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[2][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[2][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[2][5].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[2][6].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[2][7].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[2][8].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[2][9].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[2][10].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[2][11].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[2][12].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[2][13].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[2][14].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[2][15].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>4#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][5].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][6].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][7].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][8].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][9].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][10].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][11].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][12].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][13].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][14].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[0].data[3][15].valueNumber">
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
                <el-card shadow="hover" class="my-card h338">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>质量指标</span>
                  </div>
                  <div class="text item">
                    <table>
                      <thead>
                        <tr>
                          <th>单 位</th>
                          <th>烧结矿(品味%)</th>
                          <th>球团矿(品味%)</th>
                          <th>块矿(品味%)</th>
                          <th>烧结矿(配比%)</th>
                          <th>球团矿(配比%)</th>
                          <th>块矿(配比%)</th>
                          <th>烧结矿</th>
                          <th>球团矿</th>
                          <th>块矿</th>
                          <th>FMG筛后块</th>
                          <th>水渣铁</th>
                          <th>扒炉料</th>
                          <th>杂料筛块</th>
                          <th>废钢</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>1#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[0][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[0][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[0][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[0][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[0][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[0][5].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[0][6].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[0][7].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[0][8].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[0][9].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[0][10].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[0][11].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[0][12].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[0][13].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>2#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[1][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[1][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[1][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[1][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[1][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[1][5].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[1][6].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[1][7].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[1][8].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[1][9].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[1][10].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[1][11].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[1][12].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[1][13].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>3#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[2][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[2][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[2][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[2][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[2][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[2][5].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[2][6].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[2][7].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[2][8].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[2][9].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[2][10].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[2][11].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[2][12].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[2][13].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>4#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[3][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[3][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[3][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[3][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[3][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[3][5].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[3][6].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[3][7].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[3][8].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[3][9].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[3][10].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[3][11].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[3][12].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[1].data[3][13].valueNumber">
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
                <el-card shadow="hover" class="my-card h338">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>原料指标</span>
                  </div>
                  <div class="text item">
                    <table>
                      <thead>
                        <tr>
                          <td>单位</td>
                          <td>干熄基</td>
                          <td>干焦基</td>
                          <td>湿焦</td>
                          <td>二级焦</td>
                          <td>焦丁</td>
                          <td>无烟煤</td>
                          <td>烟煤</td>
                          <td>莹石</td>
                          <td>锰矿</td>
                          <td>白云石</td>
                          <td>高炉返矿</td>
                          <td>球团返粉</td>
                          <td>块矿返粉</td>
                          <td>返焦粉</td>
                          <td>返焦丁</td>
                          <td>除尘灰</td>
                          <td>内部废钢</td>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>1#高炉</td>
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
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[0][15].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[0][16].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>2#高炉</td>
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
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[1][15].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[1][16].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>3#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][5].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][6].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][7].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][8].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][9].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][10].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][11].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][12].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][13].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][14].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][15].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[2][16].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>4#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][5].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][6].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][7].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][8].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][9].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][10].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][11].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][12].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][13].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][14].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][15].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[2].data[3][16].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </el-card>
              </el-col>
            </el-row>

            <el-row :gutter="10" class="mt5">
              <el-col :span="14">
                <el-card shadow="hover" class="my-card h223">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>大宗原料进出存(单位:吨)</span>
                  </div>
                  <div class="text item h120">
                      <table>
                        <thead>
                          <tr>
                            <td>单位</td>
                            <td>干熄焦</td>
                            <td>干基焦</td>
                            <td>湿焦</td>
                            <td>二级焦</td>
                            <td>无烟煤</td>
                            <td>烟煤</td>
                            <td>烧结矿</td>
                            <td>球团矿</td>
                            <td>纽曼块</td>
                            <td>FMG块</td>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>当日进厂</td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[0][0].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[0][1].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[0][2].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[0][3].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[0][4].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[0][5].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[0][6].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[0][7].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[0][8].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[0][9].valueNumber">
                              </el-input>
                            </td>
                          </tr>
                          <tr>
                            <td>当日出库</td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[1][0].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[1][1].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[1][2].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[1][3].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[1][4].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[1][5].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[1][6].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[1][7].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[1][8].valueNumber">
                              </el-input>
                            </td>
                            <td>
                              <el-input
                                class="input-width30"
                                size="mini"
                                placeholder="" :disabled="disabled"
                                oninput="value=value.replace(/[^0-9.]/g,'')"
                                v-model="assembleData.subTableDataList[3].data[1][9].valueNumber">
                              </el-input>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                  </div>
                </el-card>
              </el-col>
              <el-col :span="10">
                <el-card shadow="hover" class="my-card h223">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>上仓水分（%）</span>
                  </div>
                  <div class="text item h120">
                    <table>
                      <thead>
                        <tr>
                          <td>单位</td>
                          <td>干熄焦</td>
                          <td>干基焦</td>
                          <td>湿焦</td>
                          <td>二级焦</td>
                          <td>无烟煤</td>
                          <td>烟煤</td>
                          <td>烧结矿</td>
                          <td>球团矿</td>
                          <td>纽曼块</td>
                          <td>FMG块</td>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>1#2#3#</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[4].data[0][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[4].data[0][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[4].data[0][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[4].data[0][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[4].data[0][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[4].data[0][5].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[4].data[0][6].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[4].data[0][7].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[4].data[0][8].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[4].data[0][9].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </el-card>
              </el-col>
            </el-row>

            <el-row :gutter="10" class="mt5">
              <el-col :span="14">
                <el-card shadow="hover" class="my-card h338">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>炉渣成份（%）</span>
                  </div>
                  <div class="text item h140">
                    <table>
                      <thead>
                        <tr>
                          <td>单位</td>
                          <td>CaO</td>
                          <td>SiO</td>
                          <td>MgO</td>
                          <td>Al2O3</td>
                          <td>S</td>
                          <td>R</td>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>1#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[0][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[0][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[0][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[0][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[0][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[0][5].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>2#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[1][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[1][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[1][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[1][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[1][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[1][5].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>3#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[2][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[2][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[2][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[2][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[2][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[2][5].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>4#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[3][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[3][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[3][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[3][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[3][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[5].data[3][5].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </el-card>
              </el-col>
              <el-col :span="10">
                <el-card shadow="hover" class="my-card h338">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>仓位(单位：吨)</span>
                  </div>
                  <div class="text item h140">
                    <table>
                      <thead>
                        <tr>
                          <td>单位</td>
                          <td>烧结矿</td>
                          <td>球团矿</td>
                          <td>纽曼块</td>
                          <td>FMG块</td>
                          <td>焦炭</td>
                          <td>焦丁</td>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>1#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[0][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[0][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[0][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[0][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[0][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[0][5].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>2#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[1][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[1][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[1][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[1][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[1][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[1][5].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>3#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[2][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[2][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[2][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[2][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[2][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[2][5].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                        <tr>
                          <td>4#高炉</td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[3][0].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[3][1].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[3][2].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[3][3].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[3][4].valueNumber">
                            </el-input>
                          </td>
                          <td>
                            <el-input
                              class="input-width30"
                              size="mini"
                              placeholder="" :disabled="disabled"
                              oninput="value=value.replace(/[^0-9.]/g,'')"
                              v-model="assembleData.subTableDataList[6].data[3][5].valueNumber">
                            </el-input>
                          </td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </el-card>
              </el-col>
            </el-row>
            <el-row :gutter="10" class="mt5">
              <el-col :span="24">
                <el-card shadow="hover">
                  <div slot="header" class="clearfix">
                    <i class="el-icon-s-data"></i>
                    <span>生产记事</span>
                  </div>
                  <div class="text item">
                    <el-row>
                      <el-col :span="24">
                        <el-input v-model="assembleData.subTableDataList[7].data.valueText" type="textarea"
                                  :disabled="disabled"></el-input>
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
        shift: -1
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
            "mainTableId": 5,
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
  border-bottom: 1px;
}

.input-width120 {
  width: 120px;
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
.h223{
  height: 223px;
}
.h338{
  height: 338px;
}
</style>
