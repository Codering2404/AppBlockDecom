package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzpa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f74416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f74417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Bundle f74418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzpb f74419d;

    zzpa(zzpb zzpbVar, String str, String str2, Bundle bundle) {
        this.f74416a = str;
        this.f74417b = str2;
        this.f74418c = bundle;
        Objects.requireNonNull(zzpbVar);
        this.f74419d = zzpbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpg zzpgVar = this.f74419d.f74420a;
        zzpp zzppVarN0 = zzpgVar.N0();
        long jCurrentTimeMillis = zzpgVar.e().currentTimeMillis();
        String str = this.f74416a;
        zzpgVar.i((zzbg) Preconditions.m(zzppVarN0.R(str, this.f74417b, this.f74418c, "auto", jCurrentTimeMillis, false, true)), str);
    }
}
