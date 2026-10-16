package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Excluder f90341h = new Excluder();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f90342a = -1.0d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f90343b = 136;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f90344c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f90345d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f90346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f90347g;

    public Excluder() {
        List list = Collections.EMPTY_LIST;
        this.f90346f = list;
        this.f90347g = list;
    }

    private boolean e(Class cls) {
        if (this.f90342a != -1.0d && !p((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if (this.f90344c || !j(cls)) {
            return i(cls);
        }
        return true;
    }

    private boolean g(Class cls, boolean z2) {
        Iterator it = (z2 ? this.f90346f : this.f90347g).iterator();
        while (it.hasNext()) {
            if (((ExclusionStrategy) it.next()).b(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean i(Class cls) {
        if (Enum.class.isAssignableFrom(cls) || k(cls)) {
            return false;
        }
        return cls.isAnonymousClass() || cls.isLocalClass();
    }

    private boolean j(Class cls) {
        return cls.isMemberClass() && !k(cls);
    }

    private boolean k(Class cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean m(Since since) {
        if (since != null) {
            return this.f90342a >= since.value();
        }
        return true;
    }

    private boolean o(Until until) {
        if (until != null) {
            return this.f90342a < until.value();
        }
        return true;
    }

    private boolean p(Since since, Until until) {
        return m(since) && o(until);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public TypeAdapter a(final Gson gson, final TypeToken typeToken) {
        Class clsC = typeToken.c();
        boolean zE = e(clsC);
        final boolean z2 = zE || g(clsC, true);
        final boolean z3 = zE || g(clsC, false);
        if (z2 || z3) {
            return new TypeAdapter<Object>() { // from class: com.google.gson.internal.Excluder.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private TypeAdapter f90348a;

                private TypeAdapter e() {
                    TypeAdapter typeAdapter = this.f90348a;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    TypeAdapter typeAdapterN = gson.n(Excluder.this, typeToken);
                    this.f90348a = typeAdapterN;
                    return typeAdapterN;
                }

                @Override // com.google.gson.TypeAdapter
                public Object b(JsonReader jsonReader) throws IOException {
                    if (!z3) {
                        return e().b(jsonReader);
                    }
                    jsonReader.h1();
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public void d(JsonWriter jsonWriter, Object obj) throws IOException {
                    if (z2) {
                        jsonWriter.F();
                    } else {
                        e().d(jsonWriter, obj);
                    }
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e3) {
            throw new AssertionError(e3);
        }
    }

    public boolean c(Class cls, boolean z2) {
        return e(cls) || g(cls, z2);
    }

    public boolean h(Field field, boolean z2) {
        Expose expose;
        if ((this.f90343b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f90342a != -1.0d && !p((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f90345d && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z2 ? expose.deserialize() : expose.serialize()))) {
            return true;
        }
        if ((!this.f90344c && j(field.getType())) || i(field.getType())) {
            return true;
        }
        List list = z2 ? this.f90346f : this.f90347g;
        if (list.isEmpty()) {
            return false;
        }
        FieldAttributes fieldAttributes = new FieldAttributes(field);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ExclusionStrategy) it.next()).a(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }
}
