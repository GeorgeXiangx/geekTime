package com.learn.design_pattern.template_pattern;

/**
 * Created by XJH on 2020/1/9.
 *
 * @Description:具体模板类
 */
public class IWriteArticle extends WriteArticleTemplate{
    @Override
    protected void introduction() {
        System.out.println("床前有xx");
    }

    @Override
    protected void actualContent() {
        System.out.println("李白想xx");
    }

    @Override
    protected void theLast() {
        System.out.println("越想越心慌");
    }
}
