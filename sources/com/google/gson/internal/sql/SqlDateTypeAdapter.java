package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class SqlDateTypeAdapter extends TypeAdapter<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final TypeAdapterFactory f90530b = new TypeAdapterFactory() { // from class: com.google.gson.internal.sql.SqlDateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.c() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateFormat f90531a;

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Date b(JsonReader jsonReader) throws IOException {
        java.util.Date date;
        if (jsonReader.j0() == JsonToken.NULL) {
            jsonReader.T();
            return null;
        }
        String strE0 = jsonReader.e0();
        try {
            synchronized (this) {
                date = this.f90531a.parse(strE0);
            }
            return new Date(date.getTime());
        } catch (ParseException e3) {
            throw new JsonSyntaxException("Failed parsing '" + strE0 + "' as SQL Date; at path " + jsonReader.n(), e3);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(JsonWriter jsonWriter, Date date) throws IOException {
        String str;
        if (date == null) {
            jsonWriter.F();
            return;
        }
        synchronized (this) {
            str = this.f90531a.format((java.util.Date) date);
        }
        jsonWriter.z0(str);
    }

    private SqlDateTypeAdapter() {
        this.f90531a = new SimpleDateFormat("MMM d, yyyy");
    }
}
