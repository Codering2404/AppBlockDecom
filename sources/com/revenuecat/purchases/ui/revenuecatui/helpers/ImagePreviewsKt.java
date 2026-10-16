package com.revenuecat.purchases.ui.revenuecatui.helpers;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.painter.Painter;
import coil.ImageLoader;
import coil.request.ImageRequest;
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
public final class ImagePreviewsKt {
    private static final /* synthetic */ ProvidableCompositionLocal<ImageLoader> LocalPreviewImageLoader = CompositionLocalKt.g(new Function0<ImageLoader>() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.ImagePreviewsKt$LocalPreviewImageLoader$1
        @Override // kotlin.jvm.functions.Function0
        public final ImageLoader invoke() {
            return null;
        }
    });

    public static final /* synthetic */ void ProvidePreviewImageLoader(final ImageLoader imageLoader, final Function2 content, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(-887489443);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(content) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 17) == 16 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-887489443, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.ProvidePreviewImageLoader (ImagePreviews.kt:21)");
            }
            CompositionLocalKt.b(LocalPreviewImageLoader.d(null), content, composerK, (i4 & 112) | ProvidedValue.f24012i);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.helpers.ImagePreviewsKt.ProvidePreviewImageLoader.1
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
                    ImagePreviewsKt.ProvidePreviewImageLoader(imageLoader, content, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final ProvidableCompositionLocal<ImageLoader> getLocalPreviewImageLoader() {
        return LocalPreviewImageLoader;
    }

    public static final /* synthetic */ Painter getPreviewPlaceholderBlocking(ImageLoader imageLoader, ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageLoader, "<this>");
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        return null;
    }
}
