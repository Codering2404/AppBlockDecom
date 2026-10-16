package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
final class DefaultLazyGridPrefetchStrategy implements LazyGridPrefetchStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7633b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableVector f7634c = new MutableVector(new LazyLayoutPrefetchState.PrefetchHandle[16], 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7635d;

    public DefaultLazyGridPrefetchStrategy(int i3) {
        this.f7632a = i3;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void a(NestedPrefetchScope nestedPrefetchScope, int i3) {
        int i4 = this.f7632a;
        for (int i5 = 0; i5 < i4; i5++) {
            nestedPrefetchScope.a(i3 + i5);
        }
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void c(LazyGridPrefetchScope lazyGridPrefetchScope, float f3, LazyGridLayoutInfo lazyGridLayoutInfo) {
        int iJ;
        int index;
        if (lazyGridLayoutInfo.h().isEmpty()) {
            return;
        }
        int i3 = 0;
        boolean z2 = f3 < 0.0f;
        if (z2) {
            LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.last(lazyGridLayoutInfo.h());
            iJ = (lazyGridLayoutInfo.getOrientation() == Orientation.f6031a ? lazyGridItemInfo.j() : lazyGridItemInfo.b()) + 1;
            index = ((LazyGridItemInfo) CollectionsKt.last(lazyGridLayoutInfo.h())).getIndex() + 1;
        } else {
            LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt.first(lazyGridLayoutInfo.h());
            iJ = (lazyGridLayoutInfo.getOrientation() == Orientation.f6031a ? lazyGridItemInfo2.j() : lazyGridItemInfo2.b()) - 1;
            index = ((LazyGridItemInfo) CollectionsKt.first(lazyGridLayoutInfo.h())).getIndex() - 1;
        }
        if (index < 0 || index >= lazyGridLayoutInfo.e()) {
            return;
        }
        if (iJ != this.f7633b && iJ >= 0) {
            if (this.f7635d != z2) {
                MutableVector mutableVector = this.f7634c;
                Object[] objArr = mutableVector.f24389a;
                int iO = mutableVector.o();
                for (int i4 = 0; i4 < iO; i4++) {
                    ((LazyLayoutPrefetchState.PrefetchHandle) objArr[i4]).cancel();
                }
            }
            this.f7635d = z2;
            this.f7633b = iJ;
            this.f7634c.i();
            MutableVector mutableVector2 = this.f7634c;
            mutableVector2.f(mutableVector2.o(), lazyGridPrefetchScope.a(iJ));
        }
        if (!z2) {
            if (lazyGridLayoutInfo.g() - LazyGridSnapLayoutInfoProviderKt.b((LazyGridItemInfo) CollectionsKt.first(lazyGridLayoutInfo.h()), lazyGridLayoutInfo.getOrientation()) < f3) {
                MutableVector mutableVector3 = this.f7634c;
                Object[] objArr2 = mutableVector3.f24389a;
                int iO2 = mutableVector3.o();
                while (i3 < iO2) {
                    ((LazyLayoutPrefetchState.PrefetchHandle) objArr2[i3]).a();
                    i3++;
                }
                return;
            }
            return;
        }
        LazyGridItemInfo lazyGridItemInfo3 = (LazyGridItemInfo) CollectionsKt.last(lazyGridLayoutInfo.h());
        if (((LazyGridSnapLayoutInfoProviderKt.b(lazyGridItemInfo3, lazyGridLayoutInfo.getOrientation()) + LazyGridSnapLayoutInfoProviderKt.c(lazyGridItemInfo3, lazyGridLayoutInfo.getOrientation())) + lazyGridLayoutInfo.f()) - lazyGridLayoutInfo.d() < (-f3)) {
            MutableVector mutableVector4 = this.f7634c;
            Object[] objArr3 = mutableVector4.f24389a;
            int iO3 = mutableVector4.o();
            while (i3 < iO3) {
                ((LazyLayoutPrefetchState.PrefetchHandle) objArr3[i3]).a();
                i3++;
            }
        }
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void d(LazyGridPrefetchScope lazyGridPrefetchScope, LazyGridLayoutInfo lazyGridLayoutInfo) {
        int iJ;
        if (this.f7633b == -1 || lazyGridLayoutInfo.h().isEmpty()) {
            return;
        }
        if (this.f7635d) {
            LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.last(lazyGridLayoutInfo.h());
            iJ = (lazyGridLayoutInfo.getOrientation() == Orientation.f6031a ? lazyGridItemInfo.j() : lazyGridItemInfo.b()) + 1;
        } else {
            LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt.first(lazyGridLayoutInfo.h());
            iJ = (lazyGridLayoutInfo.getOrientation() == Orientation.f6031a ? lazyGridItemInfo2.j() : lazyGridItemInfo2.b()) - 1;
        }
        if (this.f7633b != iJ) {
            this.f7633b = -1;
            MutableVector mutableVector = this.f7634c;
            Object[] objArr = mutableVector.f24389a;
            int iO = mutableVector.o();
            for (int i3 = 0; i3 < iO; i3++) {
                ((LazyLayoutPrefetchState.PrefetchHandle) objArr[i3]).cancel();
            }
            this.f7634c.i();
        }
    }
}
