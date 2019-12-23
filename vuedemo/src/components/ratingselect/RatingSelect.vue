<template>
  <div class="ratingselect">
    <div class="rating-type">
      <span class="block all" :class="{ active: selectType == 2 }" @click.stop.prevent="select(2)">
        {{ desc.all }}
        <span class="count">{{ ratings.length }}</span>
      </span>
      <span class="block positive" :class="{ active: selectType == 0 }" @click.stop.prevent="select(0)">
        {{ desc.positive }}
        <span class="count">{{ positives.length }}</span>
      </span>
      <span class="block negative" :class="{ active: selectType == 1 }" @click.stop.prevent="select(1)">
        {{ desc.negative }}
        <span class="count">{{ negatives.length }}</span>
      </span>
    </div>
    <div class="swith" @click.stop.prevent="toggleContent">
      <span class="icon-check_circle" :class="{ on: onlyContent }"></span>
      <span class="text">只看有内容的评价</span>
    </div>
  </div>
</template>

<script>
const POSITIVE = 0;
const NEGATIVE = 1;
const ALL = 2;
export default {
  props: {
    ratings: {
      type: Array,
      default() {
        return [];
      }
    },
    selectType: {
      type: Number,
      default: ALL
    },
    onlyContent: {
      type: Boolean,
      default: false
    },
    desc: {
      type: Object,
      default() {
        return {
          all: '全部',
          positive: '满意',
          negative: '不满意'
        };
      }
    }
  },
  methods: {
    select(type) {
      this.$emit('rating-select', type);
    },
    toggleContent() {
      this.$emit('rating-toggle', this.onlyContent);
    }
  },
  computed: {
    positives() {
      return this.ratings.filter(rating => {
        return rating.rateType === POSITIVE;
      });
    },
    negatives() {
      return this.ratings.filter(rating => {
        return rating.rateType === NEGATIVE;
      });
    }
  }
};
</script>

<style lang="stylus" rel="stylussheet/stylus">
@import '../../common/css/mixin.styl'

.ratingselect
  margin 0.75rem 0
  .rating-type
    padding 18px 0
    margin 0 1.125rem
    border-1px(rgba(7, 17, 27, 0.1))
    .block
      padding 0.5rem 0.75rem
      font-size 0.75rem
      line-height 1.125rem
      border-radius 0.125rem
      border none
      color rgb(77, 85, 93)
      background-color rgba(0, 160, 220, 0.5)
      &.active
        color #FFFFFF
        background-color rgba(0, 160, 220, 1)
      .count
        font-size 0.5rem
        margin-left 0.25rem
      &.positive
        background-color rgba(0, 160, 220, 0.2)
        &.active
          background-color rgb(0, 160, 220)
      &.negative
        background-color rgba(77, 85, 93, 0.2)
        &.active
          background-color rgb(77, 85, 93)
  .swith
    padding 0.75rem 1.125rem
    line-height 1.5rem
    height 1.5rem
    border-bottom 1px solid rgba(7, 17, 27, 0.1)
    color rgb(147, 153, 159)
    font-size 0
    .icon-check_circle
      display inline-block
      vertical-align top
      margin-right 4px
      font-size 24px
      &.on
        color #00c850
    .text
      font-size 0.75rem
</style>
