package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import android.content.Context;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import coil.ImageLoader;
import coil.compose.AsyncImagePainter;
import coil.compose.AsyncImagePainterKt;
import coil.request.CachePolicy;
import coil.request.ImageRequest;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.FitModeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ThemeImageUrlsKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PurchasesExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ImagePreviewsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
public final class BackgroundStyleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void Background_Preview_ColorGradientLinear(Composer composer, final int i3) {
        Composer composerK = composer.k(1587277957);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1587277957, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.Background_Preview_ColorGradientLinear (BackgroundStyle.kt:232)");
            }
            Modifier modifierO = SizeKt.o(Modifier.b8, Dp.g(100));
            Color.Companion companion = Color.f25715b;
            BoxKt.a(BackgroundKt.background$default(modifierO, BackgroundStyle.Color.m746boximpl(BackgroundStyle.Color.m747constructorimpl(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(90.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.k(companion.i()), 0.0f), new ColorInfo.Gradient.Point(ColorKt.k(companion.f()), 50.0f), new ColorInfo.Gradient.Point(ColorKt.k(companion.b()), 100.0f)}))))), (Shape) null, 2, (Object) null), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt.Background_Preview_ColorGradientLinear.1
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
                    BackgroundStyleKt.Background_Preview_ColorGradientLinear(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Background_Preview_ColorGradientRadial(Composer composer, final int i3) {
        Composer composerK = composer.k(1823976651);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1823976651, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.Background_Preview_ColorGradientRadial (BackgroundStyle.kt:262)");
            }
            Modifier modifierO = SizeKt.o(Modifier.b8, Dp.g(100));
            Color.Companion companion = Color.f25715b;
            BoxKt.a(BackgroundKt.background$default(modifierO, BackgroundStyle.Color.m746boximpl(BackgroundStyle.Color.m747constructorimpl(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.k(companion.i()), 0.0f), new ColorInfo.Gradient.Point(ColorKt.k(companion.f()), 50.0f), new ColorInfo.Gradient.Point(ColorKt.k(companion.b()), 100.0f)}))))), (Shape) null, 2, (Object) null), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt.Background_Preview_ColorGradientRadial.1
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
                    BackgroundStyleKt.Background_Preview_ColorGradientRadial(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Background_Preview_ColorHex(Composer composer, final int i3) {
        Composer composerK = composer.k(529543697);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(529543697, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.Background_Preview_ColorHex (BackgroundStyle.kt:222)");
            }
            BoxKt.a(BackgroundKt.background$default(SizeKt.o(Modifier.b8, Dp.g(100)), BackgroundStyle.Color.m746boximpl(BackgroundStyle.Color.m747constructorimpl(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.i())))), (Shape) null, 2, (Object) null), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt.Background_Preview_ColorHex.1
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
                    BackgroundStyleKt.Background_Preview_ColorHex(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final ImageRequest getImageRequest(Context context, String str, CachePolicy cachePolicy) {
        return new ImageRequest.Builder(context).d(str).g(cachePolicy).i(cachePolicy).a();
    }

    private static final AsyncImagePainter rememberAsyncImagePainter(ImageUrls imageUrls, ContentScale contentScale, Composer composer, int i3) {
        ImageLoader imageLoader;
        ImageRequest imageRequest;
        Painter painterD;
        composer.a0(618155120);
        if (ComposerKt.M()) {
            ComposerKt.U(618155120, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.rememberAsyncImagePainter (BackgroundStyle.kt:178)");
        }
        composer.a0(756632259);
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = SnapshotStateKt__SnapshotStateKt.e(CachePolicy.ENABLED, null, 2, null);
            composer.w(objG);
        }
        final MutableState mutableState = (MutableState) objG;
        composer.U();
        Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
        ImageLoader imageLoader2 = (ImageLoader) composer.q(ImagePreviewsKt.getLocalPreviewImageLoader());
        boolean zIsInPreviewMode = HelperFunctionsKt.isInPreviewMode(composer, 0);
        ImageLoader imageLoader3 = zIsInPreviewMode ? imageLoader2 : null;
        composer.a0(756639231);
        if (imageLoader3 == null) {
            composer.a0(756640750);
            boolean Z = composer.Z(context);
            Object objG2 = composer.G();
            if (Z || objG2 == companion.a()) {
                Purchases.Companion companion2 = Purchases.Companion;
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                objG2 = PurchasesExtensionsKt.getImageLoaderTyped(companion2, applicationContext);
                composer.w(objG2);
            }
            imageLoader3 = (ImageLoader) objG2;
            composer.U();
        }
        composer.U();
        Object webp = imageUrls.getWebp();
        Object objRememberAsyncImagePainter$lambda$7 = rememberAsyncImagePainter$lambda$7(mutableState);
        composer.a0(756644466);
        boolean Z2 = composer.Z(webp) | composer.Z(context) | composer.Z(objRememberAsyncImagePainter$lambda$7);
        Object objG3 = composer.G();
        if (Z2 || objG3 == companion.a()) {
            String string = imageUrls.getWebp().toString();
            Intrinsics.checkNotNullExpressionValue(string, "imageUrls.webp.toString()");
            objG3 = getImageRequest(context, string, rememberAsyncImagePainter$lambda$7(mutableState));
            composer.w(objG3);
        }
        ImageRequest imageRequest2 = (ImageRequest) objG3;
        composer.U();
        composer.a0(756652882);
        if (!zIsInPreviewMode || imageLoader2 == null) {
            String string2 = imageUrls.getWebpLowRes().toString();
            Intrinsics.checkNotNullExpressionValue(string2, "imageUrls.webpLowRes.toString()");
            imageLoader = imageLoader3;
            imageRequest = imageRequest2;
            painterD = AsyncImagePainterKt.d(getImageRequest(context, string2, rememberAsyncImagePainter$lambda$7(mutableState)), imageLoader, null, null, null, null, null, null, contentScale, 0, composer, ((i3 << 21) & 234881024) | 27648, 740);
        } else {
            painterD = ImagePreviewsKt.getPreviewPlaceholderBlocking(imageLoader3, imageRequest2);
            imageLoader = imageLoader3;
            imageRequest = imageRequest2;
        }
        Painter painter = painterD;
        composer.U();
        composer.a0(756669032);
        Object objG4 = composer.G();
        if (objG4 == companion.a()) {
            objG4 = new Function1<AsyncImagePainter.State.Error, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt$rememberAsyncImagePainter$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((AsyncImagePainter.State.Error) obj);
                    return Unit.f139807a;
                }

                public final void invoke(AsyncImagePainter.State.Error it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Logger.INSTANCE.w("AsyncImagePainter failed to load. Will try again disabling cache");
                    mutableState.setValue(CachePolicy.WRITE_ONLY);
                }
            };
            composer.w(objG4);
        }
        composer.U();
        AsyncImagePainter asyncImagePainterD = AsyncImagePainterKt.d(imageRequest, imageLoader, painter, null, null, null, null, (Function1) objG4, contentScale, 0, composer, ((i3 << 21) & 234881024) | 12610560, 608);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return asyncImagePainterD;
    }

    private static final CachePolicy rememberAsyncImagePainter$lambda$7(MutableState<CachePolicy> mutableState) {
        return (CachePolicy) mutableState.getValue();
    }

    public static final /* synthetic */ BackgroundStyle rememberBackgroundStyle(BackgroundStyles background, Composer composer, int i3) {
        BackgroundStyle backgroundStyleM746boximpl;
        Intrinsics.checkNotNullParameter(background, "background");
        composer.a0(1019071422);
        if (ComposerKt.M()) {
            ComposerKt.U(1019071422, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.rememberBackgroundStyle (BackgroundStyle.kt:143)");
        }
        boolean z2 = true;
        if (background instanceof BackgroundStyles.Color) {
            composer.a0(-1590418969);
            ColorStyle forCurrentTheme = ColorStyleKt.getForCurrentTheme(((BackgroundStyles.Color) background).m759unboximpl(), composer, 0);
            composer.a0(779982346);
            if ((((i3 & 14) ^ 6) <= 4 || !composer.Z(background)) && (i3 & 6) != 4) {
                z2 = false;
            }
            boolean Z = composer.Z(forCurrentTheme) | z2;
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = BackgroundStyle.Color.m746boximpl(BackgroundStyle.Color.m747constructorimpl(forCurrentTheme));
                composer.w(objG);
            }
            ColorStyle colorStyleM752unboximpl = ((BackgroundStyle.Color) objG).m752unboximpl();
            composer.U();
            composer.U();
            backgroundStyleM746boximpl = BackgroundStyle.Color.m746boximpl(colorStyleM752unboximpl);
        } else if (background instanceof BackgroundStyles.Image) {
            composer.a0(-1590195521);
            BackgroundStyles.Image image = (BackgroundStyles.Image) background;
            ColorStyles colorOverlay = image.getColorOverlay();
            composer.a0(779988729);
            ColorStyle forCurrentTheme2 = colorOverlay == null ? null : ColorStyleKt.getForCurrentTheme(colorOverlay, composer, 0);
            composer.U();
            ImageUrls urlsForCurrentTheme = ThemeImageUrlsKt.getUrlsForCurrentTheme(image.getSources(), composer, 0);
            AsyncImagePainter asyncImagePainterRememberAsyncImagePainter = rememberAsyncImagePainter(urlsForCurrentTheme, image.getContentScale(), composer, 0);
            composer.a0(779994638);
            boolean Z2 = composer.Z(urlsForCurrentTheme) | composer.Z(forCurrentTheme2) | composer.Z(asyncImagePainterRememberAsyncImagePainter);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new BackgroundStyle.Image(asyncImagePainterRememberAsyncImagePainter, image.getContentScale(), forCurrentTheme2);
                composer.w(objG2);
            }
            backgroundStyleM746boximpl = (BackgroundStyle.Image) objG2;
            composer.U();
            composer.U();
        } else {
            if (!(background instanceof BackgroundStyles.Video)) {
                composer.a0(779791050);
                composer.U();
                throw new NoWhenBranchMatchedException();
            }
            composer.a0(-1589658663);
            composer.a0(780005105);
            if ((((i3 & 14) ^ 6) <= 4 || !composer.Z(background)) && (i3 & 6) != 4) {
                z2 = false;
            }
            Object objG3 = composer.G();
            if (z2 || objG3 == Composer.f23746a.a()) {
                BackgroundStyles.Video video = (BackgroundStyles.Video) background;
                Object video2 = new BackgroundStyle.Video(video.getSources(), video.getFallbackImage(), video.getLoop(), video.getMuteAudio(), video.getContentScale(), video.getColorOverlay());
                composer.w(video2);
                objG3 = video2;
            }
            backgroundStyleM746boximpl = (BackgroundStyle.Video) objG3;
            composer.U();
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return backgroundStyleM746boximpl;
    }

    public static final /* synthetic */ Result toBackgroundStyles(Background background, Map aliases) {
        Intrinsics.checkNotNullParameter(background, "<this>");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        if (background instanceof Background.Color) {
            Result colorStyles = ColorStyleKt.toColorStyles(((Background.Color) background).getValue(), aliases);
            if (colorStyles instanceof Result.Success) {
                return new Result.Success(BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl((ColorStyles) ((Result.Success) colorStyles).getValue())));
            }
            if (colorStyles instanceof Result.Error) {
                return colorStyles;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (background instanceof Background.Image) {
            Background.Image image = (Background.Image) background;
            ColorScheme colorOverlay = image.getColorOverlay();
            Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(colorOverlay != null ? ColorStyleKt.toColorStyles(colorOverlay, aliases) : null);
            if (resultOrSuccessfullyNull instanceof Result.Success) {
                return new Result.Success(new BackgroundStyles.Image(image.getValue(), FitModeKt.toContentScale(image.getFitMode()), (ColorStyles) ((Result.Success) resultOrSuccessfullyNull).getValue()));
            }
            if (resultOrSuccessfullyNull instanceof Result.Error) {
                return resultOrSuccessfullyNull;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!(background instanceof Background.Video)) {
            if (background instanceof Background.Unknown) {
                return new Result.Error(NonEmptyListKt.nonEmptyListOf(new PaywallValidationError.UnsupportedBackgroundType((Background.Unknown) background), new PaywallValidationError.UnsupportedBackgroundType[0]));
            }
            throw new NoWhenBranchMatchedException();
        }
        Background.Video video = (Background.Video) background;
        ColorScheme colorOverlay2 = video.getColorOverlay();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(colorOverlay2 != null ? ColorStyleKt.toColorStyles(colorOverlay2, aliases) : null);
        if (resultOrSuccessfullyNull2 instanceof Result.Success) {
            return new Result.Success(new BackgroundStyles.Video(video.getValue(), video.getFallbackImage(), video.getLoop(), video.getMuteAudio(), FitModeKt.toContentScale(video.getFitMode()), (ColorStyles) ((Result.Success) resultOrSuccessfullyNull2).getValue()));
        }
        if (resultOrSuccessfullyNull2 instanceof Result.Error) {
            return resultOrSuccessfullyNull2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
