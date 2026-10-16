package androidx.media3.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class IllegalSeekPositionException extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Timeline f40699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f40700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f40701c;

    public IllegalSeekPositionException(Timeline timeline, int i3, long j3) {
        this.f40699a = timeline;
        this.f40700b = i3;
        this.f40701c = j3;
    }
}
