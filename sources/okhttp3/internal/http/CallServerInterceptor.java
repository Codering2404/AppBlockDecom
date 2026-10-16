package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.BufferedSink;
import okio.Okio;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class CallServerInterceptor implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f144513a;

    public CallServerInterceptor(boolean z2) {
        this.f144513a = z2;
    }

    private final boolean b(int i3) {
        if (i3 == 100) {
            return true;
        }
        return 102 <= i3 && i3 < 200;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object, okhttp3.Response$Builder] */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v4, types: [okhttp3.Response$Builder] */
    @Override // okhttp3.Interceptor
    public Response a(Interceptor.Chain chain) throws IOException {
        boolean z2;
        ?? r9;
        ?? R;
        Response.Builder builder;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchangeG = realInterceptorChain.g();
        Intrinsics.checkNotNull(exchangeG);
        Request requestI = realInterceptorChain.i();
        RequestBody requestBodyA = requestI.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long lValueOf = null;
        try {
            exchangeG.w(requestI);
            ?? B = HttpMethod.b(requestI.h());
            try {
                if (B == 0 || requestBodyA == null) {
                    exchangeG.p();
                    z2 = true;
                    B = 0;
                } else {
                    if (StringsKt.F("100-continue", requestI.d("Expect"), true)) {
                        exchangeG.f();
                        Response.Builder builderR = exchangeG.r(true);
                        try {
                            exchangeG.t();
                            z2 = false;
                            builder = builderR;
                        } catch (IOException e3) {
                            e = e3;
                            z2 = true;
                            r9 = builderR;
                            if (e instanceof ConnectionShutdownException) {
                                throw e;
                            }
                            R = r9;
                            if (!exchangeG.k()) {
                                throw e;
                            }
                        }
                    } else {
                        z2 = true;
                        builder = null;
                    }
                    if (builder != null) {
                        exchangeG.p();
                        B = builder;
                        if (!exchangeG.h().w()) {
                            exchangeG.o();
                            B = builder;
                        }
                    } else if (requestBodyA.e()) {
                        exchangeG.f();
                        requestBodyA.g(Okio.c(exchangeG.c(requestI, true)));
                        B = builder;
                    } else {
                        BufferedSink bufferedSinkC = Okio.c(exchangeG.c(requestI, false));
                        requestBodyA.g(bufferedSinkC);
                        bufferedSinkC.close();
                        B = builder;
                    }
                }
                if (requestBodyA == null || !requestBodyA.e()) {
                    exchangeG.e();
                }
                e = null;
                R = B;
            } catch (IOException e4) {
                e = e4;
                r9 = B;
            }
        } catch (IOException e5) {
            e = e5;
            z2 = true;
            r9 = 0;
        }
        if (R == 0) {
            try {
                R = exchangeG.r(false);
                Intrinsics.checkNotNull(R);
                if (z2) {
                    exchangeG.t();
                    z2 = false;
                }
            } catch (IOException e6) {
                if (e == null) {
                    throw e6;
                }
                ExceptionsKt.a(e, e6);
                throw e;
            }
        }
        Response responseC = R.s(requestI).j(exchangeG.h().s()).t(jCurrentTimeMillis).r(System.currentTimeMillis()).c();
        int i3 = responseC.i();
        if (b(i3)) {
            Response.Builder builderR2 = exchangeG.r(false);
            Intrinsics.checkNotNull(builderR2);
            if (z2) {
                exchangeG.t();
            }
            responseC = builderR2.s(requestI).j(exchangeG.h().s()).t(jCurrentTimeMillis).r(System.currentTimeMillis()).c();
            i3 = responseC.i();
        }
        exchangeG.s(responseC);
        Response responseC2 = (this.f144513a && i3 == 101) ? responseC.F().b(Util.f144276c).c() : responseC.F().b(exchangeG.q(responseC)).c();
        if (StringsKt.F("close", responseC2.N().d("Connection"), true) || StringsKt.F("close", Response.n(responseC2, "Connection", null, 2, null), true)) {
            exchangeG.o();
        }
        if (i3 == 204 || i3 == 205) {
            ResponseBody responseBodyA = responseC2.a();
            if ((responseBodyA == null ? -1L : responseBodyA.f()) > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP ");
                sb.append(i3);
                sb.append(" had non-zero Content-Length: ");
                ResponseBody responseBodyA2 = responseC2.a();
                if (responseBodyA2 != null) {
                    lValueOf = Long.valueOf(responseBodyA2.f());
                }
                sb.append(lValueOf);
                throw new ProtocolException(sb.toString());
            }
        }
        return responseC2;
    }
}
