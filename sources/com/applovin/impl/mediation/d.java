package com.applovin.impl.mediation;

import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.fc;
import com.applovin.impl.fe;
import com.applovin.impl.fm;
import com.applovin.impl.lm;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.ue;
import com.applovin.impl.yl;
import com.applovin.impl.yp;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f61618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f61619b = new HashMap(4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f61620c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f61621d = new HashMap(4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f61622e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f61623f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f61624g = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements fm.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f61625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f61626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f61627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MaxAdFormat f61628d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map f61629e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map f61630f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f61631g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC0110a f61632h;

        a(long j3, Map map, String str, MaxAdFormat maxAdFormat, Map map2, Map map3, Context context, a.InterfaceC0110a interfaceC0110a) {
            this.f61625a = j3;
            this.f61626b = map;
            this.f61627c = str;
            this.f61628d = maxAdFormat;
            this.f61629e = map2;
            this.f61630f = map3;
            this.f61631g = context;
            this.f61632h = interfaceC0110a;
        }

        @Override // com.applovin.impl.fm.b
        public void a(JSONArray jSONArray) {
            this.f61626b.put("sct_ms", Long.valueOf(SystemClock.elapsedRealtime() - this.f61625a));
            this.f61626b.put("calfc", Integer.valueOf(d.this.b(this.f61627c)));
            lm lmVar = new lm(this.f61627c, this.f61628d, this.f61629e, this.f61630f, this.f61626b, jSONArray, this.f61631g, d.this.f61618a, this.f61632h);
            if (((Boolean) d.this.f61618a.a(ue.E7)).booleanValue()) {
                d.this.f61618a.i0().a((yl) lmVar, tm.b.MEDIATION);
            } else {
                d.this.f61618a.i0().a(lmVar);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum b {
        PUBLISHER_INITIATED("publisher_initiated"),
        SEQUENTIAL_OR_PRECACHE("sequential_or_precache"),
        REFRESH("refresh"),
        EXPONENTIAL_RETRY("exponential_retry"),
        EXPIRED("expired"),
        NATIVE_AD_PLACER("native_ad_placer");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f61641a;

        b(String str) {
            this.f61641a = str;
        }

        public String b() {
            return this.f61641a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class c implements a.InterfaceC0110a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f61642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WeakReference f61643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d f61644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final C0111d f61645d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final MaxAdFormat f61646f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Map f61647g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Map f61648h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Map f61649i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f61650j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f61651k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f61652l;

        /* synthetic */ c(Map map, Map map2, Map map3, C0111d c0111d, MaxAdFormat maxAdFormat, long j3, long j4, d dVar, com.applovin.impl.sdk.j jVar, Context context, a aVar) {
            this(map, map2, map3, c0111d, maxAdFormat, j3, j4, dVar, jVar, context);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
            throw new IllegalStateException("Wrong callback invoked for ad: " + maxAd);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            final String str2;
            MaxError maxError2;
            this.f61644c.c(str);
            if (((Boolean) this.f61642a.a(ue.v7)).booleanValue() && this.f61645d.f61655c.get()) {
                this.f61642a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61642a.I().a("MediationAdLoadManager", "Ad failed to load but its load state was destroyed");
                    return;
                }
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f61651k;
            MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl = (MaxAdWaterfallInfoImpl) maxError.getWaterfall();
            if (maxAdWaterfallInfoImpl != null) {
                str2 = str;
                maxError2 = maxError;
                this.f61642a.P().processWaterfallInfoPostback(str2, this.f61646f, maxAdWaterfallInfoImpl, maxError2, this.f61652l, jElapsedRealtime);
            } else {
                str2 = str;
                maxError2 = maxError;
            }
            boolean z2 = maxError2.getCode() == -5603 && yp.c(this.f61642a) && ((Boolean) this.f61642a.a(sj.g6)).booleanValue();
            if (this.f61642a.a(ue.u7, this.f61646f) && this.f61645d.f61656d < this.f61650j && !z2) {
                C0111d.f(this.f61645d);
                final int iPow = (int) Math.pow(2.0d, this.f61645d.f61656d);
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61850a.a(iPow, str2);
                    }
                }, TimeUnit.SECONDS.toMillis(iPow));
                return;
            }
            this.f61645d.f61656d = 0;
            this.f61645d.f61654b.set(false);
            if (this.f61645d.f61657e != null) {
                MaxErrorImpl maxErrorImpl = (MaxErrorImpl) maxError2;
                maxErrorImpl.setLoadTag(this.f61645d.f61653a);
                maxErrorImpl.setRequestLatencyMillis(jElapsedRealtime);
                fc.a(this.f61645d.f61657e, str2, maxError2);
                this.f61645d.f61657e = null;
            }
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(MaxAd maxAd) {
            if (((Boolean) this.f61642a.a(ue.v7)).booleanValue() && this.f61645d.f61655c.get()) {
                this.f61642a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61642a.I().a("MediationAdLoadManager", "Ad loaded but its load state was destroyed");
                }
                this.f61642a.P().destroyAd(maxAd);
                return;
            }
            fe feVar = (fe) maxAd;
            feVar.i(this.f61645d.f61653a);
            feVar.a(SystemClock.elapsedRealtime() - this.f61651k);
            MaxAdWaterfallInfoImpl maxAdWaterfallInfoImpl = (MaxAdWaterfallInfoImpl) feVar.getWaterfall();
            if (maxAdWaterfallInfoImpl != null) {
                this.f61642a.P().processWaterfallInfoPostback(feVar.getAdUnitId(), this.f61646f, maxAdWaterfallInfoImpl, null, this.f61652l, feVar.getRequestLatencyMillis());
            }
            this.f61644c.a(maxAd.getAdUnitId());
            this.f61645d.f61656d = 0;
            if (this.f61645d.f61657e == null) {
                this.f61644c.a(feVar);
                this.f61645d.f61654b.set(false);
                return;
            }
            feVar.A().c().a(this.f61645d.f61657e);
            this.f61645d.f61657e.onAdLoaded(feVar);
            if (feVar.P().endsWith("load")) {
                this.f61645d.f61657e.onAdRevenuePaid(feVar);
            }
            this.f61645d.f61657e = null;
            if ((!this.f61642a.c(ue.s7).contains(maxAd.getAdUnitId()) && !this.f61642a.a(ue.r7, maxAd.getFormat())) || this.f61642a.k0().c() || this.f61642a.k0().d()) {
                this.f61645d.f61654b.set(false);
                return;
            }
            Context contextM = (Context) this.f61643b.get();
            if (contextM == null) {
                contextM = com.applovin.impl.sdk.j.m();
            }
            Context context = contextM;
            this.f61651k = SystemClock.elapsedRealtime();
            this.f61652l = System.currentTimeMillis();
            this.f61649i.put("art", b.SEQUENTIAL_OR_PRECACHE.b());
            this.f61644c.a(maxAd.getAdUnitId(), maxAd.getFormat(), this.f61647g, this.f61648h, this.f61649i, context, this);
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
        }

        private c(Map map, Map map2, Map map3, C0111d c0111d, MaxAdFormat maxAdFormat, long j3, long j4, d dVar, com.applovin.impl.sdk.j jVar, Context context) {
            this.f61642a = jVar;
            this.f61643b = new WeakReference(context);
            this.f61644c = dVar;
            this.f61645d = c0111d;
            this.f61646f = maxAdFormat;
            this.f61648h = map2;
            this.f61647g = map;
            this.f61649i = map3;
            this.f61651k = j3;
            this.f61652l = j4;
            if (CollectionUtils.getBoolean(map2, "disable_auto_retries")) {
                this.f61650j = -1;
            } else if (maxAdFormat.isAdViewAd() && CollectionUtils.getBoolean(map2, "auto_refresh_stopped")) {
                this.f61650j = Math.min(2, ((Integer) jVar.a(ue.t7)).intValue());
            } else {
                this.f61650j = ((Integer) jVar.a(ue.t7)).intValue();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i3, String str) {
            this.f61648h.put(jlWo.lnrOs, Integer.valueOf(i3));
            this.f61648h.put("retry_attempt", Integer.valueOf(this.f61645d.f61656d));
            Context contextM = (Context) this.f61643b.get();
            if (contextM == null) {
                contextM = com.applovin.impl.sdk.j.m();
            }
            Context context = contextM;
            this.f61649i.put("art", b.EXPONENTIAL_RETRY.b());
            this.f61649i.put("era", Integer.valueOf(this.f61645d.f61656d));
            this.f61652l = System.currentTimeMillis();
            this.f61644c.a(str, this.f61646f, this.f61647g, this.f61648h, this.f61649i, context, this);
        }
    }

    /* JADX INFO: renamed from: com.applovin.impl.mediation.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class C0111d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f61653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f61654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicBoolean f61655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f61656d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private volatile a.InterfaceC0110a f61657e;

        /* synthetic */ C0111d(String str, a aVar) {
            this(str);
        }

        static /* synthetic */ int f(C0111d c0111d) {
            int i3 = c0111d.f61656d;
            c0111d.f61656d = i3 + 1;
            return i3;
        }

        private C0111d(String str) {
            this.f61654b = new AtomicBoolean();
            this.f61655c = new AtomicBoolean();
            this.f61653a = str;
        }
    }

    public d(com.applovin.impl.sdk.j jVar) {
        this.f61618a = jVar;
    }

    private String b(String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str2 != null) {
            str3 = "-" + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        return sb.toString();
    }

    private fe e(String str) {
        fe feVar;
        synchronized (this.f61622e) {
            feVar = (fe) this.f61621d.get(str);
            this.f61621d.remove(str);
        }
        return feVar;
    }

    public void c(String str, String str2) {
        synchronized (this.f61620c) {
            String strB = b(str, str2);
            a(str, str2).f61655c.set(true);
            this.f61619b.remove(strB);
        }
    }

    public boolean d(String str) {
        boolean z2;
        synchronized (this.f61622e) {
            z2 = this.f61621d.get(str) != null;
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(fe feVar) {
        synchronized (this.f61622e) {
            try {
                if (this.f61621d.containsKey(feVar.getAdUnitId())) {
                    com.applovin.impl.sdk.n.h("AppLovinSdk", "Ad in cache already: " + feVar.getAdUnitId());
                }
                this.f61621d.put(feVar.getAdUnitId(), feVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int b(String str) {
        int iIntValue;
        synchronized (this.f61624g) {
            try {
                Integer num = (Integer) this.f61623f.get(str);
                iIntValue = num != null ? num.intValue() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iIntValue;
    }

    public void c(String str) {
        synchronized (this.f61624g) {
            try {
                this.f61618a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61618a.I().a("MediationAdLoadManager", "Incrementing ad load failures count for ad unit ID: " + str);
                }
                Integer num = (Integer) this.f61623f.get(str);
                if (num == null) {
                    num = 0;
                }
                this.f61623f.put(str, Integer.valueOf(num.intValue() + 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(String str, String str2, MaxAdFormat maxAdFormat, b bVar, Map map, Map map2, Context context, a.InterfaceC0110a interfaceC0110a) {
        fe feVarE = (this.f61618a.k0().d() || yp.f(com.applovin.impl.sdk.j.m())) ? null : e(str);
        if (feVarE != null) {
            feVarE.i(str2);
            feVarE.A().c().a(interfaceC0110a);
            interfaceC0110a.onAdLoaded(feVarE);
            if (feVarE.P().endsWith("load")) {
                interfaceC0110a.onAdRevenuePaid(feVarE);
            }
        }
        C0111d c0111dA = a(str, str2);
        if (!c0111dA.f61654b.compareAndSet(false, true)) {
            if (c0111dA.f61657e != null && c0111dA.f61657e != interfaceC0110a) {
                com.applovin.impl.sdk.n.j("MediationAdLoadManager", "Attempting to load ad for same ad unit id (" + str + ") while another ad load is already in progress!");
            }
            c0111dA.f61657e = interfaceC0110a;
            return;
        }
        if (feVarE == null) {
            c0111dA.f61657e = interfaceC0110a;
        }
        Map mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        mapSynchronizedMap.put("art", bVar.b());
        if (StringUtils.isValidString(str2)) {
            mapSynchronizedMap.put("alt", str2);
        }
        a(str, maxAdFormat, map, map2, mapSynchronizedMap, context, new c(map, map2, mapSynchronizedMap, c0111dA, maxAdFormat, SystemClock.elapsedRealtime(), System.currentTimeMillis(), this, this.f61618a, context, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MaxAdFormat maxAdFormat, Map map, Map map2, Map map3, Context context, a.InterfaceC0110a interfaceC0110a) {
        this.f61618a.i0().a((yl) new fm(str, maxAdFormat, map, context, this.f61618a, new a(SystemClock.elapsedRealtime(), map3, str, maxAdFormat, map, map2, context, interfaceC0110a)), tm.b.MEDIATION);
    }

    private C0111d a(String str, String str2) {
        C0111d c0111d;
        synchronized (this.f61620c) {
            try {
                String strB = b(str, str2);
                c0111d = (C0111d) this.f61619b.get(strB);
                if (c0111d == null) {
                    c0111d = new C0111d(str2, null);
                    this.f61619b.put(strB, c0111d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0111d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        synchronized (this.f61624g) {
            try {
                this.f61618a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61618a.I().a("MediationAdLoadManager", "Clearing ad load failures count for ad unit ID: " + str);
                }
                this.f61623f.remove(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
