package com.google.android.gms.measurement.internal;

import android.util.Log;
import com.revenuecat.purchases.common.Constants;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgr implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f73716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f73717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f73718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Object f73719d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Object f73720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ zzgu f73721g;

    zzgr(zzgu zzguVar, int i3, String str, Object obj, Object obj2, Object obj3) {
        this.f73716a = i3;
        this.f73717b = str;
        this.f73718c = obj;
        this.f73719d = obj2;
        this.f73720f = obj3;
        Objects.requireNonNull(zzguVar);
        this.f73721g = zzguVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgu zzguVar = this.f73721g;
        zzhh zzhhVarX = zzguVar.f73997a.x();
        if (!zzhhVarX.k()) {
            Log.println(6, zzguVar.z(), "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (zzguVar.D() == 0) {
            zzic zzicVar = zzguVar.f73997a;
            if (zzicVar.w().B()) {
                zzicVar.c();
                zzguVar.E('C');
            } else {
                zzicVar.c();
                zzguVar.E('c');
            }
        }
        if (zzguVar.F() < 0) {
            zzguVar.f73997a.w().A();
            zzguVar.G(133005L);
        }
        int i3 = this.f73716a;
        char cD = zzguVar.D();
        long jF = zzguVar.F();
        String str = this.f73717b;
        Object obj = this.f73718c;
        Object obj2 = this.f73719d;
        Object obj3 = this.f73720f;
        char cCharAt = "01VDIWEA?".charAt(i3);
        String strA = zzgu.A(true, str, obj, obj2, obj3);
        int length = String.valueOf(cCharAt).length();
        StringBuilder sb = new StringBuilder(length + 1 + String.valueOf(cD).length() + String.valueOf(jF).length() + 1 + strA.length());
        sb.append("2");
        sb.append(cCharAt);
        sb.append(cD);
        sb.append(jF);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(strA);
        String string = sb.toString();
        if (string.length() > 1024) {
            string = str.substring(0, 1024);
        }
        zzhf zzhfVar = zzhhVarX.f73811e;
        if (zzhfVar != null) {
            zzhfVar.a(string, 1L);
        }
    }
}
