package com.learn.test.inner_class;

/**
 * Created by XJH on 2019/10/24.
 *
 * @Description:
 */
public class OuterForInnerInterface {

    public void outerNum(int k, Inner inner) {
        TestNum testNum = new TestNum();
        testNum.setValue(k);

        int res = inner.process(testNum);
    }


    public interface Inner {
        int process(TestNum testNum);
    }

    public static void main(String[] args) {
        OuterForInnerInterface outer = new OuterForInnerInterface();

        int o = -1;

        outer.outerNum(10, new Inner() {
            @Override
            public int process(TestNum testNum) {
//                o = testNum.getValue();
                return 0;
            }
        });
    }
}
