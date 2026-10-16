package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhzz {
    public static final zzhzz zza = new zzhzz(new zziaa());
    public static final zzhzz zzb = new zzhzz(new zziae());
    public static final zzhzz zzc = new zzhzz(new zziag());
    public static final zzhzz zzd = new zzhzz(new zziaf());
    public static final zzhzz zze;
    public static final zzhzz zzf;
    private final zzhzy zzg;

    static {
        new zzhzz(new zziab());
        zze = new zzhzz(new zziad());
        zzf = new zzhzz(new zziac());
    }

    public zzhzz(zziah zziahVar) {
        this.zzg = !zzhks.zza() ? "The Android Project".equals(System.getProperty("java.vendor")) ? new zzhzv(zziahVar, null) : new zzhzw(zziahVar, null) : new zzhzx(zziahVar, null);
    }

    public static List zza(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public final Object zzb(String str) throws GeneralSecurityException {
        return this.zzg.zza(str);
    }
}
