<template>
  <el-form label-width="160px">
    <CRow>
      <CCol>
        <el-form-item label="Id">
          <el-input type="number" v-model="guideDataUpdate.id" />
        </el-form-item>
      </CCol>
    </CRow>
    <CRow>
      <CCol>
        <el-form-item label="Họ và tên">
          <el-input v-model="guideDataUpdate.name" />
        </el-form-item>
      </CCol>
    </CRow>
    <CRow>
      <CCol>
        <el-form-item label="Số điện thoại">
          <el-input v-model="guideDataUpdate.phone" />
        </el-form-item>
      </CCol>
    </CRow>
    <CRow>
      <CCol>
        <el-form-item label="Địa chỉ">
          <el-input v-model="guideDataUpdate.address" />
        </el-form-item>
      </CCol>
    </CRow>
    <CRow style="margin-top: 20px">
      <CCol>
        <div style="float: right">
          <el-button type="danger" @click="closeDialogLog">Đóng</el-button>
          <el-button type="success">Lưu</el-button>
        </div>
      </CCol>
    </CRow>
  </el-form>
</template>

<script>
//import { mapGetters, mapActions } from 'vuex'
export default {
  props: {
    dataGuide: Object,
  },
  data() {
    return {
      guideUpdate: {},
    }
  },
  computed: {
    // ...mapGetters({
    //   placeListGet: 'tour/getPlaceList',
    //   getLandTourPriceById: 'tour/getLandPrice1TourList',
    //   getTourPriceById: 'tour/getTourPrice1TourList',
    //   getTourScheduleByTourId: 'tour/getTourScheduleList',
    //   getDiscountTour: 'tour/getDiscountTour',
    //   getListOrder: 'tour/getOrdersById',
    // }),
    guideDataUpdate() {
      return this.dataGuide
    },
  },
  created() {},

  methods: {
    // ...mapActions({
    //   actionPlaceList: 'tour/actionPlaceList',
    // }),
    onClickSearchOrdersByDate() {},
    closeDialogLog() {
      console.log('click')
      this.$emit('close-dialog', 'false')
    },
  },
}
</script>
<style scoped>
.scrollbar-demo-item {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 50px;
  margin: 10px;
  text-align: center;
  border-radius: 4px;
}
</style>
