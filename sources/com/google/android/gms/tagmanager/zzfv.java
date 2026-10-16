package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.Log;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.analytics.ecommerce.Product;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfv extends zzfs {
    private static final String zza = com.google.android.gms.internal.gtm.zza.UNIVERSAL_ANALYTICS.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ANALYTICS_PASS_THROUGH.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.ENABLE_ECOMMERCE.toString();
    private static final String zzd = com.google.android.gms.internal.gtm.zzb.ECOMMERCE_USE_DATA_LAYER.toString();
    private static final String zze = com.google.android.gms.internal.gtm.zzb.ECOMMERCE_MACRO_DATA.toString();
    private static final String zzf = com.google.android.gms.internal.gtm.zzb.ANALYTICS_FIELDS.toString();
    private static final String zzg = com.google.android.gms.internal.gtm.zzb.TRACK_TRANSACTION.toString();
    private static final String zzh = com.google.android.gms.internal.gtm.zzb.TRANSACTION_DATALAYER_MAP.toString();
    private static final String zzi = com.google.android.gms.internal.gtm.zzb.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static final List zzj = Arrays.asList("detail", AppLovinEventTypes.USER_COMPLETED_CHECKOUT, "checkout_option", "click", "add", "remove", "purchase", "refund");
    private static final Pattern zzk = Pattern.compile("dimension(\\d+)");
    private static final Pattern zzl = Pattern.compile("metric(\\d+)");
    private static Map zzm;
    private static Map zzn;
    private final Set zzo;
    private final zzfr zzp;
    private final DataLayer zzq;

    public zzfv(Context context, DataLayer dataLayer) {
        zzfr zzfrVar = new zzfr(context);
        super(zza, new String[0]);
        this.zzq = dataLayer;
        this.zzp = zzfrVar;
        HashSet hashSet = new HashSet();
        this.zzo = hashSet;
        hashSet.add("");
        hashSet.add(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashSet.add("false");
    }

    private final String zzd(String str) {
        Object obj = this.zzq.get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    private final Map zzh(com.google.android.gms.internal.gtm.zzam zzamVar) {
        if (zzamVar == null) {
            return new HashMap();
        }
        Map mapZzm = zzm(zzamVar);
        if (mapZzm == null) {
            return new HashMap();
        }
        String str = (String) mapZzm.get("&aip");
        if (str != null && this.zzo.contains(str.toLowerCase())) {
            mapZzm.remove("&aip");
        }
        return mapZzm;
    }

    private static final void zzi(Map map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private static final boolean zzj(Map map, String str) {
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(str);
        if (zzamVar == null) {
            return false;
        }
        return zzfu.zzf(zzfu.zzk(zzamVar)).booleanValue();
    }

    private static final Double zzk(Object obj) {
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e3) {
                throw new RuntimeException("Cannot convert the object to Double: ".concat(String.valueOf(e3.getMessage())));
            }
        }
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
        if (obj instanceof Double) {
            return (Double) obj;
        }
        throw new RuntimeException("Cannot convert the object to Double: ".concat(String.valueOf(obj.toString())));
    }

    private static final Integer zzl(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e3) {
                throw new RuntimeException("Cannot convert the object to Integer: ".concat(String.valueOf(e3.getMessage())));
            }
        }
        if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        throw new RuntimeException("Cannot convert the object to Integer: ".concat(String.valueOf(obj.toString())));
    }

    private static final Map zzm(com.google.android.gms.internal.gtm.zzam zzamVar) {
        Object objZzk = zzfu.zzk(zzamVar);
        if (!(objZzk instanceof Map)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) objZzk).entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private static final Product zzn(Map map) {
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.f(obj.toString());
        }
        Object obj2 = map.get("name");
        if (obj2 != null) {
            product.g(obj2.toString());
        }
        Object obj3 = map.get("brand");
        if (obj3 != null) {
            product.a(obj3.toString());
        }
        Object obj4 = map.get("category");
        if (obj4 != null) {
            product.b(obj4.toString());
        }
        Object obj5 = map.get("variant");
        if (obj5 != null) {
            product.k(obj5.toString());
        }
        Object obj6 = map.get("coupon");
        if (obj6 != null) {
            product.c(obj6.toString());
        }
        Object obj7 = map.get("position");
        if (obj7 != null) {
            product.h(zzl(obj7).intValue());
        }
        Object obj8 = map.get("price");
        if (obj8 != null) {
            product.i(zzk(obj8).doubleValue());
        }
        Object obj9 = map.get("quantity");
        if (obj9 != null) {
            product.j(zzl(obj9).intValue());
        }
        for (String str : map.keySet()) {
            Matcher matcher = zzk.matcher(str);
            if (matcher.matches()) {
                try {
                    product.d(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(str)));
                } catch (NumberFormatException unused) {
                    Log.w("GoogleTagManager", "illegal number in custom dimension value: ".concat(String.valueOf(str)));
                }
            } else {
                Matcher matcher2 = zzl.matcher(str);
                if (matcher2.matches()) {
                    try {
                        product.e(Integer.parseInt(matcher2.group(1)), zzl(map.get(str)).intValue());
                    } catch (NumberFormatException unused2) {
                        Log.w("GoogleTagManager", "illegal number in custom metric value: ".concat(String.valueOf(str)));
                    }
                }
            }
        }
        return product;
    }

    @Override // com.google.android.gms.tagmanager.zzfs, com.google.android.gms.tagmanager.zzbt
    public final /* bridge */ /* synthetic */ boolean zzb() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:201:0x0270 A[EDGE_INSN: B:201:0x0270->B:112:0x0270 BREAK  A[LOOP:2: B:63:0x0162->B:203:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004f  */
    @Override // com.google.android.gms.tagmanager.zzfs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzc(java.util.Map r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1063
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzfv.zzc(java.util.Map):void");
    }
}
