package cz.mobilesoft.coreblock.usecase;

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
public abstract class GuestPassEligibility {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AlreadyPremium extends GuestPassEligibility {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AlreadyPremium f127166a = new AlreadyPremium();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f127167b = "already_premium";

        private AlreadyPremium() {
            super(null);
        }

        @Override // cz.mobilesoft.coreblock.usecase.GuestPassEligibility
        public String a() {
            return f127167b;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof AlreadyPremium);
        }

        public int hashCode() {
            return -719973529;
        }

        public String toString() {
            return "AlreadyPremium";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Eligible extends GuestPassEligibility {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Eligible f127168a = new Eligible();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f127169b = "eligible";

        private Eligible() {
            super(null);
        }

        @Override // cz.mobilesoft.coreblock.usecase.GuestPassEligibility
        public String a() {
            return f127169b;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Eligible);
        }

        public int hashCode() {
            return 464990303;
        }

        public String toString() {
            return "Eligible";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class HadPremiumInPast extends GuestPassEligibility {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HadPremiumInPast f127170a = new HadPremiumInPast();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f127171b = "had_premium_in_past";

        private HadPremiumInPast() {
            super(null);
        }

        @Override // cz.mobilesoft.coreblock.usecase.GuestPassEligibility
        public String a() {
            return f127171b;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof HadPremiumInPast);
        }

        public int hashCode() {
            return 202927563;
        }

        public String toString() {
            return "HadPremiumInPast";
        }
    }

    public /* synthetic */ GuestPassEligibility(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String a();

    private GuestPassEligibility() {
    }
}
