package cz.mobilesoft.coreblock.scene.premium.superwall;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewState;
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
public abstract class SuperwallPlacementViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPaywallDismissed extends SuperwallPlacementViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPaywallDismissed f113802a = new OnPaywallDismissed();

        private OnPaywallDismissed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPaywallDismissed);
        }

        public int hashCode() {
            return 1890900892;
        }

        public String toString() {
            return "OnPaywallDismissed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPaywallFailed extends SuperwallPlacementViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPaywallFailed f113803a = new OnPaywallFailed();

        private OnPaywallFailed() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPaywallFailed);
        }

        public int hashCode() {
            return 1851038250;
        }

        public String toString() {
            return "OnPaywallFailed";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPaywallPurchased extends SuperwallPlacementViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f113804a;

        public OnPaywallPurchased(boolean z2) {
            super(null);
            this.f113804a = z2;
        }

        public final boolean a() {
            return this.f113804a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPaywallPurchased) && this.f113804a == ((OnPaywallPurchased) obj).f113804a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f113804a);
        }

        public String toString() {
            return "OnPaywallPurchased(restored=" + this.f113804a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStepFinished extends SuperwallPlacementViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SuperwallPlacementViewState.Step f113805a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnStepFinished(SuperwallPlacementViewState.Step step) {
            super(null);
            Intrinsics.checkNotNullParameter(step, "step");
            this.f113805a = step;
        }

        public final SuperwallPlacementViewState.Step a() {
            return this.f113805a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnStepFinished) && this.f113805a == ((OnStepFinished) obj).f113805a;
        }

        public int hashCode() {
            return this.f113805a.hashCode();
        }

        public String toString() {
            return "OnStepFinished(step=" + this.f113805a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStepLaunched extends SuperwallPlacementViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SuperwallPlacementViewState.Step f113806a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnStepLaunched(SuperwallPlacementViewState.Step step) {
            super(null);
            Intrinsics.checkNotNullParameter(step, "step");
            this.f113806a = step;
        }

        public final SuperwallPlacementViewState.Step a() {
            return this.f113806a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnStepLaunched) && this.f113806a == ((OnStepLaunched) obj).f113806a;
        }

        public int hashCode() {
            return this.f113806a.hashCode();
        }

        public String toString() {
            return "OnStepLaunched(step=" + this.f113806a + ")";
        }
    }

    public /* synthetic */ SuperwallPlacementViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SuperwallPlacementViewEvent() {
    }
}
