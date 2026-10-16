package com.superwall.sdk.store.testmode;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class TestModeState {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Inactive extends TestModeState {
        public static final Inactive INSTANCE = new Inactive();

        private Inactive() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Inactive);
        }

        public int hashCode() {
            return 1564346463;
        }

        public String toString() {
            return "Inactive";
        }
    }

    public /* synthetic */ TestModeState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Active extends TestModeState {
        private final TestModeReason reason;
        private final TestModeSessionData session;

        public /* synthetic */ Active(TestModeReason testModeReason, TestModeSessionData testModeSessionData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(testModeReason, (i3 & 2) != 0 ? new TestModeSessionData() : testModeSessionData);
        }

        public static /* synthetic */ Active copy$default(Active active, TestModeReason testModeReason, TestModeSessionData testModeSessionData, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                testModeReason = active.reason;
            }
            if ((i3 & 2) != 0) {
                testModeSessionData = active.session;
            }
            return active.copy(testModeReason, testModeSessionData);
        }

        public final TestModeReason component1() {
            return this.reason;
        }

        public final TestModeSessionData component2() {
            return this.session;
        }

        public final Active copy(TestModeReason reason, TestModeSessionData session) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(session, "session");
            return new Active(reason, session);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Active)) {
                return false;
            }
            Active active = (Active) obj;
            return Intrinsics.areEqual(this.reason, active.reason) && Intrinsics.areEqual(this.session, active.session);
        }

        public final TestModeReason getReason() {
            return this.reason;
        }

        public final TestModeSessionData getSession() {
            return this.session;
        }

        public int hashCode() {
            return (this.reason.hashCode() * 31) + this.session.hashCode();
        }

        public String toString() {
            return "Active(reason=" + this.reason + ", session=" + this.session + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Active(TestModeReason reason, TestModeSessionData session) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(session, "session");
            this.reason = reason;
            this.session = session;
        }
    }

    private TestModeState() {
    }
}
