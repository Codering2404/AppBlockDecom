package androidx.activity.compose;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class PredictiveBackHandlerKt {
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void a(final boolean z2, final Function2 function2, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(-642000585);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i5 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (i6 != 0) {
                z2 = true;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-642000585, i5, -1, "androidx.activity.compose.PredictiveBackHandler (PredictiveBackHandler.kt:76)");
            }
            State stateP = SnapshotStateKt.p(function2, composerK, (i5 >> 3) & 14);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.l(EmptyCoroutineContext.f139889a, composerK));
                composerK.w(compositionScopedCoroutineScopeCanceller);
                objG = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScopeA = ((CompositionScopedCoroutineScopeCanceller) objG).a();
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new PredictiveBackHandlerCallback(z2, coroutineScopeA, b(stateP));
                composerK.w(objG2);
            }
            final PredictiveBackHandlerCallback predictiveBackHandlerCallback = (PredictiveBackHandlerCallback) objG2;
            boolean Z = composerK.Z(b(stateP)) | composerK.Z(coroutineScopeA);
            Object objG3 = composerK.G();
            if (Z || objG3 == companion.a()) {
                predictiveBackHandlerCallback.d(b(stateP));
                predictiveBackHandlerCallback.f(coroutineScopeA);
                composerK.w(Unit.f139807a);
            }
            Boolean boolValueOf = Boolean.valueOf(z2);
            int i7 = i5 & 14;
            boolean zI = composerK.I(predictiveBackHandlerCallback) | (i7 == 4);
            Object objG4 = composerK.G();
            if (zI || objG4 == companion.a()) {
                objG4 = new PredictiveBackHandlerKt$PredictiveBackHandler$2$1(predictiveBackHandlerCallback, z2, null);
                composerK.w(objG4);
            }
            EffectsKt.g(boolValueOf, (Function2) objG4, composerK, i7);
            OnBackPressedDispatcherOwner onBackPressedDispatcherOwnerA = LocalOnBackPressedDispatcherOwner.f458a.a(composerK, 6);
            if (onBackPressedDispatcherOwnerA == null) {
                throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner");
            }
            final OnBackPressedDispatcher onBackPressedDispatcher = onBackPressedDispatcherOwnerA.getOnBackPressedDispatcher();
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) composerK.q(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            boolean zI2 = composerK.I(onBackPressedDispatcher) | composerK.I(lifecycleOwner) | composerK.I(predictiveBackHandlerCallback);
            Object objG5 = composerK.G();
            if (zI2 || objG5 == companion.a()) {
                objG5 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        onBackPressedDispatcher.i(lifecycleOwner, predictiveBackHandlerCallback);
                        final PredictiveBackHandlerCallback predictiveBackHandlerCallback2 = predictiveBackHandlerCallback;
                        return new DisposableEffectResult() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$3$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                predictiveBackHandlerCallback2.remove();
                            }
                        };
                    }
                };
                composerK.w(objG5);
            }
            EffectsKt.b(lifecycleOwner, onBackPressedDispatcher, (Function1) objG5, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    PredictiveBackHandlerKt.a(z2, function2, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    private static final Function2 b(State state) {
        return (Function2) state.getValue();
    }
}
