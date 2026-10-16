package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class BorderStroke {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f4768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Brush f4769b;

    public /* synthetic */ BorderStroke(float f3, Brush brush, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, brush);
    }

    public final Brush a() {
        return this.f4769b;
    }

    public final float b() {
        return this.f4768a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderStroke)) {
            return false;
        }
        BorderStroke borderStroke = (BorderStroke) obj;
        return Dp.i(this.f4768a, borderStroke.f4768a) && Intrinsics.areEqual(this.f4769b, borderStroke.f4769b);
    }

    public int hashCode() {
        return (Dp.j(this.f4768a) * 31) + this.f4769b.hashCode();
    }

    public String toString() {
        return "BorderStroke(width=" + ((Object) Dp.k(this.f4768a)) + ", brush=" + this.f4769b + ')';
    }

    private BorderStroke(float f3, Brush brush) {
        this.f4768a = f3;
        this.f4769b = brush;
    }
}
