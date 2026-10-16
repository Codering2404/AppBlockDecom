package cz.mobilesoft.coreblock.util.paywalltrace;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
public final class PaywallTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f128968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Stage f128969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f128970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f128971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f128972e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f128973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Boolean f128974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f128975h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map f128976i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Set f128977j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f128978k;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Stage {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Stage[] $VALUES;
        private final String label;
        public static final Stage OnboardingRouting = new Stage("OnboardingRouting", 0, "Onboarding routing");
        public static final Stage OfferingResolution = new Stage("OfferingResolution", 1, "Offering");
        public static final Stage EngineSelection = new Stage("EngineSelection", 2, "Engine");
        public static final Stage SuperwallPresentation = new Stage("SuperwallPresentation", 3, "Superwall");

        private static final /* synthetic */ Stage[] $values() {
            return new Stage[]{OnboardingRouting, OfferingResolution, EngineSelection, SuperwallPresentation};
        }

        static {
            Stage[] stageArr$values = $values();
            $VALUES = stageArr$values;
            $ENTRIES = EnumEntriesKt.a(stageArr$values);
        }

        private Stage(String str, int i3, String str2) {
            this.label = str2;
        }

        public static EnumEntries<Stage> getEntries() {
            return $ENTRIES;
        }

        public static Stage valueOf(String str) {
            return (Stage) Enum.valueOf(Stage.class, str);
        }

        public static Stage[] values() {
            return (Stage[]) $VALUES.clone();
        }

