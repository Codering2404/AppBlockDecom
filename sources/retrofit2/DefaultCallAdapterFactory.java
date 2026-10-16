package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.CallAdapter;
import retrofit2.DefaultCallAdapterFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class DefaultCallAdapterFactory extends CallAdapter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f146835a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ExecutorCallbackCall<T> implements Call<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Executor f146839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Call f146840b;

        /* JADX INFO: renamed from: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Callback<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Callback f146841a;

            AnonymousClass1(Callback callback) {
                this.f146841a = callback;
            }

            public static /* synthetic */ void d(AnonymousClass1 anonymousClass1, Callback callback, Response response) {
                if (ExecutorCallbackCall.this.f146840b.C()) {
                    callback.a(ExecutorCallbackCall.this, new IOException("Canceled"));
                } else {
                    callback.b(ExecutorCallbackCall.this, response);
                }
            }

            @Override // retrofit2.Callback
            public void a(Call call, final Throwable th) {
                Executor executor = ExecutorCallbackCall.this.f146839a;
                final Callback callback = this.f146841a;
                executor.execute(new Runnable() { // from class: retrofit2.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        callback.a(DefaultCallAdapterFactory.ExecutorCallbackCall.this, th);
                    }
                });
            }

            @Override // retrofit2.Callback
            public void b(Call call, final Response response) {
                Executor executor = ExecutorCallbackCall.this.f146839a;
                final Callback callback = this.f146841a;
                executor.execute(new Runnable() { // from class: retrofit2.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1.d(this.f147021a, callback, response);
                    }
                });
            }
        }

        ExecutorCallbackCall(Executor executor, Call call) {
            this.f146839a = executor;
            this.f146840b = call;
        }

        @Override // retrofit2.Call
        public void A0(Callback callback) {
            Objects.requireNonNull(callback, "callback == null");
            this.f146840b.A0(new AnonymousClass1(callback));
        }

        @Override // retrofit2.Call
        public boolean C() {
            return this.f146840b.C();
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.f146840b.cancel();
        }

        @Override // retrofit2.Call
        public Response d() {
            return this.f146840b.d();
        }

        @Override // retrofit2.Call
        public Request l() {
            return this.f146840b.l();
        }

        @Override // retrofit2.Call
        public Call clone() {
            return new ExecutorCallbackCall(this.f146839a, this.f146840b.clone());
        }
    }

    DefaultCallAdapterFactory(Executor executor) {
        this.f146835a = executor;
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (CallAdapter.Factory.c(type) != Call.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        final Type typeG = Utils.g(0, (ParameterizedType) type);
        final Executor executor = Utils.l(annotationArr, SkipCallbackExecutor.class) ? null : this.f146835a;
        return new CallAdapter<Object, Call<?>>() { // from class: retrofit2.DefaultCallAdapterFactory.1
            @Override // retrofit2.CallAdapter
            public Type a() {
                return typeG;
            }

            @Override // retrofit2.CallAdapter
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Call b(Call call) {
                Executor executor2 = executor;
                return executor2 == null ? call : new ExecutorCallbackCall(executor2, call);
            }
        };
    }
}
