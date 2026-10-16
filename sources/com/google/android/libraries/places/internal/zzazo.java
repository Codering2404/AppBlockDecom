package com.google.android.libraries.places.internal;

import androidx.glance.session.ecY.lisODU;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzazo extends zzbdq implements zzbey {
    private static final zzazo zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private zzaxe zze;
    private zzaxe zzf;
    private String zzg = "";
    private zzbhv zzh;

    static {
        zzazo zzazoVar = new zzazo();
        zzi = zzazoVar;
        zzbdq.D(zzazo.class, zzazoVar);
    }

    private zzazo() {
    }

    public static zzazo M() {
        return zzi;
    }

    public final boolean G() {
        return (this.zzb & 1) != 0;
    }

    public final zzaxe H() {
        zzaxe zzaxeVar = this.zze;
        return zzaxeVar == null ? zzaxe.I() : zzaxeVar;
    }

    public final boolean I() {
        return (this.zzb & 2) != 0;
    }

    public final zzaxe J() {
        zzaxe zzaxeVar = this.zzf;
        return zzaxeVar == null ? zzaxe.I() : zzaxeVar;
    }

    public final String K() {
        return this.zzg;
    }

    public final zzbhv L() {
        zzbhv zzbhvVar = this.zzh;
        return zzbhvVar == null ? zzbhv.I() : zzbhvVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzi, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003Ȉ\u0004ဉ\u0002", new Object[]{"zzb", lisODU.wiHuEARNi, "zzf", "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzazo();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzazn(bArr);
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
        synchronized (zzazo.class) {
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
