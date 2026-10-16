package androidx.glance.appwidget;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.compose.ui.unit.Dp;
import androidx.glance.GlanceModifier;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.HeightModifier;
import androidx.glance.layout.WidthModifier;
import androidx.glance.unit.Dimension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class LayoutSelectionKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f38107a = MapsKt.mapOf(TuplesKt.a(LayoutType.Text, Integer.valueOf(R.layout.n6)), TuplesKt.a(LayoutType.List, Integer.valueOf(R.layout.f5)), TuplesKt.a(LayoutType.CheckBox, Integer.valueOf(R.layout.A2)), TuplesKt.a(LayoutType.CheckBoxBackport, Integer.valueOf(R.layout.B2)), TuplesKt.a(LayoutType.Button, Integer.valueOf(R.layout.f38318o2)), TuplesKt.a(LayoutType.Swtch, Integer.valueOf(R.layout.P5)), TuplesKt.a(LayoutType.SwtchBackport, Integer.valueOf(R.layout.Q5)), TuplesKt.a(LayoutType.Frame, Integer.valueOf(R.layout.m3)), TuplesKt.a(LayoutType.ImageCrop, Integer.valueOf(R.layout.y3)), TuplesKt.a(LayoutType.ImageCropDecorative, Integer.valueOf(R.layout.C3)), TuplesKt.a(LayoutType.ImageFit, Integer.valueOf(R.layout.u4)), TuplesKt.a(LayoutType.ImageFitDecorative, Integer.valueOf(R.layout.y4)), TuplesKt.a(LayoutType.ImageFillBounds, Integer.valueOf(R.layout.W3)), TuplesKt.a(LayoutType.ImageFillBoundsDecorative, Integer.valueOf(R.layout.a4)), TuplesKt.a(LayoutType.LinearProgressIndicator, Integer.valueOf(R.layout.T4)), TuplesKt.a(LayoutType.CircularProgressIndicator, Integer.valueOf(R.layout.Y2)), TuplesKt.a(LayoutType.VerticalGridOneColumn, Integer.valueOf(R.layout.j7)), TuplesKt.a(LayoutType.VerticalGridTwoColumns, Integer.valueOf(R.layout.H7)), TuplesKt.a(LayoutType.VerticalGridThreeColumns, Integer.valueOf(R.layout.v7)), TuplesKt.a(LayoutType.VerticalGridFourColumns, Integer.valueOf(R.layout.X6)), TuplesKt.a(LayoutType.VerticalGridFiveColumns, Integer.valueOf(R.layout.L6)), TuplesKt.a(LayoutType.VerticalGridAutoFit, Integer.valueOf(R.layout.z6)), TuplesKt.a(LayoutType.RadioButton, Integer.valueOf(R.layout.r5)), TuplesKt.a(LayoutType.RadioButtonBackport, Integer.valueOf(R.layout.s5)));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f38108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f38109c;

    static {
        int size = GeneratedLayoutsKt.f().size();
        f38108b = size;
        f38109c = Build.VERSION.SDK_INT >= 31 ? GeneratedLayoutsKt.h() : GeneratedLayoutsKt.h() / size;
    }

    public static final RemoteViewsInfo a(TranslationContext translationContext, GlanceModifier glanceModifier, int i3) {
        Object objH;
        Object objH2;
        Dimension dimensionB;
        Dimension dimensionB2;
        Context contextN = translationContext.n();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 31) {
            if (i3 >= GeneratedLayoutsKt.h()) {
                throw new IllegalArgumentException(("Index of the root view cannot be more than " + GeneratedLayoutsKt.h() + ", currently " + i3).toString());
            }
            LayoutSize layoutSize = LayoutSize.Wrap;
            SizeSelector sizeSelector = new SizeSelector(layoutSize, layoutSize);
            RemoteViews remoteViewsF = RemoteViewsTranslatorKt.f(translationContext, GeneratedLayoutsKt.a() + i3);
            WidthModifier widthModifier = (WidthModifier) glanceModifier.foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$createRootView$lambda$3$$inlined$findModifier$1
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Object invoke(Object obj, GlanceModifier.Element element) {
                    return element instanceof WidthModifier ? element : obj;
                }
            });
            if (widthModifier != null) {
                ApplyModifiersKt.f(contextN, remoteViewsF, widthModifier, R.id.K0);
            }
            HeightModifier heightModifier = (HeightModifier) glanceModifier.foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$createRootView$lambda$3$$inlined$findModifier$2
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Object invoke(Object obj, GlanceModifier.Element element) {
                    return element instanceof HeightModifier ? element : obj;
                }
            });
            if (heightModifier != null) {
                ApplyModifiersKt.e(contextN, remoteViewsF, heightModifier, R.id.K0);
            }
            if (i4 >= 33) {
                remoteViewsF.removeAllViews(R.id.K0);
            }
            return new RemoteViewsInfo(remoteViewsF, new InsertedViewInfo(R.id.K0, 0, i4 >= 33 ? MapsKt.emptyMap() : MapsKt.mapOf(TuplesKt.a(0, MapsKt.mapOf(TuplesKt.a(sizeSelector, Integer.valueOf(R.id.J0))))), 2, null));
        }
        int i5 = f38108b;
        if (i5 * i3 >= GeneratedLayoutsKt.h()) {
            throw new IllegalArgumentException(("Index of the root view cannot be more than " + (GeneratedLayoutsKt.h() / 4) + ", currently " + i3).toString());
        }
        WidthModifier widthModifier2 = (WidthModifier) glanceModifier.foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$createRootView$$inlined$findModifier$1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof WidthModifier ? element : obj;
            }
        });
        if (widthModifier2 == null || (dimensionB2 = widthModifier2.b()) == null || (objH = h(dimensionB2, contextN)) == null) {
            objH = Dimension.Wrap.f39790a;
        }
        HeightModifier heightModifier2 = (HeightModifier) glanceModifier.foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$createRootView$$inlined$findModifier$2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof HeightModifier ? element : obj;
            }
        });
        if (heightModifier2 == null || (dimensionB = heightModifier2.b()) == null || (objH2 = h(dimensionB, contextN)) == null) {
            objH2 = Dimension.Wrap.f39790a;
        }
        Dimension.Fill fill = Dimension.Fill.f39788a;
        LayoutSize layoutSize2 = Intrinsics.areEqual(objH, fill) ? LayoutSize.MatchParent : LayoutSize.Wrap;
        LayoutSize layoutSize3 = Intrinsics.areEqual(objH2, fill) ? LayoutSize.MatchParent : LayoutSize.Wrap;
        SizeSelector sizeSelectorG = g(layoutSize2, layoutSize3);
        Integer num = (Integer) GeneratedLayoutsKt.f().get(sizeSelectorG);
        if (num != null) {
            return new RemoteViewsInfo(RemoteViewsTranslatorKt.f(translationContext, GeneratedLayoutsKt.a() + (i5 * i3) + num.intValue()), new InsertedViewInfo(0, 0, MapsKt.mapOf(TuplesKt.a(0, MapsKt.mapOf(TuplesKt.a(sizeSelectorG, Integer.valueOf(R.id.J0))))), 3, null));
        }
        throw new IllegalStateException("Cannot find root element for size [" + layoutSize2 + ", " + layoutSize3 + ']');
    }

    public static final int b() {
        return f38109c;
    }

    public static final InsertedViewInfo c(RemoteViews remoteViews, TranslationContext translationContext, LayoutType layoutType, int i3, GlanceModifier glanceModifier, Alignment.Horizontal horizontal, Alignment.Vertical vertical) {
        if (i3 > 10) {
            Log.e("GlanceAppWidget", "Truncated " + layoutType + " container from " + i3 + " to 10 elements", new IllegalArgumentException(layoutType + " container cannot have more than 10 elements"));
        }
        int iK = RangesKt.k(i3, 10);
        Integer numJ = j(layoutType, glanceModifier);
        if (numJ == null) {
            ContainerInfo containerInfo = (ContainerInfo) GeneratedLayoutsKt.e().get(new ContainerSelector(layoutType, iK, horizontal, vertical, null));
            numJ = containerInfo != null ? Integer.valueOf(containerInfo.a()) : null;
            if (numJ == null) {
                throw new IllegalArgumentException("Cannot find container " + layoutType + " with " + i3 + " children");
            }
        }
        int iIntValue = numJ.intValue();
        Map map = (Map) GeneratedLayoutsKt.c().get(layoutType);
        if (map != null) {
            InsertedViewInfo insertedViewInfoB = InsertedViewInfo.b(e(remoteViews, translationContext, iIntValue, glanceModifier), 0, 0, map, 3, null);
            if (Build.VERSION.SDK_INT >= 33) {
                remoteViews.removeAllViews(insertedViewInfoB.e());
            }
            return insertedViewInfoB;
        }
        throw new IllegalArgumentException("Cannot find generated children for " + layoutType);
    }

    public static final InsertedViewInfo d(RemoteViews remoteViews, TranslationContext translationContext, LayoutType layoutType, GlanceModifier glanceModifier) {
        Integer numJ = j(layoutType, glanceModifier);
        if (numJ != null || (numJ = (Integer) f38107a.get(layoutType)) != null) {
            return e(remoteViews, translationContext, numJ.intValue(), glanceModifier);
        }
        throw new IllegalArgumentException("Cannot use `insertView` with a container like " + layoutType);
    }

    private static final InsertedViewInfo e(RemoteViews remoteViews, TranslationContext translationContext, int i3, GlanceModifier glanceModifier) {
        Dimension dimensionB;
        Dimension dimensionB2;
        int iO = translationContext.o();
        Integer numValueOf = null;
        WidthModifier widthModifier = (WidthModifier) glanceModifier.foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$insertViewInternal$$inlined$findModifier$1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof WidthModifier ? element : obj;
            }
        });
        if (widthModifier == null || (dimensionB = widthModifier.b()) == null) {
            dimensionB = Dimension.Wrap.f39790a;
        }
        HeightModifier heightModifier = (HeightModifier) glanceModifier.foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$insertViewInternal$$inlined$findModifier$2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof HeightModifier ? element : obj;
            }
        });
        if (heightModifier == null || (dimensionB2 = heightModifier.b()) == null) {
            dimensionB2 = Dimension.Wrap.f39790a;
        }
        if (!glanceModifier.all(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$insertViewInternal$specifiedViewId$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(GlanceModifier.Element element) {
                return Boolean.valueOf(!(element instanceof AppWidgetBackgroundModifier));
            }
        })) {
            if (translationContext.u().getAndSet(true)) {
                throw new IllegalStateException("At most one view can be set as AppWidgetBackground.");
            }
            numValueOf = Integer.valueOf(android.R.id.background);
        }
        Integer num = numValueOf;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 33) {
            int iIntValue = num != null ? num.intValue() : translationContext.x();
            RemoteViewsTranslatorKt.a(remoteViews, translationContext.t().e(), LayoutSelectionApi31Impl.f38106a.a(translationContext.n().getPackageName(), i3, iIntValue), iO);
            return new InsertedViewInfo(iIntValue, 0, null, 6, null);
        }
        if (i4 >= 31) {
            Dimension.Expand expand = Dimension.Expand.f39787a;
            return new InsertedViewInfo(UtilsKt.a(remoteViews, translationContext, i(remoteViews, translationContext, iO, Intrinsics.areEqual(dimensionB, expand) ? LayoutSize.Expand : LayoutSize.Wrap, Intrinsics.areEqual(dimensionB2, expand) ? LayoutSize.Expand : LayoutSize.Wrap), i3, num), 0, null, 6, null);
        }
        Context contextN = translationContext.n();
        LayoutSize layoutSizeK = k(h(dimensionB, contextN));
        LayoutSize layoutSizeK2 = k(h(dimensionB2, contextN));
        int i5 = i(remoteViews, translationContext, iO, layoutSizeK, layoutSizeK2);
        LayoutSize layoutSize = LayoutSize.Fixed;
        if (layoutSizeK != layoutSize && layoutSizeK2 != layoutSize) {
            return new InsertedViewInfo(UtilsKt.a(remoteViews, translationContext, i5, i3, num), 0, null, 6, null);
        }
        LayoutInfo layoutInfo = (LayoutInfo) GeneratedLayoutsKt.d().get(new SizeSelector(layoutSizeK, layoutSizeK2));
        if (layoutInfo != null) {
            return new InsertedViewInfo(UtilsKt.a(remoteViews, translationContext, R.id.G0, i3, num), UtilsKt.b(remoteViews, translationContext, i5, layoutInfo.a(), null, 8, null), null, 4, null);
        }
        throw new IllegalArgumentException("Could not find complex layout for width=" + layoutSizeK + ", height=" + layoutSizeK2);
    }

    public static final boolean f(InsertedViewInfo insertedViewInfo) {
        return insertedViewInfo.d() == -1;
    }

    private static final SizeSelector g(LayoutSize layoutSize, LayoutSize layoutSize2) {
        return new SizeSelector(l(layoutSize), l(layoutSize2));
    }

    public static final Dimension h(Dimension dimension, Context context) {
        if (!(dimension instanceof Dimension.Resource)) {
            return dimension;
        }
        float dimension2 = context.getResources().getDimension(((Dimension.Resource) dimension).a());
        int i3 = (int) dimension2;
        return i3 != -2 ? i3 != -1 ? new Dimension.Dp(Dp.g(dimension2 / context.getResources().getDisplayMetrics().density), null) : Dimension.Fill.f39788a : Dimension.Wrap.f39790a;
    }

    private static final int i(RemoteViews remoteViews, TranslationContext translationContext, int i3, LayoutSize layoutSize, LayoutSize layoutSize2) {
        SizeSelector sizeSelectorG = g(layoutSize, layoutSize2);
        Map map = (Map) translationContext.t().c().get(Integer.valueOf(i3));
        if (map == null) {
            throw new IllegalStateException("Parent doesn't have child position " + i3);
        }
        Integer num = (Integer) map.get(sizeSelectorG);
        if (num == null) {
            throw new IllegalStateException("No child for position " + i3 + " and size " + layoutSize + " x " + layoutSize2);
        }
        int iIntValue = num.intValue();
        Collection collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((Number) obj).intValue() != iIntValue) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj2 = arrayList.get(i4);
            i4++;
            UtilsKt.a(remoteViews, translationContext, ((Number) obj2).intValue(), R.layout.k3, Integer.valueOf(R.id.F0));
        }
        return iIntValue;
    }

    private static final Integer j(LayoutType layoutType, GlanceModifier glanceModifier) {
        if (Build.VERSION.SDK_INT < 33) {
            return null;
        }
        AlignmentModifier alignmentModifier = (AlignmentModifier) glanceModifier.foldIn(null, new Function2<AlignmentModifier, GlanceModifier.Element, AlignmentModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$selectLayout33$$inlined$findModifier$1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof AlignmentModifier ? element : obj;
            }
        });
        WidthModifier widthModifier = (WidthModifier) glanceModifier.foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$selectLayout33$$inlined$findModifier$2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof WidthModifier ? element : obj;
            }
        });
        boolean zAreEqual = widthModifier != null ? Intrinsics.areEqual(widthModifier.b(), Dimension.Expand.f39787a) : false;
        HeightModifier heightModifier = (HeightModifier) glanceModifier.foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.LayoutSelectionKt$selectLayout33$$inlined$findModifier$3
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof HeightModifier ? element : obj;
            }
        });
        boolean zAreEqual2 = heightModifier != null ? Intrinsics.areEqual(heightModifier.b(), Dimension.Expand.f39787a) : false;
        if (alignmentModifier != null) {
            LayoutInfo layoutInfo = (LayoutInfo) GeneratedLayoutsKt.b().get(new BoxChildSelector(layoutType, alignmentModifier.b().j(), alignmentModifier.b().k(), null));
            if (layoutInfo != null) {
                return Integer.valueOf(layoutInfo.a());
            }
            throw new IllegalArgumentException("Cannot find " + layoutType + " with alignment " + alignmentModifier.b());
        }
        if (!zAreEqual && !zAreEqual2) {
            return null;
        }
        LayoutInfo layoutInfo2 = (LayoutInfo) GeneratedLayoutsKt.g().get(new RowColumnChildSelector(layoutType, zAreEqual, zAreEqual2));
        if (layoutInfo2 != null) {
            return Integer.valueOf(layoutInfo2.a());
        }
        throw new IllegalArgumentException("Cannot find " + layoutType + " with defaultWeight set");
    }

    private static final LayoutSize k(Dimension dimension) {
        if (dimension instanceof Dimension.Wrap) {
            return LayoutSize.Wrap;
        }
        if (dimension instanceof Dimension.Expand) {
            return LayoutSize.Expand;
        }
        if (dimension instanceof Dimension.Fill) {
            return LayoutSize.MatchParent;
        }
        if (dimension instanceof Dimension.Dp ? true : dimension instanceof Dimension.Resource) {
            return LayoutSize.Fixed;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final LayoutSize l(LayoutSize layoutSize) {
        return layoutSize == LayoutSize.Fixed ? LayoutSize.Wrap : layoutSize;
    }
}
