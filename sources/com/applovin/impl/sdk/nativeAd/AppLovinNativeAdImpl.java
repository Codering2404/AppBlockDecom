package com.applovin.impl.sdk.nativeAd;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.arch.core.util.Function;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.aq;
import com.applovin.impl.br;
import com.applovin.impl.fc;
import com.applovin.impl.og;
import com.applovin.impl.qg;
import com.applovin.impl.s;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tl;
import com.applovin.impl.tp;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.impl.zq;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinNativeAdImpl extends AppLovinAdBase implements AppLovinNativeAd, View.OnClickListener, AppLovinTouchToClickListener.OnClickListener {
    private static final String AD_RESPONSE_TYPE_APPLOVIN = "applovin";
    private static final String AD_RESPONSE_TYPE_ORTB = "ortb";
    private static final String AD_RESPONSE_TYPE_UNDEFINED = "undefined";
    private static final String DEFAULT_APPLOVIN_PRIVACY_URL = "https://www.applovin.com/privacy/";
    private static final float MINIMUM_STARS_TO_RENDER = 3.0f;
    private static final String TAG = "AppLovinNativeAd";
    private static final int VIEWABLE_MRC100_PERCENTAGE = 100;
    private static final int VIEWABLE_MRC50_PERCENTAGE = 50;
    private static final int VIEWABLE_MRC_REQUIRED_SECONDS = 1;
    private static final int VIEWABLE_VIDEO_MRC_REQUIRED_SECONDS = 2;
    private final og adEventTracker;
    private final String advertiser;
    private final String body;
    private final String callToAction;
    private final Uri clickDestinationBackupUri;
    private final Uri clickDestinationUri;
    private final List<com.applovin.impl.sdk.network.e> clickTrackingRequests;
    private final List<String> clickTrackingUrls;
    private AppLovinNativeAdEventListener eventListener;
    private Uri iconUri;
    private final List<com.applovin.impl.sdk.network.e> impressionRequests;
    private final AtomicBoolean impressionTracked;
    private final List<String> jsTrackers;
    private float mainImageAspectRatio;
    private Uri mainImageUri;
    private AppLovinMediaView mediaView;
    private ViewGroup nativeAdView;
    private final b onAttachStateChangeHandler;
    private AppLovinOptionsView optionsView;
    private Uri privacyDestinationUri;
    private Uri privacyIconUri;
    private final List<View> registeredViews;
    private final Double starRating;
    private final String tag;
    private final String title;
    private final aq vastAd;
    private View videoView;
    private final c viewableMRC100Callback;
    private br viewableMRC100Tracker;
    private final c viewableMRC50Callback;
    private br viewableMRC50Tracker;
    private c viewableVideoMRC50Callback;
    private br viewableVideoMRC50Tracker;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
        private final JSONObject adObject;
        private String advertiser;
        private String body;
        private String callToAction;
        private Uri clickDestinationBackupUri;
        private Uri clickDestinationUri;
        private List<com.applovin.impl.sdk.network.e> clickTrackingRequests;
        private List<String> clickTrackingUrls;
        private final JSONObject fullResponse;
        private Uri iconUri;
        private List<com.applovin.impl.sdk.network.e> impressionRequests;
        private List<String> jsTrackers;
        private float mainImageAspectRatio;
        private Uri mainImageUri;
        private Uri privacyDestinationUri;
        private Uri privacyIconUri;
        private final com.applovin.impl.sdk.j sdk;
        private Double starRating;
        private String title;
        private aq vastAd;
        private List<com.applovin.impl.sdk.network.e> viewableMRC100Requests;
        private List<com.applovin.impl.sdk.network.e> viewableMRC50Requests;
        private List<com.applovin.impl.sdk.network.e> viewableVideo50Requests;

        public Builder(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
            this.adObject = jSONObject;
            this.fullResponse = jSONObject2;
            this.sdk = jVar;
        }

        public AppLovinNativeAdImpl build() {
            return new AppLovinNativeAdImpl(this, null);
        }

        public Builder setAdvertiser(String str) {
            this.advertiser = str;
            return this;
        }

        public Builder setBody(String str) {
            this.body = str;
            return this;
        }

        public Builder setCallToAction(String str) {
            this.callToAction = str;
            return this;
        }

        public Builder setClickDestinationBackupUri(Uri uri) {
            this.clickDestinationBackupUri = uri;
            return this;
        }

        public Builder setClickDestinationUri(Uri uri) {
            this.clickDestinationUri = uri;
            return this;
        }

        public Builder setClickTrackingRequests(List<com.applovin.impl.sdk.network.e> list) {
            this.clickTrackingRequests = list;
            return this;
        }

        public Builder setClickTrackingUrls(List<String> list) {
            this.clickTrackingUrls = list;
            return this;
        }

        public Builder setIconUri(Uri uri) {
            this.iconUri = uri;
            return this;
        }

        public Builder setImpressionRequests(List<com.applovin.impl.sdk.network.e> list) {
            this.impressionRequests = list;
            return this;
        }

        public Builder setJsTrackers(List<String> list) {
            this.jsTrackers = list;
            return this;
        }

        public Builder setMainImageUri(Uri uri) {
            this.mainImageUri = uri;
            return this;
        }

        public Builder setPrivacyDestinationUri(Uri uri) {
            this.privacyDestinationUri = uri;
            return this;
        }

        public Builder setPrivacyIconUri(Uri uri) {
            this.privacyIconUri = uri;
            return this;
        }

        public Builder setStarRating(Double d3) {
            this.starRating = d3;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setVastAd(aq aqVar) {
            this.vastAd = aqVar;
            return this;
        }

        public Builder setViewableMRC100Requests(List<com.applovin.impl.sdk.network.e> list) {
            this.viewableMRC100Requests = list;
            return this;
        }

        public Builder setViewableMRC50Requests(List<com.applovin.impl.sdk.network.e> list) {
            this.viewableMRC50Requests = list;
            return this;
        }

        public Builder setViewableVideo50Requests(List<com.applovin.impl.sdk.network.e> list) {
            this.viewableVideo50Requests = list;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppLovinNativeAdImpl f63436a;

        public b(AppLovinNativeAdImpl appLovinNativeAdImpl) {
            this.f63436a = appLovinNativeAdImpl;
        }

        protected boolean a(Object obj) {
            return obj instanceof b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!bVar.a(this)) {
                return false;
            }
            AppLovinNativeAdImpl appLovinNativeAdImplA = a();
            AppLovinNativeAdImpl appLovinNativeAdImplA2 = bVar.a();
            return appLovinNativeAdImplA != null ? appLovinNativeAdImplA.equals(appLovinNativeAdImplA2) : appLovinNativeAdImplA2 == null;
        }

        public int hashCode() {
            AppLovinNativeAdImpl appLovinNativeAdImplA = a();
            return (appLovinNativeAdImplA == null ? 43 : appLovinNativeAdImplA.hashCode()) + 59;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f63436a.maybeHandleOnAttachedToWindow(view);
        }

        public String toString() {
            return "AppLovinNativeAdImpl.OnAttachStateChangeHandler(ad=" + a() + ")";
        }

        public AppLovinNativeAdImpl a() {
            return this.f63436a;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class c implements br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f63437a;

        public c(List list) {
            this.f63437a = list;
        }

        protected boolean a(Object obj) {
            return obj instanceof c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!cVar.a(this)) {
                return false;
            }
            List listA = a();
            List listA2 = cVar.a();
            return listA != null ? listA.equals(listA2) : listA2 == null;
        }

        public int hashCode() {
            List listA = a();
            return (listA == null ? 43 : listA.hashCode()) + 59;
        }

        @Override // com.applovin.impl.br.a
        public void onLogVisibilityImpression() {
            Iterator it = this.f63437a.iterator();
            while (it.hasNext()) {
                ((AppLovinAdBase) AppLovinNativeAdImpl.this).sdk.X().dispatchPostbackRequest((com.applovin.impl.sdk.network.e) it.next(), null);
            }
        }

        public String toString() {
            return "AppLovinNativeAdImpl.VisibilityCallback(requests=" + a() + ")";
        }

        public List a() {
            return this.f63437a;
        }
    }

    /* synthetic */ AppLovinNativeAdImpl(Builder builder, a aVar) {
        this(builder);
    }

    public static /* synthetic */ List a(AppLovinNativeAdImpl appLovinNativeAdImpl, tl tlVar) {
        appLovinNativeAdImpl.getClass();
        return yp.a(tlVar.a("click_tracking_urls", new JSONObject()), appLovinNativeAdImpl.getClCode(), tlVar.a("click_tracking_url", (String) null), appLovinNativeAdImpl.sdk);
    }

    public static /* synthetic */ void b(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        for (View view : appLovinNativeAdImpl.registeredViews) {
            view.setOnTouchListener(null);
            view.setOnClickListener(null);
        }
        appLovinNativeAdImpl.sdk.I();
        if (n.a()) {
            appLovinNativeAdImpl.sdk.I().a(appLovinNativeAdImpl.tag, "Unregistered views: " + appLovinNativeAdImpl.registeredViews);
        }
        appLovinNativeAdImpl.registeredViews.clear();
        br brVar = appLovinNativeAdImpl.viewableMRC50Tracker;
        if (brVar != null) {
            brVar.b();
        }
        br brVar2 = appLovinNativeAdImpl.viewableMRC100Tracker;
        if (brVar2 != null) {
            brVar2.b();
        }
        br brVar3 = appLovinNativeAdImpl.viewableVideoMRC50Tracker;
        if (brVar3 != null) {
            brVar3.b();
        }
        ViewGroup viewGroup = appLovinNativeAdImpl.nativeAdView;
        if (viewGroup != null) {
            viewGroup.removeOnAttachStateChangeListener(appLovinNativeAdImpl.onAttachStateChangeHandler);
            appLovinNativeAdImpl.nativeAdView = null;
        }
        AppLovinMediaView appLovinMediaView = appLovinNativeAdImpl.mediaView;
        if (appLovinMediaView != null) {
            appLovinMediaView.destroy();
        }
        AppLovinOptionsView appLovinOptionsView = appLovinNativeAdImpl.optionsView;
        if (appLovinOptionsView != null) {
            appLovinOptionsView.destroy();
        }
    }

    public static /* synthetic */ List c(AppLovinNativeAdImpl appLovinNativeAdImpl, JSONArray jSONArray) {
        appLovinNativeAdImpl.getClass();
        if (jSONArray == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null);
            try {
                URL url = new URL(JsonUtils.getString(jSONObject, "url", null));
                String string = JsonUtils.getString(jSONObject, "vendor_key", null);
                String string2 = JsonUtils.getString(jSONObject, "parameters", null);
                if (StringUtils.isValidString(string) && StringUtils.isValidString(string2)) {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(string, url, string2));
                } else {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url));
                }
            } catch (Throwable th) {
                appLovinNativeAdImpl.sdk.I();
                if (n.a()) {
                    appLovinNativeAdImpl.sdk.I().a(appLovinNativeAdImpl.tag, "Failed to parse OMID verification script resource", th);
                }
            }
        }
        return arrayList;
    }

    private List<s> getDirectClickTrackingPostbacks() {
        List<s> listA;
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.nativeAd.c
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return AppLovinNativeAdImpl.a(this.f63468a, (tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            listA = yp.a(getJsonObjectFromAdObject("click_tracking_urls", new JSONObject()), getClCode(), getStringFromAdObject("click_tracking_url", null), this.sdk);
        }
        return listA;
    }

    private List<String> getPrivacySandboxClickAttributionUrls() {
        return getStringListFromAdObject("privacy_sandbox_click_attribution_urls", Collections.EMPTY_LIST);
    }

    private List<String> getPrivacySandboxImpressionAttributionUrls() {
        return getStringListFromAdObject("privacy_sandbox_impression_attribution_urls", Collections.EMPTY_LIST);
    }

    private boolean isDspAd() {
        return AD_RESPONSE_TYPE_ORTB.equalsIgnoreCase(getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchUri(Uri uri, Uri uri2, Context context) {
        if (tp.a(uri, context, this.sdk)) {
            this.sdk.I();
            if (n.a()) {
                this.sdk.I().a(this.tag, "Opening URL: " + uri);
                return;
            }
            return;
        }
        if (tp.a(uri2, context, this.sdk)) {
            this.sdk.I();
            if (n.a()) {
                this.sdk.I().a(this.tag, "Opening backup URL: " + uri2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeHandleOnAttachedToWindow(View view) {
        if (this.impressionTracked.compareAndSet(false, true)) {
            br brVar = new br(this.nativeAdView, this.sdk, this.viewableMRC50Callback);
            this.viewableMRC50Tracker = brVar;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            brVar.a(0, 50.0f, 50.0f, timeUnit.toMillis(1L), this.nativeAdView);
            br brVar2 = new br(this.nativeAdView, this.sdk, this.viewableMRC100Callback);
            this.viewableMRC100Tracker = brVar2;
            brVar2.a(0, 100.0f, 100.0f, timeUnit.toMillis(1L), this.nativeAdView);
            aq aqVar = this.vastAd;
            if (aqVar != null && aqVar.hasVideoUrl()) {
                br brVar3 = new br(this.nativeAdView, this.sdk, this.viewableVideoMRC50Callback);
                this.viewableVideoMRC50Tracker = brVar3;
                brVar3.a(0, 50.0f, 50.0f, timeUnit.toMillis(2L), this.videoView);
            }
            List<String> list = this.jsTrackers;
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    this.sdk.p0().b(it.next());
                }
            }
            Iterator<com.applovin.impl.sdk.network.e> it2 = this.impressionRequests.iterator();
            while (it2.hasNext()) {
                this.sdk.X().dispatchPostbackRequest(it2.next(), null);
            }
            this.adEventTracker.a(view);
            this.adEventTracker.g();
            if (this.sdk.Y() != null) {
                this.sdk.Y().b(getPrivacySandboxImpressionAttributionUrls());
            }
        }
    }

    public static /* synthetic */ List y(Function function, tl tlVar) {
        return (List) function.apply(tlVar.a("omid_verification_script_resources", (JSONArray) null));
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public void destroy() {
        unregisterViewsForInteraction();
        this.eventListener = null;
        this.adEventTracker.f();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getAdIdNumber() {
        return getLongFromAdObject("ad_id", -1L);
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public String getAdvertiser() {
        return this.advertiser;
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public String getBody() {
        return this.body;
    }

    public String getCachePrefix() {
        return getStringFromAdObject("cache_prefix", null);
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public String getCallToAction() {
        return this.callToAction;
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public Bundle getDirectDownloadParameters() {
        tl tlVar = this.synchronizedAdObject;
        return tlVar != null ? (Bundle) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.nativeAd.e
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return JsonUtils.toBundle(((tl) obj).a("ah_parameters", (JSONObject) null));
            }
        }) : JsonUtils.toBundle(getJsonObjectFromAdObject("ah_parameters", null));
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public String getDirectDownloadToken() {
        return getStringFromAdObject("ah_dd_token", null);
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public Uri getIconUri() {
        return this.iconUri;
    }

    public float getMainImageAspectRatio() {
        return this.mainImageAspectRatio;
    }

    public Uri getMainImageUri() {
        return this.mainImageUri;
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public AppLovinMediaView getMediaView() {
        return this.mediaView;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public String getOpenMeasurementContentUrl() {
        return getStringFromAdObject("omid_content_url", null);
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public String getOpenMeasurementCustomReferenceData() {
        return getStringFromAdObject("omid_custom_ref_data", "");
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources() {
        List<VerificationScriptResource> list;
        if (this.sdk.V().e()) {
            return Collections.singletonList(VerificationScriptResource.createVerificationScriptResourceWithParameters(qg.c(), qg.b(), qg.a()));
        }
        final Function function = new Function() { // from class: com.applovin.impl.sdk.nativeAd.f
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return AppLovinNativeAdImpl.c(this.f63470a, (JSONArray) obj);
            }
        };
        tl tlVar = this.synchronizedAdObject;
        if (tlVar != null) {
            return (List) tlVar.a(new Function() { // from class: com.applovin.impl.sdk.nativeAd.g
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return AppLovinNativeAdImpl.y(function, (tl) obj);
                }
            });
        }
        synchronized (this.adObjectLock) {
            list = (List) function.apply(getJsonArrayFromAdObject("omid_verification_script_resources", null));
        }
        return list;
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public AppLovinOptionsView getOptionsView() {
        return this.optionsView;
    }

    public Uri getPrivacyDestinationUri() {
        return this.privacyDestinationUri;
    }

    public Uri getPrivacyIconUri() {
        return this.privacyIconUri;
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public Double getStarRating() {
        return this.starRating;
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return getStringFromAdObject("type", AD_RESPONSE_TYPE_UNDEFINED);
    }

    public aq getVastAd() {
        return this.vastAd;
    }

    protected void handleNativeAdClick(Uri uri, Uri uri2, MotionEvent motionEvent, Context context) {
        if (this.sdk.Y() != null) {
            this.sdk.Y().b(getPrivacySandboxClickAttributionUrls(), motionEvent);
        }
        handleNativeAdClick(uri, uri2, context);
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public boolean isDirectDownloadEnabled() {
        return StringUtils.isValidString(getDirectDownloadToken());
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public boolean isOpenMeasurementEnabled() {
        if (this.sdk.V().e()) {
            return true;
        }
        return getBooleanFromAdObject("omsdk_enabled", Boolean.FALSE);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        this.sdk.I();
        if (n.a()) {
            this.sdk.I().a(this.tag, "Handle view clicked");
        }
        this.sdk.j().maybeSubmitPersistentPostbacks(getDirectClickTrackingPostbacks());
        if (!((Boolean) this.sdk.a(sj.B)).booleanValue() || (context = zq.a(this.nativeAdView, this.sdk)) == null) {
            context = view.getContext();
        }
        handleNativeAdClick(this.clickDestinationUri, this.clickDestinationBackupUri, context);
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public void registerViewsForInteraction(List<View> list, ViewGroup viewGroup) {
        this.nativeAdView = viewGroup;
        if (z3.e() && this.nativeAdView.isAttachedToWindow()) {
            maybeHandleOnAttachedToWindow(this.nativeAdView);
        } else if (z3.e() || this.nativeAdView.getParent() == null) {
            this.nativeAdView.addOnAttachStateChangeListener(this.onAttachStateChangeHandler);
        } else {
            maybeHandleOnAttachedToWindow(this.nativeAdView);
        }
        this.sdk.I();
        if (n.a()) {
            this.sdk.I().a(this.tag, "Registered ad view for impressions: " + this.nativeAdView);
        }
        if (this.clickDestinationUri == null && this.clickDestinationBackupUri == null) {
            this.sdk.I();
            if (n.a()) {
                this.sdk.I().a(this.tag, "Skipping click registration - no click URLs provided");
                return;
            }
            return;
        }
        for (View view : list) {
            if (view.hasOnClickListeners()) {
                this.sdk.I();
                if (n.a()) {
                    this.sdk.I().k(this.tag, "View has an onClickListener already - " + view);
                }
            }
            if (!view.isClickable()) {
                this.sdk.I();
                if (n.a()) {
                    this.sdk.I().k(this.tag, "View is not clickable - " + view);
                }
            }
            if (!view.isEnabled()) {
                this.sdk.I();
                if (n.a()) {
                    this.sdk.I().b(this.tag, "View is not enabled - " + view);
                }
            }
            if (view instanceof Button) {
                this.sdk.I();
                if (n.a()) {
                    this.sdk.I().a(this.tag, "Registering click for button: " + view);
                }
            } else {
                this.sdk.I();
                if (n.a()) {
                    this.sdk.I().a(this.tag, "Registering click for view: " + view);
                }
            }
            if (((Boolean) this.sdk.a(sj.I2)).booleanValue()) {
                view.setOnTouchListener(new AppLovinTouchToClickListener(this.sdk, sj.f63766m0, viewGroup.getContext(), this));
            } else {
                view.setOnClickListener(this);
            }
            this.registeredViews.add(view);
        }
        this.sdk.I();
        if (n.a()) {
            this.sdk.I().a(this.tag, "Registered views: " + this.registeredViews);
        }
    }

    public void setEventListener(AppLovinNativeAdEventListener appLovinNativeAdEventListener) {
        this.eventListener = appLovinNativeAdEventListener;
    }

    public void setIconUri(Uri uri) {
        this.iconUri = uri;
    }

    public void setMainImageAspectRatio(float f3) {
        this.mainImageAspectRatio = f3;
    }

    public void setMainImageUri(Uri uri) {
        this.mainImageUri = uri;
    }

    public void setPrivacyIconUri(Uri uri) {
        this.privacyIconUri = uri;
    }

    public void setUpNativeAdViewComponents() {
        aq aqVar = this.vastAd;
        if (aqVar == null || !aqVar.hasVideoUrl()) {
            this.mediaView = new AppLovinMediaView(this, this.sdk, com.applovin.impl.sdk.j.m());
        } else {
            try {
                this.mediaView = new AppLovinVastMediaView(this, this.sdk, com.applovin.impl.sdk.j.m());
            } catch (Throwable th) {
                this.sdk.I();
                if (n.a()) {
                    this.sdk.I().d(this.tag, "Failed to create ExoPlayer VAST media view. Falling back to static image for media view.", th);
                }
                this.sdk.D().a(TAG, "createExoPlayerVASTMediaView", th);
                this.mediaView = new AppLovinMediaView(this, this.sdk, com.applovin.impl.sdk.j.m());
            }
        }
        if (this.privacyDestinationUri != null) {
            this.optionsView = new AppLovinOptionsView(this, this.sdk, com.applovin.impl.sdk.j.m());
            return;
        }
        this.sdk.I();
        if (n.a()) {
            this.sdk.I().a(this.tag, "Privacy icon will not render because no native ad privacy URL is provided.");
        }
    }

    public void setVideoView(View view) {
        this.videoView = view;
    }

    public String toString() {
        return "AppLovinNativeAd{adIdNumber=" + getAdIdNumber() + " - " + getTitle() + "}";
    }

    @Override // com.applovin.impl.sdk.nativeAd.AppLovinNativeAd
    public void unregisterViewsForInteraction() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.nativeAd.d
            @Override // java.lang.Runnable
            public final void run() {
                AppLovinNativeAdImpl.b(this.f63469a);
            }
        });
    }

    private AppLovinNativeAdImpl(Builder builder) {
        super(builder.adObject, builder.fullResponse, builder.sdk);
        this.impressionTracked = new AtomicBoolean();
        this.registeredViews = new ArrayList();
        this.onAttachStateChangeHandler = new b(this);
        this.adEventTracker = new og(this);
        this.title = builder.title;
        this.advertiser = builder.advertiser;
        this.body = builder.body;
        this.callToAction = builder.callToAction;
        this.iconUri = builder.iconUri;
        this.mainImageUri = builder.mainImageUri;
        this.mainImageAspectRatio = builder.mainImageAspectRatio;
        this.privacyIconUri = builder.privacyIconUri;
        aq aqVar = builder.vastAd;
        this.vastAd = aqVar;
        this.clickDestinationUri = builder.clickDestinationUri;
        this.clickDestinationBackupUri = builder.clickDestinationBackupUri;
        this.clickTrackingUrls = builder.clickTrackingUrls;
        this.jsTrackers = builder.jsTrackers;
        this.clickTrackingRequests = builder.clickTrackingRequests;
        this.impressionRequests = builder.impressionRequests;
        Double d3 = builder.starRating;
        this.starRating = (d3 == null || d3.doubleValue() < 3.0d) ? null : d3;
        if (builder.privacyDestinationUri != null) {
            this.privacyDestinationUri = builder.privacyDestinationUri;
        } else if (!isDspAd() || getSdk().k0().c()) {
            this.privacyDestinationUri = Uri.parse(DEFAULT_APPLOVIN_PRIVACY_URL);
        }
        this.viewableMRC50Callback = new c(builder.viewableMRC50Requests);
        this.viewableMRC100Callback = new c(builder.viewableMRC100Requests);
        if (aqVar != null && aqVar.hasVideoUrl()) {
            this.viewableVideoMRC50Callback = new c(builder.viewableVideo50Requests);
        }
        this.tag = "AppLovinNativeAd:" + getAdIdNumber();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public og getAdEventTracker() {
        return this.adEventTracker;
    }

    private void handleNativeAdClick(Uri uri, Uri uri2, Context context) {
        if (this.clickTrackingRequests.size() > 0) {
            Iterator<com.applovin.impl.sdk.network.e> it = this.clickTrackingRequests.iterator();
            while (it.hasNext()) {
                this.sdk.X().dispatchPostbackRequest(it.next(), null);
            }
        } else {
            Iterator<String> it2 = this.clickTrackingUrls.iterator();
            while (it2.hasNext()) {
                this.sdk.X().dispatchPostbackAsync(it2.next(), null);
            }
        }
        fc.b(this.eventListener, this);
        if (isDirectDownloadEnabled()) {
            this.sdk.n().startDirectInstallOrDownloadProcess(this, null, new a(uri, uri2, context));
        } else {
            launchUri(uri, uri2, context);
        }
    }

    @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
    public void onClick(View view, MotionEvent motionEvent) {
        Context context;
        this.sdk.I();
        if (n.a()) {
            this.sdk.I().a(this.tag, "Handle view clicked");
        }
        this.sdk.j().maybeSubmitPersistentPostbacks(getDirectClickTrackingPostbacks());
        if (!((Boolean) this.sdk.a(sj.B)).booleanValue() || (context = zq.a(this.nativeAdView, this.sdk)) == null) {
            context = view.getContext();
        }
        handleNativeAdClick(this.clickDestinationUri, this.clickDestinationBackupUri, motionEvent, context);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements ArrayService.DirectDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f63432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Uri f63433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f63434c;

        a(Uri uri, Uri uri2, Context context) {
            this.f63432a = uri;
            this.f63433b = uri2;
            this.f63434c = context;
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onFailure() {
            AppLovinNativeAdImpl.this.launchUri(this.f63432a, this.f63433b, this.f63434c);
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onAppDetailsDismissed() {
        }

        @Override // com.applovin.impl.sdk.array.ArrayService.DirectDownloadListener
        public void onAppDetailsDisplayed() {
        }
    }
}
