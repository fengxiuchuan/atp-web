package com.atp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestProperties {

    @Value("${org.codingworld.test.name}")
    private String name;
    @Value("${org.codingworld.test.thing}")
    private String thing;
    @Value("${org.codingworld.test.num}")
    private Integer num;

    @Value("${org.codingworld.test.bignum}")
    private Long bigNum;

    @Value("${org.codingworld.test.num2}")
    private Integer num2;

    @Value("${org.codingworld.test.num3}")
    private Integer num3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getBigNum() {
        return bigNum;
    }

    public void setBigNum(Long bigNum) {
        this.bigNum = bigNum;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer getNum3() {
        return num3;
    }

    public void setNum3(Integer num3) {
        this.num3 = num3;
    }
}
