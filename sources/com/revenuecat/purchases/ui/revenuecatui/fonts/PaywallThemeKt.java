package com.revenuecat.purchases.ui.revenuecatui.fonts;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.revenuecat.purchases.ui.revenuecatui.extensions.TypographyExtensionsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PaywallThemeKt {
    public static final void PaywallTheme(final FontProvider fontProvider, Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i3) {
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(1433874321);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(fontProvider) : composerK.I(fontProvider) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(content) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
            function2 = content;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1433874321, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.fonts.PaywallTheme (PaywallTheme.kt:10)");
            }
            if (fontProvider == null) {
                composerK.a0(1090937919);
                content.invoke(composerK, Integer.valueOf((i4 >> 3) & 14));
                composerK.U();
                function2 = content;
            } else {
                composerK.a0(1090975739);
                MaterialTheme materialTheme = MaterialTheme.f18110a;
                int i5 = MaterialTheme.f18111b;
                function2 = content;
                MaterialThemeKt.b(materialTheme.a(composerK, i5), materialTheme.b(composerK, i5), TypographyExtensionsKt.copyWithFontProvider(materialTheme.c(composerK, i5), fontProvider), function2, composerK, (i4 << 6) & 7168, 0);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.fonts.PaywallThemeKt.PaywallTheme.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    PaywallThemeKt.PaywallTheme(fontProvider, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
