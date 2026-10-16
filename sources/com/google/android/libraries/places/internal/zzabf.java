package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzabf extends zzbdq implements zzbey {
    private static final zzabf zzk;
    private static volatile zzbff zzl;
    private int zzb;
    private double zze;
    private long zzf;
    private zzbcl zzg;
    private zzbcl zzh;
    private int zzi;
    private long zzj;

    static {
        zzabf zzabfVar = new zzabf();
        zzk = zzabfVar;
        zzbdq.D(zzabf.class, zzabfVar);
    }

    private zzabf() {
        zzbcl zzbclVar = zzbcl.f75997b;
        this.zzg = zzbclVar;
        this.zzh = zzbclVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001က\u0000\u0002ဂ\u0001\u0003ည\u0002\u0004ည\u0003\u0005᠌\u0004\u0006ဂ\u0005", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", zzabd.f75606a, "zzj"});
        }
        if (i4 == 3) {
            return new zzabf();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzabe(bArr);
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
        synchronized (zzabf.class) {
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
