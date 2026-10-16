package com.google.android.recaptcha.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbs {
    private final GoogleApiAvailabilityLight zza;

    public zzbs(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zza = googleApiAvailabilityLight;
    }

    public final int zza(Context context) {
        int i3 = this.zza.i(context);
        return (i3 == 1 || i3 == 3 || i3 == 9) ? 4 : 3;
    }

    public zzbs() {
        this.zza = GoogleApiAvailabilityLight.h();
    }
}
