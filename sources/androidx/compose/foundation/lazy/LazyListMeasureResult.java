package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class LazyListMeasureResult implements LazyListLayoutInfo, MeasureResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyListMeasuredItem f7505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f7507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f7508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MeasureResult f7509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f7510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f7511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CoroutineScope f7512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Density f7513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f7514j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f7515k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f7516l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f7517m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f7518n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f7519o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Orientation f7520p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f7521q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f7522r;

    public /* synthetic */ LazyListMeasureResult(LazyListMeasuredItem lazyListMeasuredItem, int i3, boolean z2, float f3, MeasureResult measureResult, float f4, boolean z3, CoroutineScope coroutineScope, Density density, long j3, List list, int i4, int i5, int i6, boolean z4, Orientation orientation, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyListMeasuredItem, i3, z2, f3, measureResult, f4, z3, coroutineScope, density, j3, list, i4, i5, i6, z4, orientation, i7, i8);
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public void A() {
        this.f7509e.A();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Function1 B() {
        return this.f7509e.B();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public long a() {
        return IntSize.c((((long) getHeight()) & 4294967295L) | (((long) getWidth()) << 32));
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int b() {
        return this.f7521q;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int c() {
        return -g();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int d() {
        return this.f7517m;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int e() {
        return this.f7518n;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int f() {
        return this.f7522r;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public int g() {
        return this.f7516l;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getHeight() {
        return this.f7509e.getHeight();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public Orientation getOrientation() {
        return this.f7520p;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getWidth() {
        return this.f7509e.getWidth();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public List h() {
        return this.f7515k;
    }

    public final LazyListMeasureResult i(int i3, boolean z2) {
        LazyListMeasuredItem lazyListMeasuredItem;
        if (!this.f7511g && !h().isEmpty() && (lazyListMeasuredItem = this.f7505a) != null) {
            int iM = lazyListMeasuredItem.m();
            int i4 = this.f7506b - i3;
            if (i4 >= 0 && i4 < iM) {
                LazyListMeasuredItem lazyListMeasuredItem2 = (LazyListMeasuredItem) CollectionsKt.first(h());
                LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) CollectionsKt.last(h());
                if (!lazyListMeasuredItem2.h() && !lazyListMeasuredItem3.h() && (i3 >= 0 ? Math.min(g() - lazyListMeasuredItem2.getOffset(), d() - lazyListMeasuredItem3.getOffset()) > i3 : Math.min((lazyListMeasuredItem2.getOffset() + lazyListMeasuredItem2.m()) - g(), (lazyListMeasuredItem3.getOffset() + lazyListMeasuredItem3.m()) - d()) > (-i3))) {
                    List listH = h();
                    int size = listH.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        ((LazyListMeasuredItem) listH.get(i5)).a(i3, z2);
                    }
                    return new LazyListMeasureResult(this.f7505a, this.f7506b - i3, this.f7507c || i3 > 0, i3, this.f7509e, this.f7510f, this.f7511g, this.f7512h, this.f7513i, this.f7514j, h(), g(), d(), e(), r(), getOrientation(), b(), f(), null);
                }
            }
        }
        return null;
    }

    public final boolean j() {
        LazyListMeasuredItem lazyListMeasuredItem = this.f7505a;
        return ((lazyListMeasuredItem != null ? lazyListMeasuredItem.getIndex() : 0) == 0 && this.f7506b == 0) ? false : true;
    }

    public final boolean k() {
        return this.f7507c;
    }

    public final long l() {
        return this.f7514j;
    }

    public final float m() {
        return this.f7508d;
    }

    public final CoroutineScope n() {
        return this.f7512h;
    }

    public final Density o() {
        return this.f7513i;
    }

    public final LazyListMeasuredItem p() {
        return this.f7505a;
    }

    public final int q() {
        return this.f7506b;
    }

    public boolean r() {
        return this.f7519o;
    }

    public final float s() {
        return this.f7510f;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Map z() {
        return this.f7509e.z();
    }

    private LazyListMeasureResult(LazyListMeasuredItem lazyListMeasuredItem, int i3, boolean z2, float f3, MeasureResult measureResult, float f4, boolean z3, CoroutineScope coroutineScope, Density density, long j3, List list, int i4, int i5, int i6, boolean z4, Orientation orientation, int i7, int i8) {
        this.f7505a = lazyListMeasuredItem;
        this.f7506b = i3;
        this.f7507c = z2;
        this.f7508d = f3;
        this.f7509e = measureResult;
        this.f7510f = f4;
        this.f7511g = z3;
        this.f7512h = coroutineScope;
        this.f7513i = density;
        this.f7514j = j3;
        this.f7515k = list;
        this.f7516l = i4;
        this.f7517m = i5;
        this.f7518n = i6;
        this.f7519o = z4;
        this.f7520p = orientation;
        this.f7521q = i7;
        this.f7522r = i8;
    }
}
