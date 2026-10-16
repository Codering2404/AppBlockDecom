package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import androidx.activity.FullyDrawnReporterOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ReportDrawnKt {
    public static final void a(Composer composer, final int i3) {
        Composer composerK = composer.k(-1357012904);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1357012904, i3, -1, "androidx.activity.compose.ReportDrawn (ReportDrawn.kt:135)");
            }
            c(new Function0<Boolean>() { // from class: androidx.activity.compose.ReportDrawnKt$ReportDrawn$1
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.TRUE;
                }
            }, composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.activity.compose.ReportDrawnKt$ReportDrawn$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    ReportDrawnKt.a(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void b(final Function1 function1, Composer composer, final int i3) {
        int i4;
        FullyDrawnReporter fullyDrawnReporter;
        Composer composerK = composer.k(945311272);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function1) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(945311272, i4, -1, "androidx.activity.compose.ReportDrawnAfter (ReportDrawn.kt:148)");
            }
            FullyDrawnReporterOwner fullyDrawnReporterOwnerA = LocalFullyDrawnReporterOwner.f455a.a(composerK, 6);
            if (fullyDrawnReporterOwnerA == null || (fullyDrawnReporter = fullyDrawnReporterOwnerA.getFullyDrawnReporter()) == null) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                ScopeUpdateScope scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.activity.compose.ReportDrawnKt$ReportDrawnAfter$fullyDrawnReporter$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer2, int i5) {
                            ReportDrawnKt.b(function1, composer2, RecomposeScopeImplKt.a(i3 | 1));
                        }
                    });
                    return;
                }
                return;
            }
            boolean zI = composerK.I(fullyDrawnReporter) | composerK.I(function1);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new ReportDrawnKt$ReportDrawnAfter$1$1(fullyDrawnReporter, function1, null);
                composerK.w(objG);
            }
            EffectsKt.f(function1, fullyDrawnReporter, (Function2) objG, composerK, i4 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN2 = composerK.n();
        if (scopeUpdateScopeN2 != null) {
            scopeUpdateScopeN2.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.activity.compose.ReportDrawnKt$ReportDrawnAfter$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ReportDrawnKt.b(function1, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void c(final Function0 function0, Composer composer, final int i3) {
        int i4;
        final FullyDrawnReporter fullyDrawnReporter;
        Composer composerK = composer.k(-2047119994);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function0) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-2047119994, i4, -1, "androidx.activity.compose.ReportDrawnWhen (ReportDrawn.kt:116)");
            }
            FullyDrawnReporterOwner fullyDrawnReporterOwnerA = LocalFullyDrawnReporterOwner.f455a.a(composerK, 6);
            if (fullyDrawnReporterOwnerA == null || (fullyDrawnReporter = fullyDrawnReporterOwnerA.getFullyDrawnReporter()) == null) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                ScopeUpdateScope scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.activity.compose.ReportDrawnKt$ReportDrawnWhen$fullyDrawnReporter$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer2, int i5) {
                            ReportDrawnKt.c(function0, composer2, RecomposeScopeImplKt.a(i3 | 1));
                        }
                    });
                    return;
                }
                return;
            }
            boolean zI = composerK.I(fullyDrawnReporter) | ((i4 & 14) == 4);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.activity.compose.ReportDrawnKt$ReportDrawnWhen$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        if (fullyDrawnReporter.e()) {
                            return new DisposableEffectResult() { // from class: androidx.activity.compose.ReportDrawnKt$ReportDrawnWhen$1$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                }
                            };
                        }
                        final ReportDrawnComposition reportDrawnComposition = new ReportDrawnComposition(fullyDrawnReporter, function0);
                        return new DisposableEffectResult() { // from class: androidx.activity.compose.ReportDrawnKt$ReportDrawnWhen$1$1$invoke$$inlined$onDispose$2
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                reportDrawnComposition.h();
                            }
                        };
                    }
                };
                composerK.w(objG);
            }
            EffectsKt.b(fullyDrawnReporter, function0, (Function1) objG, composerK, (i4 << 3) & 112);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN2 = composerK.n();
        if (scopeUpdateScopeN2 != null) {
            scopeUpdateScopeN2.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.activity.compose.ReportDrawnKt$ReportDrawnWhen$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ReportDrawnKt.c(function0, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
