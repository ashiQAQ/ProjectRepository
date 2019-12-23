import Mock from 'mockjs'

let appData = require('./data.json')
let seller = appData.seller
let goods = appData.goods
let ratings = appData.ratings

Mock.setup({
  timeout: '200 - 400'
})
Mock.mock('/api/goods', 'get', goods)
Mock.mock('/api/seller', 'get', seller)
Mock.mock('/api/ratings', 'get', ratings)
