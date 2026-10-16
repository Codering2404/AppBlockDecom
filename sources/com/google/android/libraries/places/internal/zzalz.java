package com.google.android.libraries.places.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzalz extends zzbdq implements zzbey {
    private static final zzalz zzt;
    private static volatile zzbff zzu;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private zzaln zzj;
    private zzalg zzk;
    private zzalc zzl;
    private zzaqx zzm;
    private zzali zzn;
    private zzall zzo;
    private zzaqz zzp;
    private zzarh zzq;
    private zzard zzr;
    private int zzs;

    static {
        zzalz zzalzVar = new zzalz();
        zzt = zzalzVar;
        zzbdq.D(zzalz.class, zzalzVar);
    }

    private zzalz() {
    }

    public static zzalu G() {
        return (zzalu) zzt.A();
    }

    final /* synthetic */ void H(int i3) {
        this.zzb |= 4;
        this.zzg = i3;
    }

    final /* synthetic */ void I(zzaln zzalnVar) {
        zzalnVar.getClass();
        this.zzj = zzalnVar;
        this.zzb |= 32;
    }

    final /* synthetic */ void J(zzalc zzalcVar) {
        zzalcVar.getClass();
        this.zzl = zzalcVar;
        this.zzb |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    final /* synthetic */ void K(zzali zzaliVar) {
        zzaliVar.getClass();
        this.zzn = zzaliVar;
        this.zzb |= 512;
    }

    final /* synthetic */ void L(zzarh zzarhVar) {
        zzarhVar.getClass();
        this.zzq = zzarhVar;
        this.zzb |= 4096;
    }

    final /* synthetic */ void N(int i3) {
        this.zze = i3 - 1;
        this.zzb |= 1;
    }

    final /* synthetic */ void O(int i3) {
        this.zzf = i3 - 1;
        this.zzb |= 2;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzt, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဉ\u0007\tဉ\b\nဉ\t\u000bဉ\n\fဉ\u000b\rဉ\f\u000eဉ\r\u000f᠌\u000e", new Object[]{"zzb", "zze", zzalw.f75676a, "zzf", zzaly.f75678a, "zzg", "zzh", zzalv.f75675a, "zzi", zzalt.f75674a, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", zzalx.f75677a});
        }
        if (i4 == 3) {
            return new zzalz();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzalu(bArr);
        }
        if (i4 == 5) {
            return zzt;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzu;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzalz.class) {
            try {
                zzbdlVar = zzu;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzt);
                    zzu = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
