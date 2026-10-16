package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

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
public final class LazyStaggeredGridMeasureResult implements LazyStaggeredGridLayoutInfo, MeasureResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f8478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f8479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f8480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MeasureResult f8481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f8482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f8483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f8484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f8485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LazyStaggeredGridSlots f8486i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LazyStaggeredGridSpanProvider f8487j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Density f8488k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f8489l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final List f8490m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f8491n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f8492o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f8493p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f8494q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f8495r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f8496s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final CoroutineScope f8497t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Orientation f8498u;

    public /* synthetic */ LazyStaggeredGridMeasureResult(int[] iArr, int[] iArr2, float f3, MeasureResult measureResult, float f4, boolean z2, boolean z3, boolean z4, LazyStaggeredGridSlots lazyStaggeredGridSlots, LazyStaggeredGridSpanProvider lazyStaggeredGridSpanProvider, Density density, int i3, List list, long j3, int i4, int i5, int i6, int i7, int i8, CoroutineScope coroutineScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr, iArr2, f3, measureResult, f4, z2, z3, z4, lazyStaggeredGridSlots, lazyStaggeredGridSpanProvider, density, i3, list, j3, i4, i5, i6, i7, i8, coroutineScope);
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public void A() {
        this.f8481d.A();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Function1 B() {
        return this.f8481d.B();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public long a() {
        return this.f8491n;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int b() {
        return this.f8495r;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int c() {
        return this.f8494q;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b5, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult d(int r33, boolean r34) {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult.d(int, boolean):androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult");
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int e() {
        return this.f8489l;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public int f() {
        return this.f8496s;
    }

    public final boolean g() {
        return this.f8478a[0] != 0 || this.f8479b[0] > 0;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getHeight() {
        return this.f8481d.getHeight();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public Orientation getOrientation() {
        return this.f8498u;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getWidth() {
        return this.f8481d.getWidth();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo
    public List h() {
        return this.f8490m;
    }

    public final boolean i() {
        return this.f8483f;
    }

    public final float j() {
        return this.f8480c;
    }

    public final CoroutineScope k() {
        return this.f8497t;
    }

    public final Density l() {
        return this.f8488k;
    }

    public final int[] m() {
        return this.f8478a;
    }

    public final int[] n() {
        return this.f8479b;
    }

    public final float o() {
        return this.f8482e;
    }

    public final LazyStaggeredGridSlots p() {
        return this.f8486i;
    }

    public final LazyStaggeredGridSpanProvider q() {
        return this.f8487j;
    }

    public int r() {
        return this.f8493p;
    }

    public int s() {
        return this.f8492o;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Map z() {
        return this.f8481d.z();
    }

    private LazyStaggeredGridMeasureResult(int[] iArr, int[] iArr2, float f3, MeasureResult measureResult, float f4, boolean z2, boolean z3, boolean z4, LazyStaggeredGridSlots lazyStaggeredGridSlots, LazyStaggeredGridSpanProvider lazyStaggeredGridSpanProvider, Density density, int i3, List list, long j3, int i4, int i5, int i6, int i7, int i8, CoroutineScope coroutineScope) {
        this.f8478a = iArr;
        this.f8479b = iArr2;
        this.f8480c = f3;
        this.f8481d = measureResult;
        this.f8482e = f4;
        this.f8483f = z2;
        this.f8484g = z3;
        this.f8485h = z4;
        this.f8486i = lazyStaggeredGridSlots;
        this.f8487j = lazyStaggeredGridSpanProvider;
        this.f8488k = density;
        this.f8489l = i3;
        this.f8490m = list;
        this.f8491n = j3;
        this.f8492o = i4;
        this.f8493p = i5;
        this.f8494q = i6;
        this.f8495r = i7;
        this.f8496s = i8;
        this.f8497t = coroutineScope;
        this.f8498u = z3 ? Orientation.f6031a : Orientation.f6032b;
    }
}
