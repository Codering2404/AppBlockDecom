package androidx.media3.exoplayer.drm;

import android.os.Looper;
import androidx.media3.common.Format;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import com.facebook.ads.AdError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface DrmSessionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DrmSessionManager f44061a = new DrmSessionManager() { // from class: androidx.media3.exoplayer.drm.DrmSessionManager.1
        @Override // androidx.media3.exoplayer.drm.DrmSessionManager
        public DrmSession b(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
            if (format.f40636s == null) {
                return null;
            }
            return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), AdError.MEDIAVIEW_MISSING_ERROR_CODE));
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionManager
        public int c(Format format) {
            return format.f40636s != null ? 1 : 0;
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionManager
        public void a(Looper looper, PlayerId playerId) {
        }
    };

    void a(Looper looper, PlayerId playerId);

    DrmSession b(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    int c(Format format);

    default DrmSessionReference d(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        return DrmSessionReference.f44062a;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface DrmSessionReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DrmSessionReference f44062a = new DrmSessionReference() { // from class: androidx.media3.exoplayer.drm.o
            @Override // androidx.media3.exoplayer.drm.DrmSessionManager.DrmSessionReference
            public final void release() {
                DrmSessionManager.DrmSessionReference.a();
            }
        };

        void release();

        static /* synthetic */ void a() {
        }
    }

    default void e() {
    }

    default void release() {
    }
}
