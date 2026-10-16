package androidx.compose.ui.contentcapture;

import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class ContentCaptureEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f25318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f25319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ContentCaptureEventType f25320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ViewStructureCompat f25321d;

    public ContentCaptureEvent(int i3, long j3, ContentCaptureEventType contentCaptureEventType, ViewStructureCompat viewStructureCompat) {
        this.f25318a = i3;
        this.f25319b = j3;
        this.f25320c = contentCaptureEventType;
        this.f25321d = viewStructureCompat;
    }

    public final int a() {
        return this.f25318a;
    }

    public final ViewStructureCompat b() {
        return this.f25321d;
    }

    public final ContentCaptureEventType c() {
        return this.f25320c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentCaptureEvent)) {
            return false;
        }
        ContentCaptureEvent contentCaptureEvent = (ContentCaptureEvent) obj;
        return this.f25318a == contentCaptureEvent.f25318a && this.f25319b == contentCaptureEvent.f25319b && this.f25320c == contentCaptureEvent.f25320c && Intrinsics.areEqual(this.f25321d, contentCaptureEvent.f25321d);
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.f25318a) * 31) + Long.hashCode(this.f25319b)) * 31) + this.f25320c.hashCode()) * 31;
        ViewStructureCompat viewStructureCompat = this.f25321d;
        return iHashCode + (viewStructureCompat == null ? 0 : viewStructureCompat.hashCode());
    }

    public String toString() {
        return "ContentCaptureEvent(id=" + this.f25318a + ", timestamp=" + this.f25319b + ", type=" + this.f25320c + ", structureCompat=" + this.f25321d + ')';
    }
}
