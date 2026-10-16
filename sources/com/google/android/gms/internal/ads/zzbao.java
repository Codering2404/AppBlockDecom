package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbao extends zzban {
    private zzbao(Context context, zzbam zzbamVar) {
        super(context, zzbamVar);
    }

    public static zzbao zzt(Context context, zzawo zzawoVar) {
        zzbam zzbamVar = new zzbam(zzawoVar);
        zzban.zzo(context, zzbamVar);
        return new zzbao(context, zzbamVar);
    }
}
