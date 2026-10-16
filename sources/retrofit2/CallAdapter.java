package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public interface CallAdapter<R, T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Factory {
        protected static Type b(int i3, ParameterizedType parameterizedType) {
            return Utils.g(i3, parameterizedType);
        }

        protected static Class c(Type type) {
            return Utils.h(type);
        }

        public abstract CallAdapter a(Type type, Annotation[] annotationArr, Retrofit retrofit);
    }

    Type a();

    Object b(Call call);
}
