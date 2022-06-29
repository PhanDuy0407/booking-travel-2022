import Vue from 'vue'
import Vuex from 'vuex'

import tourList from './modules/tour_list'

Vue.use(Vuex)

export default new Vuex.Store({
    modules: {
        tourList
    },
    // strict: process.env.DEV,
})
