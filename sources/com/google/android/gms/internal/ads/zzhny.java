package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhny extends RuntimeException {
    public zzhny(String str) {
        super(str);
    }

    public static Object zza(zzhnx zzhnxVar) {
        try {
            return zzhnxVar.zza();
        } catch (Exception e3) {
            throw new zzhny(e3);
        }
    }

    public zzhny(String str, Throwable th) {
        super(str, th);
    }

    public zzhny(Throwable th) {
        super(th);
    }
}
