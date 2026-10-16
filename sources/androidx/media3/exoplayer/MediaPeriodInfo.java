package androidx.media3.exoplayer;

import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.source.MediaSource;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MediaPeriodInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaSource.MediaPeriodId f43160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f43161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f43162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f43163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f43164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f43165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f43166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f43167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f43168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f43169j;

    MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j3, long j4, long j5, long j6, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        boolean z7 = true;
        Assertions.a(!z6 || z4);
        Assertions.a(!z5 || z4);
        if (z3 && (z4 || z5 || z6)) {
            z7 = false;
        }
        Assertions.a(z7);
        this.f43160a = mediaPeriodId;
        this.f43161b = j3;
        this.f43162c = j4;
        this.f43163d = j5;
        this.f43164e = j6;
        this.f43165f = z2;
        this.f43166g = z3;
        this.f43167h = z4;
        this.f43168i = z5;
        this.f43169j = z6;
    }

    public MediaPeriodInfo a(long j3) {
        return j3 == this.f43162c ? this : new MediaPeriodInfo(this.f43160a, this.f43161b, j3, this.f43163d, this.f43164e, this.f43165f, this.f43166g, this.f43167h, this.f43168i, this.f43169j);
    }

    public MediaPeriodInfo b(long j3) {
        return j3 == this.f43161b ? this : new MediaPeriodInfo(this.f43160a, j3, this.f43162c, this.f43163d, this.f43164e, this.f43165f, this.f43166g, this.f43167h, this.f43168i, this.f43169j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MediaPeriodInfo.class == obj.getClass()) {
            MediaPeriodInfo mediaPeriodInfo = (MediaPeriodInfo) obj;
            if (this.f43161b == mediaPeriodInfo.f43161b && this.f43162c == mediaPeriodInfo.f43162c && this.f43163d == mediaPeriodInfo.f43163d && this.f43164e == mediaPeriodInfo.f43164e && this.f43165f == mediaPeriodInfo.f43165f && this.f43166g == mediaPeriodInfo.f43166g && this.f43167h == mediaPeriodInfo.f43167h && this.f43168i == mediaPeriodInfo.f43168i && this.f43169j == mediaPeriodInfo.f43169j && Objects.equals(this.f43160a, mediaPeriodInfo.f43160a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f43160a.hashCode()) * 31) + ((int) this.f43161b)) * 31) + ((int) this.f43162c)) * 31) + ((int) this.f43163d)) * 31) + ((int) this.f43164e)) * 31) + (this.f43165f ? 1 : 0)) * 31) + (this.f43166g ? 1 : 0)) * 31) + (this.f43167h ? 1 : 0)) * 31) + (this.f43168i ? 1 : 0)) * 31) + (this.f43169j ? 1 : 0);
    }
}
