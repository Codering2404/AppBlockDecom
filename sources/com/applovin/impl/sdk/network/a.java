package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sj;
import com.applovin.impl.vi;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f63477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f63478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map f63479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map f63480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final JSONObject f63481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f63482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f63483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f63484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f63485i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f63486j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f63487k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f63488l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f63489m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f63490n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f63491o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final vi.a f63492p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f63493q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f63494r;

    /* JADX INFO: renamed from: com.applovin.impl.sdk.network.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class C0125a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f63495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f63496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f63497c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Map f63499e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        JSONObject f63500f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f63501g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f63503i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f63504j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f63505k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f63507m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f63508n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f63509o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        boolean f63510p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        vi.a f63511q;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f63502h = 1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f63506l = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Map f63498d = new HashMap();

        public C0125a(j jVar) {
            this.f63503i = ((Integer) jVar.a(sj.U2)).intValue();
            this.f63504j = ((Integer) jVar.a(sj.T2)).intValue();
            this.f63507m = ((Boolean) jVar.a(sj.r3)).booleanValue();
            this.f63508n = ((Boolean) jVar.a(sj.a5)).booleanValue();
            this.f63511q = vi.a.a(((Integer) jVar.a(sj.b5)).intValue());
            this.f63510p = ((Boolean) jVar.a(sj.y5)).booleanValue();
        }

        public C0125a a(vi.a aVar) {
            this.f63511q = aVar;
            return this;
        }

        public C0125a b(String str) {
            this.f63496b = str;
            return this;
        }

        public C0125a c(String str) {
            this.f63495a = str;
            return this;
        }

        public C0125a d(boolean z2) {
            this.f63506l = z2;
            return this;
        }

        public C0125a e(boolean z2) {
            this.f63507m = z2;
            return this;
        }

        public C0125a f(boolean z2) {
            this.f63509o = z2;
            return this;
        }

        public C0125a a(Map map) {
            this.f63499e = map;
            return this;
        }

        public C0125a b(Map map) {
            this.f63498d = map;
            return this;
        }

        public C0125a c(int i3) {
            this.f63503i = i3;
            return this;
        }

        public C0125a a(JSONObject jSONObject) {
            this.f63500f = jSONObject;
            return this;
        }

        public C0125a b(int i3) {
            this.f63504j = i3;
            return this;
        }

        public C0125a c(boolean z2) {
            this.f63505k = z2;
            return this;
        }

        public C0125a a(String str) {
            this.f63497c = str;
            return this;
        }

        public C0125a b(boolean z2) {
            this.f63510p = z2;
            return this;
        }

        public C0125a a(Object obj) {
            this.f63501g = obj;
            return this;
        }

        public C0125a a(int i3) {
            this.f63502h = i3;
            return this;
        }

        public C0125a a(boolean z2) {
            this.f63508n = z2;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    protected a(C0125a c0125a) {
        this.f63477a = c0125a.f63496b;
        this.f63478b = c0125a.f63495a;
        this.f63479c = c0125a.f63498d;
        this.f63480d = c0125a.f63499e;
        this.f63481e = c0125a.f63500f;
        this.f63482f = c0125a.f63497c;
        this.f63483g = c0125a.f63501g;
        int i3 = c0125a.f63502h;
        this.f63484h = i3;
        this.f63485i = i3;
        this.f63486j = c0125a.f63503i;
        this.f63487k = c0125a.f63504j;
        this.f63488l = c0125a.f63505k;
        this.f63489m = c0125a.f63506l;
        this.f63490n = c0125a.f63507m;
        this.f63491o = c0125a.f63508n;
        this.f63492p = c0125a.f63511q;
        this.f63493q = c0125a.f63509o;
        this.f63494r = c0125a.f63510p;
    }

    public void a(String str) {
        this.f63477a = str;
    }

    public void b(String str) {
        this.f63478b = str;
    }

    public int c() {
        return this.f63484h - this.f63485i;
    }

    public Object d() {
        return this.f63483g;
    }

    public vi.a e() {
        return this.f63492p;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f63477a;
        if (str == null ? aVar.f63477a != null : !str.equals(aVar.f63477a)) {
            return false;
        }
        Map map = this.f63479c;
        if (map == null ? aVar.f63479c != null : !map.equals(aVar.f63479c)) {
            return false;
        }
        Map map2 = this.f63480d;
        if (map2 == null ? aVar.f63480d != null : !map2.equals(aVar.f63480d)) {
            return false;
        }
        String str2 = this.f63482f;
        if (str2 == null ? aVar.f63482f != null : !str2.equals(aVar.f63482f)) {
            return false;
        }
        String str3 = this.f63478b;
        if (str3 == null ? aVar.f63478b != null : !str3.equals(aVar.f63478b)) {
            return false;
        }
        JSONObject jSONObject = this.f63481e;
        if (jSONObject == null ? aVar.f63481e != null : !jSONObject.equals(aVar.f63481e)) {
            return false;
        }
        Object obj2 = this.f63483g;
        if (obj2 == null ? aVar.f63483g == null : obj2.equals(aVar.f63483g)) {
            return this.f63484h == aVar.f63484h && this.f63485i == aVar.f63485i && this.f63486j == aVar.f63486j && this.f63487k == aVar.f63487k && this.f63488l == aVar.f63488l && this.f63489m == aVar.f63489m && this.f63490n == aVar.f63490n && this.f63491o == aVar.f63491o && this.f63492p == aVar.f63492p && this.f63493q == aVar.f63493q && this.f63494r == aVar.f63494r;
        }
        return false;
    }

    public String f() {
        return this.f63477a;
    }

    public Map g() {
        return this.f63480d;
    }

    public String h() {
        return this.f63478b;
    }

    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.f63477a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f63482f;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f63478b;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Object obj = this.f63483g;
        int iHashCode5 = ((((((((((((((((((((((iHashCode4 + (obj != null ? obj.hashCode() : 0)) * 31) + this.f63484h) * 31) + this.f63485i) * 31) + this.f63486j) * 31) + this.f63487k) * 31) + (this.f63488l ? 1 : 0)) * 31) + (this.f63489m ? 1 : 0)) * 31) + (this.f63490n ? 1 : 0)) * 31) + (this.f63491o ? 1 : 0)) * 31) + this.f63492p.b()) * 31) + (this.f63493q ? 1 : 0)) * 31) + (this.f63494r ? 1 : 0);
        Map map = this.f63479c;
        if (map != null) {
            iHashCode5 = (iHashCode5 * 31) + map.hashCode();
        }
        Map map2 = this.f63480d;
        if (map2 != null) {
            iHashCode5 = (iHashCode5 * 31) + map2.hashCode();
        }
        JSONObject jSONObject = this.f63481e;
        if (jSONObject == null) {
            return iHashCode5;
        }
        char[] charArray = jSONObject.toString().toCharArray();
        Arrays.sort(charArray);
        return (iHashCode5 * 31) + new String(charArray).hashCode();
    }

    public Map i() {
        return this.f63479c;
    }

    public int j() {
        return this.f63485i;
    }

    public int k() {
        return this.f63487k;
    }

    public int l() {
        return this.f63486j;
    }

    public boolean m() {
        return this.f63491o;
    }

    public boolean n() {
        return this.f63488l;
    }

    public boolean o() {
        return this.f63494r;
    }

    public boolean p() {
        return this.f63489m;
    }

    public boolean q() {
        return this.f63490n;
    }

    public boolean r() {
        return this.f63493q;
    }

    public String toString() {
        return "HttpRequest {endpoint=" + this.f63477a + ", backupEndpoint=" + this.f63482f + ", httpMethod=" + this.f63478b + ", httpHeaders=" + this.f63480d + ", body=" + this.f63481e + ", emptyResponse=" + this.f63483g + ", initialRetryAttempts=" + this.f63484h + ", retryAttemptsLeft=" + this.f63485i + ", timeoutMillis=" + this.f63486j + ", retryDelayMillis=" + this.f63487k + ", exponentialRetries=" + this.f63488l + ", retryOnAllErrors=" + this.f63489m + ", retryOnNoConnection=" + this.f63490n + ", encodingEnabled=" + this.f63491o + ", encodingType=" + this.f63492p + ", trackConnectionSpeed=" + this.f63493q + ", gzipBodyEncoding=" + this.f63494r + '}';
    }

    public String a() {
        return this.f63482f;
    }

    public JSONObject b() {
        return this.f63481e;
    }

    public void a(int i3) {
        this.f63485i = i3;
    }

    public static C0125a a(j jVar) {
        return new C0125a(jVar);
    }
}
