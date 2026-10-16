package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaj extends zzbdq implements zzbey {
    private static final zzaj zzo;
    private static volatile zzbff zzp;
    private int zzb;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private int zzn;

    static {
        zzaj zzajVar = new zzaj();
        zzo = zzajVar;
        zzbdq.D(zzaj.class, zzajVar);
    }

    private zzaj() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzo, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\tဇ\b\nင\t", new Object[]{"zzb", "zze", zzai.f75629a, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
        }
        if (i4 == 3) {
            return new zzaj();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzah(bArr);
        }
        if (i4 == 5) {
            return zzo;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzp;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaj.class) {
            try {
                zzbdlVar = zzp;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzo);
                    zzp = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
