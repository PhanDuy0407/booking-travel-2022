import axiosIns from 'axios'

export const state = () => ({
  guideList: [],
})
const getters = {
  getGuideList: (state) => state.guideList,
}
const mutations = {
  setGuideList: (state, payload) => {
    state.guideList = payload
  },
}
const actions = {
  async actionGuideList({ commit }, objectSearch) {
    // let header = { headers: { Authorization: "Bearer " + useJwt.getToken() } }
    const data = await axiosIns.get(`
    http://localhost:8089/api/v1/guides?nameGuide=${objectSearch.nameGuide}&phoneGuide=${objectSearch.phoneGuide}`)
    if (data.status === 200) {
      console.log('ress===', data.data)
      commit('setGuideList', data.data)
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
