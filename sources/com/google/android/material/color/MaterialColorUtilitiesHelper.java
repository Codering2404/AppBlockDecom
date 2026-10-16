package com.google.android.material.color;

import com.google.android.material.R;
import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MaterialColorUtilitiesHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final MaterialDynamicColors f80587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f80588b;

    static {
        MaterialDynamicColors materialDynamicColors = new MaterialDynamicColors();
        f80587a = materialDynamicColors;
        HashMap map = new HashMap();
        map.put(Integer.valueOf(R.color.f79553z), materialDynamicColors.B1());
        map.put(Integer.valueOf(R.color.f79542o), materialDynamicColors.q1());
        map.put(Integer.valueOf(R.color.B), materialDynamicColors.j1());
        map.put(Integer.valueOf(R.color.A), materialDynamicColors.C1());
        map.put(Integer.valueOf(R.color.f79543p), materialDynamicColors.r1());
        map.put(Integer.valueOf(R.color.C), materialDynamicColors.D1());
        map.put(Integer.valueOf(R.color.f79544q), materialDynamicColors.s1());
        map.put(Integer.valueOf(R.color.D), materialDynamicColors.E1());
        map.put(Integer.valueOf(R.color.f79545r), materialDynamicColors.t1());
        map.put(Integer.valueOf(R.color.O), materialDynamicColors.O1());
        map.put(Integer.valueOf(R.color.f79549v), materialDynamicColors.w1());
        map.put(Integer.valueOf(R.color.P), materialDynamicColors.P1());
        map.put(Integer.valueOf(R.color.f79550w), materialDynamicColors.x1());
        map.put(Integer.valueOf(R.color.f79533f), materialDynamicColors.a1());
        map.put(Integer.valueOf(R.color.f79539l), materialDynamicColors.n1());
        map.put(Integer.valueOf(R.color.E), materialDynamicColors.F1());
        map.put(Integer.valueOf(R.color.f79546s), materialDynamicColors.u1());
        map.put(Integer.valueOf(R.color.N), materialDynamicColors.N1());
        map.put(Integer.valueOf(R.color.f79548u), materialDynamicColors.v1());
        map.put(Integer.valueOf(R.color.M), materialDynamicColors.k1());
        map.put(Integer.valueOf(R.color.f79547t), materialDynamicColors.i1());
        map.put(Integer.valueOf(R.color.F), materialDynamicColors.G1());
        map.put(Integer.valueOf(R.color.L), materialDynamicColors.M1());
        map.put(Integer.valueOf(R.color.G), materialDynamicColors.H1());
        map.put(Integer.valueOf(R.color.J), materialDynamicColors.K1());
        map.put(Integer.valueOf(R.color.H), materialDynamicColors.I1());
        map.put(Integer.valueOf(R.color.K), materialDynamicColors.L1());
        map.put(Integer.valueOf(R.color.I), materialDynamicColors.J1());
        map.put(Integer.valueOf(R.color.f79551x), materialDynamicColors.y1());
        map.put(Integer.valueOf(R.color.f79552y), materialDynamicColors.z1());
        map.put(Integer.valueOf(R.color.f79537j), materialDynamicColors.e1());
        map.put(Integer.valueOf(R.color.f79540m), materialDynamicColors.o1());
        map.put(Integer.valueOf(R.color.f79538k), materialDynamicColors.f1());
        map.put(Integer.valueOf(R.color.f79541n), materialDynamicColors.p1());
        map.put(Integer.valueOf(R.color.f79534g), materialDynamicColors.b1());
        map.put(Integer.valueOf(R.color.f79536i), materialDynamicColors.d1());
        map.put(Integer.valueOf(R.color.f79535h), materialDynamicColors.c1());
        map.put(Integer.valueOf(R.color.R), materialDynamicColors.R1());
        map.put(Integer.valueOf(R.color.T), materialDynamicColors.T1());
        map.put(Integer.valueOf(R.color.U), materialDynamicColors.U1());
        map.put(Integer.valueOf(R.color.S), materialDynamicColors.S1());
        map.put(Integer.valueOf(R.color.Q), materialDynamicColors.Q1());
        f80588b = Collections.unmodifiableMap(map);
    }

    public static Map a(DynamicScheme dynamicScheme) {
        HashMap map = new HashMap();
        for (Map.Entry entry : f80588b.entrySet()) {
            map.put((Integer) entry.getKey(), Integer.valueOf(((DynamicColor) entry.getValue()).d(dynamicScheme)));
        }
        return Collections.unmodifiableMap(map);
    }
}
