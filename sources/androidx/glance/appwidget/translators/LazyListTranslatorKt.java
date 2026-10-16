package androidx.glance.appwidget.translators;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.RemoteViews;
import androidx.glance.Emittable;
import androidx.glance.appwidget.ApplyModifiersKt;
import androidx.glance.appwidget.GlanceRemoteViewsServiceKt;
import androidx.glance.appwidget.InsertedViewInfo;
import androidx.glance.appwidget.LayoutConfiguration;
import androidx.glance.appwidget.LayoutSelectionKt;
import androidx.glance.appwidget.LayoutType;
import androidx.glance.appwidget.RemoteCollectionItems;
import androidx.glance.appwidget.RemoteViewsTranslatorKt;
import androidx.glance.appwidget.TranslationContext;
import androidx.glance.appwidget.lazy.EmittableLazyColumn;
import androidx.glance.appwidget.lazy.EmittableLazyList;
import androidx.glance.appwidget.lazy.EmittableLazyListItem;
import androidx.glance.layout.Alignment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class LazyListTranslatorKt {
    public static final void a(RemoteViews remoteViews, TranslationContext translationContext, EmittableLazyColumn emittableLazyColumn) {
        b(remoteViews, translationContext, emittableLazyColumn, LayoutSelectionKt.d(remoteViews, translationContext, LayoutType.List, emittableLazyColumn.a()));
    }

    private static final void b(RemoteViews remoteViews, TranslationContext translationContext, EmittableLazyList emittableLazyList, InsertedViewInfo insertedViewInfo) {
        if (translationContext.v()) {
            throw new IllegalStateException("Glance does not support nested list views.");
        }
        remoteViews.setPendingIntentTemplate(insertedViewInfo.e(), PendingIntent.getActivity(translationContext.n(), 0, new Intent(), 184549384, emittableLazyList.h()));
        RemoteCollectionItems.Builder builder = new RemoteCollectionItems.Builder();
        TranslationContext translationContextF = translationContext.f(insertedViewInfo.e());
        boolean z2 = false;
        int i3 = 0;
        for (Object obj : emittableLazyList.d()) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Emittable emittable = (Emittable) obj;
            Intrinsics.checkNotNull(emittable, "null cannot be cast to non-null type androidx.glance.appwidget.lazy.EmittableLazyListItem");
            long j3 = ((EmittableLazyListItem) emittable).j();
            TranslationContext translationContextG = translationContextF.g(i3, 1048576);
            List listListOf = CollectionsKt.listOf(emittable);
            LayoutConfiguration layoutConfigurationR = translationContext.r();
            builder.a(j3, RemoteViewsTranslatorKt.m(translationContextG, listListOf, layoutConfigurationR != null ? layoutConfigurationR.c(emittable) : -1));
            z2 = z2 || j3 > -4611686018427387904L;
            i3 = i4;
        }
        builder.c(z2);
        builder.d(LayoutSelectionKt.b());
        GlanceRemoteViewsServiceKt.a(remoteViews, translationContext.n(), translationContext.l(), insertedViewInfo.e(), RemoteViewsTranslatorKt.k(translationContext.s()), builder.b());
        ApplyModifiersKt.c(translationContext, remoteViews, emittableLazyList.a(), insertedViewInfo);
    }

    public static final void c(RemoteViews remoteViews, TranslationContext translationContext, EmittableLazyListItem emittableLazyListItem) {
        if (emittableLazyListItem.d().size() != 1 || !Intrinsics.areEqual(emittableLazyListItem.h(), Alignment.f39415c.d())) {
            throw new IllegalArgumentException("Lazy list items can only have a single child align at the center start of the view. The normalization of the composition tree failed.");
        }
        RemoteViewsTranslatorKt.l(remoteViews, translationContext, (Emittable) CollectionsKt.first(emittableLazyListItem.d()));
    }
}
