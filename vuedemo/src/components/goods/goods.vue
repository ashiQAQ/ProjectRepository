<template>
  <div class="goods">
    <div class="menu-wrapper">
      <ul>
        <li v-for="(its, index) in goods" :key="index" :class="{ current: currentIndex === index }" class="menu-item" @click="selectMenu(index, $event)">
          <span class="text">
            <span v-show="its.type > 0" :class="classMap[its.type]" class="icon"></span>
            <span class="name">{{ its.name }}</span>
          </span>
        </li>
      </ul>
    </div>
    <div class="food-wrapper" ref="foodWrapper">
      <ul>
        <li v-for="good in goods" :key="good.index" class="good-list good-list-hook">
          <h1 class="title">{{ good.name }}</h1>
          <ul>
            <li v-for="food in good.foods" :key="food.index" class="food-list" @click="chooseFood(food)">
              <div class="icon"><img :src="food.icon" width="57" height="57" alt="" /></div>
              <div class="content">
                <h2 class="name">{{ food.name }}</h2>
                <p class="desc">{{ food.description }}</p>
                <div class="rating">
                  <span class="sell-count">月售{{ food.sellCount }}份</span>
                  <span class="rating">好评率{{ food.rating }}%</span>
                </div>
                <div class="price">
                  <span class="now">￥{{ food.price }}</span>
                  <del v-show="food.oldPrice" class="old">￥{{ food.oldPrice }}</del>
                </div>
              </div>
              <!--cart-controller-->
              <div class="cart-controller-wrapper"><CartControl :food="food" v-on:cart-add="cartAdd"></CartControl></div>
            </li>
          </ul>
        </li>
      </ul>
    </div>
    <shopCart ref="shopcart" :select-foods="selectFoods" :delivery-price="seller.deliveryPrice" :min-price="seller.minPrice"></shopCart>
    <food :food="selectedFood" ref="food" :shopcart="shopcart"></food>
  </div>
</template>

<script>
import BScroll from 'better-scroll';
import shopCart from '../../components/shopcart/shopcart';
import CartControl from '../cartcontroller/CartControl';
import food from '../food/food.vue';

export default {
  name: 'goods',
  props: {
    seller: { type: Object }
  },
  data() {
    return {
      goods: [],
      lineHeight: [],
      scrollY: 0,
      showFlag: false,
      selectedFood: {},
      shopcart: {}
    };
  },
  created() {
    this.classMap = ['decrease', 'discount', 'guarantee', 'invoice', 'special'];
    this.$http.get('/api/goods').then(resp => {
      //console.log(resp.body);
      this.goods = resp.body;
      // console.log(this.goods)
      // 数据加载 渲染页面后
      this.$nextTick(() => {
        this._initScroll();
        this._calculateHeight();
      });
    });
  },
  methods: {
    chooseFood(food) {
      this.$refs.food.show();
      this.selectedFood = food;
      this.shopcart = this.$refs.shopcart;
    },
    // 初始化滚动组件
    _initScroll() {
      this.menuScroll = new BScroll('.menu-wrapper', {
        click: true
      });
      this.foodScroll = new BScroll('.food-wrapper', {
        click: true,
        probeType: 3
      });
      // 添加滚动事件
      this.foodScroll.on('scroll', pos => {
        this.scrollY = Math.abs(Math.round(pos.y));
      });
    },
    // 计算good list的高度
    _calculateHeight() {
      let foodList = this.$refs.foodWrapper.getElementsByClassName('good-list-hook');
      this.lineHeight.push(0);
      let height = 0;
      for (let i = 0; i < foodList.length; i++) {
        let item = foodList[i];
        height += item.clientHeight;
        this.lineHeight.push(height);
      }
    },
    selectMenu(index, e) {
      let foodList = this.$refs.foodWrapper.getElementsByClassName('good-list-hook');
      let el = foodList[index];
      this.foodScroll.scrollToElement(el, 300);
    },
    cartAdd(el) {
      // 优化动画效果
      this.$nextTick(() => {
        /*调用shopcart主件中的drop函数*/
        this.$refs['shopcart'].drop(el);
      });
    }
  },
  computed: {
    currentIndex() {
      // TO DO : scrollY 的值到底currentIndex
      if (!this.scrollY) return 0;
      for (let i = 0; i < this.lineHeight.length; i++) {
        let h1 = this.lineHeight[i];
        let h2 = this.lineHeight[i + 1];
        if (!h2 || (this.scrollY >= h1 && this.scrollY < h2)) {
          return i;
        }
      }
      return 0;
    },
    selectFoods() {
      let foods = [];
      this.goods.forEach(good => {
        good.foods.forEach(food => {
          if (food.count) {
            foods.push(food);
          }
        });
      });
      this.$emit('sendfoods', foods);
      return foods;
    }
  },
  components: {
    shopCart,
    CartControl,
    food
  }
};
</script>

<style lang="stylus" rel="stylussheet/stylus">
@import '../../common/css/mixin.styl'

.goods
  width 100%
  display flex
  position absolute
  overflow hidden
  top 174px
  bottom 46px
  .menu-wrapper
    flex 0 0 80px
    width 80px
    background-color #f3f5f7
    .menu-item
      display table
      font-size 12px
      line-height 14px
      height 54px
      width 56px
      padding 0 12px
      &.current
        background-color white
        margin-top -1px
        position relative
        /* z-index 10 */
        .text
          border-none()
          .name
            font-weight 700
      &:last-child .text
        border-none()
      .text
        width 56px
        display table-cell
        vertical-align middle
        border-1px(rgba(1, 17, 27, 0.1))
        font-size 12px
        line-height 14px
        .icon
          display inline-block
          width 14px
          height 14px
          background-size 12px 12px
          background-repeat no-repeat
          margin-right 2px
          vertical-align top
          &.decrease
            bg-image('decrease_3')
          &.discount
            bg-image('discount_3')
          &.guarantee
            bg-image('guarantee_3')
          &.invoice
            bg-image('invoice_3')
          &.special
            bg-image('special_3')
        .name
          font-size 12px
          line-height 14px
          vertical-align top
  .food-wrapper
    flex 1
    .title
      padding-left 14px
      height 26px
      line-height 26px
      border-left 2px solid #d9dde1
      font-size 12px
      color rgb(147, 153, 159)
      background-color #f3f5f7
    .food-list
      display flex
      margin 18px
      padding-bottom 18px
      border-1px(rgba(7, 17, 27, 0.1))
      &:last-child
        border-none()
        margin-bottom 0
      .icon
        flex 0 0 57px
        margin-right 10px
      .content
        flex 1
        .name
          margin 2px 0 8px 0
          height 14px
          line-height 14px
          font-size 14px
          color rgb(7, 17, 27)
          overflow hidden
        .desc, .rating
          line-height 10px
          font-size 10px
          color rgb(147, 153, 159)
        .desc
          margin-bottom 8px
          line-height 12px
        .rating
          .count
            margin-right 12px
        .price
          font-weight 700
          line-height 24px
          .now
            margin-right 8px
            font-size 14px
            color rgb(240, 20, 20)
          .old
            text-decoration line-through
            font-size 10px
            color rgb(147, 153, 159)
      .cart-controller-wrapper
        position absolute
        right 0px
        bottom 5px
</style>
