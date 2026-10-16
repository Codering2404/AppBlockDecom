package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzanr extends zzbdq implements zzbey {
    private static final zzanr zzg;
    private static volatile zzbff zzh;
    private int zzb;
    private int zze;
    private zzapa zzf;

    static {
        zzanr zzanrVar = new zzanr();
        zzg = zzanrVar;
        zzbdq.D(zzanr.class, zzanrVar);
    }

    private zzanr() {
    }

    public static zzanq G() {
        return (zzanq) zzg.A();
    }

    final /* synthetic */ void H(zzapa zzapaVar) {
        zzapaVar.getClass();
        this.zzf = zzapaVar;
        this.zzb |= 2;
    }

    final /* synthetic */ void J(int i3) {
        this.zze = i3 - 1;
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
            return zzbdq.m(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001", new Object[]{"zzb", "zze", zzanp.f75758a, "zzf"});
        }
        if (i4 == 3) {
            return new zzanr();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzanq(bArr);
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
        synchronized (zzanr.class) {
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
