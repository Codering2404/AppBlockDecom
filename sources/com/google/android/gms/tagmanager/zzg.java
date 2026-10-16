package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzg implements zzau {
    private final Context zza;

    public zzg(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public final void zza(Map map) {
        String queryParameter;
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null && (obj = map.get("gtm")) != null && (obj instanceof Map)) {
            obj2 = ((Map) obj).get("url");
        }
        if (obj2 == null || !(obj2 instanceof String) || (queryParameter = Uri.parse((String) obj2).getQueryParameter("referrer")) == null) {
            return;
        }
        zzcw.zzc(this.zza, queryParameter);
    }
}
