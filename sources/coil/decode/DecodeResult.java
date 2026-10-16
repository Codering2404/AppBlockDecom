package coil.decode;

import android.graphics.drawable.Drawable;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class DecodeResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Drawable f55704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f55705b;

    public DecodeResult(Drawable drawable, boolean z2) {
        this.f55704a = drawable;
        this.f55705b = z2;
    }

    public final Drawable a() {
        return this.f55704a;
    }

    public final boolean b() {
        return this.f55705b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecodeResult)) {
            return false;
        }
        DecodeResult decodeResult = (DecodeResult) obj;
        return Intrinsics.areEqual(this.f55704a, decodeResult.f55704a) && this.f55705b == decodeResult.f55705b;
    }

    public int hashCode() {
        return (this.f55704a.hashCode() * 31) + Boolean.hashCode(this.f55705b);
    }
}
