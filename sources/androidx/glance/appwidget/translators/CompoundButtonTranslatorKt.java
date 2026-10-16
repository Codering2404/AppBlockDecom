package androidx.glance.appwidget.translators;

import android.content.Context;
import android.content.res.ColorStateList;
import android.widget.RemoteViews;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.appwidget.unit.CheckableColorProvider;
import androidx.glance.appwidget.unit.CheckedUncheckedColorProvider;
import androidx.glance.appwidget.unit.ColorProviderKt;
import androidx.glance.appwidget.unit.ResourceCheckableColorProvider;
import androidx.glance.color.DayNightColorProvidersKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

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
public final class CompoundButtonTranslatorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f39372a = Color.f25715b.a();

    private static final ColorStateList a(long j3, long j4) {
        return new ColorStateList(new int[][]{ColorProviderKt.a(), new int[0]}, new int[]{ColorKt.k(j3), ColorKt.k(j4)});
    }

    public static final long b(CheckableColorProvider checkableColorProvider, Context context, boolean z2) {
        Color colorC;
        if (checkableColorProvider instanceof CheckedUncheckedColorProvider) {
            colorC = Color.n(((CheckedUncheckedColorProvider) checkableColorProvider).a(context, DayNightColorProvidersKt.b(context), z2));
        } else {
            if (!(checkableColorProvider instanceof ResourceCheckableColorProvider)) {
                throw new NoWhenBranchMatchedException();
            }
            colorC = ColorProviderKt.c(context, ((ResourceCheckableColorProvider) checkableColorProvider).a(), z2, null, 8, null);
        }
        return colorC != null ? colorC.B() : f39372a;
    }

    public static final void c(RemoteViews remoteViews, int i3, long j3) {
        RemoteViewsCompat.f(remoteViews, i3, ColorKt.k(j3));
    }

    private static final ColorStateList d(CheckedUncheckedColorProvider checkedUncheckedColorProvider, Context context, boolean z2) {
        return a(checkedUncheckedColorProvider.a(context, z2, true), checkedUncheckedColorProvider.a(context, z2, false));
    }

    public static final DayNightColorStateList e(CheckedUncheckedColorProvider checkedUncheckedColorProvider, Context context) {
        return new DayNightColorStateList(d(checkedUncheckedColorProvider, context, false), d(checkedUncheckedColorProvider, context, true));
    }
}
