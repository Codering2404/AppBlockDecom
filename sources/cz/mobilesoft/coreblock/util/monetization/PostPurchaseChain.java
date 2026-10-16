package cz.mobilesoft.coreblock.util.monetization;

import cz.mobilesoft.coreblock.enums.LoginAfterPurchase;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
public final class PostPurchaseChain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PostPurchaseChain f128896a = new PostPurchaseChain();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Inputs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LoginAfterPurchase f128897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f128898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f128899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f128900d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f128901e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f128902f;

        public Inputs(LoginAfterPurchase loginAfterPurchase, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            Intrinsics.checkNotNullParameter(loginAfterPurchase, "loginAfterPurchase");
            this.f128897a = loginAfterPurchase;
            this.f128898b = z2;
            this.f128899c = z3;
            this.f128900d = z4;
            this.f128901e = z5;
            this.f128902f = z6;
        }

        public final boolean a() {
            return this.f128901e;
        }

        public final LoginAfterPurchase b() {
            return this.f128897a;
        }

        public final boolean c() {
            return this.f128902f;
        }

        public final boolean d() {
            return this.f128900d;
        }

        public final boolean e() {
            return this.f128899c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Inputs)) {
                return false;
            }
            Inputs inputs = (Inputs) obj;
            return this.f128897a == inputs.f128897a && this.f128898b == inputs.f128898b && this.f128899c == inputs.f128899c && this.f128900d == inputs.f128900d && this.f128901e == inputs.f128901e && this.f128902f == inputs.f128902f;
        }

        public final boolean f() {
            return this.f128898b;
        }

        public int hashCode() {
            return (((((((((this.f128897a.hashCode() * 31) + Boolean.hashCode(this.f128898b)) * 31) + Boolean.hashCode(this.f128899c)) * 31) + Boolean.hashCode(this.f128900d)) * 31) + Boolean.hashCode(this.f128901e)) * 31) + Boolean.hashCode(this.f128902f);
        }

        public String toString() {
            return "Inputs(loginAfterPurchase=" + this.f128897a + ", isSignedIn=" + this.f128898b + ", wasTrialPurchased=" + this.f128899c + ", useSubscriptionOnboarding=" + this.f128900d + ", alreadyOwned=" + this.f128901e + ", showOnboardingGuestPassShare=" + this.f128902f + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Step {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Step[] $VALUES;
        public static final Step SignIn = new Step("SignIn", 0);
        public static final Step TrialReminders = new Step("TrialReminders", 1);
        public static final Step SubscriptionOnboarding = new Step("SubscriptionOnboarding", 2);
        public static final Step GuestPassShare = new Step("GuestPassShare", 3);
        public static final Step Done = new Step("Done", 4);

        private static final /* synthetic */ Step[] $values() {
            return new Step[]{SignIn, TrialReminders, SubscriptionOnboarding, GuestPassShare, Done};
        }

        static {
            Step[] stepArr$values = $values();
            $VALUES = stepArr$values;
            $ENTRIES = EnumEntriesKt.a(stepArr$values);
        }

        private Step(String str, int i3) {
        }

        public static EnumEntries<Step> getEntries() {
            return $ENTRIES;
        }

        public static Step valueOf(String str) {
            return (Step) Enum.valueOf(Step.class, str);
        }

        public static Step[] values() {
            return (Step[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f128903a;

        static {
            int[] iArr = new int[Step.values().length];
            try {
                iArr[Step.SignIn.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Step.TrialReminders.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Step.SubscriptionOnboarding.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Step.GuestPassShare.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Step.Done.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f128903a = iArr;
        }
    }

    private PostPurchaseChain() {
    }

    public final Step a(Inputs inputs) {
        Intrinsics.checkNotNullParameter(inputs, "inputs");
        return (inputs.b() == LoginAfterPurchase.None || inputs.f()) ? b(Step.SignIn, inputs) : Step.SignIn;
    }

    public final Step b(Step completed, Inputs inputs) {
        Intrinsics.checkNotNullParameter(completed, "completed");
        Intrinsics.checkNotNullParameter(inputs, "inputs");
        int i3 = WhenMappings.f128903a[completed.ordinal()];
        if (i3 == 1) {
            return inputs.e() ? Step.TrialReminders : b(Step.TrialReminders, inputs);
        }
        if (i3 == 2) {
            return (!inputs.d() || inputs.a()) ? Step.Done : Step.SubscriptionOnboarding;
        }
        if (i3 == 3) {
            return (inputs.e() && inputs.c()) ? Step.GuestPassShare : Step.Done;
        }
        if (i3 == 4) {
            return Step.Done;
        }
        if (i3 == 5) {
            return Step.Done;
        }
        throw new NoWhenBranchMatchedException();
    }
}
