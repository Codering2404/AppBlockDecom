package com.google.android.libraries.places.internal;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbbn extends zzbdq implements zzbey {
    private static final zzbbn zzg;
    private static volatile zzbff zzh;
    private double zzb;
    private zzbdy zze = zzbdq.p();
    private zzbea zzf = zzbdq.s();

    static {
        zzbbn zzbbnVar = new zzbbn();
        zzg = zzbbnVar;
        zzbdq.D(zzbbn.class, zzbbnVar);
    }

    private zzbbn() {
    }

    public static zzbbm G() {
        return (zzbbm) zzg.A();
    }

    final /* synthetic */ void H(double d3) {
        this.zzb = d3;
    }

    final /* synthetic */ void I(Iterable iterable) {
        zzbdy zzbdyVar = this.zze;
        if (!zzbdyVar.zza()) {
            this.zze = zzbdq.q(zzbdyVar);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zze.zzh(((zzaxz) it.next()).zza());
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u0000\u0002,\u0003Ț", new Object[]{"zzb", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzbbn();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbbm(bArr);
        }
        if (i4 == 5) {
            return zzg;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzh;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbbn.class) {
            try {
                zzbdlVar = zzh;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzg);
                    zzh = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
