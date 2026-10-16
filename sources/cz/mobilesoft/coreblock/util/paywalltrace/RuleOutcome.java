package cz.mobilesoft.coreblock.util.paywalltrace;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class RuleOutcome {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f128986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f128987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f128988c;

    public RuleOutcome(String rule, String outcome, boolean z2) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        this.f128986a = rule;
        this.f128987b = outcome;
        this.f128988c = z2;
    }

    public static /* synthetic */ RuleOutcome b(RuleOutcome ruleOutcome, String str, String str2, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = ruleOutcome.f128986a;
        }
        if ((i3 & 2) != 0) {
            str2 = ruleOutcome.f128987b;
        }
        if ((i3 & 4) != 0) {
            z2 = ruleOutcome.f128988c;
        }
        return ruleOutcome.a(str, str2, z2);
    }

    public final RuleOutcome a(String rule, String outcome, boolean z2) {
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        return new RuleOutcome(rule, outcome, z2);
    }

    public final boolean c() {
        return this.f128988c;
    }

    public final String d() {
        return this.f128987b;
    }

    public final String e() {
        return this.f128986a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RuleOutcome)) {
            return false;
        }
        RuleOutcome ruleOutcome = (RuleOutcome) obj;
        return Intrinsics.areEqual(this.f128986a, ruleOutcome.f128986a) && Intrinsics.areEqual(this.f128987b, ruleOutcome.f128987b) && this.f128988c == ruleOutcome.f128988c;
    }

    public int hashCode() {
        return (((this.f128986a.hashCode() * 31) + this.f128987b.hashCode()) * 31) + Boolean.hashCode(this.f128988c);
    }

    public String toString() {
        return (this.f128988c ? "→ " : "  ") + this.f128986a + " = " + this.f128987b;
    }

    public /* synthetic */ RuleOutcome(String str, String str2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? false : z2);
    }
}
