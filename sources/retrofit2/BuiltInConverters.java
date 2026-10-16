package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.http.Streaming;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class BuiltInConverters extends Converter.Factory {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final BufferingResponseBodyConverter f146822a = new BufferingResponseBodyConverter();

        BufferingResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResponseBody a(ResponseBody responseBody) {
            try {
                return Utils.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ToStringConverter implements Converter<Object, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ToStringConverter f146825a = new ToStringConverter();

        ToStringConverter() {
        }

        @Override // retrofit2.Converter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(Object obj) {
            return obj.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UnitResponseBodyConverter implements Converter<ResponseBody, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final UnitResponseBodyConverter f146826a = new UnitResponseBodyConverter();

        UnitResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Unit a(ResponseBody responseBody) {
            responseBody.close();
            return Unit.f139807a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class VoidResponseBodyConverter implements Converter<ResponseBody, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final VoidResponseBodyConverter f146827a = new VoidResponseBodyConverter();

        VoidResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    BuiltInConverters() {
    }

    @Override // retrofit2.Converter.Factory
    public Converter c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (RequestBody.class.isAssignableFrom(Utils.h(type))) {
            return RequestBodyConverter.f146823a;
        }
        return null;
    }

    @Override // retrofit2.Converter.Factory
    public Converter d(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == ResponseBody.class) {
            return Utils.l(annotationArr, Streaming.class) ? StreamingResponseBodyConverter.f146824a : BufferingResponseBodyConverter.f146822a;
        }
        if (type == Void.class) {
            return VoidResponseBodyConverter.f146827a;
        }
        if (Utils.m(type)) {
            return UnitResponseBodyConverter.f146826a;
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RequestBodyConverter implements Converter<RequestBody, RequestBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final RequestBodyConverter f146823a = new RequestBodyConverter();

        RequestBodyConverter() {
        }

        @Override // retrofit2.Converter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RequestBody a(RequestBody requestBody) {
            return requestBody;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class StreamingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final StreamingResponseBodyConverter f146824a = new StreamingResponseBodyConverter();

        StreamingResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResponseBody a(ResponseBody responseBody) {
            return responseBody;
        }
    }
}
