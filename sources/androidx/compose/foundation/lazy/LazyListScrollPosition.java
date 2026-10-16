package androidx.compose.foundation.lazy;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.comparisons.xn.YvFRmou;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class LazyListScrollPosition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableIntState f7556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableIntState f7557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f7559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LazyLayoutNearestRangeState f7560e;

    public LazyListScrollPosition(int i3, int i4) {
        this.f7556a = SnapshotIntStateKt.a(i3);
        this.f7557b = SnapshotIntStateKt.a(i4);
        this.f7560e = new LazyLayoutNearestRangeState(i3, 30, 100);
    }

    private final void f(int i3) {
        this.f7557b.a(i3);
    }

    private final void g(int i3, int i4) {
        if (!(((float) i3) >= 0.0f)) {
            InlineClassHelperKt.a("Index should be non-negative (" + i3 + ')');
        }
        e(i3);
        this.f7560e.n(i3);
        f(i4);
    }

    public final int a() {
        return this.f7556a.g();
    }

    public final LazyLayoutNearestRangeState b() {
        return this.f7560e;
    }

    public final int c() {
        return this.f7557b.g();
    }

    public final void d(int i3, int i4) {
        g(i3, i4);
        this.f7559d = null;
    }

    public final void e(int i3) {
        this.f7556a.a(i3);
    }

    public final void h(LazyListMeasureResult lazyListMeasureResult) {
        LazyListMeasuredItem lazyListMeasuredItemP = lazyListMeasureResult.p();
        this.f7559d = lazyListMeasuredItemP != null ? lazyListMeasuredItemP.getKey() : null;
        if (this.f7558c || lazyListMeasureResult.e() > 0) {
            this.f7558c = true;
            int iQ = lazyListMeasureResult.q();
            if (!(((float) iQ) >= 0.0f)) {
                InlineClassHelperKt.c("scrollOffset should be non-negative");
            }
            LazyListMeasuredItem lazyListMeasuredItemP2 = lazyListMeasureResult.p();
            g(lazyListMeasuredItemP2 != null ? lazyListMeasuredItemP2.getIndex() : 0, iQ);
        }
    }

    public final void i(int i3) {
        if (!(((float) i3) >= 0.0f)) {
            InlineClassHelperKt.c(YvFRmou.gfl);
        }
        f(i3);
    }

    public final int j(LazyListItemProvider lazyListItemProvider, int i3) {
        int iA = LazyLayoutItemProviderKt.a(lazyListItemProvider, this.f7559d, i3);
        if (i3 != iA) {
            e(iA);
            this.f7560e.n(i3);
        }
        return iA;
    }
}
