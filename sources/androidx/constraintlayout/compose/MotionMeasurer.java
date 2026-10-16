package androidx.constraintlayout.compose;

import android.graphics.Matrix;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.state.CorePixelDp;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class MotionMeasurer extends Measurer {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f30896l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f30897m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final androidx.constraintlayout.core.state.Transition f30898n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Constraints f30899o;

    public MotionMeasurer(final Density density) {
        super(density);
        this.f30898n = new androidx.constraintlayout.core.state.Transition(new CorePixelDp() { // from class: androidx.constraintlayout.compose.b
            @Override // androidx.constraintlayout.core.state.CorePixelDp
            public final float a(float f3) {
                return MotionMeasurer.M(density, f3);
            }
        });
    }

    private final void C(DrawScope drawScope, WidgetFrame widgetFrame, PathEffect pathEffect, long j3) {
        if (widgetFrame.n()) {
            DrawScope.L1(drawScope, j3, OffsetKt.a(widgetFrame.f32151b, widgetFrame.f32152c), SizeKt.a(widgetFrame.y(), widgetFrame.k()), 0.0f, new Stroke(3.0f, 0.0f, 0, 0, pathEffect, 14, null), null, 0, 104, null);
            return;
        }
        Matrix matrix = new Matrix();
        if (!Float.isNaN(widgetFrame.f32159j)) {
            matrix.preRotate(widgetFrame.f32159j, widgetFrame.e(), widgetFrame.f());
        }
        matrix.preScale(Float.isNaN(widgetFrame.f32163n) ? 1.0f : widgetFrame.f32163n, Float.isNaN(widgetFrame.f32164o) ? 1.0f : widgetFrame.f32164o, widgetFrame.e(), widgetFrame.f());
        int i3 = widgetFrame.f32151b;
        int i4 = widgetFrame.f32152c;
        int i5 = widgetFrame.f32153d;
        int i6 = widgetFrame.f32154e;
        float[] fArr = {i3, i4, i5, i4, i5, i6, i3, i6};
        matrix.mapPoints(fArr);
        DrawScope.L0(drawScope, j3, OffsetKt.a(fArr[0], fArr[1]), OffsetKt.a(fArr[2], fArr[3]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
        DrawScope.L0(drawScope, j3, OffsetKt.a(fArr[2], fArr[3]), OffsetKt.a(fArr[4], fArr[5]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
        DrawScope.L0(drawScope, j3, OffsetKt.a(fArr[4], fArr[5]), OffsetKt.a(fArr[6], fArr[7]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
        DrawScope.L0(drawScope, j3, OffsetKt.a(fArr[6], fArr[7]), OffsetKt.a(fArr[0], fArr[1]), 3.0f, 0, pathEffect, 0.0f, null, 0, 464, null);
    }

    private final void D(DrawScope drawScope, float f3, float f4, WidgetFrame widgetFrame, boolean z2, boolean z3) {
        new MotionRenderDebug(23.0f).a(AndroidCanvas_androidKt.d(drawScope.Q1().g()), this.f30898n.y(widgetFrame.f32150a.f32299o), 1000, (int) f3, (int) f4, z2, z3);
    }

    private final void E(StringBuilder sb, float[] fArr, int[] iArr, int[] iArr2, int i3) {
        if (i3 == 0) {
            return;
        }
        sb.append("keyTypes : [");
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(' ');
            sb2.append(i5);
            sb2.append(',');
            sb.append(sb2.toString());
        }
        sb.append("],\n");
        sb.append("keyPos : [");
        int i6 = i3 * 2;
        for (int i7 = 0; i7 < i6; i7++) {
            float f3 = fArr[i7];
            StringBuilder sb3 = new StringBuilder();
            sb3.append(' ');
            sb3.append(f3);
            sb3.append(',');
            sb.append(sb3.toString());
        }
        sb.append("],\n ");
        sb.append("keyFrames : [");
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = iArr2[i8];
            StringBuilder sb4 = new StringBuilder();
            sb4.append(' ');
            sb4.append(i9);
            sb4.append(',');
            sb.append(sb4.toString());
        }
        sb.append("],\n ");
    }

    private final void I(int i3, ConstraintSet constraintSet, List list, long j3) {
        String string;
        Object objA;
        s().u();
        constraintSet.a(s(), list);
        ConstraintLayoutKt.l(s(), list);
        s().a(r());
        ArrayList arrayListZ1 = r().z1();
        int size = arrayListZ1.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((ConstraintWidget) arrayListZ1.get(i4)).G0(true);
        }
        d(j3);
        r().j2();
        if (this.f30896l) {
            r().J0("ConstraintLayout");
            ArrayList arrayListZ12 = r().z1();
            int size2 = arrayListZ12.size();
            for (int i5 = 0; i5 < size2; i5++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) arrayListZ12.get(i5);
                Object objU = constraintWidget.u();
                Measurable measurable = objU instanceof Measurable ? (Measurable) objU : null;
                if (measurable == null || (objA = LayoutIdKt.a(measurable)) == null || (string = objA.toString()) == null) {
                    string = "NOTAG";
                }
                constraintWidget.J0(string);
            }
        }
        r().f2(i3);
        r().a2(0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    private final boolean J(long j3, CompositionSource compositionSource, ShouldInvalidateCallback shouldInvalidateCallback) {
        if (this.f30898n.H() || m().isEmpty()) {
            return true;
        }
        Constraints constraints = this.f30899o;
        if (constraints != null && shouldInvalidateCallback != null) {
            Intrinsics.checkNotNull(constraints);
            if (shouldInvalidateCallback.a(constraints.r(), j3)) {
                return true;
            }
        } else if ((Constraints.i(j3) && !s().v(Constraints.k(j3))) || (Constraints.j(j3) && !s().w(Constraints.l(j3)))) {
            return true;
        }
        return compositionSource == CompositionSource.Content;
    }

    private final void L(long j3, LayoutDirection layoutDirection, ConstraintSet constraintSet, ConstraintSet constraintSet2, TransitionImpl transitionImpl, List list, int i3, float f3, boolean z2) {
        WidgetFrame widgetFrameT;
        this.f30897m = f3;
        int i4 = 0;
        if (z2) {
            this.f30898n.m();
            y();
            s().E(Constraints.j(j3) ? androidx.constraintlayout.core.state.Dimension.b(Constraints.l(j3)) : androidx.constraintlayout.core.state.Dimension.h().o(Constraints.n(j3)));
            s().m(Constraints.i(j3) ? androidx.constraintlayout.core.state.Dimension.b(Constraints.k(j3)) : androidx.constraintlayout.core.state.Dimension.h().o(Constraints.m(j3)));
            s().I(j3);
            s().z(layoutDirection == LayoutDirection.f30002b);
            I(i3, constraintSet, list, j3);
            this.f30898n.N(r(), 0);
            I(i3, constraintSet2, list, j3);
            this.f30898n.N(r(), 1);
            if (transitionImpl != null) {
                transitionImpl.e(this.f30898n);
            }
        } else {
            ConstraintLayoutKt.l(s(), list);
        }
        this.f30898n.G(r().a0(), r().z(), f3);
        r().r1(this.f30898n.w());
        r().S0(this.f30898n.v());
        ArrayList arrayListZ1 = r().z1();
        int size = arrayListZ1.size();
        while (true) {
            if (i4 >= size) {
                break;
            }
            ConstraintWidget constraintWidget = (ConstraintWidget) arrayListZ1.get(i4);
            Object objU = constraintWidget.u();
            Measurable measurable = objU instanceof Measurable ? (Measurable) objU : null;
            if (measurable != null && (widgetFrameT = this.f30898n.t(constraintWidget)) != null) {
                q().put(measurable, measurable.n0(Constraints.f29963b.c(widgetFrameT.y(), widgetFrameT.k())));
                m().put(measurable, widgetFrameT);
            }
            i4++;
        }
        LayoutInformationReceiver layoutInformationReceiverP = p();
        if ((layoutInformationReceiverP != null ? layoutInformationReceiverP.j() : null) == LayoutInfoFlags.BOUNDS) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float M(Density density, float f3) {
        return density.M1(Dp.g(f3));
    }

    public final void A() {
        this.f30898n.m();
        m().clear();
    }

    public final void B(DrawScope drawScope, boolean z2, boolean z3, boolean z4) {
        WidgetFrame widgetFrame;
        PathEffect pathEffect;
        PathEffect pathEffectA = PathEffect.f25832a.a(new float[]{10.0f, 10.0f}, 0.0f);
        ArrayList arrayListZ1 = r().z1();
        int size = arrayListZ1.size();
        int i3 = 0;
        while (i3 < size) {
            ConstraintWidget constraintWidget = (ConstraintWidget) arrayListZ1.get(i3);
            WidgetFrame widgetFrameA = this.f30898n.A(constraintWidget);
            WidgetFrame widgetFrameR = this.f30898n.r(constraintWidget);
            if (z2) {
                Color.Companion companion = Color.f25715b;
                C(drawScope, widgetFrameA, pathEffectA, companion.b());
                C(drawScope, widgetFrameR, pathEffectA, companion.b());
                drawScope.Q1().e().e(2.0f, 2.0f);
                try {
                    C(drawScope, widgetFrameA, pathEffectA, companion.l());
                    widgetFrame = widgetFrameA;
                    C(drawScope, widgetFrameR, pathEffectA, companion.l());
                    pathEffect = pathEffectA;
                } finally {
                    drawScope.Q1().e().e(-2.0f, -2.0f);
                }
            } else {
                widgetFrame = widgetFrameA;
                pathEffect = pathEffectA;
            }
            D(drawScope, Size.i(drawScope.b()), Size.g(drawScope.b()), widgetFrame, z3, z4);
            i3++;
            pathEffectA = pathEffect;
        }
    }

    public final void F(StringBuilder sb) {
        sb.append("  root: {");
        sb.append("interpolated: { left:  0,");
        sb.append("  top:  0,");
        sb.append("  right:   " + r().a0() + " ,");
        sb.append("  bottom:  " + r().z() + " ,");
        sb.append(" } }");
    }

    public final androidx.constraintlayout.core.state.Transition G() {
        return this.f30898n;
    }

    public final void H(ConstraintSet constraintSet, ConstraintSet constraintSet2, LayoutDirection layoutDirection, TransitionImpl transitionImpl, float f3) {
        A();
        s().z(layoutDirection == LayoutDirection.f30002b);
        constraintSet.a(s(), CollectionsKt.emptyList());
        constraintSet.h(this.f30898n, 0);
        s().a(r());
        this.f30898n.N(r(), 0);
        constraintSet.a(s(), CollectionsKt.emptyList());
        constraintSet2.h(this.f30898n, 1);
        s().a(r());
        this.f30898n.N(r(), 1);
        this.f30898n.G(0, 0, f3);
        transitionImpl.d(this.f30898n);
    }

    public final long K(long j3, LayoutDirection layoutDirection, ConstraintSet constraintSet, ConstraintSet constraintSet2, TransitionImpl transitionImpl, List list, int i3, float f3, CompositionSource compositionSource, ShouldInvalidateCallback shouldInvalidateCallback) {
        long j4;
        MotionMeasurer motionMeasurer;
        LayoutInformationReceiver layoutInformationReceiverP;
        LayoutInformationReceiver layoutInformationReceiverP2;
        boolean zJ = J(j3, compositionSource, shouldInvalidateCallback);
        if (this.f30897m != f3 || ((((layoutInformationReceiverP = p()) == null || layoutInformationReceiverP.p() != Integer.MIN_VALUE) && ((layoutInformationReceiverP2 = p()) == null || layoutInformationReceiverP2.g() != Integer.MIN_VALUE)) || zJ)) {
            j4 = j3;
            motionMeasurer = this;
            motionMeasurer.L(j4, layoutDirection, constraintSet, constraintSet2, transitionImpl, list, i3, f3, zJ);
        } else {
            j4 = j3;
            motionMeasurer = this;
        }
        motionMeasurer.f30899o = Constraints.a(j4);
        return IntSizeKt.a(r().a0(), r().z());
    }

    @Override // androidx.constraintlayout.compose.Measurer
    public void e() {
        MotionMeasurer motionMeasurer = this;
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        motionMeasurer.F(sb);
        int[] iArr = new int[50];
        int[] iArr2 = new int[50];
        float[] fArr = new float[100];
        ArrayList arrayListZ1 = motionMeasurer.r().z1();
        int size = arrayListZ1.size();
        int i3 = 0;
        while (i3 < size) {
            ConstraintWidget constraintWidget = (ConstraintWidget) arrayListZ1.get(i3);
            WidgetFrame widgetFrameB = motionMeasurer.f30898n.B(constraintWidget.f32299o);
            WidgetFrame widgetFrameS = motionMeasurer.f30898n.s(constraintWidget.f32299o);
            WidgetFrame widgetFrameU = motionMeasurer.f30898n.u(constraintWidget.f32299o);
            float[] fArrZ = motionMeasurer.f30898n.z(constraintWidget.f32299o);
            int iX = motionMeasurer.f30898n.x(constraintWidget.f32299o, fArr, iArr, iArr2);
            sb.append(' ' + constraintWidget.f32299o + ": {");
            sb.append(" interpolated : ");
            widgetFrameU.p(sb, true);
            sb.append(", start : ");
            widgetFrameB.o(sb);
            sb.append(", end : ");
            widgetFrameS.o(sb);
            motionMeasurer.E(sb, fArr, iArr, iArr2, iX);
            sb.append(" path : [");
            for (float f3 : fArrZ) {
                sb.append(' ' + f3 + " ,");
            }
            sb.append(" ] ");
            sb.append("}, ");
            i3++;
            motionMeasurer = this;
        }
        sb.append(" }");
        LayoutInformationReceiver layoutInformationReceiverP = p();
        if (layoutInformationReceiverP != null) {
            layoutInformationReceiverP.i(sb.toString());
        }
    }
}
