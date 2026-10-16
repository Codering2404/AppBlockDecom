package androidx.glance.appwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
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
public final class GlanceRemoteViewsServiceKt {
    public static final void a(RemoteViews remoteViews, Context context, int i3, int i4, String str, RemoteCollectionItems remoteCollectionItems) {
        if (Build.VERSION.SDK_INT > 31) {
            CollectionItemsApi31Impl.f37865a.a(remoteViews, i4, remoteCollectionItems);
            return;
        }
        Intent intentPutExtra = new Intent(context, (Class<?>) GlanceRemoteViewsService.class).putExtra("appWidgetId", i3).putExtra("androidx.glance.widget.extra.view_id", i4).putExtra("androidx.glance.widget.extra.size_info", str);
        intentPutExtra.setData(Uri.parse(intentPutExtra.toUri(1)));
        if (context.getPackageManager().resolveService(intentPutExtra, 0) == null) {
            throw new IllegalStateException("GlanceRemoteViewsService could not be resolved, check the app manifest.");
        }
        remoteViews.setRemoteAdapter(i4, intentPutExtra);
        GlanceRemoteViewsService.f38071a.e(i3, i4, str, remoteCollectionItems);
        AppWidgetManager.getInstance(context).notifyAppWidgetViewDataChanged(i3, i4);
    }
}
