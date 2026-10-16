package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzkq extends zzld {
    zzkq(FetchPlaceRequest fetchPlaceRequest, Locale locale, String str, zznh zznhVar) {
        super(fetchPlaceRequest, locale, str, zznhVar);
    }

    @Override // com.google.android.libraries.places.internal.zzld
    public final Map e() {
        FetchPlaceRequest fetchPlaceRequest = (FetchPlaceRequest) a();
        HashMap map = new HashMap();
        zzld.g(map, "placeid", fetchPlaceRequest.d(), null);
        zzld.g(map, "sessiontoken", fetchPlaceRequest.f(), null);
        zzld.g(map, "fields", zzlw.b(fetchPlaceRequest.c()), null);
        return map;
    }

    @Override // com.google.android.libraries.places.internal.zzld
    protected final String f() {
        return "details/json";
    }
}
