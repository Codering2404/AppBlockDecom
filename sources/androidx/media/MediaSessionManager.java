package androidx.media;

import android.util.Log;
import androidx.media.MediaSessionManagerImplApi28;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaSessionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f40460a = Log.isLoggable("MediaSessionManager", 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f40461b = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface MediaSessionManagerImpl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class RemoteUserInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        RemoteUserInfoImpl f40462a;

        public RemoteUserInfo(String str, int i3, int i4) {
            this.f40462a = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(str, i3, i4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfo) {
                return this.f40462a.equals(((RemoteUserInfo) obj).f40462a);
            }
            return false;
        }

        public int hashCode() {
            return this.f40462a.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface RemoteUserInfoImpl {
    }
}
