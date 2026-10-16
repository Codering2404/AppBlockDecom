package androidx.glance.appwidget.translators;

import android.os.Build;
import android.text.Layout;
import android.text.ParcelableSpan;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.appwidget.ApplyModifiersKt;
import androidx.glance.appwidget.InsertedViewInfo;
import androidx.glance.appwidget.LayoutSelectionKt;
import androidx.glance.appwidget.LayoutType;
import androidx.glance.appwidget.R;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.color.DayNightColorProvider;
import androidx.glance.text.EmittableText;
import androidx.glance.text.FontFamily;
import androidx.glance.text.FontStyle;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextDecoration;
import androidx.glance.text.TextStyle;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.FixedColorProvider;
import androidx.glance.unit.ResourceColorProvider;
import java.util.ArrayList;
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
public final class TextTranslatorKt {
    public static final void a(RemoteViews remoteViews, TranslationContext translationContext, int i3, String str, TextStyle textStyle, int i4, int i5) {
        if (i4 != Integer.MAX_VALUE) {
            RemoteViewsCompat.z(remoteViews, i3, i4);
        }
        if (textStyle == null) {
            remoteViews.setTextViewText(i3, str);
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        int length = spannableString.length();
        TextUnit textUnitE = textStyle.e();
        if (textUnitE != null) {
            long jM = textUnitE.m();
            if (!TextUnit.k(jM)) {
                throw new IllegalArgumentException("Only Sp is currently supported for font sizes");
            }
            remoteViews.setTextViewTextSize(i3, 2, TextUnit.h(jM));
        }
        ArrayList arrayList = new ArrayList();
        TextDecoration textDecorationI = textStyle.i();
        if (textDecorationI != null) {
            int iH = textDecorationI.h();
            TextDecoration.Companion companion = TextDecoration.f39758b;
            if (TextDecoration.d(iH, companion.a())) {
                arrayList.add(new StrikethroughSpan());
            }
            if (TextDecoration.d(iH, companion.b())) {
                arrayList.add(new UnderlineSpan());
            }
        }
        FontStyle fontStyleF = textStyle.f();
        if (fontStyleF != null) {
            arrayList.add(new StyleSpan(FontStyle.d(fontStyleF.g(), FontStyle.f39742b.a()) ? 2 : 0));
        }
        FontWeight fontWeightG = textStyle.g();
        if (fontWeightG != null) {
            int iJ = fontWeightG.j();
            FontWeight.Companion companion2 = FontWeight.f39746b;
            arrayList.add(new TextAppearanceSpan(translationContext.n(), FontWeight.g(iJ, companion2.a()) ? R.style.f38354a : FontWeight.g(iJ, companion2.b()) ? R.style.f38355b : R.style.f38356c));
        }
        FontFamily fontFamilyD = textStyle.d();
        if (fontFamilyD != null) {
            arrayList.add(new TypefaceSpan(fontFamilyD.a()));
        }
        TextAlign textAlignH = textStyle.h();
        if (textAlignH != null) {
            int iL = textAlignH.l();
            if (Build.VERSION.SDK_INT >= 31) {
                TextTranslatorApi31Impl.f39379a.a(remoteViews, i3, i5 | d(iL));
            } else {
                arrayList.add(new AlignmentSpan.Standard(c(iL, translationContext.w())));
            }
        }
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            spannableString.setSpan((ParcelableSpan) obj, 0, length, 17);
        }
        remoteViews.setTextViewText(i3, spannableString);
        ColorProvider colorProviderC = textStyle.c();
        if (colorProviderC instanceof FixedColorProvider) {
            remoteViews.setTextColor(i3, ColorKt.k(((FixedColorProvider) colorProviderC).b()));
            return;
        }
        if (colorProviderC instanceof ResourceColorProvider) {
            if (Build.VERSION.SDK_INT >= 31) {
                RemoteViewsCompat.B(remoteViews, i3, ((ResourceColorProvider) colorProviderC).b());
                return;
            } else {
                remoteViews.setTextColor(i3, ColorKt.k(colorProviderC.a(translationContext.n())));
                return;
            }
        }
        if (!(colorProviderC instanceof DayNightColorProvider)) {
            Log.w("GlanceAppWidget", "Unexpected text color: " + colorProviderC);
            return;
        }
        if (Build.VERSION.SDK_INT < 31) {
            remoteViews.setTextColor(i3, ColorKt.k(colorProviderC.a(translationContext.n())));
        } else {
            DayNightColorProvider dayNightColorProvider = (DayNightColorProvider) colorProviderC;
            RemoteViewsCompat.A(remoteViews, i3, ColorKt.k(dayNightColorProvider.c()), ColorKt.k(dayNightColorProvider.d()));
        }
    }

    public static /* synthetic */ void b(RemoteViews remoteViews, TranslationContext translationContext, int i3, String str, TextStyle textStyle, int i4, int i5, int i6, Object obj) {
        if ((i6 & 32) != 0) {
            i5 = 48;
        }
        a(remoteViews, translationContext, i3, str, textStyle, i4, i5);
    }

    private static final Layout.Alignment c(int i3, boolean z2) {
        TextAlign.Companion companion = TextAlign.f39751b;
        if (TextAlign.i(i3, companion.a())) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (TextAlign.i(i3, companion.c())) {
            return z2 ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
        }
        if (TextAlign.i(i3, companion.d())) {
            return z2 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (TextAlign.i(i3, companion.e())) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (TextAlign.i(i3, companion.b())) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        Log.w("GlanceAppWidget", "Unknown TextAlign: " + ((Object) TextAlign.k(i3)));
        return Layout.Alignment.ALIGN_NORMAL;
    }

    private static final int d(int i3) {
        TextAlign.Companion companion = TextAlign.f39751b;
        if (TextAlign.i(i3, companion.a())) {
            return 1;
        }
        if (TextAlign.i(i3, companion.c())) {
            return 3;
        }
        if (TextAlign.i(i3, companion.d())) {
            return 5;
        }
        if (TextAlign.i(i3, companion.e())) {
            return 8388611;
        }
        if (TextAlign.i(i3, companion.b())) {
            return 8388613;
        }
        Log.w("GlanceAppWidget", "Unknown TextAlign: " + ((Object) TextAlign.k(i3)));
        return 8388611;
    }

    public static final void e(RemoteViews remoteViews, TranslationContext translationContext, EmittableText emittableText) {
        InsertedViewInfo insertedViewInfoD = LayoutSelectionKt.d(remoteViews, translationContext, LayoutType.Text, emittableText.a());
        b(remoteViews, translationContext, insertedViewInfoD.e(), emittableText.e(), emittableText.d(), emittableText.c(), 0, 32, null);
        ApplyModifiersKt.c(translationContext, remoteViews, emittableText.a(), insertedViewInfoD);
    }
}
