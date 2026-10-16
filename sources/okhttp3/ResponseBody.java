package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;

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
public abstract class ResponseBody implements Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f144254b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Reader f144255a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BomAwareReader extends Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BufferedSource f144256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Charset f144257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f144258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Reader f144259d;

        public BomAwareReader(BufferedSource source, Charset charset) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(charset, "charset");
            this.f144256a = source;
            this.f144257b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Unit unit;
            this.f144258c = true;
            Reader reader = this.f144259d;
            if (reader == null) {
                unit = null;
            } else {
                reader.close();
                unit = Unit.f139807a;
            }
            if (unit == null) {
                this.f144256a.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cbuf, int i3, int i4) throws IOException {
            Intrinsics.checkNotNullParameter(cbuf, "cbuf");
            if (this.f144258c) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.f144259d;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.f144256a.H2(), Util.J(this.f144256a, this.f144257b));
                this.f144259d = inputStreamReader;
            }
            return inputStreamReader.read(cbuf, i3, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ResponseBody d(Companion companion, byte[] bArr, MediaType mediaType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            return companion.c(bArr, mediaType);
        }

        public final ResponseBody a(MediaType mediaType, long j3, BufferedSource content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return b(content, mediaType, j3);
        }

        public final ResponseBody b(final BufferedSource bufferedSource, final MediaType mediaType, final long j3) {
            Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                public long f() {
                    return j3;
                }

                @Override // okhttp3.ResponseBody
                public MediaType i() {
                    return mediaType;
                }

                @Override // okhttp3.ResponseBody
                public BufferedSource k() {
                    return bufferedSource;
                }
            };
        }

        public final ResponseBody c(byte[] bArr, MediaType mediaType) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            return b(new Buffer().write(bArr), mediaType, bArr.length);
        }

        private Companion() {
        }
    }

    private final Charset c() {
        MediaType mediaTypeI = i();
        Charset charsetC = mediaTypeI == null ? null : mediaTypeI.c(Charsets.f140510b);
        return charsetC == null ? Charsets.f140510b : charsetC;
    }

    public static final ResponseBody j(MediaType mediaType, long j3, BufferedSource bufferedSource) {
        return f144254b.a(mediaType, j3, bufferedSource);
    }

    public final InputStream a() {
        return k().H2();
    }

    public final Reader b() {
        Reader reader = this.f144255a;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(k(), c());
        this.f144255a = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.m(k());
    }

    public abstract long f();

    public abstract MediaType i();

    public abstract BufferedSource k();

    public final String l() {
        BufferedSource bufferedSourceK = k();
        try {
            String strZ1 = bufferedSourceK.Z1(Util.J(bufferedSourceK, c()));
            CloseableKt.a(bufferedSourceK, null);
            return strZ1;
        } finally {
        }
    }
}
