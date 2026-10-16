package com.google.android.libraries.places.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaqg extends zzbdq implements zzbey {
    private static final zzaqg zzs;
    private static volatile zzbff zzt;
    private int zzb;
    private int zze;
    private boolean zzg;
    private double zzh;
    private int zzi;
    private boolean zzk;
    private zzapp zzl;
    private zzaqe zzm;
    private zzaqu zzn;
    private boolean zzo;
    private boolean zzq;
    private boolean zzr;
    private String zzf = "";
    private zzbdy zzj = zzbdq.p();
    private String zzp = "";

    static {
        zzaqg zzaqgVar = new zzaqg();
        zzs = zzaqgVar;
        zzbdq.D(zzaqg.class, zzaqgVar);
    }

    private zzaqg() {
    }

    public static zzaqc G() {
        return (zzaqc) zzs.A();
    }

    final /* synthetic */ void H(String str) {
        this.zzb |= 2;
        this.zzf = str;
    }

    final /* synthetic */ void I(boolean z2) {
        this.zzb |= 4;
        this.zzg = z2;
    }

    final /* synthetic */ void J(double d3) {
        this.zzb |= 8;
        this.zzh = d3;
    }

    final /* synthetic */ void K(int i3) {
        this.zzb |= 16;
        this.zzi = i3;
    }

    final /* synthetic */ void L(Iterable iterable) {
        zzbdy zzbdyVar = this.zzj;
        if (!zzbdyVar.zza()) {
            this.zzj = zzbdq.q(zzbdyVar);
        }
        zzbby.f(iterable, this.zzj);
    }

    final /* synthetic */ void M(boolean z2) {
        this.zzb |= 32;
        this.zzk = z2;
    }

    final /* synthetic */ void N(zzapp zzappVar) {
        zzappVar.getClass();
        this.zzl = zzappVar;
        this.zzb |= 64;
    }

    final /* synthetic */ void O(zzaqe zzaqeVar) {
        zzaqeVar.getClass();
        this.zzm = zzaqeVar;
        this.zzb |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    final /* synthetic */ void P(zzaqu zzaquVar) {
        zzaquVar.getClass();
        this.zzn = zzaquVar;
        this.zzb |= Function.MAX_NARGS;
    }

    final /* synthetic */ void Q(boolean z2) {
        this.zzb |= 512;
        this.zzo = z2;
    }

    final /* synthetic */ void R(boolean z2) {
        this.zzb |= 2048;
        this.zzq = z2;
    }

    final /* synthetic */ void S(boolean z2) {
        this.zzb |= 4096;
        this.zzr = z2;
    }

    final /* synthetic */ void U(int i3) {
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
            return zzbdq.m(zzs, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004က\u0003\u0005င\u0004\u0006'\u0007ဇ\u0005\bဉ\u0006\tဉ\u0007\nဉ\b\u000bဇ\t\fဈ\n\rဇ\u000b\u000eဇ\f", new Object[]{"zzb", "zze", zzaqf.f75777a, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr"});
        }
        if (i4 == 3) {
            return new zzaqg();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaqc(bArr);
        }
        if (i4 == 5) {
            return zzs;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzt;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaqg.class) {
            try {
                zzbdlVar = zzt;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzs);
                    zzt = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
