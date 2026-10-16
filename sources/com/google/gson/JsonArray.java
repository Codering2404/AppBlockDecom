package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f90292a = new ArrayList();

    private JsonElement p() {
        int size = this.f90292a.size();
        if (size == 1) {
            return (JsonElement) this.f90292a.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }

    @Override // com.google.gson.JsonElement
    public int a() {
        return p().a();
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof JsonArray) && ((JsonArray) obj).f90292a.equals(this.f90292a);
        }
        return true;
    }

    @Override // com.google.gson.JsonElement
    public String f() {
        return p().f();
    }

    public int hashCode() {
        return this.f90292a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<JsonElement> iterator() {
        return this.f90292a.iterator();
    }

    public void o(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.f90293a;
        }
        this.f90292a.add(jsonElement);
    }
}
