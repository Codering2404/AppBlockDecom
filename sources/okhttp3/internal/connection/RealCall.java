package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;

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
public final class RealCall implements Call {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OkHttpClient f144442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Request f144443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f144444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RealConnectionPool f144445d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EventListener f144446f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final RealCall$timeout$1 f144447g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f144448h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Object f144449i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ExchangeFinder f144450j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private RealConnection f144451k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f144452l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Exchange f144453m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f144454n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f144455o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f144456p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile boolean f144457q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private volatile Exchange f144458r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private volatile RealConnection f144459s;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class AsyncCall implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Callback f144460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile AtomicInteger f144461b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ RealCall f144462c;

        public AsyncCall(RealCall this$0, Callback responseCallback) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
            this.f144462c = this$0;
            this.f144460a = responseCallback;
            this.f144461b = new AtomicInteger(0);
        }

        public final void a(ExecutorService executorService) {
            Intrinsics.checkNotNullParameter(executorService, "executorService");
            Dispatcher dispatcherP = this.f144462c.m().p();
            if (Util.f144281h && Thread.holdsLock(dispatcherP)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + dispatcherP);
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e3) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e3);
                    this.f144462c.w(interruptedIOException);
                    this.f144460a.c(this.f144462c, interruptedIOException);
                    this.f144462c.m().p().f(this);
                }
            } catch (Throwable th) {
                this.f144462c.m().p().f(this);
                throw th;
            }
        }

        public final RealCall b() {
            return this.f144462c;
        }

        public final AtomicInteger c() {
            return this.f144461b;
        }

        public final String d() {
            return this.f144462c.s().k().i();
        }

        public final void e(AsyncCall other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.f144461b = other.f144461b;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z2;
            Throwable th;
            IOException e3;
            OkHttpClient okHttpClientM;
            String strStringPlus = Intrinsics.stringPlus("OkHttp ", this.f144462c.x());
            RealCall realCall = this.f144462c;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(strStringPlus);
            try {
                realCall.f144447g.x();
                try {
                    try {
                        z2 = true;
                        try {
                            this.f144460a.d(realCall, realCall.t());
                            okHttpClientM = realCall.m();
                        } catch (IOException e4) {
                            e3 = e4;
                            if (z2) {
                                Platform.f144818a.g().k(Intrinsics.stringPlus("Callback failure for ", realCall.E()), 4, e3);
                            } else {
                                this.f144460a.c(realCall, e3);
                            }
                            okHttpClientM = realCall.m();
                        } catch (Throwable th2) {
                            th = th2;
                            realCall.cancel();
                            if (!z2) {
                                IOException iOException = new IOException(Intrinsics.stringPlus("canceled due to ", th));
                                ExceptionsKt.a(iOException, th);
                                this.f144460a.c(realCall, iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        realCall.m().p().f(this);
                        throw th3;
                    }
                } catch (IOException e5) {
                    z2 = false;
                    e3 = e5;
                } catch (Throwable th4) {
                    z2 = false;
                    th = th4;
                }
                okHttpClientM.p().f(this);
            } finally {
                threadCurrentThread.setName(name);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CallReference extends WeakReference<RealCall> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f144463a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallReference(RealCall referent, Object obj) {
            super(referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            this.f144463a = obj;
        }

        public final Object a() {
            return this.f144463a;
        }
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [okhttp3.internal.connection.RealCall$timeout$1, okio.Timeout] */
    public RealCall(OkHttpClient client, Request originalRequest, boolean z2) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        this.f144442a = client;
        this.f144443b = originalRequest;
        this.f144444c = z2;
        this.f144445d = client.k().a();
        this.f144446f = client.r().a(this);
        ?? r2 = new AsyncTimeout() { // from class: okhttp3.internal.connection.RealCall$timeout$1
            @Override // okio.AsyncTimeout
            protected void D() {
                this.f144464o.cancel();
            }
        };
        r2.h(m().h(), TimeUnit.MILLISECONDS);
        this.f144447g = r2;
        this.f144448h = new AtomicBoolean();
        this.f144456p = true;
    }

    private final IOException D(IOException iOException) {
        if (this.f144452l || !y()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String E() {
        StringBuilder sb = new StringBuilder();
        sb.append(C() ? "canceled " : "");
        sb.append(this.f144444c ? "web socket" : "call");
        sb.append(" to ");
        sb.append(x());
        return sb.toString();
    }

    private final IOException e(IOException iOException) {
        Socket socketY;
        boolean z2 = Util.f144281h;
        if (z2 && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        RealConnection realConnection = this.f144451k;
        if (realConnection != null) {
            if (z2 && Thread.holdsLock(realConnection)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + realConnection);
            }
            synchronized (realConnection) {
                socketY = y();
            }
            if (this.f144451k == null) {
                if (socketY != null) {
                    Util.n(socketY);
                }
                this.f144446f.l(this, realConnection);
            } else if (socketY != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        IOException iOExceptionD = D(iOException);
        if (iOException == null) {
            this.f144446f.d(this);
            return iOExceptionD;
        }
        EventListener eventListener = this.f144446f;
        Intrinsics.checkNotNull(iOExceptionD);
        eventListener.e(this, iOExceptionD);
        return iOExceptionD;
    }

    private final void g() {
        this.f144449i = Platform.f144818a.g().i("response.body().close()");
        this.f144446f.f(this);
    }

    private final Address i(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactoryH;
        HostnameVerifier hostnameVerifierV;
        CertificatePinner certificatePinnerI;
        if (httpUrl.j()) {
            sSLSocketFactoryH = this.f144442a.H();
            hostnameVerifierV = this.f144442a.v();
            certificatePinnerI = this.f144442a.i();
        } else {
            sSLSocketFactoryH = null;
            hostnameVerifierV = null;
            certificatePinnerI = null;
        }
        return new Address(httpUrl.i(), httpUrl.n(), this.f144442a.q(), this.f144442a.G(), sSLSocketFactoryH, hostnameVerifierV, certificatePinnerI, this.f144442a.B(), this.f144442a.A(), this.f144442a.z(), this.f144442a.m(), this.f144442a.D());
    }

    public final void A(RealConnection realConnection) {
        this.f144459s = realConnection;
    }

    public final void B() {
        if (this.f144452l) {
            throw new IllegalStateException("Check failed.");
        }
        this.f144452l = true;
        y();
    }

    @Override // okhttp3.Call
    public void B1(Callback responseCallback) {
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        if (!this.f144448h.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        g();
        this.f144442a.p().a(new AsyncCall(this, responseCallback));
    }

    @Override // okhttp3.Call
    public boolean C() {
        return this.f144457q;
    }

    public final void c(RealConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (!Util.f144281h || Thread.holdsLock(connection)) {
            if (this.f144451k != null) {
                throw new IllegalStateException("Check failed.");
            }
            this.f144451k = connection;
            connection.o().add(new CallReference(this, this.f144449i));
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + connection);
    }

    @Override // okhttp3.Call
    public void cancel() {
        if (this.f144457q) {
            return;
        }
        this.f144457q = true;
        Exchange exchange = this.f144458r;
        if (exchange != null) {
            exchange.b();
        }
        RealConnection realConnection = this.f144459s;
        if (realConnection != null) {
            realConnection.e();
        }
        this.f144446f.g(this);
    }

    @Override // okhttp3.Call
    public Response d() {
        if (!this.f144448h.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        x();
        g();
        try {
            this.f144442a.p().b(this);
            return t();
        } finally {
            this.f144442a.p().g(this);
        }
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public RealCall clone() {
        return new RealCall(this.f144442a, this.f144443b, this.f144444c);
    }

    public final void j(Request request, boolean z2) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.f144453m != null) {
            throw new IllegalStateException("Check failed.");
        }
        synchronized (this) {
            if (this.f144455o) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
            if (this.f144454n) {
                throw new IllegalStateException("Check failed.");
            }
            Unit unit = Unit.f139807a;
        }
        if (z2) {
            this.f144450j = new ExchangeFinder(this.f144445d, i(request.k()), this, this.f144446f);
        }
    }

    public final void k(boolean z2) {
        Exchange exchange;
        synchronized (this) {
            if (!this.f144456p) {
                throw new IllegalStateException("released");
            }
            Unit unit = Unit.f139807a;
        }
        if (z2 && (exchange = this.f144458r) != null) {
            exchange.d();
        }
        this.f144453m = null;
    }

    @Override // okhttp3.Call
    public Request l() {
        return this.f144443b;
    }

    public final OkHttpClient m() {
        return this.f144442a;
    }

    public final RealConnection o() {
        return this.f144451k;
    }

    public final EventListener p() {
        return this.f144446f;
    }

    public final boolean q() {
        return this.f144444c;
    }

    public final Exchange r() {
        return this.f144453m;
    }

    public final Request s() {
        return this.f144443b;
    }

    public final Response t() {
        ArrayList arrayList = new ArrayList();
        CollectionsKt.addAll(arrayList, this.f144442a.w());
        arrayList.add(new RetryAndFollowUpInterceptor(this.f144442a));
        arrayList.add(new BridgeInterceptor(this.f144442a.o()));
        arrayList.add(new CacheInterceptor(this.f144442a.g()));
        arrayList.add(ConnectInterceptor.f144409a);
        if (!this.f144444c) {
            CollectionsKt.addAll(arrayList, this.f144442a.x());
        }
        arrayList.add(new CallServerInterceptor(this.f144444c));
        try {
            try {
                Response responseA = new RealInterceptorChain(this, arrayList, 0, null, this.f144443b, this.f144442a.j(), this.f144442a.E(), this.f144442a.J()).a(this.f144443b);
                if (C()) {
                    Util.m(responseA);
                    throw new IOException("Canceled");
                }
                w(null);
                return responseA;
            } catch (IOException e3) {
                IOException iOExceptionW = w(e3);
                if (iOExceptionW == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                throw iOExceptionW;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                w(null);
            }
            throw th;
        }
    }

    public final Exchange u(RealInterceptorChain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        synchronized (this) {
            if (!this.f144456p) {
                throw new IllegalStateException("released");
            }
            if (this.f144455o) {
                throw new IllegalStateException("Check failed.");
            }
            if (this.f144454n) {
                throw new IllegalStateException("Check failed.");
            }
            Unit unit = Unit.f139807a;
        }
        ExchangeFinder exchangeFinder = this.f144450j;
        Intrinsics.checkNotNull(exchangeFinder);
        Exchange exchange = new Exchange(this, this.f144446f, exchangeFinder, exchangeFinder.a(this.f144442a, chain));
        this.f144453m = exchange;
        this.f144458r = exchange;
        synchronized (this) {
            this.f144454n = true;
            this.f144455o = true;
        }
        if (this.f144457q) {
            throw new IOException("Canceled");
        }
        return exchange;
    }

    public final IOException v(Exchange exchange, boolean z2, boolean z3, IOException iOException) {
        boolean z4;
        boolean z5;
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        if (Intrinsics.areEqual(exchange, this.f144458r)) {
            synchronized (this) {
                z4 = false;
                if (z2) {
                    try {
                        if (!this.f144454n) {
                            if (z3 || !this.f144455o) {
                                z5 = false;
                            }
                            Unit unit = Unit.f139807a;
                        }
                        if (z2) {
                            this.f144454n = false;
                        }
                        if (z3) {
                            this.f144455o = false;
                        }
                        boolean z6 = this.f144454n;
                        boolean z7 = (z6 || this.f144455o) ? false : true;
                        if (!z6 && !this.f144455o && !this.f144456p) {
                            z4 = true;
                        }
                        z5 = z4;
                        z4 = z7;
                        Unit unit2 = Unit.f139807a;
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    if (z3) {
                    }
                    z5 = false;
                    Unit unit22 = Unit.f139807a;
                }
            }
            if (z4) {
                this.f144458r = null;
                RealConnection realConnection = this.f144451k;
                if (realConnection != null) {
                    realConnection.t();
                }
            }
            if (z5) {
                return e(iOException);
            }
        }
        return iOException;
    }

    public final IOException w(IOException iOException) {
        boolean z2;
        synchronized (this) {
            try {
                z2 = false;
                if (this.f144456p) {
                    this.f144456p = false;
                    if (!this.f144454n && !this.f144455o) {
                        z2 = true;
                    }
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2 ? e(iOException) : iOException;
    }

    public final String x() {
        return this.f144443b.k().p();
    }

    public final Socket y() {
        RealConnection realConnection = this.f144451k;
        Intrinsics.checkNotNull(realConnection);
        if (Util.f144281h && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + realConnection);
        }
        List listO = realConnection.o();
        Iterator it = listO.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            }
            if (Intrinsics.areEqual(((Reference) it.next()).get(), this)) {
                break;
            }
            i3++;
        }
        if (i3 == -1) {
            throw new IllegalStateException("Check failed.");
        }
        listO.remove(i3);
        this.f144451k = null;
        if (listO.isEmpty()) {
            realConnection.D(System.nanoTime());
            if (this.f144445d.c(realConnection)) {
                return realConnection.F();
            }
        }
        return null;
    }

    public final boolean z() {
        ExchangeFinder exchangeFinder = this.f144450j;
        Intrinsics.checkNotNull(exchangeFinder);
        return exchangeFinder.e();
    }
}
