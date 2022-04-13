<template>
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
                    <td><input type="text" v-model="gridData.mainMenuId" /></td>
                    <th class="e">mid_menu_id</th>
                    <td><input type="text" v-model="gridData.midMenuId" /></td>
                    <th class="e">sml_menu_id</th>
                    <td><input type="text" v-model="gridData.smlMenuId" /></td>
                    <th class="e">sml_menu_nm</th>
                    <td><input type="text" v-model="gridData.smlMenuNm" /></td>
                    <th class="e">sml_menu_seq</th>
                    <td><input type="text" v-model="gridData.smlMenuSeq" /></td>
                </tr>
                <tr>
                    <th class="e">menu_id</th>
                    <td><input type="text" v-model="gridData.menuId" /></td>
                    <th class="e">create_id</th>
                    <td><input type="text" v-model="gridData.createId" /></td>
                    <th class="e">create_dt</th>
                    <td><input type="text" v-model="gridData.createDt" /></td>
                    <th class="e">mod_id</th>
                    <td><input type="text" v-model="gridData.modId" /></td>
                    <th class="e">mod_dt</th>
                    <td><input type="text" v-model="gridData.modDt" /></td>
                </tr>
            </tbody>
        </table>
        <div class="right">
            <button @:click="writer()">저장</button>
        </div>
    </div>
</template>

<script>
import customAxios from "@/plugins/customAxios";
export default {
    name: "RegistBoard",
    data() {
        return {
            mainMenuId: "",
            midMenuId: "",
            smlMenuId: "",
            smlMenuNm: "",
            smlMenuSeq: "",
            menuId: "",
            createId: "",
            createDt: "",
            modId: "",
            modDt: "",
        };
    },
    methods: {
        writer() {
            customAxios
                .post("api/test2", {
                    mainMenuId: this.mainMenuId,
                    midMenuId: this.midMenuId,
                    smlMenuId: this.smlMenuId,
                    smlMenuNm: this.smlMenuNm,
                    smlMenuSeq: this.smlMenuSeq,
                    menuId: this.menuId,
                    createId: this.createId,
                    createDt: this.createDt,
                    modId: this.modId,
                    modDt: this.modDt,
                })
                .then((res) => {
                    console.log(JSON.stringify(res.data));
                    this.gridData = res;
                });
        },
    },
};
</script>

<style></style>
