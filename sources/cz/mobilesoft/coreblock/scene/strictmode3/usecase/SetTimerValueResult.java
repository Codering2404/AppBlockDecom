package cz.mobilesoft.coreblock.scene.strictmode3.usecase;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class SetTimerValueResult {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MaxTimerLimitReached extends SetTimerValueResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f122530a;

        public MaxTimerLimitReached(int i3) {
            super(null);
            this.f122530a = i3;
        }

        public final int a() {
            return this.f122530a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MaxTimerLimitReached) && this.f122530a == ((MaxTimerLimitReached) obj).f122530a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f122530a);
        }

        public String toString() {
            return "MaxTimerLimitReached(maxDays=" + this.f122530a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Success extends SetTimerValueResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Success f122531a = new Success();

        private Success() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Success);
        }

        public int hashCode() {
            return 1223740821;
        }

        public String toString() {
            return "Success";
        }
    }

    public /* synthetic */ SetTimerValueResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SetTimerValueResult() {
    }
}
