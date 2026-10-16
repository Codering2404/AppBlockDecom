package retrofit2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class HttpException extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f146844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f146845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient Response f146846c;

    public HttpException(Response response) {
        super(b(response));
        this.f146844a = response.b();
        this.f146845b = response.f();
        this.f146846c = response;
    }

    private static String b(Response response) {
        Objects.requireNonNull(response, "response == null");
        return "HTTP " + response.b() + " " + response.f();
    }

    public int a() {
        return this.f146844a;
    }
}
