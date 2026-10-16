package androidx.media3.extractor.mp4;

import androidx.media3.extractor.SniffFailure;
import com.google.common.primitives.ImmutableIntArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class UnsupportedBrandsSniffFailure implements SniffFailure {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f46862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImmutableIntArray f46863b;

    public UnsupportedBrandsSniffFailure(int i3, int[] iArr) {
        this.f46862a = i3;
        this.f46863b = iArr != null ? ImmutableIntArray.d(iArr) : ImmutableIntArray.k();
    }
}
