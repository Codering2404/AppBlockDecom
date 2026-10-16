package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final class zzasj extends zzbdq implements zzbey {
    private static final zzasj zzn;
    private static volatile zzbff zzo;
    private int zzb;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;

    static {
        zzasj zzasjVar = new zzasj();
        zzn = zzasjVar;
        zzbdq.D(zzasj.class, zzasjVar);
    }

    private zzasj() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\tဇ\b", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i4 == 3) {
            return new zzasj();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzasi(bArr);
        }
        if (i4 == 5) {
            return zzn;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzo;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzasj.class) {
            try {
                zzbdlVar = zzo;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzn);
                    zzo = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
