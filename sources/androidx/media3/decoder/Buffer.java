package androidx.media3.decoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Buffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f42123a;

    public final void e(int i3) {
        this.f42123a = i3 | this.f42123a;
    }

    public void f() {
        this.f42123a = 0;
    }

    protected final boolean g(int i3) {
        return (this.f42123a & i3) == i3;
    }

    public final boolean h() {
        return g(268435456);
    }

    public final boolean i() {
        return g(4);
    }

    public final boolean j() {
        return g(134217728);
    }

    public final boolean k() {
        return g(1);
    }

    public final boolean l() {
        return g(536870912);
    }

    public final boolean m() {
        return g(67108864);
    }

    public final void n(int i3) {
        this.f42123a = i3;
    }
}
