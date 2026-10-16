package okhttp3;

import java.io.Closeable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
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
public final class MultipartReader implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f144135f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Options f144136g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedSource f144137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ByteString f144138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f144139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PartSource f144140d;

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
    public static final class Part implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BufferedSource f144141a;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f144141a.close();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class PartSource implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Timeout f144142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MultipartReader f144143b;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (Intrinsics.areEqual(this.f144143b.f144140d, this)) {
                this.f144143b.f144140d = null;
            }
        }

        @Override // okio.Source
        public long t2(Buffer sink, long j3) {
            long j4;
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (j3 < 0) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(j3)).toString());
            }
            if (!Intrinsics.areEqual(this.f144143b.f144140d, this)) {
                throw new IllegalStateException("closed");
            }
            Timeout timeoutV = this.f144143b.f144137a.v();
            Timeout timeout = this.f144142a;
            MultipartReader multipartReader = this.f144143b;
            long jI = timeoutV.i();
            long jA = Timeout.f145127d.a(timeout.i(), timeoutV.i());
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            timeoutV.h(jA, timeUnit);
            if (!timeoutV.f()) {
                if (timeout.f()) {
                    timeoutV.e(timeout.d());
                }
                try {
                    long jI2 = multipartReader.i(j3);
                    long jT2 = jI2 == 0 ? -1L : multipartReader.f144137a.t2(sink, jI2);
                    timeoutV.h(jI, timeUnit);
                    if (timeout.f()) {
                        timeoutV.b();
                    }
                    return jT2;
                } catch (Throwable th) {
                    timeoutV.h(jI, TimeUnit.NANOSECONDS);
                    if (timeout.f()) {
                        timeoutV.b();
                    }
                    throw th;
                }
            }
            long jD = timeoutV.d();
            if (timeout.f()) {
                j4 = 0;
                timeoutV.e(Math.min(timeoutV.d(), timeout.d()));
            } else {
                j4 = 0;
            }
            try {
                long jI3 = multipartReader.i(j3);
                long jT22 = jI3 == j4 ? -1L : multipartReader.f144137a.t2(sink, jI3);
                timeoutV.h(jI, timeUnit);
                if (timeout.f()) {
                    timeoutV.e(jD);
                }
                return jT22;
            } catch (Throwable th2) {
                timeoutV.h(jI, TimeUnit.NANOSECONDS);
                if (timeout.f()) {
                    timeoutV.e(jD);
                }
                throw th2;
            }
        }

        @Override // okio.Source
        public Timeout v() {
            return this.f144142a;
        }
    }

    static {
        Options.Companion companion = Options.f145068c;
        ByteString.Companion companion2 = ByteString.f144997d;
        f144136g = companion.d(companion2.d("\r\n"), companion2.d("--"), companion2.d(" "), companion2.d("\t"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long i(long j3) {
        this.f144137a.g1(this.f144138b.C());
        long jC0 = this.f144137a.u().c0(this.f144138b);
        return jC0 == -1 ? Math.min(j3, (this.f144137a.u().size() - ((long) this.f144138b.C())) + 1) : Math.min(j3, jC0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f144139c) {
            return;
        }
        this.f144139c = true;
        this.f144140d = null;
        this.f144137a.close();
    }
}
