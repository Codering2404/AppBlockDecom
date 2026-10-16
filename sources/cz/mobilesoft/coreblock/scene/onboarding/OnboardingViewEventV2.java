package cz.mobilesoft.coreblock.scene.onboarding;

import cz.mobilesoft.coreblock.base.ViewEvent;
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
public abstract class OnboardingViewEventV2 implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOnboardingSkipped extends OnboardingViewEventV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOnboardingSkipped f110939a = new OnOnboardingSkipped();

        private OnOnboardingSkipped() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnOnboardingSkipped);
        }

        public int hashCode() {
            return 1101957272;
        }

        public String toString() {
            return "OnOnboardingSkipped";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPhonePickUpAnswered extends OnboardingViewEventV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f110940a;

        public final int a() {
            return this.f110940a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPhonePickUpAnswered) && this.f110940a == ((OnPhonePickUpAnswered) obj).f110940a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f110940a);
        }

        public String toString() {
            return "OnPhonePickUpAnswered(unlocks=" + this.f110940a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTimeOnPhoneAnswered extends OnboardingViewEventV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f110941a;

        public OnTimeOnPhoneAnswered(int i3) {
            super(null);
            this.f110941a = i3;
        }

        public final int a() {
            return this.f110941a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnTimeOnPhoneAnswered) && this.f110941a == ((OnTimeOnPhoneAnswered) obj).f110941a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f110941a);
        }

        public String toString() {
            return "OnTimeOnPhoneAnswered(hours=" + this.f110941a + ")";
        }
    }

    public /* synthetic */ OnboardingViewEventV2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private OnboardingViewEventV2() {
    }
}
