package androidx.compose.material.ripple;

import android.view.View;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class AndroidRippleNode extends RippleNode implements RippleHostKey {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private RippleContainer f15323m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private RippleHostView f15324n;

    public /* synthetic */ AndroidRippleNode(InteractionSource interactionSource, boolean z2, float f3, ColorProducer colorProducer, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, z2, f3, colorProducer, function0);
    }

    private final RippleContainer A2() {
        RippleContainer rippleContainer = this.f15323m;
        if (rippleContainer != null) {
            Intrinsics.checkNotNull(rippleContainer);
            return rippleContainer;
        }
        RippleContainer rippleContainerC = Ripple_androidKt.c(Ripple_androidKt.e((View) CompositionLocalConsumerModifierNodeKt.a(this, AndroidCompositionLocals_androidKt.j())));
        this.f15323m = rippleContainerC;
        Intrinsics.checkNotNull(rippleContainerC);
        return rippleContainerC;
    }

    private final void B2(RippleHostView rippleHostView) {
        this.f15324n = rippleHostView;
        DrawModifierNodeKt.a(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        RippleContainer rippleContainer = this.f15323m;
        if (rippleContainer != null) {
            rippleContainer.a(this);
        }
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void r2(PressInteraction.Press press, long j3, float f3) {
        RippleHostView rippleHostViewB = A2().b(this);
        rippleHostViewB.b(press, t2(), j3, MathKt.d(f3), v2(), ((RippleAlpha) u2().invoke()).d(), new Function0<Unit>() { // from class: androidx.compose.material.ripple.AndroidRippleNode$addRipple$1$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m145invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m145invoke() {
                DrawModifierNodeKt.a(this.f15325a);
            }
        });
        B2(rippleHostViewB);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void s2(DrawScope drawScope) {
        Canvas canvasG = drawScope.Q1().g();
        RippleHostView rippleHostView = this.f15324n;
        if (rippleHostView != null) {
            rippleHostView.f(w2(), v2(), ((RippleAlpha) u2().invoke()).d());
            rippleHostView.draw(AndroidCanvas_androidKt.d(canvasG));
        }
    }

    @Override // androidx.compose.material.ripple.RippleHostKey
    public void x1() {
        B2(null);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void y2(PressInteraction.Press press) {
        RippleHostView rippleHostView = this.f15324n;
        if (rippleHostView != null) {
            rippleHostView.e();
        }
    }

    private AndroidRippleNode(InteractionSource interactionSource, boolean z2, float f3, ColorProducer colorProducer, Function0 function0) {
        super(interactionSource, z2, f3, colorProducer, function0, null);
    }
}
