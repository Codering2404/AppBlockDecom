package com.google.firebase.crashlytics.internal.stacktrace;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MiddleOutStrategy implements StackTraceTrimmingStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f89093a;

    public MiddleOutStrategy(int i3) {
        this.f89093a = i3;
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i3 = this.f89093a;
        if (length <= i3) {
            return stackTraceElementArr;
        }
        int i4 = i3 / 2;
        int i5 = i3 - i4;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i3];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i5);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i4, stackTraceElementArr2, i5, i4);
        return stackTraceElementArr2;
    }
}
