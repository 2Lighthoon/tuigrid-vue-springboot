<template>
    <div>
        <page-title />
        <div class="right">
            <select name="type" v-model="type">
                <option disabled value="">선택</option>
                <option value="smlMenuNm">sml_menu_nm</option>
                <option value="createId">create_id</option>
            </select>
            <input
                type="text"
                name="keyword"
                v-model="keyword"
                @keyup.enter="search"
            />
            <button @click="search">조회</button>
            <button type="button" @click="writer">저장</button>
        </div>
        <br />
        <div class="search_table">
            <table>
                <colgroup>
                    <col style="width: 150px" />
                    <col style="width: auto" />
                    <col style="width: 150px" />
                    <col style="width: auto" />
                </colgroup>
                <tbody>
                    <tr>
                        <th class="e">main_menu_id</th>
                        <td><input type="text" v-model="mainMenuId" /></td>
                        <th class="e">mid_menu_id</th>
                        <td><input type="text" v-model="midMenuId" /></td>
                        <th class="e">sml_menu_id</th>
                        <td><input type="text" v-model="smlMenuId" /></td>
                        <th class="e">sml_menu_nm</th>
                        <td><input type="text" v-model="smlMenuNm" /></td>
                    </tr>
                    <tr>
                        <th class="e">menu_id</th>
                        <td><input type="text" v-model="menuId" /></td>
                        <th class="e">create_id</th>
                        <td><input type="text" v-model="createId" /></td>
                        <th class="e">mod_id</th>
                        <td><input type="text" v-model="modId" /></td>
                        <th class="e">mod_dt</th>
                        <td><input type="text" v-model="modDt" /></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div>
            <div class="con_title">
                <h3>sml_menu_master</h3>
            </div>
            <div>
                <Grid
                    id="testGrid"
                    ref="testGrid"
                    v-bind="testGridProps"
                    :data="this.gridData"
                />
            </div>
        </div>
    </div>
</template>

<script>
import PageTitle from "@/components/common/PageTitle";
import { Grid } from "@toast-ui/vue-grid";
import customAxios from "@/plugins/customAxios";
import "tui-pagination/dist/tui-pagination.css";

export default {
    name: "SmlMenuMaster",
    components: { Grid, PageTitle },

    methods: {
        writer() {
            // 등록
            customAxios
                .post("api/test2", {
                    // 글등록을 위해 보내는 파라미터
                    mainMenuId: this.mainMenuId,
                    midMenuId: this.midMenuId,
                    smlMenuId: this.smlMenuId,
                    smlMenuNm: this.smlMenuNm,
                    menuId: this.menuId,
                    createId: this.createId,
                    modId: this.modId,
                    modDt: this.modDt,
                })
                .then((res) => {
                    alert("글이 등록되었습니다.");
                    console.log("writer", res);
                    this.gridData = res;
                    // gridData를 invoke로 resetData 해준다.(invoke로 resetData함수를 불러옴)
                    this.$refs.testGrid.invoke("resetData", this.gridData);
                })
                .catch((error) => {
                    alert("등록에 실패하였습니다.");
                    console.log(error);
                });
        },
        search() {
            // 검색
            customAxios
                .get("/api/test3", {
                    // 검색에 필요한 타입,키워드를 가져올 파라미터
                    params: { type: this.type, keyword: this.keyword },
                })
                .then((res) => {
                    console.log("search", res);
                    this.gridData = res;
                    // gridData를 invoke로 resetData 해준다.(invoke로 resetData함수를 불러옴)
                    this.$refs.testGrid.invoke("resetData", this.gridData);
                })
                .catch((error) => {
                    console.log(error);
                });
        },
    },

    data() {
        return {
            testGridProps: null,
            gridData: [],
            mainMenuId: "",
            midMenuId: "",
            smlMenuId: "",
            smlMenuNm: "",
            menuId: "",
            createId: "",
            modId: "",
            modDt: "",
            type: "",
            keyword: "",
        };
    },

    created() {
        //그리드의 데이터
        customAxios.get("/api/test").then((res) => {
            console.log("list", res);
            this.gridData = res;
            if (this.gridData.length > 0) {
                // gridData를 invoke로 resetData 해준다.(invoke로 resetData함수를 불러옴)
                this.$refs.testGrid.invoke("resetData", this.gridData);
            }
        });
        //그리드의 컬럼
        this.testGridProps = {
            name: "testGrid",
            minBodyHeight: 50,
            pageOptions: {
                useClient: true,
                perPage: 5,
            },
            rowHeaders: [{ type: "rowNum" }],
            columns: [
                {
                    header: "sml_menu_seq",
                    name: "smlMenuSeq",
                    align: "center",
                },
                {
                    header: "main_menu_id",
                    name: "mainMenuId",
                    align: "center",
                },
                {
                    header: "mid_menu_id",
                    name: "midMenuId",
                    align: "center",
                },
                {
                    header: "sml_menu_id",
                    name: "smlMenuId",
                    align: "center",
                },
                {
                    header: "sml_menu_nm",
                    name: "smlMenuNm",
                    align: "center",
                },
                {
                    header: "menu_id",
                    name: "menuId",
                    align: "center",
                },
                {
                    header: "create_id",
                    name: "createId",
                    align: "center",
                },
                {
                    header: "create_dt",
                    name: "createDt",
                    align: "center",
                },
                {
                    header: "mod_id",
                    name: "modId",
                    align: "center",
                },
                {
                    header: "mod_dt",
                    name: "modDt",
                    align: "center",
                },
            ],
        };
    },

    mounted() {
        // 그리드에 데이터 부착 $refs는 DOM에 접근함
        this.testGrid = this.$refs.testGrid;
    },
};
</script>

<style>
.right {
    float: right;
}
</style>
