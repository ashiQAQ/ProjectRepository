<template>
  <div class="seller" ref="seller">
    <div class="seller-content">
      <div class="overview">
        <h1 class="title">{{ seller.name }}</h1>
        <div class="desc border-1px">
          <star :size="36" :score="seller.score" class="star"></star>
          <span class="text">({{ seller.ratingCount }})</span>
          <span class="text">月售{{ seller.sellCount }}单</span>
        </div>
        <ul class="remark">
          <li class="block">
            <h2>起送价</h2>
            <div class="content">
              <span class="stress">{{ seller.minPrice }}元</span>
            </div>
          </li>
          <li class="block">
            <h2>商家配送</h2>
            <div class="content">
              <span class="stress">{{ seller.deliveryPrice }}元</span>
            </div>
          </li>
          <li class="block">
            <h2>平均配送时间</h2>
            <div class="content">
              <span class="stress">{{ seller.deliveryTime }}分钟</span>
            </div>
          </li>
        </ul>
        <div class="collect-wrapper">
          <div class="collect" :class="{ active: collect }" @click="collected"><span class="icon-favorite"></span></div>
          <div class="text">已收藏</div>
        </div>
      </div>
      <Split></Split>
      <div class="bulletin">
        <h1 class="title">公告与活动</h1>
        <div class="content-wrapper border-1px">
          <p class="content">{{ seller.bulletin }}</p>
        </div>
        <ul class="supports" v-if="seller.supports">
          <li class="supports-item border-1px" v-for="(item, index) in seller.supports" :key="index">
            <span class="icon" :class="classMap[seller.supports[index].type]"></span>
            <span class="text">{{ seller.supports[index].description }}</span>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import BScroll from 'better-scroll';
import star from '../star/star.vue';
import Split from '../split/split.vue';

export default {
  props: {
    seller: {
      type: Object
    }
  },
  data() {
    return {
      collect: false
    };
  },
  methods: {
    collected() {
      this.collect = !this.collect;
    }
  },
  created() {
    this.classMap = ['decrease', 'discount', 'guarantee', 'invoice', 'special'];
    this.$nextTick(() => {
      this.scroll = new BScroll(this.$refs.seller, {
        click: true
      });
    });
  },
  components: {
    star,
    Split
  }
};
</script>

<style lang="stylus" rel="stylussheet/stylus">
@import '../../common/css/mixin.styl'

.seller
  position absolute
  top 174px
  bottom 0
  left 0
  width 100%
  overflow hidden
  .overview
    position relative
    padding 18px
    .title
      margin-bottom 8px
      line-height 14px
      color rgb(7, 17, 27)
      font-size 14px
    .desc
      padding-bottom 18px
      border-1px(rgba(7, 17, 27, 0.1))
      font-size 0
      .star
        display inline-block
        vertical-align top
        margin-right 8px
      .text
        display inline-block
        margin-right 12px
        line-height 18px
        vertical-align top
        font-size 10px
        color rgb(77, 85, 93)
    .remark
      display flex
      padding-top 18px
      .block
        flex 1
        text-align center
        border-right 1px solid rgba(7, 17, 27, 0.1)
        &:last-child
          border none
        h2
          margin-bottom 4px
          line-height 10px
          font-size 10px
          color rgb(147, 153, 159)
        .content
          line-height 24px
          font-size 10px
          color rgb(7, 17, 27)
          .stress
            font-size 24px
    .collect-wrapper
      position absolute
      top 1.125rem
      right 1.125rem
      text-align center
      .collect
        font-size 1.5rem
        line-height 1.5rem
        color rgb(147, 153, 159)
        padding-bottom 0.25rem
        &.active
          color red
      .text
        font-size 0.625rem
        line-height 0.625rem
        color rgb(77, 85, 93)
  .bulletin
    padding 18px 18px 0 18px
    .title
      margin-bottom 8px
      line-height 14px
      color rgb(7, 17, 27)
      font-size 14px
    .content-wrapper
      padding 0 12px 16px 12px
      border-1px(rgba(7, 17, 27, 0.1))
      .content
        line-height 24px
        font-size 12px
        color rgb(240, 20, 20)
    .supports
      .supports-item
        padding 16px 12px
        border-1px(rgba(7, 17, 27, 0.1))
        font-size 0
      .icon
        display inline-block
        vertical-align top
        width 16px
        height 16px
        margin-right 6px
        background-size 16px 16px
        background-repeat no-repeat
        &.decrease
          bg-image('decrease_4')
        &.discount
          bg-image('discount_4')
        &.guarantee
          bg-image('guarantee_4')
        &.invoice
          bg-image('invoice_4')
        &.special
          bg-image('special_4')
      .text
        line-height 16px
        font-size 12px
        color rgb(7, 17, 27)
</style>
