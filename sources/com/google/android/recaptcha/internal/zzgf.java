package com.google.android.recaptcha.internal;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzgf {
    private final zzge zza;
    private final HashMap zzb;
    private final zzfw zzc;
    private final zzcg zzd;

    public zzgf(zzfw zzfwVar, zzcg zzcgVar, zzbo zzboVar) {
        this.zzc = zzfwVar;
        this.zzd = zzcgVar;
        zzge zzgeVar = new zzge();
        this.zza = zzgeVar;
        HashMap map = new HashMap();
        this.zzb = map;
        zzgeVar.zzd(173, map);
    }

    public final zzge zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zza.zzc();
        this.zza.zzd(173, this.zzb);
    }

    public final zzcg zzc() {
        return this.zzd;
    }

    public final zzfw zzd() {
        return this.zzc;
    }

    public final void zze(int i3, Object obj) {
        this.zzb.put(Integer.valueOf(i3 - 2), obj);
    }
}
