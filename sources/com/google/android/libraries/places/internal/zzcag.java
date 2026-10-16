package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface zzcag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzcag f77331a;

    static {
        zzcag zzbpzVar;
        try {
            Class.forName("java.time.Instant");
            zzbpzVar = new zzbtg();
        } catch (ClassNotFoundException unused) {
            zzbpzVar = new zzbpz();
        }
        f77331a = zzbpzVar;
    }

    long zza();
}
