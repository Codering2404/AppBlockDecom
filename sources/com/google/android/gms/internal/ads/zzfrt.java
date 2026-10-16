package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfrt {
    private final com.google.android.gms.ads.internal.util.client.zzx zza;
    private final com.google.android.gms.ads.internal.util.client.zzu zzb;
    private final zzhch zzc;
    private final zzfru zzd;
    private final zzcng zze;

    public zzfrt(com.google.android.gms.ads.internal.util.client.zzx zzxVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzhch zzhchVar, zzfru zzfruVar, zzcng zzcngVar) {
        this.zza = zzxVar;
        this.zzb = zzuVar;
        this.zzc = zzhchVar;
        this.zzd = zzfruVar;
        this.zze = zzcngVar;
    }

    private final ListenableFuture zze(final String str, final long j3, final int i3) {
        final String string;
        com.google.android.gms.ads.internal.util.client.zzx zzxVar = this.zza;
        if (i3 > zzxVar.a()) {
            zzfru zzfruVar = this.zzd;
            if (zzfruVar == null || !zzxVar.d()) {
                return zzhbw.zza(com.google.android.gms.ads.internal.util.client.zzt.RETRIABLE_FAILURE);
            }
            zzfruVar.zza(str, "", 2);
            return zzhbw.zza(com.google.android.gms.ads.internal.util.client.zzt.BUFFERED);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzjQ)).booleanValue()) {
            Uri uri = Uri.parse(str);
            String encodedQuery = uri.getEncodedQuery();
            Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
            builderClearQuery.appendQueryParameter("pa", Integer.toString(i3));
            String strValueOf = String.valueOf(builderClearQuery.build());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + String.valueOf(encodedQuery).length());
            sb.append(strValueOf);
            sb.append("&");
            sb.append(encodedQuery);
            string = sb.toString();
        } else {
            string = str;
        }
        zzhbe zzhbeVar = new zzhbe() { // from class: com.google.android.gms.internal.ads.zzfrs
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzb(i3, j3, str, (com.google.android.gms.ads.internal.util.client.zzt) obj);
            }
        };
        if (j3 == 0) {
            zzhch zzhchVar = this.zzc;
            return zzhbw.zzj(zzhchVar.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzfrr
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.zza.zzd(string);
                }
            }), zzhbeVar, zzhchVar);
        }
        zzhch zzhchVar2 = this.zzc;
        return zzhbw.zzj(zzhchVar2.schedule(new Callable() { // from class: com.google.android.gms.internal.ads.zzfrq
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc(string);
            }
        }, j3, TimeUnit.MILLISECONDS), zzhbeVar, zzhchVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final com.google.android.gms.ads.internal.util.client.zzt zzd(String str) {
        zzcng zzcngVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzki)).booleanValue() || (zzcngVar = this.zze) == null || (!com.google.android.gms.ads.internal.zzt.g().S(str) && !com.google.android.gms.ads.internal.zzt.g().T(str))) {
            return this.zzb.b(str, null);
        }
        String strZzb = zzcngVar.zzb();
        HashMap map = new HashMap();
        if (strZzb != null) {
            map.put((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkj), strZzb);
        }
        return this.zzb.b(str, map);
    }

    public final ListenableFuture zza(String str) {
        if (str != null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzg)).booleanValue() || !str.isEmpty()) {
                try {
                    return zze(str, 0L, 1);
                } catch (NullPointerException | RejectedExecutionException unused) {
                    return zzhbw.zza(com.google.android.gms.ads.internal.util.client.zzt.PERMANENT_FAILURE);
                }
            }
        }
        return zzhbw.zza(com.google.android.gms.ads.internal.util.client.zzt.PERMANENT_FAILURE);
    }

    final /* synthetic */ ListenableFuture zzb(int i3, long j3, String str, com.google.android.gms.ads.internal.util.client.zzt zztVar) {
        if (zztVar != com.google.android.gms.ads.internal.util.client.zzt.RETRIABLE_FAILURE) {
            return zzhbw.zza(zztVar);
        }
        com.google.android.gms.ads.internal.util.client.zzx zzxVar = this.zza;
        long jB = zzxVar.b();
        if (i3 != 1) {
            jB = (long) (zzxVar.c() * j3);
        }
        return zze(str, jB, i3 + 1);
    }
}
