module.exports = {
    context: __dirname + '/src/main/resources/js',
    entry: {
        main_page: './modules/MainPage/index.js'
    },
    output: {
        path: __dirname + '/target/classes/static',
        filename: '[name].js'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader'
                }
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            },
            {
                test: /\.(png|woff|woff2|eot|ttf|svg)$/,
                loader: 'url-loader?limit=100000'
            }
        ]
    }
};
