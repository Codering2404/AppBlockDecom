package com.google.android.gms.ads.internal.util.client;

import com.google.android.gms.common.api.Api;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f70156a = new ThreadPoolExecutor(2, Api.BaseClientBuilder.API_PRIORITY_OTHER, 10, TimeUnit.SECONDS, new SynchronousQueue(), new zza("ClientDefault"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f70157b = Executors.newSingleThreadExecutor(new zza("ClientSingle"));
}
