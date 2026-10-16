package androidx.glance.appwidget;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.Emittable;
import androidx.glance.EmittableButton;
import androidx.glance.EmittableImage;
import androidx.glance.GlanceModifier;
import androidx.glance.appwidget.SizeMode;
import androidx.glance.appwidget.lazy.EmittableLazyColumn;
import androidx.glance.appwidget.lazy.EmittableLazyListItem;
import androidx.glance.appwidget.lazy.EmittableLazyVerticalGrid;
import androidx.glance.appwidget.lazy.EmittableLazyVerticalGridListItem;
import androidx.glance.appwidget.translators.CheckBoxTranslatorKt;
import androidx.glance.appwidget.translators.CircularProgressIndicatorTranslatorKt;
import androidx.glance.appwidget.translators.ImageTranslatorKt;
import androidx.glance.appwidget.translators.LazyListTranslatorKt;
import androidx.glance.appwidget.translators.LazyVerticalGridTranslatorKt;
import androidx.glance.appwidget.translators.LinearProgressIndicatorTranslatorKt;
import androidx.glance.appwidget.translators.RadioButtonTranslatorKt;
import androidx.glance.appwidget.translators.SwitchTranslatorKt;
import androidx.glance.appwidget.translators.TextTranslatorKt;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.EmittableBox;
import androidx.glance.layout.EmittableColumn;
import androidx.glance.layout.EmittableRow;
import androidx.glance.layout.EmittableSpacer;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.PaddingModifier;
import androidx.glance.text.EmittableText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
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
public final class RemoteViewsTranslatorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f38429a;

    public static final void a(RemoteViews remoteViews, int i3, RemoteViews remoteViews2, int i4) {
        if (Build.VERSION.SDK_INT >= 31) {
            RemoteViewsTranslatorApi31Impl.f38428a.a(remoteViews, i3, remoteViews2, i4);
        } else {
            remoteViews.addView(i3, remoteViews2);
        }
    }

    private static final void b(List list) {
        int i3;
        List<Emittable> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 0;
            for (Emittable emittable : list2) {
                if ((emittable instanceof EmittableRadioButton) && ((EmittableRadioButton) emittable).c() && (i3 = i3 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (!(i3 <= 1)) {
            throw new IllegalStateException("When using GlanceModifier.selectableGroup(), no more than one RadioButton may be checked at a time.");
        }
    }

    private static final RemoteViews c(List list) {
        int size = list.size();
        if (size == 1) {
            return (RemoteViews) list.get(0);
        }
        if (size == 2) {
            return new RemoteViews((RemoteViews) list.get(0), (RemoteViews) list.get(1));
        }
        throw new IllegalArgumentException("There must be between 1 and 2 views.");
    }

    private static final RemoteViews d(RemoteViews remoteViews) {
        return RemoteViewsTranslatorApi28Impl.f38427a.a(remoteViews);
    }

    private static final boolean e(Context context) {
        Boolean bool = f38429a;
        return bool != null ? bool.booleanValue() : context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    public static final RemoteViews f(TranslationContext translationContext, int i3) {
        return new RemoteViews(translationContext.n().getPackageName(), i3);
    }

    public static final void g(RemoteViews remoteViews, TranslationContext translationContext, InsertedViewInfo insertedViewInfo, List list) {
        int i3 = 0;
        for (Object obj : CollectionsKt.take(list, 10)) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            l(remoteViews, translationContext.e(insertedViewInfo, i3), (Emittable) obj);
            i3 = i4;
        }
    }

    public static final int h(Alignment alignment) {
        return i(alignment.k()) | j(alignment.j());
    }

    public static final int i(int i3) {
        Alignment.Vertical.Companion companion = Alignment.Vertical.f39439b;
        if (Alignment.Vertical.g(i3, companion.c())) {
            return 48;
        }
        if (Alignment.Vertical.g(i3, companion.a())) {
            return 80;
        }
        if (Alignment.Vertical.g(i3, companion.b())) {
            return 16;
        }
        Log.w("GlanceAppWidget", "Unknown vertical alignment: " + ((Object) Alignment.Vertical.i(i3)));
        return 48;
    }

    public static final int j(int i3) {
        Alignment.Horizontal.Companion companion = Alignment.Horizontal.f39434b;
        if (Alignment.Horizontal.g(i3, companion.c())) {
            return 8388611;
        }
        if (Alignment.Horizontal.g(i3, companion.b())) {
            return 8388613;
        }
        if (Alignment.Horizontal.g(i3, companion.a())) {
            return 1;
        }
        Log.w("GlanceAppWidget", "Unknown horizontal alignment: " + ((Object) Alignment.Horizontal.i(i3)));
        return 8388611;
    }

    public static final String k(long j3) {
        if (j3 == DpSize.f29984b.a()) {
            return "Unspecified";
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) Dp.k(DpSize.j(j3)));
        sb.append('x');
        sb.append((Object) Dp.k(DpSize.i(j3)));
        return sb.toString();
    }

    public static final void l(RemoteViews remoteViews, TranslationContext translationContext, Emittable emittable) {
        if (emittable instanceof EmittableBox) {
            q(remoteViews, translationContext, (EmittableBox) emittable);
            return;
        }
        if (emittable instanceof EmittableButton) {
            r(remoteViews, translationContext, (EmittableButton) emittable);
            return;
        }
        if (emittable instanceof EmittableRow) {
            t(remoteViews, translationContext, (EmittableRow) emittable);
            return;
        }
        if (emittable instanceof EmittableColumn) {
            s(remoteViews, translationContext, (EmittableColumn) emittable);
            return;
        }
        if (emittable instanceof EmittableText) {
            TextTranslatorKt.e(remoteViews, translationContext, (EmittableText) emittable);
            return;
        }
        if (emittable instanceof EmittableLazyListItem) {
            LazyListTranslatorKt.c(remoteViews, translationContext, (EmittableLazyListItem) emittable);
            return;
        }
        if (emittable instanceof EmittableLazyColumn) {
            LazyListTranslatorKt.a(remoteViews, translationContext, (EmittableLazyColumn) emittable);
            return;
        }
        if (emittable instanceof EmittableAndroidRemoteViews) {
            p(remoteViews, translationContext, (EmittableAndroidRemoteViews) emittable);
            return;
        }
        if (emittable instanceof EmittableCheckBox) {
            CheckBoxTranslatorKt.a(remoteViews, translationContext, (EmittableCheckBox) emittable);
            return;
        }
        if (emittable instanceof EmittableSpacer) {
            v(remoteViews, translationContext, (EmittableSpacer) emittable);
            return;
        }
        if (emittable instanceof EmittableSwitch) {
            SwitchTranslatorKt.a(remoteViews, translationContext, (EmittableSwitch) emittable);
            return;
        }
        if (emittable instanceof EmittableImage) {
            ImageTranslatorKt.e(remoteViews, translationContext, (EmittableImage) emittable);
            return;
        }
        if (emittable instanceof EmittableLinearProgressIndicator) {
            LinearProgressIndicatorTranslatorKt.a(remoteViews, translationContext, (EmittableLinearProgressIndicator) emittable);
            return;
        }
        if (emittable instanceof EmittableCircularProgressIndicator) {
            CircularProgressIndicatorTranslatorKt.a(remoteViews, translationContext, (EmittableCircularProgressIndicator) emittable);
            return;
        }
        if (emittable instanceof EmittableLazyVerticalGrid) {
            LazyVerticalGridTranslatorKt.b(remoteViews, translationContext, (EmittableLazyVerticalGrid) emittable);
            return;
        }
        if (emittable instanceof EmittableLazyVerticalGridListItem) {
            LazyVerticalGridTranslatorKt.d(remoteViews, translationContext, (EmittableLazyVerticalGridListItem) emittable);
            return;
        }
        if (emittable instanceof EmittableRadioButton) {
            RadioButtonTranslatorKt.a(remoteViews, translationContext, (EmittableRadioButton) emittable);
        } else {
            if (emittable instanceof EmittableSizeBox) {
                u(remoteViews, translationContext, (EmittableSizeBox) emittable);
                return;
            }
            throw new IllegalArgumentException("Unknown element type " + emittable.getClass().getCanonicalName());
        }
    }

    public static final RemoteViews m(TranslationContext translationContext, List list, int i3) {
        List<Emittable> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (!(((Emittable) it.next()) instanceof EmittableSizeBox)) {
                    Emittable emittable = (Emittable) CollectionsKt.single(list);
                    RemoteViewsInfo remoteViewsInfoA = LayoutSelectionKt.a(translationContext, emittable.a(), i3);
                    RemoteViews remoteViewsA = remoteViewsInfoA.a();
                    l(remoteViewsA, translationContext.h(remoteViewsInfoA), emittable);
                    return remoteViewsA;
                }
            }
        }
        Object objFirst = CollectionsKt.first((List<? extends Object>) list);
        Intrinsics.checkNotNull(objFirst, "null cannot be cast to non-null type androidx.glance.appwidget.EmittableSizeBox");
        SizeMode sizeModeI = ((EmittableSizeBox) objFirst).i();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Emittable emittable2 : list2) {
            Intrinsics.checkNotNull(emittable2, "null cannot be cast to non-null type androidx.glance.appwidget.EmittableSizeBox");
            long jH = ((EmittableSizeBox) emittable2).h();
            RemoteViewsInfo remoteViewsInfoA2 = LayoutSelectionKt.a(translationContext, emittable2.a(), i3);
            RemoteViews remoteViewsA2 = remoteViewsInfoA2.a();
            l(remoteViewsA2, translationContext.i(remoteViewsInfoA2, jH), emittable2);
            arrayList.add(TuplesKt.a(AppWidgetUtilsKt.q(jH), remoteViewsA2));
        }
        if (sizeModeI instanceof SizeMode.Single) {
            return (RemoteViews) ((Pair) CollectionsKt.single((List) arrayList)).f();
        }
        boolean z2 = true;
        if (!(sizeModeI instanceof SizeMode.Responsive ? true : Intrinsics.areEqual(sizeModeI, SizeMode.Exact.f38451a))) {
            throw new NoWhenBranchMatchedException();
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.f37692a.a(MapsKt.toMap(arrayList));
        }
        int i4 = 0;
        if (arrayList.size() != 1 && arrayList.size() != 2) {
            z2 = false;
        }
        if (!z2) {
            throw new IllegalArgumentException("unsupported views size");
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            arrayList2.add((RemoteViews) ((Pair) obj).f());
        }
        return c(arrayList2);
    }

    public static final RemoteViews n(Context context, int i3, RemoteViewsRoot remoteViewsRoot, LayoutConfiguration layoutConfiguration, int i4, long j3, ComponentName componentName) {
        return m(new TranslationContext(context, i3, e(context), layoutConfiguration, -1, false, null, null, null, j3, 0, 0, false, null, componentName, 15840, null), remoteViewsRoot.d(), i4);
    }

    private static final void p(RemoteViews remoteViews, TranslationContext translationContext, EmittableAndroidRemoteViews emittableAndroidRemoteViews) {
        RemoteViews remoteViewsD;
        if (emittableAndroidRemoteViews.d().isEmpty()) {
            remoteViewsD = emittableAndroidRemoteViews.i();
        } else {
            if (emittableAndroidRemoteViews.h() == -1) {
                throw new IllegalStateException("To add children to an `AndroidRemoteViews`, its `containerViewId` must be set.");
            }
            remoteViewsD = d(emittableAndroidRemoteViews.i());
            remoteViewsD.removeAllViews(emittableAndroidRemoteViews.h());
            int i3 = 0;
            for (Object obj : emittableAndroidRemoteViews.d()) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Emittable emittable = (Emittable) obj;
                RemoteViewsInfo remoteViewsInfoA = LayoutSelectionKt.a(translationContext, emittable.a(), i3);
                RemoteViews remoteViewsA = remoteViewsInfoA.a();
                l(remoteViewsA, translationContext.h(remoteViewsInfoA), emittable);
                a(remoteViewsD, emittableAndroidRemoteViews.h(), remoteViewsA, i3);
                i3 = i4;
            }
        }
        InsertedViewInfo insertedViewInfoD = LayoutSelectionKt.d(remoteViews, translationContext, LayoutType.Frame, emittableAndroidRemoteViews.a());
        ApplyModifiersKt.c(translationContext, remoteViews, emittableAndroidRemoteViews.a(), insertedViewInfoD);
        remoteViews.removeAllViews(insertedViewInfoD.e());
        a(remoteViews, insertedViewInfoD.e(), remoteViewsD, 0);
    }

    private static final void q(RemoteViews remoteViews, TranslationContext translationContext, EmittableBox emittableBox) {
        InsertedViewInfo insertedViewInfoC = LayoutSelectionKt.c(remoteViews, translationContext, LayoutType.Box, emittableBox.d().size(), emittableBox.a(), Alignment.Horizontal.d(emittableBox.h().j()), Alignment.Vertical.d(emittableBox.h().k()));
        ApplyModifiersKt.c(translationContext, remoteViews, emittableBox.a(), insertedViewInfoC);
        for (Emittable emittable : emittableBox.d()) {
            emittable.b(emittable.a().a(new AlignmentModifier(emittableBox.h())));
        }
        g(remoteViews, translationContext, insertedViewInfoC, emittableBox.d());
    }

    private static final void r(RemoteViews remoteViews, TranslationContext translationContext, EmittableButton emittableButton) {
        if (Build.VERSION.SDK_INT < 31) {
            throw new IllegalStateException("Buttons in Android R and below are emulated using a EmittableBox containing the text.");
        }
        InsertedViewInfo insertedViewInfoD = LayoutSelectionKt.d(remoteViews, translationContext, LayoutType.Button, emittableButton.a());
        TextTranslatorKt.a(remoteViews, translationContext, insertedViewInfoD.e(), emittableButton.f(), emittableButton.e(), emittableButton.d(), 16);
        float f3 = 16;
        emittableButton.b(CornerRadiusKt.a(AppWidgetModifiersKt.a(emittableButton.a(), emittableButton.c()), Dp.g(f3)));
        if (emittableButton.a().foldIn(null, new Function2<PaddingModifier, GlanceModifier.Element, PaddingModifier>() { // from class: androidx.glance.appwidget.RemoteViewsTranslatorKt$translateEmittableButton$$inlined$findModifier$1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof PaddingModifier ? element : obj;
            }
        }) == null) {
            emittableButton.b(PaddingKt.c(emittableButton.a(), Dp.g(f3), Dp.g(8)));
        }
        ApplyModifiersKt.c(translationContext, remoteViews, emittableButton.a(), insertedViewInfoD);
    }

    private static final void s(RemoteViews remoteViews, TranslationContext translationContext, EmittableColumn emittableColumn) {
        InsertedViewInfo insertedViewInfoC = LayoutSelectionKt.c(remoteViews, translationContext, (Build.VERSION.SDK_INT < 31 || !RadioButtonKt.f(emittableColumn.a())) ? LayoutType.Column : LayoutType.RadioColumn, emittableColumn.d().size(), emittableColumn.a(), Alignment.Horizontal.d(emittableColumn.h()), null);
        RemoteViewsCompat.j(remoteViews, insertedViewInfoC.e(), h(new Alignment(emittableColumn.h(), emittableColumn.i(), null)));
        ApplyModifiersKt.c(translationContext.a(), remoteViews, emittableColumn.a(), insertedViewInfoC);
        g(remoteViews, translationContext, insertedViewInfoC, emittableColumn.d());
        if (RadioButtonKt.f(emittableColumn.a())) {
            b(emittableColumn.d());
        }
    }

    private static final void t(RemoteViews remoteViews, TranslationContext translationContext, EmittableRow emittableRow) {
        InsertedViewInfo insertedViewInfoC = LayoutSelectionKt.c(remoteViews, translationContext, (Build.VERSION.SDK_INT < 31 || !RadioButtonKt.f(emittableRow.a())) ? LayoutType.Row : LayoutType.RadioRow, emittableRow.d().size(), emittableRow.a(), null, Alignment.Vertical.d(emittableRow.i()));
        RemoteViewsCompat.j(remoteViews, insertedViewInfoC.e(), h(new Alignment(emittableRow.h(), emittableRow.i(), null)));
        ApplyModifiersKt.c(translationContext.a(), remoteViews, emittableRow.a(), insertedViewInfoC);
        g(remoteViews, translationContext, insertedViewInfoC, emittableRow.d());
        if (RadioButtonKt.f(emittableRow.a())) {
            b(emittableRow.d());
        }
    }

    public static final void u(RemoteViews remoteViews, TranslationContext translationContext, EmittableSizeBox emittableSizeBox) {
        if (emittableSizeBox.d().size() <= 1) {
            Emittable emittable = (Emittable) CollectionsKt.firstOrNull(emittableSizeBox.d());
            if (emittable != null) {
                l(remoteViews, translationContext, emittable);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("Size boxes can only have at most one child " + emittableSizeBox.d().size() + ". The normalization of the composition tree failed.").toString());
    }

    private static final void v(RemoteViews remoteViews, TranslationContext translationContext, EmittableSpacer emittableSpacer) {
        ApplyModifiersKt.c(translationContext, remoteViews, emittableSpacer.a(), LayoutSelectionKt.d(remoteViews, translationContext, LayoutType.Frame, emittableSpacer.a()));
    }
}
