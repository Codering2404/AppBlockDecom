package com.google.firebase.crashlytics.internal.stacktrace;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f89090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StackTraceTrimmingStrategy[] f89091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MiddleOutStrategy f89092c;

    public MiddleOutFallbackStrategy(int i3, StackTraceTrimmingStrategy... stackTraceTrimmingStrategyArr) {
        this.f89090a = i3;
        this.f89091b = stackTraceTrimmingStrategyArr;
        this.f89092c = new MiddleOutStrategy(i3);
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f89090a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArrA = stackTraceElementArr;
        for (StackTraceTrimmingStrategy stackTraceTrimmingStrategy : this.f89091b) {
            if (stackTraceElementArrA.length <= this.f89090a) {
                break;
            }
            stackTraceElementArrA = stackTraceTrimmingStrategy.a(stackTraceElementArr);
        }
        return stackTraceElementArrA.length > this.f89090a ? this.f89092c.a(stackTraceElementArrA) : stackTraceElementArrA;
    }
}
