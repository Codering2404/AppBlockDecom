package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class SelectionHandleInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handle f11380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SelectionHandleAnchor f11382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f11383d;

    public /* synthetic */ SelectionHandleInfo(Handle handle, long j3, SelectionHandleAnchor selectionHandleAnchor, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(handle, j3, selectionHandleAnchor, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectionHandleInfo)) {
            return false;
        }
        SelectionHandleInfo selectionHandleInfo = (SelectionHandleInfo) obj;
        return this.f11380a == selectionHandleInfo.f11380a && Offset.j(this.f11381b, selectionHandleInfo.f11381b) && this.f11382c == selectionHandleInfo.f11382c && this.f11383d == selectionHandleInfo.f11383d;
    }

    public int hashCode() {
        return (((((this.f11380a.hashCode() * 31) + Offset.o(this.f11381b)) * 31) + this.f11382c.hashCode()) * 31) + Boolean.hashCode(this.f11383d);
    }

    public String toString() {
        return "SelectionHandleInfo(handle=" + this.f11380a + ", position=" + ((Object) Offset.s(this.f11381b)) + ", anchor=" + this.f11382c + ", visible=" + this.f11383d + ')';
    }

    private SelectionHandleInfo(Handle handle, long j3, SelectionHandleAnchor selectionHandleAnchor, boolean z2) {
        this.f11380a = handle;
        this.f11381b = j3;
        this.f11382c = selectionHandleAnchor;
        this.f11383d = z2;
    }
}
