import axiosIns from 'axios'

export const state = () => ({
  tourList: [],
  placeList: [],
})

const getters = {
  getTourList: (state) => state.tourList,
  getPlaceList: (state) => state.placeList,
}

const mutations = {
  setTourList: (state, payload) => {
    state.tourList = payload
  },
  setPlaceList: (state, payload) => {
    state.placeList = payload
  },
}

const actions = {
  async actionTourList({ commit }) {
    // let header = { headers: { Authorization: "Bearer " + useJwt.getToken() } }
    const data = await axiosIns.get('http://localhost:8089/api/v1/tours')
    if (data.status === 200) {
      console.log('ress===', data.data)
      commit('setTourList', data.data)
    }
  },
  async actionPlaceList({ commit }) {
    // let header = { headers: { Authorization: "Bearer " + useJwt.getToken() } }
    const data = await axiosIns.get('http://localhost:8089/api/v1/places')
    if (data.status === 200) {
      console.log('ress===', data.data)
      commit('setPlaceList', data.data)
    }
  },
}
export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations,
}
