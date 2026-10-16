package androidx.glance.appwidget;

import android.content.Context;
import android.os.Build;
import androidx.glance.Emittable;
import androidx.glance.EmittableButton;
import androidx.glance.EmittableImage;
import androidx.glance.EmittableWithChildren;
import androidx.glance.GlanceModifier;
import androidx.glance.ImageKt;
import androidx.glance.action.ActionModifier;
import androidx.glance.appwidget.lazy.EmittableLazyColumn;
import androidx.glance.appwidget.lazy.EmittableLazyList;
import androidx.glance.appwidget.lazy.EmittableLazyListItem;
import androidx.glance.appwidget.lazy.EmittableLazyVerticalGrid;
import androidx.glance.appwidget.lazy.EmittableLazyVerticalGridListItem;
import androidx.glance.appwidget.proto.LayoutProto;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.ContentScale;
import androidx.glance.layout.EmittableBox;
import androidx.glance.layout.EmittableColumn;
import androidx.glance.layout.EmittableRow;
import androidx.glance.layout.EmittableSpacer;
import androidx.glance.layout.HeightModifier;
import androidx.glance.layout.WidthModifier;
import androidx.glance.text.EmittableText;
import androidx.glance.unit.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

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
public final class WidgetLayoutKt {
    public static final LayoutProto.LayoutNode b(Context context, Emittable emittable) {
        LayoutProto.LayoutNode.Builder builderH0 = LayoutProto.LayoutNode.h0();
        builderH0.R(d(emittable));
        builderH0.U(l(e(emittable.a()), context));
        builderH0.N(l(c(emittable.a()), context));
        builderH0.L(emittable.a().foldIn(null, new Function2<ActionModifier, GlanceModifier.Element, ActionModifier>() { // from class: androidx.glance.appwidget.WidgetLayoutKt$createNode$lambda$1$$inlined$findModifier$1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof ActionModifier ? element : obj;
            }
        }) != null);
        if (emittable.a().foldIn(null, new Function2<AppWidgetBackgroundModifier, GlanceModifier.Element, AppWidgetBackgroundModifier>() { // from class: androidx.glance.appwidget.WidgetLayoutKt$createNode$lambda$1$$inlined$findModifier$2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof AppWidgetBackgroundModifier ? element : obj;
            }
        }) != null) {
            builderH0.P(LayoutProto.NodeIdentity.BACKGROUND_NODE);
        }
        if (emittable instanceof EmittableImage) {
            i(builderH0, (EmittableImage) emittable);
        } else if (emittable instanceof EmittableColumn) {
            h(builderH0, (EmittableColumn) emittable);
        } else if (emittable instanceof EmittableRow) {
            k(builderH0, (EmittableRow) emittable);
        } else if (emittable instanceof EmittableBox) {
            g(builderH0, (EmittableBox) emittable);
        } else if (emittable instanceof EmittableLazyColumn) {
            j(builderH0, (EmittableLazyColumn) emittable);
        }
        if ((emittable instanceof EmittableWithChildren) && !(emittable instanceof EmittableLazyList)) {
            List listD = ((EmittableWithChildren) emittable).d();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listD, 10));
            Iterator it = listD.iterator();
            while (it.hasNext()) {
                arrayList.add(b(context, (Emittable) it.next()));
            }
            builderH0.K(arrayList);
        }
        return (LayoutProto.LayoutNode) builderH0.build();
    }

    private static final Dimension c(GlanceModifier glanceModifier) {
        Dimension dimensionB;
        HeightModifier heightModifier = (HeightModifier) glanceModifier.foldIn(null, new Function2<HeightModifier, GlanceModifier.Element, HeightModifier>() { // from class: androidx.glance.appwidget.WidgetLayoutKt$special$$inlined$findModifier$2
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof HeightModifier ? element : obj;
            }
        });
        return (heightModifier == null || (dimensionB = heightModifier.b()) == null) ? Dimension.Wrap.f39790a : dimensionB;
    }

    private static final LayoutProto.LayoutType d(Emittable emittable) {
        if (emittable instanceof EmittableBox) {
            return LayoutProto.LayoutType.BOX;
        }
        if (emittable instanceof EmittableButton) {
            return LayoutProto.LayoutType.BUTTON;
        }
        if (emittable instanceof EmittableRow) {
            return RadioButtonKt.f(emittable.a()) ? LayoutProto.LayoutType.RADIO_ROW : LayoutProto.LayoutType.ROW;
        }
        if (emittable instanceof EmittableColumn) {
            return RadioButtonKt.f(emittable.a()) ? LayoutProto.LayoutType.RADIO_COLUMN : LayoutProto.LayoutType.COLUMN;
        }
        if (emittable instanceof EmittableText) {
            return LayoutProto.LayoutType.TEXT;
        }
        if (emittable instanceof EmittableLazyListItem) {
            return LayoutProto.LayoutType.LIST_ITEM;
        }
        if (emittable instanceof EmittableLazyColumn) {
            return LayoutProto.LayoutType.LAZY_COLUMN;
        }
        if (emittable instanceof EmittableAndroidRemoteViews) {
            return LayoutProto.LayoutType.ANDROID_REMOTE_VIEWS;
        }
        if (emittable instanceof EmittableCheckBox) {
            return LayoutProto.LayoutType.CHECK_BOX;
        }
        if (emittable instanceof EmittableSpacer) {
            return LayoutProto.LayoutType.SPACER;
        }
        if (emittable instanceof EmittableSwitch) {
            return LayoutProto.LayoutType.SWITCH;
        }
        if (emittable instanceof EmittableImage) {
            return LayoutProto.LayoutType.IMAGE;
        }
        if (emittable instanceof EmittableLinearProgressIndicator) {
            return LayoutProto.LayoutType.LINEAR_PROGRESS_INDICATOR;
        }
        if (emittable instanceof EmittableCircularProgressIndicator) {
            return LayoutProto.LayoutType.CIRCULAR_PROGRESS_INDICATOR;
        }
        if (emittable instanceof EmittableLazyVerticalGrid) {
            return LayoutProto.LayoutType.LAZY_VERTICAL_GRID;
        }
        if (emittable instanceof EmittableLazyVerticalGridListItem) {
            return LayoutProto.LayoutType.LIST_ITEM;
        }
        if (emittable instanceof RemoteViewsRoot) {
            return LayoutProto.LayoutType.REMOTE_VIEWS_ROOT;
        }
        if (emittable instanceof EmittableRadioButton) {
            return LayoutProto.LayoutType.RADIO_BUTTON;
        }
        if (emittable instanceof EmittableSizeBox) {
            return LayoutProto.LayoutType.SIZE_BOX;
        }
        throw new IllegalArgumentException("Unknown element type " + emittable.getClass().getCanonicalName());
    }

    private static final Dimension e(GlanceModifier glanceModifier) {
        Dimension dimensionB;
        WidthModifier widthModifier = (WidthModifier) glanceModifier.foldIn(null, new Function2<WidthModifier, GlanceModifier.Element, WidthModifier>() { // from class: androidx.glance.appwidget.WidgetLayoutKt$special$$inlined$findModifier$1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, GlanceModifier.Element element) {
                return element instanceof WidthModifier ? element : obj;
            }
        });
        return (widthModifier == null || (dimensionB = widthModifier.b()) == null) ? Dimension.Wrap.f39790a : dimensionB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(int i3) {
        return "appWidgetLayout-" + i3;
    }

    private static final void g(LayoutProto.LayoutNode.Builder builder, EmittableBox emittableBox) {
        builder.O(n(emittableBox.h().j()));
        builder.S(m(emittableBox.h().k()));
    }

    private static final void h(LayoutProto.LayoutNode.Builder builder, EmittableColumn emittableColumn) {
        builder.O(n(emittableColumn.h()));
    }

    private static final void i(LayoutProto.LayoutNode.Builder builder, EmittableImage emittableImage) {
        LayoutProto.ContentScale contentScale;
        int iD = emittableImage.d();
        ContentScale.Companion companion = ContentScale.f39463b;
        if (ContentScale.g(iD, companion.c())) {
            contentScale = LayoutProto.ContentScale.FIT;
        } else if (ContentScale.g(iD, companion.a())) {
            contentScale = LayoutProto.ContentScale.CROP;
        } else {
            if (!ContentScale.g(iD, companion.b())) {
                throw new IllegalStateException(("Unknown content scale " + ((Object) ContentScale.i(emittableImage.d()))).toString());
            }
            contentScale = LayoutProto.ContentScale.FILL_BOUNDS;
        }
        builder.Q(contentScale);
        builder.M(!ImageKt.c(emittableImage));
    }

    private static final void j(LayoutProto.LayoutNode.Builder builder, EmittableLazyColumn emittableLazyColumn) {
        builder.O(n(emittableLazyColumn.i()));
    }

    private static final void k(LayoutProto.LayoutNode.Builder builder, EmittableRow emittableRow) {
        builder.S(m(emittableRow.i()));
    }

    private static final LayoutProto.DimensionType l(Dimension dimension, Context context) {
        if (Build.VERSION.SDK_INT >= 31) {
            return WidgetLayoutImpl31.f38525a.a(dimension);
        }
        Dimension dimensionH = LayoutSelectionKt.h(dimension, context);
        if (dimensionH instanceof Dimension.Dp) {
            return LayoutProto.DimensionType.EXACT;
        }
        if (dimensionH instanceof Dimension.Wrap) {
            return LayoutProto.DimensionType.WRAP;
        }
        if (dimensionH instanceof Dimension.Fill) {
            return LayoutProto.DimensionType.FILL;
        }
        if (dimensionH instanceof Dimension.Expand) {
            return LayoutProto.DimensionType.EXPAND;
        }
        throw new IllegalStateException("After resolution, no other type should be present");
    }

    private static final LayoutProto.VerticalAlignment m(int i3) {
        Alignment.Vertical.Companion companion = Alignment.Vertical.f39439b;
        if (Alignment.Vertical.g(i3, companion.c())) {
            return LayoutProto.VerticalAlignment.TOP;
        }
        if (Alignment.Vertical.g(i3, companion.b())) {
            return LayoutProto.VerticalAlignment.CENTER_VERTICALLY;
        }
        if (Alignment.Vertical.g(i3, companion.a())) {
            return LayoutProto.VerticalAlignment.BOTTOM;
        }
        throw new IllegalStateException(("unknown vertical alignment " + ((Object) Alignment.Vertical.i(i3))).toString());
    }

    private static final LayoutProto.HorizontalAlignment n(int i3) {
        Alignment.Horizontal.Companion companion = Alignment.Horizontal.f39434b;
        if (Alignment.Horizontal.g(i3, companion.c())) {
            return LayoutProto.HorizontalAlignment.START;
        }
        if (Alignment.Horizontal.g(i3, companion.a())) {
            return LayoutProto.HorizontalAlignment.CENTER_HORIZONTALLY;
        }
        if (Alignment.Horizontal.g(i3, companion.b())) {
            return LayoutProto.HorizontalAlignment.END;
        }
        throw new IllegalStateException(("unknown horizontal alignment " + ((Object) Alignment.Horizontal.i(i3))).toString());
    }
}
