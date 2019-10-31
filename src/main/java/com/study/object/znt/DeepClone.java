package com.study.object.znt;


/**
 * @author  znt
 * @description  深拷贝
 * @Date 2019/10/31
 */

public class DeepClone implements Cloneable {
    private int c;
    private int[] d;

    @Override
    public Object clone(){
        DeepClone sc = null;
        try
        {
            sc = (DeepClone) super.clone();
            int[] t = sc.getD();
            int[] b1 = new int[t.length];
            for (int i = 0; i < b1.length; i++) {
                b1[i] = t[i];
            }
            sc.setD(b1);
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return sc;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int[] getD() {
        return d;
    }

    public void setD(int[] d) {
        this.d = d;
    }


}
