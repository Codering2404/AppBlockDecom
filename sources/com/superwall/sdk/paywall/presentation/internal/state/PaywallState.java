package com.superwall.sdk.paywall.presentation.internal.state;

import com.superwall.sdk.paywall.presentation.PaywallInfo;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class PaywallState {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Dismissed extends PaywallState {
        private final PaywallInfo paywallInfo;
        private final PaywallResult paywallResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Dismissed(PaywallInfo paywallInfo, PaywallResult paywallResult) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            Intrinsics.checkNotNullParameter(paywallResult, "paywallResult");
            this.paywallInfo = paywallInfo;
            this.paywallResult = paywallResult;
        }

        public static /* synthetic */ Dismissed copy$default(Dismissed dismissed, PaywallInfo paywallInfo, PaywallResult paywallResult, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallInfo = dismissed.paywallInfo;
            }
            if ((i3 & 2) != 0) {
                paywallResult = dismissed.paywallResult;
            }
            return dismissed.copy(paywallInfo, paywallResult);
        }

        public final PaywallInfo component1() {
            return this.paywallInfo;
        }

        public final PaywallResult component2() {
            return this.paywallResult;
        }

        public final Dismissed copy(PaywallInfo paywallInfo, PaywallResult paywallResult) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            Intrinsics.checkNotNullParameter(paywallResult, "paywallResult");
            return new Dismissed(paywallInfo, paywallResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Dismissed)) {
                return false;
            }
            Dismissed dismissed = (Dismissed) obj;
            return Intrinsics.areEqual(this.paywallInfo, dismissed.paywallInfo) && Intrinsics.areEqual(this.paywallResult, dismissed.paywallResult);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public final PaywallResult getPaywallResult() {
            return this.paywallResult;
        }

        public int hashCode() {
            return (this.paywallInfo.hashCode() * 31) + this.paywallResult.hashCode();
        }

        public String toString() {
            return "Dismissed(paywallInfo=" + this.paywallInfo + ", paywallResult=" + this.paywallResult + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PresentationError extends PaywallState {
        private final Throwable error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PresentationError(Throwable error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public static /* synthetic */ PresentationError copy$default(PresentationError presentationError, Throwable th, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                th = presentationError.error;
            }
            return presentationError.copy(th);
        }

        public final Throwable component1() {
            return this.error;
        }

        public final PresentationError copy(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new PresentationError(error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PresentationError) && Intrinsics.areEqual(this.error, ((PresentationError) obj).error);
        }

        public final Throwable getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "PresentationError(error=" + this.error + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Presented extends PaywallState {
        private final PaywallInfo paywallInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Presented(PaywallInfo paywallInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            this.paywallInfo = paywallInfo;
        }

        public static /* synthetic */ Presented copy$default(Presented presented, PaywallInfo paywallInfo, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallInfo = presented.paywallInfo;
            }
            return presented.copy(paywallInfo);
        }

        public final PaywallInfo component1() {
            return this.paywallInfo;
        }

        public final Presented copy(PaywallInfo paywallInfo) {
            Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
            return new Presented(paywallInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Presented) && Intrinsics.areEqual(this.paywallInfo, ((Presented) obj).paywallInfo);
        }

        public final PaywallInfo getPaywallInfo() {
            return this.paywallInfo;
        }

        public int hashCode() {
            return this.paywallInfo.hashCode();
        }

        public String toString() {
            return "Presented(paywallInfo=" + this.paywallInfo + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Skipped extends PaywallState {
        private final PaywallSkippedReason paywallSkippedReason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Skipped(PaywallSkippedReason paywallSkippedReason) {
            super(null);
            Intrinsics.checkNotNullParameter(paywallSkippedReason, "paywallSkippedReason");
            this.paywallSkippedReason = paywallSkippedReason;
        }

        public static /* synthetic */ Skipped copy$default(Skipped skipped, PaywallSkippedReason paywallSkippedReason, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallSkippedReason = skipped.paywallSkippedReason;
            }
            return skipped.copy(paywallSkippedReason);
        }

        public final PaywallSkippedReason component1() {
            return this.paywallSkippedReason;
        }

        public final Skipped copy(PaywallSkippedReason paywallSkippedReason) {
            Intrinsics.checkNotNullParameter(paywallSkippedReason, "paywallSkippedReason");
            return new Skipped(paywallSkippedReason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Skipped) && Intrinsics.areEqual(this.paywallSkippedReason, ((Skipped) obj).paywallSkippedReason);
        }

        public final PaywallSkippedReason getPaywallSkippedReason() {
            return this.paywallSkippedReason;
        }

        public int hashCode() {
            return this.paywallSkippedReason.hashCode();
        }

        public String toString() {
            return "Skipped(paywallSkippedReason=" + this.paywallSkippedReason + ")";
        }
    }

    public /* synthetic */ PaywallState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PaywallState() {
    }
}
