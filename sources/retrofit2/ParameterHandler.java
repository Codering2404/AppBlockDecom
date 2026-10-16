package retrofit2;

import androidx.glance.session.ecY.lisODU;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
abstract class ParameterHandler<T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Body<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f146890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Converter f146892c;

        Body(Method method, int i3, Converter converter) {
            this.f146890a = method;
            this.f146891b = i3;
            this.f146892c = converter;
        }

        @Override // retrofit2.ParameterHandler
        void a(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                throw Utils.p(this.f146890a, this.f146891b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                requestBuilder.l((RequestBody) this.f146892c.a(obj));
            } catch (IOException e3) {
                throw Utils.q(this.f146890a, e3, this.f146891b, "Unable to convert " + obj + " to RequestBody", new Object[0]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Field<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f146893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Converter f146894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f146895c;

        Field(String str, Converter converter, boolean z2) {
            Objects.requireNonNull(str, "name == null");
            this.f146893a = str;
            this.f146894b = converter;
            this.f146895c = z2;
        }

        @Override // retrofit2.ParameterHandler
        void a(RequestBuilder requestBuilder, Object obj) {
            String str;
            if (obj == null || (str = (String) this.f146894b.a(obj)) == null) {
                return;
            }
            requestBuilder.a(this.f146893a, str, this.f146895c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f146896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Converter f146898c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f146899d;

        FieldMap(Method method, int i3, Converter converter, boolean z2) {
            this.f146896a = method;
            this.f146897b = i3;
            this.f146898c = converter;
            this.f146899d = z2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(RequestBuilder requestBuilder, Map map) {
            if (map == null) {
                throw Utils.p(this.f146896a, this.f146897b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.p(this.f146896a, this.f146897b, "Field map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils.p(this.f146896a, this.f146897b, "Field map contained null value for key '" + str + "'.", new Object[0]);
                }
                String str2 = (String) this.f146898c.a(value);
                if (str2 == null) {
                    throw Utils.p(this.f146896a, this.f146897b, "Field map value '" + value + "' converted to null by " + this.f146898c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                requestBuilder.a(str, str2, this.f146899d);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Header<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f146900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Converter f146901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f146902c;

        Header(String str, Converter converter, boolean z2) {
            Objects.requireNonNull(str, "name == null");
            this.f146900a = str;
            this.f146901b = converter;
            this.f146902c = z2;
        }

        @Override // retrofit2.ParameterHandler
        void a(RequestBuilder requestBuilder, Object obj) {
            String str;
            if (obj == null || (str = (String) this.f146901b.a(obj)) == null) {
                return;
            }
            requestBuilder.b(this.f146900a, str, this.f146902c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f146903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146904b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Converter f146905c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f146906d;

        HeaderMap(Method method, int i3, Converter converter, boolean z2) {
            this.f146903a = method;
            this.f146904b = i3;
            this.f146905c = converter;
            this.f146906d = z2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(RequestBuilder requestBuilder, Map map) {
            if (map == null) {
                throw Utils.p(this.f146903a, this.f146904b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.p(this.f146903a, this.f146904b, "Header map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils.p(this.f146903a, this.f146904b, "Header map contained null value for key '" + str + "'.", new Object[0]);
                }
                requestBuilder.b(str, (String) this.f146905c.a(value), this.f146906d);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Headers extends ParameterHandler<okhttp3.Headers> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f146907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146908b;

        Headers(Method method, int i3) {
            this.f146907a = method;
            this.f146908b = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(RequestBuilder requestBuilder, okhttp3.Headers headers) {
            if (headers != null) {
                requestBuilder.c(headers);
            } else {
                throw Utils.p(this.f146907a, this.f146908b, lisODU.pPzyAYDOppXkfV, new Object[0]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Part<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f146909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final okhttp3.Headers f146911c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Converter f146912d;

        Part(Method method, int i3, okhttp3.Headers headers, Converter converter) {
            this.f146909a = method;
            this.f146910b = i3;
            this.f146911c = headers;
            this.f146912d = converter;
        }

        @Override // retrofit2.ParameterHandler
        void a(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                return;
            }
            try {
                requestBuilder.d(this.f146911c, (RequestBody) this.f146912d.a(obj));
            } catch (IOException e3) {
                throw Utils.p(this.f146909a, this.f146910b, "Unable to convert " + obj + " to RequestBody", e3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class PartMap<T> extends ParameterHandler<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f146913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Converter f146915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f146916d;

        PartMap(Method method, int i3, Converter converter, String str) {
            this.f146913a = method;
            this.f146914b = i3;
            this.f146915c = converter;
            this.f146916d = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(RequestBuilder requestBuilder, Map map) {
            if (map == null) {
                throw Utils.p(this.f146913a, this.f146914b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.p(this.f146913a, this.f146914b, "Part map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils.p(this.f146913a, this.f146914b, "Part map contained null value for key '" + str + "'.", new Object[0]);
                }
                requestBuilder.d(okhttp3.Headers.g("Content-Disposition", "form-data; name=\"" + str + "\"", "Content-Transfer-Encoding", this.f146916d), (RequestBody) this.f146915c.a(value));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Path<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f146917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f146919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Converter f146920d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f146921e;

        Path(Method method, int i3, String str, Converter converter, boolean z2) {
            this.f146917a = method;
            this.f146918b = i3;
            Objects.requireNonNull(str, "name == null");
            this.f146919c = str;
            this.f146920d = converter;
            this.f146921e = z2;
        }

        @Override // retrofit2.ParameterHandler
        void a(RequestBuilder requestBuilder, Object obj) throws EOFException {
            if (obj != null) {
                requestBuilder.f(this.f146919c, (String) this.f146920d.a(obj), this.f146921e);
                return;
            }
            throw Utils.p(this.f146917a, this.f146918b, "Path parameter \"" + this.f146919c + "\" value must not be null.", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Query<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f146922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Converter f146923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f146924c;

        Query(String str, Converter converter, boolean z2) {
            Objects.requireNonNull(str, "name == null");
            this.f146922a = str;
            this.f146923b = converter;
            this.f146924c = z2;
        }

        @Override // retrofit2.ParameterHandler
        void a(RequestBuilder requestBuilder, Object obj) {
            String str;
            if (obj == null || (str = (String) this.f146923b.a(obj)) == null) {
                return;
            }
            requestBuilder.g(this.f146922a, str, this.f146924c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f146925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Converter f146927c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f146928d;

        QueryMap(Method method, int i3, Converter converter, boolean z2) {
            this.f146925a = method;
            this.f146926b = i3;
            this.f146927c = converter;
            this.f146928d = z2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(RequestBuilder requestBuilder, Map map) {
            if (map == null) {
                throw Utils.p(this.f146925a, this.f146926b, "Query map was null", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.p(this.f146925a, this.f146926b, "Query map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils.p(this.f146925a, this.f146926b, "Query map contained null value for key '" + str + "'.", new Object[0]);
                }
                String str2 = (String) this.f146927c.a(value);
                if (str2 == null) {
                    throw Utils.p(this.f146925a, this.f146926b, "Query map value '" + value + "' converted to null by " + this.f146927c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                requestBuilder.g(str, str2, this.f146928d);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class QueryName<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Converter f146929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f146930b;

        QueryName(Converter converter, boolean z2) {
            this.f146929a = converter;
            this.f146930b = z2;
        }

        @Override // retrofit2.ParameterHandler
        void a(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                return;
            }
            requestBuilder.g((String) this.f146929a.a(obj), null, this.f146930b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RawPart extends ParameterHandler<MultipartBody.Part> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final RawPart f146931a = new RawPart();

        private RawPart() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(RequestBuilder requestBuilder, MultipartBody.Part part) {
            if (part != null) {
                requestBuilder.e(part);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RelativeUrl extends ParameterHandler<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f146932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f146933b;

        RelativeUrl(Method method, int i3) {
            this.f146932a = method;
            this.f146933b = i3;
        }

        @Override // retrofit2.ParameterHandler
        void a(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                throw Utils.p(this.f146932a, this.f146933b, "@Url parameter is null.", new Object[0]);
            }
            requestBuilder.m(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Tag<T> extends ParameterHandler<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class f146934a;

        Tag(Class cls) {
            this.f146934a = cls;
        }

        @Override // retrofit2.ParameterHandler
        void a(RequestBuilder requestBuilder, Object obj) {
            requestBuilder.h(this.f146934a, obj);
        }
    }

    ParameterHandler() {
    }

    abstract void a(RequestBuilder requestBuilder, Object obj);

    final ParameterHandler b() {
        return new ParameterHandler<Object>() { // from class: retrofit2.ParameterHandler.2
            @Override // retrofit2.ParameterHandler
            void a(RequestBuilder requestBuilder, Object obj) {
                if (obj == null) {
                    return;
                }
                int length = Array.getLength(obj);
                for (int i3 = 0; i3 < length; i3++) {
                    ParameterHandler.this.a(requestBuilder, Array.get(obj, i3));
                }
            }
        };
    }

    final ParameterHandler c() {
        return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.ParameterHandler.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // retrofit2.ParameterHandler
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(RequestBuilder requestBuilder, Iterable iterable) {
                if (iterable == null) {
                    return;
                }
                Iterator<T> it = iterable.iterator();
                while (it.hasNext()) {
                    ParameterHandler.this.a(requestBuilder, it.next());
                }
            }
        };
    }
}
