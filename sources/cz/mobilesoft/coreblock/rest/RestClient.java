package cz.mobilesoft.coreblock.rest;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.facebook.GraphRequest;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.rest.interceptor.ConnectivityInterceptor;
import cz.mobilesoft.coreblock.rest.interceptor.DiagnosticInterceptor;
import cz.mobilesoft.coreblock.rest.interceptor.ErrorLogInterceptor;
import cz.mobilesoft.coreblock.rest.response.ErrorBody;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.BlockingFlowProperty;
import cz.mobilesoft.coreblock.util.JSONHelper;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class RestClient implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RestClient f98457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f98458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f98459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f98460d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f98461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f98462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ApiInterface f98463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static ApiInterface f98464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ApiInterface f98465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static ApiInterface f98466k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static ApiInterface f98467l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static ApiInterface f98468m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static ApiInterface f98469n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static Converter f98470o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f98471p;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final RestClient restClient = new RestClient();
        f98457a = restClient;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f98458b = LazyKt.a(lazyThreadSafetyModeB, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.rest.RestClient$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = restClient;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f98459c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.rest.RestClient$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = restClient;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr2, objArr3);
            }
        });
        f98460d = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.rest.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RestClient.g();
            }
        });
        f98461f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.rest.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RestClient.h();
            }
        });
        f98462g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.rest.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RestClient.i();
            }
        });
        f98471p = 8;
    }

    private RestClient() {
    }

    private final String A() {
        return (String) f98462g.getValue();
    }

    private final HttpLoggingInterceptor D(HttpLoggingInterceptor.Level level) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: cz.mobilesoft.coreblock.rest.f
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public final void a(String str) {
                RestClient.E(str);
            }
        });
        if (!BuildConfig.f95357b.booleanValue()) {
            level = HttpLoggingInterceptor.Level.BASIC;
        }
        return httpLoggingInterceptor.d(level);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (!StringsKt.U(message, "{", false, 2, null) && !StringsKt.U(message, "[", false, 2, null)) {
            Log.i("OkHttp", message);
            return;
        }
        try {
            String strR = new GsonBuilder().f().b().r(JsonParser.c(message));
            Intrinsics.checkNotNull(strR);
            Iterator it = StringsKt.x0(strR).iterator();
            while (it.hasNext()) {
                Log.i("OkHttp", (String) it.next());
            }
            Unit unit = Unit.f139807a;
        } catch (JsonSyntaxException unused) {
            Log.i("OkHttp", message);
        }
    }

    private final String G(Context context) {
        Object systemService = context.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String networkCountryIso = ((TelephonyManager) systemService).getNetworkCountryIso();
        Intrinsics.checkNotNullExpressionValue(networkCountryIso, "getNetworkCountryIso(...)");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String upperCase = networkCountryIso.toUpperCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    private final boolean J() {
        return BuildConfig.f95357b.booleanValue() && !((Boolean) new BlockingFlowProperty(z().h1()).b()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008a, code lost:
    
        if (r2.v5(r7, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object K(cz.mobilesoft.coreblock.rest.interceptor.DiagnosticRequestData r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.rest.RestClient$storeRequestDiagnostic$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.rest.RestClient$storeRequestDiagnostic$1 r0 = (cz.mobilesoft.coreblock.rest.RestClient$storeRequestDiagnostic$1) r0
            int r1 = r0.f98498f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f98498f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.rest.RestClient$storeRequestDiagnostic$1 r0 = new cz.mobilesoft.coreblock.rest.RestClient$storeRequestDiagnostic$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f98496c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f98498f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.f98495b
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r6 = r0.f98494a
            cz.mobilesoft.coreblock.rest.interceptor.DiagnosticRequestData r6 = (cz.mobilesoft.coreblock.rest.interceptor.DiagnosticRequestData) r6
            kotlin.ResultKt.b(r7)
            goto L8d
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            java.lang.Object r6 = r0.f98494a
            cz.mobilesoft.coreblock.rest.interceptor.DiagnosticRequestData r6 = (cz.mobilesoft.coreblock.rest.interceptor.DiagnosticRequestData) r6
            kotlin.ResultKt.b(r7)
            goto L5a
        L44:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r7 = r5.x()
            kotlinx.coroutines.flow.Flow r7 = r7.T2()
            r0.f98494a = r6
            r0.f98498f = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L5a
            goto L8c
        L5a:
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.List r7 = kotlin.collections.CollectionsKt.toMutableList(r7)
            java.lang.String r2 = r6.toString()
            r7.add(r2)
        L67:
            int r2 = r7.size()
            r4 = 10
            if (r2 <= r4) goto L74
            r2 = 0
            r7.remove(r2)
            goto L67
        L74:
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r2 = r5.x()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f98494a = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f98495b = r6
            r0.f98498f = r3
            java.lang.Object r6 = r2.v5(r7, r0)
            if (r6 != r1) goto L8d
        L8c:
            return r1
        L8d:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.rest.RestClient.K(cz.mobilesoft.coreblock.rest.interceptor.DiagnosticRequestData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g() {
        return "https://api.appblock.app/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h() {
        return "https://appblock.mobilesoft.eu/dev/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i() {
        return "https://www.appblock.app/wp-json/appblock/v2/";
    }

    private final void l(Request.Builder builder) {
        String languageTag = Locale.getDefault().toLanguageTag();
        InitHelper initHelper = InitHelper.f129486a;
        Context contextG = LockieApplication.g();
        Intrinsics.checkNotNullExpressionValue(contextG, "getContext(...)");
        String strJ = initHelper.j(contextG);
        Request.Builder builderA = builder.a("Content-type", "application/json").a("Accept", "application/json");
        Intrinsics.checkNotNull(languageTag);
        Request.Builder builderA2 = builderA.a(GraphRequest.ACCEPT_LANGUAGE_HEADER, languageTag).a("Content-Language", languageTag).a("App-Platform", "Android");
        String strL = LockieApplication.l();
        Intrinsics.checkNotNullExpressionValue(strL, "getVersionName(...)");
        Request.Builder builderA3 = builderA2.a("App-Version", strL);
        Context contextG2 = LockieApplication.g();
        Intrinsics.checkNotNullExpressionValue(contextG2, "getContext(...)");
        builderA3.a("x-country-code", G(contextG2));
        if (strJ != null) {
            builder.a("X-API-Key", strJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a9, code lost:
    
        if (r12.w5(r11, r0) == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(java.lang.String r11, java.lang.String r12, int r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof cz.mobilesoft.coreblock.rest.RestClient$addToRecentNetworkErrors$1
            if (r0 == 0) goto L13
            r0 = r14
            cz.mobilesoft.coreblock.rest.RestClient$addToRecentNetworkErrors$1 r0 = (cz.mobilesoft.coreblock.rest.RestClient$addToRecentNetworkErrors$1) r0
            int r1 = r0.f98478h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f98478h = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.rest.RestClient$addToRecentNetworkErrors$1 r0 = new cz.mobilesoft.coreblock.rest.RestClient$addToRecentNetworkErrors$1
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.f98476f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f98478h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L53
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r11 = r0.f98474c
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r11 = r0.f98473b
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r11 = r0.f98472a
            java.lang.String r11 = (java.lang.String) r11
            kotlin.ResultKt.b(r14)
            goto Lac
        L39:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L41:
            int r13 = r0.f98475d
            java.lang.Object r11 = r0.f98473b
            r12 = r11
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r11 = r0.f98472a
            java.lang.String r11 = (java.lang.String) r11
            kotlin.ResultKt.b(r14)
        L4f:
            r7 = r11
            r8 = r12
            r9 = r13
            goto L6d
        L53:
            kotlin.ResultKt.b(r14)
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r14 = r10.x()
            kotlinx.coroutines.flow.Flow r14 = r14.U2()
            r0.f98472a = r11
            r0.f98473b = r12
            r0.f98475d = r13
            r0.f98478h = r4
            java.lang.Object r14 = kotlinx.coroutines.flow.FlowKt.D(r14, r0)
            if (r14 != r1) goto L4f
            goto Lab
        L6d:
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.List r11 = kotlin.collections.CollectionsKt.toMutableList(r14)
            long r5 = java.lang.System.currentTimeMillis()
            cz.mobilesoft.coreblock.dto.diagnostic.RecentNetworkErrorsDTO r4 = new cz.mobilesoft.coreblock.dto.diagnostic.RecentNetworkErrorsDTO
            r4.<init>(r5, r7, r8, r9)
            r11.add(r4)
        L7f:
            int r12 = r11.size()
            r13 = 5
            if (r12 <= r13) goto L8b
            r12 = 0
            r11.remove(r12)
            goto L7f
        L8b:
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r12 = r10.x()
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f98472a = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f98473b = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r0.f98474c = r13
            r0.f98475d = r9
            r0.f98478h = r3
            java.lang.Object r11 = r12.w5(r11, r0)
            if (r11 != r1) goto Lac
        Lab:
            return r1
        Lac:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.rest.RestClient.m(java.lang.String, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final ApiInterface n(final boolean z2, long j3, String str, HttpLoggingInterceptor.Level level) {
        OkHttpClient.Builder builderR = r(j3, level);
        builderR.a(new Interceptor() { // from class: cz.mobilesoft.coreblock.rest.d
            @Override // okhttp3.Interceptor
            public final Response a(Interceptor.Chain chain) {
                return RestClient.p(z2, chain);
            }
        });
        builderR.a(new DiagnosticInterceptor("accountability", new RestClient$buildApiInterface$1(null)));
        if (z2) {
            builderR.a(new Interceptor() { // from class: cz.mobilesoft.coreblock.rest.e
                @Override // okhttp3.Interceptor
                public final Response a(Interceptor.Chain chain) {
                    return RestClient.q(chain);
                }
            });
            builderR.c(new AccessTokenAuthenticator());
        }
        builderR.a(new ErrorLogInterceptor());
        Retrofit retrofitS = s(builderR.d(), str);
        if (f98470o == null) {
            f98470o = retrofitS.h(ErrorBody.class, new Annotation[0]);
            Unit unit = Unit.f139807a;
        }
        Object objB = retrofitS.b(ApiInterface.class);
        Intrinsics.checkNotNullExpressionValue(objB, "create(...)");
        return (ApiInterface) objB;
    }

    static /* synthetic */ ApiInterface o(RestClient restClient, boolean z2, long j3, String str, HttpLoggingInterceptor.Level level, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 10;
        }
        long j4 = j3;
        if ((i3 & 4) != 0) {
            str = restClient.v();
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            level = HttpLoggingInterceptor.Level.BODY;
        }
        return restClient.n(z2, j4, str2, level);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response p(boolean z2, Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder builderI = chain.l().i();
        f98457a.l(builderI);
        if (!z2) {
            builderI.i("Authorization");
        }
        return chain.a(builderI.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response q(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder builderI = chain.l().i();
        String strG = SessionManager.f127910a.g();
        if (strG != null) {
            builderI.a("Authorization", strG);
        }
        return chain.a(builderI.b());
    }

    private final OkHttpClient.Builder r(long j3, HttpLoggingInterceptor.Level level) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder builderB = builder.f(j3, timeUnit).e(j3, timeUnit).b(D(level));
        Context contextG = LockieApplication.g();
        Intrinsics.checkNotNullExpressionValue(contextG, "getContext(...)");
        return builderB.a(new ConnectivityInterceptor(contextG)).K(true);
    }

    private final Retrofit s(OkHttpClient okHttpClient, String str) {
        return new Retrofit.Builder().c(str).b(GsonConverterFactory.g(JSONHelper.f127888a.f())).g(okHttpClient).e();
    }

    private final String v() {
        return (String) f98460d.getValue();
    }

    private final CoreDataStore x() {
        return (CoreDataStore) f98459c.getValue();
    }

    private final String y() {
        return (String) f98461f.getValue();
    }

    private final DevDataStore z() {
        return (DevDataStore) f98458b.getValue();
    }

    public final ApiInterface B() {
        ApiInterface apiInterface = f98466k;
        if (apiInterface != null) {
            return apiInterface;
        }
        ApiInterface apiInterfaceO = o(this, false, 0L, A(), HttpLoggingInterceptor.Level.HEADERS, 2, null);
        f98466k = apiInterfaceO;
        return apiInterfaceO;
    }

    public final String C(String imageId) {
        Intrinsics.checkNotNullParameter(imageId, "imageId");
        return StringHelperExtKt.n(w(), imageId);
    }

    public final ApiInterface F() {
        if (J()) {
            ApiInterface apiInterface = f98469n;
            if (apiInterface != null) {
                return apiInterface;
            }
            ApiInterface apiInterfaceO = o(this, true, 30L, y(), null, 8, null);
            f98469n = apiInterfaceO;
            return apiInterfaceO;
        }
        ApiInterface apiInterface2 = f98465j;
        if (apiInterface2 != null) {
            return apiInterface2;
        }
        ApiInterface apiInterfaceO2 = o(this, true, 30L, null, null, 12, null);
        f98465j = apiInterfaceO2;
        return apiInterfaceO2;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a4 A[Catch: Exception -> 0x00b4, TryCatch #4 {Exception -> 0x00b4, blocks: (B:74:0x0148, B:32:0x009b, B:34:0x00a4, B:36:0x00aa, B:40:0x00b7, B:42:0x00c1, B:53:0x00e6, B:55:0x00ec, B:56:0x00f2, B:59:0x00f9, B:61:0x00fd, B:63:0x0103, B:65:0x0111, B:67:0x0123, B:70:0x012a, B:52:0x00dc, B:29:0x0093, B:44:0x00c7, B:46:0x00cd, B:50:0x00d7), top: B:107:0x0093, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1 A[Catch: Exception -> 0x00b4, TRY_LEAVE, TryCatch #4 {Exception -> 0x00b4, blocks: (B:74:0x0148, B:32:0x009b, B:34:0x00a4, B:36:0x00aa, B:40:0x00b7, B:42:0x00c1, B:53:0x00e6, B:55:0x00ec, B:56:0x00f2, B:59:0x00f9, B:61:0x00fd, B:63:0x0103, B:65:0x0111, B:67:0x0123, B:70:0x012a, B:52:0x00dc, B:29:0x0093, B:44:0x00c7, B:46:0x00cd, B:50:0x00d7), top: B:107:0x0093, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0191  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object H(cz.mobilesoft.coreblock.rest.ApiInterface r20, kotlin.jvm.functions.Function2 r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.rest.RestClient.H(cz.mobilesoft.coreblock.rest.ApiInterface, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final ApiInterface I() {
        if (J()) {
            ApiInterface apiInterface = f98467l;
            if (apiInterface != null) {
                return apiInterface;
            }
            ApiInterface apiInterfaceO = o(this, false, 0L, y(), null, 10, null);
            f98467l = apiInterfaceO;
            return apiInterfaceO;
        }
        ApiInterface apiInterface2 = f98463h;
        if (apiInterface2 != null) {
            return apiInterface2;
        }
        ApiInterface apiInterfaceO2 = o(this, false, 0L, null, null, 14, null);
        f98463h = apiInterfaceO2;
        return apiInterfaceO2;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final ApiInterface t() {
        if (J()) {
            ApiInterface apiInterface = f98468m;
            if (apiInterface != null) {
                return apiInterface;
            }
            ApiInterface apiInterfaceO = o(this, true, 0L, y(), null, 10, null);
            f98468m = apiInterfaceO;
            return apiInterfaceO;
        }
        ApiInterface apiInterface2 = f98464i;
        if (apiInterface2 != null) {
            return apiInterface2;
        }
        ApiInterface apiInterfaceO2 = o(this, true, 0L, null, null, 14, null);
        f98464i = apiInterfaceO2;
        return apiInterfaceO2;
    }

    public final ApiInterface u() {
        return SessionManager.f127910a.r() ? t() : I();
    }

    public final String w() {
        return J() ? y() : v();
    }
}
