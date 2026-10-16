package androidx.compose.ui.text;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class BulletSpanWithLevel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bullet f28684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28686c;

    public BulletSpanWithLevel(Bullet bullet, int i3, int i4) {
        this.f28684a = bullet;
        this.f28685b = i3;
        this.f28686c = i4;
    }

    public final Bullet a() {
        return this.f28684a;
    }

    public final int b() {
        return this.f28685b;
    }

    public final int c() {
        return this.f28686c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BulletSpanWithLevel)) {
            return false;
        }
        BulletSpanWithLevel bulletSpanWithLevel = (BulletSpanWithLevel) obj;
        return Intrinsics.areEqual(this.f28684a, bulletSpanWithLevel.f28684a) && this.f28685b == bulletSpanWithLevel.f28685b && this.f28686c == bulletSpanWithLevel.f28686c;
    }

    public int hashCode() {
        return (((this.f28684a.hashCode() * 31) + Integer.hashCode(this.f28685b)) * 31) + Integer.hashCode(this.f28686c);
    }

    public String toString() {
        return "BulletSpanWithLevel(bullet=" + this.f28684a + ", indentationLevel=" + this.f28685b + ", start=" + this.f28686c + ')';
    }
}
