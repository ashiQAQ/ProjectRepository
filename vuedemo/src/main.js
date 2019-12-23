// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import App from './App';
import router from './router';
import VueResource from 'vue-resource';

import './common/css/index.styl';

//require('../mock/mock');//这个注释掉就可以连数据库 用生产数据 不注释就是mock的数据
//不mock的话,注意①需要把rating.vue发的/api/ratings?sellerId=1 改成 /api/ratings 不带参数的
//②后台rating循环的时候 user的数据 avatar和username 是单独算user对象的属性的 而mock的是放在一起的
Vue.config.productionTip = false;
Vue.use(VueResource);
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {
    App
  },
  template: '<App/>'
});
//console.log(vm);
