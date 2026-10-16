package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzahk {
    void zzA(zzv zzvVar);

    default int zza(zzj zzjVar, int i3, boolean z2) throws IOException {
        return zzb(zzjVar, i3, z2, 0);
    }

    int zzb(zzj zzjVar, int i3, boolean z2, int i4) throws IOException;

    default void zzc(zzet zzetVar, int i3) {
        zzd(zzetVar, i3, 0);
    }

    void zzd(zzet zzetVar, int i3, int i4);

    void zze(long j3, int i3, int i4, int i5, zzahj zzahjVar);

    default void zzO(long j3) {
    }
}
