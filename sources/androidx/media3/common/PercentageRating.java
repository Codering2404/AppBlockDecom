package androidx.media3.common;

import androidx.media3.common.util.Util;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PercentageRating extends Rating {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f40939c = Util.y0(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f40940b;

    public boolean equals(Object obj) {
        return (obj instanceof PercentageRating) && this.f40940b == ((PercentageRating) obj).f40940b;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.f40940b));
    }
}
