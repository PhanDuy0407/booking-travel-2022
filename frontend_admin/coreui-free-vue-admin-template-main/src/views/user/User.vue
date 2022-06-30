<template>
  <div>
    <el-form label-width="160px">
      <CRow>
        <CCol>
          <el-form-item label="Id">
            <el-input type="number" v-model="objectSearch.id" />
          </el-form-item>
        </CCol>
        <CCol>
          <el-form-item label="Tên đăng nhập">
            <el-input v-model="objectSearch.username" />
          </el-form-item>
        </CCol>
      </CRow>
      <CRow>
        <CCol>
          <el-form-item label="Cấp độ người dùng">
            <el-input v-model="objectSearch.rank" />
          </el-form-item>
        </CCol>
        <CCol>
          <el-form-item label="Trạng thái">
            <el-input v-model="objectSearch.status" />
          </el-form-item>
        </CCol>
      </CRow>
      <CRow style="margin-bottom: 20px">
        <CCol style="text-align: center">
          <el-button type="primary">Tìm kiếm</el-button>
        </CCol>
      </CRow>
    </el-form>

    <el-table :data="displayUserData" style="width: 100%">
      <el-table-column fixed prop="id" label="Id" width="50" />
      <el-table-column prop="username" label="Tên đăng nhập" width="120" />
      <el-table-column prop="fullname" label="Họ và tên" width="120" />
      <el-table-column prop="email" label="Email" width="120" />
      <el-table-column prop="address" label="Địa chỉ" width="120" />
      <el-table-column prop="dob" label="Ngày sinh" width="120" />
      <el-table-column prop="gender" label="Giới tính" width="120" />
      <el-table-column prop="password" label="Mật khẩu" width="120" />
      <el-table-column prop="createdDate" label="Ngày tạo" width="120" />
      <el-table-column prop="status" label="Trạng thái" width="120" />
      <el-table-column prop="rank" label="Cấp độ" width="120" />
      <el-table-column prop="totalOrder" label="Tổng đơn đặt" width="120" />
      <el-table-column fixed="right" label="Thao tác" width="150">
        <template #default>
          <el-button link type="primary" @click="handleStopActiveClick"
            >Dừng hoạt động</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      v-model:currentPage="currentPage2"
      v-model:page-size="pageSize2"
      :page-sizes="[10, 20, 50, 100]"
      :small="small"
      :disabled="disabled"
      :background="background"
      layout="sizes, prev, pager, next"
      :total="displayUserData.length"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      style="float: right"
    />
  </div>
</template>
<script>
import { mapGetters, mapActions } from 'vuex'
export default {
  name: 'Quản lý người dùng',
  data() {
    return {
      currentPage2: 1,
      pageSize2: 10,
      dialogUpdateVisible: false,
      dialogAddVisible: false,
      objectSearch: {
        id: null,
        username: null,
        rank: null,
        status: null,
      },
    }
  },
  computed: {
    ...mapGetters({
      getUserList: 'user/getUserList',
    }),
    displayUserData() {
      if (!this.getUserList || this.getUserList.length === 0) return []
      return this.getUserList.slice(
        this.pageSize2 * this.currentPage2 - this.pageSize2,
        this.pageSize2 * this.currentPage2,
      )
    },
  },
  created() {
    this.actionUserList()
  },
  methods: {
    ...mapActions({
      actionUserList: 'user/actionUserList',
    }),
    handleStopActiveClick() {},
    handleAddClick() {},
    handleSearchClick() {
      this.actionGuideList(this.objectSearch)
    },
    handleUpdateClick(data) {
      this.dialogUpdateVisible = true
      this.guideUpdate = data
    },
    handleCurrentChange(val) {
      this.currentPage2 = val
    },
    handleSizeChange(val) {
      this.pageSize2 = val
    },
    closeDialog(e) {
      this.dialogUpdateVisible = false
      console.log(e)
    },
  },
}
</script>
