package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzahz implements zzahq {
    public final String zza;

    private zzahz(String str) {
        this.zza = str;
    }

    public static zzahz zzb(zzet zzetVar) {
        return new zzahz(zzetVar.zzK(zzetVar.zzd(), StandardCharsets.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final int zza() {
        return 1852994675;
    }
}
