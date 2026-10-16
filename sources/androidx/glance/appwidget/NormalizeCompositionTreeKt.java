package androidx.glance.appwidget;

import android.os.Build;
import android.util.Log;
import androidx.compose.ui.unit.Dp;
import androidx.glance.BackgroundModifier;
import androidx.glance.ButtonKt;
import androidx.glance.Emittable;
import androidx.glance.EmittableButton;
import androidx.glance.EmittableImage;
import androidx.glance.EmittableLazyItemWithChildren;
import androidx.glance.EmittableWithChildren;
import androidx.glance.GlanceModifier;
import androidx.glance.ImageKt;
import androidx.glance.ImageProvider;
import androidx.glance.action.Action;
import androidx.glance.action.ActionModifier;
import androidx.glance.action.LambdaAction;
import androidx.glance.appwidget.action.CompoundButtonAction;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ContentScale;
import androidx.glance.layout.EmittableBox;
import androidx.glance.layout.HeightModifier;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.PaddingModifier;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.WidthModifier;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.Dimension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
public final class NormalizeCompositionTreeKt {
    private static final void d(EmittableWithChildren emittableWithChildren) {
        if (!emittableWithChildren.d().isEmpty()) {
            List listD = emittableWithChildren.d();
            if (!(listD instanceof Collection) || !listD.isEmpty()) {
                Iterator it = listD.iterator();
                while (it.hasNext()) {
                    if (!(((Emittable) it.next()) instanceof EmittableSizeBox)) {
                    }
                }
            }
            for (Emittable emittable : emittableWithChildren.d()) {
                Intrinsics.checkNotNull(emittable, "null cannot be cast to non-null type androidx.glance.appwidget.EmittableSizeBox");
                EmittableSizeBox emittableSizeBox = (EmittableSizeBox) emittable;
                if (emittableSizeBox.d().size() != 1) {
                    EmittableBox emittableBox = new EmittableBox();
                    CollectionsKt.addAll(emittableBox.d(), emittableSizeBox.d());
                    emittableSizeBox.d().clear();
                    emittableSizeBox.d().add(emittableBox);
                }
            }
            return;
        }
        if (emittableWithChildren.d().size() == 1) {
            return;
        }
        EmittableBox emittableBox2 = new EmittableBox();
        CollectionsKt.addAll(emittableBox2.d(), emittableWithChildren.d());
        emittableWithChildren.d().clear();
        emittableWithChildren.d().add(emittableBox2);
    }

