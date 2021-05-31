import request from '@/utils/request'

// 查询类型组列表
export function listGroup(query) {
  return request({
    url: '/hostel/group/list',
    method: 'get',
    params: query
  })
}

// 查询类型组详细
export function getGroup(baseTypeId) {
  return request({
    url: '/hostel/group/' + baseTypeId,
    method: 'get'
  })
}

// 新增类型组
export function addGroup(data) {
  return request({
    url: '/hostel/group',
    method: 'post',
    data: data
  })
}

// 修改类型组
export function updateGroup(data) {
  return request({
    url: '/hostel/group',
    method: 'put',
    data: data
  })
}

// 删除类型组
export function delGroup(baseTypeId) {
  return request({
    url: '/hostel/group/' + baseTypeId,
    method: 'delete'
  })
}

// 导出类型组
export function exportGroup(query) {
  return request({
    url: '/hostel/group/export',
    method: 'get',
    params: query
  })
}