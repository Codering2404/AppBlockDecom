package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JsonObject extends JsonElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedTreeMap f90294a = new LinkedTreeMap(false);

    public Set entrySet() {
        return this.f90294a.entrySet();
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof JsonObject) && ((JsonObject) obj).f90294a.equals(this.f90294a);
        }
        return true;
    }

    public int hashCode() {
        return this.f90294a.hashCode();
    }

    public void o(String str, JsonElement jsonElement) {
        LinkedTreeMap linkedTreeMap = this.f90294a;
        if (jsonElement == null) {
            jsonElement = JsonNull.f90293a;
        }
        linkedTreeMap.put(str, jsonElement);
    }

    public JsonElement p(String str) {
        return (JsonElement) this.f90294a.get(str);
    }

    public boolean q(String str) {
        return this.f90294a.containsKey(str);
    }
}
