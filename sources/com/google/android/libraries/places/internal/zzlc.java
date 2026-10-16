package com.google.android.libraries.places.internal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzlc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f78089a = new GsonBuilder().d(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).b();

    public final Object a(String str, Class cls) throws zzgk {
        try {
            return this.f78089a.j(str, cls);
        } catch (JsonSyntaxException unused) {
            String name = cls.getName();
            StringBuilder sb = new StringBuilder(name.length() + 55);
            sb.append("Could not convert JSON string to ");
            sb.append(name);
            sb.append(" due to syntax errors.");
            throw new zzgk(sb.toString());
        }
    }
}
