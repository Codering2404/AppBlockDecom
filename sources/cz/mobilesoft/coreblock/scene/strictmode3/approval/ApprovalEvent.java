package cz.mobilesoft.coreblock.scene.strictmode3.approval;

import cz.mobilesoft.coreblock.util.FailedWithError;
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
public abstract class ApprovalEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Error extends ApprovalEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FailedWithError f121706a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(FailedWithError failedWithError) {
            super(null);
            Intrinsics.checkNotNullParameter(failedWithError, "failedWithError");
            this.f121706a = failedWithError;
        }

        public final FailedWithError a() {
            return this.f121706a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.f121706a, ((Error) obj).f121706a);
        }

        public int hashCode() {
            return this.f121706a.hashCode();
        }

        public String toString() {
            return "Error(failedWithError=" + this.f121706a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Loading extends ApprovalEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Loading f121707a = new Loading();

        private Loading() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Loading);
        }

        public int hashCode() {
            return 661784366;
        }

        public String toString() {
            return "Loading";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ReadyToActivate extends ApprovalEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ReadyToActivate f121708a = new ReadyToActivate();

        private ReadyToActivate() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ReadyToActivate);
        }

        public int hashCode() {
            return 593557123;
        }

        public String toString() {
            return "ReadyToActivate";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ReadyToDeactivate extends ApprovalEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ReadyToDeactivate f121709a = new ReadyToDeactivate();

        private ReadyToDeactivate() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ReadyToDeactivate);
        }

        public int hashCode() {
            return -565260796;
        }

        public String toString() {
            return "ReadyToDeactivate";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ResendEmailCountdownEnded extends ApprovalEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ResendEmailCountdownEnded f121710a = new ResendEmailCountdownEnded();

        private ResendEmailCountdownEnded() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ResendEmailCountdownEnded);
        }

        public int hashCode() {
            return 552190716;
        }

        public String toString() {
            return "ResendEmailCountdownEnded";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ResendEmailCountdownRunning extends ApprovalEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ResendEmailCountdownRunning f121711a = new ResendEmailCountdownRunning();

        private ResendEmailCountdownRunning() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ResendEmailCountdownRunning);
        }

        public int hashCode() {
            return 1236862337;
        }

        public String toString() {
            return "ResendEmailCountdownRunning";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Success extends ApprovalEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Success f121712a = new Success();

        private Success() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Success);
        }

        public int hashCode() {
            return -1542035979;
        }

        public String toString() {
            return "Success";
        }
    }

    public /* synthetic */ ApprovalEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ApprovalEvent() {
    }
}
