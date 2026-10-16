package cz.mobilesoft.coreblock.util;

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
public abstract class DeeplinkResult {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Campaign extends DeeplinkResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f127839a;

        public Campaign(long j3) {
            super(null);
            this.f127839a = j3;
        }

        public final long a() {
            return this.f127839a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Campaign) && this.f127839a == ((Campaign) obj).f127839a;
        }

        public int hashCode() {
            return Long.hashCode(this.f127839a);
        }

        public String toString() {
            return "Campaign(campaignId=" + this.f127839a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Email extends DeeplinkResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f127840a;

        public Email(String str) {
            super(null);
            this.f127840a = str;
        }

        public final String a() {
            return this.f127840a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Email) && Intrinsics.areEqual(this.f127840a, ((Email) obj).f127840a);
        }

        public int hashCode() {
            String str = this.f127840a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Email(source=" + this.f127840a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FinishRegistration extends DeeplinkResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f127841a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FinishRegistration(String email) {
            super(null);
            Intrinsics.checkNotNullParameter(email, "email");
            this.f127841a = email;
        }

        public final String a() {
            return this.f127841a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FinishRegistration) && Intrinsics.areEqual(this.f127841a, ((FinishRegistration) obj).f127841a);
        }

        public int hashCode() {
            return this.f127841a.hashCode();
        }

        public String toString() {
            return "FinishRegistration(email=" + this.f127841a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class GuestPass extends DeeplinkResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final GuestPass f127842a = new GuestPass();

        private GuestPass() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof GuestPass);
        }

        public int hashCode() {
            return 308473343;
        }

        public String toString() {
            return "GuestPass";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Login extends DeeplinkResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Login f127843a = new Login();

        private Login() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Login);
        }

        public int hashCode() {
            return 1763700319;
        }

        public String toString() {
            return "Login";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Meta extends DeeplinkResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Meta f127844a = new Meta();

        private Meta() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Meta);
        }

        public int hashCode() {
            return -81633201;
        }

        public String toString() {
            return "Meta";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Premium extends DeeplinkResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Premium f127845a = new Premium();

        private Premium() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Premium);
        }

        public int hashCode() {
            return 2038097869;
        }

        public String toString() {
            return "Premium";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Referral extends DeeplinkResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Referral f127846a = new Referral();

        private Referral() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Referral);
        }

        public int hashCode() {
            return -683962137;
        }

        public String toString() {
            return "Referral";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SoftPaywall extends DeeplinkResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SoftPaywall f127847a = new SoftPaywall();

        private SoftPaywall() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof SoftPaywall);
        }

        public int hashCode() {
            return -260399778;
        }

        public String toString() {
            return "SoftPaywall";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Unhandled extends DeeplinkResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Unhandled f127848a = new Unhandled();

        private Unhandled() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Unhandled);
        }

        public int hashCode() {
            return -693571975;
        }

        public String toString() {
            return "Unhandled";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Welcome extends DeeplinkResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Welcome f127849a = new Welcome();

        private Welcome() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Welcome);
        }

        public int hashCode() {
            return -705317672;
        }

        public String toString() {
            return "Welcome";
        }
    }

    public /* synthetic */ DeeplinkResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DeeplinkResult() {
    }
}
