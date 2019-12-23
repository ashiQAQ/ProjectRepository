<template>
  <div class="cartcontrol">
    <transition name="fade">
      <div class="decrease" v-show="food.count > 0" @click.stop.prevent="decreaseFood">
        <transition name="rotate"><span class="inner icon-remove_circle_outline" v-show="food.count"></span></transition>
      </div>
    </transition>
    <transition name="display-count">
      <div class="count" v-show="food.count > 0">{{ food.count }}</div>
    </transition>
    <div class="increase icon-add_circle" @click.stop.prevent="increaseFood"></div>
  </div>
</template>

<script>
import Vue from 'vue';

export default {
  name: 'CartControl',
  props: {
    food: {
      type: Object
    }
  },
  methods: {
    /*点击增加按钮*/
    increaseFood(e) {
      /*Vue动态加载的数据不能监听,需要使用Vue的事例提供的方法来增加属性*/
      if (!this.food.count) {
        Vue.set(this.food, 'count', 1);
      } else {
        this.food.count++;
      }
      /*提交事件给父主键,将点击的对象传递到父主键*/
      this.$emit('cart-add', e.target);
    },
    decreaseFood() {
      this.food.count--;
    }
  }
};
</script>
<style lang="stylus" rel="stylussheet/stylus">
.cartcontrol
  font-size 0px
  text-align center
  .decrease
    vertical-align top
    display inline-block
    padding 6px
    &.fade-enter-active, &.fade-leave-active
      transition all 0.4s linear
    &.fade-enter, &.fade-leave-to
      opacity 0
      transform translate3d(24px, 0, 0)
    .inner
      display inline-block
      font-size 24px
      color rgb(0, 160, 220)
      line-height 24px
      height 24px
      &.rotate-enter-active, &.rotate-leave-active
        transition all 0.4s ease
      &.rotate-enter, &.rotate-leave-active
        opacity 0
        transform rotate(720deg)
  .count
    display inline-block
    vertical-align top
    font-size 10px
    color rgb(147, 153, 159)
    line-height 24px
    width 24px
    padding 6px 0
    &.display-count-enter-active, &.display-count-leave-active
      transition all 0.4s linear
    &.display-count-enter, &.display-count-leave-to
      opacity 0
  .increase
    vertical-align top
    display inline-block
    font-size 24px
    color rgb(0, 160, 220)
    line-height 24px
    padding 6px
</style>
