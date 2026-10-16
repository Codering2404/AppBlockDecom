package androidx.glance.appwidget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RemoteViews;
import androidx.compose.ui.unit.Dp;
import androidx.core.widget.RemoteViewsCompat;
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
public final class UtilsKt {
    public static final int a(RemoteViews remoteViews, TranslationContext translationContext, int i3, int i4, Integer num) {
        if (i3 == -1) {
            throw new IllegalArgumentException("viewStubId must not be View.NO_ID");
        }
        int iIntValue = num != null ? num.intValue() : translationContext.x();
        if (iIntValue != -1) {
            RemoteViewsCompat.I(remoteViews, i3, iIntValue);
        }
        if (i4 != 0) {
            RemoteViewsCompat.J(remoteViews, i3, i4);
        }
        remoteViews.setViewVisibility(i3, 0);
        return iIntValue;
    }

    public static /* synthetic */ int b(RemoteViews remoteViews, TranslationContext translationContext, int i3, int i4, Integer num, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        if ((i5 & 8) != 0) {
            num = null;
        }
        return a(remoteViews, translationContext, i3, i4, num);
    }

    public static final float c(int i3, DisplayMetrics displayMetrics) {
        return Dp.g(i3 / displayMetrics.density);
    }

    public static final void d(RemoteViews remoteViews, int i3, boolean z2) {
        remoteViews.setBoolean(i3, "setEnabled", z2);
    }

    public static final int e(float f3, Context context) {
        return f(f3, context.getResources().getDisplayMetrics());
    }

    public static final int f(float f3, DisplayMetrics displayMetrics) {
        return (int) TypedValue.applyDimension(1, f3, displayMetrics);
    }
}
