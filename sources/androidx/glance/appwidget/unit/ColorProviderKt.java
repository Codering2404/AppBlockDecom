package androidx.glance.appwidget.unit;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.content.ContextCompat;
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
public final class ColorProviderKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f39384a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f39385b = {-16842912};

    public static final int[] a() {
        return f39384a;
    }

    public static final Color b(Context context, int i3, boolean z2, Boolean bool) {
        if (i3 == 0) {
            return null;
        }
        if (bool != null) {
            Configuration configuration = new Configuration();
            configuration.uiMode = bool.booleanValue() ? 32 : 16;
            context = context.createConfigurationContext(configuration);
        }
        try {
            ColorStateList colorStateList = ContextCompat.getColorStateList(context, i3);
            if (colorStateList == null) {
                return null;
            }
            return Color.n(ColorKt.b(colorStateList.getColorForState(z2 ? f39384a : f39385b, colorStateList.getDefaultColor())));
        } catch (Resources.NotFoundException e3) {
            Log.w("GlanceAppWidget", "Could not resolve the checked color", e3);
            return null;
        }
    }

    public static /* synthetic */ Color c(Context context, int i3, boolean z2, Boolean bool, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            bool = null;
        }
        return b(context, i3, z2, bool);
    }
}
