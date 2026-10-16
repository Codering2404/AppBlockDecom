package androidx.compose.ui.spatial;

import android.os.Trace;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_androidKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class RectManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IntObjectMap f28580a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f28584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f28585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f28586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Object f28587h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectList f28581b = new RectList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ThrottledCallbacks f28582c = new ThrottledCallbacks();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableObjectList f28583d = new MutableObjectList(0, 1, null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f28588i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Function0 f28589j = new Function0<Unit>() { // from class: androidx.compose.ui.spatial.RectManager$dispatchLambda$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m259invoke();
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m259invoke() {
            this.f28594a.f28587h = null;
            RectManager rectManager = this.f28594a;
            Trace.beginSection("OnPositionedDispatch");
            try {
                rectManager.d();
                Unit unit = Unit.f139807a;
            } finally {
                Trace.endSection();
            }
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableRect f28590k = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);

    public RectManager(IntObjectMap intObjectMap) {
        this.f28580a = intObjectMap;
    }

    private final void c(NodeCoordinator nodeCoordinator, MutableRect mutableRect) {
        while (nodeCoordinator != null) {
            OwnedLayer ownedLayerR2 = nodeCoordinator.R2();
            long jC1 = nodeCoordinator.C1();
            mutableRect.m(Offset.e((((long) Float.floatToRawIntBits(IntOffset.k(jC1))) << 32) | (((long) Float.floatToRawIntBits(IntOffset.l(jC1))) & 4294967295L)));
            nodeCoordinator = nodeCoordinator.Y2();
            if (ownedLayerR2 != null) {
                float[] fArrMo244getUnderlyingMatrixsQKQjiQ = ownedLayerR2.mo244getUnderlyingMatrixsQKQjiQ();
                if (!MatrixKt.a(fArrMo244getUnderlyingMatrixsQKQjiQ)) {
                    Matrix.g(fArrMo244getUnderlyingMatrixsQKQjiQ, mutableRect);
                }
            }
        }
    }

    private final void f(LayoutNode layoutNode, boolean z2, int i3, int i4, int i5, int i6) {
        int iV = layoutNode.v();
        if (z2 || !this.f28581b.g(iV, i3, i4, i5, i6)) {
            LayoutNode layoutNodeB0 = layoutNode.B0();
            RectList.e(this.f28581b, iV, i3, i4, i5, i6, layoutNodeB0 != null ? layoutNodeB0.v() : -1, false, false, 192, null);
        }
        i();
    }

    private final void g(LayoutNode layoutNode, long j3, boolean z2) {
        NodeCoordinator nodeCoordinatorX0 = layoutNode.x0();
        MeasurePassDelegate measurePassDelegateN0 = layoutNode.n0();
        int iS0 = measurePassDelegateN0.S0();
        int iQ0 = measurePassDelegateN0.Q0();
        MutableRect mutableRect = this.f28590k;
        mutableRect.g(IntOffset.k(j3), IntOffset.l(j3), IntOffset.k(j3) + iS0, IntOffset.l(j3) + iQ0);
        c(nodeCoordinatorX0, mutableRect);
        int iB = (int) mutableRect.b();
        int iD = (int) mutableRect.d();
        int iC = (int) mutableRect.c();
        int iA = (int) mutableRect.a();
        int iV = layoutNode.v();
        if (z2 || !this.f28581b.j(iV, iB, iD, iC, iA)) {
            LayoutNode layoutNodeB0 = layoutNode.B0();
            RectList.e(this.f28581b, iV, iB, iD, iC, iA, layoutNodeB0 != null ? layoutNodeB0.v() : -1, false, false, 192, null);
        }
        i();
    }

    private final void h(LayoutNode layoutNode) {
        MutableVector mutableVectorH0 = layoutNode.H0();
        Object[] objArr = mutableVectorH0.f24389a;
        int iO = mutableVectorH0.o();
        for (int i3 = 0; i3 < iO; i3++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i3];
            g(layoutNode2, layoutNode2.x0().C1(), false);
            h(layoutNode2);
        }
    }

    private final long m(LayoutNode layoutNode) {
        NodeCoordinator nodeCoordinatorX0 = layoutNode.x0();
        long jC = Offset.f25596b.c();
        NodeCoordinator nodeCoordinatorZ = layoutNode.Z();
        while (nodeCoordinatorZ != null && nodeCoordinatorZ != nodeCoordinatorX0) {
            OwnedLayer ownedLayerR2 = nodeCoordinatorZ.R2();
            jC = IntOffsetKt.c(jC, nodeCoordinatorZ.C1());
            nodeCoordinatorZ = nodeCoordinatorZ.Y2();
            if (ownedLayerR2 != null) {
                float[] fArrMo244getUnderlyingMatrixsQKQjiQ = ownedLayerR2.mo244getUnderlyingMatrixsQKQjiQ();
                int iC = RectManagerKt.c(fArrMo244getUnderlyingMatrixsQKQjiQ);
                if (iC == 3) {
                    continue;
                } else {
                    if ((iC & 2) == 0) {
                        return IntOffset.f29988b.a();
                    }
                    jC = Matrix.f(fArrMo244getUnderlyingMatrixsQKQjiQ, jC);
                }
            }
        }
        return IntOffsetKt.d(jC);
    }

    private final long n(NodeCoordinator nodeCoordinator) {
        long jC = Offset.f25596b.c();
        while (nodeCoordinator != null) {
            OwnedLayer ownedLayerR2 = nodeCoordinator.R2();
            jC = IntOffsetKt.c(jC, nodeCoordinator.C1());
            nodeCoordinator = nodeCoordinator.Y2();
            if (ownedLayerR2 != null) {
                float[] fArrMo244getUnderlyingMatrixsQKQjiQ = ownedLayerR2.mo244getUnderlyingMatrixsQKQjiQ();
                int iC = RectManagerKt.c(fArrMo244getUnderlyingMatrixsQKQjiQ);
                if (iC == 3) {
                    continue;
                } else {
                    if ((iC & 2) == 0) {
                        return IntOffset.f29988b.a();
                    }
                    jC = Matrix.f(fArrMo244getUnderlyingMatrixsQKQjiQ, jC);
                }
            }
        }
        return IntOffsetKt.d(jC);
    }

    public final void d() {
        long jB = Actual_androidKt.b();
        boolean z2 = this.f28584e;
        boolean z3 = z2 || this.f28585f;
        if (z2) {
            this.f28584e = false;
            MutableObjectList mutableObjectList = this.f28583d;
            Object[] objArr = mutableObjectList.f3081a;
            int i3 = mutableObjectList.f3082b;
            for (int i4 = 0; i4 < i3; i4++) {
                ((Function0) objArr[i4]).invoke();
            }
            RectList rectList = this.f28581b;
            long[] jArr = rectList.f28570a;
            int i5 = rectList.f28572c;
            for (int i6 = 0; i6 < jArr.length - 2 && i6 < i5; i6 += 3) {
                long j3 = jArr[i6 + 2];
                if ((((int) (j3 >> 61)) & 1) != 0) {
                    this.f28582c.g(67108863 & ((int) j3), jArr[i6], jArr[i6 + 1], jB);
                }
            }
            this.f28581b.a();
        }
        if (this.f28585f) {
            this.f28585f = false;
            this.f28582c.f(jB);
        }
        if (z3) {
            this.f28582c.e(jB);
        }
        if (this.f28586g) {
            this.f28586g = false;
            this.f28581b.b();
        }
        this.f28582c.r(jB);
    }

    public final RectList e() {
        return this.f28581b;
    }

    public final void i() {
        this.f28584e = true;
    }

    public final void j(LayoutNode layoutNode) {
        this.f28584e = true;
        this.f28581b.f(layoutNode.v());
        r(true);
    }

    public final void k(LayoutNode layoutNode) {
        if (ComposeUiFlags.f25102b) {
            long jM = m(layoutNode);
            if (!RectManagerKt.d(jM)) {
                h(layoutNode);
                return;
            }
            layoutNode.V1(jM);
            layoutNode.W1(false);
            MutableVector mutableVectorH0 = layoutNode.H0();
            Object[] objArr = mutableVectorH0.f24389a;
            int iO = mutableVectorH0.o();
            for (int i3 = 0; i3 < iO; i3++) {
                LayoutNode layoutNode2 = (LayoutNode) objArr[i3];
                l(layoutNode2, layoutNode2.x0().C1(), false);
            }
            j(layoutNode);
        }
    }

    public final void l(LayoutNode layoutNode, long j3, boolean z2) {
        long j4;
        long jN;
        long jM;
        if (ComposeUiFlags.f25102b) {
            MeasurePassDelegate measurePassDelegateN0 = layoutNode.n0();
            int iS0 = measurePassDelegateN0.S0();
            int iQ0 = measurePassDelegateN0.Q0();
            LayoutNode layoutNodeB0 = layoutNode.B0();
            long jV0 = layoutNode.v0();
            long jE0 = layoutNode.e0();
            int i3 = (int) (jE0 >> 32);
            int i4 = (int) (jE0 & 4294967295L);
            boolean z3 = false;
            if (layoutNodeB0 != null) {
                boolean zZ0 = layoutNodeB0.z0();
                long jV02 = layoutNodeB0.v0();
                long jY0 = layoutNodeB0.y0();
                if (RectManagerKt.d(jV02)) {
                    if (zZ0) {
                        j4 = 4294967295L;
                        jM = m(layoutNodeB0);
                        layoutNodeB0.V1(jM);
                        layoutNodeB0.W1(false);
                    } else {
                        j4 = 4294967295L;
                        jM = jY0;
                    }
                    z3 = !RectManagerKt.d(jM);
                    jN = IntOffset.o(IntOffset.o(jV02, jM), j3);
                } else {
                    j4 = 4294967295L;
                    jN = n(layoutNode.x0());
                }
            } else {
                j4 = 4294967295L;
                jN = j3;
            }
            if (z3 || !RectManagerKt.d(jN)) {
                g(layoutNode, j3, z2);
                return;
            }
            layoutNode.S1(jN);
            layoutNode.P1(IntSize.c((((long) iS0) << 32) | (((long) iQ0) & j4)));
            int iK = IntOffset.k(jN);
            int iL = IntOffset.l(jN);
            int i5 = iK + iS0;
            int i6 = iL + iQ0;
            if (!z2 && IntOffset.j(jN, jV0) && i3 == iS0 && i4 == iQ0) {
                return;
            }
            f(layoutNode, z2, iK, iL, i5, i6);
        }
    }

    public final Object o(Function0 function0) {
        this.f28583d.n(function0);
        return function0;
    }

    public final DelegatableNode.RegistrationHandle p(int i3, long j3, long j4, DelegatableNode delegatableNode, Function1 function1) {
        return this.f28582c.p(i3, j3, j4, delegatableNode, function1);
    }

    public final void q(LayoutNode layoutNode) {
        this.f28581b.h(layoutNode.v());
        i();
        this.f28586g = true;
    }

    public final void r(boolean z2) {
        boolean z3 = (z2 && this.f28587h == null) ? false : true;
        long jI = this.f28582c.i();
        if (jI >= 0 || !z3) {
            if (this.f28588i == jI && z3) {
                return;
            }
            Object obj = this.f28587h;
            if (obj != null) {
                Actual_androidKt.e(obj);
            }
            long jB = Actual_androidKt.b();
            long jMax = Math.max(jI, ((long) 16) + jB);
            this.f28588i = jMax;
            this.f28587h = Actual_androidKt.c(jMax - jB, this.f28589j);
        }
    }

    public final void s(Object obj) {
        if ((TypeIntrinsics.m(obj, 0) ? (Function0) obj : null) == null) {
            return;
        }
        this.f28583d.y(obj);
    }

    public final void t(long j3, long j4, float[] fArr) {
        int iC = RectManagerKt.c(fArr);
        ThrottledCallbacks throttledCallbacks = this.f28582c;
        if ((iC & 2) != 0) {
            fArr = null;
        }
        this.f28585f = throttledCallbacks.s(j3, j4, fArr) || this.f28585f;
    }
}
