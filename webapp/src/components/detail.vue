<template>
    <div class="newsedit-box">
      <el-form :model="form" label-width="150px" style="width: 85%">
        <el-row>
          <el-col :span="8">
            <el-form-item label="消费名称：">
              <el-input style="width: 220px" v-if="type=='bj'" v-model="form.label"></el-input>
              <el-input v-else v-model="form.label" readonly="readonly"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="消费金额：" label-width="150px">
              <el-input style="width: 220px" v-if="type=='bj'" v-model.number="form.count" type="number"></el-input>
              <el-input v-else v-model="form.count" readonly="readonly"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="消费类别：">
              <el-select
                v-if="type=='bj'"
                v-model="form.type"
                allow-create
                default-first-option
                filterable
              >
                <el-option
                  v-for="item in types"
                  :key="item"
                  :label="item"
                  :value="item"
                ></el-option>
              </el-select>
              <el-input v-else v-model="form.type" readonly="readonly"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="消费者：" label-width="150px">
              <el-select v-if="type=='bj'" v-model="form.custom">
                <el-option v-for="item in users" :key="item" :value="item"></el-option>
              </el-select>
              <el-input v-else v-model="form.custom" readonly="readonly"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="消费日期：">
              <el-date-picker v-if="type=='bj'" value-format='yyyy-MM-dd'
                              v-model="form.cus_date"></el-date-picker>
              <el-input v-else v-model="form.cus_date" readonly="readonly"></el-input>
            </el-form-item>
          </el-col>
  
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="是否已销账：">
              <el-switch
                v-if="type=='bj'"
                v-model="form.write_off"
                active-text="是"
                inactive-text="否"
              ></el-switch>
              <div v-else>{{ form.write_off ? "是" : "否" }}</div>
            </el-form-item>
          </el-col>
        </el-row>
  
        <el-form-item label="消费说明：">
          <editor
            v-if="type=='bj'"
            v-model="form.content"
          ></editor>
          <div v-html="form.content" v-else></div>
        </el-form-item>
        <el-form-item>
          <el-button v-if="type=='bj'" size="small" type="success" @click="submit()">提交</el-button>
          <el-button size="small" type="info" @click="cancel">取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </template>
  
  <script>
    import editor from "./editor"
  
    export default {
      name: "detail",
      props: ["rows", "type"],
      data() {
        return {
          form: {},
          users: ["用户1","用户2", "lhb"],
          types: [],
        }
      },
      components: {
        editor
      },
      methods: {
        cancel() {
          this.$emit("cancel")//触发‘cancel’的事件
        },
        submit() {
          this.$axiosJava.post(`api/home/${this.form.id ? "edit" : "add"}`,this.form).then(res=>{
            
            this.$emit("add")//组件之间传递事件的方法，触发add的事件
            this.$message.success("success")//全局提示组件
          })
        },
        getTypes() {
          let url = `/static/api/home/type`
          this.$axios({
            method: "get",
            url: url
          }).then((res) => {
            this.types = res.data
          }).catch((error) => {
            this.$message.error("获取分类失败")
          })
        },
        getDetail() {
          // let form = this.rows
          if (this.rows.id) {
            let url = `api/home/detail`
            this.$axiosJava.get(url, {params: {id: this.rows.id}}).then((res) => {
              this.form = res.data
            }).catch((error) => {
              this.$message.error("获取数据失败")
            })
          }else{
            this.form={write_off: true}
          }
        }
      },
      watch: {//监听rows的数据更改
      rows: {
        immediate: true,
        handler() {
          this.getDetail()//更改时调用getdetail函数
        },

      }
    },
      mounted() {//组件完成后自动调用
        if (this.type == "bj") {
          this.getTypes()
        }
      }
    }
  </script>
  
  <style scoped>
    .add-enclosure-btn {
      width: 73px;
      height: 35px;
      overflow: hidden;
      position: relative;
    }
  </style>
  