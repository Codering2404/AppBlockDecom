package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PagerScrollPosition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PagerState f8830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableIntState f8831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableFloatState f8832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f8834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LazyLayoutNearestRangeState f8835f;

    public PagerScrollPosition(int i3, float f3, PagerState pagerState) {
        this.f8830a = pagerState;
        this.f8831b = SnapshotIntStateKt.a(i3);
        this.f8832c = PrimitiveSnapshotStateKt.a(f3);
        this.f8835f = new LazyLayoutNearestRangeState(i3, 30, 100);
    }

    private final void g(int i3) {
        this.f8831b.a(i3);
    }

    private final void h(float f3) {
        this.f8832c.s(f3);
    }

    private final void i(int i3, float f3) {
        g(i3);
        this.f8835f.n(i3);
        h(f3);
    }

    public final void a(int i3) {
        h(c() + (this.f8830a.J() == 0 ? 0.0f : i3 / this.f8830a.J()));
    }

    public final int b() {
        return this.f8831b.g();
    }

    public final float c() {
        return this.f8832c.c();
    }

    public final LazyLayoutNearestRangeState d() {
        return this.f8835f;
    }

    public final int e(PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i3) {
        int iA = LazyLayoutItemProviderKt.a(pagerLazyLayoutItemProvider, this.f8834e, i3);
        if (i3 != iA) {
            g(iA);
            this.f8835f.n(i3);
        }
        return iA;
    }

    public final void f(int i3, float f3) {
        i(i3, f3);
        this.f8834e = null;
    }

    public final void j(float f3) {
        h(f3);
    }

    public final void k(PagerMeasureResult pagerMeasureResult) {
        MeasuredPage measuredPageJ = pagerMeasureResult.j();
        this.f8834e = measuredPageJ != null ? measuredPageJ.c() : null;
        if (this.f8833d || !pagerMeasureResult.y().isEmpty()) {
            this.f8833d = true;
            MeasuredPage measuredPageJ2 = pagerMeasureResult.j();
            i(measuredPageJ2 != null ? measuredPageJ2.getIndex() : 0, pagerMeasureResult.k());
        }
    }
}