    private static final GlanceModifier e(List list) {
        GlanceModifier glanceModifierA;
        GlanceModifier.Companion companion = GlanceModifier.f37605a;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GlanceModifier glanceModifier = (GlanceModifier) it.next();
            if (glanceModifier != null && (glanceModifierA = companion.a(glanceModifier)) != null) {
                companion = glanceModifierA;
            }
        }
        return companion;
    }

    private static final Pair f(GlanceModifier glanceModifier) {
        Pair pairA = glanceModifier.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$extractLambdaAction$$inlined$extractModifier$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(GlanceModifier.Element element) {
                return Boolean.valueOf(element instanceof ActionModifier);
            }
        }) ? (Pair) glanceModifier.foldIn(TuplesKt.a(null, GlanceModifier.f37605a), new Function2<Pair<? extends ActionModifier, ? extends GlanceModifier>, GlanceModifier.Element, Pair<? extends ActionModifier, ? extends GlanceModifier>>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$extractLambdaAction$$inlined$extractModifier$2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Pair invoke(Pair pair, GlanceModifier.Element element) {
                return element instanceof ActionModifier ? TuplesKt.a(element, pair.f()) : TuplesKt.a(pair.e(), ((GlanceModifier) pair.f()).a(element));
            }
        }) : TuplesKt.a(null, glanceModifier);
        ActionModifier actionModifier = (ActionModifier) pairA.a();
        GlanceModifier glanceModifier2 = (GlanceModifier) pairA.b();
        Action actionB = actionModifier != null ? actionModifier.b() : null;
        if (actionB instanceof LambdaAction) {
            return TuplesKt.a(actionB, glanceModifier2);
        }
        if (actionB instanceof CompoundButtonAction) {
            CompoundButtonAction compoundButtonAction = (CompoundButtonAction) actionB;
            if (compoundButtonAction.d() instanceof LambdaAction) {
                return TuplesKt.a(compoundButtonAction.d(), glanceModifier2);
            }
        }
        return TuplesKt.a(null, glanceModifier2);
    }

    private static final ExtractedSizeModifiers g(GlanceModifier glanceModifier) {
        return glanceModifier.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$extractSizeAndCornerRadiusModifiers$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(GlanceModifier.Element element) {
                return Boolean.valueOf((element instanceof WidthModifier) || (element instanceof HeightModifier) || (element instanceof CornerRadiusModifier));
            }
        }) ? (ExtractedSizeModifiers) glanceModifier.foldIn(new ExtractedSizeModifiers(null, null, 3, null), new Function2<ExtractedSizeModifiers, GlanceModifier.Element, ExtractedSizeModifiers>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$extractSizeAndCornerRadiusModifiers$2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ExtractedSizeModifiers invoke(ExtractedSizeModifiers extractedSizeModifiers, GlanceModifier.Element element) {
                return ((element instanceof WidthModifier) || (element instanceof HeightModifier) || (element instanceof CornerRadiusModifier)) ? ExtractedSizeModifiers.d(extractedSizeModifiers, extractedSizeModifiers.f().a(element), null, 2, null) : ExtractedSizeModifiers.d(extractedSizeModifiers, null, extractedSizeModifiers.e().a(element), 1, null);
            }
        }) : new ExtractedSizeModifiers(null, glanceModifier, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(Emittable emittable) {
        if ((emittable instanceof EmittableSwitch) || (emittable instanceof EmittableRadioButton) || (emittable instanceof EmittableCheckBox)) {
            return true;
        }
        return (emittable instanceof EmittableButton) && Build.VERSION.SDK_INT >= 31;
    }

    public static final void i(RemoteViewsRoot remoteViewsRoot) {
        d(remoteViewsRoot);
        k(remoteViewsRoot);
        m(remoteViewsRoot, new Function1<Emittable, Emittable>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$normalizeCompositionTree$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Emittable invoke(Emittable emittable) {
                if (emittable instanceof EmittableLazyItemWithChildren) {
                    NormalizeCompositionTreeKt.j((EmittableLazyItemWithChildren) emittable);
                }
                return NormalizeCompositionTreeKt.l(emittable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(EmittableLazyItemWithChildren emittableLazyItemWithChildren) {
        EmittableBox emittableBox = new EmittableBox();
        CollectionsKt.addAll(emittableBox.d(), emittableLazyItemWithChildren.d());
        emittableBox.i(emittableLazyItemWithChildren.h());
        emittableBox.b(emittableLazyItemWithChildren.a());
        emittableLazyItemWithChildren.d().clear();
        emittableLazyItemWithChildren.d().add(emittableBox);
        emittableLazyItemWithChildren.i(Alignment.f39415c.d());
    }

    private static final void k(EmittableWithChildren emittableWithChildren) {
        Dimension dimensionB;
        Dimension dimensionB2;
        for (Emittable emittable : emittableWithChildren.d()) {
            if (emittable instanceof EmittableWithChildren) {
                k((EmittableWithChildren) emittable);
            }
        }
        HeightModifier heightModifier = (HeightModifier) emittableWithChildren.a().foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$normalizeSizes$$inlined$findModifier$1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof HeightModifier ? element : obj;
            }
        });
        if (heightModifier == null || (dimensionB = heightModifier.b()) == null) {
            dimensionB = Dimension.Wrap.f39790a;
        }
        if (dimensionB instanceof Dimension.Wrap) {
            List listD = emittableWithChildren.d();
            if (!(listD instanceof Collection) || !listD.isEmpty()) {
                Iterator it = listD.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    HeightModifier heightModifier2 = (HeightModifier) ((Emittable) it.next()).a().foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$normalizeSizes$lambda$2$$inlined$findModifier$1
                        @Override // kotlin.jvm.functions.Function2
                        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                        public final Object invoke(Object obj, GlanceModifier.Element element) {
                            return element instanceof HeightModifier ? element : obj;
                        }
                    });
                    if ((heightModifier2 != null ? heightModifier2.b() : null) instanceof Dimension.Fill) {
                        emittableWithChildren.b(SizeModifiersKt.a(emittableWithChildren.a()));
                        break;
                    }
                }
            }
        }
        WidthModifier widthModifier = (WidthModifier) emittableWithChildren.a().foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$normalizeSizes$$inlined$findModifier$2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof WidthModifier ? element : obj;
            }
        });
        if (widthModifier == null || (dimensionB2 = widthModifier.b()) == null) {
            dimensionB2 = Dimension.Wrap.f39790a;
        }
        if (dimensionB2 instanceof Dimension.Wrap) {
            List listD2 = emittableWithChildren.d();
            if ((listD2 instanceof Collection) && listD2.isEmpty()) {
                return;
            }
            Iterator it2 = listD2.iterator();
            while (it2.hasNext()) {
                WidthModifier widthModifier2 = (WidthModifier) ((Emittable) it2.next()).a().foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$normalizeSizes$lambda$3$$inlined$findModifier$1
                    @Override // kotlin.jvm.functions.Function2
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(Object obj, GlanceModifier.Element element) {
                        return element instanceof WidthModifier ? element : obj;
                    }
                });
                if ((widthModifier2 != null ? widthModifier2.b() : null) instanceof Dimension.Fill) {
                    emittableWithChildren.b(SizeModifiersKt.c(emittableWithChildren.a()));
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Emittable l(final Emittable emittable) {
        EmittableImage emittableImage;
        EmittableImage emittableImage2;
        if ((emittable instanceof EmittableLazyItemWithChildren) || (emittable instanceof EmittableSizeBox)) {
            return emittable;
        }
        final boolean z2 = emittable instanceof EmittableButton;
        if (!emittable.a().any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$shouldWrapTargetInABox$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(GlanceModifier.Element element) {
                return Boolean.valueOf(((element instanceof BackgroundModifier) && ((BackgroundModifier) element).d() != null) || (z2 && Build.VERSION.SDK_INT <= 30) || ((element instanceof ActionModifier) && !NormalizeCompositionTreeKt.h(emittable)));
            }
        })) {
            return emittable;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        GlanceModifier glanceModifierA = emittable.a();
        Pair pairA = glanceModifierA.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$$inlined$extractModifier$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(GlanceModifier.Element element) {
                return Boolean.valueOf(element instanceof BackgroundModifier);
            }
        }) ? (Pair) glanceModifierA.foldIn(TuplesKt.a(null, GlanceModifier.f37605a), new Function2<Pair<? extends BackgroundModifier, ? extends GlanceModifier>, GlanceModifier.Element, Pair<? extends BackgroundModifier, ? extends GlanceModifier>>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$$inlined$extractModifier$2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Pair invoke(Pair pair, GlanceModifier.Element element) {
                return element instanceof BackgroundModifier ? TuplesKt.a(element, pair.f()) : TuplesKt.a(pair.e(), ((GlanceModifier) pair.f()).a(element));
            }
        }) : TuplesKt.a(null, glanceModifierA);
        BackgroundModifier backgroundModifier = (BackgroundModifier) pairA.a();
        GlanceModifier glanceModifier = (GlanceModifier) pairA.b();
        if (backgroundModifier == null) {
            emittableImage = null;
        } else if (z2) {
            emittableImage = new EmittableImage();
            emittableImage.b(SizeModifiersKt.b(GlanceModifier.f37605a));
            emittableImage.h(ImageKt.b(R.drawable.f38204a));
            ColorProvider colorProviderB = backgroundModifier.b();
            if (colorProviderB != null) {
                emittableImage.f(new TintAndAlphaColorFilterParams(colorProviderB));
            }
            emittableImage.g(ContentScale.f39463b.b());
        } else if (backgroundModifier.d() != null) {
            emittableImage = new EmittableImage();
            emittableImage.b(SizeModifiersKt.b(GlanceModifier.f37605a));
            emittableImage.h(backgroundModifier.d());
            emittableImage.g(backgroundModifier.c());
        } else {
            arrayList2.add(backgroundModifier);
            emittableImage = null;
        }
        o(glanceModifier);
        Pair pairA2 = glanceModifier.any(new Function1<GlanceModifier.Element, Boolean>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$$inlined$extractModifier$3
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(GlanceModifier.Element element) {
                return Boolean.valueOf(element instanceof ActionModifier);
            }
        }) ? (Pair) glanceModifier.foldIn(TuplesKt.a(null, GlanceModifier.f37605a), new Function2<Pair<? extends ActionModifier, ? extends GlanceModifier>, GlanceModifier.Element, Pair<? extends ActionModifier, ? extends GlanceModifier>>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$$inlined$extractModifier$4
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Pair invoke(Pair pair, GlanceModifier.Element element) {
                return element instanceof ActionModifier ? TuplesKt.a(element, pair.f()) : TuplesKt.a(pair.e(), ((GlanceModifier) pair.f()).a(element));
            }
        }) : TuplesKt.a(null, glanceModifier);
        ActionModifier actionModifier = (ActionModifier) pairA2.a();
        GlanceModifier glanceModifier2 = (GlanceModifier) pairA2.b();
        arrayList.add(actionModifier);
        if (actionModifier == null || h(emittable)) {
            emittableImage2 = null;
        } else {
            ImageProvider imageProviderB = z2 ? ImageKt.b(R.drawable.f38205b) : ImageKt.b(R.drawable.f38206c);
            emittableImage2 = new EmittableImage();
            emittableImage2.b(SizeModifiersKt.b(GlanceModifier.f37605a));
            emittableImage2.h(imageProviderB);
        }
        ExtractedSizeModifiers extractedSizeModifiersG = g(glanceModifier2);
        GlanceModifier glanceModifierA2 = extractedSizeModifiersG.a();
        GlanceModifier glanceModifierB = extractedSizeModifiersG.b();
        arrayList.add(glanceModifierA2);
        arrayList2.add(SizeModifiersKt.b(glanceModifierB));
        if (emittable instanceof EmittableButton) {
            GlanceModifier.Companion companion = GlanceModifier.f37605a;
            EmittableButton emittableButton = (EmittableButton) emittable;
            arrayList.add(AppWidgetModifiersKt.a(companion, emittableButton.c()));
            emittable = ButtonKt.e(emittableButton);
            if (emittable.a().foldIn(null, new Function2<PaddingModifier, GlanceModifier.Element, PaddingModifier>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$transformBackgroundImageAndActionRipple$$inlined$findModifier$1
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Object invoke(Object obj, GlanceModifier.Element element) {
                    return element instanceof PaddingModifier ? element : obj;
                }
            }) == null) {
                arrayList2.add(PaddingKt.c(companion, Dp.g(16), Dp.g(8)));
            }
        }
        EmittableBox emittableBox = new EmittableBox();
        emittableBox.b(e(arrayList));
        if (z2) {
            emittableBox.i(Alignment.f39415c.b());
        }
        if (emittableImage != null) {
            emittableBox.d().add(emittableImage);
        }
        List listD = emittableBox.d();
        emittable.b(e(arrayList2));
        listD.add(emittable);
        if (emittableImage2 != null) {
            emittableBox.d().add(emittableImage2);
        }
        return emittableBox;
    }

    private static final void m(EmittableWithChildren emittableWithChildren, Function1 function1) {
        int i3 = 0;
        for (Object obj : emittableWithChildren.d()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Emittable emittable = (Emittable) function1.invoke((Emittable) obj);
            emittableWithChildren.d().set(i3, emittable);
            if (emittable instanceof EmittableWithChildren) {
                m((EmittableWithChildren) emittable, function1);
            }
            i3 = i4;
        }
    }

    public static final Map n(EmittableWithChildren emittableWithChildren) {
        List listD = emittableWithChildren.d();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i3 = 0;
        for (Object obj : listD) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Emittable emittable = (Emittable) obj;
            Pair pairF = f(emittable.a());
            LambdaAction lambdaAction = (LambdaAction) pairF.a();
            GlanceModifier glanceModifier = (GlanceModifier) pairF.b();
            if (lambdaAction != null && !(emittable instanceof EmittableSizeBox) && !(emittable instanceof EmittableLazyItemWithChildren)) {
                String str = lambdaAction.d() + '+' + i3;
                LambdaAction lambdaAction2 = new LambdaAction(str, lambdaAction.c());
                Object arrayList = linkedHashMap.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(str, arrayList);
                }
                ((List) arrayList).add(lambdaAction2);
                emittable.b(glanceModifier.a(new ActionModifier(lambdaAction2)));
            }
            if (emittable instanceof EmittableWithChildren) {
                for (Map.Entry entry : n((EmittableWithChildren) emittable).entrySet()) {
                    String str2 = (String) entry.getKey();
                    List list = (List) entry.getValue();
                    Object arrayList2 = linkedHashMap.get(str2);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        linkedHashMap.put(str2, arrayList2);
                    }
                    ((List) arrayList2).addAll(list);
                }
            }
            i3 = i4;
        }
        return linkedHashMap;
    }

    private static final void o(GlanceModifier glanceModifier) {
        if (((Number) glanceModifier.foldIn(0, new Function2<Integer, GlanceModifier.Element, Integer>() { // from class: androidx.glance.appwidget.NormalizeCompositionTreeKt$warnIfMultipleClickableActions$actionCount$1
            public final Integer c(int i3, GlanceModifier.Element element) {
                if (element instanceof ActionModifier) {
                    i3++;
                }
                return Integer.valueOf(i3);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return c(((Number) obj).intValue(), (GlanceModifier.Element) obj2);
            }
        })).intValue() > 1) {
            Log.w("GlanceAppWidget", "More than one clickable defined on the same GlanceModifier, only the last one will be used.");
        }
    }
}
