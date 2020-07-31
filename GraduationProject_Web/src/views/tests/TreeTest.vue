<template>
  <div>
    <el-tree :data="data" :props="defaultProps"></el-tree>

  </div>
</template>
<script>
    import axios from "axios";
    export default {
        data() {
            return {
                data:[],
                defaultProps: {
                    children: 'children',
                    label: 'title'
                }
            };
        },
        methods: {
            getTreeData(){
                axios
                    .post("/axios/api/selectTreeData")
                    .then(response => {
                        if (response.data.code == "200") {
                            this.data = response.data.data;
                        }
                    })
                    .catch(error => {
                        console.log(error);
                    });
            }
        },
        mounted() {
            this.getTreeData();
        }
    };
</script>
