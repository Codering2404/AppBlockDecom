package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class CacheStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Request f93311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Response f93312b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f93313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Request f93314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Response f93315c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Date f93316d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f93317e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Date f93318f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f93319g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Date f93320h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f93321i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f93322j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f93323k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f93324l;

        public Factory(long j3, Request request, Response response) {
            this.f93324l = -1;
            this.f93313a = j3;
            this.f93314b = request;
            this.f93315c = response;
            if (response != null) {
                Headers headersR = response.r();
                int iF = headersR.f();
                for (int i3 = 0; i3 < iF; i3++) {
                    String strD = headersR.d(i3);
                    String strG = headersR.g(i3);
                    if ("Date".equalsIgnoreCase(strD)) {
                        this.f93316d = HttpDate.b(strG);
                        this.f93317e = strG;
                    } else if ("Expires".equalsIgnoreCase(strD)) {
                        this.f93320h = HttpDate.b(strG);
                    } else if ("Last-Modified".equalsIgnoreCase(strD)) {
                        this.f93318f = HttpDate.b(strG);
                        this.f93319g = strG;
                    } else if ("ETag".equalsIgnoreCase(strD)) {
                        this.f93323k = strG;
                    } else if ("Age".equalsIgnoreCase(strD)) {
                        this.f93324l = HeaderParser.a(strG, -1);
                    } else if (OkHeaders.f93398c.equalsIgnoreCase(strD)) {
                        this.f93321i = Long.parseLong(strG);
                    } else if (OkHeaders.f93399d.equalsIgnoreCase(strD)) {
                        this.f93322j = Long.parseLong(strG);
                    }
                }
            }
        }

        private long a() {
            Date date = this.f93316d;
            long jMax = date != null ? Math.max(0L, this.f93322j - date.getTime()) : 0L;
            int i3 = this.f93324l;
            if (i3 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i3));
            }
            long j3 = this.f93322j;
            return jMax + (j3 - this.f93321i) + (this.f93313a - j3);
        }

        private long b() {
            if (this.f93315c.l().d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.d());
            }
            if (this.f93320h != null) {
                Date date = this.f93316d;
                long time = this.f93320h.getTime() - (date != null ? date.getTime() : this.f93322j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f93318f != null && this.f93315c.w().k().B() == null) {
                Date date2 = this.f93316d;
                long time2 = (date2 != null ? date2.getTime() : this.f93321i) - this.f93318f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private CacheStrategy d() {
            Response response = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            Object[] objArr7 = 0;
            Object[] objArr8 = 0;
            Object[] objArr9 = 0;
            Object[] objArr10 = 0;
            Object[] objArr11 = 0;
            Object[] objArr12 = 0;
            if (this.f93315c == null) {
                return new CacheStrategy(this.f93314b, response);
            }
            if (this.f93314b.l() && this.f93315c.o() == null) {
                return new CacheStrategy(this.f93314b, objArr11 == true ? 1 : 0);
            }
            if (!CacheStrategy.a(this.f93315c, this.f93314b)) {
                return new CacheStrategy(this.f93314b, objArr9 == true ? 1 : 0);
            }
            CacheControl cacheControlG = this.f93314b.g();
            if (cacheControlG.h() || e(this.f93314b)) {
                return new CacheStrategy(this.f93314b, objArr2 == true ? 1 : 0);
            }
            long jA = a();
            long jB = b();
            if (cacheControlG.d() != -1) {
                jB = Math.min(jB, TimeUnit.SECONDS.toMillis(cacheControlG.d()));
            }
            long millis = 0;
            long millis2 = cacheControlG.f() != -1 ? TimeUnit.SECONDS.toMillis(cacheControlG.f()) : 0L;
            CacheControl cacheControlL = this.f93315c.l();
            if (!cacheControlL.g() && cacheControlG.e() != -1) {
                millis = TimeUnit.SECONDS.toMillis(cacheControlG.e());
            }
            if (!cacheControlL.h()) {
                long j3 = millis2 + jA;
                if (j3 < millis + jB) {
                    Response.Builder builderU = this.f93315c.u();
                    if (j3 >= jB) {
                        builderU.k("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jA > 86400000 && f()) {
                        builderU.k("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy(objArr7 == true ? 1 : 0, builderU.m());
                }
            }
            Request.Builder builderN = this.f93314b.n();
            String str = this.f93323k;
            if (str != null) {
                builderN.h("If-None-Match", str);
            } else if (this.f93318f != null) {
                builderN.h("If-Modified-Since", this.f93319g);
            } else if (this.f93316d != null) {
                builderN.h("If-Modified-Since", this.f93317e);
            }
            Request requestG = builderN.g();
            return e(requestG) ? new CacheStrategy(requestG, this.f93315c) : new CacheStrategy(requestG, objArr4 == true ? 1 : 0);
        }

        private static boolean e(Request request) {
            return (request.h("If-Modified-Since") == null && request.h("If-None-Match") == null) ? false : true;
        }

        private boolean f() {
            return this.f93315c.l().d() == -1 && this.f93320h == null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CacheStrategy c() {
            CacheStrategy cacheStrategyD = d();
            return (cacheStrategyD.f93311a == null || !this.f93314b.g().j()) ? cacheStrategyD : new CacheStrategy(null, 0 == true ? 1 : 0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.l().b() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.squareup.okhttp.Response r3, com.squareup.okhttp.Request r4) {
        /*
            int r0 = r3.n()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.p(r0)
            if (r0 != 0) goto L5a
            com.squareup.okhttp.CacheControl r0 = r3.l()
            int r0 = r0.d()
            r1 = -1
            if (r0 != r1) goto L5a
            com.squareup.okhttp.CacheControl r0 = r3.l()
            boolean r0 = r0.c()
            if (r0 != 0) goto L5a
            com.squareup.okhttp.CacheControl r0 = r3.l()
            boolean r0 = r0.b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            com.squareup.okhttp.CacheControl r3 = r3.l()
            boolean r3 = r3.i()
            if (r3 != 0) goto L70
            com.squareup.okhttp.CacheControl r3 = r4.g()
            boolean r3 = r3.i()
            if (r3 != 0) goto L70
            r3 = 1
            return r3
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.http.CacheStrategy.a(com.squareup.okhttp.Response, com.squareup.okhttp.Request):boolean");
    }

    private CacheStrategy(Request request, Response response) {
        this.f93311a = request;
        this.f93312b = response;
    }
}
