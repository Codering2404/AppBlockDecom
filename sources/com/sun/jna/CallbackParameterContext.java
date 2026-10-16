package com.sun.jna;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class CallbackParameterContext extends FromNativeContext {
    private Object[] args;
    private int index;
    private Method method;

    CallbackParameterContext(Class<?> cls, Method method, Object[] objArr, int i3) {
        super(cls);
        this.method = method;
        this.args = objArr;
        this.index = i3;
    }

    public Object[] getArguments() {
        return this.args;
    }

    public int getIndex() {
        return this.index;
    }

    public Method getMethod() {
        return this.method;
    }
}
