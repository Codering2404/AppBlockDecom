package androidx.glance.appwidget;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.glance.Applier;
import androidx.glance.GlanceModifier;
import androidx.glance.unit.ColorProvider;
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
public final class CircularProgressIndicatorKt {
    public static final void a(final GlanceModifier glanceModifier, final ColorProvider colorProvider, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(-525156579);
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
        if (i7 == 2 && (i5 & 91) == 18 && composerK.l()) {
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
            } else {
                composerK.Q();
            }
            composerK.z();
            if (ComposerKt.M()) {
                ComposerKt.U(-525156579, i3, -1, "androidx.glance.appwidget.CircularProgressIndicator (CircularProgressIndicator.kt:31)");
            }
            final CircularProgressIndicatorKt$CircularProgressIndicator$1 circularProgressIndicatorKt$CircularProgressIndicator$1 = CircularProgressIndicatorKt$CircularProgressIndicator$1.f37857a;
            composerK.F(-1115894518);
            composerK.F(1886828752);
            if (!(composerK.m() instanceof Applier)) {
                ComposablesKt.c();
            }
            composerK.o();
            if (composerK.i()) {
                composerK.P(new Function0<EmittableCircularProgressIndicator>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$$inlined$GlanceNode$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return circularProgressIndicatorKt$CircularProgressIndicator$1.invoke();
                    }
                });
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, glanceModifier, new Function2<EmittableCircularProgressIndicator, GlanceModifier, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$2$1
                public final void c(EmittableCircularProgressIndicator emittableCircularProgressIndicator, GlanceModifier glanceModifier2) {
                    emittableCircularProgressIndicator.b(glanceModifier2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableCircularProgressIndicator) obj, (GlanceModifier) obj2);
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, colorProvider, new Function2<EmittableCircularProgressIndicator, ColorProvider, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$2$2
                public final void c(EmittableCircularProgressIndicator emittableCircularProgressIndicator, ColorProvider colorProvider2) {
                    emittableCircularProgressIndicator.d(colorProvider2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableCircularProgressIndicator) obj, (ColorProvider) obj2);
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
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.appwidget.CircularProgressIndicatorKt$CircularProgressIndicator$3
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
                CircularProgressIndicatorKt.a(glanceModifier, colorProvider, composer2, i3 | 1, i4);
            }
        });
    }
}
