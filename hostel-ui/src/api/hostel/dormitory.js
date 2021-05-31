import request from '@/utils/request'

// 查询宿舍楼档案列表
export function listDormitory(query) {
  return request({
    url: '/hostel/dormitory/list',
    method: 'get',
    params: query
  })
}

// 查询宿舍楼档案详细
export function getDormitory(id) {
  return request({
    url: '/hostel/dormitory/' + id,
    method: 'get'
  })
}

// 新增宿舍楼档案
export function addDormitory(data) {
  return request({
    url: '/hostel/dormitory',
    method: 'post',
    data: data
  })
}

// 修改宿舍楼档案
export function updateDormitory(data) {
  return request({
    url: '/hostel/dormitory',
    method: 'put',
    data: data
  })
}

// 删除宿舍楼档案
export function delDormitory(id) {
  return request({
    url: '/hostel/dormitory/' + id,
    method: 'delete'
  })
}

// 导出宿舍楼档案
export function exportDormitory(query) {
  return request({
    url: '/hostel/dormitory/export',
    method: 'get',
    params: query
  })
}