        public final String getLabel() {
            return this.label;
        }
    }

    public PaywallTrace(long j3, Stage stage, String summary, String str, String str2, String str3, Boolean bool, List rules, Map config, Set entitlements, int i3) {
        Intrinsics.checkNotNullParameter(stage, "stage");
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(rules, "rules");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        this.f128968a = j3;
        this.f128969b = stage;
        this.f128970c = summary;
        this.f128971d = str;
        this.f128972e = str2;
        this.f128973f = str3;
        this.f128974g = bool;
        this.f128975h = rules;
        this.f128976i = config;
        this.f128977j = entitlements;
        this.f128978k = i3;
    }

    public static /* synthetic */ PaywallTrace b(PaywallTrace paywallTrace, long j3, Stage stage, String str, String str2, String str3, String str4, Boolean bool, List list, Map map, Set set, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j3 = paywallTrace.f128968a;
        }
        return paywallTrace.a(j3, (i4 & 2) != 0 ? paywallTrace.f128969b : stage, (i4 & 4) != 0 ? paywallTrace.f128970c : str, (i4 & 8) != 0 ? paywallTrace.f128971d : str2, (i4 & 16) != 0 ? paywallTrace.f128972e : str3, (i4 & 32) != 0 ? paywallTrace.f128973f : str4, (i4 & 64) != 0 ? paywallTrace.f128974g : bool, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywallTrace.f128975h : list, (i4 & Function.MAX_NARGS) != 0 ? paywallTrace.f128976i : map, (i4 & 512) != 0 ? paywallTrace.f128977j : set, (i4 & 1024) != 0 ? paywallTrace.f128978k : i3);
    }

    public final PaywallTrace a(long j3, Stage stage, String summary, String str, String str2, String str3, Boolean bool, List rules, Map config, Set entitlements, int i3) {
        Intrinsics.checkNotNullParameter(stage, "stage");
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(rules, "rules");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        return new PaywallTrace(j3, stage, summary, str, str2, str3, bool, rules, config, entitlements, i3);
    }

    public final Map c() {
        return this.f128976i;
    }

    public final String d() {
        return this.f128972e;
    }

    public final Set e() {
        return this.f128977j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallTrace)) {
            return false;
        }
        PaywallTrace paywallTrace = (PaywallTrace) obj;
        return this.f128968a == paywallTrace.f128968a && this.f128969b == paywallTrace.f128969b && Intrinsics.areEqual(this.f128970c, paywallTrace.f128970c) && Intrinsics.areEqual(this.f128971d, paywallTrace.f128971d) && Intrinsics.areEqual(this.f128972e, paywallTrace.f128972e) && Intrinsics.areEqual(this.f128973f, paywallTrace.f128973f) && Intrinsics.areEqual(this.f128974g, paywallTrace.f128974g) && Intrinsics.areEqual(this.f128975h, paywallTrace.f128975h) && Intrinsics.areEqual(this.f128976i, paywallTrace.f128976i) && Intrinsics.areEqual(this.f128977j, paywallTrace.f128977j) && this.f128978k == paywallTrace.f128978k;
    }

    public final String f() {
        return this.f128971d;
    }

    public final Boolean g() {
        return this.f128974g;
    }

    public final int h() {
        return this.f128978k;
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.f128968a) * 31) + this.f128969b.hashCode()) * 31) + this.f128970c.hashCode()) * 31;
        String str = this.f128971d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f128972e;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f128973f;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.f128974g;
        return ((((((((iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31) + this.f128975h.hashCode()) * 31) + this.f128976i.hashCode()) * 31) + this.f128977j.hashCode()) * 31) + Integer.hashCode(this.f128978k);
    }

    public final List i() {
        return this.f128975h;
    }

    public final Stage j() {
        return this.f128969b;
    }

    public final String k() {
        return this.f128970c;
    }

    public final long l() {
        return this.f128968a;
    }

    public final String m() {
        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.f128969b.getLabel() + "] " + this.f128970c);
        sb.append('\n');
        String str = this.f128971d;
        if (str != null) {
            sb.append("placement: " + str);
            sb.append('\n');
        }
        String str2 = this.f128972e;
        if (str2 != null) {
            sb.append("engine: " + str2);
            sb.append('\n');
        }
        String str3 = this.f128973f;
        if (str3 != null) {
            sb.append("offering: " + str3);
            sb.append('\n');
        }
        Boolean bool = this.f128974g;
        if (bool != null) {
            sb.append("attributed to placement: " + bool.booleanValue());
            sb.append('\n');
        }
        if (!this.f128975h.isEmpty()) {
            sb.append("rules:");
            sb.append('\n');
            Iterator it = this.f128975h.iterator();
            while (it.hasNext()) {
                sb.append("  " + ((RuleOutcome) it.next()));
                sb.append('\n');
            }
        }
        if (!this.f128976i.isEmpty()) {
            sb.append("config:");
            sb.append('\n');
            for (Map.Entry entry : CollectionsKt.sortedWith(this.f128976i.entrySet(), new Comparator() { // from class: cz.mobilesoft.coreblock.util.paywalltrace.PaywallTrace$toReportString$lambda$0$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ComparisonsKt.d((String) ((Map.Entry) obj).getKey(), (String) ((Map.Entry) obj2).getKey());
                }
            })) {
                sb.append("  " + entry.getKey() + " = " + entry.getValue());
                sb.append('\n');
            }
        }
        if (!this.f128977j.isEmpty()) {
            sb.append("entitlements: " + CollectionsKt.joinToString$default(CollectionsKt.sorted(this.f128977j), null, null, null, 0, null, null, 63, null));
            sb.append('\n');
        }
        return sb.toString();
    }

    public String toString() {
        return "PaywallTrace(timestampMillis=" + this.f128968a + ", stage=" + this.f128969b + ", summary=" + this.f128970c + ", placement=" + this.f128971d + ", engine=" + this.f128972e + ", offeringId=" + this.f128973f + ", placementAttributed=" + this.f128974g + ", rules=" + this.f128975h + ", config=" + this.f128976i + ", entitlements=" + this.f128977j + ", presentationId=" + this.f128978k + ")";
    }

    public /* synthetic */ PaywallTrace(long j3, Stage stage, String str, String str2, String str3, String str4, Boolean bool, List list, Map map, Set set, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, stage, str, (i4 & 8) != 0 ? null : str2, (i4 & 16) != 0 ? null : str3, (i4 & 32) != 0 ? null : str4, (i4 & 64) != 0 ? null : bool, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? CollectionsKt.emptyList() : list, (i4 & Function.MAX_NARGS) != 0 ? MapsKt.emptyMap() : map, (i4 & 512) != 0 ? SetsKt.emptySet() : set, (i4 & 1024) != 0 ? 0 : i3);
    }
}
