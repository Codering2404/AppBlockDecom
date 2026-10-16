package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzja extends zzmf implements zznn {
    private static final zzja zzf;
    private int zzb;
    private zzmo zzd = zzmf.zzcv();
    private zziw zze;

    static {
        zzja zzjaVar = new zzja();
        zzf = zzjaVar;
        zzmf.zzcp(zzja.class, zzjaVar);
    }

    private zzja() {
    }

    public final List zza() {
        return this.zzd;
    }

    public final zziw zzb() {
        zziw zziwVar = this.zze;
        return zziwVar == null ? zziw.zzc() : zziwVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzmf
    protected final Object zzl(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzmf.zzcq(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzb", "zzd", zzje.class, "zze"});
        }
        if (i4 == 3) {
            return new zzja();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zziz(bArr);
        }
        if (i4 == 5) {
            return zzf;
        }
        throw null;
    }
}
