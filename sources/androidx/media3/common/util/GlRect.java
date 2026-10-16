package androidx.media3.common.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class GlRect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f41534d;

    public GlRect(int i3, int i4) {
        this(0, 0, i3, i4);
    }

    public GlRect(int i3, int i4, int i5, int i6) {
        Assertions.a(i3 <= i5 && i4 <= i6);
        this.f41531a = i3;
        this.f41532b = i4;
        this.f41533c = i5;
        this.f41534d = i6;
    }
}
