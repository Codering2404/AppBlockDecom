package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhw implements zzho {
    private zzin zzb;
    private String zzc;
    private boolean zzf;
    private final zzih zza = new zzih();
    private int zzd = 8000;
    private int zze = 8000;

    public final zzhw zzb(String str) {
        this.zzc = str;
        return this;
    }

    public final zzhw zzc(int i3) {
        this.zzd = i3;
        return this;
    }

    public final zzhw zzd(int i3) {
        this.zze = i3;
        return this;
    }

    public final zzhw zze(boolean z2) {
        this.zzf = true;
        return this;
    }

    public final zzhw zzf(zzin zzinVar) {
        this.zzb = zzinVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzho
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzia zza() {
        zzia zziaVar = new zzia(this.zzc, this.zzd, this.zze, this.zzf, false, this.zza, null, false, null);
        zzin zzinVar = this.zzb;
        if (zzinVar != null) {
            zziaVar.zze(zzinVar);
        }
        return zziaVar;
    }
}
