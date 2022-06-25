<template>
  <el-form label-width="150px">
    <CRow>
      <CCol>
        <el-form-item label="Mã code">
          <el-input v-model="tourDataDetail.code" disabled="true" />
        </el-form-item>
      </CCol>
      <CCol>
        <el-form-item label="Tên tour">
          <el-input v-model="tourDataDetail.name" disabled="true" />
        </el-form-item>
      </CCol>
    </CRow>
    <CRow>
      <CCol>
        <el-form-item label="Thời gian bắt đầu">
          <el-input
            v-model="tourDataDetail.startTime"
            type="date"
            disabled="true"
          />
        </el-form-item>
      </CCol>
      <CCol>
        <el-form-item label="Khoảng thời gian">
          <el-input v-model="tourDataDetail.period" disabled="true" />
        </el-form-item>
      </CCol>
    </CRow>
    <CRow>
      <CCol>
        <el-form-item label="Địa điểm bắt đầu">
          <el-select
            v-model="tourDataDetail.startPlaceId"
            class="m-2"
            placeholder="Select"
            size="large"
          >
            <el-option
              v-for="item in placeListGet"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
      </CCol>
      <CCol>
        <el-form-item label="Địa điểm kết thúc">
          <el-select
            v-model="tourDataDetail.endPlaceId"
            class="m-2"
            placeholder="Select"
            size="large"
          >
            <el-option
              v-for="item in placeListGet"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
      </CCol>
    </CRow>
    <CRow>
      <CCol>
        <el-form-item label="URL ảnh">
          <el-input v-model="tourDataDetail.mainImageUrl" disabled="true" />
        </el-form-item>
      </CCol>
    </CRow>
    <CRow>
      <CCol>
        <el-form-item label="Mô tả">
          <el-input
            type="textarea"
            v-model="tourDataDetail.shortDesc"
            :rows="6"
            disabled="true"
          />
        </el-form-item>
      </CCol>
    </CRow>
  </el-form>
</template>

<script>
import { mapGetters, mapActions } from 'vuex'
export default {
  props: {
    tourData: Object,
  },
  data() {
    return {
      tourDataDetail: {},
    }
  },
  computed: {
    ...mapGetters({ placeListGet: 'tour/getPlaceList' }),
  },
  created() {
    this.actionPlaceList()
    this.tourDataDetail = Object.assign({}, this.tourData)
    ;(this.tourDataDetail.startTime = this.getFormattedDate(
      new Date(this.tourDataDetail.startTime),
    )),
      console.log(this.tourDataDetail.startTime)
  },
  methods: {
    ...mapActions({
      actionPlaceList: 'tour/actionPlaceList',
    }),
    getFormattedDate(date) {
      let year = date.getFullYear()
      let month = (1 + date.getMonth()).toString().padStart(2, '0')
      let day = date.getDate().toString().padStart(2, '0')

      return year + '-' + month + '-' + day
    },
  },
}
</script>
