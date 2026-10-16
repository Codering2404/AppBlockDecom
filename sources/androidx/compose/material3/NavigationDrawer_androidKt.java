package androidx.compose.material3;

import androidx.activity.compose.PredictiveBackHandlerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
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
@Metadata
public final class NavigationDrawer_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f18680a = Dp.g(12);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f18681b = Dp.g(24);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f18682c = Dp.g(48);

    public static final void a(final DrawerState drawerState, final Function3 function3, Composer composer, final int i3) {
        int i4;
        Object navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1;
        boolean z2;
        int i5;
        int i6;
        Composer composerK = composer.k(1444817207);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(drawerState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function3) ? 32 : 16;
        }
        int i7 = i4;
        if ((i7 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1444817207, i7, -1, "androidx.compose.material3.DrawerPredictiveBackHandler (NavigationDrawer.android.kt:44)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new DrawerPredictiveBackState();
                composerK.w(objG);
            }
            DrawerPredictiveBackState drawerPredictiveBackState = (DrawerPredictiveBackState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.l(EmptyCoroutineContext.f139889a, composerK));
                composerK.w(compositionScopedCoroutineScopeCanceller);
                objG2 = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScopeA = ((CompositionScopedCoroutineScopeCanceller) objG2).a();
            boolean z3 = composerK.q(CompositionLocalsKt.m()) == LayoutDirection.f30002b;
            Ref.FloatRef floatRef = new Ref.FloatRef();
            Ref.FloatRef floatRef2 = new Ref.FloatRef();
            Ref.FloatRef floatRef3 = new Ref.FloatRef();
            Density density = (Density) composerK.q(CompositionLocalsKt.f());
            floatRef.f140141a = density.M1(f18680a);
            floatRef2.f140141a = density.M1(f18681b);
            floatRef3.f140141a = density.M1(f18682c);
            boolean zJ = drawerState.j();
            int i8 = i7 & 14;
            boolean zB = composerK.b(z3) | composerK.c(floatRef.f140141a) | composerK.c(floatRef2.f140141a) | composerK.c(floatRef3.f140141a) | composerK.I(coroutineScopeA) | (i8 == 4);
            Object objG3 = composerK.G();
            if (zB || objG3 == companion.a()) {
                z2 = zJ;
                i5 = i7;
                i6 = 0;
                navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 = new NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1(drawerPredictiveBackState, coroutineScopeA, drawerState, z3, floatRef, floatRef2, floatRef3, null);
                composerK.w(navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1);
            } else {
                z2 = zJ;
                navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 = objG3;
                i5 = i7;
                i6 = 0;
            }
            PredictiveBackHandlerKt.a(z2, (Function2) navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1, composerK, i6, i6);
            Boolean boolValueOf = Boolean.valueOf(drawerState.i());
            int i9 = i8 == 4 ? 1 : i6;
            Object objG4 = composerK.G();
            if (i9 != 0 || objG4 == companion.a()) {
                objG4 = new NavigationDrawer_androidKt$DrawerPredictiveBackHandler$3$1(drawerState, drawerPredictiveBackState, null);
                composerK.w(objG4);
            }
            EffectsKt.g(boolValueOf, (Function2) objG4, composerK, i6);
            function3.invoke(drawerPredictiveBackState, composerK, Integer.valueOf((i5 & 112) | 6));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawer_androidKt$DrawerPredictiveBackHandler$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i10) {
                    NavigationDrawer_androidKt.a(drawerState, function3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
