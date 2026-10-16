package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzftx implements Comparator {
    static final /* synthetic */ zzftx zza = new zzftx();

    private /* synthetic */ zzftx() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzftm zzftmVar = (zzftm) obj2;
        zzftm zzftmVar2 = (zzftm) obj;
        int iCompare = Double.compare(zzftmVar.zze(), zzftmVar2.zze());
        return iCompare == 0 ? Long.compare(zzftmVar2.zzd(), zzftmVar.zzd()) : iCompare;
    }
}
