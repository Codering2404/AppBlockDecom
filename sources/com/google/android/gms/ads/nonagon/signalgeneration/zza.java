package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Base64;
import android.webkit.WebView;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbia;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzgww;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zza {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f70619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ApplicationInfo f70620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f70621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VersionInfoParcel f70622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final JSONObject f70623e = new JSONObject();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f70624f = new AtomicBoolean(false);

    zza(Context context, zzbia zzbiaVar, List list, VersionInfoParcel versionInfoParcel) {
        this.f70619a = context;
        this.f70620b = context.getApplicationInfo();
        this.f70621c = list;
        this.f70622d = versionInfoParcel;
    }

    public final JSONObject b() {
        if (!this.f70624f.get()) {
            a(null);
        }
        return this.f70623e;
    }

    public final void a(WebView webView) {
        if (this.f70624f.getAndSet(true)) {
            return;
        }
        PackageInfo packageInfoF = null;
        try {
            ApplicationInfo applicationInfo = this.f70620b;
            if (applicationInfo != null) {
                packageInfoF = Wrappers.a(this.f70619a).f(applicationInfo.packageName, 0);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfoF != null) {
            try {
                JSONObject jSONObject = this.f70623e;
                jSONObject.put("vc", packageInfoF.versionCode);
                jSONObject.put("vnm", packageInfoF.versionName);
            } catch (JSONException e3) {
                com.google.android.gms.ads.internal.zzt.l().zzg(e3, "PawAppSignalGenerator.initialize");
            }
        }
        ApplicationInfo applicationInfo2 = this.f70620b;
        if (applicationInfo2 != null) {
            this.f70623e.put("pn", applicationInfo2.packageName);
        }
        JSONObject jSONObject2 = this.f70623e;
        String str = QaXmqxvjHhxVy.IJuFKO;
        List list = this.f70621c;
        ArrayList arrayList = new ArrayList();
        for (String str2 : ((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlj)).split(",", -1)) {
            if (list.contains(str2)) {
                arrayList.add(str2);
            }
        }
        jSONObject2.put(str, arrayList);
        jSONObject2.put("js", this.f70622d.f70149a);
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject2.get(next);
            if (obj != null) {
                jSONObject2.put(next, Base64.encodeToString(obj.toString().getBytes(), 2));
            }
        }
        if (((Boolean) zzbkv.zzb.zze()).booleanValue() && WebViewFeature.a("DOCUMENT_START_SCRIPT") && webView != null) {
            WebViewCompat.a(webView, String.format(Locale.getDefault(), (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzli), b()), zzgww.zzi("*"));
        }
    }
}
