package com.google.android.libraries.places.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzanh extends zzbdq implements zzbey {
    private static final zzanh zzn;
    private static volatile zzbff zzo;
    private int zzb;
    private int zze;
    private int zzf;
    private zzbdy zzg = zzbdq.p();
    private int zzh;
    private boolean zzi;
    private boolean zzj;
    private int zzk;
    private int zzl;
    private zzapa zzm;

    static {
        zzanh zzanhVar = new zzanh();
        zzn = zzanhVar;
        zzbdq.D(zzanh.class, zzanhVar);
    }

    private zzanh() {
    }

    public static zzamx G() {
        return (zzamx) zzn.A();
    }

    final /* synthetic */ void H(zzane zzaneVar) {
        this.zzf = zzaneVar.zza();
        this.zzb |= 2;
    }

    final /* synthetic */ void I(Iterable iterable) {
        zzbdy zzbdyVar = this.zzg;
        if (!zzbdyVar.zza()) {
            this.zzg = zzbdq.q(zzbdyVar);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zzg.zzh(((zzanb) it.next()).zza());
        }
    }

    final /* synthetic */ void J(zzang zzangVar) {
        this.zzh = zzangVar.zza();
        this.zzb |= 4;
    }

    final /* synthetic */ void K(boolean z2) {
        this.zzb |= 8;
        this.zzi = z2;
    }

    final /* synthetic */ void L(boolean z2) {
        this.zzb |= 16;
        this.zzj = z2;
    }

    final /* synthetic */ void M(zzamz zzamzVar) {
        this.zzk = zzamzVar.zza();
        this.zzb |= 32;
    }

    final /* synthetic */ void N(zzanj zzanjVar) {
        this.zzl = zzanjVar.zza();
        this.zzb |= 64;
    }

    final /* synthetic */ void O(zzapa zzapaVar) {
        zzapaVar.getClass();
        this.zzm = zzapaVar;
        this.zzb |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    final /* synthetic */ void Q(int i3) {
        this.zze = i3 - 1;
        this.zzb |= 1;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ࠬ\u0004᠌\u0002\u0005ဇ\u0003\u0006ဇ\u0004\u0007᠌\u0005\b᠌\u0006\tဉ\u0007", new Object[]{"zzb", "zze", zzanc.f75738a, "zzf", zzand.f75739a, "zzg", zzana.f75727a, "zzh", zzanf.f75745a, "zzi", "zzj", "zzk", zzamy.f75720a, "zzl", zzani.f75751a, "zzm"});
        }
        if (i4 == 3) {
            return new zzanh();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzamx(bArr);
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
        synchronized (zzanh.class) {
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
