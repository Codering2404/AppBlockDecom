package com.squareup.okhttp;

import com.facebook.stetho.server.http.HttpHeaders;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.CacheRequest;
import com.squareup.okhttp.internal.http.CacheStrategy;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Cache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final InternalCache f92768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DiskLruCache f92769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f92770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f92771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f92772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f92773f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f92774g;

    /* JADX INFO: renamed from: com.squareup.okhttp.Cache$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements InternalCache {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Cache f92775a;

        @Override // com.squareup.okhttp.internal.InternalCache
        public Response a(Request request) {
            return this.f92775a.j(request);
        }

        @Override // com.squareup.okhttp.internal.InternalCache
        public void b(Response response, Response response2) {
            this.f92775a.p(response, response2);
        }

        @Override // com.squareup.okhttp.internal.InternalCache
        public CacheRequest c(Response response) {
            return this.f92775a.k(response);
        }

        @Override // com.squareup.okhttp.internal.InternalCache
        public void d() {
            this.f92775a.n();
        }

        @Override // com.squareup.okhttp.internal.InternalCache
        public void e(Request request) {
            this.f92775a.m(request);
        }

        @Override // com.squareup.okhttp.internal.InternalCache
        public void f(CacheStrategy cacheStrategy) {
            this.f92775a.o(cacheStrategy);
        }
    }

    /* JADX INFO: renamed from: com.squareup.okhttp.Cache$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements Iterator<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator f92776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f92777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f92778c;

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f92777b;
            this.f92777b = null;
            this.f92778c = true;
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f92777b != null) {
                return true;
            }
            this.f92778c = false;
            while (this.f92776a.hasNext()) {
                DiskLruCache.Snapshot snapshot = (DiskLruCache.Snapshot) this.f92776a.next();
                try {
                    this.f92777b = Okio.d(snapshot.c(0)).Q0();
                    return true;
                } catch (IOException unused) {
                } finally {
                    snapshot.close();
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f92778c) {
                throw new IllegalStateException("remove() before next()");
            }
            this.f92776a.remove();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class CacheRequestImpl implements CacheRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DiskLruCache.Editor f92779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Sink f92780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f92781c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Sink f92782d;

        public CacheRequestImpl(final DiskLruCache.Editor editor) {
            this.f92779a = editor;
            Sink sinkF = editor.f(1);
            this.f92780b = sinkF;
            this.f92782d = new ForwardingSink(sinkF) { // from class: com.squareup.okhttp.Cache.CacheRequestImpl.1
                @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    synchronized (Cache.this) {
                        try {
                            if (CacheRequestImpl.this.f92781c) {
                                return;
                            }
                            CacheRequestImpl.this.f92781c = true;
                            Cache.h(Cache.this);
                            super.close();
                            editor.e();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            };
        }

        @Override // com.squareup.okhttp.internal.http.CacheRequest
        public void abort() {
            synchronized (Cache.this) {
                try {
                    if (this.f92781c) {
                        return;
                    }
                    this.f92781c = true;
                    Cache.i(Cache.this);
                    Util.c(this.f92780b);
                    try {
                        this.f92779a.a();
                    } catch (IOException unused) {
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.squareup.okhttp.internal.http.CacheRequest
        public Sink body() {
            return this.f92782d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CacheResponseBody extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DiskLruCache.Snapshot f92787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BufferedSource f92788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f92789c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f92790d;

        public CacheResponseBody(final DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.f92787a = snapshot;
            this.f92789c = str;
            this.f92790d = str2;
            this.f92788b = Okio.d(new ForwardingSource(snapshot.c(1)) { // from class: com.squareup.okhttp.Cache.CacheResponseBody.1
                @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    snapshot.close();
                    super.close();
                }
            });
        }

        @Override // com.squareup.okhttp.ResponseBody
        public long a() {
            try {
                String str = this.f92790d;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // com.squareup.okhttp.ResponseBody
        public BufferedSource b() {
            return this.f92788b;
        }
    }

    private void a(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.a();
            } catch (IOException unused) {
            }
        }
    }

    static /* synthetic */ int h(Cache cache) {
        int i3 = cache.f92770c;
        cache.f92770c = i3 + 1;
        return i3;
    }

    static /* synthetic */ int i(Cache cache) {
        int i3 = cache.f92771d;
        cache.f92771d = i3 + 1;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CacheRequest k(Response response) {
        DiskLruCache.Editor editorM;
        String strM = response.w().m();
        if (HttpMethod.a(response.w().m())) {
            try {
                m(response.w());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!strM.equals("GET") || OkHeaders.g(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            editorM = this.f92769b.M(q(response.w()));
            if (editorM == null) {
                return null;
            }
            try {
                entry.f(editorM);
                return new CacheRequestImpl(editorM);
            } catch (IOException unused2) {
                a(editorM);
                return null;
            }
        } catch (IOException unused3) {
            editorM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(BufferedSource bufferedSource) throws IOException {
        try {
            long jM1 = bufferedSource.M1();
            String strQ0 = bufferedSource.Q0();
            if (jM1 >= 0 && jM1 <= 2147483647L && strQ0.isEmpty()) {
                return (int) jM1;
            }
            throw new IOException("expected an int but was \"" + jM1 + strQ0 + "\"");
        } catch (NumberFormatException e3) {
            throw new IOException(e3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Request request) {
        this.f92769b.z0(q(request));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n() {
        this.f92773f++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o(CacheStrategy cacheStrategy) {
        try {
            this.f92774g++;
            if (cacheStrategy.f93311a != null) {
                this.f92772e++;
            } else if (cacheStrategy.f93312b != null) {
                this.f92773f++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Response response, Response response2) {
        DiskLruCache.Editor editorB;
        Entry entry = new Entry(response2);
        try {
            editorB = ((CacheResponseBody) response.k()).f92787a.b();
            if (editorB != null) {
                try {
                    entry.f(editorB);
                    editorB.e();
                } catch (IOException unused) {
                    a(editorB);
                }
            }
        } catch (IOException unused2) {
            editorB = null;
        }
    }

    private static String q(Request request) {
        return Util.p(request.p());
    }

    Response j(Request request) {
        try {
            DiskLruCache.Snapshot snapshotO = this.f92769b.O(q(request));
            if (snapshotO == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshotO.c(0));
                Response responseD = entry.d(request, snapshotO);
                if (entry.b(request, responseD)) {
                    return responseD;
                }
                Util.c(responseD.k());
                return null;
            } catch (IOException unused) {
                Util.c(snapshotO);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f92793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Headers f92794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f92795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Protocol f92796d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f92797e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f92798f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Headers f92799g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Handshake f92800h;

        public Entry(Source source) {
            try {
                BufferedSource bufferedSourceD = Okio.d(source);
                this.f92793a = bufferedSourceD.Q0();
                this.f92795c = bufferedSourceD.Q0();
                Headers.Builder builder = new Headers.Builder();
                int iL = Cache.l(bufferedSourceD);
                for (int i3 = 0; i3 < iL; i3++) {
                    builder.c(bufferedSourceD.Q0());
                }
                this.f92794b = builder.e();
                StatusLine statusLineA = StatusLine.a(bufferedSourceD.Q0());
                this.f92796d = statusLineA.f93418a;
                this.f92797e = statusLineA.f93419b;
                this.f92798f = statusLineA.f93420c;
                Headers.Builder builder2 = new Headers.Builder();
                int iL2 = Cache.l(bufferedSourceD);
                for (int i4 = 0; i4 < iL2; i4++) {
                    builder2.c(bufferedSourceD.Q0());
                }
                this.f92799g = builder2.e();
                if (a()) {
                    String strQ0 = bufferedSourceD.Q0();
                    if (strQ0.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strQ0 + "\"");
                    }
                    this.f92800h = Handshake.b(bufferedSourceD.Q0(), c(bufferedSourceD), c(bufferedSourceD));
                } else {
                    this.f92800h = null;
                }
                source.close();
            } catch (Throwable th) {
                source.close();
                throw th;
            }
        }

        private boolean a() {
            return this.f92793a.startsWith("https://");
        }

        private List c(BufferedSource bufferedSource) throws IOException {
            int iL = Cache.l(bufferedSource);
            if (iL == -1) {
                return Collections.EMPTY_LIST;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(iL);
                for (int i3 = 0; i3 < iL; i3++) {
                    String strQ0 = bufferedSource.Q0();
                    Buffer buffer = new Buffer();
                    buffer.q2(ByteString.c(strQ0));
                    arrayList.add(certificateFactory.generateCertificate(buffer.H2()));
                }
                return arrayList;
            } catch (CertificateException e3) {
                throw new IOException(e3.getMessage());
            }
        }

        private void e(BufferedSink bufferedSink, List list) throws IOException {
            try {
                bufferedSink.j1(list.size());
                bufferedSink.writeByte(10);
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    bufferedSink.C0(ByteString.v(((Certificate) list.get(i3)).getEncoded()).a());
                    bufferedSink.writeByte(10);
                }
            } catch (CertificateEncodingException e3) {
                throw new IOException(e3.getMessage());
            }
        }

        public boolean b(Request request, Response response) {
            return this.f92793a.equals(request.p()) && this.f92795c.equals(request.m()) && OkHeaders.q(response, this.f92794b, request);
        }

        public Response d(Request request, DiskLruCache.Snapshot snapshot) {
            String strA = this.f92799g.a("Content-Type");
            String strA2 = this.f92799g.a(HttpHeaders.CONTENT_LENGTH);
            return new Response.Builder().y(new Request.Builder().m(this.f92793a).j(this.f92795c, null).i(this.f92794b).g()).x(this.f92796d).q(this.f92797e).u(this.f92798f).t(this.f92799g).l(new CacheResponseBody(snapshot, strA, strA2)).r(this.f92800h).m();
        }

        public void f(DiskLruCache.Editor editor) throws IOException {
            BufferedSink bufferedSinkC = Okio.c(editor.f(0));
            bufferedSinkC.C0(this.f92793a);
            bufferedSinkC.writeByte(10);
            bufferedSinkC.C0(this.f92795c);
            bufferedSinkC.writeByte(10);
            bufferedSinkC.j1(this.f92794b.f());
            bufferedSinkC.writeByte(10);
            int iF = this.f92794b.f();
            for (int i3 = 0; i3 < iF; i3++) {
                bufferedSinkC.C0(this.f92794b.d(i3));
                bufferedSinkC.C0(": ");
                bufferedSinkC.C0(this.f92794b.g(i3));
                bufferedSinkC.writeByte(10);
            }
            bufferedSinkC.C0(new StatusLine(this.f92796d, this.f92797e, this.f92798f).toString());
            bufferedSinkC.writeByte(10);
            bufferedSinkC.j1(this.f92799g.f());
            bufferedSinkC.writeByte(10);
            int iF2 = this.f92799g.f();
            for (int i4 = 0; i4 < iF2; i4++) {
                bufferedSinkC.C0(this.f92799g.d(i4));
                bufferedSinkC.C0(": ");
                bufferedSinkC.C0(this.f92799g.g(i4));
                bufferedSinkC.writeByte(10);
            }
            if (a()) {
                bufferedSinkC.writeByte(10);
                bufferedSinkC.C0(this.f92800h.a());
                bufferedSinkC.writeByte(10);
                e(bufferedSinkC, this.f92800h.e());
                e(bufferedSinkC, this.f92800h.d());
            }
            bufferedSinkC.close();
        }

        public Entry(Response response) {
            this.f92793a = response.w().p();
            this.f92794b = OkHeaders.p(response);
            this.f92795c = response.w().m();
            this.f92796d = response.v();
            this.f92797e = response.n();
            this.f92798f = response.s();
            this.f92799g = response.r();
            this.f92800h = response.o();
        }
    }
}
