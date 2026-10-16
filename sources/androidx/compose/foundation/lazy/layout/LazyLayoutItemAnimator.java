package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LazyLayoutItemAnimator<T extends LazyLayoutMeasuredItem> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LazyLayoutKeyIndexMap f8076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8077c;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private DrawModifierNode f8084j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableScatterMap f8075a = ScatterMapKt.c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableScatterSet f8078d = ScatterSetKt.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f8079e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f8080f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f8081g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f8082h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f8083i = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Modifier f8085k = new DisplayingDisappearingItemsElement(this);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class DisplayingDisappearingItemsElement extends ModifierNodeElement<DisplayingDisappearingItemsNode> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LazyLayoutItemAnimator f8086a;

        public DisplayingDisappearingItemsElement(LazyLayoutItemAnimator lazyLayoutItemAnimator) {
            this.f8086a = lazyLayoutItemAnimator;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DisplayingDisappearingItemsNode create() {
            return new DisplayingDisappearingItemsNode(this.f8086a);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void update(DisplayingDisappearingItemsNode displayingDisappearingItemsNode) {
            displayingDisappearingItemsNode.m2(this.f8086a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DisplayingDisappearingItemsElement) && Intrinsics.areEqual(this.f8086a, ((DisplayingDisappearingItemsElement) obj).f8086a);
        }

        public int hashCode() {
            return this.f8086a.hashCode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.d("DisplayingDisappearingItemsElement");
        }

        public String toString() {
            return "DisplayingDisappearingItemsElement(animator=" + this.f8086a + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class DisplayingDisappearingItemsNode extends Modifier.Node implements DrawModifierNode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LazyLayoutItemAnimator f8087a;

        public DisplayingDisappearingItemsNode(LazyLayoutItemAnimator lazyLayoutItemAnimator) {
            this.f8087a = lazyLayoutItemAnimator;
        }

        @Override // androidx.compose.ui.node.DrawModifierNode
        public void draw(ContentDrawScope contentDrawScope) {
            List list = this.f8087a.f8083i;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimation = (LazyLayoutItemAnimation) list.get(i3);
                GraphicsLayer graphicsLayerP = lazyLayoutItemAnimation.p();
                if (graphicsLayerP != null) {
                    float fK = IntOffset.k(lazyLayoutItemAnimation.o());
                    float fK2 = fK - IntOffset.k(graphicsLayerP.y());
                    float fL = IntOffset.l(lazyLayoutItemAnimation.o()) - IntOffset.l(graphicsLayerP.y());
                    contentDrawScope.Q1().e().e(fK2, fL);
                    try {
                        GraphicsLayerKt.a(contentDrawScope, graphicsLayerP);
                    } finally {
                        contentDrawScope.Q1().e().e(-fK2, -fL);
                    }
                }
            }
            contentDrawScope.i2();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DisplayingDisappearingItemsNode) && Intrinsics.areEqual(this.f8087a, ((DisplayingDisappearingItemsNode) obj).f8087a);
        }

        public int hashCode() {
            return this.f8087a.hashCode();
        }

        public final void m2(LazyLayoutItemAnimator lazyLayoutItemAnimator) {
            if (Intrinsics.areEqual(this.f8087a, lazyLayoutItemAnimator) || !getNode().isAttached()) {
                return;
            }
            this.f8087a.p();
            lazyLayoutItemAnimator.f8084j = this;
            this.f8087a = lazyLayoutItemAnimator;
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onAttach() {
            this.f8087a.f8084j = this;
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onDetach() {
            this.f8087a.p();
        }

        public String toString() {
            return "DisplayingDisappearingItemsNode(animator=" + this.f8087a + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class ItemInfo {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Constraints f8089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f8090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f8091d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f8093f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f8094g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LazyLayoutItemAnimation[] f8088a = LazyLayoutItemAnimatorKt.f8101a;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f8092e = 1;

        public ItemInfo() {
        }

        private final boolean h() {
            for (LazyLayoutItemAnimation lazyLayoutItemAnimation : this.f8088a) {
                if (lazyLayoutItemAnimation != null && lazyLayoutItemAnimation.x()) {
                    return true;
                }
            }
            return false;
        }

        public static /* synthetic */ void l(ItemInfo itemInfo, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, CoroutineScope coroutineScope, GraphicsContext graphicsContext, int i3, int i4, int i5, int i6, Object obj) {
            if ((i6 & 32) != 0) {
                i5 = LazyLayoutItemAnimator.this.f(lazyLayoutMeasuredItem);
            }
            itemInfo.k(lazyLayoutMeasuredItem, coroutineScope, graphicsContext, i3, i4, i5);
        }

        public final LazyLayoutItemAnimation[] a() {
            return this.f8088a;
        }

        public final Constraints b() {
            return this.f8089b;
        }

        public final int c() {
            return this.f8090c;
        }

        public final int d() {
            return this.f8091d;
        }

        public final int e() {
            return this.f8094g;
        }

        public final int f() {
            return this.f8093f;
        }

        public final int g() {
            return this.f8092e;
        }

        public final void i(int i3) {
            this.f8091d = i3;
        }

        public final void j(int i3) {
            this.f8092e = i3;
        }

        public final void k(LazyLayoutMeasuredItem lazyLayoutMeasuredItem, CoroutineScope coroutineScope, GraphicsContext graphicsContext, int i3, int i4, int i5) {
            if (!h()) {
                this.f8093f = i3;
                this.f8094g = i4;
            }
            int length = this.f8088a.length;
            for (int iD = lazyLayoutMeasuredItem.d(); iD < length; iD++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimation = this.f8088a[iD];
                if (lazyLayoutItemAnimation != null) {
                    lazyLayoutItemAnimation.y();
                }
            }
            if (this.f8088a.length != lazyLayoutMeasuredItem.d()) {
                Object[] objArrCopyOf = Arrays.copyOf(this.f8088a, lazyLayoutMeasuredItem.d());
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                this.f8088a = (LazyLayoutItemAnimation[]) objArrCopyOf;
            }
            this.f8089b = Constraints.a(lazyLayoutMeasuredItem.c());
            this.f8090c = i5;
            this.f8091d = lazyLayoutMeasuredItem.e();
            this.f8092e = lazyLayoutMeasuredItem.i();
            int iD2 = lazyLayoutMeasuredItem.d();
            final LazyLayoutItemAnimator lazyLayoutItemAnimator = LazyLayoutItemAnimator.this;
            for (int i6 = 0; i6 < iD2; i6++) {
                LazyLayoutAnimationSpecsNode lazyLayoutAnimationSpecsNodeC = LazyLayoutItemAnimatorKt.c(lazyLayoutMeasuredItem.n(i6));
                if (lazyLayoutAnimationSpecsNodeC == null) {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation2 = this.f8088a[i6];
                    if (lazyLayoutItemAnimation2 != null) {
                        lazyLayoutItemAnimation2.y();
                    }
                    this.f8088a[i6] = null;
                } else {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation3 = this.f8088a[i6];
                    if (lazyLayoutItemAnimation3 == null) {
                        lazyLayoutItemAnimation3 = new LazyLayoutItemAnimation(coroutineScope, graphicsContext, new Function0<Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo$updateAnimation$1$animation$1
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m49invoke() {
                                DrawModifierNode drawModifierNode = lazyLayoutItemAnimator.f8084j;
                                if (drawModifierNode != null) {
                                    DrawModifierNodeKt.a(drawModifierNode);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m49invoke();
                                return Unit.f139807a;
                            }
                        });
                        this.f8088a[i6] = lazyLayoutItemAnimation3;
                    }
                    lazyLayoutItemAnimation3.C(lazyLayoutAnimationSpecsNodeC.m2());
                    lazyLayoutItemAnimation3.I(lazyLayoutAnimationSpecsNodeC.o2());
                    lazyLayoutItemAnimation3.D(lazyLayoutAnimationSpecsNodeC.n2());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int f(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long jO = lazyLayoutMeasuredItem.o(0);
        return !lazyLayoutMeasuredItem.k() ? IntOffset.l(jO) : IntOffset.k(jO);
    }

    private final boolean g(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        int iD = lazyLayoutMeasuredItem.d();
        for (int i3 = 0; i3 < iD; i3++) {
            if (LazyLayoutItemAnimatorKt.c(lazyLayoutMeasuredItem.n(i3)) != null) {
                return true;
            }
        }
        return false;
    }

    private final int h(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long jO = lazyLayoutMeasuredItem.o(0);
        return lazyLayoutMeasuredItem.k() ? IntOffset.l(jO) : IntOffset.k(jO);
    }

    private final void k(LazyLayoutMeasuredItem lazyLayoutMeasuredItem, int i3, ItemInfo itemInfo) {
        int i4 = 0;
        long jO = lazyLayoutMeasuredItem.o(0);
        long jH = lazyLayoutMeasuredItem.k() ? IntOffset.h(jO, 0, i3, 1, null) : IntOffset.h(jO, i3, 0, 2, null);
        LazyLayoutItemAnimation[] lazyLayoutItemAnimationArrA = itemInfo.a();
        int length = lazyLayoutItemAnimationArrA.length;
        int i5 = 0;
        while (i4 < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = lazyLayoutItemAnimationArrA[i4];
            int i6 = i5 + 1;
            if (lazyLayoutItemAnimation != null) {
                lazyLayoutItemAnimation.J(IntOffset.o(jH, IntOffset.n(lazyLayoutMeasuredItem.o(i5), jO)));
            }
            i4++;
            i5 = i6;
        }
    }

    static /* synthetic */ void l(LazyLayoutItemAnimator lazyLayoutItemAnimator, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, int i3, ItemInfo itemInfo, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            Object objE = lazyLayoutItemAnimator.f8075a.e(lazyLayoutMeasuredItem.getKey());
            Intrinsics.checkNotNull(objE);
            itemInfo = (ItemInfo) objE;
        }
        lazyLayoutItemAnimator.k(lazyLayoutMeasuredItem, i3, itemInfo);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void n() {
        /*
            r14 = this;
            androidx.collection.MutableScatterMap r0 = r14.f8075a
            boolean r0 = r0.i()
            if (r0 == 0) goto L63
            androidx.collection.MutableScatterMap r0 = r14.f8075a
            java.lang.Object[] r1 = r0.f3110c
            long[] r0 = r0.f3108a
            int r2 = r0.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L5e
            r3 = 0
            r4 = r3
        L15:
            r5 = r0[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L59
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L2f:
            if (r9 >= r7) goto L57
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L53
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo r10 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo) r10
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation[] r10 = r10.a()
            int r11 = r10.length
            r12 = r3
        L47:
            if (r12 >= r11) goto L53
            r13 = r10[r12]
            if (r13 == 0) goto L50
            r13.y()
        L50:
            int r12 = r12 + 1
            goto L47
        L53:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L2f
        L57:
            if (r7 != r8) goto L5e
        L59:
            if (r4 == r2) goto L5e
            int r4 = r4 + 1
            goto L15
        L5e:
            androidx.collection.MutableScatterMap r0 = r14.f8075a
            r0.k()
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.n():void");
    }

    private final void o(Object obj) {
        LazyLayoutItemAnimation[] lazyLayoutItemAnimationArrA;
        ItemInfo itemInfo = (ItemInfo) this.f8075a.u(obj);
        if (itemInfo == null || (lazyLayoutItemAnimationArrA = itemInfo.a()) == null) {
            return;
        }
        for (LazyLayoutItemAnimation lazyLayoutItemAnimation : lazyLayoutItemAnimationArrA) {
            if (lazyLayoutItemAnimation != null) {
                lazyLayoutItemAnimation.y();
            }
        }
    }

    private final void q(LazyLayoutMeasuredItem lazyLayoutMeasuredItem, boolean z2) {
        Object objE = this.f8075a.e(lazyLayoutMeasuredItem.getKey());
        Intrinsics.checkNotNull(objE);
        LazyLayoutItemAnimation[] lazyLayoutItemAnimationArrA = ((ItemInfo) objE).a();
        int length = lazyLayoutItemAnimationArrA.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = lazyLayoutItemAnimationArrA[i3];
            int i5 = i4 + 1;
            if (lazyLayoutItemAnimation != null) {
                long jO = lazyLayoutMeasuredItem.o(i4);
                long jS = lazyLayoutItemAnimation.s();
                if (!IntOffset.j(jS, LazyLayoutItemAnimation.f8022s.a()) && !IntOffset.j(jS, jO)) {
                    lazyLayoutItemAnimation.m(IntOffset.n(jO, jS), z2);
                }
                lazyLayoutItemAnimation.J(jO);
            }
            i3++;
            i4 = i5;
        }
    }

    static /* synthetic */ void r(LazyLayoutItemAnimator lazyLayoutItemAnimator, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        lazyLayoutItemAnimator.q(lazyLayoutMeasuredItem, z2);
    }

    private final int s(int[] iArr, LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        int iE = lazyLayoutMeasuredItem.e();
        int i3 = lazyLayoutMeasuredItem.i() + iE;
        int iMax = 0;
        while (iE < i3) {
            int iM = iArr[iE] + lazyLayoutMeasuredItem.m();
            iArr[iE] = iM;
            iMax = Math.max(iMax, iM);
            iE++;
        }
        return iMax;
    }

    public final LazyLayoutItemAnimation e(Object obj, int i3) {
        LazyLayoutItemAnimation[] lazyLayoutItemAnimationArrA;
        ItemInfo itemInfo = (ItemInfo) this.f8075a.e(obj);
        if (itemInfo == null || (lazyLayoutItemAnimationArrA = itemInfo.a()) == null) {
            return null;
        }
        return lazyLayoutItemAnimationArrA[i3];
    }

    public final long i() {
        long jA = IntSize.f29998b.a();
        List list = this.f8083i;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = (LazyLayoutItemAnimation) list.get(i3);
            GraphicsLayer graphicsLayerP = lazyLayoutItemAnimation.p();
            if (graphicsLayerP != null) {
                int iMax = Math.max((int) (jA >> 32), IntOffset.k(lazyLayoutItemAnimation.s()) + ((int) (graphicsLayerP.x() >> 32)));
                jA = IntSize.c((((long) Math.max((int) (jA & 4294967295L), IntOffset.l(lazyLayoutItemAnimation.s()) + ((int) (graphicsLayerP.x() & 4294967295L)))) & 4294967295L) | (((long) iMax) << 32));
            }
        }
        return jA;
    }

    public final Modifier j() {
        return this.f8085k;
    }

    /* JADX WARN: Removed duplicated region for block: B:181:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m(int r44, int r45, int r46, java.util.List r47, final androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap r48, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider r49, boolean r50, boolean r51, int r52, boolean r53, int r54, int r55, kotlinx.coroutines.CoroutineScope r56, androidx.compose.ui.graphics.GraphicsContext r57) {
        /*
            Method dump skipped, instruction units count: 1375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.m(int, int, int, java.util.List, androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider, boolean, boolean, int, boolean, int, int, kotlinx.coroutines.CoroutineScope, androidx.compose.ui.graphics.GraphicsContext):void");
    }

    public final void p() {
        n();
        this.f8076b = null;
        this.f8077c = -1;
    }
}
