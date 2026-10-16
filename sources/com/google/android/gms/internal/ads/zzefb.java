package com.google.android.gms.internal.ads;

import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzefb implements zzimu {
    public static zzefb zza() {
        return zzefa.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        com.google.android.gms.ads.internal.zzt.g();
        String string = UUID.randomUUID().toString();
        zzinc.zzb(string);
        return string;
    }
}
