package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbmq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f76425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbnh f76426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzbnx f76427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbmx f76428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ScheduledExecutorService f76429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbiv f76430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Executor f76431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzbmo f76432h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzbnc f76433i;

    zzbmq() {
    }

    public final zzbmq a(int i3) {
        this.f76425a = 443;
        return this;
    }

    public final zzbmq b(zzbnh zzbnhVar) {
        this.f76426b = (zzbnh) Preconditions.t(zzbnhVar);
        return this;
    }

    public final zzbmq c(zzbnx zzbnxVar) {
        this.f76427c = (zzbnx) Preconditions.t(zzbnxVar);
        return this;
    }

    public final zzbmq d(ScheduledExecutorService scheduledExecutorService) {
        this.f76429e = (ScheduledExecutorService) Preconditions.t(scheduledExecutorService);
        return this;
    }

    public final zzbmq e(zzbmx zzbmxVar) {
        this.f76428d = (zzbmx) Preconditions.t(zzbmxVar);
        return this;
    }

    public final zzbmq f(zzbiv zzbivVar) {
        this.f76430f = (zzbiv) Preconditions.t(zzbivVar);
        return this;
    }

    public final zzbmq g(Executor executor) {
        this.f76431g = executor;
        return this;
    }

    public final zzbmq h(zzbmo zzbmoVar) {
        this.f76432h = zzbmoVar;
        return this;
    }

    public final zzbmq i(zzbnc zzbncVar) {
        this.f76433i = zzbncVar;
        return this;
    }

    public final zzbmr j() {
        return new zzbmr(this, null);
    }

    final /* synthetic */ Integer k() {
        return this.f76425a;
    }

    final /* synthetic */ zzbnh l() {
        return this.f76426b;
    }

    final /* synthetic */ zzbnx m() {
        return this.f76427c;
    }

    final /* synthetic */ zzbmx n() {
        return this.f76428d;
    }

    final /* synthetic */ ScheduledExecutorService o() {
        return this.f76429e;
    }

    final /* synthetic */ zzbiv p() {
        return this.f76430f;
    }

    final /* synthetic */ Executor q() {
        return this.f76431g;
    }

    final /* synthetic */ zzbmo r() {
        return this.f76432h;
    }

    final /* synthetic */ zzbnc s() {
        return this.f76433i;
    }
}
