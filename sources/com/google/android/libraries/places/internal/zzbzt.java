package com.google.android.libraries.places.internal;

import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbzt {
    private zzbzt() {
    }

    static Set a(Map map) {
        Set setC = c(map, "retryableStatusCodes");
        Verify.a(setC != null, "%s is required in retry policy", "retryableStatusCodes");
        Verify.a(true ^ setC.contains(zzbnm.OK), "%s must not contain OK", "retryableStatusCodes");
        return setC;
    }

    static Set b(Map map) {
        Set setC = c(map, "nonFatalStatusCodes");
        if (setC == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(zzbnm.class));
        }
        Verify.a(!setC.contains(zzbnm.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return setC;
    }

    private static Set c(Map map, String str) {
        zzbnm zzbnmVarG;
        List listA = zzbud.a(map, str);
        if (listA == null) {
            return null;
        }
        EnumSet enumSetNoneOf = EnumSet.noneOf(zzbnm.class);
        for (Object obj : listA) {
            if (obj instanceof Double) {
                Double d3 = (Double) obj;
                int iIntValue = d3.intValue();
                Verify.a(((double) iIntValue) == d3.doubleValue(), "Status code %s is not integral", obj);
                zzbnmVarG = zzbnp.a(iIntValue).g();
                Verify.a(zzbnmVarG.zza() == d3.intValue(), "Status code %s is not valid", obj);
            } else {
                if (!(obj instanceof String)) {
                    String strValueOf = String.valueOf(obj);
                    String strValueOf2 = String.valueOf(obj.getClass());
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 65 + strValueOf2.length());
                    sb.append("Can not convert status code ");
                    sb.append(strValueOf);
                    sb.append(" to Status.Code, because its type is ");
                    sb.append(strValueOf2);
                    throw new VerifyException(sb.toString());
                }
                try {
                    zzbnm zzbnmVar = zzbnm.OK;
                    zzbnmVarG = (zzbnm) Enum.valueOf(zzbnm.class, (String) obj);
                } catch (IllegalArgumentException e3) {
                    String strValueOf3 = String.valueOf(obj);
                    StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 25);
                    sb2.append("Status code ");
                    sb2.append(strValueOf3);
                    sb2.append(" is not valid");
                    throw new VerifyException(sb2.toString(), e3);
                }
            }
            enumSetNoneOf.add(zzbnmVarG);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }
}
