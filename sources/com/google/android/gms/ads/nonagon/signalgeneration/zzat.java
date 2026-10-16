package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbhv;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f70691a;

    public final Set a() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.f70691a.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String b() {
        return this.f70691a.toLowerCase(Locale.ROOT);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final zzbhv.zza.EnumC0141zza c() {
        String str = this.f70691a;
        switch (str.hashCode()) {
            case -1999289321:
                if (str.equals("NATIVE")) {
                    return zzbhv.zza.EnumC0141zza.AD_LOADER;
                }
                break;
            case -1372958932:
                if (str.equals("INTERSTITIAL")) {
                    return zzbhv.zza.EnumC0141zza.INTERSTITIAL;
                }
                break;
            case 543046670:
                if (str.equals("REWARDED")) {
                    return zzbhv.zza.EnumC0141zza.REWARD_BASED_VIDEO_AD;
                }
                break;
            case 1951953708:
                if (str.equals("BANNER")) {
                    return zzbhv.zza.EnumC0141zza.BANNER;
                }
                break;
        }
        return zzbhv.zza.EnumC0141zza.AD_INITIATER_UNSPECIFIED;
    }
}
