package androidx.media3.exoplayer.trackselection;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackSelectionArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TrackSelection[] f45451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f45452b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionArray.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f45451a, ((TrackSelectionArray) obj).f45451a);
    }

    public int hashCode() {
        if (this.f45452b == 0) {
            this.f45452b = 527 + Arrays.hashCode(this.f45451a);
        }
        return this.f45452b;
    }
}
