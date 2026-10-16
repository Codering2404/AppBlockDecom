package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzajx extends zzbdq implements zzbey {
    private static final zzajx zzq;
    private static volatile zzbff zzr;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private zzbea zzm = zzbdq.s();
    private int zzn;
    private int zzo;
    private int zzp;

    static {
        zzajx zzajxVar = new zzajx();
        zzq = zzajxVar;
        zzbdq.D(zzajx.class, zzajxVar);
    }

    private zzajx() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzq, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\t\u001b\nင\b\u000b᠌\t\fင\n", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzajw.class, "zzn", "zzo", zzaja.f75639a, "zzp"});
        }
        if (i4 == 3) {
            return new zzajx();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaju(bArr);
        }
        if (i4 == 5) {
            return zzq;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzr;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzajx.class) {
            try {
                zzbdlVar = zzr;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzq);
                    zzr = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
