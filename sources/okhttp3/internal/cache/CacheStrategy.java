package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class CacheStrategy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f144291c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Request f144292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Response f144293b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean a(okhttp3.Response r5, okhttp3.Request r6) {
            /*
                r4 = this;
                java.lang.String r0 = "response"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "request"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                int r0 = r5.i()
                r1 = 200(0xc8, float:2.8E-43)
                r2 = 0
                if (r0 == r1) goto L65
                r1 = 410(0x19a, float:5.75E-43)
                if (r0 == r1) goto L65
                r1 = 414(0x19e, float:5.8E-43)
                if (r0 == r1) goto L65
                r1 = 501(0x1f5, float:7.02E-43)
                if (r0 == r1) goto L65
                r1 = 203(0xcb, float:2.84E-43)
                if (r0 == r1) goto L65
                r1 = 204(0xcc, float:2.86E-43)
                if (r0 == r1) goto L65
                r1 = 307(0x133, float:4.3E-43)
                if (r0 == r1) goto L3b
                r1 = 308(0x134, float:4.32E-43)
                if (r0 == r1) goto L65
                r1 = 404(0x194, float:5.66E-43)
                if (r0 == r1) goto L65
                r1 = 405(0x195, float:5.68E-43)
                if (r0 == r1) goto L65
                switch(r0) {
                    case 300: goto L65;
                    case 301: goto L65;
                    case 302: goto L3b;
                    default: goto L3a;
                }
            L3a:
                return r2
            L3b:
                java.lang.String r0 = "Expires"
                r1 = 2
                r3 = 0
                java.lang.String r0 = okhttp3.Response.n(r5, r0, r3, r1, r3)
                if (r0 != 0) goto L65
                okhttp3.CacheControl r0 = r5.b()
                int r0 = r0.d()
                r1 = -1
                if (r0 != r1) goto L65
                okhttp3.CacheControl r0 = r5.b()
                boolean r0 = r0.c()
                if (r0 != 0) goto L65
                okhttp3.CacheControl r0 = r5.b()
                boolean r0 = r0.b()
                if (r0 != 0) goto L65
                return r2
            L65:
                okhttp3.CacheControl r5 = r5.b()
                boolean r5 = r5.i()
                if (r5 != 0) goto L7b
                okhttp3.CacheControl r5 = r6.b()
                boolean r5 = r5.i()
                if (r5 != 0) goto L7b
                r5 = 1
                return r5
            L7b:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheStrategy.Companion.a(okhttp3.Response, okhttp3.Request):boolean");
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f144294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Request f144295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Response f144296c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Date f144297d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f144298e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Date f144299f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f144300g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Date f144301h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f144302i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f144303j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f144304k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f144305l;

        public Factory(long j3, Request request, Response response) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.f144294a = j3;
            this.f144295b = request;
            this.f144296c = response;
            this.f144305l = -1;
            if (response != null) {
                this.f144302i = response.O();
                this.f144303j = response.M();
                Headers headersR = response.r();
                int size = headersR.size();
                int i3 = 0;
                while (i3 < size) {
                    int i4 = i3 + 1;
                    String strD = headersR.d(i3);
                    String strH = headersR.h(i3);
                    if (StringsKt.F(strD, "Date", true)) {
                        this.f144297d = DatesKt.a(strH);
                        this.f144298e = strH;
                    } else if (StringsKt.F(strD, "Expires", true)) {
                        this.f144301h = DatesKt.a(strH);
                    } else if (StringsKt.F(strD, "Last-Modified", true)) {
                        this.f144299f = DatesKt.a(strH);
                        this.f144300g = strH;
                    } else if (StringsKt.F(strD, "ETag", true)) {
                        this.f144304k = strH;
                    } else if (StringsKt.F(strD, "Age", true)) {
                        this.f144305l = Util.Y(strH, -1);
                    }
                    i3 = i4;
                }
            }
        }

        private final long a() {
            Date date = this.f144297d;
            long jMax = date != null ? Math.max(0L, this.f144303j - date.getTime()) : 0L;
            int i3 = this.f144305l;
            if (i3 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i3));
            }
            long j3 = this.f144303j;
            return jMax + (j3 - this.f144302i) + (this.f144294a - j3);
        }

        private final CacheStrategy c() {
            String str;
            if (this.f144296c == null) {
                return new CacheStrategy(this.f144295b, null);
            }
            if (this.f144295b.g() && this.f144296c.k() == null) {
                return new CacheStrategy(this.f144295b, null);
            }
            if (!CacheStrategy.f144291c.a(this.f144296c, this.f144295b)) {
                return new CacheStrategy(this.f144295b, null);
            }
            CacheControl cacheControlB = this.f144295b.b();
            if (cacheControlB.h() || e(this.f144295b)) {
                return new CacheStrategy(this.f144295b, null);
            }
            CacheControl cacheControlB2 = this.f144296c.b();
            long jA = a();
            long jD = d();
            if (cacheControlB.d() != -1) {
                jD = Math.min(jD, TimeUnit.SECONDS.toMillis(cacheControlB.d()));
            }
            long millis = 0;
            long millis2 = cacheControlB.f() != -1 ? TimeUnit.SECONDS.toMillis(cacheControlB.f()) : 0L;
            if (!cacheControlB2.g() && cacheControlB.e() != -1) {
                millis = TimeUnit.SECONDS.toMillis(cacheControlB.e());
            }
            if (!cacheControlB2.h()) {
                long j3 = millis2 + jA;
                if (j3 < millis + jD) {
                    Response.Builder builderF = this.f144296c.F();
                    if (j3 >= jD) {
                        builderF.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jA > 86400000 && f()) {
                        builderF.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy(null, builderF.c());
                }
            }
            String str2 = this.f144304k;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.f144299f != null) {
                    str2 = this.f144300g;
                } else {
                    if (this.f144297d == null) {
                        return new CacheStrategy(this.f144295b, null);
                    }
                    str2 = this.f144298e;
                }
                str = "If-Modified-Since";
            }
            Headers.Builder builderF2 = this.f144295b.f().f();
            Intrinsics.checkNotNull(str2);
            builderF2.d(str, str2);
            return new CacheStrategy(this.f144295b.i().g(builderF2.f()).b(), this.f144296c);
        }

        private final long d() {
            Long lValueOf;
            Response response = this.f144296c;
            Intrinsics.checkNotNull(response);
            if (response.b().d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.d());
            }
            Date date = this.f144301h;
            if (date != null) {
                Date date2 = this.f144297d;
                lValueOf = date2 != null ? Long.valueOf(date2.getTime()) : null;
                long time = date.getTime() - (lValueOf == null ? this.f144303j : lValueOf.longValue());
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f144299f != null && this.f144296c.N().k().o() == null) {
                Date date3 = this.f144297d;
                lValueOf = date3 != null ? Long.valueOf(date3.getTime()) : null;
                long jLongValue = lValueOf == null ? this.f144302i : lValueOf.longValue();
                Date date4 = this.f144299f;
                Intrinsics.checkNotNull(date4);
                long time2 = jLongValue - date4.getTime();
                if (time2 > 0) {
                    return time2 / ((long) 10);
                }
            }
            return 0L;
        }

        private final boolean e(Request request) {
            return (request.d("If-Modified-Since") == null && request.d("If-None-Match") == null) ? false : true;
        }

        private final boolean f() {
            Response response = this.f144296c;
            Intrinsics.checkNotNull(response);
            return response.b().d() == -1 && this.f144301h == null;
        }

        public final CacheStrategy b() {
            CacheStrategy cacheStrategyC = c();
            return (cacheStrategyC.b() == null || !this.f144295b.b().k()) ? cacheStrategyC : new CacheStrategy(null, null);
        }
    }

    public CacheStrategy(Request request, Response response) {
        this.f144292a = request;
        this.f144293b = response;
    }

    public final Response a() {
        return this.f144293b;
    }

    public final Request b() {
        return this.f144292a;
    }
}
