package com.applovin.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.mediation.MaxAdFormat;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class v implements AppLovinCommunicatorSubscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f64357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f64358b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedHashMap f64359c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f64360d = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends LinkedHashMap {
        a() {
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry entry) {
            return size() > 16;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void onCreativeIdGenerated(String str, String str2);
    }

    public v(com.applovin.impl.sdk.j jVar) {
        this.f64357a = jVar;
        if (StringUtils.isValidString(b())) {
            AppLovinCommunicator.getInstance(com.applovin.impl.sdk.j.m()).subscribe(this, "safedk_ad_info");
        }
    }

    public void b(b bVar) {
        this.f64360d.remove(bVar);
    }

    public void c(String str) {
        this.f64357a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f64357a.I().a("AdReviewManager", "Removing ad info for serve id: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f64358b) {
            this.f64359c.remove(str);
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return v.class.getSimpleName();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("safedk_ad_info".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle bundle = appLovinCommunicatorMessage.getMessageData().getBundle("public");
            if (bundle == null) {
                this.f64357a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f64357a.I().k("AdReviewManager", "Received SafeDK ad info without public data");
                    return;
                }
                return;
            }
            Bundle bundle2 = appLovinCommunicatorMessage.getMessageData().getBundle("private");
            if (bundle2 == null) {
                this.f64357a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f64357a.I().k("AdReviewManager", "Received SafeDK ad info without private data");
                    return;
                }
                return;
            }
            if (MaxAdFormat.formatFromString(bundle2.getString("ad_format")) == null) {
                this.f64357a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f64357a.I().k("AdReviewManager", "Received SafeDK ad info without ad format");
                    return;
                }
                return;
            }
            final String string = bundle2.getString("id");
            if (TextUtils.isEmpty(string)) {
                this.f64357a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f64357a.I().k("AdReviewManager", "Received SafeDK ad info without serve id");
                    return;
                }
                return;
            }
            synchronized (this.f64358b) {
                try {
                    this.f64357a.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f64357a.I().a("AdReviewManager", "Storing current SafeDK ad info for serve id: " + string + ", public data: " + bundle);
                    }
                    this.f64359c.put(string, bundle);
                } catch (Throwable th) {
                    throw th;
                }
            }
            final String string2 = bundle.getString("ad_review_creative_id");
            this.f64357a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f64357a.I().a("AdReviewManager", "Received SafeDK ad info with Ad Review creative id: " + string2);
            }
            if (!StringUtils.isValidString(string2) || this.f64360d.isEmpty()) {
                return;
            }
            HashSet<b> hashSet = new HashSet(this.f64360d);
            this.f64357a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f64357a.I().a("AdReviewManager", "Notifying listeners: " + this.f64360d);
            }
            for (final b bVar : hashSet) {
                this.f64357a.i0().a((yl) new jn(this.f64357a, "creativeIdGenerated", new Runnable() { // from class: com.applovin.impl.v60
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64394a.a(bVar, string, string2);
                    }
                }), tm.b.OTHER);
            }
        }
    }

    public static String b() {
        return b("getVersion");
    }

    public Bundle a(String str) {
        Bundle bundle;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f64358b) {
            bundle = (Bundle) this.f64359c.get(str);
        }
        this.f64357a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f64357a.I().a("AdReviewManager", "Retrieved ad info (" + bundle + ") for serve id: " + str);
        }
        return bundle;
    }

    private static String b(String str) {
        Class<?> cls;
        try {
            try {
                cls = Class.forName("com.applovin.quality.AppLovinQualityService");
            } catch (Throwable unused) {
                cls = Class.forName("com.safedk.android.SafeDK");
            }
            return (String) cls.getMethod(str, null).invoke(null, null);
        } catch (Throwable unused2) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(b bVar, String str, String str2) {
        this.f64357a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f64357a.I().a("AdReviewManager", "Notifying Ad Review creative id generated for listener: " + bVar);
        }
        bVar.onCreativeIdGenerated(str, str2);
    }

    public void a(b bVar) {
        this.f64360d.add(bVar);
    }

    public static String a() {
        return b(tDEtWsFLJfe.NsmaeqpuQ);
    }
}
