package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzc extends zzb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f70306a;

    zzc(Context context) {
        this.f70306a = context;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        boolean isAdIdFakeForDebugLogging;
        try {
            isAdIdFakeForDebugLogging = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.f70306a);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e3) {
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Fail to get isAdIdFakeForDebugLogging", e3);
            isAdIdFakeForDebugLogging = false;
        }
        com.google.android.gms.ads.internal.util.client.zzl.h(isAdIdFakeForDebugLogging);
        StringBuilder sb = new StringBuilder(String.valueOf(isAdIdFakeForDebugLogging).length() + 38);
        sb.append("Update ad debug logging enablement as ");
        sb.append(isAdIdFakeForDebugLogging);
        String string = sb.toString();
        int i4 = zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f(string);
    }
}
