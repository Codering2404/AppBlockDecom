package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import com.google.android.libraries.places.internal.zzkk;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzkw {
    zzkw() {
    }

    public static final FindAutocompletePredictionsResponse a(zzkv zzkvVar) throws ApiException {
        int iA = zzlu.a(zzkvVar.f78079a);
        if (PlacesStatusCodes.b(iA)) {
            throw new ApiException(new Status(iA, zzlu.b(zzkvVar.f78079a, zzkvVar.f78080b)));
        }
        ArrayList arrayList = new ArrayList();
        zzkk[] zzkkVarArr = zzkvVar.f78081c;
        if (zzkkVarArr != null) {
            for (zzkk zzkkVar : zzkkVarArr) {
                if (zzkkVar == null || TextUtils.isEmpty(zzkkVar.c())) {
                    throw new ApiException(new Status(8, "Unexpected server error: Place ID not provided for an autocomplete prediction result"));
                }
                AutocompletePrediction.Builder builderA = AutocompletePrediction.a(zzkkVar.c());
                builderA.b(zzkkVar.b());
                builderA.f(zzlq.e(zzlq.c(zzkkVar.e())));
                builderA.c(Strings.e(zzkkVar.a()));
                builderA.h(b(zzkkVar.f()));
                zzkk.zza zzaVarD = zzkkVar.d();
                if (zzaVarD != null) {
                    builderA.d(Strings.e(zzaVarD.a()));
                    builderA.i(b(zzaVarD.c()));
                    builderA.e(Strings.e(zzaVarD.b()));
                    builderA.j(b(zzaVarD.d()));
                }
                arrayList.add(builderA.a());
            }
        }
        return FindAutocompletePredictionsResponse.b(arrayList);
    }

    private static List b(List list) throws ApiException {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzkk.zzb zzbVar = (zzkk.zzb) it.next();
            Status status = new Status(8, "Unexpected server error: Place ID not provided for an autocomplete prediction result");
            if (zzbVar == null) {
                throw new ApiException(status);
            }
            Integer num = zzbVar.f78071a;
            Integer num2 = zzbVar.f78072b;
            if (num == null || num2 == null) {
                throw new ApiException(status);
            }
            com.google.android.libraries.places.api.model.zzfr zzfrVarE = com.google.android.libraries.places.api.model.zzfs.e();
            zzfrVarE.a(num.intValue());
            zzfrVarE.b(num2.intValue());
            arrayList.add(zzfrVarE.c());
        }
        return arrayList;
    }
}
