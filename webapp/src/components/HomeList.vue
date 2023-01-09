<template>
  <div>
    <!--表本身-->
    <el-table border
              width="100%"
              height="calc(100vh-230px)"
              :data="tableData.list"
              >
      <el-table-colunm v-for ="item in coulumns"
                       :key="item.prop"
                       :prop="item.prop"
                       :label="item.label"
                       :width="item.width"
                       >
      </el-table-colunm>
      <el-table-colunm label="操作"
                       width="150"
      >
      <template slot-scope="scope">
          <el-button icon="el-icon-view" size="mini" circle type="primary" @click="view(scope)"></el-button>
          <el-button icon="el-icon-edit" size="mini" circle type="success" @click="edit(scope)"></el-button>
          <el-button icon="el-icon-delete" size="mini" circle type="danger" @click="rowDelete(scope)"></el-button>
        </template>

    </el-table-colunm>

    </el-table>

    <!--分页组件-->
    <el-pagination style="float :right"
    @size-change="handleSizeChange"
                  
                   @current-change="handleCurrentchange"
                   :current-page="currentPage"
                   :page-sizes="[15,20,25,30]" 
                   :page-size="15"
                   layout="total,sizes,prev,pager,next,jumper"
                   :total="tableData.count"
                   >  
    </el-pagination>
    <!--对话框-->
    <el-diaglog :visible.sync="showDetail" width="1200px">
      <detail @cancel ="showDetail=false" 
              :rows="currentRow" 
              :type="detailType">
      </detail>
    </el-diaglog>
  
  </div>   
</template>

<script>
  export default{
    name:'HomeList',
    components:{Detail},
    data(){
      return{
        tableData: [],
        detailType:"ck",
        showDetail:false,
        currentRow:{},
        currentPage:1,
        coulumns:[
          {
            prop:"label",
            label:"消费名称"
          },
          {
            prop:"cus_date",
            label:"消费日期"
          },{
            prop:"type",
            label:"消费类别"
          },{
            prop:"custom",
            label:"消费者"
          },{
            prop:"count",
            label:"消费金额"
          }
        ]
      }
    },
    methods:{
      view(scope){
        this.currentRow=scope.row
        this.detailType="ck"
        this.showDetail=true
      },
      edit(scope){
        this.currentRow=scope.row
        this.detailType="bj"
        this.showDetail=true
      },
      rowDelete(scope){

      },
      handleSizeChange(){

      },
      handleCurrentchange(){

      },
       getData(){
         this.$axiosJava.get("static/api/home/list").then(res=>{
           this.tableData=res.data
        })
       }
    },
    mounted(){
      this.getData()
    }
   }
</script>