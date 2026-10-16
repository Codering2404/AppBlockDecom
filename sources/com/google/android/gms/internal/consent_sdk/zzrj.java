package com.google.android.gms.internal.consent_sdk;

import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrj {
    private final zzri zza;

    private zzrj(zzsz zzszVar, Object obj, zzsz zzszVar2, Object obj2) {
        this.zza = new zzri(zzszVar, "", zzszVar2, obj2);
    }

    static int zzb(zzri zzriVar, Object obj, Object obj2) {
        return zzqf.zza(zzriVar.zza, 1, obj) + zzqf.zza(zzriVar.zzb, 2, obj2);
    }

    public final int zza(int i3, Object obj, Object obj2) {
        zzri zzriVar = this.zza;
        int iZzC = zzpv.zzC(i3 << 3);
        int iZzb = zzb(zzriVar, obj, obj2);
        return iZzC + zzpv.zzC(iZzb) + iZzb;
    }

    final zzri zzc() {
        return this.zza;
    }

    public static zzrj zzd(zzsz zzszVar, Object obj, zzsz zzszVar2, Object obj2) {
        return new zzrj(zzszVar, tDEtWsFLJfe.KaRgWtlPBFF, zzszVar2, obj2);
    }
}
