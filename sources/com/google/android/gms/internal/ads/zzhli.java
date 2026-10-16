package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhli {
    private final Map zza;
    private final Map zzb;

    /* synthetic */ zzhli(Map map, Map map2, byte[] bArr) {
        this.zza = map;
        this.zzb = map2;
    }

    public static zzhlh zza() {
        return new zzhlh(null);
    }

    public final Enum zzb(Object obj) throws GeneralSecurityException {
        Enum r02 = (Enum) this.zzb.get(obj);
        if (r02 != null) {
            return r02;
        }
        throw new GeneralSecurityException("Unable to convert object enum: ".concat(String.valueOf(obj)));
    }

    public final Object zzc(Enum r3) throws GeneralSecurityException {
        Object obj = this.zza.get(r3);
        if (obj != null) {
            return obj;
        }
        throw new GeneralSecurityException("Unable to convert proto enum: ".concat(String.valueOf(r3)));
    }
}
