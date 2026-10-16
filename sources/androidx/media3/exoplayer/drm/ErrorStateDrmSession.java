package androidx.media3.exoplayer.drm;

import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ErrorStateDrmSession implements DrmSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DrmSession.DrmSessionException f44063a;

    public ErrorStateDrmSession(DrmSession.DrmSessionException drmSessionException) {
        this.f44063a = (DrmSession.DrmSessionException) Assertions.e(drmSessionException);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final UUID a() {
        return C.f40541a;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public boolean b() {
        return false;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public CryptoConfig d() {
        return null;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public Map f() {
        return null;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public DrmSession.DrmSessionException getError() {
        return this.f44063a;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public int getState() {
        return 1;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public boolean h(String str) {
        return false;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public void e(DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public void g(DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }
}
