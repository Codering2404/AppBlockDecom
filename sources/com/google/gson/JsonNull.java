package com.google.gson;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JsonNull extends JsonElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonNull f90293a = new JsonNull();

    public boolean equals(Object obj) {
        return obj instanceof JsonNull;
    }

    public int hashCode() {
        return JsonNull.class.hashCode();
    }
}
