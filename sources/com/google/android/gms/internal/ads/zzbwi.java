package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Parcelable;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbwi implements NativeMediationAdRequest {
    private final Date zza;
    private final int zzb;
    private final Set zzc;
    private final boolean zzd;
    private final Location zze;
    private final int zzf;
    private final zzblt zzg;
    private final boolean zzi;
    private final List zzh = new ArrayList();
    private final Map zzj = new HashMap();

    public zzbwi(Date date, int i3, Set set, Location location, boolean z2, int i4, zzblt zzbltVar, List list, boolean z3, int i5, String str) {
        this.zza = date;
        this.zzb = i3;
        this.zzc = set;
        this.zze = location;
        this.zzd = z2;
        this.zzf = i4;
        this.zzg = zzbltVar;
        this.zzi = z3;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.startsWith("custom:")) {
                    String[] strArrSplit = str2.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, 3);
                    if (strArrSplit.length == 3) {
                        String str3 = strArrSplit[2];
                        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(str3)) {
                            this.zzj.put(strArrSplit[1], Boolean.TRUE);
                        } else if ("false".equals(str3)) {
                            this.zzj.put(strArrSplit[1], Boolean.FALSE);
                        }
                    }
                } else {
                    this.zzh.add(str2);
                }
            }
        }
    }

    public final float getAdVolume() {
        return com.google.android.gms.ads.internal.client.zzeu.f().i();
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zza;
    }

    @Deprecated
    public final int getGender() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.zzc;
    }

    public final Location getLocation() {
        return this.zze;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final NativeAdOptions getNativeAdOptions() {
        Parcelable.Creator<zzblt> creator = zzblt.CREATOR;
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        zzblt zzbltVar = this.zzg;
        if (zzbltVar == null) {
            return builder.a();
        }
        int i3 = zzbltVar.zza;
        if (i3 == 2) {
            builder.b(zzbltVar.zze);
        } else {
            if (i3 != 3) {
                if (i3 == 4) {
                    builder.e(zzbltVar.zzg);
                    builder.d(zzbltVar.zzh);
                }
            }
            com.google.android.gms.ads.internal.client.zzfw zzfwVar = zzbltVar.zzf;
            if (zzfwVar != null) {
                builder.h(new VideoOptions(zzfwVar));
            }
            builder.b(zzbltVar.zze);
        }
        builder.g(zzbltVar.zzb);
        builder.c(zzbltVar.zzc);
        builder.f(zzbltVar.zzd);
        return builder.a();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions() {
        return zzblt.zza(this.zzg);
    }

    public final boolean isAdMuted() {
        return com.google.android.gms.ads.internal.client.zzeu.f().k();
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzi;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isUnifiedNativeAdRequested() {
        return this.zzh.contains("6");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.zzf;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean zza() {
        return this.zzh.contains("3");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final Map zzb() {
        return this.zzj;
    }
}
