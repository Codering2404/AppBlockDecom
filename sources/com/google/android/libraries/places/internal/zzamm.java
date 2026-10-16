package com.google.android.libraries.places.internal;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzamm extends zzbdq implements zzbey {
    private static final zzamm zzm;
    private static volatile zzbff zzn;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private zzbdy zzh = zzbdq.p();
    private int zzi;
    private int zzj;
    private boolean zzk;
    private zzapa zzl;

    static {
        zzamm zzammVar = new zzamm();
        zzm = zzammVar;
        zzbdq.D(zzamm.class, zzammVar);
    }

    private zzamm() {
    }

    public static zzamd G() {
        return (zzamd) zzm.A();
    }

    final /* synthetic */ void H(zzaml zzamlVar) {
        this.zzf = zzamlVar.zza();
        this.zzb |= 2;
    }

    final /* synthetic */ void I(zzamj zzamjVar) {
        this.zzg = zzamjVar.zza();
        this.zzb |= 4;
    }

    final /* synthetic */ void J(Iterable iterable) {
        zzbdy zzbdyVar = this.zzh;
        if (!zzbdyVar.zza()) {
            this.zzh = zzbdq.q(zzbdyVar);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zzh.zzh(((zzamg) it.next()).zza());
        }
    }

    final /* synthetic */ void K(int i3) {
        this.zzb |= 16;
        this.zzj = i3;
    }

    final /* synthetic */ void L(zzapa zzapaVar) {
        zzapaVar.getClass();
        this.zzl = zzapaVar;
        this.zzb |= 64;
    }

    final /* synthetic */ void N(int i3) {
        this.zze = i3 - 1;
        this.zzb |= 1;
    }

    final /* synthetic */ void O(int i3) {
        this.zzi = i3 - 1;
        this.zzb |= 8;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzm, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004ࠬ\u0005᠌\u0003\u0006င\u0004\u0007ဇ\u0005\bဉ\u0006", new Object[]{"zzb", "zze", zzamh.f75703a, "zzf", zzamk.f75710a, "zzg", zzami.f75704a, "zzh", zzamf.f75681a, "zzi", zzame.f75680a, "zzj", "zzk", "zzl"});
        }
        if (i4 == 3) {
            return new zzamm();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzamd(bArr);
        }
        if (i4 == 5) {
            return zzm;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzn;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzamm.class) {
            try {
                zzbdlVar = zzn;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzm);
                    zzn = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
