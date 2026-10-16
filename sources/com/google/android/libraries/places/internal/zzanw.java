package com.google.android.libraries.places.internal;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzanw extends zzbdq implements zzbey {
    private static final zzanw zzx;
    private static volatile zzbff zzy;
    private int zzb;
    private int zze;
    private int zzf = 1;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private zzanr zzv;
    private int zzw;

    static {
        zzanw zzanwVar = new zzanw();
        zzx = zzanwVar;
        zzbdq.D(zzanw.class, zzanwVar);
    }

    private zzanw() {
    }

    public static zzans G() {
        return (zzans) zzx.A();
    }

    final /* synthetic */ void H(boolean z2) {
        this.zzb |= 4;
        this.zzg = z2;
    }

    final /* synthetic */ void I(boolean z2) {
        this.zzb |= 8;
        this.zzh = z2;
    }

    final /* synthetic */ void J(boolean z2) {
        this.zzb |= 16;
        this.zzi = z2;
    }

    final /* synthetic */ void K(int i3) {
        this.zzb |= 32;
        this.zzj = i3;
    }

    final /* synthetic */ void L(int i3) {
        this.zzb |= 64;
        this.zzk = i3;
    }

    final /* synthetic */ void M(int i3) {
        this.zzb |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        this.zzl = i3;
    }

    final /* synthetic */ void N(int i3) {
        this.zzb |= Function.MAX_NARGS;
        this.zzm = i3;
    }

    final /* synthetic */ void O(int i3) {
        this.zzb |= 512;
        this.zzn = i3;
    }

    final /* synthetic */ void P(int i3) {
        this.zzb |= 1024;
        this.zzo = i3;
    }

    final /* synthetic */ void Q(int i3) {
        this.zzb |= 2048;
        this.zzp = i3;
    }

    final /* synthetic */ void R(boolean z2) {
        this.zzb |= 4096;
        this.zzq = z2;
    }

    final /* synthetic */ void S(int i3) {
        this.zzb |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.zzr = i3;
    }

    final /* synthetic */ void T(zzanr zzanrVar) {
        zzanrVar.getClass();
        this.zzv = zzanrVar;
        this.zzb |= 131072;
    }

    final /* synthetic */ void U(int i3) {
        this.zzb |= 262144;
        this.zzw = i3;
    }

    final /* synthetic */ void W(int i3) {
        this.zze = i3 - 1;
        this.zzb |= 1;
    }

    final /* synthetic */ void X(int i3) {
        this.zzf = i3;
        this.zzb |= 2;
    }

    final /* synthetic */ void Y(int i3) {
        this.zzu = i3 - 1;
        this.zzb |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzx, "\u0001\u0013\u0000\u0001\u0001\u0014\u0013\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဋ\u0005\u0007ဋ\u0006\bဋ\u0007\nဋ\t\u000bဋ\n\fဋ\u000b\rဇ\f\u000eဋ\r\u000fဋ\b\u0010ဋ\u000e\u0011᠌\u000f\u0012᠌\u0010\u0013ဉ\u0011\u0014င\u0012", new Object[]{"zzb", "zze", zzanv.f75761a, "zzf", zzano.f75757a, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzn", "zzo", "zzp", "zzq", "zzr", "zzm", "zzs", "zzt", zzant.f75759a, "zzu", zzanu.f75760a, "zzv", "zzw"});
        }
        if (i4 == 3) {
            return new zzanw();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzans(bArr);
        }
        if (i4 == 5) {
            return zzx;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzy;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzanw.class) {
            try {
                zzbdlVar = zzy;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzx);
                    zzy = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
