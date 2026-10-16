package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RemoteUserInfoImplApi28 implements MediaSessionManager.RemoteUserInfoImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MediaSessionManager.RemoteUserInfo f40463a;

        RemoteUserInfoImplApi28(String str, int i3, int i4) {
            this.f40463a = new MediaSessionManager.RemoteUserInfo(str, i3, i4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfoImplApi28) {
                return this.f40463a.equals(((RemoteUserInfoImplApi28) obj).f40463a);
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.b(this.f40463a);
        }
    }
}
