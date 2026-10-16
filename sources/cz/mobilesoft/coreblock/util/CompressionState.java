package cz.mobilesoft.coreblock.util;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class CompressionState {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Error extends CompressionState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Integer f127785a;

        public Error(Integer num) {
            super(null);
            this.f127785a = num;
        }

        public final Integer a() {
            return this.f127785a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.f127785a, ((Error) obj).f127785a);
        }

        public int hashCode() {
            Integer num = this.f127785a;
            if (num == null) {
                return 0;
            }
            return num.hashCode();
        }

        public String toString() {
            return "Error(errorText=" + this.f127785a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Loading extends CompressionState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f127786a;

        public Loading(int i3) {
            super(null);
            this.f127786a = i3;
        }

        public final int a() {
            return this.f127786a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Loading) && this.f127786a == ((Loading) obj).f127786a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f127786a);
        }

        public String toString() {
            return "Loading(compressionProgress=" + this.f127786a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Success extends CompressionState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f127787a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(File outputFile) {
            super(null);
            Intrinsics.checkNotNullParameter(outputFile, "outputFile");
            this.f127787a = outputFile;
        }

        public final File a() {
            return this.f127787a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.f127787a, ((Success) obj).f127787a);
        }

        public int hashCode() {
            return this.f127787a.hashCode();
        }

        public String toString() {
            return "Success(outputFile=" + this.f127787a + ")";
        }
    }

    public /* synthetic */ CompressionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CompressionState() {
    }
}
