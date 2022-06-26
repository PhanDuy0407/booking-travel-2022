<template>
  <div>
    <el-button
      @click="handleAddClick"
      type="primary"
      style="margin-bottom: 20px"
      >Thêm mới</el-button
    >
    <el-table :data="list" stripe border style="width: 100%">
      <el-table-column fixed prop="name" label="Tên Tour" />
      <el-table-column prop="startTime" label="Thời gian bắt đầu">
        <template #default="scope">
          {{ getFormattedDate(new Date(scope.row.startTime)) }}
        </template>
      </el-table-column>
      <el-table-column prop="period" label="Khoảng thời gian" />
      <el-table-column prop="mainImageUrl" label="Link ảnh" />
      <el-table-column prop="placeOrderMax" label="Giới hạn đặt" />
      <el-table-column prop="status" label="Trạng thái" />
      <el-table-column fixed="right" label="Thao tác">
        <template #default="scope">
          <el-button
            link
            type="primary"
            size="small"
            @click="handleDetailClick(scope.row)"
            >Detail</el-button
          >
          <el-button link type="primary" size="small" @click="handleUpdateClick"
            >Edit</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-dialog
      v-model="dialogDetailVisible"
      title="Thông tin chi tiết Tour"
      width="80%"
    >
      <detail-tour :tourData="dataTour"></detail-tour>
    </el-dialog>
    <el-dialog v-model="dialogUpdateVisible" title="Cập nhật thông tin Tour">
      <UpdateTour></UpdateTour>
    </el-dialog>
    <el-dialog v-model="dialogAddVisible" title="Thêm mới Tour">
      <AddTour></AddTour>
    </el-dialog>
  </div>
</template>
<script>
import { mapGetters, mapActions } from 'vuex'
import DetailTour from './DetailTour.vue'
import AddTour from './AddTour.vue'
import UpdateTour from './UpdateTour.vue'
export default {
  components: { DetailTour, AddTour, UpdateTour },
  name: 'Quản lý Tour',
  data() {
    return {
      list: [],
      index: 0,
      dialogDetailVisible: false,
      dialogAddVisible: false,
      dialogUpdateVisible: false,
      dataTour: {
        id: null,
        name: '',
        shortDesc: '',
        startTime: '',
        period: '',
        startPlaceId: null,
        endPlaceId: null,
        mainImageUrl: '',
        guideId: null,
        placeOrderMax: null,
        code: '',
        status: null,
      },
    }
  },
  created() {
    this.getData()
  },
  computed: {
    ...mapGetters({ tourListGet: 'tour/getTourList' }),
  },
  methods: {
    ...mapActions({
      actionTourList: 'tour/actionTourList',
    }),
    add() {
      this.index++
    },
    getFormattedDate(date) {
      let year = date.getFullYear()
      let month = (1 + date.getMonth()).toString().padStart(2, '0')
      let day = date.getDate().toString().padStart(2, '0')

      return month + '/' + day + '/' + year
    },
    async getData() {
      await this.actionTourList()
      this.list = this.tourListGet
      console.log(this.list[0].name)
    },
    handleDetailClick(data) {
      this.dialogDetailVisible = true
      this.dataTour = Object.assign({}, data)
      console.log(this.dataTour)
    },
    handleUpdateClick() {
      this.dialogUpdateVisible = true
    },
    handleAddClick() {
      this.dialogAddVisible = true
    },
  },
}
</script>
