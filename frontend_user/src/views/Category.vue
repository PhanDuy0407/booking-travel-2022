<template>
  <div>
    <v-row>
      <v-col>
        <div>
          <!-- <siderbar /> -->
          <v-card>
            <v-card-title class="justify-center">Bộ lọc tìm kiếm</v-card-title>
            <v-card-text>
              <h6>Điểm đi</h6>
              <v-autocomplete
                v-model="startPlace"
                dense
                :items="places"
                outlined
              >
              </v-autocomplete>

              <h6>Điểm đến</h6>
              <v-autocomplete
                v-model="endPlace"
                dense
                :items="places"
                outlined
              >
              </v-autocomplete>
              
              <h6>Ngày đi</h6>
              <v-menu
                    ref="menu"
                    v-model="menu"
                    :close-on-content-click="false"
                    :return-value.sync="startDate"
                    transition="scale-transition"
                    offset-y
                    min-width="auto"
                  >
                    <template v-slot:activator="{ on, attrs }">
                      <v-text-field
                        v-model="startDate"
                        readonly
                        v-bind="attrs"
                        v-on="on"
                        outlined
                        dense
                      ></v-text-field>
                    </template>
                    <v-date-picker v-model="startDate" no-title scrollable>
                      <v-spacer></v-spacer>
                      <v-btn text color="primary" @click="menu = false">
                        Cancel
                      </v-btn>
                      <v-btn
                        text
                        color="primary"
                        @click="$refs.menu.save(startDate)"
                      >
                        OK
                      </v-btn>
                    </v-date-picker>
                  </v-menu>

                  <h6>Số ngày</h6>
                  <v-select dense outlined v-model="numOfDay">
                  </v-select>

                  <h6>Số người</h6>
                  <v-select dense outlined v-model="numOfPeople">
                  </v-select>

                  <h6>Giá</h6>
                  <v-range-slider
                    v-model="price"
                    min="0"
                    max="20000000"
                    step="4000000"
                    
                  ></v-range-slider>
            </v-card-text>
            <v-card-actions>
              <v-btn @click="clickSearch">Tìm kiếm</v-btn>
            </v-card-actions>
          </v-card>
        </div>
      </v-col>
      <v-col cols="12" lg="12" xl="8">
        <div>
          <div>
            <div>
              <h2 class="text-h4 font-weight-bold text-center">Danh sách Tour</h2>

              <!-- <h4 class="text-h6">Some category description goes here</h4> -->
            </div>

            <v-divider class="my-4"></v-divider>

            <v-row>
              <v-col cols="12" md="6" lg="4" v-for="i in 18" :key="i">
                <v-hover
                  v-slot:default="{ hover }"
                  open-delay="50"
                  close-delay="50"
                >
                  <div>
                    <v-card
                      flat
                      :color="hover ? 'white' : 'transparent'"
                      :elevation="hover ? 12 : 0"
                      hover
                      to="/detail"
                    >
                      <v-img
                        src="https://cdn.pixabay.com/photo/2016/11/14/04/45/elephant-1822636_1280.jpg"
                        :aspect-ratio="16 / 9"
                        gradient="to top, rgba(25,32,72,.4), rgba(25,32,72,.0)"
                        height="200px"
                        class="elevation-2"
                        style="border-radius: 16px"
                      >
                      </v-img>
                      <!-- <v-card-title>Bangkok - Pattaya (Khách sạn 4*, tặng Show Alcazar và
                          Buffet tại BaiYoke Sky)</v-card-title> -->
                      <v-card-text>
                        <div class="text-body-1 font-weight-bold black--text">
                          Bangkok - Pattaya (Khách sạn 4*, tặng Show Alcazar và
                          Buffet tại BaiYoke Sky)
                        </div>

                        <div class="text-body-1 pt-5 black--text">
                          Nơi khởi hành: TP. Hồ Chí Minh
                        </div>
                        <div class="text-body-1 black--text ">
                          Giá: <span class="text-decoration-line-through">9.000.000đ</span>
                        </div>
                        <div class="text-body-1 red--text font-weight-bold">
                          8.000.000đ
                        </div>
                        <div class="text-body-1 text-center py-5 indigo--text">
                          Còn: 00 ngày 09:09:00
                        </div>
                        <div class="text-body-1 text-right black--text">
                          <span class="text-decoration-underline"
                            >Số chỗ còn:</span>
                          <span class="red--text"> 3</span>
                        </div>
                      </v-card-text>

                      <v-card-actions class="d-flex justify-space-between">
                        <v-btn color="error">
                          <v-icon>mdi-cart</v-icon>
                          Đặt ngay
                        </v-btn>
                        <v-btn color="indigo" outlined>
                          
                          Xem chi tiết
                        </v-btn>
                      </v-card-actions>
                    </v-card>
                  </div>
                </v-hover>
              </v-col>
            </v-row>
          </div>
        </div>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import {mapGetters} from "vuex"
export default {
  name: "Category",
  components: {
    siderbar: () => import("@/components/details/sidebar"),
  },
  data() {
    return {
      places: [
        { value: 1, text: "Hà Nội" },
        { value: 2, text: "TPHCM" },
      ],
      startPlace: null,
      endPlace: null,
      startDate: null,
      numOfDay: null,
      numOfPeople: null,
      price: []
    };
  },
  computed: {
    ...mapGetters({
      objSearch: "tourList/getObjSearch"
    })
  },
  methods: {
    clickSearch(){
      console.log(this.objSearch)
    }
  },
};
</script>
