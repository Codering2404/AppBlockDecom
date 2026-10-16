package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzob {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzoc f74366a;

    zzob(zzoc zzocVar) {
        Objects.requireNonNull(zzocVar);
        this.f74366a = zzocVar;
    }

    final void a() {
        zzoc zzocVar = this.f74366a;
        zzocVar.h();
        zzic zzicVar = zzocVar.f73997a;
        if (zzicVar.x().A(zzicVar.e().currentTimeMillis())) {
            zzicVar.x().f73819m.b(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                zzicVar.a().w().a("Detected application was in foreground");
                c(zzicVar.e().currentTimeMillis(), false);
            }
        }
    }

    final void b(long j3, boolean z2) {
        zzoc zzocVar = this.f74366a;
        zzocVar.h();
        zzocVar.q();
        zzic zzicVar = zzocVar.f73997a;
        if (zzicVar.x().A(j3)) {
            zzicVar.x().f73819m.b(true);
            zzocVar.f73997a.L().p();
        }
        zzicVar.x().f73823q.b(j3);
        if (zzicVar.x().f73819m.a()) {
            c(j3, z2);
        }
    }

    final void c(long j3, boolean z2) {
        zzoc zzocVar = this.f74366a;
        zzocVar.h();
        if (zzocVar.f73997a.g()) {
            zzic zzicVar = zzocVar.f73997a;
            zzicVar.x().f73823q.b(j3);
            zzicVar.a().w().b("Session started, time", Long.valueOf(zzicVar.e().a()));
            long j4 = j3 / 1000;
            zzic zzicVar2 = zzocVar.f73997a;
            zzicVar2.B().B("auto", "_sid", Long.valueOf(j4), j3);
            zzicVar.x().f73824r.b(j4);
            zzicVar.x().f73819m.b(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j4);
            zzicVar2.B().u("auto", "_s", j3, bundle);
            String strA = zzicVar.x().f73829w.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strA);
            zzicVar2.B().u("auto", "_ssr", j3, bundle2);
        }
    }
}
