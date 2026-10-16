package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DateType f90404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f90405b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class DateType<T extends Date> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final DateType f90406b = new DateType<Date>(Date.class) { // from class: com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType.1
            @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
            protected Date d(Date date) {
                return date;
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f90407a;

        protected DateType(Class cls) {
            this.f90407a = cls;
        }

        private TypeAdapterFactory c(DefaultDateTypeAdapter defaultDateTypeAdapter) {
            return TypeAdapters.b(this.f90407a, defaultDateTypeAdapter);
        }

        public final TypeAdapterFactory a(int i3, int i4) {
            return c(new DefaultDateTypeAdapter(this, i3, i4));
        }

        public final TypeAdapterFactory b(String str) {
            return c(new DefaultDateTypeAdapter(this, str));
        }

        protected abstract Date d(Date date);
    }

    private Date e(JsonReader jsonReader) throws IOException {
        String strE0 = jsonReader.e0();
        synchronized (this.f90405b) {
            try {
                Iterator it = this.f90405b.iterator();
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
        if (jsonReader.j0() == JsonToken.NULL) {
            jsonReader.T();
            return null;
        }
        return this.f90404a.d(e(jsonReader));
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(JsonWriter jsonWriter, Date date) throws IOException {
        String str;
        if (date == null) {
            jsonWriter.F();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f90405b.get(0);
        synchronized (this.f90405b) {
            str = dateFormat.format(date);
        }
        jsonWriter.z0(str);
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.f90405b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    private DefaultDateTypeAdapter(DateType dateType, String str) {
        ArrayList arrayList = new ArrayList();
        this.f90405b = arrayList;
        Objects.requireNonNull(dateType);
        this.f90404a = dateType;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    private DefaultDateTypeAdapter(DateType dateType, int i3, int i4) {
        ArrayList arrayList = new ArrayList();
        this.f90405b = arrayList;
        Objects.requireNonNull(dateType);
        this.f90404a = dateType;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i3, i4, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i3, i4));
        }
        if (JavaVersion.d()) {
            arrayList.add(PreJava9DateFormatProvider.c(i3, i4));
        }
    }
}
