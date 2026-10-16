package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcsv implements zzcrt {
    private final CookieManager zza;

    public zzcsv(Context context) {
        this.zza = com.google.android.gms.ads.internal.zzt.j().a(context);
    }

    @Override // com.google.android.gms.internal.ads.zzcrt
    public final void zza(Map map) {
        CookieManager cookieManager = this.zza;
        if (cookieManager == null) {
            return;
        }
        if (((String) map.get("clear")) == null) {
            String str = (String) map.get("cookie");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            cookieManager.setCookie((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbz), str);
            return;
        }
        String str2 = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbz);
        String cookie = cookieManager.getCookie(str2);
        if (cookie != null) {
            List listZze = zzgty.zza(zzgsx.zzc(';')).zze(cookie);
            for (int i3 = 0; i3 < listZze.size(); i3++) {
                Iterator it = zzgty.zza(zzgsx.zzc('=')).zzd((String) listZze.get(i3)).iterator();
                it.getClass();
                if (!it.hasNext()) {
                    StringBuilder sb = new StringBuilder(String.valueOf(0).length() + 70);
                    sb.append("position (0) must be less than the number of elements that remained (");
                    sb.append(0);
                    sb.append(")");
                    throw new IndexOutOfBoundsException(sb.toString());
                }
                cookieManager.setCookie(str2, String.valueOf((String) it.next()).concat(String.valueOf((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbk))));
            }
        }
    }
}
