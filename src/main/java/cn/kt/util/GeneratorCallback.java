package cn.kt.util;

import org.mybatis.generator.api.ProgressCallback;

/**
 * mybatis generator进度回调
 * Created by kangtian on 2018/7/17.
 */
public class GeneratorCallback implements ProgressCallback {
    @Override
    public void introspectionStarted(int i) {
        System.out.println("Mybatis generator message: introspection started [" + i + "].");
    }

    @Override
    public void generationStarted(int i) {
        System.out.println("Mybatis generator message: generation started [" + i + "].");
    }

    @Override
    public void saveStarted(int i) {
        System.out.println("Mybatis generator message: save started [" + i + "].");
    }

    @Override
    public void startTask(String s) {
        System.out.println("Starting mybatis generator task: " + s);
    }

    @Override
    public void done() {
        System.out.println("Finish mybatis generator task!");
    }

    @Override
    public void checkCancel() throws InterruptedException {
    }
}
