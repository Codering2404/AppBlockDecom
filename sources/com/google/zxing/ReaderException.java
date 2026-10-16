package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class ReaderException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final boolean f91622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final StackTraceElement[] f91623b;

    static {
        f91622a = System.getProperty("surefire.test.class.path") != null;
        f91623b = new StackTraceElement[0];
    }

    ReaderException() {
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
