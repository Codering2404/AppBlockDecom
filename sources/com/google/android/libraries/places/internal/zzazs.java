package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzazs extends zzbdq implements zzbey {
    private static final zzazs zzj;
    private static volatile zzbff zzk;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private zzbhr zzh;
    private boolean zzi;

    static {
        zzazs zzazsVar = new zzazs();
        zzj = zzazsVar;
        zzbdq.D(zzazs.class, zzazsVar);
    }

    private zzazs() {
    }

    public static zzazs M() {
        return zzj;
    }

    public final int G() {
        return this.zze;
    }

    public final int H() {
        return this.zzf;
    }

    public final int I() {
        return this.zzg;
    }

    public final boolean J() {
        return (this.zzb & 8) != 0;
    }

    public final zzbhr K() {
        zzbhr zzbhrVar = this.zzh;
        return zzbhrVar == null ? zzbhr.J() : zzbhrVar;
    }

    public final boolean L() {
        return this.zzi;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzj, "\u0000\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0005\u0007\u0006ဉ\u0003", new Object[]{"zzb", "zze", "zzf", "zzg", "zzi", "zzh"});
        }
        if (i4 == 3) {
            return new zzazs();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzazr(bArr);
        }
        if (i4 == 5) {
            return zzj;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzk;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzazs.class) {
            try {
                zzbdlVar = zzk;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzj);
                    zzk = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
