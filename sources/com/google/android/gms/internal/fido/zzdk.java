package com.google.android.gms.internal.fido;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzdk {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;

    protected zzdk(String str, Class cls, boolean z2) {
        this(str, cls, z2, true);
    }

    public static zzdk zza(String str, Class cls) {
        return new zzdk(str, cls, false, false);
    }

    public final String toString() {
        Class cls = this.zzb;
        return getClass().getName() + "/" + this.zza + "[" + cls.getName() + "]";
    }

    public final boolean zzb() {
        return this.zzc;
    }

    private zzdk(String str, Class cls, boolean z2, boolean z3) {
        zzfk.zzb(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z2;
        System.identityHashCode(this);
        for (int i3 = 0; i3 < 5; i3++) {
        }
    }
}
