import request from '@/utils/request'

// 查询班次列表
export function listDayReport(query) {
  return request({
    url: '/report/dayreport/list',
    method: 'get',
    params: query
  })
}

/*
// 查询班次详细
export function getShift(id) {
  return request({
    url: '/report/shift/' + id,
    method: 'get'
  })
}

// 新增班次
export function addShift(data) {
  return request({
    url: '/report/shift',
    method: 'post',
    data: data
  })
}

// 修改班次
export function updateShift(data) {
  return request({
    url: '/report/shift',
    method: 'put',
    data: data
  })
}

// 删除班次
export function delShift(id) {
  return request({
    url: '/report/shift/' + id,
    method: 'delete'
  })
}

// 导出班次
export function exportShift(query) {
  return request({
    url: '/report/shift/export',
    method: 'get',
    params: query
  })
}*/
