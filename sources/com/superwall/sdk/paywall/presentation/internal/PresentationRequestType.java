package com.superwall.sdk.paywall.presentation.internal;

import com.facebook.internal.AnalyticsEvents;
import com.superwall.sdk.paywall.view.delegate.PaywallViewDelegateAdapter;
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
public abstract class PresentationRequestType {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean areEqual(PresentationRequestType lhs, PresentationRequestType rhs) {
            Intrinsics.checkNotNullParameter(lhs, "lhs");
            Intrinsics.checkNotNullParameter(rhs, "rhs");
            return ((lhs instanceof GetPaywall) && (rhs instanceof GetPaywall)) ? Intrinsics.areEqual(((GetPaywall) lhs).getAdapter(), ((GetPaywall) rhs).getAdapter()) : Intrinsics.areEqual(lhs, rhs);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConfirmAllAssignments extends PresentationRequestType {
        public static final ConfirmAllAssignments INSTANCE = new ConfirmAllAssignments();

        private ConfirmAllAssignments() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GetImplicitPresentationResult extends PresentationRequestType {
        public static final GetImplicitPresentationResult INSTANCE = new GetImplicitPresentationResult();

        private GetImplicitPresentationResult() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GetPaywall extends PresentationRequestType {
        private final PaywallViewDelegateAdapter adapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetPaywall(PaywallViewDelegateAdapter adapter) {
            super(null);
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.adapter = adapter;
        }

        public static /* synthetic */ GetPaywall copy$default(GetPaywall getPaywall, PaywallViewDelegateAdapter paywallViewDelegateAdapter, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                paywallViewDelegateAdapter = getPaywall.adapter;
            }
            return getPaywall.copy(paywallViewDelegateAdapter);
        }

        public final PaywallViewDelegateAdapter component1() {
            return this.adapter;
        }

        public final GetPaywall copy(PaywallViewDelegateAdapter adapter) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            return new GetPaywall(adapter);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetPaywall) && Intrinsics.areEqual(this.adapter, ((GetPaywall) obj).adapter);
        }

        public final PaywallViewDelegateAdapter getAdapter() {
            return this.adapter;
        }

        public int hashCode() {
            return this.adapter.hashCode();
        }

        public String toString() {
            return "GetPaywall(adapter=" + this.adapter + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GetPresentationResult extends PresentationRequestType {
        public static final GetPresentationResult INSTANCE = new GetPresentationResult();

        private GetPresentationResult() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Presentation extends PresentationRequestType {
        public static final Presentation INSTANCE = new Presentation();

        private Presentation() {
            super(null);
        }
    }

    public /* synthetic */ PresentationRequestType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String getDescription() {
        return this instanceof Presentation ? "presentation" : this instanceof GetPaywall ? "getPaywallViewController" : this instanceof GetPresentationResult ? "getPresentationResult" : this instanceof GetImplicitPresentationResult ? "getImplicitPresentationResult" : this instanceof ConfirmAllAssignments ? "confirmAllAssignments" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    public final PaywallViewDelegateAdapter getPaywallViewDelegateAdapter() {
        if (this instanceof GetPaywall) {
            return ((GetPaywall) this).getAdapter();
        }
        return null;
    }

    private PresentationRequestType() {
    }
}
