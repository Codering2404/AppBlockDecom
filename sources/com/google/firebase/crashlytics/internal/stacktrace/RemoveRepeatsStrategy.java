package com.google.firebase.crashlytics.internal.stacktrace;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class RemoveRepeatsStrategy implements StackTraceTrimmingStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f89094a;

    public RemoveRepeatsStrategy(int i3) {
        this.f89094a = i3;
    }

    private static boolean b(StackTraceElement[] stackTraceElementArr, int i3, int i4) {
        int i5 = i4 - i3;
        if (i4 + i5 > stackTraceElementArr.length) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (!stackTraceElementArr[i3 + i6].equals(stackTraceElementArr[i4 + i6])) {
                return false;
            }
        }
        return true;
    }

    private static StackTraceElement[] c(StackTraceElement[] stackTraceElementArr, int i3) {
        int i4;
        HashMap map = new HashMap();
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[stackTraceElementArr.length];
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (i5 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i5];
            Integer num = (Integer) map.get(stackTraceElement);
            if (num == null || !b(stackTraceElementArr, num.intValue(), i5)) {
                stackTraceElementArr2[i6] = stackTraceElementArr[i5];
                i6++;
                i7 = 1;
                i4 = i5;
            } else {
                int iIntValue = i5 - num.intValue();
                if (i7 < i3) {
                    System.arraycopy(stackTraceElementArr, i5, stackTraceElementArr2, i6, iIntValue);
                    i6 += iIntValue;
                    i7++;
                }
                i4 = (iIntValue - 1) + i5;
            }
            map.put(stackTraceElement, Integer.valueOf(i5));
            i5 = i4 + 1;
        }
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[i6];
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, 0, i6);
        return stackTraceElementArr3;
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] stackTraceElementArrC = c(stackTraceElementArr, this.f89094a);
        return stackTraceElementArrC.length < stackTraceElementArr.length ? stackTraceElementArrC : stackTraceElementArr;
    }
}
