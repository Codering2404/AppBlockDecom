package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaxe extends zzbdq implements zzbey {
    private static final zzaxe zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private zzbhv zzf;
    private zzbas zzg;
    private String zze = "";
    private zzbea zzh = zzbdq.s();

    static {
        zzaxe zzaxeVar = new zzaxe();
        zzi = zzaxeVar;
        zzbdq.D(zzaxe.class, zzaxeVar);
    }

    private zzaxe() {
    }

    public static zzaxe I() {
        return zzi;
    }

    public final zzbhv G() {
        zzbhv zzbhvVar = this.zzf;
        return zzbhvVar == null ? zzbhv.I() : zzbhvVar;
    }

    public final List H() {
        return this.zzh;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzi, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004Ț", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzaxe();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaxd(bArr);
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
        synchronized (zzaxe.class) {
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
