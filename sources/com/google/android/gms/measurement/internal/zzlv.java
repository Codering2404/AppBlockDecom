package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlv implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f74189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzlu f74190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzlu f74191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f74192d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ zzmb f74193f;

    zzlv(zzmb zzmbVar, Bundle bundle, zzlu zzluVar, zzlu zzluVar2, long j3) {
        this.f74189a = bundle;
        this.f74190b = zzluVar;
        this.f74191c = zzluVar2;
        this.f74192d = j3;
        Objects.requireNonNull(zzmbVar);
        this.f74193f = zzmbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f74193f.A(this.f74189a, this.f74190b, this.f74191c, this.f74192d);
    }
}
