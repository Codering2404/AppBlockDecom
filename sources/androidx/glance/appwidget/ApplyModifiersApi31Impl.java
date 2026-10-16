package androidx.glance.appwidget;

import android.widget.RemoteViews;
import androidx.core.widget.RemoteViewsCompat;
import androidx.glance.unit.Dimension;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
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
final class ApplyModifiersApi31Impl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ApplyModifiersApi31Impl f37791a = new ApplyModifiersApi31Impl();

    private ApplyModifiersApi31Impl() {
    }

    public final void a(RemoteViews remoteViews, int i3, Dimension dimension) {
        RemoteViewsCompat.H(remoteViews, i3, true);
        if (dimension instanceof Dimension.Dp) {
            remoteViews.setViewOutlinePreferredRadius(i3, ((Dimension.Dp) dimension).a(), 1);
        } else {
            if (dimension instanceof Dimension.Resource) {
                remoteViews.setViewOutlinePreferredRadiusDimen(i3, ((Dimension.Resource) dimension).a());
                return;
            }
            throw new IllegalStateException(("Rounded corners should not be " + dimension.getClass().getCanonicalName()).toString());
        }
    }

    public final void b(RemoteViews remoteViews, int i3, Dimension dimension) {
        if (dimension instanceof Dimension.Wrap) {
            remoteViews.setViewLayoutHeight(i3, -2.0f, 0);
        } else if (dimension instanceof Dimension.Expand) {
            remoteViews.setViewLayoutHeight(i3, 0.0f, 0);
        } else if (dimension instanceof Dimension.Dp) {
            remoteViews.setViewLayoutHeight(i3, ((Dimension.Dp) dimension).a(), 1);
        } else if (dimension instanceof Dimension.Resource) {
            remoteViews.setViewLayoutHeightDimen(i3, ((Dimension.Resource) dimension).a());
        } else {
            if (!Intrinsics.areEqual(dimension, Dimension.Fill.f39788a)) {
                throw new NoWhenBranchMatchedException();
            }
            remoteViews.setViewLayoutHeight(i3, -1.0f, 0);
        }
        Unit unit = Unit.f139807a;
    }

    public final void c(RemoteViews remoteViews, int i3, Dimension dimension) {
        if (dimension instanceof Dimension.Wrap) {
            remoteViews.setViewLayoutWidth(i3, -2.0f, 0);
        } else if (dimension instanceof Dimension.Expand) {
            remoteViews.setViewLayoutWidth(i3, 0.0f, 0);
        } else if (dimension instanceof Dimension.Dp) {
            remoteViews.setViewLayoutWidth(i3, ((Dimension.Dp) dimension).a(), 1);
        } else if (dimension instanceof Dimension.Resource) {
            remoteViews.setViewLayoutWidthDimen(i3, ((Dimension.Resource) dimension).a());
        } else {
            if (!Intrinsics.areEqual(dimension, Dimension.Fill.f39788a)) {
                throw new NoWhenBranchMatchedException();
            }
            remoteViews.setViewLayoutWidth(i3, -1.0f, 0);
        }
        Unit unit = Unit.f139807a;
    }
}
