package com.google.android.libraries.places.internal;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbbu extends zzbdq implements zzbey {
    private static final zzbbu zzx;
    private static volatile zzbff zzy;
    private int zzb;
    private int zzh;
    private boolean zzj;
    private double zzk;
    private int zzl;
    private int zzm;
    private boolean zzp;
    private zzbbp zzq;
    private zzbbr zzr;
    private zzbbn zzs;
    private zzbay zzt;
    private zzbbt zzu;
    private boolean zzv;
    private boolean zzw;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzi = "";
    private String zzn = "";
    private zzbdy zzo = zzbdq.p();

    static {
        zzbbu zzbbuVar = new zzbbu();
        zzx = zzbbuVar;
        zzbdq.D(zzbbu.class, zzbbuVar);
    }

    private zzbbu() {
    }

    public static zzbbl G() {
        return (zzbbl) zzx.A();
    }

    public static zzbbu H() {
        return zzx;
    }

    final /* synthetic */ void I(String str) {
        str.getClass();
        this.zze = str;
    }

    final /* synthetic */ void J(String str) {
        str.getClass();
        this.zzf = str;
    }

    final /* synthetic */ void K(String str) {
        this.zzg = str;
    }

    final /* synthetic */ void L(String str) {
        this.zzi = str;
    }

    final /* synthetic */ void M(boolean z2) {
        this.zzj = z2;
    }

    final /* synthetic */ void N(double d3) {
        this.zzk = d3;
    }

    final /* synthetic */ void O(int i3) {
        this.zzl = i3;
    }

    final /* synthetic */ void P(String str) {
        this.zzn = str;
    }

    final /* synthetic */ void Q(Iterable iterable) {
        zzbdy zzbdyVar = this.zzo;
        if (!zzbdyVar.zza()) {
            this.zzo = zzbdq.q(zzbdyVar);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zzo.zzh(((zzbao) it.next()).zza());
        }
    }

    final /* synthetic */ void R(boolean z2) {
        this.zzp = z2;
    }

    final /* synthetic */ void S(zzbbp zzbbpVar) {
        zzbbpVar.getClass();
        this.zzq = zzbbpVar;
        this.zzb |= 1;
    }

    final /* synthetic */ void T(zzbbr zzbbrVar) {
        zzbbrVar.getClass();
        this.zzr = zzbbrVar;
        this.zzb |= 2;
    }

    final /* synthetic */ void U(zzbbn zzbbnVar) {
        zzbbnVar.getClass();
        this.zzs = zzbbnVar;
        this.zzb |= 4;
    }

    final /* synthetic */ void V(zzbay zzbayVar) {
        zzbayVar.getClass();
        this.zzt = zzbayVar;
        this.zzb |= 8;
    }

    final /* synthetic */ void W(zzbbt zzbbtVar) {
        zzbbtVar.getClass();
        this.zzu = zzbbtVar;
        this.zzb |= 16;
    }

    final /* synthetic */ void X(boolean z2) {
        this.zzv = true;
    }

    final /* synthetic */ void Z(int i3) {
        this.zzh = i3 - 2;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzx, "\u0000\u0013\u0000\u0001\u0001\u0015\u0013\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\f\u0006Ȉ\u0007\u0007\t\u0000\n\u0004\u000b,\f\u0007\rဉ\u0000\u000eဉ\u0001\u000fဉ\u0002\u0010ဉ\u0003\u0011ဉ\u0004\u0012\u0004\u0013Ȉ\u0014\u0007\u0015\u0007", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzm", "zzn", "zzv", "zzw"});
        }
        if (i4 == 3) {
            return new zzbbu();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbbl(bArr);
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
        synchronized (zzbbu.class) {
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
