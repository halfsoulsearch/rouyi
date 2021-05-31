import request from '@/utils/request'

// 查询班次列表
export function preCreate(query) {
  return request({
    url: '/report/assembleData/preCreate',
    method: 'get',
    params: query
  })
}

export function createOrUpdate(data) {
  return request({
    url: '/report/assembleData/createOrUpdate',
    method: 'post',
    data: data
  })
}

export function getData(data) {
  return request({
    url: '/report/assembleData/getData',
    method: 'get',
    params: data
  })
}
//获取球团日报表
export function getAnalysisData(data){
  return request({
    url: '/report/analysisData/get',
    method: 'get',
    params: data
  })
}
