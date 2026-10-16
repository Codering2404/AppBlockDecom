package com.sun.jna;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class FunctionParameterContext extends ToNativeContext {
    private Object[] args;
    private Function function;
    private int index;

    FunctionParameterContext(Function function, Object[] objArr, int i3) {
        this.function = function;
        this.args = objArr;
        this.index = i3;
    }

    public Function getFunction() {
        return this.function;
    }

    public int getParameterIndex() {
        return this.index;
    }

    public Object[] getParameters() {
        return this.args;
    }
}
