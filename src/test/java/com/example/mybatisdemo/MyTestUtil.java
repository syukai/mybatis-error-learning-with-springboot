package com.example.mybatisdemo;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyTestUtil {
    /***
     * assertThrowsしつつstacktrace流す
     * @param expectedType
     * @param exec
     * @return
     * @param <T>
     */
    public static <T extends Throwable> T myAssertThrows(Class<T> expectedType , org.junit.jupiter.api.function.Executable exec) {
        assertThrows(expectedType,()-> {
            try {
                exec.execute();
            } catch (Throwable ex) {
                ex.printStackTrace();
                throw ex;
            }
        });
        return null;
    }
}
