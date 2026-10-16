package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public final class RawJwt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JsonObject f86323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Optional f86324b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    public String toString() {
        JsonObject jsonObject = new JsonObject();
        if (this.f86324b.isPresent()) {
            jsonObject.o("typ", new JsonPrimitive((String) this.f86324b.get()));
        }
        return jsonObject + "." + this.f86323a;
    }
}
