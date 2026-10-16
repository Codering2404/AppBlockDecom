package okhttp3.logging;

import com.facebook.GraphRequest;
import com.facebook.stetho.server.http.HttpHeaders;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

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
public final class HttpLoggingInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Set f144952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Level f144953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Logger f144954c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Logger {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f144961b = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Logger f144960a = new Companion.DefaultLogger();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            private static final class DefaultLogger implements Logger {
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void a(String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    Platform.l(Platform.f144818a.g(), message, 0, null, 6, null);
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        void a(String str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final boolean b(Headers headers) {
        String strA = headers.a(GraphRequest.CONTENT_ENCODING_HEADER);
        return (strA == null || StringsKt.F(strA, "identity", true) || StringsKt.F(strA, "gzip", true)) ? false : true;
    }

    private final void c(Headers headers, int i3) {
        String strH = this.f144952a.contains(headers.d(i3)) ? "██" : headers.h(i3);
        this.f144954c.a(headers.d(i3) + ": " + strH);
    }

    @Override // okhttp3.Interceptor
    public Response a(Interceptor.Chain chain) throws Exception {
        char c3;
        long j3;
        ResponseBody responseBody;
        boolean z2;
        String string;
        Charset UTF_8;
        Charset UTF_82;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Level level = this.f144953b;
        Request requestL = chain.l();
        if (level == Level.NONE) {
            return chain.a(requestL);
        }
        boolean z3 = level == Level.BODY;
        boolean z4 = z3 || level == Level.HEADERS;
        RequestBody requestBodyA = requestL.a();
        Connection connectionB = chain.b();
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(requestL.h());
        sb.append(' ');
        sb.append(requestL.k());
        sb.append(connectionB != null ? " " + connectionB.a() : "");
        String string2 = sb.toString();
        if (!z4 && requestBodyA != null) {
            string2 = string2 + " (" + requestBodyA.a() + "-byte body)";
        }
        this.f144954c.a(string2);
        if (z4) {
            Headers headersF = requestL.f();
            if (requestBodyA != null) {
                j3 = -1;
                MediaType mediaTypeB = requestBodyA.b();
                if (mediaTypeB == null || headersF.a("Content-Type") != null) {
                    c3 = ' ';
                } else {
                    Logger logger = this.f144954c;
                    StringBuilder sb2 = new StringBuilder();
                    c3 = ' ';
                    sb2.append("Content-Type: ");
                    sb2.append(mediaTypeB);
                    logger.a(sb2.toString());
                }
                if (requestBodyA.a() != -1 && headersF.a(HttpHeaders.CONTENT_LENGTH) == null) {
                    this.f144954c.a("Content-Length: " + requestBodyA.a());
                }
            } else {
                c3 = ' ';
                j3 = -1;
            }
            int size = headersF.size();
            for (int i3 = 0; i3 < size; i3++) {
                c(headersF, i3);
            }
            if (!z3 || requestBodyA == null) {
                this.f144954c.a("--> END " + requestL.h());
            } else if (b(requestL.f())) {
                this.f144954c.a("--> END " + requestL.h() + " (encoded body omitted)");
            } else if (requestBodyA.e()) {
                this.f144954c.a("--> END " + requestL.h() + " (duplex request body omitted)");
            } else if (requestBodyA.f()) {
                this.f144954c.a("--> END " + requestL.h() + " (one-shot body omitted)");
            } else {
                Buffer buffer = new Buffer();
                requestBodyA.g(buffer);
                MediaType mediaTypeB2 = requestBodyA.b();
                if (mediaTypeB2 == null || (UTF_82 = mediaTypeB2.c(StandardCharsets.UTF_8)) == null) {
                    UTF_82 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
                }
                this.f144954c.a("");
                if (Utf8Kt.a(buffer)) {
                    this.f144954c.a(buffer.Z1(UTF_82));
                    this.f144954c.a("--> END " + requestL.h() + " (" + requestBodyA.a() + "-byte body)");
                } else {
                    this.f144954c.a("--> END " + requestL.h() + " (binary " + requestBodyA.a() + "-byte body omitted)");
                }
            }
        } else {
            c3 = ' ';
            j3 = -1;
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseA = chain.a(requestL);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBodyA = responseA.a();
            Intrinsics.checkNotNull(responseBodyA);
            long jF = responseBodyA.f();
            String str = jF != j3 ? jF + "-byte" : "unknown-length";
            Logger logger2 = this.f144954c;
            StringBuilder sb3 = new StringBuilder();
            boolean z5 = z4;
            sb3.append("<-- ");
            sb3.append(responseA.i());
            if (responseA.z().length() == 0) {
                responseBody = responseBodyA;
                z2 = z3;
                string = "";
            } else {
                String strZ = responseA.z();
                responseBody = responseBodyA;
                StringBuilder sb4 = new StringBuilder();
                z2 = z3;
                sb4.append(String.valueOf(c3));
                sb4.append(strZ);
                string = sb4.toString();
            }
            sb3.append(string);
            sb3.append(c3);
            sb3.append(responseA.N().k());
            sb3.append(" (");
            sb3.append(millis);
            sb3.append("ms");
            sb3.append(z5 ? "" : ", " + str + " body");
            sb3.append(')');
            logger2.a(sb3.toString());
            if (z5) {
                Headers headersR = responseA.r();
                int size2 = headersR.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    c(headersR, i4);
                }
                if (z2 && okhttp3.internal.http.HttpHeaders.b(responseA)) {
                    if (b(responseA.r())) {
                        this.f144954c.a("<-- END HTTP (encoded body omitted)");
                        return responseA;
                    }
                    BufferedSource bufferedSourceK = responseBody.k();
                    bufferedSourceK.y(Long.MAX_VALUE);
                    Buffer bufferU = bufferedSourceK.u();
                    Long l3 = null;
                    if (StringsKt.F("gzip", headersR.a(GraphRequest.CONTENT_ENCODING_HEADER), true)) {
                        Long lValueOf = Long.valueOf(bufferU.size());
                        GzipSource gzipSource = new GzipSource(bufferU.clone());
                        try {
                            bufferU = new Buffer();
                            bufferU.K0(gzipSource);
                            CloseableKt.a(gzipSource, null);
                            l3 = lValueOf;
                        } finally {
                        }
                    }
                    MediaType mediaTypeI = responseBody.i();
                    if (mediaTypeI == null || (UTF_8 = mediaTypeI.c(StandardCharsets.UTF_8)) == null) {
                        UTF_8 = StandardCharsets.UTF_8;
                        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                    }
                    if (!Utf8Kt.a(bufferU)) {
                        this.f144954c.a("");
                        this.f144954c.a("<-- END HTTP (binary " + bufferU.size() + "-byte body omitted)");
                        return responseA;
                    }
                    if (jF != 0) {
                        this.f144954c.a("");
                        this.f144954c.a(bufferU.clone().Z1(UTF_8));
                    }
                    if (l3 == null) {
                        this.f144954c.a("<-- END HTTP (" + bufferU.size() + "-byte body)");
                        return responseA;
                    }
                    this.f144954c.a("<-- END HTTP (" + bufferU.size() + "-byte, " + l3 + "-gzipped-byte body)");
                    return responseA;
                }
                this.f144954c.a("<-- END HTTP");
            }
            return responseA;
        } catch (Exception e3) {
            this.f144954c.a("<-- HTTP FAILED: " + e3);
            throw e3;
        }
    }

    public final HttpLoggingInterceptor d(Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        this.f144953b = level;
        return this;
    }

    public HttpLoggingInterceptor(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f144954c = logger;
        this.f144952a = SetsKt.emptySet();
        this.f144953b = Level.NONE;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Logger.f144960a : logger);
    }
}
