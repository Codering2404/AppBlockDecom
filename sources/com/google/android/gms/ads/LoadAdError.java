package com.google.android.gms.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class LoadAdError extends AdError {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ResponseInfo f69670e;

    public LoadAdError(int i3, String str, String str2, AdError adError, ResponseInfo responseInfo) {
        super(i3, str, str2, adError);
        this.f69670e = responseInfo;
    }

    @Override // com.google.android.gms.ads.AdError
    public final JSONObject e() throws JSONException {
        JSONObject jSONObjectE = super.e();
        ResponseInfo responseInfoF = f();
        if (responseInfoF == null) {
            jSONObjectE.put("Response Info", "null");
            return jSONObjectE;
        }
        jSONObjectE.put("Response Info", responseInfoF.d());
        return jSONObjectE;
    }

    public ResponseInfo f() {
        return this.f69670e;
    }

    @Override // com.google.android.gms.ads.AdError
    public String toString() {
        try {
            return e().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
