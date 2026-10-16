package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzeed extends Exception {
    private final int zza;

    public zzeed(int i3) {
        this.zza = i3;
    }

    public final int zza() {
        return this.zza;
    }

    public zzeed(int i3, String str) {
        super(str);
        this.zza = i3;
    }

    public zzeed(int i3, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
