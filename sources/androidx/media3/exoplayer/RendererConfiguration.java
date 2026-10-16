package androidx.media3.exoplayer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class RendererConfiguration {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RendererConfiguration f43287c = new RendererConfiguration(0, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f43289b;

    public RendererConfiguration(int i3, boolean z2) {
        this.f43288a = i3;
        this.f43289b = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && RendererConfiguration.class == obj.getClass()) {
            RendererConfiguration rendererConfiguration = (RendererConfiguration) obj;
            if (this.f43288a == rendererConfiguration.f43288a && this.f43289b == rendererConfiguration.f43289b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f43288a << 1) + (this.f43289b ? 1 : 0);
    }
}
