package com.google.android.libraries.places.internal;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaqe extends zzbdq implements zzbey {
    private static final zzaqe zzg;
    private static volatile zzbff zzh;
    private int zzb;
    private double zze;
    private zzbdy zzf = zzbdq.p();

    static {
        zzaqe zzaqeVar = new zzaqe();
        zzg = zzaqeVar;
        zzbdq.D(zzaqe.class, zzaqeVar);
    }

    private zzaqe() {
    }

    public static zzaqd G() {
        return (zzaqd) zzg.A();
    }

    final /* synthetic */ void H(double d3) {
        this.zzb |= 1;
        this.zze = d3;
    }

    final /* synthetic */ void I(Iterable iterable) {
        zzbdy zzbdyVar = this.zzf;
        if (!zzbdyVar.zza()) {
            this.zzf = zzbdq.q(zzbdyVar);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zzf.zzh(((zzala) it.next()).zza());
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
            return zzbdq.m(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001က\u0000\u0002ࠬ", new Object[]{"zzb", "zze", "zzf", zzakz.f75656a});
        }
        if (i4 == 3) {
            return new zzaqe();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaqd(bArr);
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
        synchronized (zzaqe.class) {
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
