package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class DelegatingThemeAwareRippleNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, ObserverModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InteractionSource f17452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f17453d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f17454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ColorProducer f17455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DelegatableNode f17456h;

    public /* synthetic */ DelegatingThemeAwareRippleNode(InteractionSource interactionSource, boolean z2, float f3, ColorProducer colorProducer, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, z2, f3, colorProducer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w2() {
        this.f17456h = m2(androidx.compose.material.ripple.RippleKt.c(this.f17452c, this.f17453d, this.f17454f, new ColorProducer() { // from class: androidx.compose.material3.DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1
            @Override // androidx.compose.ui.graphics.ColorProducer
            public final long a() {
                long jA = this.f17457a.f17455g.a();
                if (jA != 16) {
                    return jA;
                }
                RippleConfiguration rippleConfiguration = (RippleConfiguration) CompositionLocalConsumerModifierNodeKt.a(this.f17457a, RippleKt.a());
                return (rippleConfiguration == null || rippleConfiguration.a() == 16) ? ((Color) CompositionLocalConsumerModifierNodeKt.a(this.f17457a, ContentColorKt.a())).B() : rippleConfiguration.a();
            }
        }, new Function0<RippleAlpha>() { // from class: androidx.compose.material3.DelegatingThemeAwareRippleNode$attachNewRipple$calculateRippleAlpha$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final RippleAlpha invoke() {
                RippleAlpha rippleAlphaB;
                RippleConfiguration rippleConfiguration = (RippleConfiguration) CompositionLocalConsumerModifierNodeKt.a(this.f17458a, RippleKt.a());
                return (rippleConfiguration == null || (rippleAlphaB = rippleConfiguration.b()) == null) ? RippleDefaults.f19379a.a() : rippleAlphaB;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x2() {
        DelegatableNode delegatableNode = this.f17456h;
        if (delegatableNode != null) {
            p2(delegatableNode);
        }
    }

    private final void y2() {
        ObserverModifierNodeKt.a(this, new Function0<Unit>() { // from class: androidx.compose.material3.DelegatingThemeAwareRippleNode$updateConfiguration$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m158invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m158invoke() {
                if (((RippleConfiguration) CompositionLocalConsumerModifierNodeKt.a(this.f17459a, RippleKt.a())) == null) {
                    this.f17459a.x2();
                } else if (this.f17459a.f17456h == null) {
                    this.f17459a.w2();
                }
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        y2();
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void w0() {
        y2();
    }

    private DelegatingThemeAwareRippleNode(InteractionSource interactionSource, boolean z2, float f3, ColorProducer colorProducer) {
        this.f17452c = interactionSource;
        this.f17453d = z2;
        this.f17454f = f3;
        this.f17455g = colorProducer;
    }
}
