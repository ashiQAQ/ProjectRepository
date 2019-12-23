import Vue from 'vue';
import Router from 'vue-router';
import goods from '@/components/goods/goods';
import seller from '@/components/seller/seller';
import rating from '@/components/rating/rating';

Vue.use(Router);

let rooter = new Router({
  // 去除#
  mode: 'history',
  routes: [{
      path: '/goods',
      component: goods
    },
    {
      path: '/seller',
      component: seller
    },
    {
      path: '/rating',
      component: rating
    }
  ],
  linkActiveClass: 'active'
});
// 跳转到默认子页面
rooter.push('/goods');

export default rooter;
