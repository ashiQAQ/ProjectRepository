<template>
  <transition name="fade">
    <div class="food" ref="food" v-show="showFlag">
      <div>
        <div class="image-header">
          <img :src="food.image" />
          <div class="back" @click="back"><i class="icon-arrow_lift"></i></div>
        </div>
        <div class="content">
          <h1 class="title">{{ food.name }}</h1>
          <div class="detail">
            <span class="sell-count">月售{{ food.sellCount }}份</span>
            <span class="rating">好评率{{ food.rating }}%</span>
          </div>
          <div class="price">
            <span class="now">￥{{ food.price }}元</span>
            <del class="old" v-show="food.oldPrice">￥{{ food.oldPrice }}元</del>
          </div>
          <div class="buy" v-show="!food.count || food.count === 0" @click.stop.prevent="addFirst">加入购物车</div>
          <div class="cart-controller-wrapper" v-show="food.count"><CartControl :food="food" v-on:cart-add="cartAdd"></CartControl></div>
        </div>
        <split></split>
        <div class="info">
          <h1 class="title">商品介绍</h1>
          <div class="text">{{ food.info }}</div>
        </div>
        <split></split>
        <div class="rating">
          <h1 class="title">商品评价</h1>
          <RatingSelect
            @rating-select="ratingSelect"
            @rating-toggle="ratingToggle"
            :ratings="food.ratings"
            :desc="desc"
            :select-type="selectType"
            :only-content="onlyContent"
          ></RatingSelect>
          <div class="rating-warpper">
            <ul v-show="food.ratings && food.ratings.length">
              <li class="rating-item" v-for="(rating, index) in food.ratings" v-show="needShow(rating.rateType, rating.text)" :key="index">
                <div class="time">{{ rating.rateTime | formatDate }}</div>
                <div class="text">
                  <span :class="{ 'icon-thumb_up': rating.rateType === 0, 'icon-thumb_down': rating.rateType === 1 }"></span>
                  {{ rating.text }}
                </div>
                <div class="user">
                  <span class="name">{{ rating.username }}</span>
                  <img class="avatar" :src="rating.avatar" alt="" />
                </div>
              </li>
            </ul>
            <div class="no-rating" v-show="!food.ratings || !food.ratings.length">暂无评价</div>
          </div>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
import split from '../split/split.vue';
import CartControl from '../cartcontroller/CartControl.vue';
import Vue from 'vue';
import BScroll from 'better-scroll';
import RatingSelect from '../ratingselect/RatingSelect.vue';
import { formatDate } from '../../common/js/date';

const ALL = 2;
export default {
  data() {
    return {
      showFlag: false,
      selectType: ALL,
      onlyContent: false,
      desc: {
        all: '全部',
        positive: '推荐',
        negative: '吐槽'
      }
    };
  },
  props: {
    food: {
      type: Object
    },
    shopcart: {
      type: Object
    }
  },
  methods: {
    back() {
      this.showFlag = false;
    },
    show() {
      this.showFlag = true;
      this.$nextTick(() => {
        if (!this.scroll) {
          this.scroll = new BScroll(this.$refs.food, {
            click: true
          });
        } else {
          this.scroll.refresh();
        }
      });
    },
    addFirst(event) {
      Vue.set(this.food, 'count', 1);
      this.shopcart.drop(event.target);
    },
    cartAdd(el) {
      this.$nextTick(() => {
        this.shopcart.drop(el);
      });
    },
    ratingToggle(onlyContent) {
      this.onlyContent = !onlyContent;
    },
    ratingSelect(type) {
      this.selectType = type;
    },
    needShow(rateType, text) {
      if (this.onlyContent && !text) {
        return false;
      }
      if (this.selectType === ALL) {
        return true;
      } else {
        return rateType === this.selectType;
      }
    }
  },
  filters: {
    formatDate(time) {
      let date = new Date(time);
      return formatDate(date, 'yyyy-MM-dd hh:mm');
    }
  },
  components: {
    split,
    CartControl,
    RatingSelect
  }
};
</script>

<style lang="stylus" rel="stylussheet/stylus">
@import '../../common/css/mixin.styl'

.food
  position fixed
  width 100%
  left 0
  top 0
  bottom 2.875rem
  z-index 30
  background #FFFFFF
  // overflow auto
  .image-header
    position relative
    width 100%
    height 0
    padding-top 100%
    img
      width 100%
      position absolute
      left 0
      top 0
    .back
      position absolute
      top 10px
      left 10px
      padding 0.625rem
      color #FFFFFF
      background rgba(7, 17, 27, 0.4)
      border-radius 50%
      .icon-arrow_lift
        font-size 1.25rem
  .content
    position relative
    padding 1.125rem
    .title
      font-size 0.875rem
      line-height 0.875rem
      font-weight 700
      color rgb(7, 17, 27)
      margin-bottom 1rem
    .detail
      font-size 0.625rem
      line-height 0.625rem
      color rgb(147, 153, 159)
      .sell-count
        margin-right 0.75rem
    .price
      margin 18px 0 0 0
      .now
        font-size 0.875rem
        line-height 1.5rem
        font-weight 700
        color rgb(240, 20, 20)
      .old
        font-size 0.625rem
        line-height 1.5rem
        font-weight 700
        color rgb(147, 153, 159)
    .cart-controller-wrapper
      position absolute
      right 1.125rem
      bottom 1.125rem
    .buy
      position absolute
      right 1.125rem
      bottom 1.125rem
      padding 0.75rem 1.5rem
      border-radius 1.5rem
      background rgb(0, 160, 220)
      font-size 0.75rem
      color rgb(255, 255, 255)
      line-height 0.75rem
  &.fade-enter-active, &.fade-leave-active
    transition all 0.2s linear
    transform translate3d(0, 0, 0)
  &.fade-enter
    transform translate3d(-100%, 0, 0)
  &.fade-leave-to
    transform translate3d(-100%, 0, 0)
  .info
    margin 1.125rem
    .title
      line-height 14px
      margin-bottom 6px
      font-size 14px
      color rgb(7, 17, 27)
    .text
      line-height 24px
      font-size 12px
      padding 0 8px
      color rgb(77, 85, 93)
  .rating
    margin-top 1.125rem
    .title
      @extend .food .info .title
      padding-left 1.125rem
    .rating-warpper
      margin 0 1.125rem
      .rating-item
        position relative
        margin 1rem 0
        border-1px(rgba(7, 17, 27, 0.1))
        .time
          font-size 0.625rem
          line-height 0.75rem
          color rgb(147, 153, 159)
        .text
          margin-top 0.375rem
          font-size 0.75rem
          color rgb(7, 17, 27)
          line-height 1rem
          .icon-thumb_up
            line-height 1.5rem
            color rgb(147, 153, 159)
          .icon-thumb_down
            line-height 1.5rem
            color rgb(0, 160, 220)
        .user
          position absolute
          right 0
          bottom 0.375rem
          .avatar
            width 0.75rem
            height 0.75rem
            border-radius 50%
            margin-left 0.375rem
          .name
            font-size 0.625rem
            line-height 0.75rem
            color rgb(147, 153, 159)
      .no-rating
        margin 16px 0
        font-size 12px
        color rgb(147, 153, 159)
</style>
