package com.revenuecat.purchases.ui.revenuecatui.customercenter.theme;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.view.WindowCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class CustomerCenterPreviewThemeKt {
    private static final ColorScheme DarkColorScheme;
    private static final ColorScheme LightColorScheme;

    static {
        long jD = ColorKt.d(4279199743L);
        Color.Companion companion = Color.f25715b;
        LightColorScheme = ColorSchemeKt.k(jD, companion.l(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, ColorKt.d(4294967295L), ColorKt.d(4280229663L), ColorKt.d(4293981433L), ColorKt.d(4280229663L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -122884, 15, null);
        DarkColorScheme = ColorSchemeKt.e(ColorKt.d(4286695300L), companion.a(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, ColorKt.d(4279374354L), ColorKt.d(4292927712L), ColorKt.d(4280953386L), ColorKt.d(4292927712L), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -122884, 15, null);
    }

    public static final void CustomerCenterPreviewTheme(Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i3) {
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(482903071);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(content) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
            function2 = content;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(482903071, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewTheme (CustomerCenterPreviewTheme.kt:36)");
            }
            final boolean zA = DarkThemeKt.a(composerK, 0);
            ColorScheme colorScheme = zA ? DarkColorScheme : LightColorScheme;
            final View view = (View) composerK.q(AndroidCompositionLocals_androidKt.j());
            composerK.a0(-1492930134);
            if (!view.isInEditMode()) {
                composerK.a0(-1492928745);
                boolean zI = composerK.I(view) | composerK.b(zA);
                Object objG = composerK.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt$CustomerCenterPreviewTheme$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1006invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1006invoke() {
                            Context context = view.getContext();
                            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                            WindowCompat.a(((Activity) context).getWindow(), view).d(!zA);
                        }
                    };
                    composerK.w(objG);
                }
                composerK.U();
                EffectsKt.j((Function0) objG, composerK, 0);
            }
            composerK.U();
            function2 = content;
            MaterialThemeKt.b(colorScheme, null, null, function2, composerK, (i4 << 9) & 7168, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme.2
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

                public final void invoke(Composer composer2, int i5) {
                    CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
