package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class um extends yl implements qb {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JSONObject f64273h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h0 f64274i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AppLovinAdLoadListener f64275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f64276k;

    public um(JSONObject jSONObject, h0 h0Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        this(jSONObject, h0Var, false, appLovinAdLoadListener, jVar);
    }

    private void a(JSONObject jSONObject) {
        String string = JsonUtils.getString(jSONObject, "type", "undefined");
        if ("applovin".equalsIgnoreCase(string)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Starting task for AppLovin ad...");
            }
            this.f65231a.i0().a(new bn(jSONObject, this.f64273h, this, this.f65231a));
            return;
        }
        if ("vast".equalsIgnoreCase(string)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Starting task for VAST ad...");
            }
            this.f65231a.i0().a(zm.a(jSONObject, this.f64273h, this, this.f65231a));
            return;
        }
        if ("js_tag".equalsIgnoreCase(string)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Starting task for JS tag ad...");
            }
            this.f65231a.i0().a(new vm(jSONObject, this.f64273h, this, this.f65231a));
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.b(this.f65232b, "Unable to process ad of unknown type: " + string);
        }
        failedToReceiveAdV2(new AppLovinError(AppLovinErrorCodes.INVALID_RESPONSE, "Unknown ad type: " + string));
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f64275j;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(appLovinAd);
        }
        if (this.f64276k || !(appLovinAd instanceof com.applovin.impl.sdk.ad.b)) {
            return;
        }
        this.f65231a.D().a(ka.f60956i, (com.applovin.impl.sdk.ad.b) appLovinAd);
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i3) {
        failedToReceiveAdV2(new AppLovinError(i3, ""));
    }

    @Override // com.applovin.impl.qb
    public void failedToReceiveAdV2(AppLovinError appLovinError) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.f64275j;
        if (appLovinAdLoadListener == null) {
            return;
        }
        if (appLovinAdLoadListener instanceof qb) {
            ((qb) appLovinAdLoadListener).failedToReceiveAdV2(appLovinError);
        } else {
            appLovinAdLoadListener.failedToReceiveAd(appLovinError.getCode());
        }
        if (this.f64276k) {
            return;
        }
        this.f65231a.D().a(ka.f60957j, this.f64274i, appLovinError);
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.f64273h, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Processing ad...");
            }
            a(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()));
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.k(this.f65232b, "No ads were returned from the server");
            }
            yp.a(this.f64274i.e(), this.f64274i.d(), this.f64273h, this.f65231a);
            failedToReceiveAdV2(AppLovinError.NO_FILL);
        }
    }

    public um(JSONObject jSONObject, h0 h0Var, boolean z2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.j jVar) {
        super("TaskProcessAdResponse", jVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        }
        if (h0Var == null) {
            throw new IllegalArgumentException("No zone specified");
        }
        this.f64273h = jSONObject;
        this.f64274i = h0Var;
        this.f64275j = appLovinAdLoadListener;
        this.f64276k = z2;
    }
}
