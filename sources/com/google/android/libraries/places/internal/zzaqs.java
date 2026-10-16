package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaqs extends zzbdq implements zzbey {
    private static final zzaqs zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;

    static {
        zzaqs zzaqsVar = new zzaqs();
        zzi = zzaqsVar;
        zzbdq.D(zzaqs.class, zzaqsVar);
    }

    private zzaqs() {
    }

    public static zzaqr G() {
        return (zzaqr) zzi.A();
    }

    final /* synthetic */ void H(boolean z2) {
        this.zzb |= 1;
        this.zze = z2;
    }

    final /* synthetic */ void I(boolean z2) {
        this.zzb |= 2;
        this.zzf = z2;
    }

    final /* synthetic */ void J(boolean z2) {
        this.zzb |= 4;
        this.zzg = z2;
    }

    final /* synthetic */ void K(boolean z2) {
        this.zzb |= 8;
        this.zzh = z2;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzaqs();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaqr(bArr);
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
        synchronized (zzaqs.class) {
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
