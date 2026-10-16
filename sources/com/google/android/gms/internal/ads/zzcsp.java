package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcsp implements zzcrt {
    private final zzfke zza;

    public zzcsp(zzfke zzfkeVar) {
        this.zza = zzfkeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcrt
    public final void zza(Map map) {
        String str = (String) map.get("render_in_browser");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.zza.zza(Boolean.parseBoolean(str));
        } catch (Exception e3) {
            throw new IllegalStateException("Invalid render_in_browser state", e3);
        }
    }
}
