package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfmc implements zzimu {
    private zzfmc(zzfmb zzfmbVar) {
    }

    public static zzfmc zza(zzfmb zzfmbVar) {
        return new zzfmc(zzfmbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        Clock clockC = DefaultClock.c();
        zzinc.zzb(clockC);
        return clockC;
    }
}
