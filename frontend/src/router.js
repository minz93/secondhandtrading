
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PostPostManager from "./components/listers/PostPostCards"
import PostPostDetail from "./components/listers/PostPostDetail"

import PurchasePurchaseManager from "./components/listers/PurchasePurchaseCards"
import PurchasePurchaseDetail from "./components/listers/PurchasePurchaseDetail"

import TradeTradeManager from "./components/listers/TradeTradeCards"
import TradeTradeDetail from "./components/listers/TradeTradeDetail"

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
                path: '/trades/trades',
                name: 'TradeTradeManager',
                component: TradeTradeManager
            },
            {
                path: '/trades/trades/:id',
                name: 'TradeTradeDetail',
                component: TradeTradeDetail
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
