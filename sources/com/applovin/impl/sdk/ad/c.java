package com.applovin.impl.sdk.ad;

import android.os.Bundle;
import com.applovin.impl.h0;
import com.applovin.impl.lg;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends AppLovinAdImpl {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AppLovinAd f63211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final h0 f63212g;

    public c(h0 h0Var, com.applovin.impl.sdk.j jVar) {
        super(new JSONObject(), new JSONObject(), jVar);
        this.f63212g = h0Var;
    }

    private AppLovinAd d() {
        return (AppLovinAd) this.sdk.h().f(this.f63212g);
    }

    private String e() {
        h0 adZone = getAdZone();
        if (adZone == null || adZone.i()) {
            return null;
        }
        return adZone.e();
    }

    public void a(AppLovinAd appLovinAd) {
        this.f63211f = appLovinAd;
    }

    public AppLovinAd c() {
        AppLovinAd appLovinAd = this.f63211f;
        return appLovinAd != null ? appLovinAd : d();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        AppLovinAd appLovinAdC = c();
        return appLovinAdC != null ? appLovinAdC.equals(obj) : super.equals(obj);
    }

    public AppLovinAd f() {
        return this.f63211f;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public lg getAdEventTracker() {
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.impl.sdk.AppLovinAdBase
    public long getAdIdNumber() {
        AppLovinAd appLovinAdC = c();
        if (appLovinAdC instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) appLovinAdC).getAdIdNumber();
        }
        return 0L;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public h0 getAdZone() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) c();
        return appLovinAdImpl != null ? appLovinAdImpl.getAdZone() : this.f63212g;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getCreatedAtMillis() {
        AppLovinAd appLovinAdC = c();
        if (appLovinAdC instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) appLovinAdC).getCreatedAtMillis();
        }
        return 0L;
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public Bundle getDirectDownloadParameters() {
        return new Bundle();
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public String getDirectDownloadToken() {
        return null;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public String getOpenMeasurementContentUrl() {
        return null;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public String getOpenMeasurementCustomReferenceData() {
        return null;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public List getOpenMeasurementVerificationScriptResources() {
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        AppLovinAd appLovinAdC = c();
        if (appLovinAdC instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) appLovinAdC).getOriginalFullResponse();
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.sdk.AppLovinAd
    public AppLovinAdSize getSize() {
        return getAdZone().f();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.sdk.AppLovinAd
    public AppLovinAdType getType() {
        return getAdZone().g();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.sdk.AppLovinAd
    public String getZoneId() {
        if (this.f63212g.i()) {
            return null;
        }
        return this.f63212g.e();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public int hashCode() {
        AppLovinAd appLovinAdC = c();
        return appLovinAdC != null ? appLovinAdC.hashCode() : super.hashCode();
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public boolean isDirectDownloadEnabled() {
        return false;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean isExpired() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) c();
        return appLovinAdImpl != null && appLovinAdImpl.isExpired();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.kg
    public boolean isOpenMeasurementEnabled() {
        return false;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean isVideoAd() {
        AppLovinAd appLovinAdC = c();
        return (appLovinAdC instanceof AppLovinAdImpl) && ((AppLovinAdImpl) appLovinAdC).isVideoAd();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public String toString() {
        return "AppLovinAd{ #" + getAdIdNumber() + ", adType=" + getType() + ", adSize=" + getSize() + ", zoneId='" + e() + "'}";
    }
}
