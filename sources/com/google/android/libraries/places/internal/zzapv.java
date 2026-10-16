package com.google.android.libraries.places.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzapv extends zzbdq implements zzbey {
    private static final zzapv zzB;
    private static volatile zzbff zzC;
    private int zzb;
    private int zze;
    private zzamo zzh;
    private zzaqm zzi;
    private zzaor zzj;
    private zzanl zzk;
    private zzaop zzl;
    private zzann zzm;
    private zzaon zzn;
    private zzaqo zzo;
    private zzaqo zzp;
    private zzaot zzq;
    private zzaob zzr;
    private zzapx zzs;
    private zzapz zzt;
    private zzapk zzu;
    private zzaoy zzv;
    private zzaqb zzw;
    private zzaqg zzx;
    private zzaqj zzy;
    private zzaop zzz;
    private byte zzA = 2;
    private String zzf = "";
    private String zzg = "";

    static {
        zzapv zzapvVar = new zzapv();
        zzB = zzapvVar;
        zzbdq.D(zzapv.class, zzapvVar);
    }

    private zzapv() {
    }

    public static zzapt G() {
        return (zzapt) zzB.A();
    }

    final /* synthetic */ void H(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zzf = str;
    }

    final /* synthetic */ void I(String str) {
        str.getClass();
        this.zzb |= 4;
        this.zzg = str;
    }

    final /* synthetic */ void J(zzaop zzaopVar) {
        zzaopVar.getClass();
        this.zzl = zzaopVar;
        this.zzb |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    final /* synthetic */ void K(zzann zzannVar) {
        zzannVar.getClass();
        this.zzm = zzannVar;
        this.zzb |= Function.MAX_NARGS;
    }

    final /* synthetic */ void L(zzaqg zzaqgVar) {
        zzaqgVar.getClass();
        this.zzx = zzaqgVar;
        this.zzb |= 524288;
    }

    final /* synthetic */ void M(zzaqj zzaqjVar) {
        zzaqjVar.getClass();
        this.zzy = zzaqjVar;
        this.zzb |= 1048576;
    }

    final /* synthetic */ void N(zzaop zzaopVar) {
        zzaopVar.getClass();
        this.zzz = zzaopVar;
        this.zzb |= 2097152;
    }

    final /* synthetic */ void P(int i3) {
        this.zze = i3 - 1;
        this.zzb |= 1;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzA);
        }
        if (i4 == 2) {
            return zzbdq.m(zzB, "\u0001\u0016\u0000\u0001\u0001\u0016\u0016\u0000\u0000\u0004\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003\u0005ᐉ\u0004\u0006ᐉ\u0005\u0007ᐉ\u0006\bဉ\u0007\tᐉ\b\nဉ\t\u000bဉ\u000b\fဉ\n\rဉ\f\u000eဉ\r\u000fဉ\u000e\u0010ဉ\u000f\u0011ဉ\u0010\u0012ဉ\u0011\u0013ဉ\u0012\u0014ဉ\u0013\u0015ဉ\u0014\u0016ဉ\u0015", new Object[]{"zzb", "zze", zzapu.f75775a, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzp", "zzo", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz"});
        }
        if (i4 == 3) {
            return new zzapv();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzapt(bArr);
        }
        if (i4 == 5) {
            return zzB;
        }
        if (i4 != 6) {
            this.zzA = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzbff zzbffVar = zzC;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzapv.class) {
            try {
                zzbdlVar = zzC;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzB);
                    zzC = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
