package com.google.firebase.crashlytics.internal.stacktrace;

import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class TrimmedThrowableData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f89095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f89096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StackTraceElement[] f89097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TrimmedThrowableData f89098d;

    private TrimmedThrowableData(String str, String str2, StackTraceElement[] stackTraceElementArr, TrimmedThrowableData trimmedThrowableData) {
        this.f89095a = str;
        this.f89096b = str2;
        this.f89097c = stackTraceElementArr;
        this.f89098d = trimmedThrowableData;
    }

    public static TrimmedThrowableData a(Throwable th, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        Stack stack = new Stack();
        while (th != null) {
            stack.push(th);
            th = th.getCause();
        }
        TrimmedThrowableData trimmedThrowableData = null;
        while (!stack.isEmpty()) {
            Throwable th2 = (Throwable) stack.pop();
            trimmedThrowableData = new TrimmedThrowableData(th2.getLocalizedMessage(), th2.getClass().getName(), stackTraceTrimmingStrategy.a(th2.getStackTrace()), trimmedThrowableData);
        }
        return trimmedThrowableData;
    }
}
