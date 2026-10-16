package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzavl extends zzbdq implements zzbey {
    private static final zzavl zzp;
    private static volatile zzbff zzq;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private zzbea zzk = zzbdq.s();
    private zzauz zzl;
    private zzavg zzm;
    private zzavk zzn;
    private zzavd zzo;

    static {
        zzavl zzavlVar = new zzavl();
        zzp = zzavlVar;
        zzbdq.D(zzavl.class, zzavlVar);
        zzbdq.n(zzbhn.G(), zzavlVar, zzavlVar, null, 525004180, zzbgj.f76196m, zzavl.class);
    }

    private zzavl() {
    }

    public static zzava H() {
        return (zzava) zzp.A();
    }

    public final List G() {
        return this.zzk;
    }

    final /* synthetic */ void I(Iterable iterable) {
        zzbea zzbeaVar = this.zzk;
        if (!zzbeaVar.zza()) {
            this.zzk = zzbdq.t(zzbeaVar);
        }
        zzbby.f(iterable, this.zzk);
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzp, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0001\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဈ\u0003\u0004ဈ\u0004\u0005ဈ\u0005\u0006\u001a\u0007ဉ\u0006\bဉ\u0007\tဉ\b\n᠌\u0002\u000bဉ\t", new Object[]{"zzb", "zze", zzavb.f75902a, "zzf", zzave.f75903a, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzg", zzavh.f75904a, "zzo"});
        }
        if (i4 == 3) {
            return new zzavl();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzava(bArr);
        }
        if (i4 == 5) {
            return zzp;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzq;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzavl.class) {
            try {
                zzbdlVar = zzq;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzp);
                    zzq = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
