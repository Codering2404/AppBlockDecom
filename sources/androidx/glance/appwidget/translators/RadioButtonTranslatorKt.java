package androidx.glance.appwidget.translators;

import android.content.Context;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.appwidget.ApplyModifiersKt;
import androidx.glance.appwidget.EmittableRadioButton;
import androidx.glance.appwidget.InsertedViewInfo;
import androidx.glance.appwidget.LayoutSelectionKt;
import androidx.glance.appwidget.LayoutType;
import androidx.glance.appwidget.R;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.appwidget.UtilsKt;
import androidx.glance.appwidget.unit.CheckableColorProvider;
import androidx.glance.appwidget.unit.CheckedUncheckedColorProvider;
import androidx.glance.appwidget.unit.ResourceCheckableColorProvider;
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
public final class RadioButtonTranslatorKt {
    public static final void a(RemoteViews remoteViews, TranslationContext translationContext, EmittableRadioButton emittableRadioButton) {
        RemoteViews remoteViews2;
        TranslationContext translationContext2;
        int iB;
        int i3 = Build.VERSION.SDK_INT;
        LayoutType layoutType = i3 >= 31 ? LayoutType.RadioButton : LayoutType.RadioButtonBackport;
        Context contextN = translationContext.n();
        InsertedViewInfo insertedViewInfoD = LayoutSelectionKt.d(remoteViews, translationContext, layoutType, emittableRadioButton.a());
        if (i3 >= 31) {
            iB = insertedViewInfoD.e();
            CompoundButtonApi31Impl.f39371a.a(remoteViews, insertedViewInfoD.e(), emittableRadioButton.c());
            CheckableColorProvider checkableColorProviderA = emittableRadioButton.d().a();
            if (checkableColorProviderA instanceof CheckedUncheckedColorProvider) {
                DayNightColorStateList dayNightColorStateListE = CompoundButtonTranslatorKt.e((CheckedUncheckedColorProvider) checkableColorProviderA, contextN);
                RemoteViewsCompat.c(remoteViews, insertedViewInfoD.e(), dayNightColorStateListE.a(), dayNightColorStateListE.b());
            } else if (checkableColorProviderA instanceof ResourceCheckableColorProvider) {
                RemoteViewsCompat.b(remoteViews, insertedViewInfoD.e(), ((ResourceCheckableColorProvider) checkableColorProviderA).a());
            }
            remoteViews2 = remoteViews;
            translationContext2 = translationContext;
        } else {
            remoteViews2 = remoteViews;
            translationContext2 = translationContext;
            iB = UtilsKt.b(remoteViews2, translationContext2, R.id.I0, 0, null, 12, null);
            int iB2 = UtilsKt.b(remoteViews2, translationContext2, R.id.H0, 0, null, 12, null);
            UtilsKt.d(remoteViews2, iB2, emittableRadioButton.c());
            CompoundButtonTranslatorKt.c(remoteViews2, iB2, CompoundButtonTranslatorKt.b(emittableRadioButton.d().a(), contextN, emittableRadioButton.c()));
        }
        TextTranslatorKt.a(remoteViews2, translationContext2, iB, emittableRadioButton.h(), emittableRadioButton.g(), emittableRadioButton.f(), 16);
        remoteViews2.setBoolean(insertedViewInfoD.e(), "setEnabled", emittableRadioButton.e());
        ApplyModifiersKt.c(translationContext2, remoteViews2, emittableRadioButton.a(), insertedViewInfoD);
    }
}
