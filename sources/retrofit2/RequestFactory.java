package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.Continuation;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import retrofit2.ParameterHandler;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Tag;
import retrofit2.http.Url;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class RequestFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f146953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Method f146954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HttpUrl f146955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f146956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f146957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Headers f146958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MediaType f146959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f146960h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f146961i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f146962j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ParameterHandler[] f146963k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final boolean f146964l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder {

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private static final Pattern f146965y = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private static final Pattern f146966z = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Retrofit f146967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class f146968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Method f146969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Annotation[] f146970d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Annotation[][] f146971e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Type[] f146972f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f146973g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f146974h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f146975i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f146976j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f146977k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f146978l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f146979m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f146980n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        String f146981o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        boolean f146982p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f146983q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f146984r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        String f146985s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        Headers f146986t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        MediaType f146987u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        Set f146988v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        ParameterHandler[] f146989w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        boolean f146990x;

        Builder(Retrofit retrofit, Class cls, Method method) {
            this.f146967a = retrofit;
            this.f146968b = cls;
            this.f146969c = method;
            this.f146970d = method.getAnnotations();
            this.f146972f = method.getGenericParameterTypes();
            this.f146971e = method.getParameterAnnotations();
        }

        private static Class a(Class cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        private Headers c(String[] strArr, boolean z2) {
            Headers.Builder builder = new Headers.Builder();
            for (String str : strArr) {
                int iIndexOf = str.indexOf(58);
                if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                    throw Utils.n(this.f146969c, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String strSubstring = str.substring(0, iIndexOf);
                String strTrim = str.substring(iIndexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                    try {
                        this.f146987u = MediaType.e(strTrim);
                    } catch (IllegalArgumentException e3) {
                        throw Utils.o(this.f146969c, e3, "Malformed content type: %s", strTrim);
                    }
                } else if (z2) {
                    builder.e(strSubstring, strTrim);
                } else {
                    builder.a(strSubstring, strTrim);
                }
            }
            return builder.f();
        }

        private void d(String str, String str2, boolean z2) {
            String str3 = this.f146981o;
            if (str3 != null) {
                throw Utils.n(this.f146969c, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f146981o = str;
            this.f146982p = z2;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (f146965y.matcher(strSubstring).find()) {
                    throw Utils.n(this.f146969c, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.f146985s = str2;
            this.f146988v = h(str2);
        }

        private void e(Annotation annotation) {
            if (annotation instanceof DELETE) {
                d("DELETE", ((DELETE) annotation).value(), false);
                return;
            }
            if (annotation instanceof GET) {
                d("GET", ((GET) annotation).value(), false);
                return;
            }
            if (annotation instanceof HEAD) {
                d("HEAD", ((HEAD) annotation).value(), false);
                return;
            }
            if (annotation instanceof PATCH) {
                d("PATCH", ((PATCH) annotation).value(), true);
                return;
            }
            if (annotation instanceof POST) {
                d("POST", ((POST) annotation).value(), true);
                return;
            }
            if (annotation instanceof PUT) {
                d("PUT", ((PUT) annotation).value(), true);
                return;
            }
            if (annotation instanceof OPTIONS) {
                d("OPTIONS", ((OPTIONS) annotation).value(), false);
                return;
            }
            if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                d(http.method(), http.path(), http.hasBody());
                return;
            }
            if (annotation instanceof retrofit2.http.Headers) {
                retrofit2.http.Headers headers = (retrofit2.http.Headers) annotation;
                String[] strArrValue = headers.value();
                if (strArrValue.length == 0) {
                    throw Utils.n(this.f146969c, "@Headers annotation is empty.", new Object[0]);
                }
                this.f146986t = c(strArrValue, headers.allowUnsafeNonAsciiValues());
                return;
            }
            if (annotation instanceof Multipart) {
                if (this.f146983q) {
                    throw Utils.n(this.f146969c, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f146984r = true;
            } else if (annotation instanceof FormUrlEncoded) {
                if (this.f146984r) {
                    throw Utils.n(this.f146969c, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f146983q = true;
            }
        }

        private ParameterHandler f(int i3, Type type, Annotation[] annotationArr, boolean z2) {
            ParameterHandler parameterHandler;
            if (annotationArr != null) {
                parameterHandler = null;
                for (Annotation annotation : annotationArr) {
                    ParameterHandler parameterHandlerG = g(i3, type, annotationArr, annotation);
                    if (parameterHandlerG != null) {
                        if (parameterHandler != null) {
                            throw Utils.p(this.f146969c, i3, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        parameterHandler = parameterHandlerG;
                    }
                }
            } else {
                parameterHandler = null;
            }
            if (parameterHandler != null) {
                return parameterHandler;
            }
            if (z2) {
                try {
                    if (Utils.h(type) == Continuation.class) {
                        this.f146990x = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw Utils.p(this.f146969c, i3, "No Retrofit annotation found.", new Object[0]);
        }

        private ParameterHandler g(int i3, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof Url) {
                j(i3, type);
                if (this.f146980n) {
                    throw Utils.p(this.f146969c, i3, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.f146976j) {
                    throw Utils.p(this.f146969c, i3, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f146977k) {
                    throw Utils.p(this.f146969c, i3, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f146978l) {
                    throw Utils.p(this.f146969c, i3, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f146979m) {
                    throw Utils.p(this.f146969c, i3, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f146985s != null) {
                    throw Utils.p(this.f146969c, i3, "@Url cannot be used with @%s URL", this.f146981o);
                }
                this.f146980n = true;
                if (type == HttpUrl.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new ParameterHandler.RelativeUrl(this.f146969c, i3);
                }
                throw Utils.p(this.f146969c, i3, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof Path) {
                j(i3, type);
                if (this.f146977k) {
                    throw Utils.p(this.f146969c, i3, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f146978l) {
                    throw Utils.p(this.f146969c, i3, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f146979m) {
                    throw Utils.p(this.f146969c, i3, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f146980n) {
                    throw Utils.p(this.f146969c, i3, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f146985s == null) {
                    throw Utils.p(this.f146969c, i3, "@Path can only be used with relative url on @%s", this.f146981o);
                }
                this.f146976j = true;
                Path path = (Path) annotation;
                String strValue = path.value();
                i(i3, strValue);
                return new ParameterHandler.Path(this.f146969c, i3, strValue, this.f146967a.i(type, annotationArr), path.encoded());
            }
            if (annotation instanceof Query) {
                j(i3, type);
                Query query = (Query) annotation;
                String strValue2 = query.value();
                boolean zEncoded = query.encoded();
                Class clsH = Utils.h(type);
                this.f146977k = true;
                if (!Iterable.class.isAssignableFrom(clsH)) {
                    if (!clsH.isArray()) {
                        return new ParameterHandler.Query(strValue2, this.f146967a.i(type, annotationArr), zEncoded);
                    }
                    return new ParameterHandler.Query(strValue2, this.f146967a.i(a(clsH.getComponentType()), annotationArr), zEncoded).b();
                }
                if (type instanceof ParameterizedType) {
                    return new ParameterHandler.Query(strValue2, this.f146967a.i(Utils.g(0, (ParameterizedType) type), annotationArr), zEncoded).c();
                }
                throw Utils.p(this.f146969c, i3, clsH.getSimpleName() + " must include generic type (e.g., " + clsH.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof QueryName) {
                j(i3, type);
                boolean zEncoded2 = ((QueryName) annotation).encoded();
                Class clsH2 = Utils.h(type);
                this.f146978l = true;
                if (!Iterable.class.isAssignableFrom(clsH2)) {
                    if (!clsH2.isArray()) {
                        return new ParameterHandler.QueryName(this.f146967a.i(type, annotationArr), zEncoded2);
                    }
                    return new ParameterHandler.QueryName(this.f146967a.i(a(clsH2.getComponentType()), annotationArr), zEncoded2).b();
                }
                if (type instanceof ParameterizedType) {
                    return new ParameterHandler.QueryName(this.f146967a.i(Utils.g(0, (ParameterizedType) type), annotationArr), zEncoded2).c();
                }
                throw Utils.p(this.f146969c, i3, clsH2.getSimpleName() + " must include generic type (e.g., " + clsH2.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof QueryMap) {
                j(i3, type);
                Class clsH3 = Utils.h(type);
                this.f146979m = true;
                if (!Map.class.isAssignableFrom(clsH3)) {
                    throw Utils.p(this.f146969c, i3, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type typeI = Utils.i(type, clsH3, Map.class);
                if (!(typeI instanceof ParameterizedType)) {
                    throw Utils.p(this.f146969c, i3, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) typeI;
                Type typeG = Utils.g(0, parameterizedType);
                if (String.class == typeG) {
                    return new ParameterHandler.QueryMap(this.f146969c, i3, this.f146967a.i(Utils.g(1, parameterizedType), annotationArr), ((QueryMap) annotation).encoded());
                }
                throw Utils.p(this.f146969c, i3, "@QueryMap keys must be of type String: " + typeG, new Object[0]);
            }
            if (annotation instanceof Header) {
                j(i3, type);
                Header header = (Header) annotation;
                String strValue3 = header.value();
                Class clsH4 = Utils.h(type);
                if (!Iterable.class.isAssignableFrom(clsH4)) {
                    if (!clsH4.isArray()) {
                        return new ParameterHandler.Header(strValue3, this.f146967a.i(type, annotationArr), header.allowUnsafeNonAsciiValues());
                    }
                    return new ParameterHandler.Header(strValue3, this.f146967a.i(a(clsH4.getComponentType()), annotationArr), header.allowUnsafeNonAsciiValues()).b();
                }
                if (type instanceof ParameterizedType) {
                    return new ParameterHandler.Header(strValue3, this.f146967a.i(Utils.g(0, (ParameterizedType) type), annotationArr), header.allowUnsafeNonAsciiValues()).c();
                }
                throw Utils.p(this.f146969c, i3, clsH4.getSimpleName() + " must include generic type (e.g., " + clsH4.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof HeaderMap) {
                if (type == Headers.class) {
                    return new ParameterHandler.Headers(this.f146969c, i3);
                }
                j(i3, type);
                Class clsH5 = Utils.h(type);
                if (!Map.class.isAssignableFrom(clsH5)) {
                    throw Utils.p(this.f146969c, i3, "@HeaderMap parameter type must be Map or Headers.", new Object[0]);
                }
                Type typeI2 = Utils.i(type, clsH5, Map.class);
                if (!(typeI2 instanceof ParameterizedType)) {
                    throw Utils.p(this.f146969c, i3, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) typeI2;
                Type typeG2 = Utils.g(0, parameterizedType2);
                if (String.class == typeG2) {
                    return new ParameterHandler.HeaderMap(this.f146969c, i3, this.f146967a.i(Utils.g(1, parameterizedType2), annotationArr), ((HeaderMap) annotation).allowUnsafeNonAsciiValues());
                }
                throw Utils.p(this.f146969c, i3, "@HeaderMap keys must be of type String: " + typeG2, new Object[0]);
            }
            if (annotation instanceof Field) {
                j(i3, type);
                if (!this.f146983q) {
                    throw Utils.p(this.f146969c, i3, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                Field field = (Field) annotation;
                String strValue4 = field.value();
                boolean zEncoded3 = field.encoded();
                this.f146973g = true;
                Class clsH6 = Utils.h(type);
                if (!Iterable.class.isAssignableFrom(clsH6)) {
                    if (!clsH6.isArray()) {
                        return new ParameterHandler.Field(strValue4, this.f146967a.i(type, annotationArr), zEncoded3);
                    }
                    return new ParameterHandler.Field(strValue4, this.f146967a.i(a(clsH6.getComponentType()), annotationArr), zEncoded3).b();
                }
                if (type instanceof ParameterizedType) {
                    return new ParameterHandler.Field(strValue4, this.f146967a.i(Utils.g(0, (ParameterizedType) type), annotationArr), zEncoded3).c();
                }
                throw Utils.p(this.f146969c, i3, clsH6.getSimpleName() + " must include generic type (e.g., " + clsH6.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof FieldMap) {
                j(i3, type);
                if (!this.f146983q) {
                    throw Utils.p(this.f146969c, i3, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class clsH7 = Utils.h(type);
                if (!Map.class.isAssignableFrom(clsH7)) {
                    throw Utils.p(this.f146969c, i3, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type typeI3 = Utils.i(type, clsH7, Map.class);
                if (!(typeI3 instanceof ParameterizedType)) {
                    throw Utils.p(this.f146969c, i3, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) typeI3;
                Type typeG3 = Utils.g(0, parameterizedType3);
                if (String.class == typeG3) {
                    Converter converterI = this.f146967a.i(Utils.g(1, parameterizedType3), annotationArr);
                    this.f146973g = true;
                    return new ParameterHandler.FieldMap(this.f146969c, i3, converterI, ((FieldMap) annotation).encoded());
                }
                throw Utils.p(this.f146969c, i3, "@FieldMap keys must be of type String: " + typeG3, new Object[0]);
            }
            if (!(annotation instanceof Part)) {
                if (annotation instanceof PartMap) {
                    j(i3, type);
                    if (!this.f146984r) {
                        throw Utils.p(this.f146969c, i3, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                    }
                    this.f146974h = true;
                    Class clsH8 = Utils.h(type);
                    if (!Map.class.isAssignableFrom(clsH8)) {
                        throw Utils.p(this.f146969c, i3, "@PartMap parameter type must be Map.", new Object[0]);
                    }
                    Type typeI4 = Utils.i(type, clsH8, Map.class);
                    if (!(typeI4 instanceof ParameterizedType)) {
                        throw Utils.p(this.f146969c, i3, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    ParameterizedType parameterizedType4 = (ParameterizedType) typeI4;
                    Type typeG4 = Utils.g(0, parameterizedType4);
                    if (String.class == typeG4) {
                        Type typeG5 = Utils.g(1, parameterizedType4);
                        if (MultipartBody.Part.class.isAssignableFrom(Utils.h(typeG5))) {
                            throw Utils.p(this.f146969c, i3, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                        }
                        return new ParameterHandler.PartMap(this.f146969c, i3, this.f146967a.g(typeG5, annotationArr, this.f146970d), ((PartMap) annotation).encoding());
                    }
                    throw Utils.p(this.f146969c, i3, "@PartMap keys must be of type String: " + typeG4, new Object[0]);
                }
                if (annotation instanceof Body) {
                    j(i3, type);
                    if (this.f146983q || this.f146984r) {
                        throw Utils.p(this.f146969c, i3, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                    }
                    if (this.f146975i) {
                        throw Utils.p(this.f146969c, i3, "Multiple @Body method annotations found.", new Object[0]);
                    }
                    try {
                        Converter converterG = this.f146967a.g(type, annotationArr, this.f146970d);
                        this.f146975i = true;
                        return new ParameterHandler.Body(this.f146969c, i3, converterG);
                    } catch (RuntimeException e3) {
                        throw Utils.q(this.f146969c, e3, i3, "Unable to create @Body converter for %s", type);
                    }
                }
                if (!(annotation instanceof Tag)) {
                    return null;
                }
                j(i3, type);
                Class clsH9 = Utils.h(type);
                for (int i4 = i3 - 1; i4 >= 0; i4--) {
                    ParameterHandler parameterHandler = this.f146989w[i4];
                    if ((parameterHandler instanceof ParameterHandler.Tag) && ((ParameterHandler.Tag) parameterHandler).f146934a.equals(clsH9)) {
                        throw Utils.p(this.f146969c, i3, "@Tag type " + clsH9.getName() + " is duplicate of " + Platform.f146936b.a(this.f146969c, i4) + " and would always overwrite its value.", new Object[0]);
                    }
                }
                return new ParameterHandler.Tag(clsH9);
            }
            j(i3, type);
            if (!this.f146984r) {
                throw Utils.p(this.f146969c, i3, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            Part part = (Part) annotation;
            this.f146974h = true;
            String strValue5 = part.value();
            Class clsH10 = Utils.h(type);
            if (strValue5.isEmpty()) {
                if (!Iterable.class.isAssignableFrom(clsH10)) {
                    if (clsH10.isArray()) {
                        if (MultipartBody.Part.class.isAssignableFrom(clsH10.getComponentType())) {
                            return ParameterHandler.RawPart.f146931a.b();
                        }
                        throw Utils.p(this.f146969c, i3, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (MultipartBody.Part.class.isAssignableFrom(clsH10)) {
                        return ParameterHandler.RawPart.f146931a;
                    }
                    throw Utils.p(this.f146969c, i3, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                if (type instanceof ParameterizedType) {
                    if (MultipartBody.Part.class.isAssignableFrom(Utils.h(Utils.g(0, (ParameterizedType) type)))) {
                        return ParameterHandler.RawPart.f146931a.c();
                    }
                    throw Utils.p(this.f146969c, i3, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                throw Utils.p(this.f146969c, i3, clsH10.getSimpleName() + " must include generic type (e.g., " + clsH10.getSimpleName() + "<String>)", new Object[0]);
            }
            Headers headersG = Headers.g("Content-Disposition", "form-data; name=\"" + strValue5 + "\"", "Content-Transfer-Encoding", part.encoding());
            if (!Iterable.class.isAssignableFrom(clsH10)) {
                if (!clsH10.isArray()) {
                    if (MultipartBody.Part.class.isAssignableFrom(clsH10)) {
                        throw Utils.p(this.f146969c, i3, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new ParameterHandler.Part(this.f146969c, i3, headersG, this.f146967a.g(type, annotationArr, this.f146970d));
                }
                Class clsA = a(clsH10.getComponentType());
                if (MultipartBody.Part.class.isAssignableFrom(clsA)) {
                    throw Utils.p(this.f146969c, i3, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new ParameterHandler.Part(this.f146969c, i3, headersG, this.f146967a.g(clsA, annotationArr, this.f146970d)).b();
            }
            if (type instanceof ParameterizedType) {
                Type typeG6 = Utils.g(0, (ParameterizedType) type);
                if (MultipartBody.Part.class.isAssignableFrom(Utils.h(typeG6))) {
                    throw Utils.p(this.f146969c, i3, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new ParameterHandler.Part(this.f146969c, i3, headersG, this.f146967a.g(typeG6, annotationArr, this.f146970d)).c();
            }
            throw Utils.p(this.f146969c, i3, clsH10.getSimpleName() + " must include generic type (e.g., " + clsH10.getSimpleName() + "<String>)", new Object[0]);
        }

        static Set h(String str) {
            Matcher matcher = f146965y.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void i(int i3, String str) {
            if (!f146966z.matcher(str).matches()) {
                throw Utils.p(this.f146969c, i3, "@Path parameter name must match %s. Found: %s", f146965y.pattern(), str);
            }
            if (!this.f146988v.contains(str)) {
                throw Utils.p(this.f146969c, i3, "URL \"%s\" does not contain \"{%s}\".", this.f146985s, str);
            }
        }

        private void j(int i3, Type type) {
            if (Utils.j(type)) {
                throw Utils.p(this.f146969c, i3, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        RequestFactory b() {
            for (Annotation annotation : this.f146970d) {
                e(annotation);
            }
            if (this.f146981o == null) {
                throw Utils.n(this.f146969c, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f146982p) {
                if (this.f146984r) {
                    throw Utils.n(this.f146969c, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.f146983q) {
                    throw Utils.n(this.f146969c, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f146971e.length;
            this.f146989w = new ParameterHandler[length];
            int i3 = length - 1;
            int i4 = 0;
            while (i4 < length) {
                this.f146989w[i4] = f(i4, this.f146972f[i4], this.f146971e[i4], i4 == i3);
                i4++;
            }
            if (this.f146985s == null && !this.f146980n) {
                throw Utils.n(this.f146969c, "Missing either @%s URL or @Url parameter.", this.f146981o);
            }
            boolean z2 = this.f146983q;
            if (!z2 && !this.f146984r && !this.f146982p && this.f146975i) {
                throw Utils.n(this.f146969c, "Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z2 && !this.f146973g) {
                throw Utils.n(this.f146969c, "Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.f146984r || this.f146974h) {
                return new RequestFactory(this);
            }
            throw Utils.n(this.f146969c, "Multipart method must contain at least one @Part.", new Object[0]);
        }
    }

    RequestFactory(Builder builder) {
        this.f146953a = builder.f146968b;
        this.f146954b = builder.f146969c;
        this.f146955c = builder.f146967a.f146996c;
        this.f146956d = builder.f146981o;
        this.f146957e = builder.f146985s;
        this.f146958f = builder.f146986t;
        this.f146959g = builder.f146987u;
        this.f146960h = builder.f146982p;
        this.f146961i = builder.f146983q;
        this.f146962j = builder.f146984r;
        this.f146963k = builder.f146989w;
        this.f146964l = builder.f146990x;
    }

    static RequestFactory b(Retrofit retrofit, Class cls, Method method) {
        return new Builder(retrofit, cls, method).b();
    }

    Request a(Object obj, Object[] objArr) {
        ParameterHandler[] parameterHandlerArr = this.f146963k;
        int length = objArr.length;
        if (length != parameterHandlerArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + parameterHandlerArr.length + ")");
        }
        RequestBuilder requestBuilder = new RequestBuilder(this.f146956d, this.f146955c, this.f146957e, this.f146958f, this.f146959g, this.f146960h, this.f146961i, this.f146962j);
        if (this.f146964l) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(objArr[i3]);
            parameterHandlerArr[i3].a(requestBuilder, objArr[i3]);
        }
        return requestBuilder.k().o(Invocation.class, new Invocation(this.f146953a, obj, this.f146954b, arrayList)).b();
    }
}
