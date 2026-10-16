package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.query.QueryInfo;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final QueryInfo f70756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f70757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f70758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f70759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f70760e = new AtomicBoolean(false);

    public zzl(QueryInfo queryInfo, String str, long j3, int i3) {
        this.f70756a = queryInfo;
        this.f70757b = str;
        this.f70758c = j3;
        this.f70759d = i3;
    }

    public final QueryInfo a() {
        return this.f70756a;
    }

    public final String b() {
        return this.f70757b;
    }

    public final boolean c() {
        return this.f70758c <= com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
    }

    public final int d() {
        return this.f70759d;
    }

    public final boolean e() {
        return this.f70760e.get();
    }

    public final void f() {
        this.f70760e.set(true);
    }
}
