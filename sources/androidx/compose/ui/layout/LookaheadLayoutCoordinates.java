package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class LookaheadLayoutCoordinates implements LayoutCoordinates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LookaheadDelegate f27147a;

    public LookaheadLayoutCoordinates(LookaheadDelegate lookaheadDelegate) {
        this.f27147a = lookaheadDelegate;
    }

    private final long c() {
        LookaheadDelegate lookaheadDelegateA = LookaheadLayoutCoordinatesKt.a(this.f27147a);
        LayoutCoordinates layoutCoordinatesU1 = lookaheadDelegateA.u1();
        Offset.Companion companion = Offset.f25596b;
        return Offset.p(S(layoutCoordinatesU1, companion.c()), b().S(lookaheadDelegateA.s2(), companion.c()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long H(long j3) {
        return b().H(Offset.q(j3, c()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean O() {
        return this.f27147a.R1();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long Q(LayoutCoordinates layoutCoordinates, long j3, boolean z2) {
        if (!(layoutCoordinates instanceof LookaheadLayoutCoordinates)) {
            LookaheadDelegate lookaheadDelegateA = LookaheadLayoutCoordinatesKt.a(this.f27147a);
            long jQ = Q(lookaheadDelegateA.t2(), j3, z2);
            long jC1 = lookaheadDelegateA.C1();
            float fK = IntOffset.k(jC1);
            long jP = Offset.p(jQ, Offset.e((4294967295L & ((long) Float.floatToRawIntBits(IntOffset.l(jC1)))) | (Float.floatToRawIntBits(fK) << 32)));
            LayoutCoordinates layoutCoordinatesT = lookaheadDelegateA.s2().T();
            if (layoutCoordinatesT == null) {
                layoutCoordinatesT = lookaheadDelegateA.s2().u1();
            }
            return Offset.q(jP, layoutCoordinatesT.Q(layoutCoordinates, Offset.f25596b.c(), z2));
        }
        LookaheadDelegate lookaheadDelegate = ((LookaheadLayoutCoordinates) layoutCoordinates).f27147a;
        lookaheadDelegate.s2().n3();
        LookaheadDelegate lookaheadDelegateS2 = b().I2(lookaheadDelegate.s2()).S2();
        if (lookaheadDelegateS2 != null) {
            long jN = IntOffset.n(IntOffset.o(lookaheadDelegate.y2(lookaheadDelegateS2, !z2), IntOffsetKt.d(j3)), this.f27147a.y2(lookaheadDelegateS2, !z2));
            return Offset.e((((long) Float.floatToRawIntBits(IntOffset.k(jN))) << 32) | (((long) Float.floatToRawIntBits(IntOffset.l(jN))) & 4294967295L));
        }
        LookaheadDelegate lookaheadDelegateA2 = LookaheadLayoutCoordinatesKt.a(lookaheadDelegate);
        long jO = IntOffset.o(IntOffset.o(lookaheadDelegate.y2(lookaheadDelegateA2, !z2), lookaheadDelegateA2.C1()), IntOffsetKt.d(j3));
        LookaheadDelegate lookaheadDelegateA3 = LookaheadLayoutCoordinatesKt.a(this.f27147a);
        long jN2 = IntOffset.n(jO, IntOffset.o(this.f27147a.y2(lookaheadDelegateA3, !z2), lookaheadDelegateA3.C1()));
        float fK2 = IntOffset.k(jN2);
        long jE = Offset.e((((long) Float.floatToRawIntBits(IntOffset.l(jN2))) & 4294967295L) | (Float.floatToRawIntBits(fK2) << 32));
        NodeCoordinator nodeCoordinatorY2 = lookaheadDelegateA3.s2().Y2();
        Intrinsics.checkNotNull(nodeCoordinatorY2);
        NodeCoordinator nodeCoordinatorY22 = lookaheadDelegateA2.s2().Y2();
        Intrinsics.checkNotNull(nodeCoordinatorY22);
        return nodeCoordinatorY2.Q(nodeCoordinatorY22, jE, z2);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long S(LayoutCoordinates layoutCoordinates, long j3) {
        return Q(layoutCoordinates, j3, true);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public LayoutCoordinates T() {
        LookaheadDelegate lookaheadDelegateS2;
        if (!m()) {
            InlineClassHelperKt.c("LayoutCoordinate operations are only valid when isAttached is true");
        }
        NodeCoordinator nodeCoordinatorY2 = b().Y2();
        if (nodeCoordinatorY2 == null || (lookaheadDelegateS2 = nodeCoordinatorY2.S2()) == null) {
            return null;
        }
        return lookaheadDelegateS2.u1();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long X(long j3) {
        return Offset.q(b().X(j3), c());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public void Y(LayoutCoordinates layoutCoordinates, float[] fArr) {
        b().Y(layoutCoordinates, fArr);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long a() {
        LookaheadDelegate lookaheadDelegate = this.f27147a;
        return IntSize.c((((long) lookaheadDelegate.X0()) << 32) | (((long) lookaheadDelegate.O0()) & 4294967295L));
    }

    public final NodeCoordinator b() {
        return this.f27147a.s2();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long f0(long j3) {
        return b().f0(Offset.q(j3, c()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public void i0(float[] fArr) {
        b().i0(fArr);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public Rect j0(LayoutCoordinates layoutCoordinates, boolean z2) {
        return b().j0(layoutCoordinates, z2);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public boolean m() {
        return b().m();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public LayoutCoordinates r0() {
        LookaheadDelegate lookaheadDelegateS2;
        if (!m()) {
            InlineClassHelperKt.c("LayoutCoordinate operations are only valid when isAttached is true");
        }
        NodeCoordinator nodeCoordinatorY2 = b().X1().x0().Y2();
        if (nodeCoordinatorY2 == null || (lookaheadDelegateS2 = nodeCoordinatorY2.S2()) == null) {
            return null;
        }
        return lookaheadDelegateS2.u1();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long x(long j3) {
        return Offset.q(b().x(j3), c());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public long x0(long j3) {
        return b().x0(Offset.q(j3, c()));
    }
}
