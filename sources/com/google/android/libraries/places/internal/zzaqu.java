package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaqu extends zzbdq implements zzbey {
    private static final zzaqu zzh;
    private static volatile zzbff zzi;
    private int zzb;
    private int zze;
    private zzaqs zzf;
    private int zzg;

    static {
        zzaqu zzaquVar = new zzaqu();
        zzh = zzaquVar;
        zzbdq.D(zzaqu.class, zzaquVar);
    }

    private zzaqu() {
    }

    public static zzaqt G() {
        return (zzaqt) zzh.A();
    }

    final /* synthetic */ void H(zzaqs zzaqsVar) {
        zzaqsVar.getClass();
        this.zzf = zzaqsVar;
        this.zzb |= 2;
    }

    final /* synthetic */ void J(int i3) {
        this.zze = i3 - 1;
        this.zzb |= 1;
    }

    final /* synthetic */ void K(int i3) {
        this.zzg = i3 - 1;
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
            return zzbdq.m(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003᠌\u0002", new Object[]{"zzb", "zze", zzarl.f75782a, "zzf", "zzg", zzaqv.f75780a});
        }
        if (i4 == 3) {
            return new zzaqu();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaqt(bArr);
        }
        if (i4 == 5) {
            return zzh;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzi;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaqu.class) {
            try {
                zzbdlVar = zzi;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzh);
                    zzi = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
