package androidx.compose.foundation;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

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
public abstract class RectListNode extends Modifier.Node implements GlobalPositionAwareModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function1 f5121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Rect f5122b;

    public RectListNode(Function1 function1) {
        this.f5121a = function1;
    }

    private final Rect m2(LayoutCoordinates layoutCoordinates, androidx.compose.ui.geometry.Rect rect) {
        LayoutCoordinates layoutCoordinatesD = LayoutCoordinatesKt.d(layoutCoordinates);
        long jS = layoutCoordinatesD.S(layoutCoordinates, rect.t());
        long jS2 = layoutCoordinatesD.S(layoutCoordinates, rect.u());
        long jS3 = layoutCoordinatesD.S(layoutCoordinates, rect.k());
        long jS4 = layoutCoordinatesD.S(layoutCoordinates, rect.l());
        int i3 = (int) (jS >> 32);
        int i4 = (int) (jS2 >> 32);
        int i5 = (int) (jS3 >> 32);
        int i6 = (int) (jS4 >> 32);
        int i7 = (int) (jS & 4294967295L);
        int i8 = (int) (jS2 & 4294967295L);
        int i9 = (int) (jS3 & 4294967295L);
        int i10 = (int) (jS4 & 4294967295L);
        return new Rect(MathKt.d(ComparisonsKt.l(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4), Float.intBitsToFloat(i5), Float.intBitsToFloat(i6))), MathKt.d(ComparisonsKt.l(Float.intBitsToFloat(i7), Float.intBitsToFloat(i8), Float.intBitsToFloat(i9), Float.intBitsToFloat(i10))), MathKt.d(ComparisonsKt.i(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4), Float.intBitsToFloat(i5), Float.intBitsToFloat(i6))), MathKt.d(ComparisonsKt.i(Float.intBitsToFloat(i7), Float.intBitsToFloat(i8), Float.intBitsToFloat(i9), Float.intBitsToFloat(i10))));
    }

    private final void q2(Rect rect) {
        MutableVector mutableVectorN2 = n2();
        Rect rect2 = this.f5122b;
        if (rect2 != null) {
            mutableVectorN2.s(rect2);
        }
        if (rect != null && !rect.isEmpty()) {
            mutableVectorN2.b(rect);
        }
        s2(mutableVectorN2);
        this.f5122b = rect;
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void I(LayoutCoordinates layoutCoordinates) {
        Rect rectM2;
        if (o2() == null) {
            androidx.compose.ui.geometry.Rect rectB = LayoutCoordinatesKt.b(layoutCoordinates);
            rectM2 = new Rect(MathKt.d(rectB.o()), MathKt.d(rectB.r()), MathKt.d(rectB.p()), MathKt.d(rectB.i()));
        } else {
            Function1 function1O2 = o2();
            Intrinsics.checkNotNull(function1O2);
            rectM2 = m2(layoutCoordinates, (androidx.compose.ui.geometry.Rect) function1O2.invoke(layoutCoordinates));
        }
        q2(rectM2);
    }

    public abstract MutableVector n2();

    public Function1 o2() {
        return this.f5121a;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        q2(null);
    }

    protected final View p2() {
        return DelegatableNode_androidKt.a(this);
    }

    public void r2(Function1 function1) {
        this.f5121a = function1;
    }

    public abstract void s2(MutableVector mutableVector);
}
