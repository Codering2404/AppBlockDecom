package androidx.glance.appwidget;

import androidx.glance.GlanceId;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AppWidgetId implements GlanceId {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f37732a;

    public AppWidgetId(int i3) {
        this.f37732a = i3;
    }

    public final int a() {
        return this.f37732a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AppWidgetId) && this.f37732a == ((AppWidgetId) obj).f37732a;
    }

    public int hashCode() {
        return Integer.hashCode(this.f37732a);
    }

    public String toString() {
        return sKeKFMqmvNzY.nnI + this.f37732a + ')';
    }
}
