package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

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
public final class LazyLayoutKt {
    public static final void a(final Function0 function0, final Modifier modifier, final LazyLayoutPrefetchState lazyLayoutPrefetchState, final Function2 function2, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(2002163445);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.I(function0) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(modifier) ? 32 : 16;
        }
        int i7 = i4 & 4;
        if (i7 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.Z(lazyLayoutPrefetchState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 8) != 0) {
            i5 |= 3072;
        } else if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function2) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (i7 != 0) {
                lazyLayoutPrefetchState = null;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(2002163445, i5, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:52)");
            }
            final State stateP = SnapshotStateKt.p(function0, composerK, i5 & 14);
            LazySaveableStateHolderKt.a(ComposableLambdaKt.e(-1488997347, true, new Function3<SaveableStateHolder, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    c((SaveableStateHolder) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void c(SaveableStateHolder saveableStateHolder, Composer composer2, int i8) {
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1488997347, i8, -1, sKeKFMqmvNzY.PKYhIocZpe);
                    }
                    final State state = stateP;
                    Object objG = composer2.G();
                    Composer.Companion companion = Composer.f23746a;
                    if (objG == companion.a()) {
                        objG = new LazyLayoutItemContentFactory(saveableStateHolder, new Function0<LazyLayoutItemProvider>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1$itemContentFactory$1$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                            public final LazyLayoutItemProvider invoke() {
                                return (LazyLayoutItemProvider) ((Function0) state.getValue()).invoke();
                            }
                        });
                        composer2.w(objG);
                    }
                    final LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) objG;
                    Object objG2 = composer2.G();
                    if (objG2 == companion.a()) {
                        objG2 = new SubcomposeLayoutState(new LazyLayoutItemReusePolicy(lazyLayoutItemContentFactory));
                        composer2.w(objG2);
                    }
                    final SubcomposeLayoutState subcomposeLayoutState = (SubcomposeLayoutState) objG2;
                    if (lazyLayoutPrefetchState != null) {
                        composer2.a0(204281539);
                        final PrefetchScheduler prefetchSchedulerD = lazyLayoutPrefetchState.d();
                        if (prefetchSchedulerD == null) {
                            composer2.a0(6591363);
                            prefetchSchedulerD = PrefetchScheduler_androidKt.a(composer2, 0);
                        } else {
                            composer2.a0(6590278);
                        }
                        composer2.U();
                        Object obj = lazyLayoutPrefetchState;
                        Object[] objArr = {obj, lazyLayoutItemContentFactory, subcomposeLayoutState, prefetchSchedulerD};
                        boolean Z = composer2.Z(obj) | composer2.I(lazyLayoutItemContentFactory) | composer2.I(subcomposeLayoutState) | composer2.I(prefetchSchedulerD);
                        final LazyLayoutPrefetchState lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
                        Object objG3 = composer2.G();
                        if (Z || objG3 == companion.a()) {
                            objG3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                    lazyLayoutPrefetchState2.f(new PrefetchHandleProvider(lazyLayoutItemContentFactory, subcomposeLayoutState, prefetchSchedulerD));
                                    final LazyLayoutPrefetchState lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
                                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1$1$1$invoke$$inlined$onDispose$1
                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                        public void dispose() {
                                            lazyLayoutPrefetchState3.f(null);
                                        }
                                    };
                                }
                            };
                            composer2.w(objG3);
                        }
                        EffectsKt.d(objArr, (Function1) objG3, composer2, 0);
                        composer2.U();
                    } else {
                        composer2.a0(204710145);
                        composer2.U();
                    }
                    Modifier modifierB = LazyLayoutPrefetchStateKt.b(modifier, lazyLayoutPrefetchState);
                    boolean Z2 = composer2.Z(lazyLayoutItemContentFactory) | composer2.Z(function2);
                    final Function2 function22 = function2;
                    Object objG4 = composer2.G();
                    if (Z2 || objG4 == companion.a()) {
                        objG4 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                return m50invoke0kLqBqw((SubcomposeMeasureScope) obj2, ((Constraints) obj3).r());
                            }

                            /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m50invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j3) {
                                return (MeasureResult) function22.invoke(new LazyLayoutMeasureScopeImpl(lazyLayoutItemContentFactory, subcomposeMeasureScope), Constraints.a(j3));
                            }
                        };
                        composer2.w(objG4);
                    }
                    SubcomposeLayoutKt.b(subcomposeLayoutState, modifierB, (Function2) objG4, composer2, SubcomposeLayoutState.f27228f, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        final Modifier modifier2 = modifier;
        final LazyLayoutPrefetchState lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2
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
                    LazyLayoutKt.a(function0, modifier2, lazyLayoutPrefetchState2, function2, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }
}
