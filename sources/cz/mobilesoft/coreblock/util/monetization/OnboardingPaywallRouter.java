package cz.mobilesoft.coreblock.util.monetization;

import cz.mobilesoft.coreblock.storage.datastore.entity.IntroPremiumScreenType;
import cz.mobilesoft.coreblock.storage.datastore.entity.IntroTrialToggleScreenType;
import cz.mobilesoft.coreblock.util.paywalltrace.RuleOutcome;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
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
public final class OnboardingPaywallRouter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OnboardingPaywallRouter f128880a = new OnboardingPaywallRouter();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Decision {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Route f128881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f128882b;

        public Decision(Route route, List rules) {
            Intrinsics.checkNotNullParameter(route, "route");
            Intrinsics.checkNotNullParameter(rules, "rules");
            this.f128881a = route;
            this.f128882b = rules;
        }

        public final Route a() {
            return this.f128881a;
        }

        public final List b() {
            return this.f128882b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Decision)) {
                return false;
            }
            Decision decision = (Decision) obj;
            return Intrinsics.areEqual(this.f128881a, decision.f128881a) && Intrinsics.areEqual(this.f128882b, decision.f128882b);
        }

        public int hashCode() {
            return (this.f128881a.hashCode() * 31) + this.f128882b.hashCode();
        }

        public String toString() {
            return "Decision(route=" + this.f128881a + ", rules=" + this.f128882b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Route {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DeeplinkOffer implements Route {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final DeeplinkOffer f128883a = new DeeplinkOffer();

            private DeeplinkOffer() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof DeeplinkOffer);
            }

            public int hashCode() {
                return 306156863;
            }

            public String toString() {
                return "DeeplinkOffer";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class NoPaywall implements Route {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final NoPaywall f128884a = new NoPaywall();

            private NoPaywall() {
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof NoPaywall);
            }

            public int hashCode() {
                return 1745636378;
            }

            public String toString() {
                return "NoPaywall";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ShowScreen implements Route {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Screen f128885a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final boolean f128886b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final boolean f128887c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final boolean f128888d;

            public ShowScreen(Screen screen, boolean z2, boolean z3, boolean z4) {
                Intrinsics.checkNotNullParameter(screen, "screen");
                this.f128885a = screen;
                this.f128886b = z2;
                this.f128887c = z3;
                this.f128888d = z4;
            }

            public final Screen a() {
                return this.f128885a;
            }

            public final boolean b() {
                return this.f128886b;
            }

            public final boolean c() {
                return this.f128887c;
            }

            public final boolean d() {
                return this.f128888d;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ShowScreen)) {
                    return false;
                }
                ShowScreen showScreen = (ShowScreen) obj;
                return this.f128885a == showScreen.f128885a && this.f128886b == showScreen.f128886b && this.f128887c == showScreen.f128887c && this.f128888d == showScreen.f128888d;
            }

            public int hashCode() {
                return (((((this.f128885a.hashCode() * 31) + Boolean.hashCode(this.f128886b)) * 31) + Boolean.hashCode(this.f128887c)) * 31) + Boolean.hashCode(this.f128888d);
            }

            public String toString() {
                return "ShowScreen(screen=" + this.f128885a + ", superwallEligible=" + this.f128886b + ", withCloseButton=" + this.f128887c + ", withSkipText=" + this.f128888d + ")";
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Screen {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Screen[] $VALUES;
        public static final Screen Generic = new Screen("Generic", 0);
        public static final Screen IntroTrial = new Screen("IntroTrial", 1);
        public static final Screen IntroTrialToggle = new Screen("IntroTrialToggle", 2);

        private static final /* synthetic */ Screen[] $values() {
            return new Screen[]{Generic, IntroTrial, IntroTrialToggle};
        }

        static {
            Screen[] screenArr$values = $values();
            $VALUES = screenArr$values;
            $ENTRIES = EnumEntriesKt.a(screenArr$values);
        }

        private Screen(String str, int i3) {
        }

        public static EnumEntries<Screen> getEntries() {
            return $ENTRIES;
        }

        public static Screen valueOf(String str) {
            return (Screen) Enum.valueOf(Screen.class, str);
        }

        public static Screen[] values() {
            return (Screen[]) $VALUES.clone();
        }
    }

    private OnboardingPaywallRouter() {
    }

    public final Decision a(boolean z2, boolean z3, boolean z4, IntroTrialToggleScreenType toggleScreenType, boolean z5, IntroPremiumScreenType introScreenType, boolean z6) {
        Intrinsics.checkNotNullParameter(toggleScreenType, "toggleScreenType");
        Intrinsics.checkNotNullParameter(introScreenType, "introScreenType");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RuleOutcome("premium already active", String.valueOf(z2), z2));
        if (z2) {
            return new Decision(Route.NoPaywall.f128884a, arrayList);
        }
        arrayList.add(new RuleOutcome("pending deeplink offer", String.valueOf(z3), z3));
        if (z3) {
            return new Decision(Route.DeeplinkOffer.f128883a, arrayList);
        }
        arrayList.add(new RuleOutcome("trial eligible", String.valueOf(z4), !z4));
        if (!z4) {
            return new Decision(new Route.ShowScreen(Screen.Generic, false, true ^ z6, false), arrayList);
        }
        boolean z7 = toggleScreenType != IntroTrialToggleScreenType.TrialNoToggle && z5;
        arrayList.add(new RuleOutcome("android_intro_trial_toggle_screen_type", toggleScreenType.getId() + " (" + toggleScreenType.name() + "), isFirstStart=" + z5, z7));
        if (z7) {
            return new Decision(new Route.ShowScreen(Screen.IntroTrialToggle, false, true ^ z6, false), arrayList);
        }
        arrayList.add(new RuleOutcome("intro_premium_screen_type", introScreenType.getId() + " (" + introScreenType.name() + ")" + (z6 ? ", hard paywall" : ""), true));
        arrayList.add(new RuleOutcome("Superwall arm", z5 ? "eligible, engine resolved by caller" : "not eligible (isFirstStart=false)", false, 4, null));
        return new Decision(new Route.ShowScreen(Screen.IntroTrial, z5, (z6 || introScreenType == IntroPremiumScreenType.TrialUnskippable) ? false : true, false), arrayList);
    }
}
