package androidx.media3.effect;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ThumbnailStripEffect implements GlEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f42646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f42647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f42648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f42649d;

    public int k() {
        return this.f42649d;
    }

    public long l() {
        if (n()) {
            return Long.MIN_VALUE;
        }
        return ((Long) this.f42648c.get(this.f42649d)).longValue();
    }

    public int m() {
        return this.f42648c.size();
    }

    public boolean n() {
        return this.f42649d >= this.f42648c.size();
    }

    void o() {
        this.f42649d++;
    }

    @Override // androidx.media3.effect.GlEffect
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public ThumbnailStripShaderProgram a(Context context, boolean z2) {
        return new ThumbnailStripShaderProgram(context, z2, this);
    }
}
