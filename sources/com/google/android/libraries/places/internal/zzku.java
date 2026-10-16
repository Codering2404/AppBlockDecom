package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzku extends zzld {
    zzku(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, Locale locale, String str, zznh zznhVar) {
        super(findAutocompletePredictionsRequest, locale, str, zznhVar);
    }

    @Override // com.google.android.libraries.places.internal.zzld
    public final Map e() {
        HashMap map = new HashMap();
        FindAutocompletePredictionsRequest findAutocompletePredictionsRequest = (FindAutocompletePredictionsRequest) a();
        List listK = findAutocompletePredictionsRequest.k();
        String strH = findAutocompletePredictionsRequest.h();
        zzld.g(map, "input", strH == null ? null : strH.replaceFirst("^\\s+", "").replaceFirst("\\s+$", " "), null);
        if (!listK.isEmpty()) {
            zzld.g(map, "types", TextUtils.join("|", listK), null);
        }
        zzld.g(map, "sessiontoken", findAutocompletePredictionsRequest.j(), null);
        zzld.g(map, "origin", zzlv.c(findAutocompletePredictionsRequest.g()), null);
        zzld.g(map, "locationbias", zzlv.d(findAutocompletePredictionsRequest.e()), null);
        zzld.g(map, "locationrestriction", zzlv.e(findAutocompletePredictionsRequest.f()), null);
        List<String> listC = findAutocompletePredictionsRequest.c();
        StringBuilder sb = new StringBuilder();
        for (String str : listC) {
            String strConcat = TextUtils.isEmpty(str) ? null : "country:".concat(String.valueOf(str.toLowerCase(Locale.US)));
            if (strConcat != null) {
                if (sb.length() != 0) {
                    sb.append('|');
                }
                sb.append(strConcat);
            }
        }
        zzld.g(map, "components", sb.length() == 0 ? null : sb.toString(), null);
        return map;
    }

    @Override // com.google.android.libraries.places.internal.zzld
    protected final String f() {
        return "autocomplete/json";
    }
}
