package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class OptionalConverterFactory extends Converter.Factory {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OptionalConverter<T> implements Converter<ResponseBody, Optional<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Converter f146887a;

        OptionalConverter(Converter converter) {
            this.f146887a = converter;
        }

        @Override // retrofit2.Converter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Optional a(ResponseBody responseBody) {
            return Optional.ofNullable(this.f146887a.a(responseBody));
        }
    }

    OptionalConverterFactory() {
    }

    @Override // retrofit2.Converter.Factory
    public Converter d(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Converter.Factory.b(type) != Optional.class) {
            return null;
        }
        return new OptionalConverter(retrofit.h(Converter.Factory.a(0, (ParameterizedType) type), annotationArr));
    }
}
