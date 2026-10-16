package androidx.media3.common;

import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class VideoSize {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final VideoSize f41254e = new VideoSize(0, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f41255f = Util.y0(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f41256g = Util.y0(1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f41257h = Util.y0(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f41259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f41261d;

    public VideoSize(int i3, int i4) {
        this(i3, i4, 1.0f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoSize) {
            VideoSize videoSize = (VideoSize) obj;
            if (this.f41258a == videoSize.f41258a && this.f41259b == videoSize.f41259b && this.f41261d == videoSize.f41261d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((217 + this.f41258a) * 31) + this.f41259b) * 31) + Float.floatToRawIntBits(this.f41261d);
    }

    public VideoSize(int i3, int i4, float f3) {
        this.f41258a = i3;
        this.f41259b = i4;
        this.f41260c = 0;
        this.f41261d = f3;
    }
}
