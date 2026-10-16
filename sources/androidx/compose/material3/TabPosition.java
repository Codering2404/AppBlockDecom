package androidx.compose.material3;

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
    private final float f20568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f20569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f20570c;

    public /* synthetic */ TabPosition(float f3, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5);
    }

    public final float a() {
        return this.f20570c;
    }

    public final float b() {
        return this.f20568a;
    }

    public final float c() {
        return Dp.g(this.f20568a + this.f20569b);
    }

    public final float d() {
        return this.f20569b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabPosition)) {
            return false;
        }
        TabPosition tabPosition = (TabPosition) obj;
        return Dp.i(this.f20568a, tabPosition.f20568a) && Dp.i(this.f20569b, tabPosition.f20569b) && Dp.i(this.f20570c, tabPosition.f20570c);
    }

    public int hashCode() {
        return (((Dp.j(this.f20568a) * 31) + Dp.j(this.f20569b)) * 31) + Dp.j(this.f20570c);
    }

    public String toString() {
        return "TabPosition(left=" + ((Object) Dp.k(this.f20568a)) + ", right=" + ((Object) Dp.k(c())) + ", width=" + ((Object) Dp.k(this.f20569b)) + ", contentWidth=" + ((Object) Dp.k(this.f20570c)) + ')';
    }

    private TabPosition(float f3, float f4, float f5) {
        this.f20568a = f3;
        this.f20569b = f4;
        this.f20570c = f5;
    }
}
