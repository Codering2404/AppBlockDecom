package okhttp3.internal.cache2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

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
public final class Relay {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f144365k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ByteString f144366l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ByteString f144367m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RandomAccessFile f144368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Source f144369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f144370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ByteString f144371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f144372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Thread f144373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Buffer f144374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f144375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Buffer f144376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f144377j;

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
    public final class RelaySource implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Timeout f144378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private FileOperator f144379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f144380c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Relay f144381d;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f144379b == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.f144379b = null;
            Relay relay = this.f144381d;
            synchronized (relay) {
                try {
                    relay.m(relay.f() - 1);
                    if (relay.f() == 0) {
                        RandomAccessFile randomAccessFileE = relay.e();
                        relay.l(null);
                        randomAccessFile = randomAccessFileE;
                    }
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (randomAccessFile == null) {
                return;
            }
            Util.m(randomAccessFile);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
        
            if (r0 != 2) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
        
            r6 = java.lang.Math.min(r23, r21.f144381d.i() - r21.f144380c);
            r2 = r21.f144379b;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
            r2.a(r21.f144380c + 32, r22, r6);
            r21.f144380c += r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x009a, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
        
            r0 = r21.f144381d.g();
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
            r11 = r0.t2(r21.f144381d.h(), r21.f144381d.c());
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00b7, code lost:
        
            if (r11 != (-1)) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00b9, code lost:
        
            r0 = r21.f144381d;
            r0.a(r0.i());
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00c2, code lost:
        
            r2 = r21.f144381d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00c4, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00c5, code lost:
        
            r2.o(null);
            r2.notifyAll();
            r0 = kotlin.Unit.f139807a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00cd, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00ce, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00d2, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00d5, code lost:
        
            r6 = java.lang.Math.min(r11, r23);
            r21.f144381d.h().j(r22, 0, r6);
            r21.f144380c += r6;
            r13 = r21.f144379b;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13);
            r13.b(r21.f144381d.i() + 32, r21.f144381d.h().clone(), r11);
            r4 = r21.f144381d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x010b, code lost:
        
            monitor-enter(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x010c, code lost:
        
            r4.b().H0(r4.h(), r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0125, code lost:
        
            if (r4.b().size() <= r4.c()) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0127, code lost:
        
            r4.b().skip(r4.b().size() - r4.c());
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x013c, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x013e, code lost:
        
            r4.n(r4.i() + r11);
            r0 = kotlin.Unit.f139807a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0148, code lost:
        
            monitor-exit(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0149, code lost:
        
            r2 = r21.f144381d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x014b, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x014c, code lost:
        
            r2.o(null);
            r2.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0152, code lost:
        
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0153, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0158, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0159, code lost:
        
            r2 = r21.f144381d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x015b, code lost:
        
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x015c, code lost:
        
            r2.o(null);
            r2.notifyAll();
            r3 = kotlin.Unit.f139807a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x0165, code lost:
        
            throw r0;
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long t2(okio.Buffer r22, long r23) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 371
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.t2(okio.Buffer, long):long");
        }

        @Override // okio.Source
        public Timeout v() {
            return this.f144378a;
        }
    }

    static {
        ByteString.Companion companion = ByteString.f144997d;
        f144366l = companion.d("OkHttp cache v1\n");
        f144367m = companion.d("OkHttp DIRTY :(\n");
    }

    private final void p(ByteString byteString, long j3, long j4) throws IOException {
        Buffer buffer = new Buffer();
        buffer.q2(byteString);
        buffer.A1(j3);
        buffer.A1(j4);
        if (buffer.size() != 32) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        RandomAccessFile randomAccessFile = this.f144368a;
        Intrinsics.checkNotNull(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
        new FileOperator(channel).b(0L, buffer, 32L);
    }

    private final void q(long j3) throws IOException {
        Buffer buffer = new Buffer();
        buffer.q2(this.f144371d);
        RandomAccessFile randomAccessFile = this.f144368a;
        Intrinsics.checkNotNull(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
        new FileOperator(channel).b(32 + j3, buffer, this.f144371d.C());
    }

    public final void a(long j3) throws IOException {
        q(j3);
        RandomAccessFile randomAccessFile = this.f144368a;
        Intrinsics.checkNotNull(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        p(f144366l, j3, this.f144371d.C());
        RandomAccessFile randomAccessFile2 = this.f144368a;
        Intrinsics.checkNotNull(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            k(true);
            Unit unit = Unit.f139807a;
        }
        Source source = this.f144369b;
        if (source != null) {
            Util.m(source);
        }
        this.f144369b = null;
    }

    public final Buffer b() {
        return this.f144376i;
    }

    public final long c() {
        return this.f144372e;
    }

    public final boolean d() {
        return this.f144375h;
    }

    public final RandomAccessFile e() {
        return this.f144368a;
    }

    public final int f() {
        return this.f144377j;
    }

    public final Source g() {
        return this.f144369b;
    }

    public final Buffer h() {
        return this.f144374g;
    }

    public final long i() {
        return this.f144370c;
    }

    public final Thread j() {
        return this.f144373f;
    }

    public final void k(boolean z2) {
        this.f144375h = z2;
    }

    public final void l(RandomAccessFile randomAccessFile) {
        this.f144368a = randomAccessFile;
    }

    public final void m(int i3) {
        this.f144377j = i3;
    }

    public final void n(long j3) {
        this.f144370c = j3;
    }

    public final void o(Thread thread) {
        this.f144373f = thread;
    }
}
