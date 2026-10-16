package com.applovin.impl;

import android.os.Process;
import androidx.core.util.Consumer;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class dg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PriorityBlockingQueue f59211a = new PriorityBlockingQueue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f59212b;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BlockingQueue f59213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f59214b;

        private b(BlockingQueue blockingQueue, int i3, com.applovin.impl.sdk.j jVar) {
            super("AppLovinSdk:network");
            if (blockingQueue == null) {
                throw new IllegalArgumentException("No request queue specified");
            }
            if (jVar == null) {
                throw new IllegalArgumentException("No sdk specified");
            }
            this.f59213a = blockingQueue;
            this.f59214b = jVar;
            setPriority(((Integer) jVar.a(sj.U)).intValue());
        }

        private HttpURLConnection a(c cVar) throws ProtocolException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(cVar.f59216a).openConnection();
            httpURLConnection.setRequestMethod(cVar.f59217b);
            httpURLConnection.setConnectTimeout(cVar.f59220f);
            httpURLConnection.setReadTimeout(cVar.f59220f);
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoInput(true);
            if (!cVar.f59218c.isEmpty()) {
                for (Map.Entry entry : cVar.f59218c.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            return httpURLConnection;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(c cVar, d dVar) {
            cVar.f59221g.accept(dVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:128:0x0249 A[Catch: all -> 0x0253, TRY_LEAVE, TryCatch #16 {all -> 0x0253, blocks: (B:126:0x0231, B:128:0x0249), top: B:181:0x0231 }] */
        /* JADX WARN: Removed duplicated region for block: B:147:0x029c  */
        /* JADX WARN: Removed duplicated region for block: B:156:0x0259 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:191:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00e7 A[Catch: all -> 0x00f1, TRY_LEAVE, TryCatch #6 {all -> 0x00f1, blocks: (B:57:0x00cf, B:59:0x00e7, B:82:0x011d), top: B:163:0x00cf }] */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0138  */
        /* JADX WARN: Type inference failed for: r15v0 */
        /* JADX WARN: Type inference failed for: r15v1, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r15v16 */
        /* JADX WARN: Type inference failed for: r15v17 */
        /* JADX WARN: Type inference failed for: r15v18 */
        /* JADX WARN: Type inference failed for: r15v19 */
        /* JADX WARN: Type inference failed for: r15v2, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r15v20 */
        /* JADX WARN: Type inference failed for: r15v3 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void b(final com.applovin.impl.dg.c r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 746
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.dg.b.b(com.applovin.impl.dg$c):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(c cVar, d dVar) {
            cVar.f59221g.accept(dVar);
        }

        private void a() throws Throwable {
            b((c) this.f59213a.take());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class c implements Comparable {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final AtomicInteger f59215j = new AtomicInteger();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f59216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f59217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map f59218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final byte[] f59219d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f59220f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Consumer f59221g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Executor f59222h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f59223i;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f59224a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f59225b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private Map f59226c = new HashMap();

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private byte[] f59227d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private int f59228e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private Consumer f59229f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private Executor f59230g;

            public a a(byte[] bArr) {
                this.f59227d = bArr;
                return this;
            }

            public a b(String str) {
                this.f59225b = str;
                return this;
            }

            public a a(String str) {
                this.f59224a = str;
                return this;
            }

            public a a(String str, String str2) {
                this.f59226c.put(str, str2);
                return this;
            }

            public a a(Map map) {
                if (map == null) {
                    map = new HashMap();
                }
                this.f59226c = map;
                return this;
            }

            public a a(Consumer consumer) {
                this.f59229f = consumer;
                return this;
            }

            public a a(Executor executor) {
                this.f59230g = executor;
                return this;
            }

            public a a(int i3) {
                this.f59228e = i3;
                return this;
            }

            public c a() {
                return new c(this);
            }
        }

        private c(a aVar) {
            this.f59216a = aVar.f59224a;
            this.f59217b = aVar.f59225b;
            this.f59218c = aVar.f59226c != null ? aVar.f59226c : Collections.EMPTY_MAP;
            this.f59219d = aVar.f59227d;
            this.f59220f = aVar.f59228e;
            this.f59221g = aVar.f59229f;
            this.f59222h = aVar.f59230g;
            this.f59223i = f59215j.incrementAndGet();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return this.f59223i - cVar.f59223i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f59231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f59232b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f59233c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f59234d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Throwable f59235e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f59236a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private byte[] f59237b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private byte[] f59238c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private long f59239d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private Throwable f59240e;

            public a a(int i3) {
                this.f59236a = i3;
                return this;
            }

            public a b(byte[] bArr) {
                this.f59238c = bArr;
                return this;
            }

            public a a(byte[] bArr) {
                this.f59237b = bArr;
                return this;
            }

            public a a(long j3) {
                this.f59239d = j3;
                return this;
            }

            public a a(Throwable th) {
                this.f59240e = th;
                return this;
            }

            public d a() {
                return new d(this);
            }
        }

        private d(a aVar) {
            this.f59231a = aVar.f59236a;
            this.f59232b = aVar.f59237b;
            this.f59233c = aVar.f59238c;
            this.f59234d = aVar.f59239d;
            this.f59235e = aVar.f59240e;
        }

        public static a a() {
            return new a();
        }

        public int b() {
            return this.f59231a;
        }

        public int c() throws Throwable {
            Throwable th = this.f59235e;
            if (th == null) {
                return this.f59231a;
            }
            throw th;
        }

        public byte[] d() throws Throwable {
            Throwable th = this.f59235e;
            if (th == null) {
                return this.f59232b;
            }
            throw th;
        }

        public long e() {
            return this.f59234d;
        }

        public byte[] f() {
            return this.f59233c;
        }
    }

    public dg(com.applovin.impl.sdk.j jVar) {
        this.f59212b = jVar;
    }

    public void a(c cVar) {
        if (cVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        this.f59211a.add(cVar);
    }

    public void a() {
        for (int i3 = 0; i3 < ((Integer) this.f59212b.a(sj.T)).intValue(); i3++) {
            new b(this.f59211a, i3, this.f59212b).start();
        }
    }
}
