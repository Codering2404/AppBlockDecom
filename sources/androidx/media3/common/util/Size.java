package androidx.media3.common.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Size {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Size f41593c = new Size(-1, -1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Size f41594d = new Size(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f41595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f41596b;

    public Size(int i3, int i4) {
        Assertions.a((i3 == -1 || i3 >= 0) && (i4 == -1 || i4 >= 0));
        this.f41595a = i3;
        this.f41596b = i4;
    }

    public int a() {
        return this.f41596b;
    }

    public int b() {
        return this.f41595a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.f41595a == size.f41595a && this.f41596b == size.f41596b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.f41596b;
        int i4 = this.f41595a;
        return i3 ^ ((i4 >>> 16) | (i4 << 16));
    }

    public String toString() {
        return this.f41595a + "x" + this.f41596b;
    }
}
