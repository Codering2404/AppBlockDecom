package com.sun.jna;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class MethodResultContext extends FunctionResultContext {
    private final Method method;

    MethodResultContext(Class<?> cls, Function function, Object[] objArr, Method method) {
        super(cls, function, objArr);
        this.method = method;
    }

    public Method getMethod() {
        return this.method;
    }
}
