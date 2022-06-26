import Vue from 'vue'
import Vuex from 'vuex'
import tour from './tour.js'
// Modules

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    tour,
  },
  strict: process.env.DEV,
})
