package androidx.glance.appwidget.translators;

import android.widget.RemoteViews;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.color.DayNightColorProvider;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.ResourceColorProvider;
import kotlin.Metadata;

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
final class ImageTranslatorApi31Impl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImageTranslatorApi31Impl f39376a = new ImageTranslatorApi31Impl();

    private ImageTranslatorApi31Impl() {
    }

    public final void a(TranslationContext translationContext, RemoteViews remoteViews, ColorProvider colorProvider, int i3) {
        if (colorProvider instanceof DayNightColorProvider) {
            DayNightColorProvider dayNightColorProvider = (DayNightColorProvider) colorProvider;
            ImageTranslatorKt.c(remoteViews, i3, dayNightColorProvider.c(), dayNightColorProvider.d());
        } else if (colorProvider instanceof ResourceColorProvider) {
            RemoteViewsCompat.h(remoteViews, i3, ((ResourceColorProvider) colorProvider).b());
        } else {
            RemoteViewsCompat.f(remoteViews, i3, ColorKt.k(colorProvider.a(translationContext.n())));
        }
    }
}
