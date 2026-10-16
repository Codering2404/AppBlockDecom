package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzwt extends zzwr {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map f78782d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzuj f78783c;

    static {
        EnumMap enumMap = new EnumMap(zzuj.class);
        for (zzuj zzujVar : zzuj.values()) {
            zzwt[] zzwtVarArr = new zzwt[10];
            for (int i3 = 0; i3 < 10; i3++) {
                zzwtVarArr[i3] = new zzwt(i3, zzujVar, zzuk.a());
            }
            enumMap.put(zzujVar, zzwtVarArr);
        }
        f78782d = Collections.unmodifiableMap(enumMap);
    }

    private zzwt(int i3, zzuj zzujVar, zzuk zzukVar) {
        super(zzukVar, i3);
        zzxb.a(zzujVar, "format char");
        this.f78783c = zzujVar;
        if (zzukVar.e()) {
            zzujVar.e();
            return;
        }
        int iB = zzujVar.b();
        iB = zzukVar.k() ? iB & 65503 : iB;
        StringBuilder sb = new StringBuilder("%");
        zzukVar.l(sb);
        sb.append((char) iB);
    }

    public static zzwt e(int i3, zzuj zzujVar, zzuk zzukVar) {
        if (i3 >= 10 || !zzukVar.e()) {
            return new zzwt(i3, zzujVar, zzukVar);
        }
        zzwt[] zzwtVarArr = (zzwt[]) f78782d.get(zzujVar);
        zzxb.a(zzwtVarArr, "default parameter");
        return zzwtVarArr[i3];
    }

    @Override // com.google.android.libraries.places.internal.zzwr
    protected final void a(zzws zzwsVar, Object obj) {
        zzwsVar.b(obj, this.f78783c, c());
    }
}
