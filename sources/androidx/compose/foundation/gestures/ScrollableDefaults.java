package androidx.compose.foundation.gestures;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class ScrollableDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScrollableDefaults f6072a = new ScrollableDefaults();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class NoOpOverscrollEffect implements OverscrollEffect {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoOpOverscrollEffect f6073a = new NoOpOverscrollEffect();

        private NoOpOverscrollEffect() {
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        public boolean a() {
            return false;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        public long b(long j3, int i3, Function1 function1) {
            return ((Offset) function1.invoke(Offset.d(j3))).u();
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        public Object c(long j3, Function2 function2, Continuation continuation) {
            Object objInvoke = function2.invoke(Velocity.b(j3), continuation);
            return objInvoke == IntrinsicsKt.f() ? objInvoke : Unit.f139807a;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        public DelegatableNode getNode() {
            return new Modifier.Node() { // from class: androidx.compose.foundation.gestures.ScrollableDefaults$NoOpOverscrollEffect$node$1
            };
        }
    }

    private ScrollableDefaults() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final FlingBehavior a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1107739818, i3, -1, "androidx.compose.foundation.gestures.ScrollableDefaults.flingBehavior (Scrollable.kt:536)");
        }
        DecayAnimationSpec decayAnimationSpecB = SplineBasedFloatDecayAnimationSpec_androidKt.b(composer, 0);
        boolean Z = composer.Z(decayAnimationSpecB);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new DefaultFlingBehavior(decayAnimationSpecB, null, 2, 0 == true ? 1 : 0);
            composer.w(objG);
        }
        DefaultFlingBehavior defaultFlingBehavior = (DefaultFlingBehavior) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return defaultFlingBehavior;
    }

    public final boolean b(LayoutDirection layoutDirection, Orientation orientation, boolean z2) {
        return (layoutDirection != LayoutDirection.f30002b || orientation == Orientation.f6031a) ? !z2 : z2;
    }
}
