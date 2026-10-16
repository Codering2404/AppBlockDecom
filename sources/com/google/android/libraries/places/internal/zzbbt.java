package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbbt extends zzbdq implements zzbey {
    private static final zzbbt zzk;
    private static volatile zzbff zzl;
    private int zzb;
    private zzban zze;
    private int zzf;
    private zzbcy zzg;
    private zzbcy zzh;
    private zzbcy zzi;
    private int zzj;

    static {
        zzbbt zzbbtVar = new zzbbt();
        zzk = zzbbtVar;
        zzbdq.D(zzbbt.class, zzbbtVar);
    }

    private zzbbt() {
    }

    public static zzbbs G() {
        return (zzbbs) zzk.A();
    }

    final /* synthetic */ void H(zzban zzbanVar) {
        zzbanVar.getClass();
        this.zze = zzbanVar;
        this.zzb |= 1;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzk, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002င\u0001\u0003ဉ\u0003\u0004ဉ\u0004\u0005င\u0005\u0006ဉ\u0002", new Object[]{"zzb", "zze", "zzf", "zzh", "zzi", "zzj", "zzg"});
        }
        if (i4 == 3) {
            return new zzbbt();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbbs(bArr);
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
        synchronized (zzbbt.class) {
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
