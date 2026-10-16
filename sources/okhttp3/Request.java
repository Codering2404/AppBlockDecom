package okhttp3;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

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
public final class Request {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HttpUrl f144207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f144208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Headers f144209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RequestBody f144210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f144211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CacheControl f144212f;

    public Request(HttpUrl url, String method, Headers headers, RequestBody requestBody, Map tags) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.f144207a = url;
        this.f144208b = method;
        this.f144209c = headers;
        this.f144210d = requestBody;
        this.f144211e = tags;
    }

    public final RequestBody a() {
        return this.f144210d;
    }

    public final CacheControl b() {
        CacheControl cacheControl = this.f144212f;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControlB = CacheControl.f143911n.b(this.f144209c);
        this.f144212f = cacheControlB;
        return cacheControlB;
    }

    public final Map c() {
        return this.f144211e;
    }

    public final String d(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f144209c.a(name);
    }

    public final List e(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f144209c.l(name);
    }

    public final Headers f() {
        return this.f144209c;
    }

    public final boolean g() {
        return this.f144207a.j();
    }

    public final String h() {
        return this.f144208b;
    }

    public final Builder i() {
        return new Builder(this);
    }

    public final Object j(Class type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return type.cast(this.f144211e.get(type));
    }

    public final HttpUrl k() {
        return this.f144207a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(h());
        sb.append(", url=");
        sb.append(k());
        if (f().size() != 0) {
            sb.append(", headers=[");
            int i3 = 0;
            for (Pair<? extends String, ? extends String> pair : f()) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String str = (String) pair2.a();
                String str2 = (String) pair2.b();
                if (i3 > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                sb.append(str2);
                i3 = i4;
            }
            sb.append(']');
        }
        if (!c().isEmpty()) {
            sb.append(", tags=");
            sb.append(c());
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private HttpUrl f144213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f144214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Headers.Builder f144215c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private RequestBody f144216d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map f144217e;

        public Builder() {
            this.f144217e = new LinkedHashMap();
            this.f144214b = "GET";
            this.f144215c = new Headers.Builder();
        }

        public Builder a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            d().a(name, value);
            return this;
        }

        public Request b() {
            HttpUrl httpUrl = this.f144213a;
            if (httpUrl != null) {
                return new Request(httpUrl, this.f144214b, this.f144215c.f(), this.f144216d, Util.W(this.f144217e));
            }
            throw new IllegalStateException("url == null");
        }

        public Builder c(CacheControl cacheControl) {
            Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
            String string = cacheControl.toString();
            return string.length() == 0 ? i("Cache-Control") : f("Cache-Control", string);
        }

        public final Headers.Builder d() {
            return this.f144215c;
        }

        public final Map e() {
            return this.f144217e;
        }

        public Builder f(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            d().j(name, value);
            return this;
        }

        public Builder g(Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            k(headers.f());
            return this;
        }

        public Builder h(String method, RequestBody requestBody) {
            Intrinsics.checkNotNullParameter(method, "method");
            if (method.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if (requestBody == null) {
                if (HttpMethod.e(method)) {
                    throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                }
            } else if (!HttpMethod.b(method)) {
                throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
            }
            l(method);
            j(requestBody);
            return this;
        }

        public Builder i(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            d().i(name);
            return this;
        }

        public final void j(RequestBody requestBody) {
            this.f144216d = requestBody;
        }

        public final void k(Headers.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<set-?>");
            this.f144215c = builder;
        }

        public final void l(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f144214b = str;
        }

        public final void m(Map map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.f144217e = map;
        }

        public final void n(HttpUrl httpUrl) {
            this.f144213a = httpUrl;
        }

        public Builder o(Class type, Object obj) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (obj == null) {
                e().remove(type);
                return this;
            }
            if (e().isEmpty()) {
                m(new LinkedHashMap());
            }
            Map mapE = e();
            Object objCast = type.cast(obj);
            Intrinsics.checkNotNull(objCast);
            mapE.put(type, objCast);
            return this;
        }

        public Builder p(Object obj) {
            return o(Object.class, obj);
        }

        public Builder q(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (StringsKt.S(url, "ws:", true)) {
                String strSubstring = url.substring(3);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                url = Intrinsics.stringPlus("http:", strSubstring);
            } else if (StringsKt.S(url, "wss:", true)) {
                String strSubstring2 = url.substring(4);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                url = Intrinsics.stringPlus("https:", strSubstring2);
            }
            return r(HttpUrl.f144085k.d(url));
        }

        public Builder r(HttpUrl url) {
            Intrinsics.checkNotNullParameter(url, "url");
            n(url);
            return this;
        }

        public Builder(Request request) {
            Map mutableMap;
            Intrinsics.checkNotNullParameter(request, "request");
            this.f144217e = new LinkedHashMap();
            this.f144213a = request.k();
            this.f144214b = request.h();
            this.f144216d = request.a();
            if (request.c().isEmpty()) {
                mutableMap = new LinkedHashMap();
            } else {
                mutableMap = MapsKt.toMutableMap(request.c());
            }
            this.f144217e = mutableMap;
            this.f144215c = request.f().f();
        }
    }
}
