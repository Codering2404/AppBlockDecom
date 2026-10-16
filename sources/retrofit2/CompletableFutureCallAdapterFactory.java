package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import retrofit2.CallAdapter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class CompletableFutureCallAdapterFactory extends CallAdapter.Factory {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BodyCallAdapter<R> implements CallAdapter<R, CompletableFuture<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f146828a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class BodyCallback implements Callback<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final CompletableFuture f146829a;

            public BodyCallback(CompletableFuture completableFuture) {
                this.f146829a = completableFuture;
            }

            @Override // retrofit2.Callback
            public void a(Call call, Throwable th) {
                this.f146829a.completeExceptionally(th);
            }

            @Override // retrofit2.Callback
            public void b(Call call, Response response) {
                if (response.e()) {
                    this.f146829a.complete(response.a());
                } else {
                    this.f146829a.completeExceptionally(new HttpException(response));
                }
            }
        }

        BodyCallAdapter(Type type) {
            this.f146828a = type;
        }

        @Override // retrofit2.CallAdapter
        public Type a() {
            return this.f146828a;
        }

        @Override // retrofit2.CallAdapter
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture b(Call call) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            call.A0(new BodyCallback(callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CallCancelCompletableFuture<T> extends CompletableFuture<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Call f146831a;

        CallCancelCompletableFuture(Call call) {
            this.f146831a = call;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z2) {
            if (z2) {
                this.f146831a.cancel();
            }
            return super.cancel(z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ResponseCallAdapter<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type f146832a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class ResponseCallback implements Callback<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final CompletableFuture f146833a;

            public ResponseCallback(CompletableFuture completableFuture) {
                this.f146833a = completableFuture;
            }

            @Override // retrofit2.Callback
            public void a(Call call, Throwable th) {
                this.f146833a.completeExceptionally(th);
            }

            @Override // retrofit2.Callback
            public void b(Call call, Response response) {
                this.f146833a.complete(response);
            }
        }

        ResponseCallAdapter(Type type) {
            this.f146832a = type;
        }

        @Override // retrofit2.CallAdapter
        public Type a() {
            return this.f146832a;
        }

        @Override // retrofit2.CallAdapter
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture b(Call call) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            call.A0(new ResponseCallback(callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }
    }

    CompletableFutureCallAdapterFactory() {
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter a(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (CallAdapter.Factory.c(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeB = CallAdapter.Factory.b(0, (ParameterizedType) type);
        if (CallAdapter.Factory.c(typeB) != Response.class) {
            return new BodyCallAdapter(typeB);
        }
        if (typeB instanceof ParameterizedType) {
            return new ResponseCallAdapter(CallAdapter.Factory.b(0, (ParameterizedType) typeB));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
