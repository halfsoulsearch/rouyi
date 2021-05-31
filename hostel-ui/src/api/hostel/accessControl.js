import request from '@/utils/request'

// 查询门禁设备列表
export function listAccessControl(query) {
  return request({
    url: '/hostel/accessControl/list',
    method: 'get',
    params: query
  })
}

// 查询门禁设备详细
export function getAccessControl(id) {
  return request({
    url: '/hostel/accessControl/' + id,
    method: 'get'
  })
}

// 新增门禁设备
export function addAccessControl(data) {
  return request({
    url: '/hostel/accessControl',
    method: 'post',
    data: data
  })
}

// 修改门禁设备
export function updateAccessControl(data) {
  return request({
    url: '/hostel/accessControl',
    method: 'put',
    data: data
  })
}

// 删除门禁设备
export function delAccessControl(id) {
  return request({
    url: '/hostel/accessControl/' + id,
    method: 'delete'
  })
}

// 导出门禁设备
export function exportAccessControl(query) {
  return request({
    url: '/hostel/accessControl/export',
    method: 'get',
    params: query
  })
}