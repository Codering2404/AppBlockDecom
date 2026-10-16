package okhttp3.internal.http;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;

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
public final class RealInterceptorChain implements Interceptor.Chain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RealCall f144521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f144522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f144523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Exchange f144524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Request f144525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f144526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f144527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f144528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f144529i;

    public RealInterceptorChain(RealCall call, List interceptors, int i3, Exchange exchange, Request request, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(request, "request");
        this.f144521a = call;
        this.f144522b = interceptors;
        this.f144523c = i3;
        this.f144524d = exchange;
        this.f144525e = request;
        this.f144526f = i4;
        this.f144527g = i5;
        this.f144528h = i6;
    }

    public static /* synthetic */ RealInterceptorChain d(RealInterceptorChain realInterceptorChain, int i3, Exchange exchange, Request request, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i3 = realInterceptorChain.f144523c;
        }
        if ((i7 & 2) != 0) {
            exchange = realInterceptorChain.f144524d;
        }
        if ((i7 & 4) != 0) {
            request = realInterceptorChain.f144525e;
        }
        if ((i7 & 8) != 0) {
            i4 = realInterceptorChain.f144526f;
        }
        if ((i7 & 16) != 0) {
            i5 = realInterceptorChain.f144527g;
        }
        if ((i7 & 32) != 0) {
            i6 = realInterceptorChain.f144528h;
        }
        int i8 = i5;
        int i9 = i6;
        return realInterceptorChain.c(i3, exchange, request, i4, i8, i9);
    }

    @Override // okhttp3.Interceptor.Chain
    public Response a(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.f144523c >= this.f144522b.size()) {
            throw new IllegalStateException("Check failed.");
        }
        this.f144529i++;
        Exchange exchange = this.f144524d;
        if (exchange != null) {
            if (!exchange.j().g(request.k())) {
                throw new IllegalStateException(("network interceptor " + this.f144522b.get(this.f144523c - 1) + " must retain the same host and port").toString());
            }
            if (this.f144529i != 1) {
                throw new IllegalStateException(("network interceptor " + this.f144522b.get(this.f144523c - 1) + " must call proceed() exactly once").toString());
            }
        }
        RealInterceptorChain realInterceptorChainD = d(this, this.f144523c + 1, null, request, 0, 0, 0, 58, null);
        Interceptor interceptor = (Interceptor) this.f144522b.get(this.f144523c);
        Response responseA = interceptor.a(realInterceptorChainD);
        if (responseA == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (this.f144524d != null && this.f144523c + 1 < this.f144522b.size() && realInterceptorChainD.f144529i != 1) {
            throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
        }
        if (responseA.a() != null) {
            return responseA;
        }
        throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection b() {
        Exchange exchange = this.f144524d;
        if (exchange == null) {
            return null;
        }
        return exchange.h();
    }

    public final RealInterceptorChain c(int i3, Exchange exchange, Request request, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new RealInterceptorChain(this.f144521a, this.f144522b, i3, exchange, request, i4, i5, i6);
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.f144521a;
    }

    public final RealCall e() {
        return this.f144521a;
    }

    public final int f() {
        return this.f144526f;
    }

    public final Exchange g() {
        return this.f144524d;
    }

    public final int h() {
        return this.f144527g;
    }

    public final Request i() {
        return this.f144525e;
    }

    public final int j() {
        return this.f144528h;
    }

    public int k() {
        return this.f144527g;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request l() {
        return this.f144525e;
    }
}
