package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

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
public final class ExchangeFinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RealConnectionPool f144432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Address f144433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RealCall f144434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EventListener f144435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RouteSelector.Selection f144436e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RouteSelector f144437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f144438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f144439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f144440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Route f144441j;

    public ExchangeFinder(RealConnectionPool connectionPool, Address address, RealCall call, EventListener eventListener) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.f144432a = connectionPool;
        this.f144433b = address;
        this.f144434c = call;
        this.f144435d = eventListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final okhttp3.internal.connection.RealConnection b(int r13, int r14, int r15, int r16, boolean r17) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.b(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    private final RealConnection c(int i3, int i4, int i5, int i6, boolean z2, boolean z3) throws IOException {
        while (true) {
            RealConnection realConnectionB = b(i3, i4, i5, i6, z2);
            boolean z4 = z2;
            int i7 = i6;
            int i8 = i5;
            int i9 = i4;
            int i10 = i3;
            if (realConnectionB.v(z3)) {
                return realConnectionB;
            }
            realConnectionB.A();
            if (this.f144441j == null) {
                RouteSelector.Selection selection = this.f144436e;
                if (selection == null ? true : selection.b()) {
                    continue;
                } else {
                    RouteSelector routeSelector = this.f144437f;
                    if (!(routeSelector != null ? routeSelector.a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
            i3 = i10;
            i4 = i9;
            i5 = i8;
            i6 = i7;
            z2 = z4;
        }
    }

    private final Route f() {
        RealConnection realConnectionO;
        if (this.f144438g > 1 || this.f144439h > 1 || this.f144440i > 0 || (realConnectionO = this.f144434c.o()) == null) {
            return null;
        }
        synchronized (realConnectionO) {
            if (realConnectionO.r() != 0) {
                return null;
            }
            if (Util.j(realConnectionO.B().a().l(), d().l())) {
                return realConnectionO.B();
            }
            return null;
        }
    }

    public final ExchangeCodec a(OkHttpClient client, RealInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        try {
        } catch (IOException e3) {
            e = e3;
        } catch (RouteException e4) {
            e = e4;
        }
        try {
            return c(chain.f(), chain.h(), chain.j(), client.y(), client.F(), !Intrinsics.areEqual(chain.i().h(), "GET")).x(client, chain);
        } catch (IOException e5) {
            e = e5;
            IOException iOException = e;
            h(iOException);
            throw new RouteException(iOException);
        } catch (RouteException e6) {
            e = e6;
            RouteException routeException = e;
            h(routeException.c());
            throw routeException;
        }
    }

    public final Address d() {
        return this.f144433b;
    }

    public final boolean e() {
        RouteSelector routeSelector;
        if (this.f144438g == 0 && this.f144439h == 0 && this.f144440i == 0) {
            return false;
        }
        if (this.f144441j != null) {
            return true;
        }
        Route routeF = f();
        if (routeF != null) {
            this.f144441j = routeF;
            return true;
        }
        RouteSelector.Selection selection = this.f144436e;
        if ((selection != null && selection.b()) || (routeSelector = this.f144437f) == null) {
            return true;
        }
        return routeSelector.a();
    }

    public final boolean g(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HttpUrl httpUrlL = this.f144433b.l();
        return url.n() == httpUrlL.n() && Intrinsics.areEqual(url.i(), httpUrlL.i());
    }

    public final void h(IOException e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        this.f144441j = null;
        if ((e3 instanceof StreamResetException) && ((StreamResetException) e3).f144786a == ErrorCode.REFUSED_STREAM) {
            this.f144438g++;
        } else if (e3 instanceof ConnectionShutdownException) {
            this.f144439h++;
        } else {
            this.f144440i++;
        }
    }
}
