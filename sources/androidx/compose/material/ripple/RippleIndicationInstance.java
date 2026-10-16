package androidx.compose.material.ripple;

import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

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
@Deprecated
@Metadata
public abstract class RippleIndicationInstance implements IndicationInstance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f15401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StateLayer f15402b;

    public RippleIndicationInstance(boolean z2, final State state) {
        this.f15401a = z2;
        this.f15402b = new StateLayer(z2, new Function0<RippleAlpha>() { // from class: androidx.compose.material.ripple.RippleIndicationInstance$stateLayer$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final RippleAlpha invoke() {
                return (RippleAlpha) state.getValue();
            }
        });
    }

    public abstract void b(PressInteraction.Press press, CoroutineScope coroutineScope);

    public final void f(DrawScope drawScope, float f3, long j3) {
        this.f15402b.b(drawScope, Float.isNaN(f3) ? RippleAnimationKt.a(drawScope, this.f15401a, drawScope.b()) : drawScope.M1(f3), j3);
    }

    public abstract void g(PressInteraction.Press press);

    public final void h(Interaction interaction, CoroutineScope coroutineScope) {
        this.f15402b.c(interaction, coroutineScope);
    }
}
