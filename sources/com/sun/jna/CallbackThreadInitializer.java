package com.sun.jna;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class CallbackThreadInitializer {
    private boolean daemon;
    private boolean detach;
    private ThreadGroup group;
    private String name;

    public CallbackThreadInitializer() {
        this(true);
    }

    public boolean detach(Callback callback) {
        return this.detach;
    }

    public String getName(Callback callback) {
        return this.name;
    }

    public ThreadGroup getThreadGroup(Callback callback) {
        return this.group;
    }

    public boolean isDaemon(Callback callback) {
        return this.daemon;
    }

    public CallbackThreadInitializer(boolean z2) {
        this(z2, false);
    }

    public CallbackThreadInitializer(boolean z2, boolean z3) {
        this(z2, z3, null);
    }

    public CallbackThreadInitializer(boolean z2, boolean z3, String str) {
        this(z2, z3, str, null);
    }

    public CallbackThreadInitializer(boolean z2, boolean z3, String str, ThreadGroup threadGroup) {
        this.daemon = z2;
        this.detach = z3;
        this.name = str;
        this.group = threadGroup;
    }
}
