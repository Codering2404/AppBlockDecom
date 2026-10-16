package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzw extends zzm {
    public zzw(Activity activity) {
        super(activity);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzm, com.google.android.gms.internal.ads.zzbzb
    public final void zzh(Bundle bundle) {
        com.google.android.gms.ads.internal.util.zze.k("AdOverlayParcel is null or does not contain valid overlay type.");
        this.f70120w = 4;
        this.f70099a.finish();
    }
}
