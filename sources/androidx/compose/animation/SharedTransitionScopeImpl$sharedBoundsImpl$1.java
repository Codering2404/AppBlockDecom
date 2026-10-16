package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

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
final class SharedTransitionScopeImpl$sharedBoundsImpl$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedTransitionScope.SharedContentState f3677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Transition f3678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f3679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SharedTransitionScopeImpl f3680d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SharedTransitionScope.PlaceHolderSize f3681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f3682g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ SharedTransitionScope.OverlayClip f3683h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ float f3684i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ boolean f3685j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ BoundsTransform f3686k;

    public final Modifier c(Modifier modifier, Composer composer, int i3) {
        Transition transitionH;
        Composer composer2 = composer;
        composer.a0(-1843478929);
        if (ComposerKt.M()) {
            ComposerKt.U(-1843478929, i3, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous> (SharedTransitionScope.kt:915)");
        }
        Object objC = this.f3677a.c();
        composer.K(-359689844, objC);
        SharedTransitionScopeImpl sharedTransitionScopeImpl = this.f3680d;
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = sharedTransitionScopeImpl.y(objC);
            composer.w(objG);
        }
        SharedElement sharedElement = (SharedElement) objG;
        composer.K(-359686031, this.f3678b);
        boolean z2 = false;
        if (this.f3678b != null) {
            composer.a0(1734686048);
            Transition transition = this.f3678b;
            String string = objC.toString();
            Function1 function1 = this.f3679c;
            boolean Z = composer.Z(transition);
            Object objG2 = composer.G();
            if (Z || objG2 == companion.a()) {
                objG2 = transition.i();
                composer.w(objG2);
            }
            if (transition.w()) {
                objG2 = transition.i();
            }
            composer.a0(1329676753);
            if (ComposerKt.M()) {
                ComposerKt.U(1329676753, 0, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SharedTransitionScope.kt:925)");
            }
            Boolean bool = (Boolean) function1.invoke(objG2);
            bool.booleanValue();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            Object objQ = transition.q();
            composer.a0(1329676753);
            if (ComposerKt.M()) {
                ComposerKt.U(1329676753, 0, -1, "androidx.compose.animation.SharedTransitionScopeImpl.sharedBoundsImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SharedTransitionScope.kt:925)");
            }
            Boolean bool2 = (Boolean) function1.invoke(objQ);
            bool2.booleanValue();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            transitionH = androidx.compose.animation.core.TransitionKt.d(transition, bool, bool2, string, composer2, 0);
            composer2 = composer2;
            composer.U();
        } else {
            composer.a0(1734936683);
            Function1 function12 = this.f3679c;
            Intrinsics.checkNotNull(function12, "null cannot be cast to non-null type kotlin.Function1<kotlin.Unit, kotlin.Boolean>");
            Boolean bool3 = (Boolean) ((Function1) TypeIntrinsics.f(function12, 1)).invoke(Unit.f139807a);
            boolean zBooleanValue = bool3.booleanValue();
            Object objG3 = composer.G();
            if (objG3 == companion.a()) {
                if (sharedElement.c() == null) {
                    z2 = zBooleanValue;
                } else if (!zBooleanValue) {
                    z2 = true;
                }
                objG3 = new MutableTransitionState(Boolean.valueOf(z2));
                composer.w(objG3);
            }
            MutableTransitionState mutableTransitionState = (MutableTransitionState) objG3;
            mutableTransitionState.h(bool3);
            transitionH = androidx.compose.animation.core.TransitionKt.h(mutableTransitionState, null, composer, MutableTransitionState.f4020d, 2);
            composer.U();
        }
        composer.K(-359623378, Boolean.valueOf(this.f3680d.p()));
        Transition.DeferredAnimation deferredAnimationE = androidx.compose.animation.core.TransitionKt.e(transitionH, VectorConvertersKt.c(Rect.f25601e), null, composer2, 0, 2);
        composer.X();
        boolean Z2 = composer.Z(transitionH);
        SharedTransitionScopeImpl sharedTransitionScopeImpl2 = this.f3680d;
        BoundsTransform boundsTransform = this.f3686k;
        Object objG4 = composer.G();
        if (Z2 || objG4 == companion.a()) {
            objG4 = new BoundsAnimation(sharedTransitionScopeImpl2, transitionH, deferredAnimationE, boundsTransform);
            composer.w(objG4);
        }
        BoundsAnimation boundsAnimation = (BoundsAnimation) objG4;
        boundsAnimation.m(deferredAnimationE, this.f3686k);
        composer.X();
        SharedElementInternalState sharedElementInternalStateS = this.f3680d.s(sharedElement, boundsAnimation, this.f3681f, this.f3682g, this.f3677a, this.f3683h, this.f3684i, this.f3685j, composer, 0);
        composer.X();
        Modifier modifierThen = modifier.then(new SharedBoundsNodeElement(sharedElementInternalStateS));
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
