package com.google.android.libraries.places.internal;

import com.google.common.cache.LSNn.vfptEEmYY;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzazk extends zzbdq implements zzbey {
    private static final zzazk zzk;
    private static volatile zzbff zzl;
    private int zzb;
    private zzbhv zze;
    private zzbhv zzg;
    private zzbas zzi;
    private zzbhv zzj;
    private String zzf = "";
    private String zzh = "";

    static {
        zzazk zzazkVar = new zzazk();
        zzk = zzazkVar;
        zzbdq.D(zzazk.class, zzazkVar);
    }

    private zzazk() {
    }

    public static zzazk L() {
        return zzk;
    }

    public final boolean G() {
        return (this.zzb & 1) != 0;
    }

    public final zzbhv H() {
        zzbhv zzbhvVar = this.zze;
        return zzbhvVar == null ? zzbhv.I() : zzbhvVar;
    }

    public final String I() {
        return this.zzf;
    }

    public final boolean J() {
        return (this.zzb & 8) != 0;
    }

    public final zzbhv K() {
        zzbhv zzbhvVar = this.zzj;
        return zzbhvVar == null ? zzbhv.I() : zzbhvVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzk, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004Ȉ\u0005Ȉ\u0006ဉ\u0003", new Object[]{"zzb", "zze", "zzg", "zzi", "zzf", "zzh", vfptEEmYY.qAoqFvK});
        }
        if (i4 == 3) {
            return new zzazk();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzazj(bArr);
        }
        if (i4 == 5) {
            return zzk;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzl;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzazk.class) {
            try {
                zzbdlVar = zzl;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzk);
                    zzl = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
