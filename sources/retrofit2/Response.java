package retrofit2;

import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.util.Objects;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class Response<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final okhttp3.Response f146991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f146992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ResponseBody f146993c;

    private Response(okhttp3.Response response, Object obj, ResponseBody responseBody) {
        this.f146991a = response;
        this.f146992b = obj;
        this.f146993c = responseBody;
    }

    public static Response c(ResponseBody responseBody, okhttp3.Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new Response(response, null, responseBody);
    }

    public Object a() {
        return this.f146992b;
    }

    public int b() {
        return this.f146991a.i();
    }

    public ResponseBody d() {
        return this.f146993c;
    }

    public boolean e() {
        return this.f146991a.isSuccessful();
    }

    public String f() {
        return this.f146991a.z();
    }

    public okhttp3.Response g() {
        return this.f146991a;
    }

    public String toString() {
        return this.f146991a.toString();
    }

    public static Response h(Object obj, okhttp3.Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new Response(response, obj, null);
        }
        throw new IllegalArgumentException(KrzujOtzIk.jAFMfAIzfKtz);
    }
}
