package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzti implements zzqt {
    final /* synthetic */ zztr zza;
    private final zzre zzb;

    /* synthetic */ zzti(zztr zztrVar, zzre zzreVar, byte[] bArr) {
        Objects.requireNonNull(zztrVar);
        this.zza = zztrVar;
        this.zzb = zzreVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqt
    public final void zza(long j3) {
        zztr zztrVar = this.zza;
        if (equals(zztrVar.zzJ()) && zztrVar.zzK() != null) {
            zztx zztxVar = ((zztw) zztrVar.zzK()).zza;
            zztxVar.zzaC(true);
            zztxVar.zzaz().zzd(j3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqt
    public final void zzb() {
        zzmz zzmzVarZzbc;
        zztr zztrVar = this.zza;
        if (equals(zztrVar.zzJ()) && zztrVar.zzK() != null && zztrVar.zzP() && (zzmzVarZzbc = ((zztw) zztrVar.zzK()).zza.zzbc()) != null) {
            zzmzVarZzbc.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqt
    public final void zzc() {
        zztr zztrVar = this.zza;
        if (equals(zztrVar.zzJ()) && zztrVar.zzN()) {
            zztrVar.zzO(true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqt
    public final void zzd() {
        long jZzt;
        zztr zztrVar = this.zza;
        if (equals(zztrVar.zzJ()) && zztrVar.zzK() != null) {
            if (zztrVar.zzL().zzi() != -1) {
                long jZzi = zztrVar.zzL().zzj().zze / zztrVar.zzL().zzi();
                zzqv zzqvVarZzM = zztrVar.zzM();
                zzqvVarZzM.getClass();
                jZzt = zzfl.zzt(jZzi, zzqvVarZzM.zzi());
            } else {
                jZzt = -9223372036854775807L;
            }
            ((zztw) zztrVar.zzK()).zza.zzaz().zze(zztrVar.zzL().zzj().zze, zzfl.zzr(jZzt), SystemClock.elapsedRealtime() - zztrVar.zzQ());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqt
    public final void zze() {
        zztr.zza.getAndDecrement();
        zztr zztrVar = this.zza;
        if (zztrVar.zzK() != null) {
            zzre zzreVar = this.zzb;
            ((zztw) zztrVar.zzK()).zza.zzaz().zzl(new zzry(zzreVar.zza, zzreVar.zzb, zzreVar.zzc, false, false, zzreVar.zze));
        }
    }
}
