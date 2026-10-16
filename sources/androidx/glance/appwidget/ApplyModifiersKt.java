package androidx.glance.appwidget;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.AndroidResourceImageProvider;
import androidx.glance.BackgroundModifier;
import androidx.glance.GlanceModifier;
import androidx.glance.ImageProvider;
import androidx.glance.Visibility;
import androidx.glance.VisibilityModifier;
import androidx.glance.action.ActionModifier;
import androidx.glance.appwidget.action.ApplyActionKt;
import androidx.glance.color.DayNightColorProvider;
import androidx.glance.layout.HeightModifier;
import androidx.glance.layout.PaddingInDp;
import androidx.glance.layout.PaddingModifier;
import androidx.glance.layout.WidthModifier;
import androidx.glance.semantics.SemanticsModifier;
import androidx.glance.semantics.SemanticsProperties;
import androidx.glance.unit.ColorProvider;
import androidx.glance.unit.Dimension;
import androidx.glance.unit.FixedColorProvider;
import androidx.glance.unit.ResourceColorProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ApplyModifiersKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37792a;

        static {
            int[] iArr = new int[Visibility.values().length];
            try {
                iArr[Visibility.Visible.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Visibility.Invisible.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Visibility.Gone.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f37792a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Context context, RemoteViews remoteViews, BackgroundModifier backgroundModifier, InsertedViewInfo insertedViewInfo) {
        int iE = insertedViewInfo.e();
        ImageProvider imageProviderD = backgroundModifier.d();
        if (imageProviderD != null) {
            if (imageProviderD instanceof AndroidResourceImageProvider) {
                RemoteViewsCompat.G(remoteViews, iE, ((AndroidResourceImageProvider) imageProviderD).a());
                return;
            }
            return;
        }
        ColorProvider colorProviderB = backgroundModifier.b();
        if (colorProviderB instanceof FixedColorProvider) {
            RemoteViewsCompat.D(remoteViews, iE, ColorKt.k(((FixedColorProvider) colorProviderB).b()));
            return;
        }
        if (colorProviderB instanceof ResourceColorProvider) {
            RemoteViewsCompat.F(remoteViews, iE, ((ResourceColorProvider) colorProviderB).b());
            return;
        }
        if (!(colorProviderB instanceof DayNightColorProvider)) {
            Log.w("GlanceAppWidget", "Unexpected background color modifier: " + colorProviderB);
            return;
        }
        if (Build.VERSION.SDK_INT < 31) {
            RemoteViewsCompat.D(remoteViews, iE, ColorKt.k(((DayNightColorProvider) colorProviderB).a(context)));
        } else {
            DayNightColorProvider dayNightColorProvider = (DayNightColorProvider) colorProviderB;
            RemoteViewsCompat.E(remoteViews, iE, ColorKt.k(dayNightColorProvider.c()), ColorKt.k(dayNightColorProvider.d()));
        }
    }

    public static final void c(final TranslationContext translationContext, final RemoteViews remoteViews, GlanceModifier glanceModifier, final InsertedViewInfo insertedViewInfo) {
        List list;
        final Context contextN = translationContext.n();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
        objectRef5.f140144a = Visibility.Visible;
        final Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
        glanceModifier.foldIn(Unit.f139807a, new Function2<Unit, GlanceModifier.Element, Unit>() { // from class: androidx.glance.appwidget.ApplyModifiersKt$applyModifiers$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void c(Unit unit, GlanceModifier.Element element) {
                PaddingModifier paddingModifierB;
                if (element instanceof ActionModifier) {
                    if (objectRef6.f140144a != null) {
                        Log.w("GlanceAppWidget", "More than one clickable defined on the same GlanceModifier, only the last one will be used.");
                    }
                    objectRef6.f140144a = element;
                    return;
                }
                if (element instanceof WidthModifier) {
                    objectRef.f140144a = element;
                    return;
                }
                if (element instanceof HeightModifier) {
                    objectRef2.f140144a = element;
                    return;
                }
                if (element instanceof BackgroundModifier) {
                    ApplyModifiersKt.b(contextN, remoteViews, (BackgroundModifier) element, insertedViewInfo);
                    return;
                }
                if (element instanceof PaddingModifier) {
                    Ref.ObjectRef objectRef10 = objectRef3;
                    PaddingModifier paddingModifier = (PaddingModifier) objectRef10.f140144a;
                    if (paddingModifier == null || (paddingModifierB = paddingModifier.b((PaddingModifier) element)) == null) {
                        paddingModifierB = (PaddingModifier) element;
                    }
                    objectRef10.f140144a = paddingModifierB;
                    return;
                }
                if (element instanceof VisibilityModifier) {
                    objectRef5.f140144a = ((VisibilityModifier) element).b();
                    return;
                }
                if (element instanceof CornerRadiusModifier) {
                    objectRef4.f140144a = ((CornerRadiusModifier) element).b();
                    return;
                }
                if (element instanceof AppWidgetBackgroundModifier) {
                    return;
                }
                if (element instanceof SelectableGroupModifier) {
                    if (!translationContext.m()) {
                        throw new IllegalStateException("GlanceModifier.selectableGroup() can only be used on Row or Column composables.");
                    }
                    return;
                }
                if (element instanceof AlignmentModifier) {
                    return;
                }
                if (element instanceof ClipToOutlineModifier) {
                    objectRef8.f140144a = element;
                    return;
                }
                if (element instanceof EnabledModifier) {
                    objectRef7.f140144a = element;
                    return;
                }
                if (element instanceof SemanticsModifier) {
                    objectRef9.f140144a = element;
                    return;
                }
                Log.w("GlanceAppWidget", "Unknown modifier '" + element + "', nothing done.");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((Unit) obj, (GlanceModifier.Element) obj2);
                return Unit.f139807a;
            }
        });
        g(translationContext, remoteViews, (WidthModifier) objectRef.f140144a, (HeightModifier) objectRef2.f140144a, insertedViewInfo);
        ActionModifier actionModifier = (ActionModifier) objectRef6.f140144a;
        if (actionModifier != null) {
            ApplyActionKt.a(translationContext, remoteViews, actionModifier.b(), insertedViewInfo.e());
        }
        Dimension dimension = (Dimension) objectRef4.f140144a;
        if (dimension != null) {
            d(remoteViews, insertedViewInfo.e(), dimension);
        }
        PaddingModifier paddingModifier = (PaddingModifier) objectRef3.f140144a;
        if (paddingModifier != null) {
            PaddingInDp paddingInDpE = paddingModifier.c(contextN.getResources()).e(translationContext.w());
            DisplayMetrics displayMetrics = contextN.getResources().getDisplayMetrics();
            remoteViews.setViewPadding(insertedViewInfo.e(), UtilsKt.f(paddingInDpE.b(), displayMetrics), UtilsKt.f(paddingInDpE.d(), displayMetrics), UtilsKt.f(paddingInDpE.c(), displayMetrics), UtilsKt.f(paddingInDpE.a(), displayMetrics));
        }
        if (((ClipToOutlineModifier) objectRef8.f140144a) != null && Build.VERSION.SDK_INT >= 31) {
            remoteViews.setBoolean(insertedViewInfo.e(), "setClipToOutline", true);
        }
        EnabledModifier enabledModifier = (EnabledModifier) objectRef7.f140144a;
        if (enabledModifier != null) {
            remoteViews.setBoolean(insertedViewInfo.e(), "setEnabled", enabledModifier.b());
        }
        SemanticsModifier semanticsModifier = (SemanticsModifier) objectRef9.f140144a;
        if (semanticsModifier != null && (list = (List) semanticsModifier.b().c(SemanticsProperties.f39517a.a())) != null) {
            remoteViews.setContentDescription(insertedViewInfo.e(), CollectionsKt.joinToString$default(list, null, null, null, 0, null, null, 63, null));
        }
        remoteViews.setViewVisibility(insertedViewInfo.e(), k((Visibility) objectRef5.f140144a));
    }

    private static final void d(RemoteViews remoteViews, int i3, Dimension dimension) {
        if (Build.VERSION.SDK_INT >= 31) {
            ApplyModifiersApi31Impl.f37791a.a(remoteViews, i3, dimension);
        } else {
            Log.w("GlanceAppWidget", "Cannot set the rounded corner of views before Api 31.");
        }
    }

    public static final void e(Context context, RemoteViews remoteViews, HeightModifier heightModifier, int i3) {
        Dimension dimensionB = heightModifier.b();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 31) {
            if (i4 >= 33 || !CollectionsKt.listOf((Object[]) new Dimension[]{Dimension.Wrap.f39790a, Dimension.Expand.f39787a}).contains(dimensionB)) {
                ApplyModifiersApi31Impl.f37791a.b(remoteViews, i3, dimensionB);
                return;
            }
            return;
        }
        if (CollectionsKt.listOf((Object[]) new Dimension[]{Dimension.Wrap.f39790a, Dimension.Fill.f39788a, Dimension.Expand.f39787a}).contains(LayoutSelectionKt.h(dimensionB, context))) {
            return;
        }
        throw new IllegalArgumentException("Using a height of " + dimensionB + " requires a complex layout before API 31");
    }

    public static final void f(Context context, RemoteViews remoteViews, WidthModifier widthModifier, int i3) {
        Dimension dimensionB = widthModifier.b();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 31) {
            if (i4 >= 33 || !CollectionsKt.listOf((Object[]) new Dimension[]{Dimension.Wrap.f39790a, Dimension.Expand.f39787a}).contains(dimensionB)) {
                ApplyModifiersApi31Impl.f37791a.c(remoteViews, i3, dimensionB);
                return;
            }
            return;
        }
        if (CollectionsKt.listOf((Object[]) new Dimension[]{Dimension.Wrap.f39790a, Dimension.Fill.f39788a, Dimension.Expand.f39787a}).contains(LayoutSelectionKt.h(dimensionB, context))) {
            return;
        }
        throw new IllegalArgumentException("Using a width of " + dimensionB + " requires a complex layout before API 31");
    }

    private static final void g(TranslationContext translationContext, RemoteViews remoteViews, WidthModifier widthModifier, HeightModifier heightModifier, InsertedViewInfo insertedViewInfo) {
        Context contextN = translationContext.n();
        if (LayoutSelectionKt.f(insertedViewInfo)) {
            if (widthModifier != null) {
                f(contextN, remoteViews, widthModifier, insertedViewInfo.e());
            }
            if (heightModifier != null) {
                e(contextN, remoteViews, heightModifier, insertedViewInfo.e());
                return;
            }
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            throw new IllegalStateException("There is currently no valid use case where a complex view is used on Android S");
        }
        Dimension dimensionB = widthModifier != null ? widthModifier.b() : null;
        Dimension dimensionB2 = heightModifier != null ? heightModifier.b() : null;
        if (j(dimensionB) || j(dimensionB2)) {
            boolean z2 = (dimensionB instanceof Dimension.Fill) || (dimensionB instanceof Dimension.Expand);
            boolean z3 = (dimensionB2 instanceof Dimension.Fill) || (dimensionB2 instanceof Dimension.Expand);
            int iB = UtilsKt.b(remoteViews, translationContext, R.id.L0, (z2 && z3) ? R.layout.xa : z2 ? R.layout.ya : z3 ? R.layout.za : R.layout.Aa, null, 8, null);
            if (dimensionB instanceof Dimension.Dp) {
                RemoteViewsCompat.C(remoteViews, iB, h((Dimension.Dp) dimensionB, contextN));
            } else if (dimensionB instanceof Dimension.Resource) {
                RemoteViewsCompat.C(remoteViews, iB, i((Dimension.Resource) dimensionB, contextN));
            } else {
                if (!((Intrinsics.areEqual(dimensionB, Dimension.Expand.f39787a) ? true : Intrinsics.areEqual(dimensionB, Dimension.Fill.f39788a) ? true : Intrinsics.areEqual(dimensionB, Dimension.Wrap.f39790a)) || dimensionB == null)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            Unit unit = Unit.f139807a;
            if (dimensionB2 instanceof Dimension.Dp) {
                RemoteViewsCompat.y(remoteViews, iB, h((Dimension.Dp) dimensionB2, contextN));
            } else if (dimensionB2 instanceof Dimension.Resource) {
                RemoteViewsCompat.y(remoteViews, iB, i((Dimension.Resource) dimensionB2, contextN));
            } else {
                if (!((Intrinsics.areEqual(dimensionB2, Dimension.Expand.f39787a) ? true : Intrinsics.areEqual(dimensionB2, Dimension.Fill.f39788a) ? true : Intrinsics.areEqual(dimensionB2, Dimension.Wrap.f39790a)) || dimensionB2 == null)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
    }

    private static final int h(Dimension.Dp dp, Context context) {
        return UtilsKt.e(dp.a(), context);
    }

    private static final int i(Dimension.Resource resource, Context context) {
        return context.getResources().getDimensionPixelSize(resource.a());
    }

    private static final boolean j(Dimension dimension) {
        boolean z2 = true;
        if (dimension instanceof Dimension.Dp ? true : dimension instanceof Dimension.Resource) {
            return true;
        }
        if (!(Intrinsics.areEqual(dimension, Dimension.Expand.f39787a) ? true : Intrinsics.areEqual(dimension, Dimension.Fill.f39788a) ? true : Intrinsics.areEqual(dimension, Dimension.Wrap.f39790a)) && dimension != null) {
            z2 = false;
        }
        if (z2) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final int k(Visibility visibility) {
        int i3 = WhenMappings.f37792a[visibility.ordinal()];
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 4;
        }
        if (i3 == 3) {
            return 8;
        }
        throw new NoWhenBranchMatchedException();
    }
}
