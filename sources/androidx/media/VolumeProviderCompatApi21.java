package androidx.media;

import android.media.VolumeProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class VolumeProviderCompatApi21 {

    /* JADX INFO: renamed from: androidx.media.VolumeProviderCompatApi21$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class AnonymousClass1 extends VolumeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Delegate f40477a;

        @Override // android.media.VolumeProvider
        public void onAdjustVolume(int i3) {
            this.f40477a.b(i3);
        }

        @Override // android.media.VolumeProvider
        public void onSetVolumeTo(int i3) {
            this.f40477a.a(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Delegate {
        void a(int i3);

        void b(int i3);
    }
}
