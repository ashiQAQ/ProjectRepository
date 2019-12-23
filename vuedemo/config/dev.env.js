'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

//将环境变量配置为 development 开发环境
module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  MOCK: true
})
