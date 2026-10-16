package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

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
public final class LazyGridScrollPosition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableIntState f7879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableIntState f7880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f7882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LazyLayoutNearestRangeState f7883e;

    public LazyGridScrollPosition(int i3, int i4) {
        this.f7879a = SnapshotIntStateKt.a(i3);
        this.f7880b = SnapshotIntStateKt.a(i4);
        this.f7883e = new LazyLayoutNearestRangeState(i3, 90, 200);
    }

    private final void e(int i3) {
        this.f7879a.a(i3);
    }

    private final void f(int i3) {
        this.f7880b.a(i3);
    }

    private final void g(int i3, int i4) {
        if (!(((float) i3) >= 0.0f)) {
            InlineClassHelperKt.a("Index should be non-negative");
        }
        e(i3);
        this.f7883e.n(i3);
        f(i4);
    }

    public final int a() {
        return this.f7879a.g();
    }

    public final LazyLayoutNearestRangeState b() {
        return this.f7883e;
    }

    public final int c() {
        return this.f7880b.g();
    }

    public final void d(int i3, int i4) {
        g(i3, i4);
        this.f7882d = null;
    }

    public final void h(LazyGridMeasureResult lazyGridMeasureResult) {
        LazyGridMeasuredItem[] lazyGridMeasuredItemArrB;
        LazyGridMeasuredItem lazyGridMeasuredItem;
        LazyGridMeasuredItem[] lazyGridMeasuredItemArrB2;
        LazyGridMeasuredItem lazyGridMeasuredItem2;
        LazyGridMeasuredLine lazyGridMeasuredLineO = lazyGridMeasureResult.o();
        this.f7882d = (lazyGridMeasuredLineO == null || (lazyGridMeasuredItemArrB2 = lazyGridMeasuredLineO.b()) == null || (lazyGridMeasuredItem2 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(lazyGridMeasuredItemArrB2)) == null) ? null : lazyGridMeasuredItem2.getKey();
        if (this.f7881c || lazyGridMeasureResult.e() > 0) {
            this.f7881c = true;
            int iP = lazyGridMeasureResult.p();
            int index = 0;
            if (!(((float) iP) >= 0.0f)) {
                InlineClassHelperKt.c("scrollOffset should be non-negative (" + iP + ')');
            }
            LazyGridMeasuredLine lazyGridMeasuredLineO2 = lazyGridMeasureResult.o();
            if (lazyGridMeasuredLineO2 != null && (lazyGridMeasuredItemArrB = lazyGridMeasuredLineO2.b()) != null && (lazyGridMeasuredItem = (LazyGridMeasuredItem) ArraysKt.firstOrNull(lazyGridMeasuredItemArrB)) != null) {
                index = lazyGridMeasuredItem.getIndex();
            }
            g(index, iP);
        }
    }

    public final void i(int i3) {
        if (!(((float) i3) >= 0.0f)) {
            InlineClassHelperKt.c("scrollOffset should be non-negative");
        }
        f(i3);
    }

    public final int j(LazyGridItemProvider lazyGridItemProvider, int i3) {
        int iA = LazyLayoutItemProviderKt.a(lazyGridItemProvider, this.f7882d, i3);
        if (i3 != iA) {
            e(iA);
            this.f7883e.n(i3);
        }
        return iA;
    }
}
