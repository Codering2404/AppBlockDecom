package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.facebook.LegacyTokenHelper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgkq implements zzfza {
    private final Context zza;
    private final zzgpc zzb;
    private final String zzc;
    private final long zzd;
    private final long zze;

    zzgkq(Context context, zzgdf zzgdfVar, zzgpc zzgpcVar) {
        this.zza = context;
        this.zzc = zzgdfVar.zzd();
        this.zzd = zzgdfVar.zzl();
        this.zze = zzgdfVar.zzm();
        this.zzb = zzgpcVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zza(Map map) {
        ListenableFuture listenableFuture;
        zzaym zzaymVar;
        map.put("v", this.zzc);
        map.put("t", new Throwable());
        try {
            listenableFuture = (ListenableFuture) map.get("gs");
        } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException unused) {
        }
        String strZzb = (listenableFuture == null || (Build.VERSION.SDK_INT >= 31 && !listenableFuture.isDone()) || (zzaymVar = (zzaym) listenableFuture.get(this.zzd, TimeUnit.MILLISECONDS)) == null || zzaymVar.zzb().length() <= 1) ? "E" : zzaymVar.zzb();
        if (strZzb.equals("E")) {
            try {
                ListenableFuture listenableFuture2 = (ListenableFuture) map.get("ai");
                if (listenableFuture2 != null) {
                    String str = (String) listenableFuture2.get(this.zze, TimeUnit.MILLISECONDS);
                    if (!zzgua.zzc(str)) {
                        strZzb = str;
                    }
                }
            } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException unused2) {
            }
        }
        map.put(LegacyTokenHelper.TYPE_INTEGER, strZzb);
    }

    @Override // com.google.android.gms.internal.ads.zzfza
    public final Map zzb() {
        Map mapZzb = this.zzb.zzb();
        zza(mapZzb);
        return mapZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfza
    public final Map zzc() {
        Map mapZzc = this.zzb.zzc(this.zza, null);
        zza(mapZzc);
        return mapZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfza
    public final Map zzd() {
        Map mapZzd = this.zzb.zzd();
        zza(mapZzd);
        return mapZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfza
    public final Map zze() {
        HashMap map = new HashMap();
        map.put("t", new Throwable());
        return map;
    }
}
