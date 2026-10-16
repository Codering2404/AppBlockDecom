package androidx.compose.animation.graphics.vector;

import androidx.compose.animation.core.Easing;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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
public final class PropertyValuesHolder2D extends PropertyValuesHolder<Pair<? extends Float, ? extends Float>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f4432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f4433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Easing f4434d;

    public PropertyValuesHolder2D(String str, String str2, List list, Easing easing) {
        super(null);
        this.f4431a = str;
        this.f4432b = str2;
        this.f4433c = list;
        this.f4434d = easing;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PropertyValuesHolder2D)) {
            return false;
        }
        PropertyValuesHolder2D propertyValuesHolder2D = (PropertyValuesHolder2D) obj;
        return Intrinsics.areEqual(this.f4431a, propertyValuesHolder2D.f4431a) && Intrinsics.areEqual(this.f4432b, propertyValuesHolder2D.f4432b) && Intrinsics.areEqual(this.f4433c, propertyValuesHolder2D.f4433c) && Intrinsics.areEqual(this.f4434d, propertyValuesHolder2D.f4434d);
    }

    public int hashCode() {
        return (((((this.f4431a.hashCode() * 31) + this.f4432b.hashCode()) * 31) + this.f4433c.hashCode()) * 31) + this.f4434d.hashCode();
    }

    public String toString() {
        return "PropertyValuesHolder2D(xPropertyName=" + this.f4431a + ", yPropertyName=" + this.f4432b + ", pathData=" + this.f4433c + ", interpolator=" + this.f4434d + ')';
    }
}
