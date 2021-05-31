<template>
  <div class="app-container home">
    <div class="dashboard-editor-container">

      <el-row :gutter="40" class="panel-group">
        <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
          <div class="card-panel" @click="handleSetLineChartData('newVisitis')">
            <div class="card-panel-icon-wrapper icon-people">
              <svg-icon icon-class="peoples" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">用户数量</div>
              <count-to :start-val="0" :end-val="userTotal" :duration="2600" class="card-panel-num"/>
            </div>
          </div>
        </el-col>
        <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
          <div class="card-panel" @click="handleSetLineChartData('messages')">
            <div class="card-panel-icon-wrapper icon-message">
              <svg-icon icon-class="message" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">报表数量</div>
              <count-to :start-val="0" :end-val="goodsTotal" :duration="3000" class="card-panel-num"/>
            </div>
          </div>
        </el-col>
        <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
          <div class="card-panel" @click="handleSetLineChartData('purchases')">
            <div class="card-panel-icon-wrapper icon-money">
              <svg-icon icon-class="message" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">数量</div>
              <count-to :start-val="0" :end-val="productTotal" :duration="3200" class="card-panel-num"/>
            </div>
          </div>
        </el-col>
        <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
          <div class="card-panel" @click="handleSetLineChartData('shoppings')">
            <div class="card-panel-icon-wrapper icon-shoppingCard">
              <svg-icon icon-class="money" class-name="card-panel-icon" />
            </div>
            <div class="card-panel-description">
              <div class="card-panel-text">数量</div>
              <count-to :start-val="0" :end-val="orderTotal" :duration="3600" class="card-panel-num"/>
            </div>
          </div>
        </el-col>
      </el-row>

      <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
        <line-chart :chart-data="userOrderCnt" />
      </el-row>

      <el-row :gutter="32">
        <el-col :xs="24" :sm="24" :lg="16">
          <div class="chart-wrapper">
            <bar-chart :chart-data="orderAmts"/>
          </div>
        </el-col>
        <el-col :xs="24" :sm="24" :lg="8">
          <div class="chart-wrapper">
            <pie-chart :chart-data="categorySell"/>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import { info, chart } from '@/api/report/dashboard'
import CountTo from 'vue-count-to'
import LineChart from './dashboard/LineChart'
import PieChart from './dashboard/PieChart'
import BarChart from './dashboard/BarChart'

export default {
  name: "index",
  components: {
    CountTo,
    LineChart,
    PieChart,
    BarChart
  },
  data() {
    return {
      userTotal: 0,
      goodsTotal: 0,
      productTotal: 0,
      orderTotal: 0,
      userOrderCnt: { dayData: [], userCnt: [], orderCnt: [] },
      orderAmts: { dayData: [], orderAmtData: [], orderCntData: [] },
      categorySell: { categoryNames: [], categorySellData: [] },
      // 版本号
      version: "3.4.0",
    };
  },
  created() {
   /* chart().then(response => {
      this.userOrderCnt = response.data.data.userOrderCnt
      this.orderAmts = response.data.data.orderAmts
      this.categorySell = response.data.data.categorySell
    })
    info().then(response => {
      this.userTotal = response.data.data.userTotal
      this.goodsTotal = response.data.data.goodsTotal
      this.productTotal = response.data.data.productTotal
      this.orderTotal = response.data.data.orderTotal
    })*/
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
    handleSetLineChartData(type) {
      this.$emit('handleSetLineChartData', type)
    }
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}

.dashboard-editor-container {
  padding: 32px;
  background-color: rgb(240, 242, 245);
  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }
}

.panel-group {
  margin-top: 18px;

  .card-panel-col{
    margin-bottom: 32px;
  }
  .card-panel {
    height: 108px;
    cursor: pointer;
    font-size: 12px;
    position: relative;
    overflow: hidden;
    color: #666;
    background: #fff;
    box-shadow: 4px 4px 40px rgba(0, 0, 0, .05);
    border-color: rgba(0, 0, 0, .05);
    &:hover {
      .card-panel-icon-wrapper {
        color: #fff;
      }
      .icon-people {
        background: #40c9c6;
      }
      .icon-message {
        background: #36a3f7;
      }
      .icon-money {
        background: #f4516c;
      }
      .icon-shoppingCard {
        background: #34bfa3
      }
    }
    .icon-people {
      color: #40c9c6;
    }
    .icon-message {
      color: #36a3f7;
    }
    .icon-money {
      color: #f4516c;
    }
    .icon-shoppingCard {
      color: #34bfa3
    }
    .card-panel-icon-wrapper {
      float: left;
      margin: 14px 0 0 14px;
      padding: 16px;
      transition: all 0.38s ease-out;
      border-radius: 6px;
    }
    .card-panel-icon {
      float: left;
      font-size: 48px;
    }
    .card-panel-description {
      float: right;
      font-weight: bold;
      margin: 26px;
      margin-left: 0px;
      .card-panel-text {
        line-height: 18px;
        color: rgba(0, 0, 0, 0.45);
        font-size: 16px;
        margin-bottom: 12px;
      }
      .card-panel-num {
        font-size: 20px;
      }
    }
  }
}
</style>

