package androidx.compose.material3;

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
public final class CardColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f16174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f16175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f16176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f16177d;

    public /* synthetic */ CardColors(long j3, long j4, long j5, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6);
    }

    public final long a(boolean z2) {
        return z2 ? this.f16174a : this.f16176c;
    }

    public final long b(boolean z2) {
        return z2 ? this.f16175b : this.f16177d;
    }

    public final CardColors c(long j3, long j4, long j5, long j6) {
        return new CardColors(j3 != 16 ? j3 : this.f16174a, j4 != 16 ? j4 : this.f16175b, j5 != 16 ? j5 : this.f16176c, j6 != 16 ? j6 : this.f16177d, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CardColors)) {
            return false;
        }
        CardColors cardColors = (CardColors) obj;
        return Color.t(this.f16174a, cardColors.f16174a) && Color.t(this.f16175b, cardColors.f16175b) && Color.t(this.f16176c, cardColors.f16176c) && Color.t(this.f16177d, cardColors.f16177d);
    }

    public int hashCode() {
        return (((((Color.z(this.f16174a) * 31) + Color.z(this.f16175b)) * 31) + Color.z(this.f16176c)) * 31) + Color.z(this.f16177d);
    }

    private CardColors(long j3, long j4, long j5, long j6) {
        this.f16174a = j3;
        this.f16175b = j4;
        this.f16176c = j5;
        this.f16177d = j6;
    }
}
