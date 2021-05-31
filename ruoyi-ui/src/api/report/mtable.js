import request from '@/utils/request'

// 查询主的配置列表
export function listMtable(query) {
  return request({
    url: '/report/mtable/list',
    method: 'get',
    params: query
  })
}

// 查询主的配置详细
export function getMtable(id) {
  return request({
    url: '/report/mtable/' + id,
    method: 'get'
  })
}

// 新增主的配置
export function addMtable(data) {
  return request({
    url: '/report/mtable',
    method: 'post',
    data: data
  })
}

// 修改主的配置
export function updateMtable(data) {
  return request({
    url: '/report/mtable',
    method: 'put',
    data: data
  })
}

// 删除主的配置
export function delMtable(id) {
  return request({
    url: '/report/mtable/' + id,
    method: 'delete'
  })
}

// 导出主的配置
export function exportMtable(query) {
  return request({
    url: '/report/mtable/export',
    method: 'get',
    params: query
  })
}