package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbzs {
    private static zzcem zze;
    private final Context zza;
    private final AdFormat zzb;
    private final com.google.android.gms.ads.internal.client.zzeh zzc;
    private final String zzd;

    public zzbzs(Context context, AdFormat adFormat, com.google.android.gms.ads.internal.client.zzeh zzehVar, String str) {
        this.zza = context;
        this.zzb = adFormat;
        this.zzc = zzehVar;
        this.zzd = str;
    }

    public static zzcem zza(Context context) {
        zzcem zzcemVar;
        synchronized (zzbzs.class) {
            try {
                if (zze == null) {
                    zze = com.google.android.gms.ads.internal.client.zzay.b().i(context, new zzbuy());
                }
                zzcemVar = zze;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzcemVar;
    }

    public final void zzb(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        com.google.android.gms.ads.internal.client.zzm zzmVarA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Context context = this.zza;
        zzcem zzcemVarZza = zza(context);
        if (zzcemVarZza == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        IObjectWrapper iObjectWrapperI5 = ObjectWrapper.i5(context);
        com.google.android.gms.ads.internal.client.zzeh zzehVar = this.zzc;
        if (zzehVar == null) {
            com.google.android.gms.ads.internal.client.zzn zznVar = new com.google.android.gms.ads.internal.client.zzn();
            zznVar.i(jCurrentTimeMillis);
            zzmVarA = zznVar.a();
        } else {
            zzehVar.o(jCurrentTimeMillis);
            zzmVarA = com.google.android.gms.ads.internal.client.zzq.f70003a.a(context, zzehVar);
        }
        try {
            zzcemVarZza.zze(iObjectWrapperI5, new zzceq(this.zzd, this.zzb.name(), null, zzmVarA), new zzbzr(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
