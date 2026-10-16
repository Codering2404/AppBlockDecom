package androidx.compose.material;

import androidx.compose.ui.unit.Dp;
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
public final class TabPosition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f14547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f14548b;

    public /* synthetic */ TabPosition(float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4);
    }

    public final float a() {
        return this.f14547a;
    }

    public final float b() {
        return Dp.g(this.f14547a + this.f14548b);
    }

    public final float c() {
        return this.f14548b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabPosition)) {
            return false;
        }
        TabPosition tabPosition = (TabPosition) obj;
        return Dp.i(this.f14547a, tabPosition.f14547a) && Dp.i(this.f14548b, tabPosition.f14548b);
    }

    public int hashCode() {
        return (Dp.j(this.f14547a) * 31) + Dp.j(this.f14548b);
    }

    public String toString() {
        return "TabPosition(left=" + ((Object) Dp.k(this.f14547a)) + ", right=" + ((Object) Dp.k(b())) + ", width=" + ((Object) Dp.k(this.f14548b)) + ')';
    }

    private TabPosition(float f3, float f4) {
        this.f14547a = f3;
        this.f14548b = f4;
    }
}
