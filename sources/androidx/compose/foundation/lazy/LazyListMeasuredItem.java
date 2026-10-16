package androidx.compose.foundation.lazy;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.KotlinNothingValueException;
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
public final class LazyListMeasuredItem implements LazyListItemInfo, LazyLayoutMeasuredItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f7524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f7525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Alignment.Horizontal f7526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Alignment.Vertical f7527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LayoutDirection f7528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f7529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f7530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f7531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f7532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f7533k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Object f7534l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Object f7535m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final LazyLayoutItemAnimator f7536n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final long f7537o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f7538p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f7539q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f7540r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f7541s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f7542t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f7543u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f7544v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f7545w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f7546x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f7547y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int[] f7548z;

    public /* synthetic */ LazyListMeasuredItem(int i3, List list, boolean z2, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z3, int i4, int i5, int i6, long j3, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, list, z2, horizontal, vertical, layoutDirection, z3, i4, i5, i6, j3, obj, obj2, lazyLayoutItemAnimator, j4);
    }

    private final int f(long j3) {
        return k() ? IntOffset.l(j3) : IntOffset.k(j3);
    }

    private final int j(Placeable placeable) {
        return k() ? placeable.O0() : placeable.X0();
    }

    public final void a(int i3, boolean z2) {
        int iIntValue;
        int iL;
        if (h()) {
            return;
        }
        this.f7538p = getOffset() + i3;
        int length = this.f7548z.length;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 & 1;
            if ((k() && i5 != 0) || (!k() && i5 == 0)) {
                int[] iArr = this.f7548z;
                iArr[i4] = iArr[i4] + i3;
            }
        }
        if (z2) {
            int iD = d();
            for (int i6 = 0; i6 < iD; i6++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimationE = this.f7536n.e(getKey(), i6);
                if (lazyLayoutItemAnimationE != null) {
                    long jS = lazyLayoutItemAnimationE.s();
                    if (k()) {
                        iIntValue = IntOffset.k(jS);
                        iL = Integer.valueOf(IntOffset.l(jS) + i3).intValue();
                    } else {
                        iIntValue = Integer.valueOf(IntOffset.k(jS) + i3).intValue();
                        iL = IntOffset.l(jS);
                    }
                    lazyLayoutItemAnimationE.J(IntOffset.f((((long) iIntValue) << 32) | (4294967295L & ((long) iL))));
                }
            }
        }
    }

    public final int b() {
        return this.f7543u;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public long c() {
        return this.f7537o;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int d() {
        return this.f7524b.size();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int e() {
        return this.f7540r;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void g(boolean z2) {
        this.f7544v = z2;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.f7523a;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.f7534l;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getOffset() {
        return this.f7538p;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public int getSize() {
        return this.f7539q;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean h() {
        return this.f7544v;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int i() {
        return this.f7541s;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean k() {
        return this.f7525c;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void l(int i3, int i4, int i5, int i6) {
        q(i3, i5, i6);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int m() {
        return this.f7542t;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object n(int i3) {
        return ((Placeable) this.f7524b.get(i3)).p();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public long o(int i3) {
        int[] iArr = this.f7548z;
        int i4 = i3 * 2;
        return IntOffset.f((((long) iArr[i4]) << 32) | (((long) iArr[i4 + 1]) & 4294967295L));
    }

    public final void p(Placeable.PlacementScope placementScope, boolean z2) {
        GraphicsLayer graphicsLayerP;
        Placeable.PlacementScope placementScope2;
        long jK;
        int i3 = 0;
        if (!(this.f7545w != Integer.MIN_VALUE)) {
            InlineClassHelperKt.a("position() should be called first");
        }
        int iD = d();
        while (i3 < iD) {
            Placeable placeable = (Placeable) this.f7524b.get(i3);
            int iJ = this.f7546x - j(placeable);
            int i4 = this.f7547y;
            long jO = o(i3);
            LazyLayoutItemAnimation lazyLayoutItemAnimationE = this.f7536n.e(getKey(), i3);
            if (lazyLayoutItemAnimationE != null) {
                if (z2) {
                    lazyLayoutItemAnimationE.F(jO);
                } else {
                    if (!IntOffset.j(lazyLayoutItemAnimationE.q(), LazyLayoutItemAnimation.f8022s.a())) {
                        jO = lazyLayoutItemAnimationE.q();
                    }
                    long jO2 = IntOffset.o(jO, lazyLayoutItemAnimationE.r());
                    if ((f(jO) <= iJ && f(jO2) <= iJ) || (f(jO) >= i4 && f(jO2) >= i4)) {
                        lazyLayoutItemAnimationE.n();
                    }
                    jO = jO2;
                }
                graphicsLayerP = lazyLayoutItemAnimationE.p();
            } else {
                graphicsLayerP = null;
            }
            if (this.f7529g) {
                if (k()) {
                    jK = (((long) ((this.f7545w - IntOffset.l(jO)) - j(placeable))) & 4294967295L) | (((long) IntOffset.k(jO)) << 32);
                } else {
                    jK = (((long) ((this.f7545w - IntOffset.k(jO)) - j(placeable))) << 32) | (4294967295L & ((long) IntOffset.l(jO)));
                }
                jO = IntOffset.f(jK);
            }
            long jO3 = IntOffset.o(jO, this.f7533k);
            if (!z2 && lazyLayoutItemAnimationE != null) {
                lazyLayoutItemAnimationE.E(jO3);
            }
            if (!k()) {
                placementScope2 = placementScope;
                GraphicsLayer graphicsLayer = graphicsLayerP;
                if (graphicsLayer != null) {
                    Placeable.PlacementScope.u(placementScope2, placeable, jO3, graphicsLayer, 0.0f, 4, null);
                } else {
                    Placeable.PlacementScope.t(placementScope2, placeable, jO3, 0.0f, null, 6, null);
                }
            } else if (graphicsLayerP != null) {
                placementScope2 = placementScope;
                Placeable.PlacementScope.A(placementScope2, placeable, jO3, graphicsLayerP, 0.0f, 4, null);
            } else {
                placementScope2 = placementScope;
                Placeable.PlacementScope.z(placementScope2, placeable, jO3, 0.0f, null, 6, null);
            }
            i3++;
            placementScope = placementScope2;
        }
    }

    public final void q(int i3, int i4, int i5) {
        int iX0;
        this.f7538p = i3;
        this.f7545w = k() ? i5 : i4;
        List list = this.f7524b;
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            Placeable placeable = (Placeable) list.get(i6);
            int i7 = i6 * 2;
            if (k()) {
                int[] iArr = this.f7548z;
                Alignment.Horizontal horizontal = this.f7526d;
                if (horizontal == null) {
                    InlineClassHelperKt.b("null horizontalAlignment when isVertical == true");
                    throw new KotlinNothingValueException();
                }
                iArr[i7] = horizontal.a(placeable.X0(), i4, this.f7528f);
                this.f7548z[i7 + 1] = i3;
                iX0 = placeable.O0();
            } else {
                int[] iArr2 = this.f7548z;
                iArr2[i7] = i3;
                int i8 = i7 + 1;
                Alignment.Vertical vertical = this.f7527e;
                if (vertical == null) {
                    InlineClassHelperKt.b("null verticalAlignment when isVertical == false");
                    throw new KotlinNothingValueException();
                }
                iArr2[i8] = vertical.a(placeable.O0(), i5);
                iX0 = placeable.X0();
            }
            i3 += iX0;
        }
        this.f7546x = -this.f7530h;
        this.f7547y = this.f7545w + this.f7531i;
    }

    public final void r(int i3) {
        this.f7545w = i3;
        this.f7547y = i3 + this.f7531i;
    }

    private LazyListMeasuredItem(int i3, List list, boolean z2, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z3, int i4, int i5, int i6, long j3, Object obj, Object obj2, LazyLayoutItemAnimator lazyLayoutItemAnimator, long j4) {
        this.f7523a = i3;
        this.f7524b = list;
        this.f7525c = z2;
        this.f7526d = horizontal;
        this.f7527e = vertical;
        this.f7528f = layoutDirection;
        this.f7529g = z3;
        this.f7530h = i4;
        this.f7531i = i5;
        this.f7532j = i6;
        this.f7533k = j3;
        this.f7534l = obj;
        this.f7535m = obj2;
        this.f7536n = lazyLayoutItemAnimator;
        this.f7537o = j4;
        this.f7541s = 1;
        this.f7545w = Integer.MIN_VALUE;
        int size = list.size();
        int iO0 = 0;
        int iMax = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Placeable placeable = (Placeable) list.get(i7);
            iO0 += k() ? placeable.O0() : placeable.X0();
            iMax = Math.max(iMax, !k() ? placeable.O0() : placeable.X0());
        }
        this.f7539q = iO0;
        this.f7542t = RangesKt.f(getSize() + this.f7532j, 0);
        this.f7543u = iMax;
        this.f7548z = new int[this.f7524b.size() * 2];
    }
}
