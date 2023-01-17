<template>
  <div>
    <!--图表本身--height="calc(100vh-50px)"-->
    <el-table border
              width="100%"
              height="calc(80vh)"
              :data="tableData.list"
              @selection-change="handleSelectionChange"
              >
       <el-table-column
        type="selection"
        width="55">
      </el-table-column>

      <!--for循环-->
      <el-table-column v-for ="item in columns"
                       :key="item.prop"
                       :prop="item.prop"
                       :label="item.label"
                       :width="item.width"
                       >
      </el-table-column>
      <el-table-column label="操作"
                       width="150"
      >
      <template slot-scope="scope">
          <el-button icon="el-icon-view" size="mini" circle type="primary" @click="view(scope)"></el-button>
          <el-button icon="el-icon-edit" size="mini" circle type="success" @click="edit(scope)"></el-button>
          <el-button icon="el-icon-delete" size="mini" circle type="danger" @click="rowDelete(scope)"></el-button>
        </template>

    </el-table-column>

    </el-table>

    <!--分页组件-->
    <el-pagination style="float :right"
                   @size-change="handleSizeChange"
                   @current-change="handleCurrentchange"
                   :current-page="currentPage"
                   :page-sizes="[15,20,25,30]" 
                   :page-size="currentSize"
                   layout="total,sizes,prev,pager,next,jumper"
                   :total="tableData.count"
                   >  
    </el-pagination>
    <!--对话框-->
    <el-dialog :visible.sync="showDetail" width="1200px">
      <detail @add="showDetail=false;reSearch()"
              @cancel ="showDetail=false" :rows="currentRow" :type="detailType">
      </detail>
    </el-dialog>
  
  </div>   
</template>

<script>
  import Detail from "./detail"
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
        currentSize:15,
        selection: [],
        params: null,
        columns:[
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
          },{
            prop:"write_off",
            label:"是否已销账"
          }
        ]
      }
    },
    methods:{
      handleSelectionChange(rows) {
        this.selection = rows
      },
      reSearch() {
        this.$emit("search", this.params)
      },
      deleteRows() {
        this.$axiosJava.post("api/home/delete", this.selection.map(item => {
          return item.id
        })).then(res => {
          this.$message.success("成功")
          this.reSearch()
        })
      },
      add() {
        this.currentRow = {}
        this.detailType = "bj"
        this.showDetail = true
      },
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
        this.$axiosJava.post("api/home/delete", [scope.row.id]).then(res => {
        this.$message.success("success")
        this.reSearch()
        })
      },
 
      handleSizeChange(currentSize){
        this.currentPage = 1
        this.currentSize = currentSize
        this.getData()

      },
      handleCurrentchange(currentPage){
        this.currentPage = currentPage
        this.getData()
      },
       getData(){
        
        this.params.num=this.currentSize
        this.params.page=this.currentPage
         this.$axiosJava.post("api/home/list",this.params).then(res=>{
           this.tableData=res.data
           this.tableData.list.map((item)=>{
            item.write_off=item.write_off ? "是" : "否"
           })
        })
       },
    query(params) {
        this.currentPage = 1

        this.params = {
          ...params,
          num: this.currentSize,
          page: this.currentPage
        }
        this.currentPage = 1
        this.getData()
      }}}
   
</script>