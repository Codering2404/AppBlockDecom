package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaow extends zzbdq implements zzbey {
    private static final zzaow zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private zzamo zze;
    private int zzf;
    private int zzg;
    private zzapp zzh;

    static {
        zzaow zzaowVar = new zzaow();
        zzi = zzaowVar;
        zzbdq.D(zzaow.class, zzaowVar);
    }

    private zzaow() {
    }

    public static zzaou G() {
        return (zzaou) zzi.A();
    }

    final /* synthetic */ void H(int i3) {
        this.zzb |= 4;
        this.zzg = i3;
    }

    final /* synthetic */ void I(zzapp zzappVar) {
        zzappVar.getClass();
        this.zzh = zzappVar;
        this.zzb |= 8;
    }

    final /* synthetic */ void K(int i3) {
        this.zzf = i3 - 1;
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
            return zzbdq.m(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003င\u0002\u0004ဉ\u0003", new Object[]{"zzb", "zze", "zzf", zzaov.f75769a, "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzaow();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaou(bArr);
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
        synchronized (zzaow.class) {
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
