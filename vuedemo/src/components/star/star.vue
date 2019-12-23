<template>
  <div id="star" :class="starType"><span v-for="starItem in starItems" :key="starItem.index" :class="starItem" class="star-item"></span></div>
</template>

<script>
export default {
  name: 'star',
  props: {
    size: { type: Number },
    score: { type: Number }
  },
  computed: {
    starType() {
      return 'star-' + this.size;
    },
    starItems() {
      const LENGTH = 5;
      const CLS_ON = 'on';
      const CLS_HALF = 'half';
      const CLS_OFF = 'off';
      let result = [];
      let score = Math.floor(this.score * 2) / 2;
      //获取整数部分
      let int = Math.floor(this.score);
      //判断小数部分
      let hasDicimal = score % 1 !== 0;
      for (let i = 0; i < int; i++) {
        result.push(CLS_ON);
      }
      if (hasDicimal) {
        result.push(CLS_HALF);
      }
      while (result.length < LENGTH) {
        result.push(CLS_OFF);
      }
      return result;
    }
  }
};
</script>

<style lang="stylus" rel="stylussheet/stylus">
@import '../../common/css/mixin.styl'

#star
  font-size 0
  .star-item
    display inline-block
    background-repeat no-repeat
  &.star-48
    .star-item
      width 20px
      height 20px
      margin-right 8px
      background-size 20px 20px
      &:last-child
        margin-right 0
      &.on
        bg-image('star48_on')
      &.half
        bg-image('star48_half')
      &.off
        bg-image('star48_off')
  &.star-36
    .star-item
      width 15px
      height 15px
      margin-right 5px
      background-size 15px 15px
      &:last-child
        margin-right 0
      &.on
        bg-image('star36_on')
      &.half
        bg-image('star36_half')
      &.off
        bg-image('star36_off')
  &.star-24
    .star-item
      width 10px
      height 10px
      margin-right 3px
      background-size 10px 10px
      &:last-child
        margin-right 0
      &.on
        bg-image('star24_on')
      &.half
        bg-image('star24_half')
      &.off
        bg-image('star24_off')
</style>
