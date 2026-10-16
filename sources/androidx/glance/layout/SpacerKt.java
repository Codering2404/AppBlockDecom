package androidx.glance.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.glance.Applier;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceNodeKt$GlanceNode$$inlined$ComposeNode$1;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class SpacerKt {
    public static final void a(final GlanceModifier glanceModifier, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(1380468206);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 14) == 0) {
            i5 = (composerK.Z(glanceModifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i5 & 11) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (i6 != 0) {
                glanceModifier = GlanceModifier.f37605a;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(1380468206, i3, -1, "androidx.glance.layout.Spacer (Spacer.kt:43)");
            }
            SpacerKt$Spacer$1 spacerKt$Spacer$1 = SpacerKt$Spacer$1.f39507a;
            composerK.F(-1115894518);
            composerK.F(1886828752);
            if (!(composerK.m() instanceof Applier)) {
                ComposablesKt.c();
            }
            composerK.o();
            if (composerK.i()) {
                composerK.P(new GlanceNodeKt$GlanceNode$$inlined$ComposeNode$1(spacerKt$Spacer$1));
            } else {
                composerK.v();
            }
            Updater.e(Updater.a(composerK), glanceModifier, new Function2<EmittableSpacer, GlanceModifier, Unit>() { // from class: androidx.glance.layout.SpacerKt$Spacer$2$1
                public final void c(EmittableSpacer emittableSpacer, GlanceModifier glanceModifier2) {
                    emittableSpacer.b(glanceModifier2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableSpacer) obj, (GlanceModifier) obj2);
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
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.layout.SpacerKt$Spacer$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i7) {
                SpacerKt.a(glanceModifier, composer2, i3 | 1, i4);
            }
        });
    }
}
