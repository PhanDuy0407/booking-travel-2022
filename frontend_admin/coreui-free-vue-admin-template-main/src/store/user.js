import axiosIns from 'axios'

export const state = () => ({
  userList: [],
})
const getters = {
  getUserList: (state) => state.userList,
}
const mutations = {
  setUserList: (state, payload) => {
    state.userList = payload
  },
}
const actions = {
  async actionUserList({ commit }) {
    // let header = { headers: { Authorization: "Bearer " + useJwt.getToken() } }
    const data = await axiosIns.get(`
    http://localhost:8089/api/v1/users`)
    if (data.status === 200) {
      console.log('ress===', data.data)
      commit('setUserList', data.data)
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
