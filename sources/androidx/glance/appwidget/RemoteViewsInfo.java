package androidx.glance.appwidget;

import android.widget.RemoteViews;
import kotlin.Metadata;
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
public final class RemoteViewsInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RemoteViews f38423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InsertedViewInfo f38424b;

    public RemoteViewsInfo(RemoteViews remoteViews, InsertedViewInfo insertedViewInfo) {
        this.f38423a = remoteViews;
        this.f38424b = insertedViewInfo;
    }

    public final RemoteViews a() {
        return this.f38423a;
    }

    public final InsertedViewInfo b() {
        return this.f38424b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteViewsInfo)) {
            return false;
        }
        RemoteViewsInfo remoteViewsInfo = (RemoteViewsInfo) obj;
        return Intrinsics.areEqual(this.f38423a, remoteViewsInfo.f38423a) && Intrinsics.areEqual(this.f38424b, remoteViewsInfo.f38424b);
    }

    public int hashCode() {
        return (this.f38423a.hashCode() * 31) + this.f38424b.hashCode();
    }

    public String toString() {
        return "RemoteViewsInfo(remoteViews=" + this.f38423a + ", view=" + this.f38424b + ')';
    }
}
