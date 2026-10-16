package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

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
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Companion f144873y = new Companion(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final List f144874z = CollectionsKt.listOf(Protocol.HTTP_1_1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebSocketListener f144875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Random f144876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f144877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WebSocketExtensions f144878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f144879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f144880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Call f144881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Task f144882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private WebSocketReader f144883i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private WebSocketWriter f144884j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TaskQueue f144885k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f144886l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Streams f144887m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ArrayDeque f144888n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ArrayDeque f144889o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f144890p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f144891q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f144892r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f144893s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f144894t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f144895u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f144896v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f144897w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f144898x;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Close {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f144899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ByteString f144900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f144901c;

        public Close(int i3, ByteString byteString, long j3) {
            this.f144899a = i3;
            this.f144900b = byteString;
            this.f144901c = j3;
        }

        public final long a() {
            return this.f144901c;
        }

        public final int b() {
            return this.f144899a;
        }

        public final ByteString c() {
            return this.f144900b;
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

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Message {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f144902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ByteString f144903b;

        public final ByteString a() {
            return this.f144903b;
        }

        public final int b() {
            return this.f144902a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Streams implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f144904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BufferedSource f144905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final BufferedSink f144906c;

        public Streams(boolean z2, BufferedSource source, BufferedSink sink) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            this.f144904a = z2;
            this.f144905b = source;
            this.f144906c = sink;
        }

        public final boolean a() {
            return this.f144904a;
        }

        public final BufferedSink b() {
            return this.f144906c;
        }

        public final BufferedSource c() {
            return this.f144905b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class WriterTask extends Task {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ RealWebSocket f144907e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WriterTask(RealWebSocket this$0) {
            super(Intrinsics.stringPlus(this$0.f144886l, " writer"), false, 2, null);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.f144907e = this$0;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long f() {
            try {
                return this.f144907e.t() ? 0L : -1L;
            } catch (IOException e3) {
                this.f144907e.n(e3, null);
                return -1L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q(WebSocketExtensions webSocketExtensions) {
        if (!webSocketExtensions.f144922f && webSocketExtensions.f144918b == null) {
            return webSocketExtensions.f144920d == null || new IntRange(8, 15).p(webSocketExtensions.f144920d.intValue());
        }
        return false;
    }

    private final void s() {
        if (!Util.f144281h || Thread.holdsLock(this)) {
            Task task = this.f144882h;
            if (task != null) {
                TaskQueue.j(this.f144885k, task, 0L, 2, null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void a(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.f144875a.e(this, bytes);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void b(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.f144875a.d(this, text);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void c(ByteString payload) {
        try {
            Intrinsics.checkNotNullParameter(payload, "payload");
            if (!this.f144894t && (!this.f144891q || !this.f144889o.isEmpty())) {
                this.f144888n.add(payload);
                s();
                this.f144896v++;
            }
        } finally {
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void d(ByteString payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.f144897w++;
        this.f144898x = false;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void e(int i3, String reason) {
        Streams streams;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (i3 == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        synchronized (this) {
            try {
                if (this.f144892r != -1) {
                    throw new IllegalStateException("already closed");
                }
                this.f144892r = i3;
                this.f144893s = reason;
                streams = null;
                if (this.f144891q && this.f144889o.isEmpty()) {
                    Streams streams2 = this.f144887m;
                    this.f144887m = null;
                    webSocketReader = this.f144883i;
                    this.f144883i = null;
                    webSocketWriter = this.f144884j;
                    this.f144884j = null;
                    this.f144885k.o();
                    streams = streams2;
                } else {
                    webSocketReader = null;
                    webSocketWriter = null;
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            this.f144875a.b(this, i3, reason);
            if (streams != null) {
                this.f144875a.a(this, i3, reason);
            }
            if (streams != null) {
                Util.m(streams);
            }
            if (webSocketReader != null) {
                Util.m(webSocketReader);
            }
            if (webSocketWriter == null) {
                return;
            }
            Util.m(webSocketWriter);
        } catch (Throwable th2) {
            if (streams != null) {
                Util.m(streams);
            }
            if (webSocketReader != null) {
                Util.m(webSocketReader);
            }
            if (webSocketWriter != null) {
                Util.m(webSocketWriter);
            }
            throw th2;
        }
    }

    public void j() {
        Call call = this.f144881g;
        Intrinsics.checkNotNull(call);
        call.cancel();
    }

    public final void k(Response response, Exchange exchange) throws ProtocolException {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.i() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.i() + ' ' + response.z() + '\'');
        }
        String strN = Response.n(response, "Connection", null, 2, null);
        if (!StringsKt.F("Upgrade", strN, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + ((Object) strN) + '\'');
        }
        String strN2 = Response.n(response, "Upgrade", null, 2, null);
        if (!StringsKt.F("websocket", strN2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + ((Object) strN2) + '\'');
        }
        String strN3 = Response.n(response, "Sec-WebSocket-Accept", null, 2, null);
        String strA = ByteString.f144997d.d(Intrinsics.stringPlus(this.f144880f, "258EAFA5-E914-47DA-95CA-C5AB0DC85B11")).A().a();
        if (Intrinsics.areEqual(strA, strN3)) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strA + "' but was '" + ((Object) strN3) + '\'');
    }

    public boolean l(int i3, String str) {
        return m(i3, str, 60000L);
    }

    public final synchronized boolean m(int i3, String str, long j3) {
        ByteString byteStringD;
        try {
            WebSocketProtocol.f144923a.c(i3);
            if (str != null) {
                byteStringD = ByteString.f144997d.d(str);
                if (byteStringD.C() > 123) {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("reason.size() > 123: ", str).toString());
                }
            } else {
                byteStringD = null;
            }
            if (!this.f144894t && !this.f144891q) {
                this.f144891q = true;
                this.f144889o.add(new Close(i3, byteStringD, j3));
                s();
                return true;
            }
            return false;
        } finally {
        }
    }

    public final void n(Exception e3, Response response) {
        Intrinsics.checkNotNullParameter(e3, "e");
        synchronized (this) {
            if (this.f144894t) {
                return;
            }
            this.f144894t = true;
            Streams streams = this.f144887m;
            this.f144887m = null;
            WebSocketReader webSocketReader = this.f144883i;
            this.f144883i = null;
            WebSocketWriter webSocketWriter = this.f144884j;
            this.f144884j = null;
            this.f144885k.o();
            Unit unit = Unit.f139807a;
            try {
                this.f144875a.c(this, e3, response);
                if (streams != null) {
                    Util.m(streams);
                }
                if (webSocketReader != null) {
                    Util.m(webSocketReader);
                }
                if (webSocketWriter == null) {
                    return;
                }
                Util.m(webSocketWriter);
            } catch (Throwable th) {
                if (streams != null) {
                    Util.m(streams);
                }
                if (webSocketReader != null) {
                    Util.m(webSocketReader);
                }
                if (webSocketWriter != null) {
                    Util.m(webSocketWriter);
                }
                throw th;
            }
        }
    }

    public final WebSocketListener o() {
        return this.f144875a;
    }

    public final void p(String name, Streams streams) throws Throwable {
        Throwable th;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(streams, "streams");
        WebSocketExtensions webSocketExtensions = this.f144878d;
        Intrinsics.checkNotNull(webSocketExtensions);
        synchronized (this) {
            try {
                this.f144886l = name;
                this.f144887m = streams;
                this.f144884j = new WebSocketWriter(streams.a(), streams.b(), this.f144876b, webSocketExtensions.f144917a, webSocketExtensions.a(streams.a()), this.f144879e);
                this.f144882h = new WriterTask(this);
                long j3 = this.f144877c;
                if (j3 != 0) {
                    try {
                        final long nanos = TimeUnit.MILLISECONDS.toNanos(j3);
                        TaskQueue taskQueue = this.f144885k;
                        final String strStringPlus = Intrinsics.stringPlus(name, " ping");
                        taskQueue.i(new Task(strStringPlus, this, nanos) { // from class: okhttp3.internal.ws.RealWebSocket$initReaderAndWriter$lambda-3$$inlined$schedule$1

                            /* JADX INFO: renamed from: e, reason: collision with root package name */
                            final /* synthetic */ String f144910e;

                            /* JADX INFO: renamed from: f, reason: collision with root package name */
                            final /* synthetic */ RealWebSocket f144911f;

                            /* JADX INFO: renamed from: g, reason: collision with root package name */
                            final /* synthetic */ long f144912g;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(strStringPlus, false, 2, null);
                                this.f144910e = strStringPlus;
                                this.f144911f = this;
                                this.f144912g = nanos;
                            }

                            @Override // okhttp3.internal.concurrent.Task
                            public long f() {
                                this.f144911f.u();
                                return this.f144912g;
                            }
                        }, nanos);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                if (!this.f144889o.isEmpty()) {
                    s();
                }
                Unit unit = Unit.f139807a;
                this.f144883i = new WebSocketReader(streams.a(), streams.c(), this, webSocketExtensions.f144917a, webSocketExtensions.a(!streams.a()));
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public final void r() {
        while (this.f144892r == -1) {
            WebSocketReader webSocketReader = this.f144883i;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.a();
        }
    }

    public final boolean t() {
        String str;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        int i3;
        Streams streams;
        synchronized (this) {
            try {
                if (this.f144894t) {
                    return false;
                }
                WebSocketWriter webSocketWriter2 = this.f144884j;
                Object objPoll = this.f144888n.poll();
                final boolean z2 = true;
                Object obj = null;
                if (objPoll == null) {
                    Object objPoll2 = this.f144889o.poll();
                    if (objPoll2 instanceof Close) {
                        i3 = this.f144892r;
                        str = this.f144893s;
                        if (i3 != -1) {
                            streams = this.f144887m;
                            this.f144887m = null;
                            webSocketReader = this.f144883i;
                            this.f144883i = null;
                            webSocketWriter = this.f144884j;
                            this.f144884j = null;
                            this.f144885k.o();
                        } else {
                            long jA = ((Close) objPoll2).a();
                            TaskQueue taskQueue = this.f144885k;
                            final String strStringPlus = Intrinsics.stringPlus(this.f144886l, " cancel");
                            taskQueue.i(new Task(strStringPlus, z2, this) { // from class: okhttp3.internal.ws.RealWebSocket$writeOneFrame$lambda-8$$inlined$execute$default$1

                                /* JADX INFO: renamed from: e, reason: collision with root package name */
                                final /* synthetic */ String f144913e;

                                /* JADX INFO: renamed from: f, reason: collision with root package name */
                                final /* synthetic */ boolean f144914f;

                                /* JADX INFO: renamed from: g, reason: collision with root package name */
                                final /* synthetic */ RealWebSocket f144915g;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(strStringPlus, z2);
                                    this.f144913e = strStringPlus;
                                    this.f144914f = z2;
                                    this.f144915g = this;
                                }

                                @Override // okhttp3.internal.concurrent.Task
                                public long f() {
                                    this.f144915g.j();
                                    return -1L;
                                }
                            }, TimeUnit.MILLISECONDS.toNanos(jA));
                            streams = null;
                            webSocketReader = null;
                            webSocketWriter = null;
                        }
                    } else {
                        if (objPoll2 == null) {
                            return false;
                        }
                        str = null;
                        webSocketReader = null;
                        webSocketWriter = null;
                        i3 = -1;
                        streams = null;
                    }
                    obj = objPoll2;
                } else {
                    str = null;
                    webSocketReader = null;
                    webSocketWriter = null;
                    i3 = -1;
                    streams = null;
                }
                Unit unit = Unit.f139807a;
                try {
                    if (objPoll != null) {
                        Intrinsics.checkNotNull(webSocketWriter2);
                        webSocketWriter2.i((ByteString) objPoll);
                    } else if (obj instanceof Message) {
                        Message message = (Message) obj;
                        Intrinsics.checkNotNull(webSocketWriter2);
                        webSocketWriter2.c(message.b(), message.a());
                        synchronized (this) {
                            this.f144890p -= (long) message.a().C();
                        }
                    } else {
                        if (!(obj instanceof Close)) {
                            throw new AssertionError();
                        }
                        Close close = (Close) obj;
                        Intrinsics.checkNotNull(webSocketWriter2);
                        webSocketWriter2.a(close.b(), close.c());
                        if (streams != null) {
                            WebSocketListener webSocketListener = this.f144875a;
                            Intrinsics.checkNotNull(str);
                            webSocketListener.a(this, i3, str);
                        }
                    }
                    if (streams != null) {
                        Util.m(streams);
                    }
                    if (webSocketReader != null) {
                        Util.m(webSocketReader);
                    }
                    if (webSocketWriter == null) {
                        return true;
                    }
                    Util.m(webSocketWriter);
                    return true;
                } catch (Throwable th) {
                    if (streams != null) {
                        Util.m(streams);
                    }
                    if (webSocketReader != null) {
                        Util.m(webSocketReader);
                    }
                    if (webSocketWriter != null) {
                        Util.m(webSocketWriter);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void u() {
        synchronized (this) {
            try {
                if (this.f144894t) {
                    return;
                }
                WebSocketWriter webSocketWriter = this.f144884j;
                if (webSocketWriter == null) {
                    return;
                }
                int i3 = this.f144898x ? this.f144895u : -1;
                this.f144895u++;
                this.f144898x = true;
                Unit unit = Unit.f139807a;
                if (i3 == -1) {
                    try {
                        webSocketWriter.f(ByteString.f144998f);
                        return;
                    } catch (IOException e3) {
                        n(e3, null);
                        return;
                    }
                }
                n(new SocketTimeoutException("sent ping but didn't receive pong within " + this.f144877c + "ms (after " + (i3 - 1) + " successful ping/pongs)"), null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
