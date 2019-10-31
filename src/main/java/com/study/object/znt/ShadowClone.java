package com.study.object.znt;


/**
 * @author  znt
 * @description  浅拷贝
 * @Date 2019/10/31
 */

public class ShadowClone implements Cloneable {

    private int a;
    private int[] b;

    public ShadowClone(){}

    public ShadowClone(int a,int init){
        this.a=a;
        this.b=new int[]{init};
    }

    @Override
    public ShadowClone clone(){
        ShadowClone sc = null;
        try{
            sc = (ShadowClone)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return sc;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int[] getB() {
        return b;
    }

    public void setB(int[] b) {
        this.b = b;
    }



}
