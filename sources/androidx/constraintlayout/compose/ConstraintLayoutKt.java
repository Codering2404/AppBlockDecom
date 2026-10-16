package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class ConstraintLayoutKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f30437a = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstraintSet a(MutableState mutableState) {
        return (ConstraintSet) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MutableState mutableState, ConstraintSet constraintSet) {
        mutableState.setValue(constraintSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstraintSet c(MutableState mutableState) {
        return (ConstraintSet) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MutableState mutableState, ConstraintSet constraintSet) {
        mutableState.setValue(constraintSet);
    }

    public static final ConstraintSet e(String str) {
        return new JSONConstraintSet(str, null, null, 6, null);
    }

    public static final void l(State state, List list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            Measurable measurable = (Measurable) list.get(i3);
            Object objA = LayoutIdKt.a(measurable);
            if (objA == null && (objA = ConstraintLayoutTagKt.a(measurable)) == null) {
                objA = m();
            }
            state.s(objA.toString(), measurable);
            Object objB = ConstraintLayoutTagKt.b(measurable);
            if (objB != null && (objB instanceof String) && (objA instanceof String)) {
                state.A((String) objA, (String) objB);
            }
        }
    }

    public static final Object m() {
        return new Object() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$createId$1
        };
    }

    public static final void n(Placeable.PlacementScope placementScope, Placeable placeable, final WidgetFrame widgetFrame, long j3) {
        if (widgetFrame.f32167r != 8) {
            if (widgetFrame.n()) {
                Placeable.PlacementScope.k(placementScope, placeable, IntOffsetKt.a(widgetFrame.f32151b - IntOffset.k(j3), widgetFrame.f32152c - IntOffset.l(j3)), 0.0f, 2, null);
                return;
            } else {
                placementScope.v(placeable, widgetFrame.f32151b - IntOffset.k(j3), widgetFrame.f32152c - IntOffset.l(j3), Float.isNaN(widgetFrame.f32162m) ? 0.0f : widgetFrame.f32162m, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$placeWithFrameTransform$layerBlock$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        if (!Float.isNaN(widgetFrame.f32155f) || !Float.isNaN(widgetFrame.f32156g)) {
                            graphicsLayerScope.A0(TransformOriginKt.a(Float.isNaN(widgetFrame.f32155f) ? 0.5f : widgetFrame.f32155f, Float.isNaN(widgetFrame.f32156g) ? 0.5f : widgetFrame.f32156g));
                        }
                        if (!Float.isNaN(widgetFrame.f32157h)) {
                            graphicsLayerScope.h(widgetFrame.f32157h);
                        }
                        if (!Float.isNaN(widgetFrame.f32158i)) {
                            graphicsLayerScope.i(widgetFrame.f32158i);
                        }
                        if (!Float.isNaN(widgetFrame.f32159j)) {
                            graphicsLayerScope.j(widgetFrame.f32159j);
                        }
                        if (!Float.isNaN(widgetFrame.f32160k)) {
                            graphicsLayerScope.l(widgetFrame.f32160k);
                        }
                        if (!Float.isNaN(widgetFrame.f32161l)) {
                            graphicsLayerScope.d(widgetFrame.f32161l);
                        }
                        if (!Float.isNaN(widgetFrame.f32162m)) {
                            graphicsLayerScope.E(widgetFrame.f32162m);
                        }
                        if (!Float.isNaN(widgetFrame.f32163n) || !Float.isNaN(widgetFrame.f32164o)) {
                            graphicsLayerScope.e(Float.isNaN(widgetFrame.f32163n) ? 1.0f : widgetFrame.f32163n);
                            graphicsLayerScope.k(Float.isNaN(widgetFrame.f32164o) ? 1.0f : widgetFrame.f32164o);
                        }
                        if (Float.isNaN(widgetFrame.f32165p)) {
                            return;
                        }
                        graphicsLayerScope.c(widgetFrame.f32165p);
                    }
                });
                return;
            }
        }
        if (f30437a) {
            Log.d("CCL", "Widget: " + widgetFrame.i() + " is Gone. Skipping placement.");
        }
    }

    public static /* synthetic */ void o(Placeable.PlacementScope placementScope, Placeable placeable, WidgetFrame widgetFrame, long j3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            j3 = IntOffset.f29988b.b();
        }
        n(placementScope, placeable, widgetFrame, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String p(ConstraintWidget constraintWidget) {
        return constraintWidget.v() + " width " + constraintWidget.a0() + " minWidth " + constraintWidget.L() + " maxWidth " + constraintWidget.J() + " height " + constraintWidget.z() + " minHeight " + constraintWidget.K() + " maxHeight " + constraintWidget.I() + " HDB " + constraintWidget.C() + " VDB " + constraintWidget.X() + " MCW " + constraintWidget.f32315w + " MCH " + constraintWidget.f32317x + " percentW " + constraintWidget.B + " percentH " + constraintWidget.E;
    }
}
