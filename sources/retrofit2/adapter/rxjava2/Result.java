package retrofit2.adapter.rxjava2;

import retrofit2.Response;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class Result<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Response f147033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Throwable f147034b;

    private Result(Response response, Throwable th) {
        this.f147033a = response;
        this.f147034b = th;
    }

    public static Result a(Throwable th) {
        if (th != null) {
            return new Result(null, th);
        }
        throw new NullPointerException("error == null");
    }

    public static Result b(Response response) {
        if (response != null) {
            return new Result(response, null);
        }
        throw new NullPointerException("response == null");
    }
}
