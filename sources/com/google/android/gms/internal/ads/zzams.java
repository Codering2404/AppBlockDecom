package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzams implements zzafy {
    private zzagb zza;
    private zzamz zzb;
    private boolean zzc;

    static {
        int i3 = zzamr.zza;
    }

    @EnsuresNonNullIf
    private final boolean zzh(zzafz zzafzVar) throws IOException {
        zzamu zzamuVar = new zzamu();
        if (zzamuVar.zzc(zzafzVar, true) && (zzamuVar.zza & 2) == 2) {
            int iMin = Math.min(zzamuVar.zze, 8);
            zzet zzetVar = new zzet(iMin);
            zzafzVar.zzi(zzetVar.zzi(), 0, iMin);
            zzetVar.zzh(0);
            if (zzetVar.zzd() >= 5 && zzetVar.zzs() == 127 && zzetVar.zzz() == 1179402563) {
                this.zzb = new zzamq();
            } else {
                zzetVar.zzh(0);
                if (zzhe.zzc(1, zzetVar, true)) {
                    this.zzb = new zzanb();
                } else {
                    zzetVar.zzh(0);
                    if (zzamw.zzd(zzetVar)) {
                        this.zzb = new zzamw();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        try {
            return zzh(zzafzVar);
        } catch (zzat unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zza = zzagbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        this.zza.getClass();
        if (this.zzb == null) {
            if (!zzh(zzafzVar)) {
                throw zzat.zzb("Failed to determine bitstream type", null);
            }
            zzafzVar.zzl();
        }
        if (!this.zzc) {
            zzahk zzahkVarZzu = this.zza.zzu(0, 1);
            this.zza.zzv();
            this.zzb.zze(this.zza, zzahkVarZzu);
            this.zzc = true;
        }
        return this.zzb.zzg(zzafzVar, zzagyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j3, long j4) {
        zzamz zzamzVar = this.zzb;
        if (zzamzVar != null) {
            zzamzVar.zzf(j3, j4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
