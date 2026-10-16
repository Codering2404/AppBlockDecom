package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TypeAdapterFactory f90402b = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.DateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.c() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f90403a;

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.f90403a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (JavaVersion.d()) {
            arrayList.add(PreJava9DateFormatProvider.c(2, 2));
        }
    }

    private Date e(JsonReader jsonReader) throws IOException {
        String strE0 = jsonReader.e0();
        synchronized (this.f90403a) {
            try {
                Iterator it = this.f90403a.iterator();
                while (it.hasNext()) {
                    try {
                        return ((DateFormat) it.next()).parse(strE0);
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return ISO8601Utils.f(strE0, new ParsePosition(0));
                } catch (ParseException e3) {
                    throw new JsonSyntaxException("Failed parsing '" + strE0 + "' as Date; at path " + jsonReader.n(), e3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date b(JsonReader jsonReader) throws IOException {
        if (jsonReader.j0() != JsonToken.NULL) {
            return e(jsonReader);
        }
        jsonReader.T();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(JsonWriter jsonWriter, Date date) throws IOException {
        String str;
        if (date == null) {
            jsonWriter.F();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f90403a.get(0);
        synchronized (this.f90403a) {
            str = dateFormat.format(date);
        }
        jsonWriter.z0(str);
    }
}
