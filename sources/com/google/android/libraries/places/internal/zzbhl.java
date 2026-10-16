package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbhl extends zzbdq implements zzbey {
    private static final zzbhl zzj;
    private static volatile zzbff zzk;
    private int zzb;
    private long zze;
    private zzavl zzh;
    private zzbcl zzf = zzbcl.f75997b;
    private String zzg = "";
    private String zzi = "";

    static {
        zzbhl zzbhlVar = new zzbhl();
        zzj = zzbhlVar;
        zzbdq.D(zzbhl.class, zzbhlVar);
    }

    private zzbhl() {
    }

    public static zzbhk G() {
        return (zzbhk) zzj.A();
    }

    final /* synthetic */ void H(String str) {
        str.getClass();
        this.zzb |= 4;
        this.zzg = str;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဈ\u0002\u0003ဉ\u0003\u0004ည\u0001\u0005ဈ\u0004", new Object[]{"zzb", "zze", "zzg", "zzh", "zzf", "zzi"});
        }
        if (i4 == 3) {
            return new zzbhl();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbhk(bArr);
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
        synchronized (zzbhl.class) {
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
