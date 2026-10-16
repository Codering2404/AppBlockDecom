package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzazz extends zzbdq implements zzbey {
    private static final zzazz zzl;
    private static volatile zzbff zzm;
    private int zzb;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    static {
        zzazz zzazzVar = new zzazz();
        zzl = zzazzVar;
        zzbdq.D(zzazz.class, zzazzVar);
    }

    private zzazz() {
    }

    public static zzazz U() {
        return zzl;
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

    public final boolean O() {
        return (this.zzb & 16) != 0;
    }

    public final boolean P() {
        return this.zzi;
    }

    public final boolean Q() {
        return (this.zzb & 32) != 0;
    }

    public final boolean R() {
        return this.zzj;
    }

    public final boolean S() {
        return (this.zzb & 64) != 0;
    }

    public final boolean T() {
        return this.zzk;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzl, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i4 == 3) {
            return new zzazz();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzazy(bArr);
        }
        if (i4 == 5) {
            return zzl;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzm;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzazz.class) {
            try {
                zzbdlVar = zzm;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzl);
                    zzm = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
