package androidx.media3.effect;

import androidx.media3.common.OverlaySettings;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TextureOverlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float[] f42640a = GlUtil.h();

    public OverlaySettings b(long j3) {
        return new OverlaySettings() { // from class: androidx.media3.effect.TextureOverlay.1
        };
    }

    public abstract int c(long j3);

    public abstract Size d(long j3);

    public float[] e(long j3) {
        return f42640a;
    }

    public void f() {
    }

    public void a(Size size) {
    }
}
