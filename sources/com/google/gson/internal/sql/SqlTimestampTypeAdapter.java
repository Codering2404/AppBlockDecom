package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final TypeAdapterFactory f90534b = new TypeAdapterFactory() { // from class: com.google.gson.internal.sql.SqlTimestampTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.c() == Timestamp.class) {
                return new SqlTimestampTypeAdapter(gson.m(Date.class));
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TypeAdapter f90535a;

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Timestamp b(JsonReader jsonReader) {
        Date date = (Date) this.f90535a.b(jsonReader);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(JsonWriter jsonWriter, Timestamp timestamp) {
        this.f90535a.d(jsonWriter, timestamp);
    }

    private SqlTimestampTypeAdapter(TypeAdapter typeAdapter) {
        this.f90535a = typeAdapter;
    }
}
