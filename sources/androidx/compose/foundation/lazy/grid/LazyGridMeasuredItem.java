package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
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
public final class LazyGridMeasuredItem implements LazyGridItemInfo, LazyLayoutMeasuredItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f7837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f7838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f7839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f7840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LayoutDirection f7841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f7842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f7843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f7844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f7845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Object f7846k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final LazyLayoutItemAnimator f7847l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f7848m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f7849n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f7850o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f7851p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f7852q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f7853r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f7854s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f7855t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final long f7856u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f7857v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f7858w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f7859x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f7860y;

    public /* synthetic */ LazyGridMeasuredItem(int i3, Object obj, boolean z2, int i4, int i5, boolean z3, LayoutDirection layoutDirection, int i6, int i7, List list, long j3, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j4, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, obj, z2, i4, i5, z3, layoutDirection, i6, i7, list, j3, obj2, lazyLayoutItemAnimator, j4, i8, i9);
    }

    private final int q(long j3) {
        return k() ? IntOffset.l(j3) : IntOffset.k(j3);
    }

    private final int s(Placeable placeable) {
        return k() ? placeable.O0() : placeable.X0();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public long a() {
        return this.f7856u;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int b() {
        return this.f7859x;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public long c() {
        return this.f7848m;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int d() {
        return this.f7844i.size();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int e() {
        return this.f7849n;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public long f() {
        return this.f7857v;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void g(boolean z2) {
        this.f7860y = z2;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.f7836a;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.f7837b;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean h() {
        return this.f7860y;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int i() {
        return this.f7850o;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridItemInfo
    public int j() {
        return this.f7858w;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean k() {
        return this.f7838c;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void l(int i3, int i4, int i5, int i6) {
        u(i3, i4, i5, i6, -1, -1);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int m() {
        return this.f7852q;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object n(int i3) {
        return ((Placeable) this.f7844i.get(i3)).p();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public long o(int i3) {
        return f();
    }

    public final void p(int i3, boolean z2) {
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
        this.f7857v = IntOffset.f((((long) iK) << 32) | (((long) iL) & 4294967295L));
        if (z2) {
            int iD = d();
            for (int i4 = 0; i4 < iD; i4++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimationE = this.f7847l.e(getKey(), i4);
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

    public final int r() {
        return this.f7851p;
    }

    public final void t(Placeable.PlacementScope placementScope, boolean z2) {
        GraphicsLayer graphicsLayerP;
        Placeable.PlacementScope placementScope2;
        int i3 = 0;
        if (!(this.f7853r != Integer.MIN_VALUE)) {
            InlineClassHelperKt.a("position() should be called first");
        }
        int iD = d();
        while (i3 < iD) {
            Placeable placeable = (Placeable) this.f7844i.get(i3);
            int iS = this.f7854s - s(placeable);
            int i4 = this.f7855t;
            long jF = f();
            LazyLayoutItemAnimation lazyLayoutItemAnimationE = this.f7847l.e(getKey(), i3);
            if (lazyLayoutItemAnimationE != null) {
                if (z2) {
                    lazyLayoutItemAnimationE.F(jF);
                } else {
                    long jO = IntOffset.o(!IntOffset.j(lazyLayoutItemAnimationE.q(), LazyLayoutItemAnimation.f8022s.a()) ? lazyLayoutItemAnimationE.q() : jF, lazyLayoutItemAnimationE.r());
                    if ((q(jF) <= iS && q(jO) <= iS) || (q(jF) >= i4 && q(jO) >= i4)) {
                        lazyLayoutItemAnimationE.n();
                    }
                    jF = jO;
                }
                graphicsLayerP = lazyLayoutItemAnimationE.p();
            } else {
                graphicsLayerP = null;
            }
            if (this.f7840e) {
                jF = IntOffset.f((((long) (k() ? (this.f7853r - IntOffset.l(jF)) - s(placeable) : IntOffset.l(jF))) & 4294967295L) | (((long) (k() ? IntOffset.k(jF) : (this.f7853r - IntOffset.k(jF)) - s(placeable))) << 32));
            }
            long jO2 = IntOffset.o(jF, this.f7845j);
            if (!z2 && lazyLayoutItemAnimationE != null) {
                lazyLayoutItemAnimationE.E(jO2);
            }
            if (!k()) {
                placementScope2 = placementScope;
                GraphicsLayer graphicsLayer = graphicsLayerP;
                if (graphicsLayer != null) {
                    Placeable.PlacementScope.u(placementScope2, placeable, jO2, graphicsLayer, 0.0f, 4, null);
                } else {
                    Placeable.PlacementScope.t(placementScope2, placeable, jO2, 0.0f, null, 6, null);
                }
            } else if (graphicsLayerP != null) {
                placementScope2 = placementScope;
                Placeable.PlacementScope.A(placementScope2, placeable, jO2, graphicsLayerP, 0.0f, 4, null);
            } else {
                placementScope2 = placementScope;
                Placeable.PlacementScope.z(placementScope2, placeable, jO2, 0.0f, null, 6, null);
            }
            i3++;
            placementScope = placementScope2;
        }
    }

    public final void u(int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f7853r = k() ? i6 : i5;
        if (!k()) {
            i5 = i6;
        }
        if (k() && this.f7841f == LayoutDirection.f30002b) {
            i4 = (i5 - i4) - this.f7839d;
        }
        this.f7857v = k() ? IntOffset.f((((long) i4) << 32) | (4294967295L & ((long) i3))) : IntOffset.f((((long) i4) & 4294967295L) | (((long) i3) << 32));
        this.f7858w = i7;
        this.f7859x = i8;
        this.f7854s = -this.f7842g;
        this.f7855t = this.f7853r + this.f7843h;
    }

    public final void v(int i3) {
        this.f7853r = i3;
        this.f7855t = i3 + this.f7843h;
    }

    private LazyGridMeasuredItem(int i3, Object obj, boolean z2, int i4, int i5, boolean z3, LayoutDirection layoutDirection, int i6, int i7, List list, long j3, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j4, int i8, int i9) {
        this.f7836a = i3;
        this.f7837b = obj;
        this.f7838c = z2;
        this.f7839d = i4;
        this.f7840e = z3;
        this.f7841f = layoutDirection;
        this.f7842g = i6;
        this.f7843h = i7;
        this.f7844i = list;
        this.f7845j = j3;
        this.f7846k = obj2;
        this.f7847l = lazyLayoutItemAnimator;
        this.f7848m = j4;
        this.f7849n = i8;
        this.f7850o = i9;
        this.f7853r = Integer.MIN_VALUE;
        int size = list.size();
        int iMax = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Placeable placeable = (Placeable) list.get(i10);
            iMax = Math.max(iMax, k() ? placeable.O0() : placeable.X0());
        }
        this.f7851p = iMax;
        this.f7852q = RangesKt.f(i5 + iMax, 0);
        this.f7856u = k() ? IntSize.c((((long) iMax) & 4294967295L) | (((long) this.f7839d) << 32)) : IntSize.c((((long) this.f7839d) & 4294967295L) | (((long) iMax) << 32));
        this.f7857v = IntOffset.f29988b.b();
        this.f7858w = -1;
        this.f7859x = -1;
    }
}
