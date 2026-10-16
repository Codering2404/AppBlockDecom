package androidx.glance.appwidget.translators;

import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.appwidget.ApplyModifiersKt;
import androidx.glance.appwidget.EmittableCheckBox;
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
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;

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
public final class CheckBoxTranslatorKt {
    public static final void a(RemoteViews remoteViews, TranslationContext translationContext, EmittableCheckBox emittableCheckBox) {
        RemoteViews remoteViews2;
        TranslationContext translationContext2;
        int i3;
        int iB;
        int i4 = Build.VERSION.SDK_INT;
        InsertedViewInfo insertedViewInfoD = LayoutSelectionKt.d(remoteViews, translationContext, i4 >= 31 ? LayoutType.CheckBox : LayoutType.CheckBoxBackport, emittableCheckBox.a());
        if (i4 >= 31) {
            remoteViews2 = remoteViews;
            translationContext2 = translationContext;
            iB = UtilsKt.b(remoteViews2, translationContext2, R.id.f38207a, 0, null, 12, null);
            CompoundButtonApi31Impl.f39371a.a(remoteViews2, iB, emittableCheckBox.c());
            CheckableColorProvider checkableColorProviderA = emittableCheckBox.d().a();
            if (checkableColorProviderA instanceof CheckedUncheckedColorProvider) {
                DayNightColorStateList dayNightColorStateListE = CompoundButtonTranslatorKt.e((CheckedUncheckedColorProvider) checkableColorProviderA, translationContext2.n());
                RemoteViewsCompat.c(remoteViews2, iB, dayNightColorStateListE.a(), dayNightColorStateListE.b());
            } else {
                if (!(checkableColorProviderA instanceof ResourceCheckableColorProvider)) {
                    throw new NoWhenBranchMatchedException();
                }
                RemoteViewsCompat.b(remoteViews2, iB, ((ResourceCheckableColorProvider) checkableColorProviderA).a());
            }
            Unit unit = Unit.f139807a;
            i3 = iB;
        } else {
            remoteViews2 = remoteViews;
            translationContext2 = translationContext;
            int iB2 = UtilsKt.b(remoteViews2, translationContext2, R.id.f38209b, 0, null, 12, null);
            int iB3 = UtilsKt.b(remoteViews2, translationContext2, R.id.f38211c, 0, null, 12, null);
            int iE = insertedViewInfoD.e();
            UtilsKt.d(remoteViews2, iB2, emittableCheckBox.c());
            CompoundButtonTranslatorKt.c(remoteViews2, iB2, CompoundButtonTranslatorKt.b(emittableCheckBox.d().a(), translationContext2.n(), emittableCheckBox.c()));
            i3 = iB3;
            iB = iE;
        }
        TextTranslatorKt.a(remoteViews2, translationContext2, i3, emittableCheckBox.g(), emittableCheckBox.f(), emittableCheckBox.e(), 16);
        ApplyModifiersKt.c(translationContext2.d(iB), remoteViews2, emittableCheckBox.a(), insertedViewInfoD);
    }
}
