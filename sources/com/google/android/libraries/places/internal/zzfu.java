package com.google.android.libraries.places.internal;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzfu {
    static ApiException a(VolleyError volleyError) {
        int i3 = volleyError instanceof NetworkError ? 7 : volleyError instanceof TimeoutError ? 15 : ((volleyError instanceof ServerError) || (volleyError instanceof ParseError)) ? 8 : volleyError instanceof AuthFailureError ? 9011 : 13;
        NetworkResponse networkResponse = volleyError.f57722a;
        return new ApiException(new Status(i3, String.format("Unexpected server error (HTTP Code: %s. Message: %s.)", networkResponse == null ? "N/A" : String.valueOf(networkResponse.f57676a), volleyError)));
    }

    static ApiException b(zzbns zzbnsVar) {
        zzbnp zzbnpVarB = zzbnp.b(zzbnsVar);
        zzbnm zzbnmVar = zzbnm.OK;
        int iOrdinal = zzbnpVarB.g().ordinal();
        return iOrdinal != 3 ? iOrdinal != 4 ? iOrdinal != 5 ? iOrdinal != 7 ? iOrdinal != 13 ? iOrdinal != 14 ? new ApiException(new Status(13, zzbnpVarB.h())) : new ApiException(new Status(7, zzbnpVarB.h())) : new ApiException(new Status(8, zzbnpVarB.h())) : new ApiException(new Status(9011, zzbnpVarB.h())) : new ApiException(new Status(9013, zzbnpVarB.h())) : new ApiException(new Status(15, zzbnpVarB.h())) : new ApiException(new Status(9012, zzbnpVarB.h()));
    }
}
