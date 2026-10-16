package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzhh implements zzhp {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;
    private zzht zzd;

    protected zzhh(boolean z2) {
        this.zza = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zze(zzin zzinVar) {
        zzinVar.getClass();
        ArrayList arrayList = this.zzb;
        if (arrayList.contains(zzinVar)) {
            return;
        }
        arrayList.add(zzinVar);
        this.zzc++;
    }

    protected final void zzf(zzht zzhtVar) {
        for (int i3 = 0; i3 < this.zzc; i3++) {
            ((zzin) this.zzb.get(i3)).zza(this, zzhtVar, this.zza);
        }
    }

    protected final void zzg(zzht zzhtVar) {
        this.zzd = zzhtVar;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            ((zzin) this.zzb.get(i3)).zzb(this, zzhtVar, this.zza);
        }
    }

    protected final void zzh(int i3) {
        zzht zzhtVar = this.zzd;
        String str = zzfl.zza;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            ((zzin) this.zzb.get(i4)).zzc(this, zzhtVar, this.zza, i3);
        }
    }

    protected final void zzi() {
        zzht zzhtVar = this.zzd;
        String str = zzfl.zza;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            ((zzin) this.zzb.get(i3)).zzd(this, zzhtVar, this.zza);
        }
        this.zzd = null;
    }
}
