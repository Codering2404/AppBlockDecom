package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final MediaType f147052c = MediaType.e("application/json; charset=UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f147053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TypeAdapter f147054b;

    GsonRequestBodyConverter(Gson gson, TypeAdapter typeAdapter) {
        this.f147053a = gson;
        this.f147054b = typeAdapter;
    }

    @Override // retrofit2.Converter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RequestBody a(Object obj) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter jsonWriterQ = this.f147053a.q(new OutputStreamWriter(buffer.D2(), StandardCharsets.UTF_8));
        this.f147054b.d(jsonWriterQ, obj);
        jsonWriterQ.close();
        return RequestBody.c(f147052c, buffer.M());
    }
}
