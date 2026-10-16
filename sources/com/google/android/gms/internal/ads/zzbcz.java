package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcz extends zzbdf {
    private final zzbbz zzh;
    private long zzi;

    public zzbcz(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4, zzbbz zzbbzVar) {
        super(zzbbsVar, "CX4J+2yEJ2HtJzNjBSAFoPZxV3S124qFqsrwrEik3kHdsHRX3oIIB4d/zi0EQ0fu", "gfLiyhD2OvLSOj6bwf+kcmK11rwQ90aeBshxHD6xXgk=", zzaxmVar, i3, 53);
        this.zzh = zzbbzVar;
        if (zzbbzVar != null) {
            this.zzi = zzbbzVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzh != null) {
            this.zzd.zzH(((Long) this.zze.invoke(null, Long.valueOf(this.zzi))).longValue());
        }
    }
}
