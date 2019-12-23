<template>
  <div class="header">
    <div class="content-wrapper">
      <div class="avatar"><img width="64px" height="64px" :src="seller.avatar" alt="" /></div>
      <div class="content">
        <div class="title">
          <span class="brand"></span>
          <span class="name">{{ seller.name }}</span>
        </div>
        <div class="description">{{ seller.description }}/{{ seller.deliveryTime }}分钟送达</div>
        <div v-if="seller.supports" class="support">
          <span class="icon" :class="classMap[seller.supports[0].type]"></span>
          <span class="text">{{ seller.supports[0].description }}</span>
        </div>
      </div>
      <div v-if="seller.supports" class="support-count" @click="detailsShow">
        <span class="count">{{ seller.supports.length }}个</span>
        <i class="icon-keyboard_arrow_right"></i>
      </div>
    </div>
    <div class="bulletin-wrapper" @click="detailsShow">
      <span class="bulletin-text">{{ seller.bulletin }}</span>
      <span class="icon-keyboard_arrow_right"></span>
    </div>
    <div class="bg-image"><img :src="seller.avatar" alt="" /></div>
    <transition name="fade">
      <div class="screen" v-show="screenShow">
        <div class="screen-wrapper clear-fix">
          <div class="screen-content">
            <h1 class="name">{{ seller.name }}</h1>
            <div class="star-wrapper"><star :size="48" :score="seller.score"></star></div>
            <div class="title">
              <div class="line"><hr /></div>
              <div class="text">优惠信息</div>
              <div class="line"><hr /></div>
            </div>
            <div class="supports" v-if="seller.supports">
              <div v-for="(item, index) in seller.supports" :key="index" class="supports-item">
                <span class="icon" :class="classMap[seller.supports[index].type]"></span>
                <span class="text">{{ seller.supports[index].description }}</span>
              </div>
            </div>
            <div class="title">
              <div class="line"><hr /></div>
              <div class="text">商家公告</div>
              <div class="line"><hr /></div>
            </div>
            <div class="bulletin">
              <p class="content">{{ seller.bulletin }}</p>
            </div>
          </div>
        </div>
        <div class="screen-close"><i class="icon-close" @click="detailsHide"></i></div>
      </div>
    </transition>
  </div>
</template>

<script>
import star from '../star/star';

export default {
  props: {
    // 接受App传过来的seller对象
    seller: {
      type: Object
    }
  },
  data() {
    return {
      screenShow: false
    };
  },
  methods: {
    detailsShow() {
      this.screenShow = true;
    },
    detailsHide() {
      this.screenShow = false;
    }
  },
  created() {
    this.classMap = ['decrease', 'discount', 'guarantee', 'invoice', 'special'];
  },
  components: {
    star
  }
};
</script>

<style lang="stylus" rel="stylussheet/stylus">
@import '../../common/css/mixin.styl'

.header
  background-color rgba(7, 17, 27, 0.3)
  position relative
  color #fff
  .content-wrapper
    position relative
    font-size 0
    padding 24px 12px 18px 24px
    .avatar
      vertical-align top
      display inline-block
      img
        border-radius 4px
    .content
      display inline-block
      margin-left 16px
      .title
        margin 2px 0px 8px 0
        .brand
          display inline-block
          vertical-align top
          width 30px
          height 18px
          bg-image('brand')
          background-size 30px 18px
          background-repeat no-repeat
        .name
          margin-left 6px
          font-size 16px
          line-height 18px
          color rgb(255, 255, 255)
          font-weight bold
      .description
        margin 8px 0 12px 0
        font-size 12px
        line-height 12px
        color rgb(255, 255, 255)
      .support
        margin 10px 0 2px 0
        text-align left
        .icon
          display inline-block
          vertical-align top
          width 12px
          height 12px
          background-size 12px 12px
          background-repeat no-repeat
          &.decrease
            bg-image('decrease_1')
          &.discount
            bg-image('discount_1')
          &.guarantee
            bg-image('guarantee_1')
          &.invoice
            bg-image('invoice_1')
          &.special
            bg-image('special_1')
        .text
          display inline-block
          margin-left 4px
          font-size 11px
          color rgb(255, 255, 255)
          height 12px
          line-height 12px
          text-decoration none
    .support-count
      position absolute
      background-color rgba(0, 0, 0, 0.2)
      bottom 16px
      right 12px
      padding 0px 8px
      border-radius 14px
      height 24px
      line-height 24px
      .count
        font-size 11px
        color rgb(255, 255, 255)
        line-height 12px
      .icon-keyboard_arrow_right
        margin-left 2px
        line-height 26px
        font-size 10px
  .bulletin-wrapper
    height 28px
    line-height 28px
    background-color rgba(7, 17, 27, 0.2)
    font-size 0
    .bulletin-text
      display inline-block
      font-size 12px
      text-indent 30px
      white-space nowrap
      overflow hidden
      text-overflow ellipsis
      bg-image('bulletin')
      background-size 22px 12px
      background-repeat no-repeat
      background-position 4px center
      width 90%
    .icon-keyboard_arrow_right
      width 10%
      display inline-block
      font-size 18px
      height 28px
      line-height 28px
      vertical-align top
      text-align center
  .bg-image
    position absolute
    top 0
    left 0
    z-index -1
    width 100%
    height 100%
    overflow hidden
    img
      display block
      width 100%
      height 100%
      filter blur(10px)
  .fade-enter-active, .fade-leave-active
    transition all 0.5s
  .fade-enter, .fade-leave-to
    opacity 0
    background-color rgba(7, 17, 27, 0)
  .screen
    position fixed
    left 0
    top 0
    width 100%
    height 100%
    z-index 100
    overflow auto
    background-color rgba(7, 17, 27, 0.7)
    backdrop-filter blur(10px)
    .screen-wrapper
      width 100%
      min-height 100%
      .screen-content
        margin-top 64px
        padding-bottom 64px
        text-align center
        .name
          font-size 16px
          font-weight 700
          line-height 16px
        .star-wrapper
          margin 16px 0 28px 0
        .title
          margin 28px 36px 24px 36px
          display flex
          .line
            flex 1
            hr
              height 2px
              border none
              background-color rgba(255, 255, 255, 0.2)
          .text
            padding 0 12px
            font-weight 700
            font-size 14px
            line-height 18px
        .supports
          margin 24px 48px 28px 48px
          font-size 0
          text-align left
          .icon
            display inline-block
            vertical-align top
            width 16px
            height 16px
            background-size 16px 16px
            background-repeat no-repeat
            margin-bottom 12px
            margin-right 6px
            &.decrease
              bg-image('decrease_2')
            &.discount
              bg-image('discount_2')
            &.guarantee
              bg-image('guarantee_2')
            &.invoice
              bg-image('invoice_2')
            &.special
              bg-image('special_2')
          .text
            font-size 12px
            font-weight 200
            line-height 16px
        .bulletin
          margin 24px 48px 0 48px
          text-align left
          .content
            font-size 12px
            font-weight 300
            line-height 24px
    .screen-close
      width 32px
      height 32px
      font-size 32px
      line-height 32px
      position relative
      margin -64px auto 0 auto
      clear both
      .icon-close
        border 2px solid white
        border-radius 32px
</style>
