package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbuc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f76908a = Logger.getLogger(zzbuc.class.getName());

    private zzbuc() {
    }

    public static Object a(String str) {
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        try {
            Object objB = b(jsonReader);
            try {
                jsonReader.close();
                return objB;
            } catch (IOException e3) {
                f76908a.logp(Level.WARNING, "io.grpc.internal.JsonParser", "parse", "Failed to close", (Throwable) e3);
                return objB;
            }
        } finally {
        }
    }

    private static Object b(JsonReader jsonReader) throws IOException {
        Preconditions.A(jsonReader.r(), "unexpected end of JSON");
        switch (zzbub.f76907a[jsonReader.j0().ordinal()]) {
            case 1:
                jsonReader.a();
                ArrayList arrayList = new ArrayList();
                while (jsonReader.r()) {
                    arrayList.add(b(jsonReader));
                }
                Preconditions.A(jsonReader.j0() == JsonToken.END_ARRAY, "Bad token: ".concat(String.valueOf(jsonReader.g())));
                jsonReader.j();
                return Collections.unmodifiableList(arrayList);
            case 2:
                jsonReader.b();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (jsonReader.r()) {
                    String strN = jsonReader.N();
                    Preconditions.m(!linkedHashMap.containsKey(strN), "Duplicate key found: %s", strN);
                    linkedHashMap.put(strN, b(jsonReader));
                }
                Preconditions.A(jsonReader.j0() == JsonToken.END_OBJECT, "Bad token: ".concat(String.valueOf(jsonReader.g())));
                jsonReader.k();
                return Collections.unmodifiableMap(linkedHashMap);
            case 3:
                return jsonReader.e0();
            case 4:
                return Double.valueOf(jsonReader.K());
            case 5:
                return Boolean.valueOf(jsonReader.J());
            case 6:
                jsonReader.T();
                return null;
            default:
                throw new IllegalStateException("Bad token: ".concat(String.valueOf(jsonReader.g())));
        }
    }
}
