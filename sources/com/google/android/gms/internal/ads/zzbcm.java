package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcm extends zzbdf {
    private final zzbbt zzh;

    public zzbcm(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4, zzbbt zzbbtVar) {
        super(zzbbsVar, "4UiqdD16WGcqj9vsERkA6tbA4c/2yE/sXnYMi3TR5nPXoyMXncc0iB8g5zhndeqU", "5yR6P4d4j2VnbvLNLQtiv9yBd7AWiKZJ6Mp0Kq9QPto=", zzaxmVar, i3, 85);
        this.zzh = zzbbtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        Method method = this.zze;
        zzbbt zzbbtVar = this.zzh;
        long[] jArr = (long[]) method.invoke(null, Long.valueOf(zzbbtVar.zzf()), Long.valueOf(zzbbtVar.zzg()), Long.valueOf(zzbbtVar.zzi()), Long.valueOf(zzbbtVar.zzh()));
        zzaxm zzaxmVar = this.zzd;
        synchronized (zzaxmVar) {
            zzaxmVar.zzY(jArr[0]);
            zzaxmVar.zzZ(jArr[1]);
        }
    }
}
