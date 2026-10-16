package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzblt;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@ParametersAreNonnullByDefault
public class MediationNativeAdConfiguration extends MediationAdConfiguration {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzblt f70488j;

    public MediationNativeAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z2, Location location, int i3, int i4, String str2, String str3, zzblt zzbltVar) {
        super(context, str, bundle, bundle2, z2, location, i3, i4, str2, str3);
        this.f70488j = zzbltVar;
    }
}
