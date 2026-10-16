package com.google.android.gms.internal.gtm;

import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrv {
    private final List zza;
    private final Map zzb;
    private final String zzc;

    /* synthetic */ zzrv(List list, Map map, String str, int i3, zzru zzruVar) {
        this.zza = Collections.unmodifiableList(list);
        this.zzb = Collections.unmodifiableMap(map);
        this.zzc = str;
    }

    public static zzrx zza() {
        return new zzrx(null);
    }

    public final String zzb() {
        return this.zzc;
    }

    public final List zzc() {
        return this.zza;
    }

    public final Map zzd() {
        return this.zzb;
    }

    public final String toString() {
        return "Rules: " + String.valueOf(this.zza) + KrzujOtzIk.rHQLvYb + String.valueOf(this.zzb);
    }
}
