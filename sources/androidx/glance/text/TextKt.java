package androidx.glance.text;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.glance.Applier;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceNodeKt$GlanceNode$$inlined$ComposeNode$1;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class TextKt {
    public static final void a(final String str, GlanceModifier glanceModifier, TextStyle textStyle, int i3, Composer composer, final int i4, final int i5) {
        int i6;
        Composer composerK = composer.k(-192911377);
        if ((i5 & 1) != 0) {
            i6 = i4 | 6;
        } else if ((i4 & 14) == 0) {
            i6 = (composerK.Z(str) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        int i7 = i5 & 2;
        if (i7 != 0) {
            i6 |= 48;
        } else if ((i4 & 112) == 0) {
            i6 |= composerK.Z(glanceModifier) ? 32 : 16;
        }
        if ((i4 & 896) == 0) {
            i6 |= ((i5 & 4) == 0 && composerK.Z(textStyle)) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i8 = i5 & 8;
        if (i8 != 0) {
            i6 |= 3072;
        } else if ((i4 & 7168) == 0) {
            i6 |= composerK.e(i3) ? 2048 : 1024;
        }
        if ((i6 & 5851) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            composerK.J();
            if ((i4 & 1) == 0 || composerK.S()) {
                if (i7 != 0) {
                    glanceModifier = GlanceModifier.f37605a;
                }
                if ((i5 & 4) != 0) {
                    textStyle = TextDefaults.f39763a.b();
                }
                if (i8 != 0) {
                    i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
            } else {
                composerK.Q();
            }
            composerK.z();
            if (ComposerKt.M()) {
                ComposerKt.U(-192911377, i4, -1, "androidx.glance.text.Text (Text.kt:38)");
            }
            TextKt$Text$1 textKt$Text$1 = TextKt$Text$1.f39767a;
            composerK.F(-1115894518);
            composerK.F(1886828752);
            if (!(composerK.m() instanceof Applier)) {
                ComposablesKt.c();
            }
            composerK.o();
            if (composerK.i()) {
                composerK.P(new GlanceNodeKt$GlanceNode$$inlined$ComposeNode$1(textKt$Text$1));
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, str, new Function2<EmittableText, String, Unit>() { // from class: androidx.glance.text.TextKt$Text$2$1
                public final void c(EmittableText emittableText, String str2) {
                    emittableText.h(str2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableText) obj, (String) obj2);
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, glanceModifier, new Function2<EmittableText, GlanceModifier, Unit>() { // from class: androidx.glance.text.TextKt$Text$2$2
                public final void c(EmittableText emittableText, GlanceModifier glanceModifier2) {
                    emittableText.b(glanceModifier2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableText) obj, (GlanceModifier) obj2);
                    return Unit.f139807a;
                }
            });
            Updater.e(composerA, textStyle, new Function2<EmittableText, TextStyle, Unit>() { // from class: androidx.glance.text.TextKt$Text$2$3
                public final void c(EmittableText emittableText, TextStyle textStyle2) {
                    emittableText.g(textStyle2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableText) obj, (TextStyle) obj2);
                    return Unit.f139807a;
                }
            });
            TextKt$Text$2$4 textKt$Text$2$4 = new Function2<EmittableText, Integer, Unit>() { // from class: androidx.glance.text.TextKt$Text$2$4
                public final void c(EmittableText emittableText, int i9) {
                    emittableText.f(i9);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((EmittableText) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }
            };
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(i3))) {
                composerA.w(Integer.valueOf(i3));
                composerA.p(Integer.valueOf(i3), textKt$Text$2$4);
            }
            composerK.y();
            composerK.Y();
            composerK.Y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        final GlanceModifier glanceModifier2 = glanceModifier;
        final TextStyle textStyle2 = textStyle;
        final int i9 = i3;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.glance.text.TextKt$Text$3
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
                TextKt.a(str, glanceModifier2, textStyle2, i9, composer2, i4 | 1, i5);
            }
        });
    }
}
