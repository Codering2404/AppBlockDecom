package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.webkit.WebView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfwc extends zzfvy {
    private WebView zza;
    private Long zzb;
    private final Map zzc;

    public zzfwc(String str, Map map, String str2) {
        super(str);
        this.zzb = null;
        this.zzc = map;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza() {
        WebView webView = new WebView(zzfvn.zza().zzb());
        this.zza = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.zza.getSettings().setAllowContentAccess(false);
        this.zza.getSettings().setAllowFileAccess(false);
        this.zza.setWebViewClient(new zzfwa(this));
        zzc(this.zza);
        zzfvp.zzk(this.zza, null);
        Map map = this.zzc;
        Iterator it = map.keySet().iterator();
        if (it.hasNext()) {
            throw null;
        }
        this.zzb = Long.valueOf(System.nanoTime());
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zzb() {
        super.zzb();
        new Handler().postDelayed(new zzfwb(this), Math.max(4000 - (this.zzb == null ? 4000L : TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zzk(zzfuo zzfuoVar, zzfum zzfumVar) {
        JSONObject jSONObject = new JSONObject();
        Map mapZze = zzfumVar.zze();
        Iterator it = mapZze.keySet().iterator();
        if (it.hasNext()) {
            throw null;
        }
        zzl(zzfuoVar, zzfumVar, jSONObject);
    }

    final /* synthetic */ WebView zzq() {
        return this.zza;
    }
}
