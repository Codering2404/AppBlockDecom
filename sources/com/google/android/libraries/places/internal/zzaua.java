package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaua extends zzbdq implements zzbey {
    private static final zzaua zzg;
    private static volatile zzbff zzh;
    private int zzb;
    private zzbht zze;
    private zzbht zzf;

    static {
        zzaua zzauaVar = new zzaua();
        zzg = zzauaVar;
        zzbdq.D(zzaua.class, zzauaVar);
    }

    private zzaua() {
    }

    public static zzatz I() {
        return (zzatz) zzg.A();
    }

    public static zzaua J() {
        return zzg;
    }

    public final zzbht G() {
        zzbht zzbhtVar = this.zze;
        return zzbhtVar == null ? zzbht.J() : zzbhtVar;
    }

    public final zzbht H() {
        zzbht zzbhtVar = this.zzf;
        return zzbhtVar == null ? zzbht.J() : zzbhtVar;
    }

    final /* synthetic */ void K(zzbht zzbhtVar) {
        zzbhtVar.getClass();
        this.zze = zzbhtVar;
        this.zzb |= 1;
    }

    final /* synthetic */ void L(zzbht zzbhtVar) {
        zzbhtVar.getClass();
        this.zzf = zzbhtVar;
        this.zzb |= 2;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzg, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzb", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzaua();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzatz(bArr);
        }
        if (i4 == 5) {
            return zzg;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzh;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaua.class) {
            try {
                zzbdlVar = zzh;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzg);
                    zzh = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
