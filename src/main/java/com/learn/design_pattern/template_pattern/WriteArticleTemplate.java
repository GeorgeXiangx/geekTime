package com.learn.design_pattern.template_pattern;

/**
 * Created by XJH on 2020/1/9.
 *
 * @Description:抽象模板类
 */
public abstract class WriteArticleTemplate {

    // 基本方法
    protected abstract void introduction();

    // 基本方法
    protected abstract void actualContent();

    // 基本方法
    protected abstract void theLast();

    // 模板方法
    public final void writeAnCompleteArticle() {
        introduction();
        actualContent();
        theLast();
    }

    public static void main(String[] args) {
        WriteArticleTemplate wat1 = new IWriteArticle();
        wat1.writeAnCompleteArticle();

        WriteArticleTemplate wat2 = new LiBaiWriteArticle();
        wat2.writeAnCompleteArticle();
    }
}
