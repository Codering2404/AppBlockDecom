package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ShadowStyleKt {
    public static final /* synthetic */ ShadowStyle rememberShadowStyle(ShadowStyles shadow, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        composer.a0(1695935038);
        if (ComposerKt.M()) {
            ComposerKt.U(1695935038, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.rememberShadowStyle (ShadowStyle.kt:55)");
        }
        ColorStyle forCurrentTheme = ColorStyleKt.getForCurrentTheme(shadow.getColors(), composer, 0);
        composer.a0(-634727445);
        boolean Z = composer.Z(forCurrentTheme);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            Object shadowStyle = new ShadowStyle(forCurrentTheme, shadow.m802getRadiusD9Ej5fM(), shadow.m803getXD9Ej5fM(), shadow.m804getYD9Ej5fM(), null);
            composer.w(shadowStyle);
            objG = shadowStyle;
        }
        ShadowStyle shadowStyle2 = (ShadowStyle) objG;
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return shadowStyle2;
    }

    public static final /* synthetic */ Result toShadowStyles(Shadow shadow, Map aliases) {
        Intrinsics.checkNotNullParameter(shadow, "<this>");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Result colorStyles = ColorStyleKt.toColorStyles(shadow.getColor(), aliases);
        if (colorStyles instanceof Result.Success) {
            return new Result.Success(new ShadowStyles((ColorStyles) ((Result.Success) colorStyles).getValue(), Dp.g((float) shadow.getRadius()), Dp.g((float) shadow.getX()), Dp.g((float) shadow.getY()), null));
        }
        if (colorStyles instanceof Result.Error) {
            return colorStyles;
        }
        throw new NoWhenBranchMatchedException();
    }
}
