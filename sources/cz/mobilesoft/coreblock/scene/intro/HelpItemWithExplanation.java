package cz.mobilesoft.coreblock.scene.intro;

import cz.mobilesoft.coreblock.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class HelpItemWithExplanation extends OnboardingHelpItem {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f104475h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final List f104476i = CollectionsKt.listOf((Object[]) new HelpItemWithExplanation[]{Focus.f104478j, MentalHealth.f104480j, PhoneUsage.f104481j, Porn.f104482j, Gaming.f104479j, Sleep.f104483j});

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f104477g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return HelpItemWithExplanation.f104476i;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Focus extends HelpItemWithExplanation {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Focus f104478j = new Focus();

        /* JADX WARN: Illegal instructions before constructor call */
        private Focus() {
            String str = "Focus";
            super(str, OnboardingNavItem.Explanation1Focus, R.drawable.f95508e2, R.string.Ol, R.string.gm, 1, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Gaming extends HelpItemWithExplanation {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Gaming f104479j = new Gaming();

        /* JADX WARN: Illegal instructions before constructor call */
        private Gaming() {
            String str = "Gaming";
            super(str, OnboardingNavItem.Explanation1Gaming, R.drawable.Z1, R.string.CA, R.string.hm, 4, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MentalHealth extends HelpItemWithExplanation {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final MentalHealth f104480j = new MentalHealth();

        /* JADX WARN: Illegal instructions before constructor call */
        private MentalHealth() {
            String str = "MentalHealth";
            super(str, OnboardingNavItem.Explanation1MentalHealth, R.drawable.f95492a2, R.string.Pl, R.string.lm, 3, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PhoneUsage extends HelpItemWithExplanation {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final PhoneUsage f104481j = new PhoneUsage();

        /* JADX WARN: Illegal instructions before constructor call */
        private PhoneUsage() {
            String str = "PhoneUsage";
            super(str, OnboardingNavItem.Explanation1PhoneUsage, R.drawable.f95500c2, R.string.DA, R.string.om, 2, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Porn extends HelpItemWithExplanation {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Porn f104482j = new Porn();

        /* JADX WARN: Illegal instructions before constructor call */
        private Porn() {
            String str = "Porn";
            super(str, OnboardingNavItem.Explanation1Porn, R.drawable.f95512f2, R.string.EA, R.string.pm, 5, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Sleep extends HelpItemWithExplanation {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Sleep f104483j = new Sleep();

        /* JADX WARN: Illegal instructions before constructor call */
        private Sleep() {
            String str = "Sleep";
            super(str, OnboardingNavItem.Explanation1Sleep, R.drawable.f95504d2, R.string.BA, R.string.Am, 6, null);
        }
    }

    public /* synthetic */ HelpItemWithExplanation(String str, OnboardingNavItem onboardingNavItem, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, onboardingNavItem, i3, i4, i5, i6);
    }

    public final int g() {
        return this.f104477g;
    }

    private HelpItemWithExplanation(String str, OnboardingNavItem onboardingNavItem, int i3, int i4, int i5, int i6) {
        super(str, i3, i4, onboardingNavItem, i6, null);
        this.f104477g = i5;
    }
}
