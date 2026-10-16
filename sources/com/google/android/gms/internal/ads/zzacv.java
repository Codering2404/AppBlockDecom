package com.google.android.gms.internal.ads;

import android.view.Surface;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzacv implements zzaeu {
    private final zzadu zza;
    private final zzadv zzb;
    private final zzaec zzc;
    private final Queue zzd;
    private Surface zze;
    private zzv zzf;
    private long zzg;
    private zzaer zzh;
    private Executor zzi;
    private zzadr zzj;

    public zzacv(zzadu zzaduVar, zzadv zzadvVar, zzdo zzdoVar) {
        this.zza = zzaduVar;
        this.zzb = zzadvVar;
        zzaduVar.zzg(zzdoVar);
        this.zzc = new zzaec(new zzacu(this, null), zzaduVar, zzadvVar);
        this.zzd = new ArrayDeque();
        this.zzf = new zzt().zzO();
        this.zzg = -9223372036854775807L;
        this.zzh = zzaer.zzb;
        this.zzi = zzacq.zza;
        this.zzj = zzaco.zza;
    }

    final /* synthetic */ Surface zzA() {
        return this.zze;
    }

    final /* synthetic */ zzaer zzB() {
        return this.zzh;
    }

    final /* synthetic */ Executor zzC() {
        return this.zzi;
    }

    final /* synthetic */ zzadr zzD() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zza() {
        this.zzb.zzd();
        this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzb() {
        this.zzb.zzd();
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzc(zzaer zzaerVar, Executor executor) {
        this.zzh = zzaerVar;
        this.zzi = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzd(zzv zzvVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zze() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzf() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzg(boolean z2) {
        if (z2) {
            this.zza.zzl();
        }
        this.zzb.zzd();
        this.zzc.zza();
        this.zzd.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh(boolean z2) {
        return this.zza.zzi(z2);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzi() {
        this.zzc.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzj() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final Surface zzk() {
        Surface surface = this.zze;
        surface.getClass();
        return surface;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzl(zzadr zzadrVar) {
        this.zzj = zzadrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzm(float f3) {
        this.zza.zzn(f3);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzn(List list) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzo(long j3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzp(Surface surface, zzeu zzeuVar) {
        this.zze = surface;
        this.zza.zzd(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzq() {
        this.zze = null;
        this.zza.zzd(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzr(int i3) {
        this.zza.zzm(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzs(int i3, zzv zzvVar, long j3, int i4, List list) {
        zzgtj.zzi(list.isEmpty());
        int i5 = zzvVar.zzw;
        zzv zzvVar2 = this.zzf;
        if (i5 != zzvVar2.zzw || zzvVar.zzx != zzvVar2.zzx) {
            this.zzc.zzc(i5, zzvVar.zzx);
        }
        float f3 = zzvVar.zzA;
        if (f3 != this.zzf.zzA) {
            this.zza.zze(f3);
        }
        this.zzf = zzvVar;
        if (j3 != this.zzg) {
            this.zzc.zzd(i4, j3);
            this.zzg = j3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzt() {
        this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzu(long j3, zzaes zzaesVar) {
        this.zzd.add(zzaesVar);
        this.zzc.zze(j3);
        this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzacp
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzy();
            }
        });
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzv(long j3, long j4) throws zzaet {
        try {
            this.zzc.zzb(j3, j4);
        } catch (zzjk e3) {
            throw new zzaet(e3, this.zzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzw(boolean z2) {
        this.zza.zzj(z2);
    }

    final /* synthetic */ void zzy() {
        this.zzh.zza();
    }

    final /* synthetic */ Queue zzz() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final void zzx() {
    }
}
