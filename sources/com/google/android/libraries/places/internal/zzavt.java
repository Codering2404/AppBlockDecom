package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzavt extends zzbdq implements zzbey {
    private static final zzavt zzq;
    private static volatile zzbff zzr;
    private int zzb;
    private zzbht zzg;
    private int zzh;
    private zzaua zzi;
    private zzaua zzj;
    private zzbhz zzl;
    private zzavy zzp;
    private String zze = "";
    private String zzf = "";
    private String zzk = "";
    private zzbea zzm = zzbdq.s();
    private zzbea zzn = zzbdq.s();
    private zzbea zzo = zzbdq.s();

    static {
        zzavt zzavtVar = new zzavt();
        zzq = zzavtVar;
        zzbdq.D(zzavt.class, zzavtVar);
    }

    private zzavt() {
    }

    public final String G() {
        return this.zzf;
    }

    public final List H() {
        return this.zzo;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzq, "\u0000\f\u0000\u0001\u0001\r\f\u0000\u0003\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000\u0004\f\u0005ဉ\u0001\u0006ဉ\u0002\u0007Ȉ\bဉ\u0003\t\u001b\u000b\u001b\fȚ\rဉ\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzavr.class, "zzn", zzbhv.class, "zzo", "zzp"});
        }
        if (i4 == 3) {
            return new zzavt();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzavs(bArr);
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
        synchronized (zzavt.class) {
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
