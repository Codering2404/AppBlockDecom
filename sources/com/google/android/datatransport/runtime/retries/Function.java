package com.google.android.datatransport.runtime.retries;

import java.lang.Throwable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface Function<TInput, TResult, TException extends Throwable> {
    Object apply(Object obj);
}
