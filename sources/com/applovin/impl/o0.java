package com.applovin.impl;

import com.amazon.device.ads.AdError;
import com.amazon.device.ads.DTBAdCallback;
import com.amazon.device.ads.DTBAdRequest;
import com.amazon.device.ads.DTBAdResponse;
import com.amazon.device.ads.DTBAdSize;
import com.applovin.mediation.MaxAdFormat;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class o0 implements DTBAdCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxAdFormat f62151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f62152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DTBAdRequest f62153c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat);

        void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat);
    }

    public o0(p0 p0Var, MaxAdFormat maxAdFormat, a aVar) {
        this(Arrays.asList(p0Var.a()), maxAdFormat, aVar);
    }

    public void a() {
        DTBAdRequest dTBAdRequest = this.f62153c;
        if (dTBAdRequest == null) {
            this.f62152b.onAdLoadFailed(null, this.f62151a);
        } else {
            dTBAdRequest.loadAd(this);
        }
    }

    public void onFailure(AdError adError) {
        this.f62152b.onAdLoadFailed(adError, this.f62151a);
    }

    public void onSuccess(DTBAdResponse dTBAdResponse) {
        this.f62152b.onAdResponseLoaded(dTBAdResponse, this.f62151a);
    }

    public o0(List list, MaxAdFormat maxAdFormat, a aVar) {
        this.f62151a = maxAdFormat;
        this.f62152b = aVar;
        try {
            DTBAdSize[] dTBAdSizeArr = new DTBAdSize[list.size()];
            for (int i3 = 0; i3 < list.size(); i3++) {
                Object obj = list.get(i3);
                if (obj instanceof DTBAdSize) {
                    dTBAdSizeArr[i3] = (DTBAdSize) obj;
                }
            }
            DTBAdRequest dTBAdRequest = new DTBAdRequest();
            this.f62153c = dTBAdRequest;
            dTBAdRequest.setSizes(dTBAdSizeArr);
        } catch (Throwable unused) {
        }
    }
}
