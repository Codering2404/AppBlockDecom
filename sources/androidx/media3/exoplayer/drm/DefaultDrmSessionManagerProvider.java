package androidx.media3.exoplayer.drm;

import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultDrmSessionManagerProvider implements DrmSessionManagerProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f44049a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MediaItem.DrmConfiguration f44050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DrmSessionManager f44051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DataSource.Factory f44052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f44053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LoadErrorHandlingPolicy f44054f;

    private DrmSessionManager b(MediaItem.DrmConfiguration drmConfiguration) {
        DataSource.Factory factoryF = this.f44052d;
        if (factoryF == null) {
            factoryF = new DefaultHttpDataSource.Factory().f(this.f44053e);
        }
        Uri uri = drmConfiguration.f40769c;
        HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(uri == null ? null : uri.toString(), drmConfiguration.f40774h, factoryF);
        UnmodifiableIterator it = drmConfiguration.f40771e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            httpMediaDrmCallback.c((String) entry.getKey(), (String) entry.getValue());
        }
        DefaultDrmSessionManager.Builder builderE = new DefaultDrmSessionManager.Builder().f(drmConfiguration.f40767a, FrameworkMediaDrm.f44074d).c(drmConfiguration.f40772f).d(drmConfiguration.f40773g).e(Ints.n(drmConfiguration.f40776j));
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f44054f;
        if (loadErrorHandlingPolicy != null) {
            builderE.b(loadErrorHandlingPolicy);
        }
        DefaultDrmSessionManager defaultDrmSessionManagerA = builderE.a(httpMediaDrmCallback);
        defaultDrmSessionManagerA.F(0, drmConfiguration.c());
        return defaultDrmSessionManagerA;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManagerProvider
    public DrmSessionManager a(MediaItem mediaItem) {
        DrmSessionManager drmSessionManager;
        Assertions.e(mediaItem.f40714b);
        MediaItem.DrmConfiguration drmConfiguration = mediaItem.f40714b.f40812c;
        if (drmConfiguration == null) {
            return DrmSessionManager.f44061a;
        }
        synchronized (this.f44049a) {
            try {
                if (!drmConfiguration.equals(this.f44050b)) {
                    this.f44050b = drmConfiguration;
                    this.f44051c = b(drmConfiguration);
                }
                drmSessionManager = (DrmSessionManager) Assertions.e(this.f44051c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return drmSessionManager;
    }
}
