<template>
    <div class="box">
        <Header></Header><!--顶栏-->
        <div class ="content">
            <tool @search="search" @delete="$refs.list.deleteRows()" @add="$refs.list.add()">
            </tool><!--工具条-->
            <el-row :gutter= "20" style= "margin-top:18px"><!--布局方式-->
                <el-col :span="16">
                    <home-list @search="search" ref="list"></home-list>
                </el-col>
                <el-col :span="8">
                    <el-tabs v-model="tabNow" class="chartBox" @tab-click="tabClick">
                        <el-tab-pane name="total" label="总消费">
                            <echart1 ref="echart1"></echart1>
                            <echart2 ref="echart2" :params="params"></echart2>
                        </el-tab-pane>
                        <el-tab-pane name="compare" label="消费对比">
                            <echart3 ref="echart3"></echart3>
                        </el-tab-pane>
                    </el-tabs>
                </el-col>
           </el-row>
        </div>
    </div>
</template>


<script>
    import HomeList from "../components/HomeList"
    import Header from "../components/header.vue"
    import Echart1 from "../components/echart1.vue"
    import Echart2 from "../components/echart2.vue"
    import Echart3 from "../components/echart3.vue"
    import Tool from "../components/tool.vue"
    export default{
        name:"home",
        data(){
            return {
                tabNow:"total",
                params:{}
            }
        },
        components:{HomeList,Header,Echart1,Echart2,Echart3,Tool},
        methods:{
            // add(){
            //     let form= {
            //         "comment": "null",
            //         "count": 6,
            //         "cus_date": "2023-01-09",
            //         "custom": "lhb",
            //         "label": "null",
            //         "type": "null"
            //     }

            //     this.$axiosJava.post("api/home/add",form).then(res=>{
            //         this.$message.success("成功")
            //     }).catch(e=>{
            //         this.$message.error(e);
            //     })
            // }
            tabClick(tab){
                this.search(this.params)
            },
            
            search(params){
                this.$refs.list.query(params)
                switch (this.tabNow){
                    case "total":
                        this.$refs.echart1.query(params)
                        this.$refs.echart2.query(params)
                        break
                    case "compare":
                        this.$refs.echart3.query(params)
                        break
                }
                this.params=params
            },




        }

    }

</script>

<style scoped>
  .box {
    margin: 0;
    background-color: #f0f0f0;
    padding-bottom: 20px;
  }
  .box .content {
    margin: 12px;
    background-color: white;
    padding: 18px;
  
  }


</style>