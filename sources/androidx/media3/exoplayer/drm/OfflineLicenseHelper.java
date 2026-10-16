package androidx.media3.exoplayer.drm;

import android.os.ConditionVariable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.exoplayer.source.MediaSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class OfflineLicenseHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Format f44087b = new Format.Builder().Y(new DrmInitData(new DrmInitData.SchemeData[0])).N();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConditionVariable f44088a;

    /* JADX INFO: renamed from: androidx.media3.exoplayer.drm.OfflineLicenseHelper$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements DrmSessionEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OfflineLicenseHelper f44089a;

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void N(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            this.f44089a.f44088a.open();
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void X(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            this.f44089a.f44088a.open();
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void Y(int i3, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            this.f44089a.f44088a.open();
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
        public void i0(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            this.f44089a.f44088a.open();
        }
    }
}
