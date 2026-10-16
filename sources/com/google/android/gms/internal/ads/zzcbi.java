package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcbi implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzcbk zzb;

    zzcbi(zzcbk zzcbkVar, Context context) {
        this.zza = context;
        Objects.requireNonNull(zzcbkVar);
        this.zzb = zzcbkVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0038  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ java.lang.Object call() throws java.lang.Exception {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzcbk r0 = r7.zzb
            java.util.WeakHashMap r1 = r0.zzb()
            android.content.Context r2 = r7.zza
            java.lang.Object r1 = r1.get(r2)
            com.google.android.gms.internal.ads.zzcbj r1 = (com.google.android.gms.internal.ads.zzcbj) r1
            if (r1 == 0) goto L38
            com.google.android.gms.internal.ads.zzbka r3 = com.google.android.gms.internal.ads.zzbkf.zzd
            java.lang.Object r3 = r3.zze()
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            long r5 = r1.zza
            long r5 = r5 + r3
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzt.o()
            long r3 = r3.currentTimeMillis()
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 >= 0) goto L2c
            goto L38
        L2c:
            com.google.android.gms.internal.ads.zzcbh r1 = r1.zzb
            com.google.android.gms.internal.ads.zzcbg r3 = new com.google.android.gms.internal.ads.zzcbg
            r3.<init>(r2, r1)
            com.google.android.gms.internal.ads.zzcbh r1 = r3.zza()
            goto L41
        L38:
            com.google.android.gms.internal.ads.zzcbg r1 = new com.google.android.gms.internal.ads.zzcbg
            r1.<init>(r2)
            com.google.android.gms.internal.ads.zzcbh r1 = r1.zza()
        L41:
            com.google.android.gms.internal.ads.zzcbj r3 = new com.google.android.gms.internal.ads.zzcbj
            r3.<init>(r0, r1)
            java.util.WeakHashMap r0 = r0.zzb()
            r0.put(r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbi.call():java.lang.Object");
    }
}
