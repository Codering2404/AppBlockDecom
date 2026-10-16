package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbab extends zzbdq implements zzbey {
    private static final zzbab zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;

    static {
        zzbab zzbabVar = new zzbab();
        zzi = zzbabVar;
        zzbdq.D(zzbab.class, zzbabVar);
    }

    private zzbab() {
    }

    public static zzbab O() {
        return zzi;
    }

    public final boolean G() {
        return (this.zzb & 1) != 0;
    }

    public final boolean H() {
        return this.zze;
    }

    public final boolean I() {
        return (this.zzb & 2) != 0;
    }

    public final boolean J() {
        return this.zzf;
    }

    public final boolean K() {
        return (this.zzb & 4) != 0;
    }

    public final boolean L() {
        return this.zzg;
    }

    public final boolean M() {
        return (this.zzb & 8) != 0;
    }

    public final boolean N() {
        return this.zzh;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzi, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzbab();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbaa(bArr);
        }
        if (i4 == 5) {
            return zzi;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzj;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbab.class) {
            try {
                zzbdlVar = zzj;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzi);
                    zzj = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
