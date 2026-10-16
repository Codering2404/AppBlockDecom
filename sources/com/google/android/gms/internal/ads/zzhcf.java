package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzhcf extends ScheduledFuture, ListenableFuture {
    @Override // com.google.common.util.concurrent.ListenableFuture
    /* synthetic */ void addListener(Runnable runnable, Executor executor);
}
