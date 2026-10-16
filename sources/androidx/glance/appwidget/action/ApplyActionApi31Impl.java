package androidx.glance.appwidget.action;

import android.app.PendingIntent;
import android.content.Intent;
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
final class ApplyActionApi31Impl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ApplyActionApi31Impl f38547a = new ApplyActionApi31Impl();

    private ApplyActionApi31Impl() {
    }

    public final void a(RemoteViews remoteViews, int i3, PendingIntent pendingIntent) {
        remoteViews.setOnCheckedChangeResponse(i3, RemoteViews.RemoteResponse.fromPendingIntent(pendingIntent));
    }

    public final void b(RemoteViews remoteViews, int i3, Intent intent) {
        remoteViews.setOnCheckedChangeResponse(i3, RemoteViews.RemoteResponse.fromFillInIntent(intent));
    }

    public final void c(RemoteViews remoteViews, int i3) {
        remoteViews.setOnCheckedChangeResponse(i3, new RemoteViews.RemoteResponse());
    }

    public final void d(RemoteViews remoteViews, int i3) {
        remoteViews.setOnClickResponse(i3, new RemoteViews.RemoteResponse());
    }
}
