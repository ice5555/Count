<template>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="label"
        label="标题"
        width="180">
      </el-table-column>
      <el-table-column
        prop="type"
        label="类别"
        width="180">
      </el-table-column>
      <el-table-column
        prop="custom"
        label="消费者">
      </el-table-column>
    </el-table>
</template>

<script>
  export default{
    name:'HomeList',
    data(){
      return{
        tableData: []
      }
    },
    methods:{
       getData(){
         this.$axiosJava.get("api/home/list").then(res=>{
           this.tableData=res.data
        })
       }
    },
    mounted(){
      this.getData()
    }
   }
</script>