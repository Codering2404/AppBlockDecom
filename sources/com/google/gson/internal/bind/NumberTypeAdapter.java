package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class NumberTypeAdapter extends TypeAdapter<Number> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final TypeAdapterFactory f90427b = f(ToNumberPolicy.LAZILY_PARSED_NUMBER);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ToNumberStrategy f90428a;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.NumberTypeAdapter$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f90430a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f90430a = iArr;
            try {
                iArr[JsonToken.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f90430a[JsonToken.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f90430a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private NumberTypeAdapter(ToNumberStrategy toNumberStrategy) {
        this.f90428a = toNumberStrategy;
    }

    public static TypeAdapterFactory e(ToNumberStrategy toNumberStrategy) {
        return toNumberStrategy == ToNumberPolicy.LAZILY_PARSED_NUMBER ? f90427b : f(toNumberStrategy);
    }

    private static TypeAdapterFactory f(ToNumberStrategy toNumberStrategy) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.NumberTypeAdapter.1
            @Override // com.google.gson.TypeAdapterFactory
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                if (typeToken.c() == Number.class) {
                    return NumberTypeAdapter.this;
                }
                return null;
            }
        };
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Number b(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenJ0 = jsonReader.j0();
        int i3 = AnonymousClass2.f90430a[jsonTokenJ0.ordinal()];
        if (i3 == 1) {
            jsonReader.T();
            return null;
        }
        if (i3 == 2 || i3 == 3) {
            return this.f90428a.a(jsonReader);
        }
        throw new JsonSyntaxException("Expecting number, got: " + jsonTokenJ0 + "; at path " + jsonReader.g());
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(JsonWriter jsonWriter, Number number) throws IOException {
        jsonWriter.w0(number);
    }
}
