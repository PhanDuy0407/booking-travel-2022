<template>
  <div>
    <CRow>
      <CCol>
        <el-form-item label="Từ ngày">
          <el-input type="date" v-model="objectSearch.nameGuide" />
        </el-form-item>
      </CCol>
      <CCol>
        <el-form-item label="Đến ngày">
          <el-input type="date" v-model="objectSearch.phoneGuide" />
        </el-form-item>
      </CCol>
      <CCol>
        <el-button @click="handleSearchClick" type="primary"
          >Tìm kiếm</el-button
        >
      </CCol>
    </CRow>
    <el-table
      :data="displayOrdersAllData"
      stripe
      border
      style="width: 100%"
      v-loading="loading"
      :summary-method="getSummaries"
      show-summary
    >
      <el-table-column type="index" fixed />
      <el-table-column prop="id" label="Id" />
      <el-table-column prop="fullname" label="Họ và tên" />
      <el-table-column prop="email" label="Email" />
      <el-table-column prop="phoneNumber" label="Số điện thoại" />
      <el-table-column prop="address" label="Địa chỉ" />
      <el-table-column prop="sumPrice" label="Tổng đơn" />
      <el-table-column fixed="right" label="Thao tác">
        <template #default="scope">
          <el-button
            link
            type="primary"
            size="small"
            @click="handleUpdateClick(scope.row)"
            >Chi tiết</el-button
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
      :total="displayOrdersAllData.length"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      style="float: right"
    />
  </div>
</template>
<script>
import { mapGetters, mapActions } from 'vuex'

export default {
  name: 'Quản lý đơn đặt tour',
  data() {
    return {
      currentPage2: 1,
      pageSize2: 10,
      dialogUpdateVisible: false,
      dialogAddVisible: false,
      objectSearch: {
        nameGuide: null,
        phoneGuide: null,
      },
      guideUpdate: {},
    }
  },
  computed: {
    ...mapGetters({
      getAllOrdersList: 'order/getAllOrdersList',
    }),
    displayOrdersAllData() {
      if (!this.getAllOrdersList || this.getAllOrdersList.length === 0)
        return []
      return this.getAllOrdersList.slice(
        this.pageSize2 * this.currentPage2 - this.pageSize2,
        this.pageSize2 * this.currentPage2,
      )
    },
  },
  created() {
    this.actionAllOrdersList()
  },
  methods: {
    ...mapActions({
      actionAllOrdersList: 'order/actionAllOrdersList',
    }),
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
    getSummaries(param) {
      const { columns, data } = param
      const sums = []
      columns.forEach((column, index) => {
        if (index === 1) {
          sums[index] = 'Tổng tiền'
          return
        }
        const values = data.map((item) => Number(item[column.property]))
        if (!values.every((value) => isNaN(value)) && index == 6) {
          sums[index] = values.reduce((prev, curr) => {
            const value = Number(curr)
            if (!isNaN(value)) {
              return prev + curr
            } else {
              return prev
            }
          }, 0)
        } else {
          sums[index] = ''
        }
      })

      return sums
    },
  },
}
</script>
