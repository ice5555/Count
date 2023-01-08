<template>
    <div>
        <home-list></home-list>
         <el-button @click="add" type="primary">新增</el-button>
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