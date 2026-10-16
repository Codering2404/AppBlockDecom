package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfcx implements zzfci {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final boolean zze;
    public final int zzf;

    public zzfcx(String str, int i3, int i4, int i5, boolean z2, int i6) {
        this.zza = str;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = z2;
        this.zzf = i6;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzfln.zzb(bundle, "carrier", this.zza, !TextUtils.isEmpty(r0));
        int i3 = this.zzb;
        zzfln.zzc(bundle, "cnt", i3, i3 != -2);
        bundle.putInt("gnt", this.zzc);
        bundle.putInt("pt", this.zzd);
        Bundle bundleZza = zzfln.zza(bundle, DeviceRequestsHelper.DEVICE_INFO_DEVICE);
        bundle.putBundle(DeviceRequestsHelper.DEVICE_INFO_DEVICE, bundleZza);
        Bundle bundleZza2 = zzfln.zza(bundleZza, "network");
        bundleZza.putBundle("network", bundleZza2);
        bundleZza2.putInt("active_network_state", this.zzf);
        bundleZza2.putBoolean("active_network_metered", this.zze);
    }
}
