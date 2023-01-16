'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  // VUE_APP_URL:'"http://192.168.1.2:8888/"'
  VUE_APP_URL:'"http://localhost:8888/"'
})
