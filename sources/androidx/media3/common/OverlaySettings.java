package androidx.media3.common;

import android.util.Pair;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface OverlaySettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pair f40934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pair f40935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pair f40936c;

    static {
        Float fValueOf = Float.valueOf(0.0f);
        f40934a = Pair.create(fValueOf, fValueOf);
        f40935b = Pair.create(fValueOf, fValueOf);
        Float fValueOf2 = Float.valueOf(1.0f);
        f40936c = Pair.create(fValueOf2, fValueOf2);
    }

    default float a() {
        return 1.0f;
    }

    default float b() {
        return 1.0f;
    }

    default Pair c() {
        return f40934a;
    }

    default float d() {
        return 0.0f;
    }

    default Pair e() {
        return f40935b;
    }

    default Pair getScale() {
        return f40936c;
    }
}
