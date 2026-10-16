package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbft implements Comparator {
    zzbft(zzbfv zzbfvVar) {
        Objects.requireNonNull(zzbfvVar);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbfy zzbfyVar = (zzbfy) obj;
        zzbfy zzbfyVar2 = (zzbfy) obj2;
        int i3 = zzbfyVar.zzc - zzbfyVar2.zzc;
        return i3 != 0 ? i3 : Long.compare(zzbfyVar.zza, zzbfyVar2.zza);
    }
}
