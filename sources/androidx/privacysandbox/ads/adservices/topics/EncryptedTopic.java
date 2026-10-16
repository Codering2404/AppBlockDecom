package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
@ExperimentalFeatures.Ext11OptIn
@Metadata
public final class EncryptedTopic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f51354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f51355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f51356c;

    public EncryptedTopic(byte[] encryptedTopic, String keyIdentifier, byte[] encapsulatedKey) {
        Intrinsics.checkNotNullParameter(encryptedTopic, "encryptedTopic");
        Intrinsics.checkNotNullParameter(keyIdentifier, "keyIdentifier");
        Intrinsics.checkNotNullParameter(encapsulatedKey, "encapsulatedKey");
        this.f51354a = encryptedTopic;
        this.f51355b = keyIdentifier;
        this.f51356c = encapsulatedKey;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncryptedTopic)) {
            return false;
        }
        EncryptedTopic encryptedTopic = (EncryptedTopic) obj;
        return Arrays.equals(this.f51354a, encryptedTopic.f51354a) && this.f51355b.contentEquals(encryptedTopic.f51355b) && Arrays.equals(this.f51356c, encryptedTopic.f51356c);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.f51354a)), this.f51355b, Integer.valueOf(Arrays.hashCode(this.f51356c)));
    }

    public String toString() {
        return "EncryptedTopic { " + ("EncryptedTopic=" + StringsKt.B(this.f51354a) + ", KeyIdentifier=" + this.f51355b + ", EncapsulatedKey=" + StringsKt.B(this.f51356c) + " }");
    }
}
