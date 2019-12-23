<template>
  <div>
    <div class="shop-cart" ref="shopcart">
      <div class="content">
        <div class="content-left" @click="toggleList">
          <div class="logo-wrapper">
            <div class="logo" :class="{ highlight: totalCount > 0 }"><i class="icon-shopping_cart" :class="{ highlight: totalCount > 0 }"></i></div>
            <div class="num" v-show="totalCount > 0">{{ totalCount }}</div>
          </div>
          <div class="price" :class="{ highlight: totalPrice > 0 }">￥{{ totalPrice }}元</div>
          <div class="desc">另需配送费{{ deliveryPrice }}元</div>
        </div>
        <div class="content-right" @click="pay">
          <div class="pay" :class="payClass">{{ payPrice }}</div>
        </div>
        <div class="ball-container">
          <transition-group name="drop" tag="div" v-on:before-enter="beforeEnter" v-on:enter="dropEnter" v-on:after-enter="afterEnter">
            <div class="ball" v-for="ball in balls" :key="ball.key" v-show="ball.show"><div class="inner inner-hook"></div></div>
          </transition-group>
        </div>
      </div>
      <transition name="hide">
        <div class="shop-cart-list" v-show="listShow">
          <div class="list-header">
            <h1 class="title">购物车</h1>
            <span class="clear" @click="clearFoods">清空</span>
          </div>
          <div class="list-content" ref="listContent">
            <ul>
              <li class="food" v-for="(food, index) in selectFoods" :key="index">
                <span class="name">{{ food.name }}</span>
                <div class="price">
                  <span>￥{{ food.price * food.count }}</span>
                </div>
                <div class="cart-controller-wrapper"><CartControl :food="food" v-on:cart-add="cartAdd"></CartControl></div>
              </li>
            </ul>
          </div>
        </div>
      </transition>
    </div>
    <transition name="mask"><div class="list-mask" v-show="listShow" @click="hideList"></div></transition>
  </div>
</template>

<script>
import CartControl from '../cartcontroller/CartControl';
import BScroll from 'better-scroll';

export default {
  name: 'shopcart',
  components: { CartControl },
  props: {
    selectFoods: {
      type: Array,
      default() {
        return [];
      }
    },
    deliveryPrice: { type: Number, default: 0 },
    minPrice: { type: Number, default: 0 }
  },
  data() {
    return {
      balls: [{ show: false, key: 1 }, { show: false, key: 2 }, { show: false, key: 3 }, { show: false, key: 4 }, { show: false, key: 5 }],
      dropBalls: [],
      fold: true
    };
  },
  watch: {
    listShow() {
      let show = !this.fold;
      if (show) {
        this.$nextTick(() => {
          if (!this.scroll) {
            this.scroll = new BScroll(this.$refs.listContent, {
              click: true
            });
          } else {
            this.scroll.refresh();
          }
        });
      }
    },
    selectFoods(newFoods, oldFoods) {
      if (newFoods.length === 0) {
        this.fold = true;
      }
    }
  },
  computed: {
    listShow() {
      if (!this.totalCount) {
        return false;
      }
      let show = !this.fold;
      return show;
    },
    totalCount() {
      let count = 0;
      this.selectFoods.forEach(food => {
        count += food.count;
      });
      return count;
    },
    totalPrice() {
      let total = 0;
      this.selectFoods.forEach(food => {
        total += food.price * food.count;
      });
      return total;
    },
    payPrice() {
      if (this.totalPrice === 0) {
        return `￥${this.minPrice}元起送`;
      } else if (this.totalPrice < this.minPrice) {
        let diff = this.minPrice - this.totalPrice;
        return `还差￥${diff}配送`;
      } else {
        return '结算';
      }
    },
    payClass() {
      if (this.totalPrice < this.minPrice) {
        return 'not-enough';
      } else {
        return 'enough';
      }
    }
  },
  methods: {
    pay() {
      if (this.totalPrice < this.minPrice) {
        return;
      }
      let total = this.totalPrice + this.deliveryPrice;
      alert(`请支付${total}元`);
    },
    clearFoods() {
      this.selectFoods.forEach(food => {
        food.count = 0;
      });
    },
    hideList() {
      if (!this.totalCount) {
        return;
      }
      this.fold = !this.fold;
    },
    toggleList() {
      if (!this.totalCount) {
        return;
      }
      this.fold = !this.fold;
    },
    drop(el) {
      /*获取balls中的小球，如果show=false则执行该小球的动画，同时将小球加入已经执行动画的小球集合中*/
      for (let i = 0; i < this.balls.length; i++) {
        let ball = this.balls[i];
        if (!ball.show) {
          ball.show = true;
          ball.el = el; //绑定点击对象,为了获取点击对象的坐标作为小球动画的起始坐标
          this.dropBalls.push(ball);
          return;
        }
      }
    },
    beforeEnter(el, done) {
      let count = this.balls.length;
      while (count--) {
        let ball = this.balls[count];
        if (ball.show) {
          let rect = ball.el.getBoundingClientRect();
          let x = rect.left - 30;
          let y = -(window.innerHeight - rect.top - 21);
          el.style.display = '';
          el.style.transform = `translate3d(0,${y}px,0)`;
          el.style.webkitTransform = `translate3d(0,${y}px,0)`;
          let inner = el.getElementsByClassName('inner-hook')[0];
          inner.style.webkitTransform = `translate3d(${x}px,0,0)`;
          inner.style.transform = `translate3d(${x}px,0,0)`;
        }
      }
    },
    dropEnter(el, done) {
      /* eslint-disable no-unused-vars */
      /* 触发浏览器重绘; */
      let rf = el.offsetHeight;
      this.$nextTick(() => {
        el.style.webkitTransform = 'translate3d(0, 0, 0)';
        el.style.transform = 'translate3d(0, 0, 0)';
        let inner = el.getElementsByClassName('inner-hook')[0];
        inner.style.webkitTransform = 'translate3d(0, 0, 0)';
        inner.style.transform = 'translate3d(0, 0, 0)';
        el.addEventListener('transitionend', done);
      });
    },
    afterEnter(el) {
      el.style.display = 'none';
      let ball = this.dropBalls.shift();
      ball.show = false;
      ball.el = null;
    },
    cartAdd(el) {
      // 优化动画效果
      this.$nextTick(() => {
        /*调用shopcart主件中的drop函数*/
        this.drop(el);
      });
    }
  }
};
</script>

