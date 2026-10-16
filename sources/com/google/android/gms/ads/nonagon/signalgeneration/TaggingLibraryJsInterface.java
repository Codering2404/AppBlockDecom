package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbap;
import com.google.android.gms.internal.ads.zzbaq;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzdzq;
import com.google.android.gms.internal.ads.zzflc;
import com.google.android.gms.internal.ads.zzfsc;
import com.google.android.gms.internal.ads.zzhcg;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class TaggingLibraryJsInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f70607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WebView f70608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbap f70609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzflc f70610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f70611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdzq f70612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f70613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzhcg f70614h = zzcfr.zzf;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzfsc f70615i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzj f70616j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zza f70617k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final zze f70618l;

    TaggingLibraryJsInterface(WebView webView, zzbap zzbapVar, zzdzq zzdzqVar, zzfsc zzfscVar, zzflc zzflcVar, zzj zzjVar, zza zzaVar, zze zzeVar) {
        this.f70608b = webView;
        Context context = webView.getContext();
        this.f70607a = context;
        this.f70609c = zzbapVar;
        this.f70612f = zzdzqVar;
        zzbiq.zza(context);
        this.f70611e = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkY)).intValue();
        this.f70613g = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzkZ)).booleanValue();
        this.f70615i = zzfscVar;
        this.f70610d = zzflcVar;
        this.f70616j = zzjVar;
        this.f70617k = zzaVar;
        this.f70618l = zzeVar;
    }

    final /* synthetic */ void a(Bundle bundle, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        com.google.android.gms.ads.internal.util.zzz zzzVarJ = com.google.android.gms.ads.internal.zzt.j();
        Context context = this.f70607a;
        CookieManager cookieManagerA = zzzVarJ.a(context);
        bundle.putBoolean("accept_3p_cookie", cookieManagerA != null ? cookieManagerA.acceptThirdPartyCookies(this.f70608b) : false);
        QueryInfo.a(context, AdFormat.BANNER, ((AdRequest.Builder) new AdRequest.Builder().c(AdMobAdapter.class, bundle)).m(), queryInfoGenerationCallback);
    }

    final /* synthetic */ void b(String str) {
        zzflc zzflcVar;
        Uri uriZzd = Uri.parse(str);
        try {
            uriZzd = (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznw)).booleanValue() || (zzflcVar = this.f70610d) == null) ? this.f70609c.zzd(uriZzd, this.f70607a, this.f70608b, null) : zzflcVar.zza(uriZzd, this.f70607a, this.f70608b, null);
        } catch (zzbaq e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.b("Failed to append the click signal to URL: ", e3);
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "TaggingLibraryJsInterface.recordClick");
        }
        this.f70615i.zzb(uriZzd.toString(), null, null, null);
    }

    final /* synthetic */ WebView c() {
        return this.f70608b;
    }

    final /* synthetic */ zzhcg d() {
        return this.f70614h;
    }

    final /* synthetic */ zza e() {
        return this.f70617k;
    }

    final /* synthetic */ zze f() {
        return this.f70618l;
    }

    @JavascriptInterface
    public String getClickSignals(String str) {
        try {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
            String strZzg = this.f70609c.zzb().zzg(this.f70607a, str, this.f70608b);
            if (!this.f70613g) {
                return strZzg;
            }
            zzv.e(this.f70612f, null, "csg", new Pair("clat", String.valueOf(com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() - jCurrentTimeMillis)));
            return strZzg;
        } catch (RuntimeException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Exception getting click signals. ", e3);
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JavascriptInterface
    public String getClickSignalsWithTimeout(final String str, int i3) {
        if (i3 <= 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 51);
            sb.append("Invalid timeout for getting click signals. Timeout=");
            sb.append(i3);
            String string = sb.toString();
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c(string);
            return "";
        }
        try {
            return (String) zzcfr.zza.submit(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbh
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.f70719a.getClickSignals(str);
                }
            }).get(Math.min(i3, this.f70611e), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e3) {
            int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Exception getting click signals with timeout. ", e3);
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "TaggingLibraryJsInterface.getClickSignalsWithTimeout");
            return e3 instanceof TimeoutException ? "17" : "";
        }
    }

    @JavascriptInterface
    public String getQueryInfo() {
        com.google.android.gms.ads.internal.zzt.g();
        String string = UUID.randomUUID().toString();
        final Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        final zzbf zzbfVar = new zzbf(this, string);
        if (((Boolean) zzbkv.zze.zze()).booleanValue()) {
            this.f70616j.b(this.f70608b, zzbfVar);
            return string;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlb)).booleanValue()) {
            this.f70614h.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbj
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f70723a.a(bundle, zzbfVar);
                }
            });
            return string;
        }
        QueryInfo.a(this.f70607a, AdFormat.BANNER, ((AdRequest.Builder) new AdRequest.Builder().c(AdMobAdapter.class, bundle)).m(), zzbfVar);
        return string;
    }

    @JavascriptInterface
    public String getViewSignals() {
        try {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
            String strZzj = this.f70609c.zzb().zzj(this.f70607a, this.f70608b, null);
            if (!this.f70613g) {
                return strZzj;
            }
            zzv.e(this.f70612f, null, "vsg", new Pair("vlat", String.valueOf(com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() - jCurrentTimeMillis)));
            return strZzj;
        } catch (RuntimeException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Exception getting view signals. ", e3);
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JavascriptInterface
    public String getViewSignalsWithTimeout(int i3) {
        if (i3 <= 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 50);
            sb.append("Invalid timeout for getting view signals. Timeout=");
            sb.append(i3);
            String string = sb.toString();
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.c(string);
            return "";
        }
        try {
            return (String) zzcfr.zza.submit(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbg
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.f70718a.getViewSignals();
                }
            }).get(Math.min(i3, this.f70611e), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e3) {
            int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Exception getting view signals with timeout. ", e3);
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "TaggingLibraryJsInterface.getViewSignalsWithTimeout");
            return e3 instanceof TimeoutException ? "17" : "";
        }
    }

    @JavascriptInterface
    public void recordClick(final String str) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzld)).booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbi
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f70721a.b(str);
            }
        });
    }

    @JavascriptInterface
    public void reportTouchEvent(String str) {
        int i3;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i4 = jSONObject.getInt("x");
            int i5 = jSONObject.getInt("y");
            int i6 = jSONObject.getInt("duration_ms");
            float f3 = (float) jSONObject.getDouble("force");
            int i7 = jSONObject.getInt("type");
            if (i7 != 0) {
                i3 = 1;
                if (i7 != 1) {
                    i3 = 2;
                    if (i7 != 2) {
                        i3 = 3;
                        if (i7 != 3) {
                            i3 = -1;
                        }
                    }
                }
            } else {
                i3 = 0;
            }
            try {
                this.f70609c.zzc(MotionEvent.obtain(0L, i6, i3, i4, i5, f3, 1.0f, 0, 1.0f, 1.0f, 0, 0));
            } catch (RuntimeException e3) {
                e = e3;
                int i8 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Failed to parse the touch string. ", e);
                com.google.android.gms.ads.internal.zzt.l().zzg(e, "TaggingLibraryJsInterface.reportTouchEvent");
            } catch (JSONException e4) {
                e = e4;
                int i82 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Failed to parse the touch string. ", e);
                com.google.android.gms.ads.internal.zzt.l().zzg(e, "TaggingLibraryJsInterface.reportTouchEvent");
            }
        } catch (RuntimeException | JSONException e5) {
            e = e5;
        }
    }
}
