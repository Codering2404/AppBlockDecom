package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
abstract class ServiceMethod<T> {
    ServiceMethod() {
    }

    static ServiceMethod b(Retrofit retrofit, Class cls, Method method) {
        RequestFactory requestFactoryB = RequestFactory.b(retrofit, cls, method);
        Type genericReturnType = method.getGenericReturnType();
        if (Utils.j(genericReturnType)) {
            throw Utils.n(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }
        if (genericReturnType != Void.TYPE) {
            return HttpServiceMethod.f(retrofit, method, requestFactoryB);
        }
        throw Utils.n(method, "Service methods cannot return void.", new Object[0]);
    }

    abstract Object a(Object obj, Object[] objArr);
}
