package com.applovin.impl.mediation;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxMediatedNetworkInfoImpl implements MaxMediatedNetworkInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f61434a;

    public MaxMediatedNetworkInfoImpl(JSONObject jSONObject) {
        this.f61434a = jSONObject;
    }

    @Override // com.applovin.mediation.MaxMediatedNetworkInfo
    public String getAdapterClassName() {
        return JsonUtils.getString(this.f61434a, "class", "");
    }

    @Override // com.applovin.mediation.MaxMediatedNetworkInfo
    public String getAdapterVersion() {
        return JsonUtils.getString(this.f61434a, "version", "");
    }

    @Override // com.applovin.mediation.MaxMediatedNetworkInfo
    public String getName() {
        return JsonUtils.getString(this.f61434a, "name", "");
    }

    @Override // com.applovin.mediation.MaxMediatedNetworkInfo
    public String getSdkVersion() {
        return JsonUtils.getString(this.f61434a, "sdk_version", "");
    }

    public String toString() {
        return "MaxMediatedNetworkInfo{name=" + getName() + ", adapterClassName=" + getAdapterClassName() + ", adapterVersion=" + getAdapterVersion() + ", sdkVersion=" + getSdkVersion() + '}';
    }
}
