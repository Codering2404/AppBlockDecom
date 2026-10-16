package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.internal.ads.zzbhp;
import com.google.android.gms.internal.ads.zzcku;
import com.google.android.gms.internal.ads.zzclf;
import com.google.android.gms.internal.ads.zzcmi;
import com.google.android.gms.internal.ads.zzekr;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class zzt extends zzz {
    public zzt() {
        super(null);
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final CookieManager a(Context context) {
        com.google.android.gms.ads.internal.zzt.g();
        if (zzs.i()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            int i3 = zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzt.l().zzh(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public zzclf b(zzcku zzckuVar, zzbhp zzbhpVar, boolean z2, zzekr zzekrVar) {
        return new zzcmi(zzckuVar, zzbhpVar, z2, zzekrVar);
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final WebResourceResponse c(String str, String str2, int i3, String str3, Map map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i3, str3, map, inputStream);
    }
}
