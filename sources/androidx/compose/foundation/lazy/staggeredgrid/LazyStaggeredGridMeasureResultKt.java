package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.MutableIntervalList;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScopeKt;

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
public final class LazyStaggeredGridMeasureResultKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f8499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LazyStaggeredGridMeasureResult f8500b;

    static {
        int[] iArr = new int[0];
        f8499a = iArr;
        f8500b = new LazyStaggeredGridMeasureResult(iArr, iArr, 0.0f, new MeasureResult() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResultKt$EmptyLazyStaggeredGridLayoutInfo$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f8501a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f8502b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Map f8503c = MapsKt.emptyMap();

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getHeight() {
                return this.f8502b;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getWidth() {
                return this.f8501a;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map z() {
                return this.f8503c;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void A() {
            }
        }, 0.0f, false, false, false, new LazyStaggeredGridSlots(iArr, iArr), new LazyStaggeredGridSpanProvider(new MutableIntervalList()), DensityKt.b(1.0f, 0.0f, 2, null), 0, CollectionsKt.emptyList(), IntSize.f29998b.a(), 0, 0, 0, 0, 0, CoroutineScopeKt.a(EmptyCoroutineContext.f139889a), null);
    }

    public static final LazyStaggeredGridItemInfo a(LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, final int i3) {
        if (lazyStaggeredGridLayoutInfo.h().isEmpty()) {
            return null;
        }
        int index = ((LazyStaggeredGridItemInfo) CollectionsKt.first(lazyStaggeredGridLayoutInfo.h())).getIndex();
        if (i3 > ((LazyStaggeredGridItemInfo) CollectionsKt.last(lazyStaggeredGridLayoutInfo.h())).getIndex() || index > i3) {
            return null;
        }
        return (LazyStaggeredGridItemInfo) CollectionsKt.getOrNull(lazyStaggeredGridLayoutInfo.h(), CollectionsKt.binarySearch$default(lazyStaggeredGridLayoutInfo.h(), 0, 0, new Function1<LazyStaggeredGridItemInfo, Integer>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResultKt$findVisibleItem$index$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Integer invoke(LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo) {
                return Integer.valueOf(lazyStaggeredGridItemInfo.getIndex() - i3);
            }
        }, 3, (Object) null));
    }

    public static final LazyStaggeredGridMeasureResult b() {
        return f8500b;
    }

    public static final int c(LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo) {
        return (int) (lazyStaggeredGridLayoutInfo.getOrientation() == Orientation.f6031a ? lazyStaggeredGridLayoutInfo.a() & 4294967295L : lazyStaggeredGridLayoutInfo.a() >> 32);
    }

    public static final int d(LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo) {
        List listH = lazyStaggeredGridLayoutInfo.h();
        if (listH.isEmpty()) {
            return 0;
        }
        int size = listH.size();
        int iA = 0;
        for (int i3 = 0; i3 < size; i3++) {
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo = (LazyStaggeredGridItemInfo) listH.get(i3);
            iA += (int) (lazyStaggeredGridLayoutInfo.getOrientation() == Orientation.f6031a ? lazyStaggeredGridItemInfo.a() & 4294967295L : lazyStaggeredGridItemInfo.a() >> 32);
        }
        return (iA / listH.size()) + lazyStaggeredGridLayoutInfo.f();
    }
}
