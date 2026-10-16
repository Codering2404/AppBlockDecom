package coil.network;

import coil.util.Time;
import coil.util.Utils;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.server.http.HttpHeaders;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CacheStrategy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f55984c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Request f55985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CacheResponse f55986b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean d(String str) {
            return StringsKt.F(HttpHeaders.CONTENT_LENGTH, str, true) || StringsKt.F(GraphRequest.CONTENT_ENCODING_HEADER, str, true) || StringsKt.F("Content-Type", str, true);
        }

        private final boolean e(String str) {
            return (StringsKt.F("Connection", str, true) || StringsKt.F("Keep-Alive", str, true) || StringsKt.F("Proxy-Authenticate", str, true) || StringsKt.F("Proxy-Authorization", str, true) || StringsKt.F("TE", str, true) || StringsKt.F("Trailers", str, true) || StringsKt.F("Transfer-Encoding", str, true) || StringsKt.F("Upgrade", str, true)) ? false : true;
        }

        public final Headers a(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i3 = 0; i3 < size; i3++) {
                String strD = headers.d(i3);
                String strH = headers.h(i3);
                if ((!StringsKt.F("Warning", strD, true) || !StringsKt.U(strH, AppEventsConstants.EVENT_PARAM_VALUE_YES, false, 2, null)) && (d(strD) || !e(strD) || headers2.a(strD) == null)) {
                    builder.a(strD, strH);
                }
            }
            int size2 = headers2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                String strD2 = headers2.d(i4);
                if (!d(strD2) && e(strD2)) {
                    builder.a(strD2, headers2.h(i4));
                }
            }
            return builder.f();
        }

        public final boolean b(Request request, CacheResponse cacheResponse) {
            return (request.b().i() || cacheResponse.a().i() || Intrinsics.areEqual(cacheResponse.d().a("Vary"), "*")) ? false : true;
        }

        public final boolean c(Request request, Response response) {
            return (request.b().i() || response.b().i() || Intrinsics.areEqual(response.r().a("Vary"), "*")) ? false : true;
        }

        private Companion() {
        }
    }

    public /* synthetic */ CacheStrategy(Request request, CacheResponse cacheResponse, DefaultConstructorMarker defaultConstructorMarker) {
        this(request, cacheResponse);
    }

    public final CacheResponse a() {
        return this.f55986b;
    }

    public final Request b() {
        return this.f55985a;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Request f55987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CacheResponse f55988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Date f55989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f55990d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Date f55991e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f55992f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Date f55993g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f55994h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f55995i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f55996j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f55997k;

        private final long a() {
            Date date = this.f55989c;
            long jMax = date != null ? Math.max(0L, this.f55995i - date.getTime()) : 0L;
            int i3 = this.f55997k;
            if (i3 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i3));
            }
            return jMax + (this.f55995i - this.f55994h) + (Time.f56248a.a() - this.f55995i);
        }

        private final long c() {
            CacheResponse cacheResponse = this.f55988b;
            Intrinsics.checkNotNull(cacheResponse);
            if (cacheResponse.a().d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.d());
            }
            Date date = this.f55993g;
            if (date != null) {
                Date date2 = this.f55989c;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.f55995i);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f55991e != null && this.f55987a.k().o() == null) {
                Date date3 = this.f55989c;
                long time2 = date3 != null ? date3.getTime() : this.f55994h;
                Date date4 = this.f55991e;
                Intrinsics.checkNotNull(date4);
                long time3 = time2 - date4.getTime();
                if (time3 > 0) {
                    return time3 / ((long) 10);
                }
            }
            return 0L;
        }

        private final boolean d(Request request) {
            return (request.d("If-Modified-Since") == null && request.d("If-None-Match") == null) ? false : true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CacheStrategy b() {
            String str;
            CacheResponse cacheResponse = null;
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
            if (this.f55988b == null) {
                return new CacheStrategy(this.f55987a, cacheResponse, objArr12 == true ? 1 : 0);
            }
            if (this.f55987a.g() && !this.f55988b.f()) {
                return new CacheStrategy(this.f55987a, objArr11 == true ? 1 : 0, objArr10 == true ? 1 : 0);
            }
            CacheControl cacheControlA = this.f55988b.a();
            if (!CacheStrategy.f55984c.b(this.f55987a, this.f55988b)) {
                return new CacheStrategy(this.f55987a, objArr9 == true ? 1 : 0, objArr8 == true ? 1 : 0);
            }
            CacheControl cacheControlB = this.f55987a.b();
            if (cacheControlB.h() || d(this.f55987a)) {
                return new CacheStrategy(this.f55987a, objArr2 == true ? 1 : 0, objArr == true ? 1 : 0);
            }
            long jA = a();
            long jC = c();
            if (cacheControlB.d() != -1) {
                jC = Math.min(jC, TimeUnit.SECONDS.toMillis(cacheControlB.d()));
            }
            long millis = 0;
            long millis2 = cacheControlB.f() != -1 ? TimeUnit.SECONDS.toMillis(cacheControlB.f()) : 0L;
            if (!cacheControlA.g() && cacheControlB.e() != -1) {
                millis = TimeUnit.SECONDS.toMillis(cacheControlB.e());
            }
            if (!cacheControlA.h() && jA + millis2 < jC + millis) {
                return new CacheStrategy(objArr7 == true ? 1 : 0, this.f55988b, objArr6 == true ? 1 : 0);
            }
            String str2 = this.f55996j;
            if (str2 != null) {
                Intrinsics.checkNotNull(str2);
                str = "If-None-Match";
            } else {
                str = "If-Modified-Since";
                if (this.f55991e != null) {
                    str2 = this.f55992f;
                    Intrinsics.checkNotNull(str2);
                } else {
                    if (this.f55989c == null) {
                        return new CacheStrategy(this.f55987a, objArr4 == true ? 1 : 0, objArr3 == true ? 1 : 0);
                    }
                    str2 = this.f55990d;
                    Intrinsics.checkNotNull(str2);
                }
            }
            return new CacheStrategy(this.f55987a.i().a(str, str2).b(), this.f55988b, objArr5 == true ? 1 : 0);
        }

        public Factory(Request request, CacheResponse cacheResponse) {
            this.f55987a = request;
            this.f55988b = cacheResponse;
            this.f55997k = -1;
            if (cacheResponse != null) {
                this.f55994h = cacheResponse.e();
                this.f55995i = cacheResponse.c();
                Headers headersD = cacheResponse.d();
                int size = headersD.size();
                for (int i3 = 0; i3 < size; i3++) {
                    String strD = headersD.d(i3);
                    if (StringsKt.F(strD, "Date", true)) {
                        this.f55989c = headersD.b("Date");
                        this.f55990d = headersD.h(i3);
                    } else {
                        String str = FptyjHFU.ipplSllFsD;
                        if (StringsKt.F(strD, str, true)) {
                            this.f55993g = headersD.b(str);
                        } else if (StringsKt.F(strD, "Last-Modified", true)) {
                            this.f55991e = headersD.b("Last-Modified");
                            this.f55992f = headersD.h(i3);
                        } else if (StringsKt.F(strD, "ETag", true)) {
                            this.f55996j = headersD.h(i3);
                        } else if (StringsKt.F(strD, "Age", true)) {
                            this.f55997k = Utils.A(headersD.h(i3), -1);
                        }
                    }
                }
            }
        }
    }

    private CacheStrategy(Request request, CacheResponse cacheResponse) {
        this.f55985a = request;
        this.f55986b = cacheResponse;
    }
}
