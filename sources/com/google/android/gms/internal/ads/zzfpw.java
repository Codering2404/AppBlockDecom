package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzfpw {
    static zzfpw zzn(Context context, int i3) {
        boolean zBooleanValue;
        if (zzfqj.zza()) {
            int i4 = i3 - 2;
            if (i4 == 20 || i4 == 21) {
                zBooleanValue = ((Boolean) zzbkj.zze.zze()).booleanValue();
            } else if (i4 != 110) {
                switch (i4) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        zBooleanValue = ((Boolean) zzbkj.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        zBooleanValue = ((Boolean) zzbkj.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        zBooleanValue = ((Boolean) zzbkj.zzb.zze()).booleanValue();
                        break;
                }
            } else {
                zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkk)).booleanValue();
            }
            if (zBooleanValue) {
                return new zzfpy(context, i3);
            }
        }
        return new zzfqz();
    }

    static zzfpw zzo(Context context, int i3, int i4, com.google.android.gms.ads.internal.client.zzm zzmVar) {
        zzfpw zzfpwVarZzn = zzn(context, i3);
        if (zzfpwVarZzn instanceof zzfpy) {
            zzfpwVarZzn.zza();
            zzfpwVarZzn.zzp(i4);
            zzfpwVarZzn.zzf(com.google.android.gms.ads.nonagon.signalgeneration.zzv.d(zzmVar.f69976n));
            String str = zzmVar.f69979q;
            if (zzfqf.zza(str)) {
                zzfpwVarZzn.zze(str);
            }
        }
        return zzfpwVarZzn;
    }

    zzfpw zza();

    boolean zzb();

    zzfpw zzc();

    zzfpw zzd(boolean z2);

    zzfpw zze(String str);

    zzfpw zzf(zzfql zzfqlVar);

    zzfpw zzg(zzfkp zzfkpVar);

    zzfpw zzh(com.google.android.gms.ads.internal.client.zze zzeVar);

    zzfpw zzi(String str);

    zzfpw zzj(Throwable th);

    zzfpw zzk(String str);

    boolean zzl();

    zzfpz zzm();

    zzfpw zzp(int i3);
}
