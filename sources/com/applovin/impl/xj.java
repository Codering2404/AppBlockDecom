package com.applovin.impl;

import android.os.SystemClock;
import com.applovin.mediation.MaxAdFormat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class xj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f64985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f64986b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f64987c = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f64988a;

        static {
            int[] iArr = new int[b.values().length];
            f64988a = iArr;
            try {
                iArr[b.AD_FORMAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64988a[b.AD_UNIT_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f64988a[b.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum b {
        AD_FORMAT,
        AD_UNIT_ID,
        ALL
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final yj f64993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f64994b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f64995c;

        private c(yj yjVar, long j3) {
            this.f64993a = yjVar;
            this.f64994b = j3;
            this.f64995c = SystemClock.elapsedRealtime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            return SystemClock.elapsedRealtime() - this.f64995c > this.f64994b;
        }

        public yj c() {
            return this.f64993a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!cVar.a((Object) this) || b() != cVar.b() || a() != cVar.a()) {
                return false;
            }
            yj yjVarC = c();
            yj yjVarC2 = cVar.c();
            return yjVarC != null ? yjVarC.equals(yjVarC2) : yjVarC2 == null;
        }

        public int hashCode() {
            long jB = b();
            long jA = a();
            yj yjVarC = c();
            return ((((((int) (jB ^ (jB >>> 32))) + 59) * 59) + ((int) ((jA >>> 32) ^ jA))) * 59) + (yjVarC == null ? 43 : yjVarC.hashCode());
        }

        public String toString() {
            return "SignalCacheManager.SignalWrapper(signal=" + c() + ", expirationTimeMillis=" + b() + ", cacheTimestampMillis=" + a() + ")";
        }

        protected boolean a(Object obj) {
            return obj instanceof c;
        }

        public long b() {
            return this.f64994b;
        }

        public long a() {
            return this.f64995c;
        }

        /* synthetic */ c(yj yjVar, long j3, a aVar) {
            this(yjVar, j3);
        }
    }

    public xj(com.applovin.impl.sdk.j jVar) {
        this.f64985a = jVar;
    }

    private String a(zj zjVar, String str, MaxAdFormat maxAdFormat) {
        String strC = zjVar.c();
        int i3 = a.f64988a[zjVar.t().ordinal()];
        if (i3 == 1) {
            return strC + "_" + maxAdFormat.getLabel();
        }
        if (i3 != 2) {
            return strC;
        }
        return strC + "_" + str;
    }

    public yj b(zj zjVar, String str, MaxAdFormat maxAdFormat) {
        String strA = a(zjVar, str, maxAdFormat);
        synchronized (this.f64987c) {
            try {
                c cVar = (c) this.f64986b.get(strA);
                if (cVar == null) {
                    return null;
                }
                if (cVar.d()) {
                    this.f64986b.remove(strA);
                    return null;
                }
                this.f64985a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f64985a.I().a("SignalCacheManager", "Returning cached signal for: " + zjVar);
                }
                return cVar.f64993a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(yj yjVar, zj zjVar, String str, MaxAdFormat maxAdFormat) {
        if (yjVar == null) {
            return;
        }
        long jU = zjVar.u();
        if (jU <= 0) {
            return;
        }
        this.f64985a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f64985a.I().a("SignalCacheManager", "Caching signal for: " + zjVar);
        }
        String strA = a(zjVar, str, maxAdFormat);
        c cVar = new c(yjVar, jU, null);
        synchronized (this.f64987c) {
            this.f64986b.put(strA, cVar);
        }
    }
}
