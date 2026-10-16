package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.github.appintro.AppIntroBaseFragmentKt;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class tp {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f63987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.adview.a f63988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f63989c;

        a(String str, com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.j jVar) {
            this.f63987a = str;
            this.f63988b = aVar;
            this.f63989c = jVar;
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof AppLovinWebViewActivity) {
                ((AppLovinWebViewActivity) activity).loadUrl(this.f63987a, null);
                fc.c(this.f63988b.e(), this.f63988b.i(), this.f63988b.k());
            }
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof AppLovinWebViewActivity) {
                fc.a(this.f63988b.e(), this.f63988b.i(), this.f63988b.k());
                this.f63989c.e().b(this);
            }
        }
    }

    public static void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar) {
        String queryParameter = uri.getQueryParameter("n");
        if (URLUtil.isValidUrl(queryParameter)) {
            jVar.W().e(com.applovin.impl.sdk.network.d.b().d(StringUtils.appendQueryParameter(queryParameter, "clcode", bVar.getClCode())).a(false).b(Boolean.parseBoolean(uri.getQueryParameter("fire_from_webview"))).a());
            return;
        }
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().b("UriUtils", "Could not find postback url to fire from query in original uri: " + uri);
        }
    }

    public static boolean b(Uri uri) {
        return uri != null && "applovin".equalsIgnoreCase(uri.getScheme()) && AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN.equalsIgnoreCase(uri.getHost()) && "/adservice/deeplink".equals(uri.getPath());
    }

    public static void b(Uri uri, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar) {
        String strEmptyIfNull = StringUtils.emptyIfNull(uri.getQueryParameter("error"));
        String strEmptyIfNull2 = StringUtils.emptyIfNull(uri.getQueryParameter("exception"));
        String strEmptyIfNull3 = StringUtils.emptyIfNull(uri.getQueryParameter("details"));
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("source", strEmptyIfNull);
        CollectionUtils.putStringIfValid("top_main_method", strEmptyIfNull2, mapHashMap);
        CollectionUtils.putStringIfValid("details", strEmptyIfNull3, mapHashMap);
        if (bVar != null) {
            mapHashMap.putAll(la.a(bVar, true, jVar));
        }
        jVar.D().a(ka.f60947b0, (Map) mapHashMap);
    }

    public static Bundle a(Uri uri) {
        Bundle bundle = new Bundle();
        for (String str : uri.getQueryParameterNames()) {
            bundle.putString(str, uri.getQueryParameter(str));
        }
        return bundle;
    }

    public static Boolean a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            boolean z2 = true;
            packageManager.getPackageInfo("com.android.vending", 1);
            int applicationEnabledSetting = packageManager.getApplicationEnabledSetting("com.android.vending");
            if (applicationEnabledSetting != 2 && applicationEnabledSetting != 3) {
                z2 = false;
            }
            return Boolean.valueOf(z2);
        } catch (PackageManager.NameNotFoundException unused) {
            return Boolean.TRUE;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void a(Uri uri, com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.j jVar) {
        com.applovin.impl.adview.b bVarG = aVar.g();
        String queryParameter = uri.getQueryParameter("n");
        boolean zIsEmpty = TextUtils.isEmpty(queryParameter);
        String str = YgVrd.nYEbdaiWYHzk;
        if (zIsEmpty) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().b(str, "Could not find url to load from query in original uri");
                return;
            }
            return;
        }
        String queryParameter2 = uri.getQueryParameter("load_type");
        if ("external".equalsIgnoreCase(queryParameter2)) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a(str, "Loading new page externally: " + queryParameter);
            }
            a(queryParameter, aVar, jVar);
            return;
        }
        if ("internal".equalsIgnoreCase(queryParameter2)) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a(str, "Loading new page in WebView: " + queryParameter);
            }
            bVarG.loadUrl(queryParameter);
            String queryParameter3 = uri.getQueryParameter(AppIntroBaseFragmentKt.ARG_BG_COLOR);
            if (StringUtils.isValidString(queryParameter3)) {
                bVarG.setBackgroundColor(Color.parseColor(queryParameter3));
                return;
            }
            return;
        }
        if ("in_app".equalsIgnoreCase(queryParameter2)) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a(str, "Loading new page in slide-up webview: " + queryParameter);
            }
            jVar.e().a(new a(queryParameter, aVar, jVar));
            Intent intent = new Intent(com.applovin.impl.sdk.j.m(), (Class<?>) AppLovinWebViewActivity.class);
            intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, jVar.a0());
            intent.setFlags(268435456);
            com.applovin.impl.sdk.j.m().startActivity(intent);
            return;
        }
        if ("in_app_v2".equalsIgnoreCase(queryParameter2)) {
            aVar.a(aVar.i(), aVar.k(), (Uri) null, bVarG.getAndClearLastClickEvent(), (Bundle) null);
            if (aVar.j() != null) {
                jVar.I();
                if (com.applovin.impl.sdk.n.a()) {
                    jVar.I().a(str, "Loading new page in Custom Tabs: " + queryParameter);
                }
                jVar.w().a(queryParameter, aVar, jVar.m0());
                return;
            }
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a(str, "Custom Tabs not supported, loading new page externally: " + queryParameter);
            }
            a(queryParameter, aVar, jVar);
            return;
        }
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().b(str, "Could not find load type in original uri");
        }
    }

    public static boolean a(Uri uri, Context context, com.applovin.impl.sdk.j jVar) {
        boolean z2 = false;
        if (uri == null) {
            return false;
        }
        try {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().d("UriUtils", "Opening URI: " + uri);
            }
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            if ("market".equals(intent.getScheme()) || "play.google.com".equals(uri.getHost())) {
                Boolean boolA = a(context);
                if (((Boolean) jVar.a(sj.k6)).booleanValue() && (boolA == null || boolA.booleanValue())) {
                    intent.setPackage(null);
                } else {
                    intent.setPackage("com.android.vending");
                }
            }
            jVar.e0().pauseForClick();
            context.startActivity(intent);
            z2 = true;
        } catch (Throwable th) {
            jVar.I();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.I().a("UriUtils", "Unable to open \"" + uri + "\".", th);
            }
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("url", uri.toString());
            if ("play.google.com".equals(uri.getHost())) {
                CollectionUtils.putStringIfValid("details", (String) jVar.x().H().get("ps_version"), mapHashMap);
            }
            jVar.D().a("UriUtils", "openUri", th, mapHashMap);
        }
        if (!z2) {
            jVar.e0().resumeForClick();
        }
        return z2;
    }

    private static void a(String str, com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.j jVar) {
        a(Uri.parse(str), aVar.g().getContext(), jVar);
        fc.b(aVar.e(), aVar.i(), aVar.k());
    }
}
