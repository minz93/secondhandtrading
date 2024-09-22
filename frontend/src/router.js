
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PostPostManager from "./components/listers/PostPostCards"
import PostPostDetail from "./components/listers/PostPostDetail"

import ProductProductManager from "./components/listers/ProductProductCards"
import ProductProductDetail from "./components/listers/ProductProductDetail"

import TradingTradingManager from "./components/listers/TradingTradingCards"
import TradingTradingDetail from "./components/listers/TradingTradingDetail"

import AlarmAlarmManager from "./components/listers/AlarmAlarmCards"
import AlarmAlarmDetail from "./components/listers/AlarmAlarmDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/posts/posts',
                name: 'PostPostManager',
                component: PostPostManager
            },
            {
                path: '/posts/posts/:id',
                name: 'PostPostDetail',
                component: PostPostDetail
            },

            {
                path: '/products/products',
                name: 'ProductProductManager',
                component: ProductProductManager
            },
            {
                path: '/products/products/:id',
                name: 'ProductProductDetail',
                component: ProductProductDetail
            },

            {
                path: '/tradings/tradings',
                name: 'TradingTradingManager',
                component: TradingTradingManager
            },
            {
                path: '/tradings/tradings/:id',
                name: 'TradingTradingDetail',
                component: TradingTradingDetail
            },

            {
                path: '/alarms/alarms',
                name: 'AlarmAlarmManager',
                component: AlarmAlarmManager
            },
            {
                path: '/alarms/alarms/:id',
                name: 'AlarmAlarmDetail',
                component: AlarmAlarmDetail
            },




    ]
})
