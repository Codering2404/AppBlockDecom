package androidx.media3.exoplayer;

import androidx.media3.exoplayer.StreamVolumeManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StreamVolumeManager.VolumeChangeReceiver f44524a;

    @Override // java.lang.Runnable
    public final void run() {
        StreamVolumeManager.VolumeChangeReceiver.a(this.f44524a);
    }
}
