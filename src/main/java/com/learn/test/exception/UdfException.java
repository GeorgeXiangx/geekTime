package com.learn.test.exception;

/**
 * Created by XJH on 2020/3/31.
 *
 * @Description:
 */
public class UdfException extends Exception {

    private String mesg;

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public UdfException(String mesg) {
        this.mesg = mesg;
    }
}
