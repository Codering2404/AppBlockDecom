package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import coil.target.Yb.oUcQRqOVfOC;
import com.applovin.impl.aq;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.nativeAd.a;
import com.applovin.impl.sdk.network.e;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.impl.zm;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class b extends yl implements a.InterfaceC0124a, AppLovinAdLoadListener {
    private final List A;
    private final List B;
    private final List C;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JSONObject f63449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final JSONObject f63450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AppLovinNativeAdLoadListener f63451j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f63452k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f63453l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f63454m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Double f63455n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f63456o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Uri f63457p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Uri f63458q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private aq f63459r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Uri f63460s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Uri f63461t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Uri f63462u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Uri f63463v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final List f63464w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final List f63465x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final List f63466y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final List f63467z;

    public b(JSONObject jSONObject, JSONObject jSONObject2, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskRenderNativeAd", jVar);
        this.f63452k = "";
        this.f63453l = "";
        this.f63454m = "";
        this.f63455n = null;
        this.f63456o = "";
        this.f63457p = null;
        this.f63458q = null;
        this.f63460s = null;
        this.f63461t = null;
        this.f63462u = null;
        this.f63463v = null;
        this.f63464w = new ArrayList();
        this.f63465x = new ArrayList();
        this.f63466y = new ArrayList();
        this.f63467z = new ArrayList();
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.C = new ArrayList();
        this.f63449h = jSONObject;
        this.f63450i = jSONObject2;
        this.f63451j = appLovinNativeAdLoadListener;
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String string = JsonUtils.getString(jSONObject, "url", null);
        if (StringUtils.isValidString(string)) {
            this.f63462u = Uri.parse(string);
            if (n.a()) {
                this.f65233c.a(this.f65232b, "Processed click destination URL: " + this.f63462u);
            }
        }
        String string2 = JsonUtils.getString(jSONObject, "fallback", null);
        if (StringUtils.isValidString(string2)) {
            this.f63463v = Uri.parse(string2);
            if (n.a()) {
                this.f65233c.a(this.f65232b, "Processed click destination backup URL: " + this.f63463v);
            }
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "clicktrackers", null);
        if (jSONArray != null) {
            if (!JsonUtils.getBoolean(this.f63449h, "use_requests_for_native_ad_click_postbacks", (Boolean) this.f65231a.a(sj.R2)).booleanValue()) {
                try {
                    this.f63464w.addAll(JsonUtils.toList(jSONArray));
                    if (n.a()) {
                        this.f65233c.a(this.f65232b, "Processed click tracking URLs: " + this.f63464w);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (n.a()) {
                        this.f65233c.a(this.f65232b, "Failed to render click tracking URLs", th);
                        return;
                    }
                    return;
                }
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray, i3, null);
                if (objectAtIndex instanceof String) {
                    String str = (String) objectAtIndex;
                    if (!TextUtils.isEmpty(str)) {
                        this.f63466y.add(new e.a(this.f65231a).b(str).b(false).a(false).h(f()).a());
                    }
                }
            }
            if (n.a()) {
                this.f65233c.a(this.f65232b, "Processed click tracking requests: " + this.f63466y);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        if (n.a()) {
            this.f65233c.a(this.f65232b, "Preparing native ad view components...");
        }
        try {
            appLovinNativeAdImpl.setUpNativeAdViewComponents();
            if (n.a()) {
                this.f65233c.a(this.f65232b, "Successfully prepared native ad view components");
            }
            appLovinNativeAdImpl.getAdEventTracker().h();
            this.f63451j.onNativeAdLoaded(appLovinNativeAdImpl);
        } catch (Throwable th) {
            if (n.a()) {
                this.f65233c.a(this.f65232b, "Failed to prepare native ad view components", th);
            }
            b(th.getMessage());
            this.f65231a.D().a(this.f65232b, "prepareNativeComponents", th);
        }
    }

    private void c(final AppLovinNativeAdImpl appLovinNativeAdImpl) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.nativeAd.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f63474a.b(appLovinNativeAdImpl);
            }
        });
    }

    private boolean f() {
        return JsonUtils.getBoolean(this.f63449h, "fire_native_ad_postbacks_from_webview", (Boolean) this.f65231a.a(sj.Q2)).booleanValue();
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        if (n.a()) {
            this.f65233c.a(this.f65232b, "VAST ad rendered successfully");
        }
        this.f63459r = (aq) appLovinAd;
        e();
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i3) {
        if (n.a()) {
            this.f65233c.b(this.f65232b, "VAST ad failed to render");
        }
        e();
    }

    private void e() {
        AppLovinNativeAdImpl appLovinNativeAdImplBuild = new AppLovinNativeAdImpl.Builder(JsonUtils.shallowCopy(this.f63449h), JsonUtils.shallowCopy(this.f63450i), this.f65231a).setTitle(this.f63452k).setAdvertiser(this.f63453l).setBody(this.f63454m).setCallToAction(this.f63456o).setStarRating(this.f63455n).setIconUri(this.f63457p).setMainImageUri(this.f63458q).setPrivacyIconUri(this.f63460s).setVastAd(this.f63459r).setPrivacyDestinationUri(this.f63461t).setClickDestinationUri(this.f63462u).setClickDestinationBackupUri(this.f63463v).setClickTrackingUrls(this.f63464w).setJsTrackers(this.f63465x).setClickTrackingRequests(this.f63466y).setImpressionRequests(this.f63467z).setViewableMRC50Requests(this.A).setViewableMRC100Requests(this.B).setViewableVideo50Requests(this.C).build();
        appLovinNativeAdImplBuild.getAdEventTracker().e();
        if (n.a()) {
            this.f65233c.a(this.f65232b, "Starting cache task for type: " + appLovinNativeAdImplBuild.getType() + "...");
        }
        this.f65231a.i0().a((yl) new a(appLovinNativeAdImplBuild, this.f65231a, this), tm.b.CORE);
    }

    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v60 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.String, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v8 */
    @Override // java.lang.Runnable
    public void run() {
        ?? r3 = 0;
        String string = JsonUtils.getString(this.f63449h, "privacy_icon_url", null);
        if (URLUtil.isValidUrl(string)) {
            this.f63460s = Uri.parse(string);
        }
        String string2 = JsonUtils.getString(this.f63449h, "privacy_url", null);
        if (URLUtil.isValidUrl(string2)) {
            this.f63461t = Uri.parse(string2);
        }
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f63449h, "ortb_response", (JSONObject) null);
        if (jSONObject == null || jSONObject.length() == 0) {
            if (n.a()) {
                this.f65233c.b(this.f65232b, "No oRtb response provided: " + this.f63449h);
            }
            b("No oRtb response provided");
            return;
        }
        String string3 = JsonUtils.getString(jSONObject, "version", null);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "value", (JSONObject) null);
        if (n.a()) {
            this.f65233c.a(this.f65232b, YznnJpHcAmeoW.PazaEZU + string3);
        }
        JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONObject2, AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, jSONObject2);
        a(JsonUtils.getJSONObject(jSONObject3, "link", (JSONObject) null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject3, "assets", null);
        if (jSONArray == null || jSONArray.length() == 0) {
            if (n.a()) {
                this.f65233c.b(this.f65232b, "Unable to retrieve assets - failing ad load: " + this.f63449h);
            }
            b("Unable to retrieve assets");
            return;
        }
        String str = "";
        int i3 = 0;
        while (i3 < jSONArray.length()) {
            JSONObject jSONObject4 = JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) r3);
            if (jSONObject4.has("title")) {
                this.f63452k = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, "title", (JSONObject) r3), "text", r3);
                if (n.a()) {
                    this.f65233c.a(this.f65232b, "Processed title: " + this.f63452k);
                }
            } else if (jSONObject4.has("link")) {
                a(JsonUtils.getJSONObject(jSONObject4, "link", (JSONObject) r3));
            } else if (jSONObject4.has("img")) {
                int i4 = JsonUtils.getInt(jSONObject4, "id", -1);
                JSONObject jSONObject5 = JsonUtils.getJSONObject(jSONObject4, "img", (JSONObject) r3);
                int i5 = JsonUtils.getInt(jSONObject5, "type", -1);
                String string4 = JsonUtils.getString(jSONObject5, "url", r3);
                if (i5 == 1 || 3 == i4) {
                    this.f63457p = Uri.parse(string4);
                    if (n.a()) {
                        this.f65233c.a(this.f65232b, "Processed icon URL: " + this.f63457p);
                    }
                } else if (i5 == 3 || 2 == i4) {
                    this.f63458q = Uri.parse(string4);
                    if (n.a()) {
                        this.f65233c.a(this.f65232b, "Processed main image URL: " + this.f63458q);
                    }
                } else {
                    if (n.a()) {
                        this.f65233c.k(this.f65232b, "Unrecognized image: " + jSONObject4);
                    }
                    int i6 = JsonUtils.getInt(jSONObject5, "w", -1);
                    int i7 = JsonUtils.getInt(jSONObject5, "h", -1);
                    if (i6 <= 0 || i7 <= 0) {
                        if (n.a()) {
                            this.f65233c.k(this.f65232b, "Skipping...");
                        }
                    } else if (i6 / i7 > 1.0d) {
                        if (n.a()) {
                            this.f65233c.a(this.f65232b, "Inferring main image from " + i6 + "x" + i7 + "...");
                        }
                        this.f63458q = Uri.parse(string4);
                    } else {
                        if (n.a()) {
                            this.f65233c.a(this.f65232b, "Inferring icon image from " + i6 + "x" + i7 + "...");
                        }
                        this.f63457p = Uri.parse(string4);
                    }
                }
            } else if (jSONObject4.has(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO)) {
                String string5 = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject4, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, (JSONObject) null), "vasttag", null);
                if (StringUtils.isValidString(string5)) {
                    if (n.a()) {
                        this.f65233c.a(this.f65232b, oUcQRqOVfOC.BJSdK);
                    }
                } else if (n.a()) {
                    this.f65233c.k(this.f65232b, "Ignoring invalid \"vasttag\" for video: " + jSONObject4);
                }
                str = string5;
            } else if (jSONObject4.has("data")) {
                int i8 = JsonUtils.getInt(jSONObject4, "id", -1);
                JSONObject jSONObject6 = JsonUtils.getJSONObject(jSONObject4, "data", (JSONObject) null);
                int i9 = JsonUtils.getInt(jSONObject6, "type", -1);
                String string6 = JsonUtils.getString(jSONObject6, "value", null);
                if (i9 == 1 || i8 == 8) {
                    this.f63453l = string6;
                    if (n.a()) {
                        this.f65233c.a(this.f65232b, "Processed advertiser: " + this.f63453l);
                    }
                } else if (i9 == 2 || i8 == 4) {
                    this.f63454m = string6;
                    if (n.a()) {
                        this.f65233c.a(this.f65232b, "Processed body: " + this.f63454m);
                    }
                } else if (i9 == 12 || i8 == 5) {
                    this.f63456o = string6;
                    if (n.a()) {
                        this.f65233c.a(this.f65232b, "Processed cta: " + this.f63456o);
                    }
                } else if (i9 == 3 || i8 == 6) {
                    double dA = yp.a(string6, -1.0d);
                    if (dA != -1.0d) {
                        this.f63455n = Double.valueOf(dA);
                        if (n.a()) {
                            this.f65233c.a(this.f65232b, "Processed star rating: " + this.f63455n);
                        }
                    } else if (n.a()) {
                        this.f65233c.a(this.f65232b, "Received invalid star rating: " + string6);
                    }
                } else if (n.a()) {
                    this.f65233c.k(this.f65232b, "Skipping unsupported data: " + jSONObject4);
                }
            } else if (n.a()) {
                this.f65233c.b(this.f65232b, "Unsupported asset object: " + jSONObject4);
            }
            i3++;
            r3 = 0;
        }
        String string7 = JsonUtils.getString(jSONObject3, "jstracker", null);
        if (StringUtils.isValidString(string7)) {
            this.f63465x.add(string7);
            if (n.a()) {
                this.f65233c.a(this.f65232b, "Processed jstracker: " + string7);
            }
        }
        Object obj = null;
        JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject3, "imptrackers", null);
        if (jSONArray2 != null) {
            int i10 = 0;
            while (i10 < jSONArray2.length()) {
                Object objectAtIndex = JsonUtils.getObjectAtIndex(jSONArray2, i10, obj);
                if (objectAtIndex instanceof String) {
                    String str2 = (String) objectAtIndex;
                    if (!TextUtils.isEmpty(str2)) {
                        this.f63467z.add(new e.a(this.f65231a).b(str2).b(false).a(false).h(f()).a());
                        if (n.a()) {
                            this.f65233c.a(this.f65232b, "Processed imptracker URL: " + str2);
                        }
                    }
                }
                i10++;
                obj = null;
            }
        }
        ?? r6 = 0;
        JSONArray jSONArray3 = JsonUtils.getJSONArray(jSONObject3, "eventtrackers", null);
        if (jSONArray3 != null) {
            int i11 = 0;
            while (i11 < jSONArray3.length()) {
                JSONObject jSONObject7 = JsonUtils.getJSONObject(jSONArray3, i11, (JSONObject) r6);
                int i12 = JsonUtils.getInt(jSONObject7, "event", -1);
                int i13 = JsonUtils.getInt(jSONObject7, pMpIcGE.pnQb, -1);
                String string8 = JsonUtils.getString(jSONObject7, "url", r6);
                if (!TextUtils.isEmpty(string8)) {
                    if (i13 == 1 || i13 == 2) {
                        if (i13 == 2 && string8.startsWith("<script")) {
                            this.f63465x.add(string8);
                        } else {
                            com.applovin.impl.sdk.network.e eVarA = new e.a(this.f65231a).b(string8).b(false).a(false).h(f() || i13 == 2).a();
                            if (i12 == 1) {
                                this.f63467z.add(eVarA);
                                if (n.a()) {
                                    this.f65233c.a(this.f65232b, "Processed impression URL: " + string8);
                                }
                            } else if (i12 == 2) {
                                this.A.add(eVarA);
                                if (n.a()) {
                                    this.f65233c.a(this.f65232b, "Processed viewable MRC50 URL: " + string8);
                                }
                            } else if (i12 == 3) {
                                this.B.add(eVarA);
                                if (n.a()) {
                                    this.f65233c.a(this.f65232b, "Processed viewable MRC100 URL: " + string8);
                                }
                            } else if (i12 == 4) {
                                this.C.add(eVarA);
                                if (n.a()) {
                                    this.f65233c.a(this.f65232b, "Processed viewable video 50 URL: " + string8);
                                }
                            } else if (i12 == 555) {
                                if (n.a()) {
                                    this.f65233c.a(this.f65232b, "Ignoring processing of OMID URL: " + string8);
                                }
                            } else if (n.a()) {
                                this.f65233c.b(this.f65232b, "Unsupported event tracker: " + jSONObject7);
                            }
                        }
                    } else if (n.a()) {
                        this.f65233c.b(this.f65232b, "Unsupported method for event tracker: " + jSONObject7);
                    }
                }
                i11++;
                r6 = 0;
            }
        }
        if (!StringUtils.isValidString(str)) {
            e();
            return;
        }
        if (n.a()) {
            this.f65233c.a(this.f65232b, "Processing VAST video...");
        }
        this.f65231a.i0().a(zm.a(str, JsonUtils.shallowCopy(this.f63449h), JsonUtils.shallowCopy(this.f63450i), this, this.f65231a));
    }

    private void b(String str) {
        this.f63451j.onNativeAdLoadFailed(new AppLovinError(-6, str));
    }

    @Override // com.applovin.impl.sdk.nativeAd.a.InterfaceC0124a
    public void a(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        if (n.a()) {
            this.f65233c.a(this.f65232b, "Successfully cached and loaded ad");
        }
        c(appLovinNativeAdImpl);
    }
}
