package androidx.compose.material3;

import androidx.compose.ui.window.SecureFlagPolicy;
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
public final class ModalBottomSheetProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SecureFlagPolicy f18364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f18365b;

    public ModalBottomSheetProperties(SecureFlagPolicy secureFlagPolicy, boolean z2) {
        this.f18364a = secureFlagPolicy;
        this.f18365b = z2;
    }

    public final SecureFlagPolicy a() {
        return this.f18364a;
    }

    public final boolean b() {
        return this.f18365b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ModalBottomSheetProperties) && this.f18364a == ((ModalBottomSheetProperties) obj).f18364a;
    }

    public int hashCode() {
        return (this.f18364a.hashCode() * 31) + Boolean.hashCode(this.f18365b);
    }

    public /* synthetic */ ModalBottomSheetProperties(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2);
    }

    public ModalBottomSheetProperties(boolean z2) {
        this(SecureFlagPolicy.f30288a, z2);
    }
}
