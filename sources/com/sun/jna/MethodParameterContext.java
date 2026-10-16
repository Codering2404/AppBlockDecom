package com.sun.jna;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class MethodParameterContext extends FunctionParameterContext {
    private Method method;

    MethodParameterContext(Function function, Object[] objArr, int i3, Method method) {
        super(function, objArr, i3);
        this.method = method;
    }

    public Method getMethod() {
        return this.method;
    }
}
