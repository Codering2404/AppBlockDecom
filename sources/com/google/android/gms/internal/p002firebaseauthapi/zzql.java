package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzql extends RuntimeException {
    public zzql(String str) {
        super(str);
    }

    public static <T> T zza(zzqo<T> zzqoVar) {
        try {
            return zzqoVar.zza();
        } catch (Exception e3) {
            throw new zzql(e3);
        }
    }

    public zzql(Throwable th) {
        super(th);
    }

    public zzql(String str, Throwable th) {
        super(str, th);
    }
}
