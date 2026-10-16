package com.google.android.gms.ads.internal.util.client;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zza implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f70154a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f70155b;

    zza(String str) {
        this.f70155b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f70154a.getAndIncrement();
        int length = String.valueOf(andIncrement).length();
        String str = this.f70155b;
        StringBuilder sb = new StringBuilder(str.length() + 12 + length);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
