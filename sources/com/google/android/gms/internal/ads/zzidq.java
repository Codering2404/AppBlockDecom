package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzidq extends zzidp {
    zzidq() {
    }

    @Override // com.google.android.gms.internal.ads.zzidp
    final void zza(Object obj) {
        ((zziea) obj).zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzidp
    final void zzb(zzihi zzihiVar, Map.Entry entry) throws IOException {
        zzieb zziebVar = (zzieb) entry.getKey();
        if (!zziebVar.zzc) {
            zzihg zzihgVar = zzihg.zza;
            switch (zziebVar.zzb.ordinal()) {
                case 0:
                    zzihiVar.zzf(zziebVar.zza, ((Double) entry.getValue()).doubleValue());
                    break;
                case 1:
                    zzihiVar.zze(zziebVar.zza, ((Float) entry.getValue()).floatValue());
                    break;
                case 2:
                    zzihiVar.zzc(zziebVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case 3:
                    zzihiVar.zzh(zziebVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    zzihiVar.zzi(zziebVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case 5:
                    zzihiVar.zzj(zziebVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case 6:
                    zzihiVar.zzk(zziebVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case 7:
                    zzihiVar.zzl(zziebVar.zza, ((Boolean) entry.getValue()).booleanValue());
                    break;
                case 8:
                    zzihiVar.zzm(zziebVar.zza, (String) entry.getValue());
                    break;
                case 9:
                    zzihiVar.zzs(zziebVar.zza, entry.getValue(), zzifz.zza().zzb(entry.getValue().getClass()));
                    break;
                case 10:
                    zzihiVar.zzr(zziebVar.zza, entry.getValue(), zzifz.zza().zzb(entry.getValue().getClass()));
                    break;
                case 11:
                    zzihiVar.zzn(zziebVar.zza, (zzida) entry.getValue());
                    break;
                case 12:
                    zzihiVar.zzo(zziebVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case 13:
                    zzihiVar.zzi(zziebVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case 14:
                    zzihiVar.zzb(zziebVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case 15:
                    zzihiVar.zzd(zziebVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case 16:
                    zzihiVar.zzp(zziebVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case 17:
                    zzihiVar.zzq(zziebVar.zza, ((Long) entry.getValue()).longValue());
                    break;
            }
        }
        zzihg zzihgVar2 = zzihg.zza;
        switch (zziebVar.zzb.ordinal()) {
            case 0:
                zzigi.zza(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case 1:
                zzigi.zzb(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case 2:
                zzigi.zzc(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case 3:
                zzigi.zzd(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case 4:
                zzigi.zzh(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case 5:
                zzigi.zzf(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case 6:
                zzigi.zzk(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case 7:
                zzigi.zzn(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case 8:
                zzigi.zzo(zziebVar.zza, (List) entry.getValue(), zzihiVar);
                break;
            case 9:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    zzigi.zzr(zziebVar.zza, (List) entry.getValue(), zzihiVar, zzifz.zza().zzb(list.get(0).getClass()));
                    break;
                }
                break;
            case 10:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    zzigi.zzq(zziebVar.zza, (List) entry.getValue(), zzihiVar, zzifz.zza().zzb(list2.get(0).getClass()));
                    break;
                }
                break;
            case 11:
                zzigi.zzp(zziebVar.zza, (List) entry.getValue(), zzihiVar);
                break;
            case 12:
                zzigi.zzi(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case 13:
                zzigi.zzh(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case 14:
                zzigi.zzl(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case 15:
                zzigi.zzg(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case 16:
                zzigi.zzj(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
            case 17:
                zzigi.zze(zziebVar.zza, (List) entry.getValue(), zzihiVar, zziebVar.zzd);
                break;
        }
    }
}
