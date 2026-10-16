package okhttp3.logging;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

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
public final class LoggingEventListener extends EventListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f144962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HttpLoggingInterceptor.Logger f144963d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class Factory implements EventListener.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HttpLoggingInterceptor.Logger f144964a;

        /* JADX WARN: Multi-variable type inference failed */
        public Factory() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // okhttp3.EventListener.Factory
        public EventListener a(Call call) {
            Intrinsics.checkNotNullParameter(call, "call");
            return new LoggingEventListener(this.f144964a, null);
        }

        public Factory(HttpLoggingInterceptor.Logger logger) {
            Intrinsics.checkNotNullParameter(logger, "logger");
            this.f144964a = logger;
        }

        public /* synthetic */ Factory(HttpLoggingInterceptor.Logger logger, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? HttpLoggingInterceptor.Logger.f144960a : logger);
        }
    }

    public /* synthetic */ LoggingEventListener(HttpLoggingInterceptor.Logger logger, DefaultConstructorMarker defaultConstructorMarker) {
        this(logger);
    }

    private final void D(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.f144962c);
        this.f144963d.a('[' + millis + " ms] " + str);
    }

    @Override // okhttp3.EventListener
    public void A(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        D("satisfactionFailure: " + response);
    }

    @Override // okhttp3.EventListener
    public void B(Call call, Handshake handshake) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("secureConnectEnd: " + handshake);
    }

    @Override // okhttp3.EventListener
    public void C(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("secureConnectStart");
    }

    @Override // okhttp3.EventListener
    public void a(Call call, Response cachedResponse) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
        D("cacheConditionalHit: " + cachedResponse);
    }

    @Override // okhttp3.EventListener
    public void b(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        D("cacheHit: " + response);
    }

    @Override // okhttp3.EventListener
    public void c(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("cacheMiss");
    }

    @Override // okhttp3.EventListener
    public void d(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("callEnd");
    }

    @Override // okhttp3.EventListener
    public void e(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        D("callFailed: " + ioe);
    }

    @Override // okhttp3.EventListener
    public void f(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.f144962c = System.nanoTime();
        D("callStart: " + call.l());
    }

    @Override // okhttp3.EventListener
    public void g(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("canceled");
    }

    @Override // okhttp3.EventListener
    public void h(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        D("connectEnd: " + protocol);
    }

    @Override // okhttp3.EventListener
    public void i(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        D("connectFailed: " + protocol + ' ' + ioe);
    }

    @Override // okhttp3.EventListener
    public void j(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        D("connectStart: " + inetSocketAddress + ' ' + proxy);
    }

    @Override // okhttp3.EventListener
    public void k(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
        D("connectionAcquired: " + connection);
    }

    @Override // okhttp3.EventListener
    public void l(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
        D("connectionReleased");
    }

    @Override // okhttp3.EventListener
    public void m(Call call, String domainName, List inetAddressList) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        Intrinsics.checkNotNullParameter(inetAddressList, "inetAddressList");
        D("dnsEnd: " + inetAddressList);
    }

    @Override // okhttp3.EventListener
    public void n(Call call, String domainName) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        D("dnsStart: " + domainName);
    }

    @Override // okhttp3.EventListener
    public void o(Call call, HttpUrl url, List proxies) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(proxies, "proxies");
        D("proxySelectEnd: " + proxies);
    }

    @Override // okhttp3.EventListener
    public void p(Call call, HttpUrl url) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        D("proxySelectStart: " + url);
    }

    @Override // okhttp3.EventListener
    public void q(Call call, long j3) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("requestBodyEnd: byteCount=" + j3);
    }

    @Override // okhttp3.EventListener
    public void r(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("requestBodyStart");
    }

    @Override // okhttp3.EventListener
    public void s(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        D("requestFailed: " + ioe);
    }

    @Override // okhttp3.EventListener
    public void t(Call call, Request request) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(request, "request");
        D("requestHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void u(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("requestHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void v(Call call, long j3) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("responseBodyEnd: byteCount=" + j3);
    }

    @Override // okhttp3.EventListener
    public void w(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("responseBodyStart");
    }

    @Override // okhttp3.EventListener
    public void x(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
        D("responseFailed: " + ioe);
    }

    @Override // okhttp3.EventListener
    public void y(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        D("responseHeadersEnd: " + response);
    }

    @Override // okhttp3.EventListener
    public void z(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
        D("responseHeadersStart");
    }

    private LoggingEventListener(HttpLoggingInterceptor.Logger logger) {
        this.f144963d = logger;
    }
}
