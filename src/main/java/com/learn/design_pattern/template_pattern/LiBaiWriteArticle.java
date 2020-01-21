package com.learn.design_pattern.template_pattern;

/**
 * Created by XJH on 2020/1/9.
 *
 * @Description:
 */
public class LiBaiWriteArticle extends WriteArticleTemplate {

    @Override
    protected void introduction() {
        System.out.println("床前明月光");
    }

    @Override
    protected void actualContent() {
        System.out.println("疑是地上霜");
    }

    @Override
    protected void theLast() {
        System.out.println("举头望明月");
    }
}
