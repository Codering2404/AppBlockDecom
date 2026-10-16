package androidx.media3.exoplayer.source;

import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ExternalLoader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class LoadRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f44677a;

        public LoadRequest(Uri uri) {
            this.f44677a = uri;
        }
    }

    ListenableFuture a(LoadRequest loadRequest);
}
