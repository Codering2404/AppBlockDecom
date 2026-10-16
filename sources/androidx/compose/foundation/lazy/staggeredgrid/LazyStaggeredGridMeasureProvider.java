package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
public abstract class LazyStaggeredGridMeasureProvider implements LazyLayoutMeasuredItemProvider<LazyStaggeredGridMeasuredItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f8474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LazyStaggeredGridItemProvider f8475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyLayoutMeasureScope f8476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LazyStaggeredGridSlots f8477d;

    public LazyStaggeredGridMeasureProvider(boolean z2, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridSlots lazyStaggeredGridSlots) {
        this.f8474a = z2;
        this.f8475b = lazyStaggeredGridItemProvider;
        this.f8476c = lazyLayoutMeasureScope;
        this.f8477d = lazyStaggeredGridSlots;
    }

    private final long b(int i3, int i4) {
        int i5;
        if (i4 == 1) {
            i5 = this.f8477d.b()[i3];
        } else {
            int i6 = this.f8477d.a()[i3];
            int i7 = (i3 + i4) - 1;
            i5 = (this.f8477d.a()[i7] + this.f8477d.b()[i7]) - i6;
        }
        return this.f8474a ? Constraints.f29963b.e(i5) : Constraints.f29963b.d(i5);
    }

    public abstract LazyStaggeredGridMeasuredItem c(int i3, int i4, int i5, Object obj, Object obj2, List list, long j3);

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public LazyStaggeredGridMeasuredItem a(int i3, int i4, int i5, long j3) {
        return c(i3, i4, i5, this.f8475b.d(i3), this.f8475b.f(i3), this.f8476c.m0(i3, j3), j3);
    }

    public final LazyStaggeredGridMeasuredItem e(int i3, long j3) {
        Object objD = this.f8475b.d(i3);
        Object objF = this.f8475b.f(i3);
        int length = this.f8477d.b().length;
        int i4 = (int) (j3 >> 32);
        int iK = RangesKt.k(i4, length - 1);
        int iK2 = RangesKt.k(((int) (j3 & 4294967295L)) - i4, length - iK);
        long jB = b(iK, iK2);
        return c(i3, iK, iK2, objD, objF, this.f8476c.m0(i3, jB), jB);
    }

    public final LazyLayoutKeyIndexMap f() {
        return this.f8475b.b();
    }
}
