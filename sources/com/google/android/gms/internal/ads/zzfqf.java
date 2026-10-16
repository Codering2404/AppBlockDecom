package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfqf {
    public static boolean zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkc), str);
    }

    public static void zzb(ListenableFuture listenableFuture, zzfpw zzfpwVar) {
        if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
            zzhbw.zzr(zzhbo.zzw(listenableFuture), new zzfqb(zzfpwVar), zzcfr.zzh);
        }
    }

    public static zzfok zzc(final zzfpw zzfpwVar) {
        return new zzfok() { // from class: com.google.android.gms.internal.ads.zzfqe
            @Override // com.google.android.gms.internal.ads.zzfok
            public final /* synthetic */ Object zza(Object obj) {
                if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
                    zzfpwVar.zza();
                }
                return obj;
            }
        };
    }

    public static void zzd(ListenableFuture listenableFuture, zzfqg zzfqgVar, zzfpw zzfpwVar) {
        zzh(listenableFuture, zzfqgVar, zzfpwVar, false);
    }

    public static void zze(ListenableFuture listenableFuture, zzfqg zzfqgVar, zzfpw zzfpwVar) {
        zzh(listenableFuture, zzfqgVar, zzfpwVar, true);
    }

    public static void zzf(ListenableFuture listenableFuture, zzfqg zzfqgVar, zzfpw zzfpwVar) {
        if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
            zzhbw.zzr(zzhbo.zzw(listenableFuture), new zzfqd(zzfqgVar, zzfpwVar), zzcfr.zzh);
        }
    }

    public static int zzg(zzfky zzfkyVar) {
        int iG = com.google.android.gms.ads.nonagon.signalgeneration.zzv.g(zzfkyVar) - 1;
        return (iG == 0 || iG == 1) ? 7 : 23;
    }

    private static void zzh(ListenableFuture listenableFuture, zzfqg zzfqgVar, zzfpw zzfpwVar, boolean z2) {
        if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
            zzhbw.zzr(zzhbo.zzw(listenableFuture), new zzfqc(zzfqgVar, zzfpwVar, z2), zzcfr.zzh);
        }
    }
}
