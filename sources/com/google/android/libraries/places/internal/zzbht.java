package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbht extends zzbdq implements zzbey {
    private static final zzbht zzf;
    private static volatile zzbff zzg;
    private double zzb;
    private double zze;

    static {
        zzbht zzbhtVar = new zzbht();
        zzf = zzbhtVar;
        zzbdq.D(zzbht.class, zzbhtVar);
    }

    private zzbht() {
    }

    public static zzbhs I() {
        return (zzbhs) zzf.A();
    }

    public static zzbht J() {
        return zzf;
    }

    public final double G() {
        return this.zzb;
    }

    public final double H() {
        return this.zze;
    }

    final /* synthetic */ void K(double d3) {
        this.zzb = d3;
    }

    final /* synthetic */ void L(double d3) {
        this.zze = d3;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0000\u0002\u0000", new Object[]{"zzb", "zze"});
        }
        if (i4 == 3) {
            return new zzbht();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbhs(bArr);
        }
        if (i4 == 5) {
            return zzf;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzg;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbht.class) {
            try {
                zzbdlVar = zzg;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzf);
                    zzg = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
