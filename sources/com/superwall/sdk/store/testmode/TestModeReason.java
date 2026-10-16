package com.superwall.sdk.store.testmode;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class TestModeReason {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ApplicationIdMismatch extends TestModeReason {
        private final String actual;
        private final String expected;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApplicationIdMismatch(String expected, String actual) {
            super(null);
            Intrinsics.checkNotNullParameter(expected, "expected");
            Intrinsics.checkNotNullParameter(actual, "actual");
            this.expected = expected;
            this.actual = actual;
        }

        public static /* synthetic */ ApplicationIdMismatch copy$default(ApplicationIdMismatch applicationIdMismatch, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = applicationIdMismatch.expected;
            }
            if ((i3 & 2) != 0) {
                str2 = applicationIdMismatch.actual;
            }
            return applicationIdMismatch.copy(str, str2);
        }

        public final String component1() {
            return this.expected;
        }

        public final String component2() {
            return this.actual;
        }

        public final ApplicationIdMismatch copy(String expected, String actual) {
            Intrinsics.checkNotNullParameter(expected, "expected");
            Intrinsics.checkNotNullParameter(actual, "actual");
            return new ApplicationIdMismatch(expected, actual);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ApplicationIdMismatch)) {
                return false;
            }
            ApplicationIdMismatch applicationIdMismatch = (ApplicationIdMismatch) obj;
            return Intrinsics.areEqual(this.expected, applicationIdMismatch.expected) && Intrinsics.areEqual(this.actual, applicationIdMismatch.actual);
        }

        public final String getActual() {
            return this.actual;
        }

        public final String getExpected() {
            return this.expected;
        }

        public int hashCode() {
            return (this.expected.hashCode() * 31) + this.actual.hashCode();
        }

        public String toString() {
            return "ApplicationIdMismatch(expected=" + this.expected + ", actual=" + this.actual + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConfigMatch extends TestModeReason {
        private final String matchedId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfigMatch(String matchedId) {
            super(null);
            Intrinsics.checkNotNullParameter(matchedId, "matchedId");
            this.matchedId = matchedId;
        }

        public static /* synthetic */ ConfigMatch copy$default(ConfigMatch configMatch, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = configMatch.matchedId;
            }
            return configMatch.copy(str);
        }

        public final String component1() {
            return this.matchedId;
        }

        public final ConfigMatch copy(String matchedId) {
            Intrinsics.checkNotNullParameter(matchedId, "matchedId");
            return new ConfigMatch(matchedId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConfigMatch) && Intrinsics.areEqual(this.matchedId, ((ConfigMatch) obj).matchedId);
        }

        public final String getMatchedId() {
            return this.matchedId;
        }

        public int hashCode() {
            return this.matchedId.hashCode();
        }

        public String toString() {
            return "ConfigMatch(matchedId=" + this.matchedId + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TestModeOption extends TestModeReason {
        public static final TestModeOption INSTANCE = new TestModeOption();

        private TestModeOption() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof TestModeOption);
        }

        public int hashCode() {
            return -1490789315;
        }

        public String toString() {
            return "TestModeOption";
        }
    }

    public /* synthetic */ TestModeReason(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String getDescription() {
        if (this instanceof ConfigMatch) {
            return "User ID \"" + ((ConfigMatch) this).getMatchedId() + "\" matched a test mode user in the dashboard config.";
        }
        if (!(this instanceof ApplicationIdMismatch)) {
            if (this instanceof TestModeOption) {
                return "Test mode is always enabled via SuperwallOptions.";
            }
            throw new NoWhenBranchMatchedException();
        }
        ApplicationIdMismatch applicationIdMismatch = (ApplicationIdMismatch) this;
        return "Application ID mismatch: expected \"" + applicationIdMismatch.getExpected() + "\", got \"" + applicationIdMismatch.getActual() + "\".";
    }

    private TestModeReason() {
    }
}
