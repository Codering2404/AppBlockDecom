package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class LazyStaggeredGridScrollPosition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f8527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f8528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableIntState f8529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f8530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableIntState f8531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f8533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final LazyLayoutNearestRangeState f8534h;

    public LazyStaggeredGridScrollPosition(int[] iArr, int[] iArr2, Function2 function2) {
        this.f8527a = function2;
        this.f8528b = iArr;
        this.f8529c = SnapshotIntStateKt.a(a(iArr));
        this.f8530d = iArr2;
        this.f8531e = SnapshotIntStateKt.a(b(iArr, iArr2));
        Integer numMinOrNull = ArraysKt.minOrNull(iArr);
        this.f8534h = new LazyLayoutNearestRangeState(numMinOrNull != null ? numMinOrNull.intValue() : 0, 90, 200);
    }

    private final int a(int[] iArr) {
        int i3 = Integer.MAX_VALUE;
        for (int i4 : iArr) {
            if (i4 <= 0) {
                return 0;
            }
            if (i3 > i4) {
                i3 = i4;
            }
        }
        if (i3 == Integer.MAX_VALUE) {
            return 0;
        }
        return i3;
    }

    private final int b(int[] iArr, int[] iArr2) {
        int iA = a(iArr);
        int length = iArr2.length;
        int iMin = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            if (iArr[i3] == iA) {
                iMin = Math.min(iMin, iArr2[i3]);
            }
        }
        if (iMin == Integer.MAX_VALUE) {
            return 0;
        }
        return iMin;
    }

    private final void i(int i3) {
        this.f8529c.a(i3);
    }

    private final void j(int i3) {
        this.f8531e.a(i3);
    }

    private final void k(int[] iArr, int[] iArr2) {
        this.f8528b = iArr;
        i(a(iArr));
        this.f8530d = iArr2;
        j(b(iArr, iArr2));
    }

    public final int c() {
        return this.f8529c.g();
    }

    public final int[] d() {
        return this.f8528b;
    }

    public final LazyLayoutNearestRangeState e() {
        return this.f8534h;
    }

    public final int f() {
        return this.f8531e.g();
    }

    public final int[] g() {
        return this.f8530d;
    }

    public final void h(int i3, int i4) {
        int[] iArr = (int[]) this.f8527a.invoke(Integer.valueOf(i3), Integer.valueOf(this.f8528b.length));
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i5 = 0; i5 < length; i5++) {
            iArr2[i5] = i4;
        }
        k(iArr, iArr2);
        this.f8534h.n(i3);
        this.f8533g = null;
    }

    public final void l(LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult) {
        Object obj;
        int iA = a(lazyStaggeredGridMeasureResult.m());
        List listH = lazyStaggeredGridMeasureResult.h();
        int size = listH.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                obj = null;
                break;
            }
            obj = listH.get(i3);
            if (((LazyStaggeredGridMeasuredItem) obj).getIndex() == iA) {
                break;
            } else {
                i3++;
            }
        }
        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) obj;
        this.f8533g = lazyStaggeredGridMeasuredItem != null ? lazyStaggeredGridMeasuredItem.getKey() : null;
        this.f8534h.n(iA);
        if (this.f8532f || lazyStaggeredGridMeasureResult.e() > 0) {
            this.f8532f = true;
            Snapshot.Companion companion = Snapshot.f24914e;
            Snapshot snapshotD = companion.d();
            Function1 function1G = snapshotD != null ? snapshotD.g() : null;
            Snapshot snapshotE = companion.e(snapshotD);
            try {
                k(lazyStaggeredGridMeasureResult.m(), lazyStaggeredGridMeasureResult.n());
                Unit unit = Unit.f139807a;
            } finally {
                companion.m(snapshotD, snapshotE, function1G);
            }
        }
    }

    public final void m(int[] iArr) {
        this.f8530d = iArr;
        j(b(this.f8528b, iArr));
    }

    public final int[] n(LazyLayoutItemProvider lazyLayoutItemProvider, int[] iArr) {
        Object obj = this.f8533g;
        Integer orNull = ArraysKt.getOrNull(iArr, 0);
        int iA = LazyLayoutItemProviderKt.a(lazyLayoutItemProvider, obj, orNull != null ? orNull.intValue() : 0);
        if (ArraysKt.contains(iArr, iA)) {
            return iArr;
        }
        this.f8534h.n(iA);
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotD = companion.d();
        Function1 function1G = snapshotD != null ? snapshotD.g() : null;
        Snapshot snapshotE = companion.e(snapshotD);
        try {
            int[] iArr2 = (int[]) this.f8527a.invoke(Integer.valueOf(iA), Integer.valueOf(iArr.length));
            companion.m(snapshotD, snapshotE, function1G);
            this.f8528b = iArr2;
            i(a(iArr2));
            return iArr2;
        } catch (Throwable th) {
            companion.m(snapshotD, snapshotE, function1G);
            throw th;
        }
    }
}
