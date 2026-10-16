package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.Color;
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
public final class TextSelectionColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f11600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f11601b;

    public /* synthetic */ TextSelectionColors(long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4);
    }

    public final long a() {
        return this.f11601b;
    }

    public final long b() {
        return this.f11600a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextSelectionColors)) {
            return false;
        }
        TextSelectionColors textSelectionColors = (TextSelectionColors) obj;
        return Color.t(this.f11600a, textSelectionColors.f11600a) && Color.t(this.f11601b, textSelectionColors.f11601b);
    }

    public int hashCode() {
        return (Color.z(this.f11600a) * 31) + Color.z(this.f11601b);
    }

    public String toString() {
        return "SelectionColors(selectionHandleColor=" + ((Object) Color.A(this.f11600a)) + ", selectionBackgroundColor=" + ((Object) Color.A(this.f11601b)) + ')';
    }

    private TextSelectionColors(long j3, long j4) {
        this.f11600a = j3;
        this.f11601b = j4;
    }
}
