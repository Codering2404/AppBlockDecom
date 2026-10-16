package androidx.credentials.webauthn;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class Cbor {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Arg {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f35413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f35414b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Arg)) {
                return false;
            }
            Arg arg = (Arg) obj;
            return this.f35413a == arg.f35413a && this.f35414b == arg.f35414b;
        }

        public int hashCode() {
            return (Long.hashCode(this.f35413a) * 31) + Integer.hashCode(this.f35414b);
        }

        public String toString() {
            return "Arg(arg=" + this.f35413a + ", len=" + this.f35414b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Item {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f35415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f35416b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual(this.f35415a, item.f35415a) && this.f35416b == item.f35416b;
        }

        public int hashCode() {
            return (this.f35415a.hashCode() * 31) + Integer.hashCode(this.f35416b);
        }

        public String toString() {
            return "Item(item=" + this.f35415a + ", len=" + this.f35416b + ')';
        }
    }
}
