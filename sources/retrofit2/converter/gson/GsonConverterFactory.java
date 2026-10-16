package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class GsonConverterFactory extends Converter.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f147051a;

    private GsonConverterFactory(Gson gson) {
        this.f147051a = gson;
    }

    public static GsonConverterFactory f() {
        return g(new Gson());
    }

    public static GsonConverterFactory g(Gson gson) {
        if (gson != null) {
            return new GsonConverterFactory(gson);
        }
        throw new NullPointerException("gson == null");
    }

    @Override // retrofit2.Converter.Factory
    public Converter c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.f147051a, this.f147051a.l(TypeToken.b(type)));
    }

    @Override // retrofit2.Converter.Factory
    public Converter d(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.f147051a, this.f147051a.l(TypeToken.b(type)));
    }
}
