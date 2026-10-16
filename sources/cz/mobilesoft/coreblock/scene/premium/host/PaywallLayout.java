package cz.mobilesoft.coreblock.scene.premium.host;

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
public interface PaywallLayout {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class IntroTrialToggle implements PaywallLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final IntroTrialToggle f113322a = new IntroTrialToggle();

        private IntroTrialToggle() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof IntroTrialToggle);
        }

        public int hashCode() {
            return -341470510;
        }

        public String toString() {
            return "IntroTrialToggle";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MySubscription implements PaywallLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MySubscription f113323a = new MySubscription();

        private MySubscription() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof MySubscription);
        }

        public int hashCode() {
            return 571210941;
        }

        public String toString() {
            return "MySubscription";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RcTrial implements PaywallLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RcTrial f113324a = new RcTrial();

        private RcTrial() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof RcTrial);
        }

        public int hashCode() {
            return 2031208977;
        }

        public String toString() {
            return "RcTrial";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Illustrated implements PaywallLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f113316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f113317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f113318c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f113319d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f113320e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Integer f113321f;

        public Illustrated(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Integer num) {
            this.f113316a = z2;
            this.f113317b = z3;
            this.f113318c = z4;
            this.f113319d = z5;
            this.f113320e = z6;
            this.f113321f = num;
        }

        public final Integer a() {
            return this.f113321f;
        }

        public final boolean b() {
            return this.f113318c;
        }

        public final boolean c() {
            return this.f113319d;
        }

        public final boolean d() {
            return this.f113317b;
        }

        public final boolean e() {
            return this.f113316a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Illustrated)) {
                return false;
            }
            Illustrated illustrated = (Illustrated) obj;
            return this.f113316a == illustrated.f113316a && this.f113317b == illustrated.f113317b && this.f113318c == illustrated.f113318c && this.f113319d == illustrated.f113319d && this.f113320e == illustrated.f113320e && Intrinsics.areEqual(this.f113321f, illustrated.f113321f);
        }

        public final boolean f() {
            return this.f113320e;
        }

        public int hashCode() {
            int iHashCode = ((((((((Boolean.hashCode(this.f113316a) * 31) + Boolean.hashCode(this.f113317b)) * 31) + Boolean.hashCode(this.f113318c)) * 31) + Boolean.hashCode(this.f113319d)) * 31) + Boolean.hashCode(this.f113320e)) * 31;
            Integer num = this.f113321f;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "Illustrated(showSelectedOption=" + this.f113316a + ", showFooterOptionsButton=" + this.f113317b + ", rasterIllustration=" + this.f113318c + ", showCountdown=" + this.f113319d + ", withTitleGradient=" + this.f113320e + ", headingRes=" + this.f113321f + ")";
        }

        public /* synthetic */ Illustrated(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) != 0 ? false : z4, (i3 & 8) != 0 ? true : z5, (i3 & 16) != 0 ? true : z6, (i3 & 32) != 0 ? null : num);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Standard implements PaywallLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f113325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f113326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f113327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f113328d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f113329e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f113330f;

        public Standard(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            this.f113325a = z2;
            this.f113326b = z3;
            this.f113327c = z4;
            this.f113328d = z5;
            this.f113329e = z6;
            this.f113330f = z7;
        }

        public final boolean a() {
            return this.f113325a;
        }

        public final boolean b() {
            return this.f113328d;
        }

        public final boolean c() {
            return this.f113327c;
        }

        public final boolean d() {
            return this.f113330f;
        }

        public final boolean e() {
            return this.f113326b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Standard)) {
                return false;
            }
            Standard standard = (Standard) obj;
            return this.f113325a == standard.f113325a && this.f113326b == standard.f113326b && this.f113327c == standard.f113327c && this.f113328d == standard.f113328d && this.f113329e == standard.f113329e && this.f113330f == standard.f113330f;
        }

        public final boolean f() {
            return this.f113329e;
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.f113325a) * 31) + Boolean.hashCode(this.f113326b)) * 31) + Boolean.hashCode(this.f113327c)) * 31) + Boolean.hashCode(this.f113328d)) * 31) + Boolean.hashCode(this.f113329e)) * 31) + Boolean.hashCode(this.f113330f);
        }

        public String toString() {
            return "Standard(showBenefits=" + this.f113325a + ", showTrial=" + this.f113326b + ", showReviews=" + this.f113327c + ", showOffers=" + this.f113328d + ", withTitleIcon=" + this.f113329e + ", showSubscriptionPrice=" + this.f113330f + ")";
        }

        public /* synthetic */ Standard(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) != 0 ? false : z4, (i3 & 8) != 0 ? false : z5, (i3 & 16) != 0 ? false : z6, (i3 & 32) != 0 ? true : z7);
        }
    }
}
