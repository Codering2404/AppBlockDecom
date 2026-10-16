package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzajh extends zzbdq implements zzbey {
    private static final zzajh zzn;
    private static volatile zzbff zzo;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private zzakf zzi;
    private zzajp zzj;
    private zzakd zzk;
    private int zzl;
    private int zzm;

    static {
        zzajh zzajhVar = new zzajh();
        zzn = zzajhVar;
        zzbdq.D(zzajh.class, zzajhVar);
    }

    private zzajh() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002\u0004᠌\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\b᠌\u0007\t᠌\b", new Object[]{"zzb", "zze", zzaje.f75642a, "zzf", zzajg.f75644a, "zzg", "zzh", zzajd.f75641a, "zzi", "zzj", "zzk", "zzl", zzajb.f75640a, "zzm", zzajf.f75643a});
        }
        if (i4 == 3) {
            return new zzajh();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzajc(bArr);
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
        synchronized (zzajh.class) {
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
