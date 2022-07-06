const state = {
    objSearch: null
}

// getters
const getters = {
    getObjSearch: (state) => {
        // let result = []
        // state.resOperationManuals.filter((item) => {
        //     result.push(item)
        // })
        return state.objSearch
    },

}

// mutations
const mutations = {
    setObjSearch: (state, payload) => {
        state.objSearch = {
            startPlace: payload.startPlace,
            endPlace: payload.endPlace,
            startDate: payload.startDate,
            numOfDay: payload.numOfDay
        }
    },

}
// actions
const actions = {
    setObjSearch({ commit }, filter) {
        commit('setObjSearch', filter)
        console.log(filter)
    }
    // async exportData({ commit }, filter) {
    //     return axios.get(`${apiURL._API_URL}res-operation-manual/export/excel?fromDate=${filter.fromDate}&toDate=${filter.toDate}?riverBasin=${filter.riverBasin}&river=${filter.river}&reservoir=${filter.reservoir}&fileType=${filter.fileType}`, { responseType: 'blob' })

    // },
    // async getFileTemplate({ commit }) {
    //     return axios.get(`${apiURL._API_URL}res-operation-manual/file-template`, { responseType: 'blob' })

    // },
    // async importFile({ commit }, item) {
    //     return axios.post(`${apiURL._API_URL}res-operation-manual/import`, item, { responseType: 'blob' })
    // },

}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}