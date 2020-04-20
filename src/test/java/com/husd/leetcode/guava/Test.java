package com.husd.leetcode.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.math.BigIntegerMath;
import com.google.common.math.DoubleMath;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 这里是这个类的功能描述
 *
 * @author hushengdong
 * @date 2020/4/17
 */
public class Test {

    @org.junit.Test
    public void test() {

        int a = 4;
        Integer a1 = 4;
        Integer b1 = 5;
        Objects.isNull(a);
        Preconditions.checkNotNull(a);
        Preconditions.checkArgument(a == 4);
        com.google.common.base.Objects.equal(a, 4);

        //懒比较
        ComparisonChain.start().compare(a, 4).compare(a, 5).compare(a1, b1).result();

        // Ordering<Person> ordering = Ordering.natural().nullsFirst().onResultOf();

        //不可变的list
        ImmutableList<Integer> finalList = ImmutableList.of(11, 2, 3, 4, 5);
        finalList.stream().forEach(item -> {
            System.out.println(item);
        });
    }

    @org.junit.Test
    public void test2() {

        //连接
        String s = Joiner.on(",").join(Arrays.asList(1, 5, 7));
        //1,5,7
        System.out.println(s);

        //分割
        List<String> l1 = Lists.newArrayList(Splitter.on(',')
                .trimResults()
                //.omitEmptyStrings()
                .split(",a,,b,"));
        System.out.println(l1);

        int logFloor = LongMath.log2(10, RoundingMode.HALF_DOWN);
        int mustNotOverflow = IntMath.checkedMultiply(100, 1000000);
        long quotient = LongMath.divide(30, 3, RoundingMode.UNNECESSARY); // fail fast on non-multiple of 3
        BigInteger nearestInteger = DoubleMath.roundToBigInteger(100.0, RoundingMode.HALF_EVEN);
        BigInteger sideLength = BigIntegerMath.sqrt(new BigInteger("12334558877"), RoundingMode.CEILING);


    }

    class Person {

        public int age;
    }
}
