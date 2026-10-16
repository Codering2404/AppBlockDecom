package androidx.media3.effect;

import android.util.Pair;
import androidx.media3.common.OverlaySettings;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class StaticOverlaySettings implements OverlaySettings {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f42622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Pair f42623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Pair f42624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Pair f42625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f42626h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f42627i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    @Override // androidx.media3.common.OverlaySettings
    public float a() {
        return this.f42627i;
    }

    @Override // androidx.media3.common.OverlaySettings
    public float b() {
        return this.f42622d;
    }

    @Override // androidx.media3.common.OverlaySettings
    public Pair c() {
        return this.f42623e;
    }

    @Override // androidx.media3.common.OverlaySettings
    public float d() {
        return this.f42626h;
    }

    @Override // androidx.media3.common.OverlaySettings
    public Pair e() {
        return this.f42624f;
    }

    @Override // androidx.media3.common.OverlaySettings
    public Pair getScale() {
        return this.f42625g;
    }
}
