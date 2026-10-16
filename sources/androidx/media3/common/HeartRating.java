package androidx.media3.common;

import androidx.media3.common.util.Util;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class HeartRating extends Rating {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f40695d = Util.y0(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f40696e = Util.y0(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f40697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f40698c;

    public boolean equals(Object obj) {
        if (!(obj instanceof HeartRating)) {
            return false;
        }
        HeartRating heartRating = (HeartRating) obj;
        return this.f40698c == heartRating.f40698c && this.f40697b == heartRating.f40697b;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f40697b), Boolean.valueOf(this.f40698c));
    }
}