<style lang="stylus" rel="stylussheet/stylus">
@import '../../common/css/mixin.styl'

.shop-cart
  position fixed
  bottom 0px
  left 0px
  z-index 50
  width 100%
  height 46px
  .content
    display flex
    font-size 0
    color rgba(255, 255, 255, 0.4)
    background-color #141d27
    .content-left
      flex 1
      .logo-wrapper
        display inline-block
        position relative
        margin 0 10px
        width 56px
        height 56px
        border-radius 50%
        box-sizing border-box
        background-color #141d27
        padding 6px
        top -8px
        .logo
          display inline-block
          vertical-align top
          width 100%
          height 100%
          text-align center
          background-color #2b343c
          border-radius 50%
          &.highlight
            background-color rgb(0, 160, 220)
          .icon-shopping_cart
            font-size 24px
            color #80858a
            line-height 46px
            &.highlight
              color white
        .num
          position absolute
          top 0
          right 0
          width 24px
          height 16px
          line-height 16px
          text-align center
          border-radius 16px
          font-size 9px
          font-weight 700
          color #fff
          background-color rgb(240, 20, 20)
          box-shadow 0 4px 8px 0 rgba(0, 0, 0, 0.4)
      .price
        display inline-block
        vertical-align top
        font-size 16px
        font-weight 700
        margin-top 12px
        padding-right 12px
        line-height 22px
        box-sizing border-box
        border-right 1px solid rgba(255, 255, 255, 0.1)
        &.highlight
          color #fff
      .desc
        display inline-block
        vertical-align top
        padding-left 12px
        font-size 12px
        font-weight 700px
        line-height 46px
        background-color #141d27
    .content-right
      flex 0 0 105px
      width 105px
      .pay
        font-size 12px
        font-weight 700
        line-height 46px
        text-align center
        &.not-enough
          background-color #2b333b
        &.enough
          background-color #00b43c
          color #fff
    .ball-container
      .ball
        position fixed
        left 30px
        bottom 21px
        z-index 200
        &.drop-enter-active
          transition all 0.4s cubic-bezier(0.49, -0.29, 0.75, 0.41)
        .inner
          width 16px
          height 16px
          border-radius 50%
          background-color rgb(0, 160, 220)
          transition all 0.4s linear
  .shop-cart-list
    position absolute
    width 100%
    left 0
    bottom 46px
    z-index -1
    background-color white
    &.hide-enter-active, &.hide-leave-active
      transition opacity 0.5s linear
    &.hide-enter, &.hide-leave-to
      opacity 0
    .list-header
      height 40px
      line-height 40px
      background-color #f3f5f7
      padding 0 18px
      font-weight 300px
      border-bottom 1px solid rgba(7, 17, 27, 0.1)
      .title
        float left
        font-size 14px
        color rgb(7, 17, 27)
      .clear
        float right
        font-size 12px
        color rgb(0, 160, 220)
    .list-content
      padding 0 18px
      max-height 217px
      background-color #ffffff
      overflow hidden
      .food
        position relative
        padding 12px 0
        box-sizing border-box
        border-1px(rgba(7, 17, 27, 0.1))
        .name
          line-height 24px
          font-size 14px
          color rgb(7, 17, 27)
        .price
          position absolute
          right 100px
          bottom 12px
          line-height 24px
          font-weight 700
          font-size 14px
          color rgb(240, 20, 20)
        .cart-controller-wrapper
          position absolute
          right 0
          bottom 6px
.list-mask
  position fixed
  width 100%
  height 100%
  left 0
  top 0
  background-color rgba(7, 17, 27, 0.6)
  z-index 40
  &.mask-enter-active, &.mask-leave-active
    transition all 0.5s linear
  &.mask-enter, &.mask-leave-to
    background-color rgba(7, 17, 27, 0)
</style>
