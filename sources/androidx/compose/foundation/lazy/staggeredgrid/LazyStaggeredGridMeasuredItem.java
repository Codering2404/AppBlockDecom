package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class LazyStaggeredGridMeasuredItem implements LazyStaggeredGridItemInfo, LazyLayoutMeasuredItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f8506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f8507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f8508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f8509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f8510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f8511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f8512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f8513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LazyLayoutItemAnimator f8514j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f8515k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8516l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f8517m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f8518n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f8519o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f8520p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f8521q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f8522r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f8523s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final long f8524t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f8525u;

    public /* synthetic */ LazyStaggeredGridMeasuredItem(int i3, Object obj, List list, boolean z2, int i4, int i5, int i6, int i7, int i8, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, obj, list, z2, i4, i5, i6, i7, i8, obj2, lazyLayoutItemAnimator, j3);
    }

    private final int j(long j3) {
        return k() ? IntOffset.l(j3) : IntOffset.k(j3);
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public long a() {
        return this.f8524t;
    }

    public final void b(int i3, boolean z2) {
        if (h()) {
            return;
        }
        long jF = f();
        int iK = k() ? IntOffset.k(jF) : IntOffset.k(jF) + i3;
        boolean zK = k();
        int iL = IntOffset.l(jF);
        if (zK) {
            iL += i3;
        }
        this.f8525u = IntOffset.f((((long) iK) << 32) | (((long) iL) & 4294967295L));
        if (z2) {
            int iD = d();
            for (int i4 = 0; i4 < iD; i4++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimationE = this.f8514j.e(getKey(), i4);
                if (lazyLayoutItemAnimationE != null) {
                    long jS = lazyLayoutItemAnimationE.s();
                    int iK2 = k() ? IntOffset.k(jS) : Integer.valueOf(IntOffset.k(jS) + i3).intValue();
                    boolean zK2 = k();
                    int iL2 = IntOffset.l(jS);
                    if (zK2) {
                        iL2 = Integer.valueOf(iL2 + i3).intValue();
                    }
                    lazyLayoutItemAnimationE.J(IntOffset.f((((long) iL2) & 4294967295L) | (((long) iK2) << 32)));
                }
            }
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public long c() {
        return this.f8515k;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int d() {
        return this.f8507c.size();
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int e() {
        return this.f8509e;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public long f() {
        return this.f8525u;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void g(boolean z2) {
        this.f8523s = z2;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.f8505a;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.f8506b;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean h() {
        return this.f8523s;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int i() {
        return this.f8510f;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean k() {
        return this.f8508d;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void l(int i3, int i4, int i5, int i6) {
        if (k()) {
            i5 = i6;
        }
        t(i3, i4, i5);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int m() {
        return this.f8518n;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object n(int i3) {
        return ((Placeable) this.f8507c.get(i3)).p();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public long o(int i3) {
        return f();
    }

    public final int p() {
        return !k() ? IntOffset.k(f()) : IntOffset.l(f());
    }

    public final int q() {
        return this.f8517m;
    }

    public final boolean r() {
        return this.f8516l;
    }

    public final void s(Placeable.PlacementScope placementScope, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, boolean z2) {
        GraphicsLayer graphicsLayerP;
        if (!(this.f8520p != -1)) {
            InlineClassHelperKt.a("position() should be called first");
        }
        List list = this.f8507c;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Placeable placeable = (Placeable) list.get(i3);
            int iO0 = this.f8521q - (k() ? placeable.O0() : placeable.X0());
            int i4 = this.f8522r;
            long jF = f();
            LazyLayoutItemAnimation lazyLayoutItemAnimationE = this.f8514j.e(getKey(), i3);
            if (lazyLayoutItemAnimationE != null) {
                if (z2) {
                    lazyLayoutItemAnimationE.F(jF);
                } else {
                    long jO = IntOffset.o(!IntOffset.j(lazyLayoutItemAnimationE.q(), LazyLayoutItemAnimation.f8022s.a()) ? lazyLayoutItemAnimationE.q() : jF, lazyLayoutItemAnimationE.r());
                    if ((j(jF) <= iO0 && j(jO) <= iO0) || (j(jF) >= i4 && j(jO) >= i4)) {
                        lazyLayoutItemAnimationE.n();
                    }
                    jF = jO;
                }
                graphicsLayerP = lazyLayoutItemAnimationE.p();
            } else {
                graphicsLayerP = null;
            }
            if (lazyStaggeredGridMeasureContext.q()) {
                int iK = k() ? IntOffset.k(jF) : (this.f8520p - IntOffset.k(jF)) - (k() ? placeable.O0() : placeable.X0());
                jF = IntOffset.f((((long) (k() ? (this.f8520p - IntOffset.l(jF)) - (k() ? placeable.O0() : placeable.X0()) : IntOffset.l(jF))) & 4294967295L) | (((long) iK) << 32));
            }
            long jO2 = IntOffset.o(jF, lazyStaggeredGridMeasureContext.e());
            if (!z2 && lazyLayoutItemAnimationE != null) {
                lazyLayoutItemAnimationE.E(jO2);
            }
            if (graphicsLayerP != null) {
                Placeable.PlacementScope.u(placementScope, placeable, jO2, graphicsLayerP, 0.0f, 4, null);
            } else {
                Placeable.PlacementScope.t(placementScope, placeable, jO2, 0.0f, null, 6, null);
            }
        }
    }

    public final void t(int i3, int i4, int i5) {
        long jF;
        this.f8520p = i5;
        this.f8521q = -this.f8511g;
        this.f8522r = i5 + this.f8512h;
        if (k()) {
            jF = IntOffset.f((((long) i4) << 32) | (4294967295L & ((long) i3)));
        } else {
            jF = IntOffset.f((((long) i4) & 4294967295L) | (((long) i3) << 32));
        }
        this.f8525u = jF;
    }

    public String toString() {
        return super.toString();
    }

    public final void u(boolean z2) {
        this.f8516l = z2;
    }

    public final void v(int i3) {
        this.f8520p = i3;
        this.f8522r = i3 + this.f8512h;
    }

    private LazyStaggeredGridMeasuredItem(int i3, Object obj, List list, boolean z2, int i4, int i5, int i6, int i7, int i8, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j3) {
        int iO0;
        this.f8505a = i3;
        this.f8506b = obj;
        this.f8507c = list;
        this.f8508d = z2;
        this.f8509e = i5;
        this.f8510f = i6;
        this.f8511g = i7;
        this.f8512h = i8;
        this.f8513i = obj2;
        this.f8514j = lazyLayoutItemAnimator;
        this.f8515k = j3;
        int i9 = 1;
        this.f8516l = true;
        int i10 = 0;
        if (list.isEmpty()) {
            iO0 = 0;
        } else {
            Placeable placeable = (Placeable) list.get(0);
            iO0 = k() ? placeable.O0() : placeable.X0();
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                int i11 = 1;
                while (true) {
                    Placeable placeable2 = (Placeable) list.get(i11);
                    int iO02 = k() ? placeable2.O0() : placeable2.X0();
                    iO0 = iO02 > iO0 ? iO02 : iO0;
                    if (i11 == lastIndex) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        this.f8517m = iO0;
        this.f8518n = RangesKt.f(iO0 + i4, 0);
        List list2 = this.f8507c;
        if (!list2.isEmpty()) {
            Placeable placeable3 = (Placeable) list2.get(0);
            int iX0 = k() ? placeable3.X0() : placeable3.O0();
            int lastIndex2 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex2) {
                while (true) {
                    Placeable placeable4 = (Placeable) list2.get(i9);
                    int iX02 = k() ? placeable4.X0() : placeable4.O0();
                    iX0 = iX02 > iX0 ? iX02 : iX0;
                    if (i9 == lastIndex2) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            i10 = iX0;
        }
        this.f8519o = i10;
        this.f8520p = -1;
        this.f8524t = k() ? IntSize.c((((long) this.f8517m) & 4294967295L) | (((long) i10) << 32)) : IntSize.c((((long) i10) & 4294967295L) | (((long) this.f8517m) << 32));
        this.f8525u = IntOffset.f29988b.b();
    }
}
