package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzld extends zzgi {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Locale f78090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f78091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zznh f78092d;

    protected zzld(zzmq zzmqVar, Locale locale, String str, zznh zznhVar) {
        super(zzmqVar);
        this.f78090b = locale;
        this.f78091c = str;
        this.f78092d = zznhVar;
    }

    protected static void g(Map map, String str, Object obj, Object obj2) {
        String string = obj != null ? obj.toString() : null;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        map.put(str, string);
    }

    @Override // com.google.android.libraries.places.internal.zzgi
    protected final Map c() {
        HashMap map = new HashMap();
        map.putAll(this.f78092d.a());
        map.put("X-Places-Android-Sdk", "5.1.1");
        return map;
    }

    @Override // com.google.android.libraries.places.internal.zzgi
    protected final String d() {
        zzlp zzlpVar = new zzlp(f(), this.f78091c);
        zzlpVar.a(this.f78090b);
        zzlpVar.b(e());
        return zzlpVar.c();
    }

    protected abstract Map e();

    protected abstract String f();
}
