package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaej extends zzbdq implements zzbey {
    private static final zzaej zzq;
    private static volatile zzbff zzr;
    private int zzb;
    private zzbdz zze = zzbdq.r();
    private zzbdz zzf = zzbdq.r();
    private zzbdz zzg = zzbdq.r();
    private zzbdz zzh = zzbdq.r();
    private zzbdz zzi = zzbdq.r();
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private zzady zzo;
    private int zzp;

    static {
        zzaej zzaejVar = new zzaej();
        zzq = zzaejVar;
        zzbdq.D(zzaej.class, zzaejVar);
    }

    private zzaej() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzq, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0005\u0000\u0001\u0014\u0002\u0014\u0003\u0014\u0004\u0014\u0005\u0014\u0006င\u0000\u0007᠌\u0001\b᠌\u0002\t᠌\u0003\nင\u0004\u000bဉ\u0005\fင\u0006", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzaei.f75619a, "zzl", zzaeh.f75618a, "zzm", zzaef.f75617a, "zzn", "zzo", "zzp"});
        }
        if (i4 == 3) {
            return new zzaej();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaeg(bArr);
        }
        if (i4 == 5) {
            return zzq;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzr;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaej.class) {
            try {
                zzbdlVar = zzr;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzq);
                    zzr = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
