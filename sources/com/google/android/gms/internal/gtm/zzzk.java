package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzzk implements zzzt {
    private final zzzg zza;
    private final zzaak zzb;
    private final boolean zzc;
    private final zzxg zzd;

    private zzzk(zzaak zzaakVar, zzxg zzxgVar, zzzg zzzgVar) {
        this.zzb = zzaakVar;
        this.zzc = zzxgVar.zzi(zzzgVar);
        this.zzd = zzxgVar;
        this.zza = zzzgVar;
    }

    static zzzk zzc(zzaak zzaakVar, zzxg zzxgVar, zzzg zzzgVar) {
        return new zzzk(zzaakVar, zzxgVar, zzzgVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzzt
    public final int zza(Object obj) {
        zzaak zzaakVar = this.zzb;
        int iZzb = zzaakVar.zzb(zzaakVar.zzd(obj));
        return this.zzc ? iZzb + this.zzd.zzb(obj).zzc() : iZzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzzt
    public final int zzb(Object obj) {
        int iHashCode = this.zzb.zzd(obj).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zzb(obj).zza.hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.gtm.zzzt
    public final Object zze() {
        zzzg zzzgVar = this.zza;
        return zzzgVar instanceof zzxv ? ((zzxv) zzzgVar).zzad() : zzzgVar.zzau().zzE();
    }

    @Override // com.google.android.gms.internal.gtm.zzzt
    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zzf(obj);
    }

    @Override // com.google.android.gms.internal.gtm.zzzt
    public final void zzg(Object obj, Object obj2) {
        zzzv.zzr(this.zzb, obj, obj2);
        if (this.zzc) {
            zzzv.zzq(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzzt
    public final void zzh(Object obj, zzzs zzzsVar, zzxf zzxfVar) throws IOException {
        boolean zZzQ;
        zzaak zzaakVar = this.zzb;
        Object objZzc = zzaakVar.zzc(obj);
        zzxg zzxgVar = this.zzd;
        zzxk zzxkVarZzc = zzxgVar.zzc(obj);
        while (zzzsVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzzsVar.zzd();
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        Object objZzd = zzxgVar.zzd(zzxfVar, this.zza, iZzd >>> 3);
                        if (objZzd != null) {
                            zzxgVar.zzg(zzzsVar, objZzd, zzxfVar, zzxkVarZzc);
                        } else {
                            zZzQ = zzaakVar.zzp(objZzc, zzzsVar);
                        }
                    } else {
                        zZzQ = zzzsVar.zzQ();
                    }
                    if (!zZzQ) {
                        zzaakVar.zzn(obj, objZzc);
                        return;
                    }
                } else {
                    Object objZzd2 = null;
                    int iZzj = 0;
                    zzud zzudVarZzp = null;
                    while (zzzsVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzzsVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzzsVar.zzj();
                            objZzd2 = zzxgVar.zzd(zzxfVar, this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (objZzd2 != null) {
                                zzxgVar.zzg(zzzsVar, objZzd2, zzxfVar, zzxkVarZzc);
                            } else {
                                zzudVarZzp = zzzsVar.zzp();
                            }
                        } else if (!zzzsVar.zzQ()) {
                            break;
                        }
                    }
                    if (zzzsVar.zzd() != 12) {
                        throw zzyg.zzb();
                    }
                    if (zzudVarZzp != null) {
                        if (objZzd2 != null) {
                            zzxgVar.zzh(zzudVarZzp, objZzd2, zzxfVar, zzxkVarZzc);
                        } else {
                            zzaakVar.zzk(objZzc, iZzj, zzudVarZzp);
                        }
                    }
                }
            } catch (Throwable th) {
                zzaakVar.zzn(obj, objZzc);
                throw th;
            }
        }
        zzaakVar.zzn(obj, objZzc);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c3 A[EDGE_INSN: B:61:0x00c3->B:33:0x00c3 BREAK  A[LOOP:1: B:17:0x0069->B:64:0x0069], SYNTHETIC] */
    @Override // com.google.android.gms.internal.gtm.zzzt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.gtm.zztp r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzzk.zzi(java.lang.Object, byte[], int, int, com.google.android.gms.internal.gtm.zztp):void");
    }

    @Override // com.google.android.gms.internal.gtm.zzzt
    public final boolean zzj(Object obj, Object obj2) {
        zzaak zzaakVar = this.zzb;
        if (!zzaakVar.zzd(obj).equals(zzaakVar.zzd(obj2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(obj).equals(this.zzd.zzb(obj2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzzt
    public final boolean zzk(Object obj) {
        return this.zzd.zzb(obj).zzm();
    }

    @Override // com.google.android.gms.internal.gtm.zzzt
    public final void zzm(Object obj, zzur zzurVar) throws IOException {
        Iterator itZzg = this.zzd.zzb(obj).zzg();
        while (itZzg.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzg.next();
            zzxj zzxjVar = (zzxj) entry.getKey();
            if (zzxjVar.zze() != zzabb.MESSAGE || zzxjVar.zzg()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzxjVar.zzf();
            if (entry instanceof zzyj) {
                zzurVar.zzw(zzxjVar.zza(), ((zzyj) entry).zza().zzb());
            } else {
                zzurVar.zzw(zzxjVar.zza(), entry.getValue());
            }
        }
        zzaak zzaakVar = this.zzb;
        zzaakVar.zzr(zzaakVar.zzd(obj), zzurVar);
    }
}
