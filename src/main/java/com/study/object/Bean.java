package com.study.object;

public class Bean implements Cloneable {

    private String name;
    private String firstSign;//获取名字首字母
    public Bean(String name) {
        this.name = name;
        if (name.length() != 0) {
            firstSign = name.substring(0, 1);
            firstSign += "abc";
        }
    }

    @Override
    protected Bean clone() throws CloneNotSupportedException {
        return (Bean) super.clone();
    }
}
