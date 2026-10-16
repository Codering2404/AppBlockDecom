package com.google.android.gms.common;

import com.google.android.gms.internal.common.zzah;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GmsSignatureVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final zzab f71446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzab f71447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap f71448c;

    static {
        zzaa zzaaVar = new zzaa();
        zzaaVar.a("com.google.android.gms");
        zzaaVar.b(204200000L);
        zzm zzmVar = zzo.f72340f;
        zzaaVar.c(zzah.zzm(zzmVar.h5(), zzo.f72338d.h5(), zzo.f72336b.h5()));
        zzm zzmVar2 = zzo.f72339e;
        byte[] bArrH5 = zzmVar2.h5();
        zzm zzmVar3 = zzo.f72337c;
        zzaaVar.d(zzah.zzm(bArrH5, zzmVar3.h5(), zzo.f72335a.h5()));
        f71446a = zzaaVar.e();
        zzaa zzaaVar2 = new zzaa();
        zzaaVar2.a("com.android.vending");
        zzaaVar2.b(82240000L);
        zzaaVar2.c(zzah.zzk(zzmVar.h5()));
        zzaaVar2.d(zzah.zzl(zzmVar2.h5(), zzmVar3.h5()));
        f71447b = zzaaVar2.e();
        f71448c = new HashMap();
    }
}
