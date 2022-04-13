const { defineConfig } = require("@vue/cli-service");
const path = require("path");
const webpack = require("webpack");
module.exports = defineConfig({
    transpileDependencies: true,
    chainWebpack: (config) => {
        config.resolve.alias.set("@assets", path.join(__dirname, "src/assets"));

        config.plugin("jquery").use(webpack.ProvidePlugin, [{
            $: "jquery",
        }, ]);
    },
    devServer: {
        proxy: "http://localhost:19090",
    },
});