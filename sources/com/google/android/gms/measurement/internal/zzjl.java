package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjl {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzjl f74015c = new zzjl(null, null, 100);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnumMap f74016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f74017b;

    public zzjl(Boolean bool, Boolean bool2, int i3) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        this.f74016a = enumMap;
        enumMap.put(zzjk.AD_STORAGE, h(null));
        enumMap.put(zzjk.ANALYTICS_STORAGE, h(null));
        this.f74017b = i3;
    }

    public static zzjl a(zzji zzjiVar, zzji zzjiVar2, int i3) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        enumMap.put(zzjk.AD_STORAGE, zzjiVar);
        enumMap.put(zzjk.ANALYTICS_STORAGE, zzjiVar2);
        return new zzjl(enumMap, -10);
    }

    static String d(int i3) {
        return i3 != -30 ? i3 != -20 ? i3 != -10 ? i3 != 0 ? i3 != 30 ? i3 != 90 ? i3 != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static zzjl e(Bundle bundle, int i3) {
        if (bundle == null) {
            return new zzjl(null, null, i3);
        }
        EnumMap enumMap = new EnumMap(zzjk.class);
        for (zzjk zzjkVar : zzjj.STORAGE.b()) {
            enumMap.put(zzjkVar, g(bundle.getString(zzjkVar.f74014a)));
        }
        return new zzjl(enumMap, i3);
    }

    public static zzjl f(String str, int i3) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        zzjk[] zzjkVarArrA = zzjj.STORAGE.a();
        for (int i4 = 0; i4 < zzjkVarArrA.length; i4++) {
            String str2 = str == null ? "" : str;
            zzjk zzjkVar = zzjkVarArrA[i4];
            int i5 = i4 + 2;
            if (i5 < str2.length()) {
                enumMap.put(zzjkVar, j(str2.charAt(i5)));
            } else {
                enumMap.put(zzjkVar, zzji.UNINITIALIZED);
            }
        }
        return new zzjl(enumMap, i3);
    }

    static zzji g(String str) {
        return str == null ? zzji.UNINITIALIZED : str.equals("granted") ? zzji.GRANTED : str.equals("denied") ? zzji.DENIED : zzji.UNINITIALIZED;
    }

    static zzji h(Boolean bool) {
        return bool == null ? zzji.UNINITIALIZED : bool.booleanValue() ? zzji.GRANTED : zzji.DENIED;
    }

    static String i(zzji zzjiVar) {
        int iOrdinal = zzjiVar.ordinal();
        if (iOrdinal == 2) {
            return "denied";
        }
        if (iOrdinal != 3) {
            return null;
        }
        return "granted";
    }

    static zzji j(char c3) {
        return c3 != '+' ? c3 != '0' ? c3 != '1' ? zzji.UNINITIALIZED : zzji.GRANTED : zzji.DENIED : zzji.POLICY;
    }

    static char m(zzji zzjiVar) {
        if (zzjiVar == null) {
            return '-';
        }
        int iOrdinal = zzjiVar.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public static boolean u(int i3, int i4) {
        int i5 = -30;
        if (i3 == -20) {
            if (i4 == -30) {
                return true;
            }
            i3 = -20;
        }
        if (i3 != -30) {
            i5 = i3;
        } else if (i4 == -20) {
            return true;
        }
        return i5 == i4 || i3 < i4;
    }

    public final int b() {
        return this.f74017b;
    }

    public final boolean c() {
        Iterator it = this.f74016a.values().iterator();
        while (it.hasNext()) {
            if (((zzji) it.next()) != zzji.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjl)) {
            return false;
        }
        zzjl zzjlVar = (zzjl) obj;
        for (zzjk zzjkVar : zzjj.STORAGE.b()) {
            if (this.f74016a.get(zzjkVar) != zzjlVar.f74016a.get(zzjkVar)) {
                return false;
            }
        }
        return this.f74017b == zzjlVar.f74017b;
    }

    public final int hashCode() {
        Iterator it = this.f74016a.values().iterator();
        int iHashCode = this.f74017b * 17;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + ((zzji) it.next()).hashCode();
        }
        return iHashCode;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String k() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "G1"
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzjj r1 = com.google.android.gms.measurement.internal.zzjj.STORAGE
            com.google.android.gms.measurement.internal.zzjk[] r1 = r1.a()
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L3a
            r4 = r1[r3]
            java.util.EnumMap r5 = r7.f74016a
            java.lang.Object r4 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzji r4 = (com.google.android.gms.measurement.internal.zzji) r4
            r5 = 45
            if (r4 == 0) goto L34
            int r4 = r4.ordinal()
            if (r4 == 0) goto L34
            r6 = 1
            if (r4 == r6) goto L32
            r6 = 2
            if (r4 == r6) goto L2f
            r6 = 3
            if (r4 == r6) goto L32
            goto L34
        L2f:
            r5 = 48
            goto L34
        L32:
            r5 = 49
        L34:
            r0.append(r5)
            int r3 = r3 + 1
            goto Lf
        L3a:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjl.k():java.lang.String");
    }

    public final String l() {
        StringBuilder sb = new StringBuilder("G1");
        for (zzjk zzjkVar : zzjj.STORAGE.a()) {
            sb.append(m((zzji) this.f74016a.get(zzjkVar)));
        }
        return sb.toString();
    }

    public final Bundle n() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f74016a.entrySet()) {
            String strI = i((zzji) entry.getValue());
            if (strI != null) {
                bundle.putString(((zzjk) entry.getKey()).f74014a, strI);
            }
        }
        return bundle;
    }

    public final boolean o(zzjk zzjkVar) {
        return ((zzji) this.f74016a.get(zzjkVar)) != zzji.DENIED;
    }

    public final zzji p() {
        zzji zzjiVar = (zzji) this.f74016a.get(zzjk.AD_STORAGE);
        return zzjiVar == null ? zzji.UNINITIALIZED : zzjiVar;
    }

    public final zzji q() {
        zzji zzjiVar = (zzji) this.f74016a.get(zzjk.ANALYTICS_STORAGE);
        return zzjiVar == null ? zzji.UNINITIALIZED : zzjiVar;
    }

    public final boolean r(zzjl zzjlVar) {
        EnumMap enumMap = this.f74016a;
        for (zzjk zzjkVar : (zzjk[]) enumMap.keySet().toArray(new zzjk[0])) {
            zzji zzjiVar = (zzji) enumMap.get(zzjkVar);
            zzji zzjiVar2 = (zzji) zzjlVar.f74016a.get(zzjkVar);
            zzji zzjiVar3 = zzji.DENIED;
            if (zzjiVar == zzjiVar3 && zzjiVar2 != zzjiVar3) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzjl s(com.google.android.gms.measurement.internal.zzjl r9) {
        /*
            r8 = this;
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<com.google.android.gms.measurement.internal.zzjk> r1 = com.google.android.gms.measurement.internal.zzjk.class
            r0.<init>(r1)
            com.google.android.gms.measurement.internal.zzjj r1 = com.google.android.gms.measurement.internal.zzjj.STORAGE
            com.google.android.gms.measurement.internal.zzjk[] r1 = r1.b()
            int r2 = r1.length
            r3 = 0
        Lf:
            if (r3 >= r2) goto L4a
            r4 = r1[r3]
            java.util.EnumMap r5 = r8.f74016a
            java.lang.Object r5 = r5.get(r4)
            com.google.android.gms.measurement.internal.zzji r5 = (com.google.android.gms.measurement.internal.zzji) r5
            java.util.EnumMap r6 = r9.f74016a
            java.lang.Object r6 = r6.get(r4)
            com.google.android.gms.measurement.internal.zzji r6 = (com.google.android.gms.measurement.internal.zzji) r6
            if (r5 != 0) goto L26
            goto L33
        L26:
            if (r6 == 0) goto L42
            com.google.android.gms.measurement.internal.zzji r7 = com.google.android.gms.measurement.internal.zzji.UNINITIALIZED
            if (r5 != r7) goto L2d
            goto L33
        L2d:
            if (r6 == r7) goto L42
            com.google.android.gms.measurement.internal.zzji r7 = com.google.android.gms.measurement.internal.zzji.POLICY
            if (r5 != r7) goto L35
        L33:
            r5 = r6
            goto L42
        L35:
            if (r6 == r7) goto L42
            com.google.android.gms.measurement.internal.zzji r7 = com.google.android.gms.measurement.internal.zzji.DENIED
            if (r5 == r7) goto L41
            if (r6 != r7) goto L3e
            goto L41
        L3e:
            com.google.android.gms.measurement.internal.zzji r5 = com.google.android.gms.measurement.internal.zzji.GRANTED
            goto L42
        L41:
            r5 = r7
        L42:
            if (r5 == 0) goto L47
            r0.put(r4, r5)
        L47:
            int r3 = r3 + 1
            goto Lf
        L4a:
            com.google.android.gms.measurement.internal.zzjl r9 = new com.google.android.gms.measurement.internal.zzjl
            r1 = 100
            r9.<init>(r0, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjl.s(com.google.android.gms.measurement.internal.zzjl):com.google.android.gms.measurement.internal.zzjl");
    }

    public final zzjl t(zzjl zzjlVar) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        for (zzjk zzjkVar : zzjj.STORAGE.b()) {
            zzji zzjiVar = (zzji) this.f74016a.get(zzjkVar);
            if (zzjiVar == zzji.UNINITIALIZED) {
                zzjiVar = (zzji) zzjlVar.f74016a.get(zzjkVar);
            }
            if (zzjiVar != null) {
                enumMap.put(zzjkVar, zzjiVar);
            }
        }
        return new zzjl(enumMap, this.f74017b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(d(this.f74017b));
        for (zzjk zzjkVar : zzjj.STORAGE.b()) {
            sb.append(",");
            sb.append(zzjkVar.f74014a);
            sb.append("=");
            zzji zzjiVar = (zzji) this.f74016a.get(zzjkVar);
            if (zzjiVar == null) {
                zzjiVar = zzji.UNINITIALIZED;
            }
            sb.append(zzjiVar);
        }
        return sb.toString();
    }

    private zzjl(EnumMap enumMap, int i3) {
        EnumMap enumMap2 = new EnumMap(zzjk.class);
        this.f74016a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f74017b = i3;
    }
}
