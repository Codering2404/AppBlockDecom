package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.revenuecat.purchases.common.Constants;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaz {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzaz f73453f = new zzaz((Boolean) null, 100, (Boolean) null, (String) null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f73454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f73455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Boolean f73456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f73457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EnumMap f73458e;

    zzaz(Boolean bool, int i3, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        this.f73458e = enumMap;
        enumMap.put(zzjk.AD_USER_DATA, zzjl.h(bool));
        this.f73454a = i3;
        this.f73455b = l();
        this.f73456c = bool2;
        this.f73457d = str;
    }

    static zzaz a(zzji zzjiVar, int i3) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        enumMap.put(zzjk.AD_USER_DATA, zzjiVar);
        return new zzaz(enumMap, -10, (Boolean) null, (String) null);
    }

    public static zzaz g(String str) {
        if (str == null || str.length() <= 0) {
            return f73453f;
        }
        String[] strArrSplit = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        int i3 = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(zzjk.class);
        zzjk[] zzjkVarArrA = zzjj.DMA.a();
        int length = zzjkVarArrA.length;
        int i4 = 1;
        int i5 = 0;
        while (i5 < length) {
            enumMap.put(zzjkVarArrA[i5], zzjl.j(strArrSplit[i4].charAt(0)));
            i5++;
            i4++;
        }
        return new zzaz(enumMap, i3, (Boolean) null, (String) null);
    }

    public static zzaz h(Bundle bundle, int i3) {
        if (bundle == null) {
            return new zzaz((Boolean) null, i3, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(zzjk.class);
        for (zzjk zzjkVar : zzjj.DMA.a()) {
            enumMap.put(zzjkVar, zzjl.g(bundle.getString(zzjkVar.f74014a)));
        }
        return new zzaz(enumMap, i3, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public static Boolean i(Bundle bundle) {
        zzji zzjiVarG;
        if (bundle == null || (zzjiVarG = zzjl.g(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int iOrdinal = zzjiVarG.ordinal();
        if (iOrdinal == 2) {
            return Boolean.FALSE;
        }
        if (iOrdinal != 3) {
            return null;
        }
        return Boolean.TRUE;
    }

    private final String l() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f73454a);
        for (zzjk zzjkVar : zzjj.DMA.a()) {
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(zzjl.m((zzji) this.f73458e.get(zzjkVar)));
        }
        return sb.toString();
    }

    public final int b() {
        return this.f73454a;
    }

    public final zzji c() {
        zzji zzjiVar = (zzji) this.f73458e.get(zzjk.AD_USER_DATA);
        return zzjiVar == null ? zzji.UNINITIALIZED : zzjiVar;
    }

    public final boolean d() {
        Iterator it = this.f73458e.values().iterator();
        while (it.hasNext()) {
            if (((zzji) it.next()) != zzji.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String e() {
        return this.f73455b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaz)) {
            return false;
        }
        zzaz zzazVar = (zzaz) obj;
        if (this.f73455b.equalsIgnoreCase(zzazVar.f73455b) && Objects.equals(this.f73456c, zzazVar.f73456c)) {
            return Objects.equals(this.f73457d, zzazVar.f73457d);
        }
        return false;
    }

    public final Bundle f() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f73458e.entrySet()) {
            String strI = zzjl.i((zzji) entry.getValue());
            if (strI != null) {
                bundle.putString(((zzjk) entry.getKey()).f74014a, strI);
            }
        }
        Boolean bool = this.f73456c;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.f73457d;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final int hashCode() {
        Boolean bool = this.f73456c;
        int i3 = bool == null ? 3 : true != bool.booleanValue() ? 13 : 7;
        String str = this.f73457d;
        return this.f73455b.hashCode() + (i3 * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    public final Boolean j() {
        return this.f73456c;
    }

    public final String k() {
        return this.f73457d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzjl.d(this.f73454a));
        for (zzjk zzjkVar : zzjj.DMA.a()) {
            sb.append(",");
            sb.append(zzjkVar.f74014a);
            sb.append("=");
            zzji zzjiVar = (zzji) this.f73458e.get(zzjkVar);
            if (zzjiVar == null) {
                sb.append("uninitialized");
            } else {
                int iOrdinal = zzjiVar.ordinal();
                if (iOrdinal == 0) {
                    sb.append("uninitialized");
                } else if (iOrdinal == 1) {
                    sb.append("eu_consent_policy");
                } else if (iOrdinal == 2) {
                    sb.append("denied");
                } else if (iOrdinal == 3) {
                    sb.append("granted");
                }
            }
        }
        Boolean bool = this.f73456c;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.f73457d;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    private zzaz(EnumMap enumMap, int i3, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(zzjk.class);
        this.f73458e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f73454a = i3;
        this.f73455b = l();
        this.f73456c = bool;
        this.f73457d = str;
    }
}
