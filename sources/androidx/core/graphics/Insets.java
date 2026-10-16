package androidx.core.graphics;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Insets {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Insets f33963e = new Insets(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f33964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f33965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33967d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static android.graphics.Insets a(int i3, int i4, int i5, int i6) {
            return android.graphics.Insets.of(i3, i4, i5, i6);
        }
    }

    private Insets(int i3, int i4, int i5, int i6) {
        this.f33964a = i3;
        this.f33965b = i4;
        this.f33966c = i5;
        this.f33967d = i6;
    }

    public static Insets a(Insets insets, Insets insets2) {
        return b(Math.max(insets.f33964a, insets2.f33964a), Math.max(insets.f33965b, insets2.f33965b), Math.max(insets.f33966c, insets2.f33966c), Math.max(insets.f33967d, insets2.f33967d));
    }

    public static Insets b(int i3, int i4, int i5, int i6) {
        return (i3 == 0 && i4 == 0 && i5 == 0 && i6 == 0) ? f33963e : new Insets(i3, i4, i5, i6);
    }

    public static Insets c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static Insets d(android.graphics.Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public android.graphics.Insets e() {
        return Api29Impl.a(this.f33964a, this.f33965b, this.f33966c, this.f33967d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Insets.class != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        return this.f33967d == insets.f33967d && this.f33964a == insets.f33964a && this.f33966c == insets.f33966c && this.f33965b == insets.f33965b;
    }

    public int hashCode() {
        return (((((this.f33964a * 31) + this.f33965b) * 31) + this.f33966c) * 31) + this.f33967d;
    }

    public String toString() {
        return "Insets{left=" + this.f33964a + ", top=" + this.f33965b + ", right=" + this.f33966c + ", bottom=" + this.f33967d + '}';
    }
}
