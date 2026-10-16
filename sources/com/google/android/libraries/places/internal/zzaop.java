package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaop extends zzbdq implements zzbey {
    private static final zzaop zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private zzbea zze = zzbdq.s();
    private int zzf;
    private int zzg;
    private zzapp zzh;

    static {
        zzaop zzaopVar = new zzaop();
        zzi = zzaopVar;
        zzbdq.D(zzaop.class, zzaopVar);
    }

    private zzaop() {
    }

    public static zzaoo G() {
        return (zzaoo) zzi.A();
    }

    final /* synthetic */ void H(int i3) {
        this.zzb |= 2;
        this.zzg = 1;
    }

    final /* synthetic */ void I(zzapp zzappVar) {
        zzappVar.getClass();
        this.zzh = zzappVar;
        this.zzb |= 4;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001a\u0002᠌\u0000\u0003ဋ\u0001\u0004ဉ\u0002", new Object[]{"zzb", "zze", "zzf", zzalj.f75672a, "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzaop();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaoo(bArr);
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
        synchronized (zzaop.class) {
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
