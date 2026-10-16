package androidx.glance.appwidget.translators;

import android.content.res.ColorStateList;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.appwidget.ApplyModifiersKt;
import androidx.glance.appwidget.EmittableCircularProgressIndicator;
import androidx.glance.appwidget.InsertedViewInfo;
import androidx.glance.appwidget.LayoutSelectionKt;
import androidx.glance.appwidget.LayoutType;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.color.DayNightColorProvider;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.FixedColorProvider;
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
public final class CircularProgressIndicatorTranslatorKt {
    public static final void a(RemoteViews remoteViews, TranslationContext translationContext, EmittableCircularProgressIndicator emittableCircularProgressIndicator) {
        InsertedViewInfo insertedViewInfoD = LayoutSelectionKt.d(remoteViews, translationContext, LayoutType.CircularProgressIndicator, emittableCircularProgressIndicator.a());
        remoteViews.setProgressBar(insertedViewInfoD.e(), 0, 0, true);
        if (Build.VERSION.SDK_INT >= 31) {
            ColorProvider colorProviderC = emittableCircularProgressIndicator.c();
            if (colorProviderC instanceof FixedColorProvider) {
                RemoteViewsCompat.l(remoteViews, insertedViewInfoD.e(), ColorStateList.valueOf(ColorKt.k(((FixedColorProvider) colorProviderC).b())));
            } else if (colorProviderC instanceof ResourceColorProvider) {
                RemoteViewsCompat.k(remoteViews, insertedViewInfoD.e(), ((ResourceColorProvider) colorProviderC).b());
            } else if (colorProviderC instanceof DayNightColorProvider) {
                DayNightColorProvider dayNightColorProvider = (DayNightColorProvider) colorProviderC;
                RemoteViewsCompat.m(remoteViews, insertedViewInfoD.e(), ColorStateList.valueOf(ColorKt.k(dayNightColorProvider.c())), ColorStateList.valueOf(ColorKt.k(dayNightColorProvider.d())));
            } else {
                Log.w("GlanceAppWidget", "Unexpected progress indicator color: " + colorProviderC);
            }
        }
        ApplyModifiersKt.c(translationContext, remoteViews, emittableCircularProgressIndicator.a(), insertedViewInfoD);
    }
}
