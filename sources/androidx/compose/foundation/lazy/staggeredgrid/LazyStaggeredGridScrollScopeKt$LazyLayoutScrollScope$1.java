package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
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
public final class LazyStaggeredGridScrollScopeKt$LazyLayoutScrollScope$1 implements LazyLayoutScrollScope, ScrollScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ScrollScope f8535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LazyStaggeredGridState f8536b;

    LazyStaggeredGridScrollScopeKt$LazyLayoutScrollScope$1(ScrollScope scrollScope, LazyStaggeredGridState lazyStaggeredGridState) {
        this.f8536b = lazyStaggeredGridState;
        this.f8535a = scrollScope;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int a() {
        return this.f8536b.y().e();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int b() {
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo = (LazyStaggeredGridItemInfo) CollectionsKt.lastOrNull(this.f8536b.y().h());
        if (lazyStaggeredGridItemInfo != null) {
            return lazyStaggeredGridItemInfo.getIndex();
        }
        return 0;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public void c(int i3, int i4) {
        this.f8536b.Q(i3, i4, true);
    }

    @Override // androidx.compose.foundation.gestures.ScrollScope
    public float d(float f3) {
        return this.f8535a.d(f3);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int f(int i3, int i4) {
        Object obj;
        int iL;
        LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfoY = this.f8536b.y();
        int i5 = 0;
        if (lazyStaggeredGridLayoutInfoY.h().isEmpty()) {
            return 0;
        }
        List listH = lazyStaggeredGridLayoutInfoY.h();
        int size = listH.size();
        while (true) {
            if (i5 >= size) {
                obj = null;
                break;
            }
            obj = listH.get(i5);
            if (((LazyStaggeredGridItemInfo) obj).getIndex() == i3) {
                break;
            }
            i5++;
        }
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo = (LazyStaggeredGridItemInfo) obj;
        if (lazyStaggeredGridItemInfo == null) {
            int iD = LazyStaggeredGridMeasureResultKt.d(lazyStaggeredGridLayoutInfoY);
            int iW = this.f8536b.w();
            iL = (iD * ((i3 / iW) - (h() / iW))) - g();
        } else {
            iL = lazyStaggeredGridLayoutInfoY.getOrientation() == Orientation.f6031a ? IntOffset.l(lazyStaggeredGridItemInfo.f()) : IntOffset.k(lazyStaggeredGridItemInfo.f());
        }
        return iL + i4;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int g() {
        return this.f8536b.t();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
    public int h() {
        return this.f8536b.s();
    }
}
