<template>
  <div class="ratings" ref="ratings">
    <div class="rating-content">
      <div class="overview">
        <div class="overview-left">
          <h1 class="score">{{ seller.score }}</h1>
          <div class="title">综合评分</div>
          <div class="rank">高于周边商家{{ seller.rankRate }}%</div>
        </div>
        <div class="overview-right">
          <div class="score-wrapper">
            <span class="title">服务态度</span>
            <div class="star"><star :size="24" :score="seller.serviceScore"></star></div>
            <span class="score">{{ seller.serviceScore }}</span>
          </div>
          <div class="score-wrapper">
            <span class="title">商品评分</span>
            <div class="star"><star :size="24" :score="seller.score"></star></div>
            <span class="score">{{ seller.score }}</span>
          </div>
          <div class="delivery-wrapper">
            <span class="title">送达时间</span>
            <span class="time">{{ seller.deliveryTime }}分钟</span>
          </div>
        </div>
      </div>
      <split></split>
      <ratingSelect :ratings="ratings" :onlyContent="onlyContent" :selectType="selectType" @rating-toggle="ratingToggle" @rating-select="ratingSelect"></ratingSelect>
      <div class="rating-wrapper">
        <ul>
          <li class="rating-item" v-show="needShow(rating.rateType, rating.text)" v-for="(rating, index) in ratings" :key="index">
            <!--<div class="avatar"><img :src="rating.avatar" alt="" /></div>-->
            <div class="avatar"><img :src="rating.user.avatar" alt="" /></div>
            <div class="content">
              <div class="username">{{ rating.user.username }}</div>
              <!--<div class="username">{{ rating.username }}</div>-->
              <div class="star-wrapper">
                <star class="star" :size="24" :score="rating.score"></star>
                <span class="delivery" v-show="rating.deliveryTime">{{ rating.deliveryTime }}分钟送达</span>
              </div>
              <p class="text">{{ rating.text }}</p>
              <div class="recommend" v-show="rating.recommend.length > 0">
                <span class="icon-thumb_up"></span>
                <span class="item" v-for="(item, index) in rating.recommend" :key="index">{{ item }}</span>
              </div>
              <div class="time">{{ rating.rateTime | formatDate }}</div>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <shopCart :select-foods="foods" :delivery-price="seller.deliveryPrice" :min-price="seller.minPrice"></shopCart>
  </div>
</template>

<script>
import BScroll from 'better-scroll';
import food from '../food/food.vue';
import shopCart from '../../components/shopcart/shopcart';
import star from '../star/star.vue';
import split from '../split/split.vue';
import ratingSelect from '../ratingselect/RatingSelect.vue';
import { formatDate } from '../../common/js/date';
const ALL = 2;
export default {
  name: 'rating',
  data() {
    return {
      ratings: [],
      onlyContent: true,
      selectType: ALL
    };
  },
  props: {
    seller: {
      type: Object
    },
    foods: {
      type: Array,
      default() {
        return [];
      }
    }
  },
  methods: {
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
  created() {
    this.$http.get('/api/ratings?sellerId=1').then(resp => {
      // 返回数据
      this.ratings = resp.body;
      console.log(this.ratings);
      this.$nextTick(() => {
        this.scroll = new BScroll(this.$refs.ratings, {
          click: true
        });
      });
    });
  },
  filters: {
    formatDate(time) {
      let date = new Date(time);
      return formatDate(date, 'yyyy-MM-dd hh:mm');
    }
  },
  components: {
    food,
    shopCart,
    star,
    split,
    ratingSelect
  }
};
</script>

<style lang="stylus" rel="stylussheet/stylus">
@import '../../common/css/mixin.styl'

.ratings
  position absolute
  width 100%
  left 0
  bottom 2.8125rem
  top 11rem
  overflow hidden
  .overview
    padding 1.125rem 0
    display flex
    .overview-left
      flex 0 0 8.4375rem
      text-align center
      width 137px
      text-align center
      border-right 1px solid rgba(7, 17, 27, 0.1)
      padding 6px 0
      .score
        font-size 1.5rem
        line-height 1.75rem
        color rgb(255, 153, 0)
        margin-bottom 0.375rem
      .title
        font-size 0.75rem
        line-height 0.75rem
        color rgb(7, 17, 27)
        margin-bottom 0.5rem
      .rank
        font-size 0.625rem
        line-height 0.625rem
        color rgb(7, 17, 27)
    .overview-right
      flex 1
      padding 0.375rem 0 0.375rem 1.5rem
      .score-wrapper
        margin-bottom 0.5rem
        font-size 0
        .title
          display inline-block
          font-size 0.75rem
          line-height 1.125rem
          color rgb(7, 17, 27)
          padding-right 0.75rem
        .star
          display inline-block
          padding-right 0.75rem
        .score
          display inline-block
          font-size 0.75rem
          line-height 1.125rem
          color rgb(255, 153, 0)
      .delivery-wrapper
        font-size 0
        .title
          display inline-block
          font-size 0.75rem
          line-height 1.125rem
          color rgb(7, 17, 27)
          padding-right 0.75rem
        .time
          display inline-block
          font-size 0.75rem
          line-height 1.125rem
          color rgb(147, 153, 159)
  .rating-wrapper
    padding 0 18px
    .rating-item
      display flex
      padding 18px 0
      border-1px(rgba(7, 17, 27, 0.1))
      .avatar
        flex 0 0 28px
        width 28px
        margin-right 12px
        img
          width 28px
          border-radius 50%
      .content
        position relative
        flex 1
        .username
          line-height 12px
          font-size 10px
          color rgb(7, 17, 27)
          margin-bottom 4px
        .star-wrapper
          margin-bottom 6px
          font-size 0
          .star
            display inline-block
            margin-right 6px
            vertical-align top
          .delivery
            display inline-block
            vertical-align top
            line-height 12px
            font-size 10px
            color rgb(147, 153 159)
        .text
          line-height 18px
          color rgb(7, 17, 27)
          font-size 12px
          margin-bottom 8px
        .recommend
          line-height 16px
          font-size 0
          .icon-thumb_up, .item
            display inline-block
            margin 0 8px 4px 0
            font-size 9px
          .icon-thumb_up
            color rgb(0, 160, 220)
          .item
            padding 0 6px
            border 1px solid rgba(7, 17, 27, 0.1)
            border-radius 1px
            color rgb(147, 153, 159)
            background-color #fff
        .time
          position absolute
          top 0
          right 0
          line-height 12px
          font-size 10px
          color rgb(147, 153, 159)
</style>
