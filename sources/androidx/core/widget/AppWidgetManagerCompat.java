package androidx.core.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.res.Resources;
import android.widget.RemoteViews;
import androidx.core.util.SizeFCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class AppWidgetManagerCompat {
    public static final boolean a(SizeFCompat sizeFCompat, SizeFCompat other) {
        Intrinsics.checkNotNullParameter(sizeFCompat, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        float f3 = 1;
        return ((float) Math.ceil((double) sizeFCompat.b())) + f3 >= other.b() && ((float) Math.ceil((double) sizeFCompat.a())) + f3 >= other.a();
    }

    public static final RemoteViews b(AppWidgetManager appWidgetManager, int i3, Function1 factory) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "appWidgetManager");
        Intrinsics.checkNotNullParameter(factory, "factory");
        return (RemoteViews) factory.invoke(d(appWidgetManager, i3));
    }

    public static final float c(SizeFCompat sizeFCompat) {
        Intrinsics.checkNotNullParameter(sizeFCompat, "<this>");
        return sizeFCompat.b() * sizeFCompat.a();
    }

    public static final SizeFCompat d(AppWidgetManager appWidgetManager, int i3) {
        Intrinsics.checkNotNullParameter(appWidgetManager, "<this>");
        AppWidgetProviderInfo appWidgetInfo = appWidgetManager.getAppWidgetInfo(i3);
        return new SizeFCompat(e(appWidgetInfo.minWidth), e(appWidgetInfo.minHeight));
    }

    private static final float e(int i3) {
        return i3 / Resources.getSystem().getDisplayMetrics().density;
    }
}
