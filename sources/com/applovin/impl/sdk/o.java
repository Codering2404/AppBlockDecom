package com.applovin.impl.sdk;

import com.applovin.impl.fe;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f63562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f63563b = new HashMap(5);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f63564c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f63565d = Collections.synchronizedMap(new HashMap(5));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f63566e = Collections.synchronizedMap(new HashMap(5));

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f63567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f63568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f63569c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f63570d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f63571e;

        public a(String str, String str2, String str3) {
            this.f63567a = str;
            this.f63568b = str2;
            this.f63569c = str3;
        }

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public String c() {
            return this.f63569c;
        }

        public String d() {
            return this.f63570d;
        }

        public String e() {
            return this.f63571e;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a(this)) {
                return false;
            }
            String strB = b();
            String strB2 = aVar.b();
            if (strB != null ? !strB.equals(strB2) : strB2 != null) {
                return false;
            }
            String strA = a();
            String strA2 = aVar.a();
            if (strA != null ? !strA.equals(strA2) : strA2 != null) {
                return false;
            }
            String strC = c();
            String strC2 = aVar.c();
            if (strC != null ? !strC.equals(strC2) : strC2 != null) {
                return false;
            }
            String strD = d();
            String strD2 = aVar.d();
            if (strD != null ? !strD.equals(strD2) : strD2 != null) {
                return false;
            }
            String strE = e();
            String strE2 = aVar.e();
            return strE != null ? strE.equals(strE2) : strE2 == null;
        }

        public int hashCode() {
            String strB = b();
            int iHashCode = strB == null ? 43 : strB.hashCode();
            String strA = a();
            int iHashCode2 = ((iHashCode + 59) * 59) + (strA == null ? 43 : strA.hashCode());
            String strC = c();
            int iHashCode3 = (iHashCode2 * 59) + (strC == null ? 43 : strC.hashCode());
            String strD = d();
            int iHashCode4 = (iHashCode3 * 59) + (strD == null ? 43 : strD.hashCode());
            String strE = e();
            return (iHashCode4 * 59) + (strE != null ? strE.hashCode() : 43);
        }

        public String toString() {
            return "MediationWaterfallWinnerTracker.WinningAd(bCode=" + b() + ", adapterName=" + a() + ", networkName=" + c() + ", secondWinnerAdapterName=" + d() + ", secondWinnerNetworkName=" + e() + ")";
        }

        public String b() {
            return this.f63567a;
        }

        public String a() {
            return this.f63568b;
        }
    }

    o(j jVar) {
        this.f63562a = jVar.I();
    }

    public void a(fe feVar) {
        synchronized (this.f63564c) {
            try {
                String adUnitId = feVar.getAdUnitId();
                a aVar = (a) this.f63563b.get(adUnitId);
                if (aVar == null) {
                    if (n.a()) {
                        this.f63562a.a("MediationWaterfallWinnerTracker", "No previous winner to clear.");
                    }
                    return;
                }
                if (feVar.B().equals(aVar.b())) {
                    if (n.a()) {
                        this.f63562a.a("MediationWaterfallWinnerTracker", "Clearing previous winning ad: " + aVar);
                    }
                    this.f63563b.remove(adUnitId);
                } else if (n.a()) {
                    this.f63562a.a("MediationWaterfallWinnerTracker", "Previous winner not cleared for ad: " + feVar + " , since it could have already been updated with a new ad: " + aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(fe feVar) {
        this.f63565d.put(feVar.getAdUnitId(), feVar.R());
    }

    public void c(fe feVar) {
        a(feVar, null);
    }

    public String b(String str) {
        return (String) this.f63565d.get(str);
    }

    public a c(String str) {
        a aVar;
        synchronized (this.f63564c) {
            aVar = (a) this.f63563b.get(str);
        }
        return aVar;
    }

    public void a(fe feVar, fe feVar2) {
        synchronized (this.f63564c) {
            try {
                if (n.a()) {
                    this.f63562a.a("MediationWaterfallWinnerTracker", "Tracking winning ad: " + feVar);
                }
                a aVar = new a(feVar.B(), feVar.c(), feVar.getNetworkName());
                if (feVar2 != null) {
                    aVar.f63570d = feVar2.c();
                    aVar.f63571e = feVar2.getNetworkName();
                }
                this.f63563b.put(feVar.getAdUnitId(), aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f63566e.put(feVar.getAdUnitId(), feVar.R());
    }

    public String a(String str) {
        return (String) this.f63566e.get(str);
    }
}
