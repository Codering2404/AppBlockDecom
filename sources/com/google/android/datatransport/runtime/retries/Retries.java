package com.google.android.datatransport.runtime.retries;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Retries {
    public static Object a(int i3, Object obj, Function function, RetryStrategy retryStrategy) {
        Object objApply;
        if (i3 < 1) {
            return function.apply(obj);
        }
        do {
            objApply = function.apply(obj);
            obj = retryStrategy.a(obj, objApply);
            if (obj == null) {
                break;
            }
            i3--;
        } while (i3 >= 1);
        return objApply;
    }
}
