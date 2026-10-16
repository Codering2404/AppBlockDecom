package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

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
public final class TransitionKt$animateOffset$1 extends Lambda implements Function3<Transition.Segment<Object>, Composer, Integer, SpringSpec<Offset>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TransitionKt$animateOffset$1 f4257a = new TransitionKt$animateOffset$1();

    public TransitionKt$animateOffset$1() {
        super(3);
    }

    public final SpringSpec c(Transition.Segment segment, Composer composer, int i3) {
        composer.a0(1623385561);
        if (ComposerKt.M()) {
            ComposerKt.U(1623385561, i3, -1, "androidx.compose.animation.core.animateOffset.<anonymous> (Transition.kt:1980)");
        }
        SpringSpec springSpecL = AnimationSpecKt.l(0.0f, 0.0f, Offset.d(VisibilityThresholdsKt.c(Offset.f25596b)), 3, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return springSpecL;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return c((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
    }
}
