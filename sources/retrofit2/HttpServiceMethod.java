package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.coroutines.Continuation;
import okhttp3.Call;
import retrofit2.Utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RequestFactory f146847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Call.Factory f146848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Converter f146849c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final CallAdapter f146850d;

        CallAdapted(RequestFactory requestFactory, Call.Factory factory, Converter converter, CallAdapter callAdapter) {
            super(requestFactory, factory, converter);
            this.f146850d = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        protected Object c(Call call, Object[] objArr) {
            return this.f146850d.b(call);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final CallAdapter f146851d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f146852e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f146853f;

        SuspendForBody(RequestFactory requestFactory, Call.Factory factory, Converter converter, CallAdapter callAdapter, boolean z2, boolean z3) {
            super(requestFactory, factory, converter);
            this.f146851d = callAdapter;
            this.f146852e = z2;
            this.f146853f = z3;
        }

        @Override // retrofit2.HttpServiceMethod
        protected Object c(Call call, Object[] objArr) {
            Call call2 = (Call) this.f146851d.b(call);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return this.f146853f ? KotlinExtensions.d(call2, continuation) : this.f146852e ? KotlinExtensions.b(call2, continuation) : KotlinExtensions.a(call2, continuation);
            } catch (LinkageError e3) {
                throw e3;
            } catch (ThreadDeath e4) {
                throw e4;
            } catch (VirtualMachineError e5) {
                throw e5;
            } catch (Throwable th) {
                return KotlinExtensions.e(th, continuation);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final CallAdapter f146854d;

        SuspendForResponse(RequestFactory requestFactory, Call.Factory factory, Converter converter, CallAdapter callAdapter) {
            super(requestFactory, factory, converter);
            this.f146854d = callAdapter;
        }

        @Override // retrofit2.HttpServiceMethod
        protected Object c(Call call, Object[] objArr) {
            Call call2 = (Call) this.f146854d.b(call);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return KotlinExtensions.c(call2, continuation);
            } catch (Exception e3) {
                return KotlinExtensions.e(e3, continuation);
            }
        }
    }

    HttpServiceMethod(RequestFactory requestFactory, Call.Factory factory, Converter converter) {
        this.f146847a = requestFactory;
        this.f146848b = factory;
        this.f146849c = converter;
    }

    private static CallAdapter d(Retrofit retrofit, Method method, Type type, Annotation[] annotationArr) {
        try {
            return retrofit.a(type, annotationArr);
        } catch (RuntimeException e3) {
            throw Utils.o(method, e3, "Unable to create call adapter for %s", type);
        }
    }

    private static Converter e(Retrofit retrofit, Method method, Type type) {
        try {
            return retrofit.h(type, method.getAnnotations());
        } catch (RuntimeException e3) {
            throw Utils.o(method, e3, "Unable to create converter for %s", type);
        }
    }

    static HttpServiceMethod f(Retrofit retrofit, Method method, RequestFactory requestFactory) {
        Type genericReturnType;
        boolean z2;
        boolean z3;
        boolean zM;
        boolean z4 = requestFactory.f146964l;
        Annotation[] annotations = method.getAnnotations();
        if (z4) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type typeF = Utils.f(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (Utils.h(typeF) == Response.class && (typeF instanceof ParameterizedType)) {
                typeF = Utils.g(0, (ParameterizedType) typeF);
                zM = false;
                z2 = true;
            } else {
                if (Utils.h(typeF) == Call.class) {
                    throw Utils.n(method, "Suspend functions should not return Call, as they already execute asynchronously.\nChange its return type to %s", Utils.g(0, (ParameterizedType) typeF));
                }
                zM = Utils.m(typeF);
                z2 = false;
            }
            genericReturnType = new Utils.ParameterizedTypeImpl(null, Call.class, typeF);
            annotations = SkipCallbackExecutorImpl.a(annotations);
            z3 = zM;
        } else {
            genericReturnType = method.getGenericReturnType();
            z2 = false;
            z3 = false;
        }
        CallAdapter callAdapterD = d(retrofit, method, genericReturnType, annotations);
        Type typeA = callAdapterD.a();
        if (typeA == okhttp3.Response.class) {
            throw Utils.n(method, "'" + Utils.h(typeA).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (typeA == Response.class) {
            throw Utils.n(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (requestFactory.f146956d.equals("HEAD") && !Void.class.equals(typeA) && !Utils.m(typeA)) {
            throw Utils.n(method, "HEAD method must use Void or Unit as response type.", new Object[0]);
        }
        Converter converterE = e(retrofit, method, typeA);
        Call.Factory factory = retrofit.f146995b;
        return !z4 ? new CallAdapted(requestFactory, factory, converterE, callAdapterD) : z2 ? new SuspendForResponse(requestFactory, factory, converterE, callAdapterD) : new SuspendForBody(requestFactory, factory, converterE, callAdapterD, false, z3);
    }

    @Override // retrofit2.ServiceMethod
    final Object a(Object obj, Object[] objArr) {
        return c(new OkHttpCall(this.f146847a, obj, objArr, this.f146848b, this.f146849c), objArr);
    }

    protected abstract Object c(Call call, Object[] objArr);
}
