package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzcmh extends zzclf {
    public zzcmh(zzcku zzckuVar, zzbhp zzbhpVar, boolean z2, zzekr zzekrVar) {
        super(zzckuVar, zzbhpVar, z2, new zzbyf(zzckuVar, zzckuVar.zzK(), new zzbhx(zzckuVar.getContext())), null, zzekrVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final WebResourceResponse zzac(WebView webView, String str, Map map) {
        String str2;
        if (!(webView instanceof zzcku)) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcku zzckuVar = (zzcku) webView;
        zzcdn zzcdnVar = this.zzb;
        if (zzcdnVar != null) {
            zzcdnVar.zze(str, map, 1);
        }
        zzfzk.zza();
        zzfzp zzfzpVar = zzfzp.zza;
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.EMPTY_MAP;
            }
            return super.zzL(str, map);
        }
        if (zzckuVar.zzP() != null) {
            zzckuVar.zzP().zzN();
        }
        if (zzckuVar.zzN().zzg()) {
            str2 = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaB);
        } else if (zzckuVar.zzW()) {
            str2 = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaA);
        } else {
            str2 = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzaz);
        }
        com.google.android.gms.ads.internal.zzt.g();
        return com.google.android.gms.ads.internal.util.zzs.k0(zzckuVar.getContext(), zzckuVar.zzs().f70149a, str2);
    }
}
