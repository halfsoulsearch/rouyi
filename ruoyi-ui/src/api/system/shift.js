import request from '@/utils/request'

// 查询班次列表
export function listShift(query) {
  return request({
    url: '/system/shift/list',
    method: 'get',
    params: query
  })
}

// 查询班次详细
export function getShift(id) {
  return request({
    url: '/system/shift/' + id,
    method: 'get'
  })
}

// 新增班次
export function addShift(data) {
  return request({
    url: '/system/shift',
    method: 'post',
    data: data
  })
}

// 修改班次
export function updateShift(data) {
  return request({
    url: '/system/shift',
    method: 'put',
    data: data
  })
}

// 删除班次
export function delShift(id) {
  return request({
    url: '/system/shift/' + id,
    method: 'delete'
  })
}

// 导出班次
export function exportShift(query) {
  return request({
    url: '/system/shift/export',
    method: 'get',
    params: query
  })
}