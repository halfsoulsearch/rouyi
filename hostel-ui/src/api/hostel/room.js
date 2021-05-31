import request from '@/utils/request'




// 查询房间档案列表
export function listRoom(query) {
  return request({
    url: '/hostel/room/searchBaseRoom',
    method: 'post',
    data: query
  })
}

// 查询房间档案详细
export function getRoom(id) {
  return request({
    url: '/hostel/room/' + id,
    method: 'get'
  })
}

// 新增房间档案
export function addRoom(data) {
  return request({
    url: '/hostel/room/saveRoom',
    method: 'post',
    data: data
  })
}

// 修改房间档案
export function updateRoom(data) {
  return request({
    url: '/hostel/room',
    method: 'put',
    data: data
  })
}

// 删除房间档案
export function delRoom(id) {
  return request({
    url: '/hostel/room/' + id,
    method: 'delete'
  })
}

// 导出房间档案
export function exportRoom(query) {
  return request({
    url: '/hostel/room/export',
    method: 'get',
    params: query
  })
}
