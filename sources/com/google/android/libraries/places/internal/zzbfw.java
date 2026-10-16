package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbfw extends zzbdq implements zzbey {
    private static final zzbfw zzf;
    private static volatile zzbff zzg;
    private long zzb;
    private int zze;

    static {
        zzbfw zzbfwVar = new zzbfw();
        zzf = zzbfwVar;
        zzbdq.D(zzbfw.class, zzbfwVar);
    }

    private zzbfw() {
    }

    public static zzbfv I() {
        return (zzbfv) zzf.A();
    }

    public static zzbfw J() {
        return zzf;
    }

    public final long G() {
        return this.zzb;
    }

    public final int H() {
        return this.zze;
    }

    final /* synthetic */ void K(long j3) {
        this.zzb = j3;
    }

    final /* synthetic */ void L(int i3) {
        this.zze = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return new zzbfj(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzb", "zze"});
        }
        if (i4 == 3) {
            return new zzbfw();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbfv(bArr);
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
        synchronized (zzbfw.class) {
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
