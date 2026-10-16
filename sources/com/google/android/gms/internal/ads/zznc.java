package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zznc {
    static boolean zzac(int i3, boolean z2) {
        int i4 = i3 & 7;
        if (i4 != 4) {
            return z2 && i4 == 3;
        }
        return true;
    }

    String zzU();

    int zza();

    int zzad(zzv zzvVar) throws zzjk;

    int zzu() throws zzjk;

    default void zzw() {
    }

    default void zzv(zznb zznbVar) {
    }
}
