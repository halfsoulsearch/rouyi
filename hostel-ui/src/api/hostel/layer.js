import request from '@/utils/request'

// 查询宿舍楼层档案列表
export function listLayer(query) {
  return request({
    url: '/hostel/layer/list',
    method: 'get',
    params: query
  })
}

// 查询宿舍楼层档案详细
export function getLayer(id) {
  return request({
    url: '/hostel/layer/' + id,
    method: 'get'
  })
}

// 新增宿舍楼层档案
export function addLayer(data) {
  return request({
    url: '/hostel/layer',
    method: 'post',
    data: data
  })
}

// 修改宿舍楼层档案
export function updateLayer(data) {
  return request({
    url: '/hostel/layer',
    method: 'put',
    data: data
  })
}

// 删除宿舍楼层档案
export function delLayer(id) {
  return request({
    url: '/hostel/layer/' + id,
    method: 'delete'
  })
}

// 导出宿舍楼层档案
export function exportLayer(query) {
  return request({
    url: '/hostel/layer/export',
    method: 'get',
    params: query
  })
}