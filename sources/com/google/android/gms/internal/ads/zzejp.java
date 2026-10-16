package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzbhv;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzejp implements zzfpl {
    private final zzejd zza;
    private final zzejh zzb;

    zzejp(zzejd zzejdVar, zzejh zzejhVar) {
        this.zza = zzejdVar;
        this.zzb = zzejhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdM(zzfpe zzfpeVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhh)).booleanValue()) {
            if (zzfpe.zzd == zzfpeVar) {
                this.zza.zzg(com.google.android.gms.ads.internal.zzt.o().a());
                return;
            }
            if (zzfpe.PRELOADED_LOADER == zzfpeVar || zzfpe.SERVER_TRANSACTION == zzfpeVar) {
                zzejd zzejdVar = this.zza;
                zzejdVar.zza(com.google.android.gms.ads.internal.zzt.o().a());
                final zzejh zzejhVar = this.zzb;
                final long jZzb = zzejdVar.zzb();
                zzejhVar.zza.zza(new zzfok() { // from class: com.google.android.gms.internal.ads.zzejg
                    @Override // com.google.android.gms.internal.ads.zzfok
                    public final /* synthetic */ Object zza(Object obj) {
                        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                        if (zzejhVar.zzf()) {
                            return null;
                        }
                        long j3 = jZzb;
                        zzbhv.zzaf.zza.C0143zza c0143zzaZzz = zzbhv.zzaf.zza.zzz();
                        c0143zzaZzz.zzad(j3);
                        byte[] bArrZzaN = c0143zzaZzz.zzbu().zzaN();
                        zzejo.zzf(sQLiteDatabase, false, false);
                        zzejo.zze(sQLiteDatabase, j3, bArrZzaN);
                        return null;
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdN(zzfpe zzfpeVar, String str, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhh)).booleanValue() && zzfpe.zzd == zzfpeVar) {
            zzejd zzejdVar = this.zza;
            if (zzejdVar.zzh() != 0) {
                zzejdVar.zzi(com.google.android.gms.ads.internal.zzt.o().a() - zzejdVar.zzh());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdO(zzfpe zzfpeVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhh)).booleanValue() && zzfpe.zzd == zzfpeVar) {
            zzejd zzejdVar = this.zza;
            if (zzejdVar.zzh() != 0) {
                zzejdVar.zzi(com.google.android.gms.ads.internal.zzt.o().a() - zzejdVar.zzh());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdL(zzfpe zzfpeVar, String str) {
    }
}
