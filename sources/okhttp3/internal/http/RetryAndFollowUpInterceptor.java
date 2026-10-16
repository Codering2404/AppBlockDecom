package okhttp3.internal.http;

import com.google.android.gms.common.api.Api;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;

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
public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f144534b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OkHttpClient f144535a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RetryAndFollowUpInterceptor(OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.f144535a = client;
    }

    private final Request b(Response response, String str) {
        String strN;
        HttpUrl httpUrlQ;
        if (!this.f144535a.s() || (strN = Response.n(response, "Location", null, 2, null)) == null || (httpUrlQ = response.N().k().q(strN)) == null) {
            return null;
        }
        if (!Intrinsics.areEqual(httpUrlQ.r(), response.N().k().r()) && !this.f144535a.t()) {
            return null;
        }
        Request.Builder builderI = response.N().i();
        if (HttpMethod.b(str)) {
            int i3 = response.i();
            HttpMethod httpMethod = HttpMethod.f144520a;
            boolean z2 = httpMethod.d(str) || i3 == 308 || i3 == 307;
            if (!httpMethod.c(str) || i3 == 308 || i3 == 307) {
                builderI.h(str, z2 ? response.N().a() : null);
            } else {
                builderI.h("GET", null);
            }
            if (!z2) {
                builderI.i("Transfer-Encoding");
                builderI.i(com.facebook.stetho.server.http.HttpHeaders.CONTENT_LENGTH);
                builderI.i("Content-Type");
            }
        }
        if (!Util.j(response.N().k(), httpUrlQ)) {
            builderI.i("Authorization");
        }
        return builderI.r(httpUrlQ).b();
    }

    private final Request c(Response response, Exchange exchange) throws ProtocolException {
        RealConnection realConnectionH;
        Route routeB = (exchange == null || (realConnectionH = exchange.h()) == null) ? null : realConnectionH.B();
        int i3 = response.i();
        String strH = response.N().h();
        if (i3 != 307 && i3 != 308) {
            if (i3 == 401) {
                return this.f144535a.e().a(routeB, response);
            }
            if (i3 == 421) {
                RequestBody requestBodyA = response.N().a();
                if ((requestBodyA != null && requestBodyA.f()) || exchange == null || !exchange.l()) {
                    return null;
                }
                exchange.h().z();
                return response.N();
            }
            if (i3 == 503) {
                Response responseK = response.K();
                if ((responseK == null || responseK.i() != 503) && g(response, Api.BaseClientBuilder.API_PRIORITY_OTHER) == 0) {
                    return response.N();
                }
                return null;
            }
            if (i3 == 407) {
                Intrinsics.checkNotNull(routeB);
                if (routeB.b().type() == Proxy.Type.HTTP) {
                    return this.f144535a.B().a(routeB, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (i3 == 408) {
                if (!this.f144535a.F()) {
                    return null;
                }
                RequestBody requestBodyA2 = response.N().a();
                if (requestBodyA2 != null && requestBodyA2.f()) {
                    return null;
                }
                Response responseK2 = response.K();
                if ((responseK2 == null || responseK2.i() != 408) && g(response, 0) <= 0) {
                    return response.N();
                }
                return null;
            }
            switch (i3) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return b(response, strH);
    }

    private final boolean d(IOException iOException, boolean z2) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z2 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean e(IOException iOException, RealCall realCall, Request request, boolean z2) {
        if (this.f144535a.F()) {
            return !(z2 && f(iOException, request)) && d(iOException, z2) && realCall.z();
        }
        return false;
    }

    private final boolean f(IOException iOException, Request request) {
        RequestBody requestBodyA = request.a();
        return (requestBodyA != null && requestBodyA.f()) || (iOException instanceof FileNotFoundException);
    }

    private final int g(Response response, int i3) {
        String strN = Response.n(response, "Retry-After", null, 2, null);
        if (strN == null) {
            return i3;
        }
        if (!new Regex("\\d+").k(strN)) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        Integer numValueOf = Integer.valueOf(strN);
        Intrinsics.checkNotNullExpressionValue(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0040, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        r0 = r1.r();
        r6 = c(r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        if (r6 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
    
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
    
        if (r0.m() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        r1.B();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        r1.k(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        r0 = r6.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        if (r0.f() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        r1.k(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
    
        r0 = r7.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0075, code lost:
    
        okhttp3.internal.Util.m(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r8 > 20) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:
    
        throw new java.net.ProtocolException(kotlin.jvm.internal.Intrinsics.stringPlus("Too many follow-up requests: ", java.lang.Integer.valueOf(r8)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        if (r7 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0028, code lost:
    
        r0 = r0.F().p(r7.F().b(null).c()).c();
     */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response a(okhttp3.Interceptor.Chain r11) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.RetryAndFollowUpInterceptor.a(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
