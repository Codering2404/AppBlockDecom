package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.ads.zzbhv;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfmo implements zzfmn {
    private final ConcurrentHashMap zza;
    private final zzfmu zzb;
    private final zzfmq zzc = new zzfmq();

    public zzfmo(zzfmu zzfmuVar) {
        this.zza = new ConcurrentHashMap(zzfmuVar.zzd);
        this.zzb = zzfmuVar;
    }

    private final void zzf() {
        Parcelable.Creator<zzfmu> creator = zzfmu.CREATOR;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhn)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            zzfmu zzfmuVar = this.zzb;
            sb.append(zzfmuVar.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzg());
            int i3 = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i3++;
                sb.append(i3);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfmx) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i4 = 0; i4 < ((zzfmm) entry.getValue()).zzc(); i4++) {
                    sb.append("[O]");
                }
                for (int iZzc = ((zzfmm) entry.getValue()).zzc(); iZzc < zzfmuVar.zzd; iZzc++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfmm) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i3 < zzfmuVar.zzc) {
                i3++;
                sb.append(i3);
                sb.append(".\n");
            }
            String string = sb.toString();
            int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a(string);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmn
    public final synchronized zzfmw zza(zzfmx zzfmxVar) {
        zzfmw zzfmwVarZzb;
        try {
            zzfmm zzfmmVar = (zzfmm) this.zza.get(zzfmxVar);
            if (zzfmmVar != null) {
                zzfmwVarZzb = zzfmmVar.zzb();
                if (zzfmwVarZzb == null) {
                    this.zzc.zzb();
                }
                zzfnk zzfnkVarZzh = zzfmmVar.zzh();
                if (zzfmwVarZzb != null) {
                    zzbhv.zzb.zzc zzcVarZzs = zzbhv.zzb.zzs();
                    zzbhv.zzb.zza.C0144zza c0144zzaZzs = zzbhv.zzb.zza.zzs();
                    c0144zzaZzs.zzc(zzbhv.zzb.zzd.IN_MEMORY);
                    zzbhv.zzb.zze.zza zzaVarZzq = zzbhv.zzb.zze.zzq();
                    zzaVarZzq.zzc(zzfnkVarZzh.zza);
                    zzaVarZzq.zzg(zzfnkVarZzh.zzb);
                    c0144zzaZzs.zzh(zzaVarZzq);
                    zzcVarZzs.zzh(c0144zzaZzs);
                    zzfmwVarZzb.zza.zza().zzd().zzj(zzcVarZzs.zzbu());
                }
                zzf();
            } else {
                this.zzc.zza();
                zzf();
                zzfmwVarZzb = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzfmwVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfmn
    public final synchronized boolean zzb(zzfmx zzfmxVar, zzfmw zzfmwVar) {
        boolean zZza;
        try {
            ConcurrentHashMap concurrentHashMap = this.zza;
            zzfmm zzfmmVar = (zzfmm) concurrentHashMap.get(zzfmxVar);
            zzfmwVar.zzd = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
            if (zzfmmVar == null) {
                zzfmu zzfmuVar = this.zzb;
                zzfmm zzfmmVar2 = new zzfmm(zzfmuVar.zzd, zzfmuVar.zze * 1000);
                if (concurrentHashMap.size() == zzfmuVar.zzc) {
                    int i3 = zzfmuVar.zzg;
                    int i4 = i3 - 1;
                    zzfmx zzfmxVar2 = null;
                    if (i3 == 0) {
                        throw null;
                    }
                    long jZzd = Long.MAX_VALUE;
                    if (i4 == 0) {
                        for (Map.Entry entry : concurrentHashMap.entrySet()) {
                            if (((zzfmm) entry.getValue()).zzd() < jZzd) {
                                jZzd = ((zzfmm) entry.getValue()).zzd();
                                zzfmxVar2 = (zzfmx) entry.getKey();
                            }
                        }
                        if (zzfmxVar2 != null) {
                            concurrentHashMap.remove(zzfmxVar2);
                        }
                    } else if (i4 == 1) {
                        for (Map.Entry entry2 : concurrentHashMap.entrySet()) {
                            if (((zzfmm) entry2.getValue()).zze() < jZzd) {
                                jZzd = ((zzfmm) entry2.getValue()).zze();
                                zzfmxVar2 = (zzfmx) entry2.getKey();
                            }
                        }
                        if (zzfmxVar2 != null) {
                            concurrentHashMap.remove(zzfmxVar2);
                        }
                    } else if (i4 == 2) {
                        int iZzf = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        for (Map.Entry entry3 : concurrentHashMap.entrySet()) {
                            if (((zzfmm) entry3.getValue()).zzf() < iZzf) {
                                iZzf = ((zzfmm) entry3.getValue()).zzf();
                                zzfmxVar2 = (zzfmx) entry3.getKey();
                            }
                        }
                        if (zzfmxVar2 != null) {
                            concurrentHashMap.remove(zzfmxVar2);
                        }
                    }
                    this.zzc.zzd();
                }
                concurrentHashMap.put(zzfmxVar, zzfmmVar2);
                this.zzc.zzc();
                zzfmmVar = zzfmmVar2;
            }
            zZza = zzfmmVar.zza(zzfmwVar);
            zzfmq zzfmqVar = this.zzc;
            zzfmqVar.zze();
            zzfmp zzfmpVarZzf = zzfmqVar.zzf();
            zzfnk zzfnkVarZzh = zzfmmVar.zzh();
            zzbhv.zzb.zzc zzcVarZzs = zzbhv.zzb.zzs();
            zzbhv.zzb.zza.C0144zza c0144zzaZzs = zzbhv.zzb.zza.zzs();
            c0144zzaZzs.zzc(zzbhv.zzb.zzd.IN_MEMORY);
            zzbhv.zzb.zzg.zza zzaVarZzs = zzbhv.zzb.zzg.zzs();
            zzaVarZzs.zzc(zzfmpVarZzf.zza);
            zzaVarZzs.zzg(zzfmpVarZzf.zzb);
            zzaVarZzs.zzk(zzfnkVarZzh.zzb);
            c0144zzaZzs.zzn(zzaVarZzs);
            zzcVarZzs.zzh(c0144zzaZzs);
            zzfmwVar.zza.zza().zzd().zzk(zzcVarZzs.zzbu());
            zzf();
        } catch (Throwable th) {
            throw th;
        }
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzfmn
    public final synchronized boolean zzc(zzfmx zzfmxVar) {
        zzfmm zzfmmVar = (zzfmm) this.zza.get(zzfmxVar);
        if (zzfmmVar == null) {
            return true;
        }
        return zzfmmVar.zzc() < this.zzb.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfmn
    @Deprecated
    public final zzfmx zzd(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, com.google.android.gms.ads.internal.client.zzx zzxVar) {
        zzfmu zzfmuVar = this.zzb;
        return new zzfmy(zzmVar, str, new zzcbg(zzfmuVar.zza).zza().zzj, zzfmuVar.zzf, zzxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfmn
    public final zzfmu zze() {
        return this.zzb;
    }
}
