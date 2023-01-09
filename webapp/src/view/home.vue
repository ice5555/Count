<template>
    <div class="box">
        <HeaderTop></HeaderTop><!--顶栏-->
        <div class ="content">
            <tool></tool><!--工具条-->
            <el-row :gutter= "20" style= "margin-top:18px">
                <el-col :span="16">
                    <home-list></home-list>
                </el-col>
                <el-col :span="8"><!--tab页面-->
                    <el-tabs v-model="tabNow" class="chartBox">
                        <el-tabl-pane name="total" label="总消费">
                            <echart1></echart1>
                            <echart2></echart2>
                        </el-tabl-pane>
                        <el-tabl-pane lazy name="vs" label="消费对比">
                            <echart3></echart3>
                        </el-tabl-pane>
                    </el-tabs>
                </el-col>
           </el-row>
        </div>
    </div>
</template>


<script>
    import HomeList from "../components/HomeList"
    export default{
        name:"home",
        components:{HomeList},
        methods:{
            add(){
                let form= {
                    "comment": "null",
                    "count": 6,
                    "cus_date": "2023-01-09",
                    "custom": "lhb",
                    "label": "null",
                    "type": "null"
                }

                this.$axiosJava.post("api/home/add",form).then(res=>{
                    this.$message.success("成功")
                }).catch(e=>{
                    this.$message.error(e);
                })
            }
        }

    }

</script>

<style scoped>

</style>