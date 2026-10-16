package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbmr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f76434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbnh f76435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbnx f76436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbmx f76437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ScheduledExecutorService f76438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbiv f76439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Executor f76440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbmo f76441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbnc f76442i;

    /* synthetic */ zzbmr(zzbmq zzbmqVar, byte[] bArr) {
        this.f76434a = ((Integer) Preconditions.u(zzbmqVar.k(), "defaultPort not set")).intValue();
        this.f76435b = (zzbnh) Preconditions.u(zzbmqVar.l(), "proxyDetector not set");
        this.f76436c = (zzbnx) Preconditions.u(zzbmqVar.m(), "syncContext not set");
        this.f76437d = (zzbmx) Preconditions.u(zzbmqVar.n(), "serviceConfigParser not set");
        this.f76438e = zzbmqVar.o();
        this.f76439f = zzbmqVar.p();
        this.f76440g = zzbmqVar.q();
        this.f76441h = zzbmqVar.r();
        this.f76442i = zzbmqVar.s();
    }

    public static zzbmq g() {
        return new zzbmq();
    }

    public final int a() {
        return this.f76434a;
    }

    public final zzbnh b() {
        return this.f76435b;
    }

    public final zzbnx c() {
        return this.f76436c;
    }

    public final ScheduledExecutorService d() {
        ScheduledExecutorService scheduledExecutorService = this.f76438e;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService;
        }
        throw new IllegalStateException("ScheduledExecutorService not set in Builder");
    }

    public final zzbmx e() {
        return this.f76437d;
    }

    public final Executor f() {
        return this.f76440g;
    }

    public final String toString() {
        return MoreObjects.c(this).b("defaultPort", this.f76434a).d("proxyDetector", this.f76435b).d("syncContext", this.f76436c).d("serviceConfigParser", this.f76437d).d("customArgs", null).d("scheduledExecutorService", this.f76438e).d("channelLogger", this.f76439f).d("executor", this.f76440g).d("overrideAuthority", null).d("metricRecorder", this.f76441h).d("nameResolverRegistry", this.f76442i).toString();
    }
}
