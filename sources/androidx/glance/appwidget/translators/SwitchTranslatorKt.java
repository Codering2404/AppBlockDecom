package androidx.glance.appwidget.translators;

import android.content.Context;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.appwidget.ApplyModifiersKt;
import androidx.glance.appwidget.EmittableSwitch;
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
public final class SwitchTranslatorKt {
    public static final void a(RemoteViews remoteViews, TranslationContext translationContext, EmittableSwitch emittableSwitch) {
        RemoteViews remoteViews2;
        TranslationContext translationContext2;
        int iB;
        int i3 = Build.VERSION.SDK_INT;
        LayoutType layoutType = i3 >= 31 ? LayoutType.Swtch : LayoutType.SwtchBackport;
        Context contextN = translationContext.n();
        InsertedViewInfo insertedViewInfoD = LayoutSelectionKt.d(remoteViews, translationContext, layoutType, emittableSwitch.a());
        if (i3 >= 31) {
            iB = insertedViewInfoD.e();
            CompoundButtonApi31Impl.f39371a.a(remoteViews, insertedViewInfoD.e(), emittableSwitch.c());
            CheckableColorProvider checkableColorProviderA = emittableSwitch.d().a();
            if (checkableColorProviderA instanceof CheckedUncheckedColorProvider) {
                DayNightColorStateList dayNightColorStateListE = CompoundButtonTranslatorKt.e((CheckedUncheckedColorProvider) checkableColorProviderA, contextN);
                RemoteViewsCompat.u(remoteViews, insertedViewInfoD.e(), dayNightColorStateListE.a(), dayNightColorStateListE.b());
            } else {
                if (!(checkableColorProviderA instanceof ResourceCheckableColorProvider)) {
                    throw new NoWhenBranchMatchedException();
                }
                RemoteViewsCompat.t(remoteViews, insertedViewInfoD.e(), ((ResourceCheckableColorProvider) checkableColorProviderA).a());
            }
            Unit unit = Unit.f139807a;
            CheckableColorProvider checkableColorProviderB = emittableSwitch.d().b();
            if (checkableColorProviderB instanceof CheckedUncheckedColorProvider) {
                DayNightColorStateList dayNightColorStateListE2 = CompoundButtonTranslatorKt.e((CheckedUncheckedColorProvider) checkableColorProviderB, contextN);
                RemoteViewsCompat.w(remoteViews, insertedViewInfoD.e(), dayNightColorStateListE2.a(), dayNightColorStateListE2.b());
            } else {
                if (!(checkableColorProviderB instanceof ResourceCheckableColorProvider)) {
                    throw new NoWhenBranchMatchedException();
                }
                RemoteViewsCompat.v(remoteViews, insertedViewInfoD.e(), ((ResourceCheckableColorProvider) checkableColorProviderB).a());
            }
            remoteViews2 = remoteViews;
            translationContext2 = translationContext;
        } else {
            remoteViews2 = remoteViews;
            translationContext2 = translationContext;
            iB = UtilsKt.b(remoteViews2, translationContext2, R.id.M0, 0, null, 12, null);
            int iB2 = UtilsKt.b(remoteViews2, translationContext2, R.id.N0, 0, null, 12, null);
            int iB3 = UtilsKt.b(remoteViews2, translationContext2, R.id.O0, 0, null, 12, null);
            UtilsKt.d(remoteViews2, iB2, emittableSwitch.c());
            UtilsKt.d(remoteViews2, iB3, emittableSwitch.c());
            CompoundButtonTranslatorKt.c(remoteViews2, iB2, CompoundButtonTranslatorKt.b(emittableSwitch.d().a(), contextN, emittableSwitch.c()));
            CompoundButtonTranslatorKt.c(remoteViews2, iB3, CompoundButtonTranslatorKt.b(emittableSwitch.d().b(), contextN, emittableSwitch.c()));
        }
        TextTranslatorKt.a(remoteViews2, translationContext2, iB, emittableSwitch.g(), emittableSwitch.f(), emittableSwitch.e(), 16);
        ApplyModifiersKt.c(translationContext2, remoteViews2, emittableSwitch.a(), insertedViewInfoD);
    }
}
