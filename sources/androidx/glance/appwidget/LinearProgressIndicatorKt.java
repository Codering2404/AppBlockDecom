package androidx.glance.appwidget;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.glance.Applier;
import androidx.glance.GlanceModifier;
import androidx.glance.unit.ColorProvider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class LinearProgressIndicatorKt {
    public static final void a(final float f3, GlanceModifier glanceModifier, ColorProvider colorProvider, ColorProvider colorProvider2, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(-12096187);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i5 = (composerK.c(f3) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 112) == 0) {
            i5 |= composerK.Z(glanceModifier) ? 32 : 16;
        }
        int i7 = i4 & 4;
        if (i7 != 0) {
            i5 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i8 = i4 & 8;
        if (i8 != 0) {
            i5 |= 1024;
        }
        if ((i4 & 12) == 12 && (i5 & 5851) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            composerK.J();
            if ((i3 & 1) == 0 || composerK.S()) {
                if (i6 != 0) {
                    glanceModifier = GlanceModifier.f37605a;
                }
                if (i7 != 0) {
                    colorProvider = ProgressIndicatorDefaults.f38195a.b();
                }
                if (i8 != 0) {
                    colorProvider2 = ProgressIndicatorDefaults.f38195a.a();
                }
            } else {
                composerK.Q();
            }
            composerK.z();
            if (ComposerKt.M()) {
                ComposerKt.U(-12096187, i3, -1, "androidx.glance.appwidget.LinearProgressIndicator (LinearProgressIndicator.kt:35)");
            }
            final LinearProgressIndicatorKt$LinearProgressIndicator$1 linearProgressIndicatorKt$LinearProgressIndicator$1 = LinearProgressIndicatorKt$LinearProgressIndicator$1.f38155a;
            composerK.F(-1115894518);
            composerK.F(1886828752);
            if (!(composerK.m() instanceof Applier)) {
                ComposablesKt.c();
            }
            composerK.o();
            if (composerK.i()) {
                composerK.P(new Function0<EmittableLinearProgressIndicator>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$$inlined$GlanceNode$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return linearProgressIndicatorKt$LinearProgressIndicator$1.invoke();
                    }
                });
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, glanceModifier, new Function2<EmittableLinearProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$2$1
                public final void c(EmittableLinearProgressIndicator emittableLinearProgressIndicator, GlanceModifier glanceModifier2) {
                    emittableLinearProgressIndicator.b(glanceModifier2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLinearProgressIndicator) obj, (GlanceModifier) obj2);
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, Float.valueOf(f3), new Function2<EmittableLinearProgressIndicator, Float, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$2$2
                public final void c(EmittableLinearProgressIndicator emittableLinearProgressIndicator, float f4) {
                    emittableLinearProgressIndicator.j(f4);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLinearProgressIndicator) obj, ((Number) obj2).floatValue());
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, colorProvider, new Function2<EmittableLinearProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$2$3
                public final void c(EmittableLinearProgressIndicator emittableLinearProgressIndicator, ColorProvider colorProvider3) {
                    emittableLinearProgressIndicator.h(colorProvider3);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLinearProgressIndicator) obj, (ColorProvider) obj2);
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, colorProvider2, new Function2<EmittableLinearProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$2$4
                public final void c(EmittableLinearProgressIndicator emittableLinearProgressIndicator, ColorProvider colorProvider3) {
                    emittableLinearProgressIndicator.g(colorProvider3);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLinearProgressIndicator) obj, (ColorProvider) obj2);
                    return Unit.f139807a;
                }
            });
            composerK.y();
            composerK.Y();
            composerK.Y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        final ColorProvider colorProvider3 = colorProvider;
        final ColorProvider colorProvider4 = colorProvider2;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i9) {
                LinearProgressIndicatorKt.a(f3, glanceModifier2, colorProvider3, colorProvider4, composer2, i3 | 1, i4);
            }
        });
    }

    public static final void b(GlanceModifier glanceModifier, ColorProvider colorProvider, ColorProvider colorProvider2, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(-1130088971);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i5 = (composerK.Z(glanceModifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i7 = i4 & 2;
        if (i7 != 0) {
            i5 |= 16;
        }
        int i8 = i4 & 4;
        if (i8 != 0) {
            i5 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 6) == 6 && (i5 & 731) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            composerK.J();
            if ((i3 & 1) == 0 || composerK.S()) {
                if (i6 != 0) {
                    glanceModifier = GlanceModifier.f37605a;
                }
                if (i7 != 0) {
                    colorProvider = ProgressIndicatorDefaults.f38195a.b();
                }
                if (i8 != 0) {
                    colorProvider2 = ProgressIndicatorDefaults.f38195a.a();
                }
            } else {
                composerK.Q();
            }
            composerK.z();
            if (ComposerKt.M()) {
                ComposerKt.U(-1130088971, i3, -1, "androidx.glance.appwidget.LinearProgressIndicator (LinearProgressIndicator.kt:62)");
            }
            final LinearProgressIndicatorKt$LinearProgressIndicator$4 linearProgressIndicatorKt$LinearProgressIndicator$4 = LinearProgressIndicatorKt$LinearProgressIndicator$4.f38166a;
            composerK.F(-1115894518);
            composerK.F(1886828752);
            if (!(composerK.m() instanceof Applier)) {
                ComposablesKt.c();
            }
            composerK.o();
            if (composerK.i()) {
                composerK.P(new Function0<EmittableLinearProgressIndicator>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$$inlined$GlanceNode$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return linearProgressIndicatorKt$LinearProgressIndicator$4.invoke();
                    }
                });
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, glanceModifier, new Function2<EmittableLinearProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$5$1
                public final void c(EmittableLinearProgressIndicator emittableLinearProgressIndicator, GlanceModifier glanceModifier2) {
                    emittableLinearProgressIndicator.b(glanceModifier2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLinearProgressIndicator) obj, (GlanceModifier) obj2);
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, Boolean.TRUE, new Function2<EmittableLinearProgressIndicator, Boolean, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$5$2
                public final void c(EmittableLinearProgressIndicator emittableLinearProgressIndicator, boolean z2) {
                    emittableLinearProgressIndicator.i(z2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLinearProgressIndicator) obj, ((Boolean) obj2).booleanValue());
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, colorProvider, new Function2<EmittableLinearProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$5$3
                public final void c(EmittableLinearProgressIndicator emittableLinearProgressIndicator, ColorProvider colorProvider3) {
                    emittableLinearProgressIndicator.h(colorProvider3);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLinearProgressIndicator) obj, (ColorProvider) obj2);
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, colorProvider2, new Function2<EmittableLinearProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$5$4
                public final void c(EmittableLinearProgressIndicator emittableLinearProgressIndicator, ColorProvider colorProvider3) {
                    emittableLinearProgressIndicator.g(colorProvider3);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableLinearProgressIndicator) obj, (ColorProvider) obj2);
                    return Unit.f139807a;
                }
            });
            composerK.y();
            composerK.Y();
            composerK.Y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        final ColorProvider colorProvider3 = colorProvider;
        final ColorProvider colorProvider4 = colorProvider2;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.LinearProgressIndicatorKt$LinearProgressIndicator$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i9) {
                LinearProgressIndicatorKt.b(glanceModifier2, colorProvider3, colorProvider4, composer2, i3 | 1, i4);
            }
        });
    }
}
