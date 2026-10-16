package androidx.compose.material3.adaptive;

import androidx.compose.ui.geometry.Rect;
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
public final class HingeInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f21593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f21594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f21596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f21597e;

    public HingeInfo(Rect rect, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f21593a = rect;
        this.f21594b = z2;
        this.f21595c = z3;
        this.f21596d = z4;
        this.f21597e = z5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HingeInfo)) {
            return false;
        }
        HingeInfo hingeInfo = (HingeInfo) obj;
        return Intrinsics.areEqual(this.f21593a, hingeInfo.f21593a) && this.f21594b == hingeInfo.f21594b && this.f21595c == hingeInfo.f21595c && this.f21596d == hingeInfo.f21596d && this.f21597e == hingeInfo.f21597e;
    }

    public int hashCode() {
        return (((((((this.f21593a.hashCode() * 31) + Boolean.hashCode(this.f21594b)) * 31) + Boolean.hashCode(this.f21595c)) * 31) + Boolean.hashCode(this.f21596d)) * 31) + Boolean.hashCode(this.f21597e);
    }

    public String toString() {
        return "HingeInfo(bounds=" + this.f21593a + ", isFlat=" + this.f21594b + ", isVertical=" + this.f21595c + ", isSeparating=" + this.f21596d + ", isOccluding=" + this.f21597e + ')';
    }
}
