package androidx.media3.exoplayer.drm;

import android.net.Uri;
import androidx.media3.datasource.DataSpec;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaDrmCallbackException extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataSpec f44083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f44084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f44085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f44086d;

    public MediaDrmCallbackException(DataSpec dataSpec, Uri uri, Map map, long j3, Throwable th) {
        super(th);
        this.f44083a = dataSpec;
        this.f44084b = uri;
        this.f44085c = map;
        this.f44086d = j3;
    }
}
