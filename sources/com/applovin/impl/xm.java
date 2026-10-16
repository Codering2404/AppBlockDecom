package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.mediation.MaxAdWaterfallInfoImpl;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MaxNetworkResponseInfoImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.tm;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxErrorCode;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class xm extends yl {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final AtomicBoolean f65003q = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f65004h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MaxAdFormat f65005i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final JSONObject f65006j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f65007k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final a.InterfaceC0110a f65008l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final WeakReference f65009m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f65010n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f65011o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final List f65012p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class b extends yl {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final long f65013h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f65014i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final fe f65015j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final List f65016k;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class a extends ne {
            a(a.InterfaceC0110a interfaceC0110a) {
                super(interfaceC0110a);
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoadFailed(String str, MaxError maxError) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - b.this.f65013h;
                com.applovin.impl.sdk.n unused = b.this.f65233c;
                if (com.applovin.impl.sdk.n.a()) {
                    b.this.f65233c.a(b.this.f65232b, "Ad failed to load in " + jElapsedRealtime + " ms for " + xm.this.f65005i.getLabel() + " ad unit " + xm.this.f65004h + " with error: " + maxError);
                }
                b.this.b("failed to load ad: " + maxError.getCode());
                b bVar = b.this;
                bVar.a(bVar.f65015j, MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD, jElapsedRealtime, maxError);
                if (b.this.f65014i >= b.this.f65016k.size() - 1) {
                    xm.this.b(new MaxErrorImpl(-5001, "MAX returned eligible ads from mediated networks, but all ads failed to load. Inspect getWaterfall() for more info."));
                } else {
                    b bVar2 = b.this;
                    b.this.f65231a.i0().a((yl) new b(bVar2.f65014i + 1, b.this.f65016k), tm.b.MEDIATION);
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoaded(MaxAd maxAd) {
                b.this.b("loaded ad");
                long jElapsedRealtime = SystemClock.elapsedRealtime() - b.this.f65013h;
                com.applovin.impl.sdk.n unused = b.this.f65233c;
                if (com.applovin.impl.sdk.n.a()) {
                    b.this.f65233c.a(b.this.f65232b, "Ad loaded in " + jElapsedRealtime + "ms for " + xm.this.f65005i.getLabel() + " ad unit " + xm.this.f65004h);
                }
                fe feVar = (fe) maxAd;
                b.this.a(feVar, MaxNetworkResponseInfo.AdLoadState.AD_LOADED, jElapsedRealtime, null);
                int i3 = b.this.f65014i;
                while (true) {
                    i3++;
                    if (i3 >= b.this.f65016k.size()) {
                        xm.this.b(feVar);
                        return;
                    } else {
                        b bVar = b.this;
                        bVar.a((fe) bVar.f65016k.get(i3), MaxNetworkResponseInfo.AdLoadState.AD_LOAD_NOT_ATTEMPTED, -1L, null);
                    }
                }
            }
        }

        private b(int i3, List list) {
            super(xm.this.f65232b, xm.this.f65231a, xm.this.f65004h);
            this.f65013h = SystemClock.elapsedRealtime();
            this.f65014i = i3;
            this.f65015j = (fe) list.get(i3);
            this.f65016k = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Loading ad " + (this.f65014i + 1) + " of " + this.f65016k.size() + " from " + this.f65015j.c() + " for " + xm.this.f65005i.getLabel() + " ad unit " + xm.this.f65004h);
            }
            b("started to load ad");
            Context context = (Context) xm.this.f65009m.get();
            Activity activityM0 = context instanceof Activity ? (Activity) context : this.f65231a.m0();
            this.f65231a.S().b(this.f65015j);
            this.f65231a.P().loadThirdPartyMediatedAd(xm.this.f65004h, this.f65015j, activityM0, new a(xm.this.f65008l));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(fe feVar, MaxNetworkResponseInfo.AdLoadState adLoadState, long j3, MaxError maxError) {
            xm.this.f65012p.add(new MaxNetworkResponseInfoImpl(adLoadState, ze.a(feVar.b()), feVar.F(), feVar.X(), j3, feVar.B(), maxError));
        }
    }

    xm(String str, MaxAdFormat maxAdFormat, Map map, JSONObject jSONObject, Context context, com.applovin.impl.sdk.j jVar, a.InterfaceC0110a interfaceC0110a) {
        super("TaskProcessMediationWaterfall", jVar, str);
        this.f65004h = str;
        this.f65005i = maxAdFormat;
        this.f65006j = jSONObject;
        this.f65008l = interfaceC0110a;
        this.f65009m = new WeakReference(context);
        this.f65010n = JsonUtils.getString(jSONObject, "mcode", "");
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ads", new JSONArray());
        this.f65007k = new ArrayList(jSONArray.length());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            this.f65007k.add(fe.a(i3, map, JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null), jSONObject, jVar));
        }
        this.f65012p = new ArrayList(this.f65007k.size());
    }

    @Override // java.lang.Runnable
    public void run() {
        final MaxErrorImpl maxErrorImpl;
        this.f65011o = SystemClock.elapsedRealtime();
        int i3 = 0;
        if (this.f65006j.optBoolean("is_testing", false) && !this.f65231a.k0().c() && f65003q.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.s80
                @Override // java.lang.Runnable
                public final void run() {
                    this.f63003a.e();
                }
            });
        }
        if (this.f65007k.size() > 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Starting waterfall for " + this.f65005i.getLabel() + " ad unit " + this.f65004h + " with " + this.f65007k.size() + " ad(s)...");
            }
            this.f65231a.i0().a(new b(i3, this.f65007k));
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.k(this.f65232b, "No ads were returned from the server for " + this.f65005i.getLabel() + " ad unit " + this.f65004h);
        }
        yp.a(this.f65004h, this.f65005i, this.f65006j, this.f65231a);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f65006j, "settings", new JSONObject());
        long j3 = JsonUtils.getLong(jSONObject, "alfdcs", 0L);
        if (ze.a(this.f65006j, this.f65004h, this.f65231a)) {
            maxErrorImpl = new MaxErrorImpl(MaxErrorCode.INVALID_AD_UNIT_ID, "Ad Unit ID " + this.f65004h + " is invalid or disabled.\nMake sure to use an Ad Unit ID from the MAX dashboard that is enabled and configured for the current application.\nFor more information, see https://developers.applovin.com/en/getting-started#step-2-create-an-ad-unit\nNote: New ad units cannot load ads until 30-60 minutes after they are created");
            if (yp.c(this.f65231a) && ((Boolean) this.f65231a.a(sj.g6)).booleanValue()) {
                j3 = 0;
            }
        } else {
            maxErrorImpl = new MaxErrorImpl(204, "MAX returned no eligible ads from any mediated networks for this app/device");
        }
        if (j3 <= 0) {
            b(maxErrorImpl);
            return;
        }
        long millis = TimeUnit.SECONDS.toMillis(j3);
        Runnable runnable = new Runnable() { // from class: com.applovin.impl.t80
            @Override // java.lang.Runnable
            public final void run() {
                this.f63893a.b(maxErrorImpl);
            }
        };
        if (JsonUtils.getBoolean(jSONObject, "alfdcs_iba", Boolean.FALSE).booleanValue()) {
            x1.a(millis, this.f65231a, runnable);
        } else {
            AppLovinSdkUtils.runOnUiThreadDelayed(runnable, millis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(fe feVar) {
        this.f65231a.S().c(feVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f65011o;
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.d(this.f65232b, "Waterfall loaded in " + jElapsedRealtime + "ms from " + feVar.c() + " for " + this.f65005i.getLabel() + " ad unit " + this.f65004h);
        }
        feVar.a(new MaxAdWaterfallInfoImpl(feVar, jElapsedRealtime, this.f65012p, this.f65010n));
        fc.f(this.f65008l, feVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        yp.a("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", this.f65231a.m0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(MaxError maxError) {
        if (maxError.getCode() == 204) {
            this.f65231a.C().c(ba.f58623u);
        } else if (maxError.getCode() == -5001) {
            this.f65231a.C().c(ba.f58624v);
        } else {
            this.f65231a.C().c(ba.f58625w);
        }
        ArrayList arrayList = new ArrayList(this.f65012p.size());
        for (MaxNetworkResponseInfo maxNetworkResponseInfo : this.f65012p) {
            if (maxNetworkResponseInfo.getAdLoadState() == MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD) {
                arrayList.add(maxNetworkResponseInfo);
            }
        }
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder("======FAILED AD LOADS======");
            sb.append("\n");
            int i3 = 0;
            while (i3 < arrayList.size()) {
                MaxNetworkResponseInfo maxNetworkResponseInfo2 = (MaxNetworkResponseInfo) arrayList.get(i3);
                i3++;
                sb.append(i3);
                sb.append(") ");
                sb.append(maxNetworkResponseInfo2.getMediatedNetwork().getName());
                sb.append("\n");
                sb.append("..code: ");
                sb.append(maxNetworkResponseInfo2.getError().getCode());
                sb.append("\n");
                sb.append("..message: ");
                sb.append(maxNetworkResponseInfo2.getError().getMessage());
                sb.append("\n");
            }
            ((MaxErrorImpl) maxError).setAdLoadFailureInfo(sb.toString());
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f65011o;
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.d(this.f65232b, "Waterfall failed in " + jElapsedRealtime + "ms for " + this.f65005i.getLabel() + " ad unit " + this.f65004h + " with error: " + maxError);
        }
        ((MaxErrorImpl) maxError).setWaterfall(new MaxAdWaterfallInfoImpl(null, JsonUtils.getString(this.f65006j, "waterfall_name", ""), JsonUtils.getString(this.f65006j, "waterfall_test_name", ""), jElapsedRealtime, this.f65012p, JsonUtils.optList(JsonUtils.getJSONArray(this.f65006j, "mwf_info_urls", null), Collections.EMPTY_LIST), this.f65010n));
        fc.a(this.f65008l, this.f65004h, maxError);
    }
}
