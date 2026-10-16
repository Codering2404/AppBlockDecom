package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.Bundle;
import android.os.ext.SdkExtensions;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzewf implements zzfci {

    @Nullable
    private final Integer zza;

    private zzewf(@Nullable Integer num) {
        this.zza = num;
    }

    static /* synthetic */ zzewf zzb(VersionInfoParcel versionInfoParcel) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlw)).booleanValue()) {
            return new zzewf(null);
        }
        com.google.android.gms.ads.internal.zzt.g();
        int extensionVersion = 0;
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlz)).booleanValue()) {
                    if (versionInfoParcel.f70151c >= ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzly)).intValue() && i3 >= 31 && SdkExtensions.getExtensionVersion(31) >= 9) {
                        extensionVersion = SdkExtensions.getExtensionVersion(31);
                    }
                }
            } else {
                extensionVersion = SdkExtensions.getExtensionVersion(1000000);
            }
        } catch (Exception e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "AdUtil.getAdServicesExtensionVersion");
        }
        return new zzewf(Integer.valueOf(extensionVersion));
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Integer num = this.zza;
        Bundle bundle = (Bundle) obj;
        if (num != null) {
            bundle.putInt("aos", num.intValue());
        }
    }
}
