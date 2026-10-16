package okhttp3;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okio.BufferedSink;
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
public abstract class RequestBody {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f144218a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ RequestBody g(Companion companion, String str, MediaType mediaType, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            return companion.a(str, mediaType);
        }

        public static /* synthetic */ RequestBody h(Companion companion, MediaType mediaType, byte[] bArr, int i3, int i4, int i5, Object obj) {
            if ((i5 & 4) != 0) {
                i3 = 0;
            }
            if ((i5 & 8) != 0) {
                i4 = bArr.length;
            }
            return companion.d(mediaType, bArr, i3, i4);
        }

        public static /* synthetic */ RequestBody i(Companion companion, byte[] bArr, MediaType mediaType, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                mediaType = null;
            }
            if ((i5 & 2) != 0) {
                i3 = 0;
            }
            if ((i5 & 4) != 0) {
                i4 = bArr.length;
            }
            return companion.f(bArr, mediaType, i3, i4);
        }

        public final RequestBody a(String str, MediaType mediaType) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Charset charset = Charsets.f140510b;
            if (mediaType != null) {
                Charset charsetD = MediaType.d(mediaType, null, 1, null);
                if (charsetD == null) {
                    mediaType = MediaType.f144108e.b(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetD;
                }
            }
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return f(bytes, mediaType, 0, bytes.length);
        }

        public final RequestBody b(MediaType mediaType, ByteString content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return e(content, mediaType);
        }

        public final RequestBody c(MediaType mediaType, byte[] content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return h(this, mediaType, content, 0, 0, 12, null);
        }

        public final RequestBody d(MediaType mediaType, byte[] content, int i3, int i4) {
            Intrinsics.checkNotNullParameter(content, "content");
            return f(content, mediaType, i3, i4);
        }

        public final RequestBody e(final ByteString byteString, final MediaType mediaType) {
            Intrinsics.checkNotNullParameter(byteString, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long a() {
                    return byteString.C();
                }

                @Override // okhttp3.RequestBody
                public MediaType b() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void g(BufferedSink sink) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    sink.q2(byteString);
                }
            };
        }

        public final RequestBody f(final byte[] bArr, final MediaType mediaType, final int i3, final int i4) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            Util.l(bArr.length, i3, i4);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public long a() {
                    return i4;
                }

                @Override // okhttp3.RequestBody
                public MediaType b() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void g(BufferedSink sink) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    sink.write(bArr, i3, i4);
                }
            };
        }

        private Companion() {
        }
    }

    public static final RequestBody c(MediaType mediaType, ByteString byteString) {
        return f144218a.b(mediaType, byteString);
    }

    public static final RequestBody d(MediaType mediaType, byte[] bArr) {
        return f144218a.c(mediaType, bArr);
    }

    public long a() {
        return -1L;
    }

    public abstract MediaType b();

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public abstract void g(BufferedSink bufferedSink);
}
