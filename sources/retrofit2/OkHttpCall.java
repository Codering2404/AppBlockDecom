package retrofit2;

import java.io.IOException;
import java.util.Objects;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class OkHttpCall<T> implements Call<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RequestFactory f146870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f146871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f146872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Call.Factory f146873d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Converter f146874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f146875g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private okhttp3.Call f146876h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Throwable f146877i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f146878j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ExceptionCatchingResponseBody extends ResponseBody {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ResponseBody f146881c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final BufferedSource f146882d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        IOException f146883f;

        ExceptionCatchingResponseBody(ResponseBody responseBody) {
            this.f146881c = responseBody;
            this.f146882d = Okio.d(new ForwardingSource(responseBody.k()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingResponseBody.1
                @Override // okio.ForwardingSource, okio.Source
                public long t2(Buffer buffer, long j3) throws IOException {
                    try {
                        return super.t2(buffer, j3);
                    } catch (IOException e3) {
                        ExceptionCatchingResponseBody.this.f146883f = e3;
                        throw e3;
                    }
                }
            });
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f146881c.close();
        }

        @Override // okhttp3.ResponseBody
        public long f() {
            return this.f146881c.f();
        }

        @Override // okhttp3.ResponseBody
        public MediaType i() {
            return this.f146881c.i();
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource k() {
            return this.f146882d;
        }

        void m() throws IOException {
            IOException iOException = this.f146883f;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class NoContentResponseBody extends ResponseBody {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MediaType f146885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f146886d;

        NoContentResponseBody(MediaType mediaType, long j3) {
            this.f146885c = mediaType;
            this.f146886d = j3;
        }

        @Override // okhttp3.ResponseBody
        public long f() {
            return this.f146886d;
        }

        @Override // okhttp3.ResponseBody
        public MediaType i() {
            return this.f146885c;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource k() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    OkHttpCall(RequestFactory requestFactory, Object obj, Object[] objArr, Call.Factory factory, Converter converter) {
        this.f146870a = requestFactory;
        this.f146871b = obj;
        this.f146872c = objArr;
        this.f146873d = factory;
        this.f146874f = converter;
    }

    private okhttp3.Call b() {
        okhttp3.Call callA = this.f146873d.a(this.f146870a.a(this.f146871b, this.f146872c));
        if (callA != null) {
            return callA;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    private okhttp3.Call c() throws IOException {
        okhttp3.Call call = this.f146876h;
        if (call != null) {
            return call;
        }
        Throwable th = this.f146877i;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            okhttp3.Call callB = b();
            this.f146876h = callB;
            return callB;
        } catch (IOException | Error | RuntimeException e3) {
            Utils.t(e3);
            this.f146877i = e3;
            throw e3;
        }
    }

    @Override // retrofit2.Call
    public void A0(final Callback callback) {
        okhttp3.Call call;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            try {
                if (this.f146878j) {
                    throw new IllegalStateException("Already executed.");
                }
                this.f146878j = true;
                call = this.f146876h;
                th = this.f146877i;
                if (call == null && th == null) {
                    try {
                        okhttp3.Call callB = b();
                        this.f146876h = callB;
                        call = callB;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.t(th);
                        this.f146877i = th;
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        if (th != null) {
            callback.a(this, th);
            return;
        }
        if (this.f146875g) {
            call.cancel();
        }
        call.B1(new okhttp3.Callback() { // from class: retrofit2.OkHttpCall.1
            private void a(Throwable th4) {
                try {
                    callback.a(OkHttpCall.this, th4);
                } catch (Throwable th5) {
                    Utils.t(th5);
                    th5.printStackTrace();
                }
            }

            @Override // okhttp3.Callback
            public void c(okhttp3.Call call2, IOException iOException) {
                a(iOException);
            }

            @Override // okhttp3.Callback
            public void d(okhttp3.Call call2, okhttp3.Response response) {
                try {
                    try {
                        callback.b(OkHttpCall.this, OkHttpCall.this.e(response));
                    } catch (Throwable th4) {
                        Utils.t(th4);
                        th4.printStackTrace();
                    }
                } catch (Throwable th5) {
                    Utils.t(th5);
                    a(th5);
                }
            }
        });
    }

    @Override // retrofit2.Call
    public boolean C() {
        boolean z2 = true;
        if (this.f146875g) {
            return true;
        }
        synchronized (this) {
            try {
                okhttp3.Call call = this.f146876h;
                if (call == null || !call.C()) {
                    z2 = false;
                }
            } finally {
            }
        }
        return z2;
    }

    @Override // retrofit2.Call
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public OkHttpCall clone() {
        return new OkHttpCall(this.f146870a, this.f146871b, this.f146872c, this.f146873d, this.f146874f);
    }

    @Override // retrofit2.Call
    public void cancel() {
        okhttp3.Call call;
        this.f146875g = true;
        synchronized (this) {
            call = this.f146876h;
        }
        if (call != null) {
            call.cancel();
        }
    }

    @Override // retrofit2.Call
    public Response d() {
        okhttp3.Call callC;
        synchronized (this) {
            if (this.f146878j) {
                throw new IllegalStateException("Already executed.");
            }
            this.f146878j = true;
            callC = c();
        }
        if (this.f146875g) {
            callC.cancel();
        }
        return e(callC.d());
    }

    Response e(okhttp3.Response response) throws IOException {
        ResponseBody responseBodyA = response.a();
        okhttp3.Response responseC = response.F().b(new NoContentResponseBody(responseBodyA.i(), responseBodyA.f())).c();
        int i3 = responseC.i();
        if (i3 < 200 || i3 >= 300) {
            try {
                return Response.c(Utils.a(responseBodyA), responseC);
            } finally {
                responseBodyA.close();
            }
        }
        if (i3 == 204 || i3 == 205) {
            responseBodyA.close();
            return Response.h(null, responseC);
        }
        ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(responseBodyA);
        try {
            return Response.h(this.f146874f.a(exceptionCatchingResponseBody), responseC);
        } catch (RuntimeException e3) {
            exceptionCatchingResponseBody.m();
            throw e3;
        }
    }

    @Override // retrofit2.Call
    public synchronized Request l() {
        try {
        } catch (IOException e3) {
            throw new RuntimeException("Unable to create request.", e3);
        }
        return c().l();
    }
}
