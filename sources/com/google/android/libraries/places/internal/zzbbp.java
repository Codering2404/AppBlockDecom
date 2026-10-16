package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbbp extends zzbdq implements zzbey {
    private static final zzbbp zzf;
    private static volatile zzbff zzg;
    private int zzb = 0;
    private Object zze;

    static {
        zzbbp zzbbpVar = new zzbbp();
        zzf = zzbbpVar;
        zzbdq.D(zzbbp.class, zzbbpVar);
    }

    private zzbbp() {
    }

    public static zzbbo G() {
        return (zzbbo) zzf.A();
    }

    final /* synthetic */ void H(zzaua zzauaVar) {
        zzauaVar.getClass();
        this.zze = zzauaVar;
        this.zzb = 1;
    }

    final /* synthetic */ void I(zzaxc zzaxcVar) {
        zzaxcVar.getClass();
        this.zze = zzaxcVar;
        this.zzb = 2;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzf, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"zze", "zzb", zzaua.class, zzaxc.class});
        }
        if (i4 == 3) {
            return new zzbbp();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbbo(bArr);
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
        synchronized (zzbbp.class) {
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
