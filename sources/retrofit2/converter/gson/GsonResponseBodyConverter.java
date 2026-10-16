package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f147055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypeAdapter f147056b;

    GsonResponseBodyConverter(Gson gson, TypeAdapter typeAdapter) {
        this.f147055a = gson;
        this.f147056b = typeAdapter;
    }

    @Override // retrofit2.Converter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Object a(ResponseBody responseBody) {
        JsonReader jsonReaderP = this.f147055a.p(responseBody.b());
        try {
            Object objB = this.f147056b.b(jsonReaderP);
            if (jsonReaderP.j0() == JsonToken.END_DOCUMENT) {
                return objB;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
