package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzapa extends zzbdq implements zzbey {
    private static final zzapa zzj;
    private static volatile zzbff zzk;
    private int zzb;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    static {
        zzapa zzapaVar = new zzapa();
        zzj = zzapaVar;
        zzbdq.D(zzapa.class, zzapaVar);
    }

    private zzapa() {
    }

    public static zzaoz L() {
        return (zzaoz) zzj.A();
    }

    public final boolean G() {
        return this.zze;
    }

    public final boolean H() {
        return this.zzf;
    }

    public final boolean I() {
        return this.zzg;
    }

    public final boolean J() {
        return this.zzh;
    }

    public final boolean K() {
        return this.zzi;
    }

    final /* synthetic */ void M(boolean z2) {
        this.zzb |= 1;
        this.zze = z2;
    }

    final /* synthetic */ void N(boolean z2) {
        this.zzb |= 2;
        this.zzf = z2;
    }

    final /* synthetic */ void O(boolean z2) {
        this.zzb |= 4;
        this.zzg = z2;
    }

    final /* synthetic */ void P(boolean z2) {
        this.zzb |= 8;
        this.zzh = z2;
    }

    final /* synthetic */ void Q(boolean z2) {
        this.zzb |= 16;
        this.zzi = z2;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i4 == 3) {
            return new zzapa();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaoz(bArr);
        }
        if (i4 == 5) {
            return zzj;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzk;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzapa.class) {
            try {
                zzbdlVar = zzk;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzj);
                    zzk = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
