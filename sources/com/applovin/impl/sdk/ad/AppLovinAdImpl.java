package com.applovin.impl.sdk.ad;

import android.os.Bundle;
import com.applovin.impl.h0;
import com.applovin.impl.i8;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tl;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.facebook.appevents.AppEventsConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AppLovinAdImpl extends AppLovinAdBase implements AppLovinAd, i8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f63174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h0 f63175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f63176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f63177d;

    protected AppLovinAdImpl(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        super(jSONObject, jSONObject2, jVar);
        this.f63174a = new Bundle();
    }

    private long b() {
        return getLongFromAdObject("ad_expiration_ms", ((Long) this.sdk.a(sj.f63732d1)).longValue());
    }

    public boolean canExpire() {
        return getSize() == AppLovinAdSize.INTERSTITIAL && b() > 0;
    }

    public boolean equals(Object obj) {
        AppLovinAd appLovinAdC;
        if ((obj instanceof c) && (appLovinAdC = ((c) obj).c()) != null) {
            obj = appLovinAdC;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && getAdIdNumber() == ((AppLovinAdImpl) obj).getAdIdNumber();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getAdIdNumber() {
        return getLongFromAdObject("ad_id", -1L);
    }

    public h0 getAdZone() {
        h0 h0Var = this.f63175b;
        if (h0Var != null) {
            if (h0Var.f() != null && this.f63175b.g() != null) {
                return this.f63175b;
            }
            if (getSize() == null && getType() == null) {
                return this.f63175b;
            }
        }
        h0 h0VarA = h0.a(getSize(), getType(), getStringFromFullResponse(AppLovinUtils.ServerParameterKeys.ZONE_ID, null), getBooleanFromFullResponse("is_bidding", false), getBooleanFromFullResponse("is_direct_sold", false));
        this.f63175b = h0VarA;
        return h0VarA;
    }

    public c getDummyAd() {
        return this.f63177d;
    }

    public Bundle getMAXAdValues() {
        return this.f63174a;
    }

    public abstract JSONObject getOriginalFullResponse();

    public String getRawFullResponse() {
        String string;
        tl tlVar = this.synchronizedFullResponse;
        if (tlVar != null) {
            return tlVar.toString();
        }
        synchronized (this.fullResponseLock) {
            string = this.fullResponse.toString();
        }
        return string;
    }

    @Override // com.applovin.sdk.AppLovinAd
    public AppLovinAdSize getSize() {
        return AppLovinAdSize.fromString(getStringFromFullResponse("ad_size", null));
    }

    @Override // com.applovin.impl.i8
    public long getTimeToLiveMillis() {
        if (!canExpire()) {
            return Long.MAX_VALUE;
        }
        return b() - (System.currentTimeMillis() - getCreatedAtMillis());
    }

    @Override // com.applovin.sdk.AppLovinAd
    public AppLovinAdType getType() {
        return AppLovinAdType.fromString(getStringFromFullResponse(AppEventsConstants.EVENT_PARAM_AD_TYPE, null));
    }

    @Override // com.applovin.sdk.AppLovinAd
    public String getZoneId() {
        if (getAdZone().i()) {
            return null;
        }
        return getStringFromFullResponse(AppLovinUtils.ServerParameterKeys.ZONE_ID, null);
    }

    public boolean hasShown() {
        return getBooleanFromAdObject("shown", Boolean.FALSE);
    }

    public boolean hasVideoUrl() {
        this.sdk.I();
        if (!com.applovin.impl.sdk.n.a()) {
            return false;
        }
        this.sdk.I().b("AppLovinAd", "Attempting to invoke hasVideoUrl() from base ad class");
        return false;
    }

    public int hashCode() {
        return (int) getAdIdNumber();
    }

    public boolean isExpired() {
        return this.f63176c;
    }

    public boolean isVideoAd() {
        return this.adObject.has("is_video_ad") ? getBooleanFromAdObject("is_video_ad", Boolean.FALSE) : hasVideoUrl();
    }

    public void setDummyAd(c cVar) {
        this.f63177d = cVar;
    }

    @Override // com.applovin.impl.i8
    public void setExpired() {
        this.f63176c = true;
    }

    public void setHasShown(boolean z2) {
        try {
            tl tlVar = this.synchronizedAdObject;
            if (tlVar != null) {
                tlVar.a("shown", (Object) Boolean.valueOf(z2));
                return;
            }
            synchronized (this.adObjectLock) {
                this.adObject.put("shown", z2);
            }
        } catch (Throwable unused) {
        }
    }

    public void setMaxAdValue(String str, Object obj) {
        BundleUtils.put(str, obj, this.f63174a);
    }

    public String toString() {
        return "AppLovinAd{adIdNumber=" + getAdIdNumber() + ", zoneId=\"" + getZoneId() + "\"}";
    }
}
