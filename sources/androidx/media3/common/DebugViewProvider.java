package androidx.media3.common;

import android.view.SurfaceView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface DebugViewProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DebugViewProvider f40567a = new DebugViewProvider() { // from class: androidx.media3.common.e
        @Override // androidx.media3.common.DebugViewProvider
        public final SurfaceView b(int i3, int i4) {
            return DebugViewProvider.a(i3, i4);
        }
    };

    static /* synthetic */ SurfaceView a(int i3, int i4) {
        return null;
    }

    SurfaceView b(int i3, int i4);
}
