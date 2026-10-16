package cz.mobilesoft.coreblock.rest.interceptor;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import cz.mobilesoft.coreblock.rest.interceptor.LogSanitizer;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Interceptor;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ErrorLogInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f98518a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set f98519b = SetsKt.setOf((Object[]) new Integer[]{Integer.valueOf(RCHTTPStatusCodes.UNAUTHORIZED), Integer.valueOf(RCHTTPStatusCodes.FORBIDDEN), 404});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicLong f98520c = new AtomicLong(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final CoroutineScope f98521d = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ApiCallFailedException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApiCallFailedException(String message, Throwable th) {
            super(message, th);
            Intrinsics.checkNotNullParameter(message, "message");
        }

        public /* synthetic */ ApiCallFailedException(String str, Throwable th, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ApiErrorDetails {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Integer f98522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f98523b;

        public ApiErrorDetails(Integer num, String str) {
            this.f98522a = num;
            this.f98523b = str;
        }

        public final Integer a() {
            return this.f98522a;
        }

        public final String b() {
            return this.f98523b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ApiErrorDetails)) {
                return false;
            }
            ApiErrorDetails apiErrorDetails = (ApiErrorDetails) obj;
            return Intrinsics.areEqual(this.f98522a, apiErrorDetails.f98522a) && Intrinsics.areEqual(this.f98523b, apiErrorDetails.f98523b);
        }

        public int hashCode() {
            Integer num = this.f98522a;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.f98523b;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "ApiErrorDetails(code=" + this.f98522a + ", message=" + this.f98523b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void b(ApiCallLog apiCallLog, boolean z2, Function3 function3) {
        BuildersKt__Builders_commonKt.d(f98521d, null, null, new ErrorLogInterceptor$onCallFailed$1(apiCallLog.d(), z2 ? TuplesKt.a(apiCallLog.c(), ErrorLogStore.f98544a.d(apiCallLog.e())) : null, function3, null), 3, null);
    }

    private final void c(ApiCallLog apiCallLog, Exception exc) {
        ApiCallLog.b(apiCallLog, "<-- ERROR " + exc.getClass().getSimpleName() + " " + exc.getMessage(), null, 2, null);
    }

    private final void d(ApiCallLog apiCallLog, Request request, String str) {
        LogSanitizer logSanitizer = LogSanitizer.f98558a;
        LogSanitizer.BodyLog bodyLogH = logSanitizer.h(request);
        apiCallLog.a("--> " + request.h() + " " + str, "--> " + request.h() + " " + request.k());
        ApiCallLog.b(apiCallLog, "--> Headers: " + logSanitizer.i(request.f()), null, 2, null);
        apiCallLog.a("--> " + bodyLogH.a(), "--> " + bodyLogH.b());
    }

    private final void e(ApiCallLog apiCallLog, Response response, String str, ApiErrorDetails apiErrorDetails) {
        ApiCallLog.b(apiCallLog, "<-- " + response.i() + " " + response.z(), null, 2, null);
        ApiCallLog.b(apiCallLog, "<-- Headers: " + LogSanitizer.f98558a.i(response.r()), null, 2, null);
        String str2 = "<-- Server error details: " + apiErrorDetails;
        if (str == null) {
            str = "(No body)";
        }
        apiCallLog.a(str2, "<-- Body: " + str);
    }

    @Override // okhttp3.Interceptor
    public Response a(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request requestL = chain.l();
        LogSanitizer logSanitizer = LogSanitizer.f98558a;
        String strE = logSanitizer.e(requestL);
        if (strE == null) {
            strE = "unknown url";
        }
        String str = strE;
        ApiCallLog apiCallLog = new ApiCallLog(f98520c.incrementAndGet());
        d(apiCallLog, requestL, str);
        try {
            Response responseA = chain.a(requestL);
            String strG = logSanitizer.g(responseA);
            ApiErrorDetails apiErrorDetailsD = logSanitizer.d(strG);
            e(apiCallLog, responseA, strG, apiErrorDetailsD);
            if (responseA.isSuccessful()) {
                return responseA;
            }
            b(apiCallLog, !f98519b.contains(Integer.valueOf(r3)), new ErrorLogInterceptor$intercept$1(str, responseA.i(), requestL, apiErrorDetailsD, null));
            return responseA;
        } catch (IOException e3) {
            c(apiCallLog, e3);
            b(apiCallLog, !(e3 instanceof UnknownHostException), new ErrorLogInterceptor$intercept$2(requestL, str, e3, null));
            throw e3;
        }
    }
}
