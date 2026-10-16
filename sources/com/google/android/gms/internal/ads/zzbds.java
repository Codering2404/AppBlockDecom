package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzbds implements zziei {
    UNSUPPORTED(0),
    zzb(2),
    X86(4),
    ARM64(5),
    X86_64(6),
    RISCV64(7),
    zzg(999);

    private final int zzh;

    zzbds(int i3) {
        this.zzh = i3;
    }

    public static zzbds zzb(int i3) {
        if (i3 == 0) {
            return UNSUPPORTED;
        }
        if (i3 == 2) {
            return zzb;
        }
        if (i3 == 999) {
            return zzg;
        }
        if (i3 == 4) {
            return X86;
        }
        if (i3 == 5) {
            return ARM64;
        }
        if (i3 == 6) {
            return X86_64;
        }
        if (i3 != 7) {
            return null;
        }
        return RISCV64;
    }

    public static zziek zzc() {
        return zzbdr.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zziei
    public final int zza() {
        return this.zzh;
    }
}
