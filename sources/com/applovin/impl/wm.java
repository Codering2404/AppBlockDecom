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
import com.revenuecat.purchases.common.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class wm extends yl {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final AtomicBoolean f64691z = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f64692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MaxAdFormat f64693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final JSONObject f64694j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final a.InterfaceC0110a f64695k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final WeakReference f64696l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f64697m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Queue f64698n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Object f64699o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Queue f64700p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Object f64701q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f64702r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f64703s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List f64704t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final AtomicBoolean f64705u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final AtomicBoolean f64706v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final AtomicBoolean f64707w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private fe f64708x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private go f64709y;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b extends yl {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f64710h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final long f64711i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final fe f64712j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final c f64713k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f64714l;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class a extends ne {
            a(a.InterfaceC0110a interfaceC0110a) {
                super(interfaceC0110a);
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoadFailed(String str, MaxError maxError) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - b.this.f64711i;
                com.applovin.impl.sdk.n unused = b.this.f65233c;
                if (com.applovin.impl.sdk.n.a()) {
                    b.this.f65233c.a(b.this.f64710h, "Ad (" + b.this.f64714l + ") failed to load in " + jElapsedRealtime + "ms for " + wm.this.f64693i + " ad unit " + str + " with error: " + maxError);
                }
                b.this.b("failed to load ad: " + maxError.getCode());
                b bVar = b.this;
                wm.this.a(bVar.f64712j, MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD, jElapsedRealtime, maxError);
                if (wm.this.f64707w.get()) {
                    return;
                }
                if (wm.this.f64708x != null) {
                    b bVar2 = b.this;
                    if (b.this.b(wm.this.c(bVar2.f64713k))) {
                        wm wmVar = wm.this;
                        wmVar.b(wmVar.f64708x);
                        return;
                    }
                }
                b bVar3 = b.this;
                if (!wm.this.d(bVar3.f64713k) && wm.this.f64706v.get() && wm.this.f64705u.get()) {
                    wm.this.b(new MaxErrorImpl(-5001, "MAX returned eligible ads from mediated networks, but all ads failed to load. Inspect getWaterfall() for more info."));
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoaded(MaxAd maxAd) {
                boolean z2;
                long jE;
                fe feVar;
                b.this.b("loaded ad");
                fe feVar2 = (fe) maxAd;
                long jElapsedRealtime = SystemClock.elapsedRealtime() - b.this.f64711i;
                com.applovin.impl.sdk.n unused = b.this.f65233c;
                if (com.applovin.impl.sdk.n.a()) {
                    b.this.f65233c.a(b.this.f64710h, "Ad (" + b.this.f64714l + ") loaded in " + jElapsedRealtime + "ms for " + wm.this.f64693i + " ad unit " + wm.this.f64692h);
                }
                wm.this.a(feVar2, MaxNetworkResponseInfo.AdLoadState.AD_LOADED, jElapsedRealtime, null);
                b bVar = b.this;
                wm.this.b(bVar.f64713k);
                if (c.BIDDING == b.this.f64713k) {
                    z2 = wm.this.f64706v.get();
                    jE = feVar2.S();
                } else {
                    z2 = wm.this.f64705u.get();
                    jE = feVar2.E();
                }
                if (z2 || jE == 0) {
                    if (b.this.b(feVar2)) {
                        feVar2 = wm.this.f64708x;
                        feVar = feVar2;
                    } else {
                        feVar = wm.this.f64708x;
                    }
                    wm.this.a(feVar2, feVar);
                    return;
                }
                wm.this.f64708x = feVar2;
                if (jE < 0) {
                    return;
                }
                b bVar2 = b.this;
                wm.this.f64709y = go.a(jE, bVar2.f65231a, new Runnable() { // from class: com.applovin.impl.q70
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f62583a.a();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a() {
                wm wmVar = wm.this;
                wmVar.b(wmVar.f64708x);
            }
        }

        private b(fe feVar, c cVar) {
            super(wm.this.f65232b, wm.this.f65231a, wm.this.f64692h);
            this.f64710h = this.f65232b + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + cVar;
            this.f64711i = SystemClock.elapsedRealtime();
            this.f64712j = feVar;
            this.f64713k = cVar;
            this.f64714l = feVar.J() + 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f64710h, "Loading ad " + this.f64714l + " of " + wm.this.f64702r + " from " + this.f64712j.c() + " for " + wm.this.f64693i + " ad unit " + wm.this.f64692h);
            }
            b("started to load ad");
            Context context = (Context) wm.this.f64696l.get();
            Activity activityM0 = context instanceof Activity ? (Activity) context : this.f65231a.m0();
            this.f65231a.S().b(this.f64712j);
            this.f65231a.P().loadThirdPartyMediatedAd(wm.this.f64692h, this.f64712j, activityM0, new a(wm.this.f64695k));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b(fe feVar) {
            if (wm.this.f64708x == null) {
                return false;
            }
            if (feVar == null) {
                return true;
            }
            double dN = wm.this.f64708x.N();
            double dN2 = feVar.N();
            return (dN < 0.0d || dN2 < 0.0d) ? wm.this.f64708x.J() < feVar.J() : dN > dN2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum c {
        BIDDING,
        TAG
    }

    public wm(String str, MaxAdFormat maxAdFormat, Map map, JSONObject jSONObject, Context context, com.applovin.impl.sdk.j jVar, a.InterfaceC0110a interfaceC0110a) {
        super("TaskProcessMediationWaterfallV2", jVar, str);
        this.f64698n = new LinkedList();
        this.f64699o = new Object();
        this.f64700p = new LinkedList();
        this.f64701q = new Object();
        this.f64705u = new AtomicBoolean();
        this.f64706v = new AtomicBoolean();
        this.f64707w = new AtomicBoolean();
        this.f64692h = str;
        this.f64693i = maxAdFormat;
        this.f64694j = jSONObject;
        this.f64695k = interfaceC0110a;
        this.f64696l = new WeakReference(context);
        this.f64697m = JsonUtils.getString(jSONObject, "mCode", "");
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ads", new JSONArray());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            fe feVarA = fe.a(i3, map, JsonUtils.getJSONObject(jSONArray, i3, (JSONObject) null), jSONObject, jVar);
            if (feVarA.X()) {
                this.f64700p.add(feVarA);
            } else {
                this.f64698n.add(feVarA);
            }
        }
        int size = this.f64698n.size() + this.f64700p.size();
        this.f64702r = size;
        this.f64704t = new ArrayList(size);
    }

    @Override // java.lang.Runnable
    public void run() {
        final MaxErrorImpl maxErrorImpl;
        this.f64703s = SystemClock.elapsedRealtime();
        if (this.f64694j.optBoolean("is_testing", false) && !this.f65231a.k0().c() && f64691z.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.o70
                @Override // java.lang.Runnable
                public final void run() {
                    this.f62196a.e();
                }
            });
        }
        if (this.f64702r != 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.a(this.f65232b, "Starting waterfall for " + this.f64693i.getLabel() + " ad unit " + this.f64692h + " with " + this.f64702r + " ad(s)...");
            }
            d(c.TAG);
            d(c.BIDDING);
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f65233c.k(this.f65232b, "No ads were returned from the server for " + this.f64693i.getLabel() + " ad unit " + this.f64692h);
        }
        yp.a(this.f64692h, this.f64693i, this.f64694j, this.f65231a);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f64694j, "settings", new JSONObject());
        long j3 = JsonUtils.getLong(jSONObject, "alfdcs", 0L);
        if (ze.a(this.f64694j, this.f64692h, this.f65231a)) {
            maxErrorImpl = new MaxErrorImpl(MaxErrorCode.INVALID_AD_UNIT_ID, "Ad Unit ID " + this.f64692h + " is invalid or disabled.\nMake sure to use an Ad Unit ID from the MAX dashboard that is enabled and configured for the current application.\nFor more information, see https://developers.applovin.com/en/getting-started#step-2-create-an-ad-unit\nNote: New ad units cannot load ads until 30-60 minutes after they are created");
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
        Runnable runnable = new Runnable() { // from class: com.applovin.impl.p70
            @Override // java.lang.Runnable
            public final void run() {
                this.f62420a.b(maxErrorImpl);
            }
        };
        if (JsonUtils.getBoolean(jSONObject, "alfdcs_iba", Boolean.FALSE).booleanValue()) {
            x1.a(millis, this.f65231a, runnable);
        } else {
            AppLovinSdkUtils.runOnUiThreadDelayed(runnable, millis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(c cVar) {
        fe feVarA = a(cVar);
        if (feVarA == null) {
            b(cVar);
            return false;
        }
        this.f65231a.i0().a((yl) new b(feVarA, cVar), tm.b.MEDIATION);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        yp.a("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", this.f65231a.m0());
    }

    private void f() {
        go goVar = this.f64709y;
        if (goVar == null) {
            return;
        }
        goVar.a();
        this.f64709y = null;
    }

    private void g() {
        a(this.f64698n);
        a(this.f64700p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public fe c(c cVar) {
        return a(cVar, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(fe feVar) {
        a(feVar, (fe) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        if (c.BIDDING == cVar) {
            this.f64705u.compareAndSet(false, true);
        } else if (c.TAG == cVar) {
            this.f64706v.compareAndSet(false, true);
        }
    }

    private fe a(c cVar) {
        return a(cVar, false);
    }

    private fe a(c cVar, boolean z2) {
        Object objPoll;
        fe feVar;
        Object objPoll2;
        fe feVar2;
        if (cVar == c.BIDDING) {
            synchronized (this.f64701q) {
                try {
                    if (z2) {
                        objPoll2 = this.f64700p.peek();
                    } else {
                        objPoll2 = this.f64700p.poll();
                    }
                    feVar2 = (fe) objPoll2;
                } finally {
                }
            }
            return feVar2;
        }
        synchronized (this.f64699o) {
            try {
                if (z2) {
                    objPoll = this.f64698n.peek();
                } else {
                    objPoll = this.f64698n.poll();
                }
                feVar = (fe) objPoll;
            } finally {
            }
        }
        return feVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(fe feVar, fe feVar2) {
        if (this.f64707w.compareAndSet(false, true)) {
            f();
            g();
            this.f65231a.S().a(feVar, feVar2);
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f64703s;
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.d(this.f65232b, "Waterfall loaded in " + jElapsedRealtime + "ms from " + feVar.c() + " for " + this.f64693i + " ad unit " + this.f64692h);
            }
            feVar.a(new MaxAdWaterfallInfoImpl(feVar, jElapsedRealtime, this.f64704t, this.f64697m));
            fc.f(this.f64695k, feVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(MaxError maxError) {
        int i3 = 0;
        if (this.f64707w.compareAndSet(false, true)) {
            if (maxError.getCode() == 204) {
                this.f65231a.C().c(ba.f58623u);
            } else if (maxError.getCode() == -5001) {
                this.f65231a.C().c(ba.f58624v);
            } else {
                this.f65231a.C().c(ba.f58625w);
            }
            ArrayList arrayList = new ArrayList(this.f64704t.size());
            for (MaxNetworkResponseInfo maxNetworkResponseInfo : this.f64704t) {
                if (maxNetworkResponseInfo.getAdLoadState() == MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD) {
                    arrayList.add(maxNetworkResponseInfo);
                }
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder("======FAILED AD LOADS======");
                sb.append("\n");
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
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f64703s;
            if (com.applovin.impl.sdk.n.a()) {
                this.f65233c.d(this.f65232b, "Waterfall failed in " + jElapsedRealtime + "ms for " + this.f64693i + " ad unit " + this.f64692h + " with error: " + maxError);
            }
            ((MaxErrorImpl) maxError).setWaterfall(new MaxAdWaterfallInfoImpl(null, JsonUtils.getString(this.f64694j, "waterfall_name", ""), JsonUtils.getString(this.f64694j, "waterfall_test_name", ""), jElapsedRealtime, this.f64704t, JsonUtils.optList(JsonUtils.getJSONArray(this.f64694j, "mwf_info_urls", null), Collections.EMPTY_LIST), this.f64697m));
            fc.a(this.f64695k, this.f64692h, maxError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(fe feVar, MaxNetworkResponseInfo.AdLoadState adLoadState, long j3, MaxError maxError) {
        this.f64704t.add(new MaxNetworkResponseInfoImpl(adLoadState, ze.a(feVar.b()), feVar.F(), feVar.X(), j3, feVar.B(), maxError));
    }

    private void a(Queue queue) {
        Iterator it = queue.iterator();
        while (it.hasNext()) {
            a((fe) it.next(), MaxNetworkResponseInfo.AdLoadState.AD_LOAD_NOT_ATTEMPTED, -1L, null);
        }
    }
}
