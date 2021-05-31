<template>
    <div class="container">
      <div class="dashboard-editor-container">
        <el-row :gutter="40" class="panel-group">

          <el-col :xs="12" :sm="12" :lg="4" class="card-panel-col" v-for="selReport in mtableList" :key="selReport.id">
            <div class="card-panel" @click="">
              <div class="card-panel-icon-wrapper icon-people">
                <svg-icon icon-class="excel" class-name="card-panel-icon" />
              </div>
              <div class="card-panel-description">
                <div class="card-panel-text"> {{selReport.name}}</div>
                <el-link icon="el-icon-view" type="info"
                         :underline="false" @click="reportDetail(selReport.url)">查看</el-link>
              </div>
            </div>
          </el-col>

        </el-row>
      </div>
    </div>
</template>

<script>
  import { listMtable} from "@/api/report/mtable";
  import {getData, preCreate} from "@/api/report/assembleData";
  export default {
      name: "index",
      data() {
        return {
          // 遮罩层
          loading: true,
          // 主报表的配置表格数据
          mtableList: [],
        }
      },
      created() {
        listMtable().then(response=>{
          this.mtableList = response.rows
        });
      },
      methods:{
        reportDetail(url){
          console.log("/analisys/analisys-"+url)
          this.$router.push({path:"/analisys/analisys-"+url})
        },

      }
  }
</script>

<style scoped lang="scss">
.dashboard-editor-container {
    border: 1px solid #e5e3e3;
    border-radius: 5px;
    margin: 10px;
    padding: 32px;
    background-color: rgba(206, 212, 229, 0.09);
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
    background: #f9f7f7;
    box-shadow: 4px 4px 40px rgba(0, 0, 0, 0.05);
    border: 1px solid #e2e1e1;
    border-radius: 5px;
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
