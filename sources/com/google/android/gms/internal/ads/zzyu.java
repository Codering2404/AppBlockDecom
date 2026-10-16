package com.google.android.gms.internal.ads;

import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyu extends zzwj implements zzyi {
    private final zzho zza;
    private final zzyc zzb;
    private final zzun zzc;
    private final int zzd;
    private boolean zze = true;
    private long zzf = -9223372036854775807L;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private zzin zzj;
    private zzak zzk;
    private final zzabu zzl;

    /* synthetic */ zzyu(zzak zzakVar, zzho zzhoVar, zzyc zzycVar, zzun zzunVar, zzabu zzabuVar, int i3, boolean z2, int i4, zzv zzvVar, zzgub zzgubVar, byte[] bArr) {
        this.zzk = zzakVar;
        this.zza = zzhoVar;
        this.zzb = zzycVar;
        this.zzc = zzunVar;
        this.zzl = zzabuVar;
        this.zzd = i3;
    }

    private final void zzu() {
        long j3 = this.zzf;
        boolean z2 = this.zzg;
        boolean z3 = this.zzh;
        zzak zzakVarZzJ = zzJ();
        zzbf zzzgVar = new zzzg(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j3, j3, 0L, 0L, z2, false, false, null, zzakVarZzJ, z3 ? zzakVarZzJ.zzc : null);
        if (this.zze) {
            zzzgVar = new zzyr(this, zzzgVar);
        }
        zze(zzzgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final synchronized void zzA(zzak zzakVar) {
        this.zzk = zzakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzD(zzxi zzxiVar) {
        ((zzyq) zzxiVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final zzxi zzG(zzxk zzxkVar, zzabl zzablVar, long j3) {
        zzhp zzhpVarZza = this.zza.zza();
        zzin zzinVar = this.zzj;
        if (zzinVar != null) {
            zzhpVarZza.zze(zzinVar);
        }
        zzag zzagVar = zzJ().zzb;
        zzagVar.getClass();
        return new zzyq(zzagVar.zza, zzhpVarZza, this.zzb.zza(zzk()), this.zzc, zzh(zzxkVar), this.zzl, zzf(zzxkVar), this, zzablVar, null, this.zzd, false, 0, null, zzfl.zzs(-9223372036854775807L), null);
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final synchronized zzak zzJ() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    protected final void zza(zzin zzinVar) {
        this.zzj = zzinVar;
        Looper.myLooper().getClass();
        zzk();
        zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void zzb(long j3, zzahb zzahbVar, boolean z2) {
        if (this.zzi && zzahbVar.zzj()) {
            return;
        }
        this.zzi = !zzahbVar.zzj();
        if (j3 == -9223372036854775807L) {
            j3 = this.zzf;
        }
        boolean zZzb = zzahbVar.zzb();
        if (!this.zze && this.zzf == j3 && this.zzg == zZzb && this.zzh == z2) {
            return;
        }
        this.zzf = j3;
        this.zzg = zZzb;
        this.zzh = z2;
        this.zze = false;
        zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    protected final void zzd() {
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final void zzt() {
    }
}
