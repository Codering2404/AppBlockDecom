package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzclr implements zzbpq {
    final /* synthetic */ zzclx zza;

    zzclr(zzclx zzclxVar) {
        Objects.requireNonNull(zzclxVar);
        this.zza = zzclxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int i3 = Integer.parseInt(str);
                zzclx zzclxVar = this.zza;
                synchronized (zzclxVar) {
                    try {
                        if (zzclxVar.zzaX() != i3) {
                            zzclxVar.zzaY(i3);
                            zzclxVar.requestLayout();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e3) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Exception occurred while getting webview content height", e3);
            }
        }
    }
}
