package retrofit2;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.EOFException;
import java.util.regex.Pattern;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class RequestBuilder {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final char[] f146938l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f146939m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f146940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HttpUrl f146941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f146942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HttpUrl.Builder f146943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Request.Builder f146944e = new Request.Builder();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Headers.Builder f146945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MediaType f146946g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f146947h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MultipartBody.Builder f146948i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private FormBody.Builder f146949j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private RequestBody f146950k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ContentTypeOverridingRequestBody extends RequestBody {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RequestBody f146951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MediaType f146952c;

        ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
            this.f146951b = requestBody;
            this.f146952c = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long a() {
            return this.f146951b.a();
        }

        @Override // okhttp3.RequestBody
        public MediaType b() {
            return this.f146952c;
        }

        @Override // okhttp3.RequestBody
        public void g(BufferedSink bufferedSink) {
            this.f146951b.g(bufferedSink);
        }
    }

    RequestBuilder(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z2, boolean z3, boolean z4) {
        this.f146940a = str;
        this.f146941b = httpUrl;
        this.f146942c = str2;
        this.f146946g = mediaType;
        this.f146947h = z2;
        if (headers != null) {
            this.f146945f = headers.f();
        } else {
            this.f146945f = new Headers.Builder();
        }
        if (z3) {
            this.f146949j = new FormBody.Builder();
        } else if (z4) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.f146948i = builder;
            builder.f(MultipartBody.f144120l);
        }
    }

    private static String i(String str, boolean z2) throws EOFException {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z2 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                Buffer buffer = new Buffer();
                buffer.J0(str, 0, iCharCount);
                j(buffer, str, iCharCount, length, z2);
                return buffer.e0();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    private static void j(Buffer buffer, String str, int i3, int i4, boolean z2) throws EOFException {
        Buffer buffer2 = null;
        while (i3 < i4) {
            int iCodePointAt = str.codePointAt(i3);
            if (!z2 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z2 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.Y1(iCodePointAt);
                    while (!buffer2.G1()) {
                        byte b3 = buffer2.readByte();
                        buffer.writeByte(37);
                        char[] cArr = f146938l;
                        buffer.writeByte(cArr[((b3 & 255) >> 4) & 15]);
                        buffer.writeByte(cArr[b3 & Ascii.SI]);
                    }
                } else {
                    buffer.Y1(iCodePointAt);
                }
            }
            i3 += Character.charCount(iCodePointAt);
        }
    }

    void a(String str, String str2, boolean z2) {
        if (z2) {
            this.f146949j.b(str, str2);
        } else {
            this.f146949j.a(str, str2);
        }
    }

    void b(String str, String str2, boolean z2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            if (z2) {
                this.f146945f.e(str, str2);
                return;
            } else {
                this.f146945f.a(str, str2);
                return;
            }
        }
        try {
            this.f146946g = MediaType.e(str2);
        } catch (IllegalArgumentException e3) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e3);
        }
    }

    void c(Headers headers) {
        this.f146945f.b(headers);
    }

    void d(Headers headers, RequestBody requestBody) {
        this.f146948i.c(headers, requestBody);
    }

    void e(MultipartBody.Part part) {
        this.f146948i.d(part);
    }

    void f(String str, String str2, boolean z2) throws EOFException {
        if (this.f146942c == null) {
            throw new AssertionError();
        }
        String strI = i(str2, z2);
        String strReplace = this.f146942c.replace("{" + str + "}", strI);
        if (!f146939m.matcher(strReplace).matches()) {
            this.f146942c = strReplace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    void g(String str, String str2, boolean z2) {
        String str3 = this.f146942c;
        if (str3 != null) {
            HttpUrl.Builder builderL = this.f146941b.l(str3);
            this.f146943d = builderL;
            if (builderL == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f146941b + ", Relative: " + this.f146942c);
            }
            this.f146942c = null;
        }
        if (z2) {
            this.f146943d.a(str, str2);
        } else {
            this.f146943d.b(str, str2);
        }
    }

    void h(Class cls, Object obj) {
        this.f146944e.o(cls, obj);
    }

    Request.Builder k() {
        HttpUrl httpUrlQ;
        HttpUrl.Builder builder = this.f146943d;
        if (builder != null) {
            httpUrlQ = builder.c();
        } else {
            httpUrlQ = this.f146941b.q(this.f146942c);
            if (httpUrlQ == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f146941b + ", Relative: " + this.f146942c);
            }
        }
        RequestBody contentTypeOverridingRequestBody = this.f146950k;
        if (contentTypeOverridingRequestBody == null) {
            FormBody.Builder builder2 = this.f146949j;
            if (builder2 != null) {
                contentTypeOverridingRequestBody = builder2.c();
            } else {
                MultipartBody.Builder builder3 = this.f146948i;
                if (builder3 != null) {
                    contentTypeOverridingRequestBody = builder3.e();
                } else if (this.f146947h) {
                    contentTypeOverridingRequestBody = RequestBody.d(null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f146946g;
        if (mediaType != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, mediaType);
            } else {
                this.f146945f.a("Content-Type", mediaType.toString());
            }
        }
        return this.f146944e.r(httpUrlQ).g(this.f146945f.f()).h(this.f146940a, contentTypeOverridingRequestBody);
    }

    void l(RequestBody requestBody) {
        this.f146950k = requestBody;
    }

    void m(Object obj) {
        this.f146942c = obj.toString();
    }
}
