package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznh {
    public static final zznh zza = new zznh(new zzng());
    public final zzgww zzb;
    public final Double zzc = null;
    public final Double zzd = null;
    public final boolean zze = true;
    public final boolean zzf = true;
    public final boolean zzi = true;
    public final boolean zzg = true;
    public final boolean zzh = true;

    private zznh(zzng zzngVar) {
        this.zzb = zzngVar.zza();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zznh) && this.zzb.equals(((zznh) obj).zzb);
    }

    public final int hashCode() {
        zzgww zzgwwVar = this.zzb;
        Boolean bool = Boolean.TRUE;
        return Objects.hash(zzgwwVar, null, null, bool, bool, bool, bool, bool);
    }
}
