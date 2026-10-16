package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzazd extends zzbdq implements zzbey {
    private static final zzazd zzh;
    private static volatile zzbff zzi;
    private int zzb;
    private String zze = "";
    private String zzf = "";
    private zzazc zzg;

    static {
        zzazd zzazdVar = new zzazd();
        zzh = zzazdVar;
        zzbdq.D(zzazd.class, zzazdVar);
    }

    private zzazd() {
    }

    public static zzazd J() {
        return zzh;
    }

    public final String G() {
        return this.zze;
    }

    public final String H() {
        return this.zzf;
    }

    public final zzazc I() {
        zzazc zzazcVar = this.zzg;
        return zzazcVar == null ? zzazc.I() : zzazcVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzh, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000", new Object[]{"zzb", "zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzazd();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaza(bArr);
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
        synchronized (zzazd.class) {
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
