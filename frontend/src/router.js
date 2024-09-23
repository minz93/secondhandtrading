
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PostPostManager from "./components/listers/PostPostCards"
import PostPostDetail from "./components/listers/PostPostDetail"

import PurchasePurchaseManager from "./components/listers/PurchasePurchaseCards"
import PurchasePurchaseDetail from "./components/listers/PurchasePurchaseDetail"

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
                path: '/purchases/purchases',
                name: 'PurchasePurchaseManager',
                component: PurchasePurchaseManager
            },
            {
                path: '/purchases/purchases/:id',
                name: 'PurchasePurchaseDetail',
                component: PurchasePurchaseDetail
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
