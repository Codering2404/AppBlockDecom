package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
final class SharedTransitionScopeImpl$sharedBounds$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AnimatedVisibilityScope f3670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ EnterTransition f3671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ExitTransition f3672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SharedTransitionScope.SharedContentState f3673d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SharedTransitionScope.ResizeMode f3674f;

    public final Modifier c(Modifier modifier, Composer composer, int i3) {
        Modifier modifierA;
        composer.a0(-419341573);
        if (ComposerKt.M()) {
            ComposerKt.U(-419341573, i3, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBounds.<anonymous> (SharedTransitionScope.kt:736)");
        }
        Transition transitionB = this.f3670a.b();
        EnterTransition enterTransition = this.f3671b;
        ExitTransition exitTransition = this.f3672c;
        boolean zI = composer.I(this.f3673d);
        final SharedTransitionScope.SharedContentState sharedContentState = this.f3673d;
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0<Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(sharedContentState.f());
                }
            };
            composer.w(objG);
        }
        Modifier modifierG = EnterExitTransitionKt.g(transitionB, enterTransition, exitTransition, (Function0) objG, "enter/exit for " + this.f3673d.c(), composer, 0, 0);
        if (this.f3674f instanceof ScaleToBoundsImpl) {
            composer.a0(-805568624);
            Modifier.Companion companion = Modifier.b8;
            ScaleToBoundsImpl scaleToBoundsImpl = (ScaleToBoundsImpl) this.f3674f;
            boolean zI2 = composer.I(this.f3673d);
            final SharedTransitionScope.SharedContentState sharedContentState2 = this.f3673d;
            Object objG2 = composer.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0<Boolean>() { // from class: androidx.compose.animation.SharedTransitionScopeImpl$sharedBounds$2$2$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(sharedContentState2.f());
                    }
                };
                composer.w(objG2);
            }
            modifierA = SkipToLookaheadNodeKt.a(companion, scaleToBoundsImpl, (Function0) objG2);
            composer.U();
        } else {
            composer.a0(-804951414);
            composer.U();
            modifierA = Modifier.b8;
        }
        Modifier modifierThen = modifierG.then(modifierA);
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
