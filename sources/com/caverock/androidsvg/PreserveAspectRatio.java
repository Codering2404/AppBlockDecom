package com.caverock.androidsvg;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PreserveAspectRatio {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PreserveAspectRatio f67393c = new PreserveAspectRatio(null, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PreserveAspectRatio f67394d = new PreserveAspectRatio(Alignment.none, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final PreserveAspectRatio f67395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final PreserveAspectRatio f67396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final PreserveAspectRatio f67397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PreserveAspectRatio f67398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final PreserveAspectRatio f67399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final PreserveAspectRatio f67400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PreserveAspectRatio f67401k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Alignment f67402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Scale f67403b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Alignment {
        none,
        xMinYMin,
        xMidYMin,
        xMaxYMin,
        xMinYMid,
        xMidYMid,
        xMaxYMid,
        xMinYMax,
        xMidYMax,
        xMaxYMax
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Scale {
        meet,
        slice
    }

    static {
        Alignment alignment = Alignment.xMidYMid;
        Scale scale = Scale.meet;
        f67395e = new PreserveAspectRatio(alignment, scale);
        Alignment alignment2 = Alignment.xMinYMin;
        f67396f = new PreserveAspectRatio(alignment2, scale);
        f67397g = new PreserveAspectRatio(Alignment.xMaxYMax, scale);
        f67398h = new PreserveAspectRatio(Alignment.xMidYMin, scale);
        f67399i = new PreserveAspectRatio(Alignment.xMidYMax, scale);
        Scale scale2 = Scale.slice;
        f67400j = new PreserveAspectRatio(alignment, scale2);
        f67401k = new PreserveAspectRatio(alignment2, scale2);
    }

    PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.f67402a = alignment;
        this.f67403b = scale;
    }

    public Alignment a() {
        return this.f67402a;
    }

    public Scale b() {
        return this.f67403b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
        return this.f67402a == preserveAspectRatio.f67402a && this.f67403b == preserveAspectRatio.f67403b;
    }

    public String toString() {
        return this.f67402a + " " + this.f67403b;
    }
}
