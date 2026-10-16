package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class GsonBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Excluder f90272a = Excluder.f90341h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LongSerializationPolicy f90273b = LongSerializationPolicy.DEFAULT;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FieldNamingStrategy f90274c = FieldNamingPolicy.IDENTITY;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f90275d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f90276e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f90277f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f90278g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f90279h = Gson.f90241z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f90280i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f90281j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f90282k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f90283l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f90284m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f90285n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f90286o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f90287p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f90288q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ToNumberStrategy f90289r = Gson.B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ToNumberStrategy f90290s = Gson.C;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final LinkedList f90291t = new LinkedList();

    private void a(String str, int i3, int i4, List list) {
        TypeAdapterFactory typeAdapterFactoryB;
        TypeAdapterFactory typeAdapterFactoryB2;
        boolean z2 = SqlTypesSupport.f90536a;
        TypeAdapterFactory typeAdapterFactoryA = null;
        if (str != null && !str.trim().isEmpty()) {
            typeAdapterFactoryB = DefaultDateTypeAdapter.DateType.f90406b.b(str);
            if (z2) {
                typeAdapterFactoryA = SqlTypesSupport.f90538c.b(str);
                typeAdapterFactoryB2 = SqlTypesSupport.f90537b.b(str);
            } else {
                typeAdapterFactoryB2 = null;
            }
        } else {
            if (i3 == 2 || i4 == 2) {
                return;
            }
            TypeAdapterFactory typeAdapterFactoryA2 = DefaultDateTypeAdapter.DateType.f90406b.a(i3, i4);
            if (z2) {
                typeAdapterFactoryA = SqlTypesSupport.f90538c.a(i3, i4);
                TypeAdapterFactory typeAdapterFactoryA3 = SqlTypesSupport.f90537b.a(i3, i4);
                typeAdapterFactoryB = typeAdapterFactoryA2;
                typeAdapterFactoryB2 = typeAdapterFactoryA3;
            } else {
                typeAdapterFactoryB = typeAdapterFactoryA2;
                typeAdapterFactoryB2 = null;
            }
        }
        list.add(typeAdapterFactoryB);
        if (z2) {
            list.add(typeAdapterFactoryA);
            list.add(typeAdapterFactoryB2);
        }
    }

    public Gson b() {
        ArrayList arrayList = new ArrayList(this.f90276e.size() + this.f90277f.size() + 3);
        arrayList.addAll(this.f90276e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f90277f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f90279h, this.f90280i, this.f90281j, arrayList);
        return new Gson(this.f90272a, this.f90274c, new HashMap(this.f90275d), this.f90278g, this.f90282k, this.f90286o, this.f90284m, this.f90285n, this.f90287p, this.f90283l, this.f90288q, this.f90273b, this.f90279h, this.f90280i, this.f90281j, new ArrayList(this.f90276e), new ArrayList(this.f90277f), arrayList, this.f90289r, this.f90290s, new ArrayList(this.f90291t));
    }

    public GsonBuilder c(Type type, Object obj) {
        Objects.requireNonNull(type);
        boolean z2 = obj instanceof JsonSerializer;
        C$Gson$Preconditions.a(z2 || (obj instanceof JsonDeserializer) || (obj instanceof InstanceCreator) || (obj instanceof TypeAdapter));
        if (obj instanceof InstanceCreator) {
            this.f90275d.put(type, (InstanceCreator) obj);
        }
        if (z2 || (obj instanceof JsonDeserializer)) {
            this.f90276e.add(TreeTypeAdapter.g(TypeToken.b(type), obj));
        }
        if (obj instanceof TypeAdapter) {
            this.f90276e.add(TypeAdapters.a(TypeToken.b(type), (TypeAdapter) obj));
        }
        return this;
    }

    public GsonBuilder d(FieldNamingPolicy fieldNamingPolicy) {
        return e(fieldNamingPolicy);
    }

    public GsonBuilder e(FieldNamingStrategy fieldNamingStrategy) {
        Objects.requireNonNull(fieldNamingStrategy);
        this.f90274c = fieldNamingStrategy;
        return this;
    }

    public GsonBuilder f() {
        this.f90285n = true;
        return this;
    }
}
