package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zaq {
    ExecutorService zaa(ThreadFactory threadFactory, int i3);

    ExecutorService zab(int i3, int i4);

    ExecutorService zac(int i3, ThreadFactory threadFactory, int i4);
}
