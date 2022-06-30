import axiosIns from 'axios'

export const state = () => ({
  tourList: [],
  placeList: [],
  tourScheduleList: [],
  landprice1Tour: {},
  tourprice1Tour: {},
  discountTour: {},
  ordersById: [],
})

const getters = {
  getTourList: (state) => state.tourList,
  getPlaceList: (state) => state.placeList,
  getTourScheduleList: (state) => state.tourScheduleList,
  getLandPrice1TourList: (state) => state.landprice1Tour,
  getTourPrice1TourList: (state) => state.tourprice1Tour,
  getDiscountTour: (state) => state.discountTour,
  getOrdersById: (state) => state.ordersById,
}

const mutations = {
  setTourList: (state, payload) => {
    state.tourList = payload
  },
  setPlaceList: (state, payload) => {
    state.placeList = payload
  },
  setTourScheduleList: (state, payload) => {
    state.tourScheduleList = payload
  },
  setLandPrice1TourList: (state, payload) => {
    state.landprice1Tour = payload
  },
  setTourPrice1TourList: (state, payload) => {
    state.tourprice1Tour = payload
  },
  setDiscountTour: (state, payload) => {
    state.discountTour = payload
  },
  setOrdersById: (state, payload) => {
    state.ordersById = payload
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

  async actionGetLandPrice1TourList({ commit }, id) {
    // let header = { headers: { Authorization: "Bearer " + useJwt.getToken() } }
    const data = await axiosIns.get(`
    http://localhost:8089/api/v1/land-tour-price/${id}`)
    if (data.status === 200) {
      commit('setLandPrice1TourList', data.data)
    }
  },

  async actionGetDiscountTour({ commit }, id) {
    // let header = { headers: { Authorization: "Bearer " + useJwt.getToken() } }
    const data = await axiosIns.get(`
    http://localhost:8089/api/v1/discount/${id}`)
    if (data.status === 200) {
      commit('setDiscountTour', data.data)
    }
  },

  async actionGetTourPrice1TourList({ commit }, id) {
    // let header = { headers: { Authorization: "Bearer " + useJwt.getToken() } }
    const data = await axiosIns.get(`
    http://localhost:8089/api/v1/tour-price/${id}`)
    if (data.status === 200) {
      commit('setTourPrice1TourList', data.data)
    }
  },

  async actionGetTourScheduleList({ commit }, id) {
    // let header = { headers: { Authorization: "Bearer " + useJwt.getToken() } }
    const data = await axiosIns.get(`
    http://localhost:8089/api/v1/tour-schedule/${id}`)
    if (data.status === 200) {
      commit('setTourScheduleList', data.data)
    }
  },

  async actionGetOrdersByTourId({ commit }, id) {
    // let header = { headers: { Authorization: "Bearer " + useJwt.getToken() } }
    const data = await axiosIns.get(`
    http://localhost:8089/api/v1/tour-orders/${id}`)
    if (data.status === 200) {
      commit('setOrdersById', data.data)
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
