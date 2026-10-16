package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzazi extends zzbdq implements zzbey {
    private static final zzazi zzk;
    private static volatile zzbff zzl;
    private int zzb;
    private zzaxe zze;
    private zzaxe zzf;
    private zzaxe zzg;
    private zzaxe zzh;
    private String zzi = "";
    private zzbhv zzj;

    static {
        zzazi zzaziVar = new zzazi();
        zzk = zzaziVar;
        zzbdq.D(zzazi.class, zzaziVar);
    }

    private zzazi() {
    }

    public static zzazi P() {
        return zzk;
    }

    public final zzaxe G() {
        zzaxe zzaxeVar = this.zze;
        return zzaxeVar == null ? zzaxe.I() : zzaxeVar;
    }

    public final boolean H() {
        return (this.zzb & 2) != 0;
    }

    public final zzaxe I() {
        zzaxe zzaxeVar = this.zzf;
        return zzaxeVar == null ? zzaxe.I() : zzaxeVar;
    }

    public final boolean J() {
        return (this.zzb & 4) != 0;
    }

    public final zzaxe K() {
        zzaxe zzaxeVar = this.zzg;
        return zzaxeVar == null ? zzaxe.I() : zzaxeVar;
    }

    public final boolean L() {
        return (this.zzb & 8) != 0;
    }

    public final zzaxe M() {
        zzaxe zzaxeVar = this.zzh;
        return zzaxeVar == null ? zzaxe.I() : zzaxeVar;
    }

    public final String N() {
        return this.zzi;
    }

    public final zzbhv O() {
        zzbhv zzbhvVar = this.zzj;
        return zzbhvVar == null ? zzbhv.I() : zzbhvVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzk, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005Ȉ\u0006ဉ\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i4 == 3) {
            return new zzazi();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzazh(bArr);
        }
        if (i4 == 5) {
            return zzk;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzl;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzazi.class) {
            try {
                zzbdlVar = zzl;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzk);
                    zzl = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
