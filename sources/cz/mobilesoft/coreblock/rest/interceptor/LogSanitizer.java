package cz.mobilesoft.coreblock.rest.interceptor;

import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.GraphRequest;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import cz.mobilesoft.coreblock.rest.interceptor.ErrorLogInterceptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import retrofit2.Invocation;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LogSanitizer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LogSanitizer f98558a = new LogSanitizer();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f98559b = new Gson();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Type f98560c = new TypeToken<Map<String, ? extends Object>>() { // from class: cz.mobilesoft.coreblock.rest.interceptor.LogSanitizer$mapType$1
    }.d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set f98561d = SetsKt.setOf((Object[]) new String[]{"Authorization", "X-API-Key", "Cookie", "Set-Cookie"});

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set f98562e = SetsKt.setOf((Object[]) new String[]{"brand", "currentTime", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "deviceId", "deviceLanguage", "devicePlatform", "deviceType", "manufacturer", DeviceRequestsHelper.DEVICE_INFO_MODEL, AppLovinEventTypes.USER_VIEWED_PRODUCT, "errors", "message", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "profiles"});

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f98563f = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BodyLog {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f98564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f98565b;

        public BodyLog(String censored, String full) {
            Intrinsics.checkNotNullParameter(censored, "censored");
            Intrinsics.checkNotNullParameter(full, "full");
            this.f98564a = censored;
            this.f98565b = full;
        }

        public final String a() {
            return this.f98564a;
        }

        public final String b() {
            return this.f98565b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BodyLog)) {
                return false;
            }
            BodyLog bodyLog = (BodyLog) obj;
            return Intrinsics.areEqual(this.f98564a, bodyLog.f98564a) && Intrinsics.areEqual(this.f98565b, bodyLog.f98565b);
        }

        public int hashCode() {
            return (this.f98564a.hashCode() * 31) + this.f98565b.hashCode();
        }

        public String toString() {
            return "BodyLog(censored=" + this.f98564a + ", full=" + this.f98565b + ")";
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public BodyLog(String sameForBoth) {
            this(sameForBoth, sameForBoth);
            Intrinsics.checkNotNullParameter(sameForBoth, "sameForBoth");
        }
    }

    private LogSanitizer() {
    }

    private final String c(String str) {
        try {
            Gson gson = f98559b;
            Object objK = gson.k(str, f98560c);
            Intrinsics.checkNotNullExpressionValue(objK, "fromJson(...)");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : ((Map) objK).entrySet()) {
                if (f98562e.contains((String) entry.getKey())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            String strS = gson.s(linkedHashMap);
            Intrinsics.checkNotNull(strS);
            return strS;
        } catch (Exception unused) {
            return "(Failed to parse JSON)";
        }
    }

    private final String f(String str) {
        if (str.length() <= 2048) {
            return str;
        }
        return StringsKt.B1(str, 2048) + "... (" + (str.length() - 2048) + " more characters)";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0092 A[EDGE_INSN: B:37:0x0092->B:34:0x0092 BREAK  A[LOOP:0: B:29:0x0072->B:38:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.CharSequence j(okhttp3.Headers r12, java.lang.String r13) {
        /*
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.util.List r12 = r12.l(r13)
            java.util.Set r0 = cz.mobilesoft.coreblock.rest.interceptor.LogSanitizer.f98561d
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            java.lang.String r2 = "[empty]"
            if (r1 == 0) goto L1d
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L1d
            goto L5d
        L1d:
            java.util.Iterator r0 = r0.iterator()
        L21:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L5d
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            r3 = 1
            boolean r1 = kotlin.text.StringsKt.F(r1, r13, r3)
            if (r1 == 0) goto L21
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            boolean r0 = r12 instanceof java.util.Collection
            if (r0 == 0) goto L44
            r0 = r12
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L44
            goto L92
        L44:
            java.util.Iterator r12 = r12.iterator()
        L48:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L92
            java.lang.Object r0 = r12.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = kotlin.text.StringsKt.p0(r0)
            if (r0 != 0) goto L48
            java.lang.String r2 = "[censored]"
            goto L92
        L5d:
            r3 = r12
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            boolean r12 = r3 instanceof java.util.Collection
            if (r12 == 0) goto L6e
            r12 = r3
            java.util.Collection r12 = (java.util.Collection) r12
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L6e
            goto L92
        L6e:
            java.util.Iterator r12 = r3.iterator()
        L72:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L92
            java.lang.Object r0 = r12.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = kotlin.text.StringsKt.p0(r0)
            if (r0 != 0) goto L72
            r10 = 62
            r11 = 0
            java.lang.String r4 = ", "
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r2 = kotlin.collections.CollectionsKt.joinToString$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L92:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r13)
            java.lang.String r13 = ": "
            r12.append(r13)
            r12.append(r2)
            java.lang.String r12 = r12.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.rest.interceptor.LogSanitizer.j(okhttp3.Headers, java.lang.String):java.lang.CharSequence");
    }

    public final boolean b(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody requestBodyA = request.a();
        return (requestBodyA == null || requestBodyA.f() || requestBodyA.a() > 262144) ? false : true;
    }

    public final ErrorLogInterceptor.ApiErrorDetails d(String str) {
        if (str != null && !StringsKt.p0(str)) {
            try {
                JsonElement jsonElementC = JsonParser.c(str);
                if (!jsonElementC.l()) {
                    return null;
                }
                JsonObject jsonObjectD = jsonElementC.d();
                Integer numValueOf = jsonObjectD.q("code") ? Integer.valueOf(jsonObjectD.p("code").a()) : null;
                String strF = jsonObjectD.q("message") ? jsonObjectD.p("message").f() : null;
                if (numValueOf == null && strF == null) {
                    return null;
                }
                return new ErrorLogInterceptor.ApiErrorDetails(numValueOf, strF);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final String e(Request request) {
        Annotation annotation;
        Intrinsics.checkNotNullParameter(request, "<this>");
        Invocation invocation = (Invocation) request.j(Invocation.class);
        if (invocation == null) {
            return null;
        }
        Annotation[] annotations = invocation.a().getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "getAnnotations(...)");
        int length = annotations.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                annotation = null;
                break;
            }
            annotation = annotations[i3];
            if ((annotation instanceof GET) || (annotation instanceof POST) || (annotation instanceof PUT) || (annotation instanceof DELETE) || (annotation instanceof PATCH) || (annotation instanceof HEAD)) {
                break;
            }
            i3++;
        }
        if (annotation == null) {
            return null;
        }
        if (annotation instanceof GET) {
            return ((GET) annotation).value();
        }
        if (annotation instanceof POST) {
            return ((POST) annotation).value();
        }
        if (annotation instanceof PUT) {
            return ((PUT) annotation).value();
        }
        if (annotation instanceof DELETE) {
            return ((DELETE) annotation).value();
        }
        if (annotation instanceof PATCH) {
            return ((PATCH) annotation).value();
        }
        if (annotation instanceof HEAD) {
            return ((HEAD) annotation).value();
        }
        return null;
    }

    public final String g(Response response) {
        String strL;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            strL = response.J(2048L).l();
        } catch (Exception unused) {
        }
        if (StringsKt.p0(strL)) {
            return null;
        }
        return strL;
    }

    public final BodyLog h(Request request) {
        String strG;
        Charset UTF_8;
        Intrinsics.checkNotNullParameter(request, "request");
        RequestBody requestBodyA = request.a();
        if (requestBodyA == null) {
            return new BodyLog("Body: (No body)");
        }
        if (!b(request)) {
            return new BodyLog("Body: (Not loggable, the body is a stream of data or is too big)");
        }
        MediaType mediaTypeB = requestBodyA.b();
        if (mediaTypeB == null || (strG = mediaTypeB.g()) == null || !StringsKt.a0(strG, GraphRequest.FORMAT_JSON, false, 2, null)) {
            return new BodyLog("Body: (Non-JSON body, Type: " + requestBodyA.b() + ")");
        }
        try {
            Buffer buffer = new Buffer();
            requestBodyA.g(buffer);
            MediaType mediaTypeB2 = requestBodyA.b();
            if (mediaTypeB2 == null || (UTF_8 = mediaTypeB2.c(StandardCharsets.UTF_8)) == null) {
                UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            }
            String strZ1 = buffer.Z1(UTF_8);
            return new BodyLog("Body: " + c(strZ1), "Body: " + f(strZ1));
        } catch (Exception unused) {
            return new BodyLog("Body: (Failed to read the body)");
        }
    }

    public final String i(final Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        return headers.size() == 0 ? "[No headers]" : CollectionsKt.joinToString$default(headers.e(), " | ", null, null, 0, null, new Function1() { // from class: cz.mobilesoft.coreblock.rest.interceptor.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LogSanitizer.j(headers, (String) obj);
            }
        }, 30, null);
    }
}
