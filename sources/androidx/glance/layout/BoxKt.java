package androidx.glance.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.glance.Applier;
import androidx.glance.GlanceModifier;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class BoxKt {
    public static final void a(GlanceModifier glanceModifier, Alignment alignment, final Function2 function2, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(1959221577);
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
            i5 |= 48;
        } else if ((i3 & 112) == 0) {
            i5 |= composerK.Z(alignment) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i3 & 896) == 0) {
            i5 |= composerK.Z(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 731) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (i6 != 0) {
                glanceModifier = GlanceModifier.f37605a;
            }
            if (i7 != 0) {
                alignment = Alignment.f39415c.i();
            }
            if (ComposerKt.M()) {
                ComposerKt.U(1959221577, i5, -1, "androidx.glance.layout.Box (Box.kt:61)");
            }
            BoxKt$Box$1 boxKt$Box$1 = BoxKt$Box$1.f39444a;
            composerK.F(578571862);
            int i8 = i5 & 896;
            composerK.F(-548224868);
            if (!(composerK.m() instanceof Applier)) {
                ComposablesKt.c();
            }
            composerK.o();
            if (composerK.i()) {
                composerK.P(boxKt$Box$1);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, glanceModifier, new Function2<EmittableBox, GlanceModifier, Unit>() { // from class: androidx.glance.layout.BoxKt$Box$2$1
                public final void c(EmittableBox emittableBox, GlanceModifier glanceModifier2) {
                    emittableBox.b(glanceModifier2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableBox) obj, (GlanceModifier) obj2);
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, alignment, new Function2<EmittableBox, Alignment, Unit>() { // from class: androidx.glance.layout.BoxKt$Box$2$2
                public final void c(EmittableBox emittableBox, Alignment alignment2) {
                    emittableBox.i(alignment2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableBox) obj, (Alignment) obj2);
                    return Unit.f139807a;
                }
            });
            function2.invoke(composerK, Integer.valueOf((i8 >> 6) & 14));
            composerK.y();
            composerK.Y();
            composerK.Y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        final Alignment alignment2 = alignment;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.layout.BoxKt$Box$3
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
                BoxKt.a(glanceModifier2, alignment2, function2, composer2, i3 | 1, i4);
            }
        });
    }
}
