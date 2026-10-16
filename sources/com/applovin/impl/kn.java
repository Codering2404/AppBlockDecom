package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class kn extends mn {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.b f61046h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinAdRewardListener f61047i;

    public kn(com.applovin.impl.sdk.ad.b bVar, AppLovinAdRewardListener appLovinAdRewardListener, com.applovin.impl.sdk.j jVar) {
        super("TaskValidateAppLovinReward", jVar);
        this.f61046h = bVar;
        this.f61047i = appLovinAdRewardListener;
    }

    @Override // com.applovin.impl.mn
    protected void a(eh ehVar) {
        this.f61046h.a(ehVar);
        String strB = ehVar.b();
        Map<String, String> mapA = ehVar.a();
        if (strB.equals("accepted")) {
            this.f61047i.userRewardVerified(this.f61046h, mapA);
            return;
        }
        if (strB.equals("quota_exceeded")) {
            this.f61047i.userOverQuota(this.f61046h, mapA);
        } else if (strB.equals("rejected")) {
            this.f61047i.userRewardRejected(this.f61046h, mapA);
        } else {
            this.f61047i.validationRequestFailed(this.f61046h, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        }
    }

    @Override // com.applovin.impl.in
    public String f() {
        return "2.0/vr";
    }

    @Override // com.applovin.impl.mn
    protected boolean h() {
        return this.f61046h.S0();
    }

    @Override // com.applovin.impl.in
    protected void a(int i3) {
        String str;
        super.a(i3);
        if (i3 >= 400 && i3 < 500) {
            this.f61047i.userRewardRejected(this.f61046h, Collections.EMPTY_MAP);
            str = "rejected";
        } else {
            this.f61047i.validationRequestFailed(this.f61046h, i3);
            str = "network_timeout";
        }
        this.f61046h.a(eh.a(str));
    }

    @Override // com.applovin.impl.in
    protected void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, this.f61046h.getAdZone().e());
        String clCode = this.f61046h.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }
}
