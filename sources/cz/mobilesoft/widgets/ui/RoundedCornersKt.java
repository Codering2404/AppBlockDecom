package cz.mobilesoft.widgets.ui;

import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import androidx.glance.BackgroundKt;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.ImageKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.unit.ColorProvider;
import cz.mobilesoft.widgets.R;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RoundedCornersKt {
    public static final GlanceModifier a(GlanceModifier glanceModifier, boolean z2, ColorProvider backgroundColor, int i3, Composer composer, int i4, int i5) {
        GlanceModifier glanceModifierC;
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        composer.F(1769293721);
        if ((i5 & 1) != 0) {
            z2 = true;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1769293721, i4, -1, "cz.mobilesoft.widgets.ui.roundedCorners (RoundedCorners.kt:30)");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            glanceModifierC = BackgroundKt.a(glanceModifier, backgroundColor);
            if (z2) {
                glanceModifierC = CornerRadiusKt.a(glanceModifierC, Dp.g(16));
            }
        } else {
            glanceModifierC = BackgroundKt.c(glanceModifier, ImageKt.b(i3), 0, 2, null);
        }
        GlanceModifier glanceModifierA = glanceModifier.a(glanceModifierC);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return glanceModifierA;
    }

    public static final GlanceModifier b(GlanceModifier glanceModifier, boolean z2, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        composer.F(-1905469158);
        boolean z3 = (i4 & 1) != 0 ? true : z2;
        if (ComposerKt.M()) {
            ComposerKt.U(-1905469158, i3, -1, "cz.mobilesoft.widgets.ui.roundedCornersAccent (RoundedCorners.kt:49)");
        }
        GlanceModifier glanceModifierA = a(glanceModifier, z3, GlanceTheme.f37608a.a(composer, GlanceTheme.f37609b).g(), R.drawable.f133938c, composer, i3 & 126, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return glanceModifierA;
    }

    public static final GlanceModifier c(GlanceModifier glanceModifier, boolean z2, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        composer.F(1636144438);
        boolean z3 = (i4 & 1) != 0 ? true : z2;
        if (ComposerKt.M()) {
            ComposerKt.U(1636144438, i3, -1, "cz.mobilesoft.widgets.ui.roundedCornersBackground (RoundedCorners.kt:42)");
        }
        GlanceModifier glanceModifierA = a(glanceModifier, z3, GlanceTheme.f37608a.a(composer, GlanceTheme.f37609b).a(), R.drawable.f133937b, composer, i3 & 126, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return glanceModifierA;
    }

    public static final GlanceModifier d(GlanceModifier glanceModifier, boolean z2, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(glanceModifier, "<this>");
        composer.F(-726080157);
        boolean z3 = (i4 & 1) != 0 ? true : z2;
        if (ComposerKt.M()) {
            ComposerKt.U(-726080157, i3, -1, "cz.mobilesoft.widgets.ui.roundedCornersSurface (RoundedCorners.kt:56)");
        }
        GlanceModifier glanceModifierA = a(glanceModifier, z3, GlanceTheme.f37608a.a(composer, GlanceTheme.f37609b).i(), R.drawable.f133939d, composer, i3 & 126, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return glanceModifierA;
    }
}
