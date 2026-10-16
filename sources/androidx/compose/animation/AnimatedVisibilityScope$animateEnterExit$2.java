package androidx.compose.animation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
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
final class AnimatedVisibilityScope$animateEnterExit$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AnimatedVisibilityScope f3387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ EnterTransition f3388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ExitTransition f3389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f3390d;

    public final Modifier c(Modifier modifier, Composer composer, int i3) {
        composer.a0(1840112047);
        if (ComposerKt.M()) {
            ComposerKt.U(1840112047, i3, -1, "androidx.compose.animation.AnimatedVisibilityScope.animateEnterExit.<anonymous> (AnimatedVisibility.kt:654)");
        }
        Modifier modifierThen = modifier.then(EnterExitTransitionKt.g(this.f3387a.b(), this.f3388b, this.f3389c, null, this.f3390d, composer, 0, 4));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifierThen;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }
}
