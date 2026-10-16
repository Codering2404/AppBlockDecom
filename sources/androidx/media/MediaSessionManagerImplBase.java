package androidx.media;

import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class MediaSessionManagerImplBase implements MediaSessionManager.MediaSessionManagerImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f40464a = MediaSessionManager.f40460a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RemoteUserInfoImplBase implements MediaSessionManager.RemoteUserInfoImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f40465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f40466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f40467c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfoImplBase)) {
                return false;
            }
            RemoteUserInfoImplBase remoteUserInfoImplBase = (RemoteUserInfoImplBase) obj;
            return TextUtils.equals(this.f40465a, remoteUserInfoImplBase.f40465a) && this.f40466b == remoteUserInfoImplBase.f40466b && this.f40467c == remoteUserInfoImplBase.f40467c;
        }

        public int hashCode() {
            return ObjectsCompat.b(this.f40465a, Integer.valueOf(this.f40466b), Integer.valueOf(this.f40467c));
        }
    }
}
