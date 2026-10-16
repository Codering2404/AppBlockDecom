package okhttp3;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.Buffer;
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
public final class MultipartBody extends RequestBody {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f144115g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MediaType f144116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final MediaType f144117i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final MediaType f144118j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final MediaType f144119k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final MediaType f144120l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final byte[] f144121m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final byte[] f144122n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final byte[] f144123o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ByteString f144124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MediaType f144125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f144126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MediaType f144127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f144128f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteString f144129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MediaType f144130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f144131c;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final Builder a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            d(Part.f144132c.b(name, value));
            return this;
        }

        public final Builder b(String name, String str, RequestBody body) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(body, "body");
            d(Part.f144132c.c(name, str, body));
            return this;
        }

        public final Builder c(Headers headers, RequestBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            d(Part.f144132c.a(headers, body));
            return this;
        }

        public final Builder d(Part part) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.f144131c.add(part);
            return this;
        }

        public final MultipartBody e() {
            if (this.f144131c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.f144129a, this.f144130b, Util.V(this.f144131c));
        }

        public final Builder f(MediaType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (!Intrinsics.areEqual(type.h(), "multipart")) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("multipart != ", type).toString());
            }
            this.f144130b = type;
            return this;
        }

        public Builder(String boundary) {
            Intrinsics.checkNotNullParameter(boundary, "boundary");
            this.f144129a = ByteString.f144997d.d(boundary);
            this.f144130b = MultipartBody.f144116h;
            this.f144131c = new ArrayList();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Builder(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i3 & 1) != 0) {
                str = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
            }
            this(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(StringBuilder sb, String key) {
            Intrinsics.checkNotNullParameter(sb, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            sb.append('\"');
            int length = key.length();
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3 + 1;
                char cCharAt = key.charAt(i3);
                if (cCharAt == '\n') {
                    sb.append("%0A");
                } else if (cCharAt == '\r') {
                    sb.append("%0D");
                } else if (cCharAt == '\"') {
                    sb.append("%22");
                } else {
                    sb.append(cCharAt);
                }
                i3 = i4;
            }
            sb.append('\"');
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Part {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Companion f144132c = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Headers f144133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RequestBody f144134b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Part a(Headers headers, RequestBody body) {
                Intrinsics.checkNotNullParameter(body, "body");
                DefaultConstructorMarker defaultConstructorMarker = null;
                if ((headers == null ? null : headers.a("Content-Type")) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if ((headers == null ? null : headers.a(HttpHeaders.CONTENT_LENGTH)) == null) {
                    return new Part(headers, body, defaultConstructorMarker);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }

            public final Part b(String name, String value) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                return c(name, null, RequestBody.Companion.g(RequestBody.f144218a, value, null, 1, null));
            }

            public final Part c(String name, String str, RequestBody body) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(body, "body");
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                Companion companion = MultipartBody.f144115g;
                companion.a(sb, name);
                if (str != null) {
                    sb.append("; filename=");
                    companion.a(sb, str);
                }
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
                return a(new Headers.Builder().e("Content-Disposition", string).f(), body);
            }

            private Companion() {
            }
        }

        public /* synthetic */ Part(Headers headers, RequestBody requestBody, DefaultConstructorMarker defaultConstructorMarker) {
            this(headers, requestBody);
        }

        public final RequestBody a() {
            return this.f144134b;
        }

        public final Headers b() {
            return this.f144133a;
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.f144133a = headers;
            this.f144134b = requestBody;
        }
    }

    static {
        MediaType.Companion companion = MediaType.f144108e;
        f144116h = companion.a("multipart/mixed");
        f144117i = companion.a("multipart/alternative");
        f144118j = companion.a("multipart/digest");
        f144119k = companion.a("multipart/parallel");
        f144120l = companion.a("multipart/form-data");
        f144121m = new byte[]{58, 32};
        f144122n = new byte[]{Ascii.CR, 10};
        f144123o = new byte[]{Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX};
    }

    public MultipartBody(ByteString boundaryByteString, MediaType type, List parts) {
        Intrinsics.checkNotNullParameter(boundaryByteString, "boundaryByteString");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(parts, "parts");
        this.f144124b = boundaryByteString;
        this.f144125c = type;
        this.f144126d = parts;
        this.f144127e = MediaType.f144108e.a(type + "; boundary=" + h());
        this.f144128f = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long i(BufferedSink bufferedSink, boolean z2) throws EOFException {
        Buffer buffer;
        if (z2) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.f144126d.size();
        long j3 = 0;
        int i3 = 0;
        while (i3 < size) {
            int i4 = i3 + 1;
            Part part = (Part) this.f144126d.get(i3);
            Headers headersB = part.b();
            RequestBody requestBodyA = part.a();
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.write(f144123o);
            bufferedSink.q2(this.f144124b);
            bufferedSink.write(f144122n);
            if (headersB != null) {
                int size2 = headersB.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    bufferedSink.C0(headersB.d(i5)).write(f144121m).C0(headersB.h(i5)).write(f144122n);
                }
            }
            MediaType mediaTypeB = requestBodyA.b();
            if (mediaTypeB != null) {
                bufferedSink.C0("Content-Type: ").C0(mediaTypeB.toString()).write(f144122n);
            }
            long jA = requestBodyA.a();
            if (jA != -1) {
                bufferedSink.C0("Content-Length: ").j1(jA).write(f144122n);
            } else if (z2) {
                Intrinsics.checkNotNull(buffer);
                buffer.a();
                return -1L;
            }
            byte[] bArr = f144122n;
            bufferedSink.write(bArr);
            if (z2) {
                j3 += jA;
            } else {
                requestBodyA.g(bufferedSink);
            }
            bufferedSink.write(bArr);
            i3 = i4;
        }
        Intrinsics.checkNotNull(bufferedSink);
        byte[] bArr2 = f144123o;
        bufferedSink.write(bArr2);
        bufferedSink.q2(this.f144124b);
        bufferedSink.write(bArr2);
        bufferedSink.write(f144122n);
        if (!z2) {
            return j3;
        }
        Intrinsics.checkNotNull(buffer);
        long size3 = j3 + buffer.size();
        buffer.a();
        return size3;
    }

    @Override // okhttp3.RequestBody
    public long a() throws EOFException {
        long j3 = this.f144128f;
        if (j3 != -1) {
            return j3;
        }
        long jI = i(null, true);
        this.f144128f = jI;
        return jI;
    }

    @Override // okhttp3.RequestBody
    public MediaType b() {
        return this.f144127e;
    }

    @Override // okhttp3.RequestBody
    public void g(BufferedSink sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        i(sink, false);
    }

    public final String h() {
        return this.f144124b.I();
    }
}
