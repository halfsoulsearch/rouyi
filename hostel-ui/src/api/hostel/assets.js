import request from '@/utils/request'

// 查询资产档案列表
export function listAssets(query) {
  return request({
    url: '/hostel/assets/list',
    method: 'get',
    params: query
  })
}

// 查询资产档案详细
export function getAssets(id) {
  return request({
    url: '/hostel/assets/' + id,
    method: 'get'
  })
}

// 新增资产档案
export function addAssets(data) {
  return request({
    url: '/hostel/assets',
    method: 'post',
    data: data
  })
}

// 修改资产档案
export function updateAssets(data) {
  return request({
    url: '/hostel/assets',
    method: 'put',
    data: data
  })
}

// 删除资产档案
export function delAssets(id) {
  return request({
    url: '/hostel/assets/' + id,
    method: 'delete'
  })
}

// 导出资产档案
export function exportAssets(query) {
  return request({
    url: '/hostel/assets/export',
    method: 'get',
    params: query
  })
}
