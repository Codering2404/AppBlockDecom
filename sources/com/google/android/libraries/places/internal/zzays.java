package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzays extends zzbdq implements zzbey {
    private static final zzays zzh;
    private static volatile zzbff zzi;
    private String zzb = "";
    private String zze = "";
    private zzbea zzf = zzbdq.s();
    private String zzg = "";

    static {
        zzays zzaysVar = new zzays();
        zzh = zzaysVar;
        zzbdq.D(zzays.class, zzaysVar);
    }

    private zzays() {
    }

    public final String G() {
        return this.zzb;
    }

    public final String H() {
        return this.zze;
    }

    public final List I() {
        return this.zzf;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ț\u0004Ȉ", new Object[]{"zzb", "zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzays();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzayr(bArr);
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
        synchronized (zzays.class) {
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
