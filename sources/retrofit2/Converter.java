package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public interface Converter<F, T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Factory {
        protected static Type a(int i3, ParameterizedType parameterizedType) {
            return Utils.g(i3, parameterizedType);
        }

        protected static Class b(Type type) {
            return Utils.h(type);
        }

        public Converter c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
            return null;
        }

        public Converter d(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }

        public Converter e(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }
    }

    Object a(Object obj);
}
