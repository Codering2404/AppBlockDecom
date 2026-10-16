package androidx.media3.common;

import androidx.media3.common.util.Size;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface VideoCompositorSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final VideoCompositorSettings f41251a = new VideoCompositorSettings() { // from class: androidx.media3.common.VideoCompositorSettings.1
        @Override // androidx.media3.common.VideoCompositorSettings
        public OverlaySettings a(int i3, long j3) {
            return new OverlaySettings() { // from class: androidx.media3.common.VideoCompositorSettings.1.1
            };
        }

        @Override // androidx.media3.common.VideoCompositorSettings
        public Size b(List list) {
            return (Size) list.get(0);
        }
    };

    OverlaySettings a(int i3, long j3);

    Size b(List list);
}
