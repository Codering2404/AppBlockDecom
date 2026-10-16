package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbgt extends zzbdq implements zzbey {
    private static final zzbgt zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private int zzh;

    static {
        zzbgt zzbgtVar = new zzbgt();
        zzi = zzbgtVar;
        zzbdq.D(zzbgt.class, zzbgtVar);
    }

    private zzbgt() {
    }

    public static zzbgr G() {
        return (zzbgr) zzi.A();
    }

    public static zzbgt H() {
        return zzi;
    }

    final /* synthetic */ void I(zzbgs zzbgsVar) {
        this.zzb = zzbgsVar.zza();
    }

    final /* synthetic */ void J(String str) {
        str.getClass();
        this.zze = str;
    }

    final /* synthetic */ void K(String str) {
        str.getClass();
        this.zzg = str;
    }

    final /* synthetic */ void M(int i3) {
        this.zzh = 2;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzi, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\f", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzbgt();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbgr(bArr);
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
        synchronized (zzbgt.class) {
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
