package com.google.android.gms.internal.consent_sdk;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdo {
    private final zzdk zza;

    private zzdo(zzdk zzdkVar) {
        int i3 = zzdg.zzb;
        this.zza = zzdkVar;
    }

    public static zzdo zza(char c3) {
        return new zzdo(new zzdk(new zzde(',')));
    }

    static /* bridge */ /* synthetic */ Iterator zzc(zzdo zzdoVar, CharSequence charSequence) {
        return new zzdl(zzdoVar, charSequence, zzdoVar.zza.zza);
    }

    public final Iterable zzb(CharSequence charSequence) {
        return new zzdm(this, charSequence);
    }
}
