package cz.mobilesoft.coreblock.scene.strictmode3.access;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import java.util.Arrays;
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
public abstract class StrictModeAccessViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAccessMethodClicked extends StrictModeAccessViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeAccessMethod f121525a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAccessMethodClicked(StrictModeAccessMethod accessMethod) {
            super(null);
            Intrinsics.checkNotNullParameter(accessMethod, "accessMethod");
            this.f121525a = accessMethod;
        }

        public final StrictModeAccessMethod a() {
            return this.f121525a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnAccessMethodClicked) && this.f121525a == ((OnAccessMethodClicked) obj).f121525a;
        }

        public int hashCode() {
            return this.f121525a.hashCode();
        }

        public String toString() {
            return "OnAccessMethodClicked(accessMethod=" + this.f121525a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCooldownSet extends StrictModeAccessViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f121526a;

        public OnCooldownSet(long j3) {
            super(null);
            this.f121526a = j3;
        }

        public final long a() {
            return this.f121526a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnCooldownSet) && this.f121526a == ((OnCooldownSet) obj).f121526a;
        }

        public int hashCode() {
            return Long.hashCode(this.f121526a);
        }

        public String toString() {
            return "OnCooldownSet(timer=" + this.f121526a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEmailDismiss extends StrictModeAccessViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnEmailDismiss f121527a = new OnEmailDismiss();

        private OnEmailDismiss() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnEmailDismiss);
        }

        public int hashCode() {
            return -1256499412;
        }

        public String toString() {
            return "OnEmailDismiss";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEmailSet extends StrictModeAccessViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f121528a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnEmailSet(String email) {
            super(null);
            Intrinsics.checkNotNullParameter(email, "email");
            this.f121528a = email;
        }

        public final String a() {
            return this.f121528a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnEmailSet) && Intrinsics.areEqual(this.f121528a, ((OnEmailSet) obj).f121528a);
        }

        public int hashCode() {
            return this.f121528a.hashCode();
        }

        public String toString() {
            return "OnEmailSet(email=" + this.f121528a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPinConfirmed extends StrictModeAccessViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f121529a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPinConfirmed(String pinCode) {
            super(null);
            Intrinsics.checkNotNullParameter(pinCode, "pinCode");
            this.f121529a = pinCode;
        }

        public final String a() {
            return this.f121529a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPinConfirmed) && Intrinsics.areEqual(this.f121529a, ((OnPinConfirmed) obj).f121529a);
        }

        public int hashCode() {
            return this.f121529a.hashCode();
        }

        public String toString() {
            return "OnPinConfirmed(pinCode=" + this.f121529a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSchedulesSet extends StrictModeAccessViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long[] f121530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AccessMethodConfiguration.Schedules.SchedulesBlockingMode f121531b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSchedulesSet(long[] profileIds, AccessMethodConfiguration.Schedules.SchedulesBlockingMode blockingMode) {
            super(null);
            Intrinsics.checkNotNullParameter(profileIds, "profileIds");
            Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
            this.f121530a = profileIds;
            this.f121531b = blockingMode;
        }

        public final AccessMethodConfiguration.Schedules.SchedulesBlockingMode a() {
            return this.f121531b;
        }

        public final long[] b() {
            return this.f121530a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnSchedulesSet)) {
                return false;
            }
            OnSchedulesSet onSchedulesSet = (OnSchedulesSet) obj;
            return Intrinsics.areEqual(this.f121530a, onSchedulesSet.f121530a) && this.f121531b == onSchedulesSet.f121531b;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f121530a) * 31) + this.f121531b.hashCode();
        }

        public String toString() {
            return "OnSchedulesSet(profileIds=" + Arrays.toString(this.f121530a) + ", blockingMode=" + this.f121531b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTimerSet extends StrictModeAccessViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f121532a;

        public OnTimerSet(long j3) {
            super(null);
            this.f121532a = j3;
        }

        public final long a() {
            return this.f121532a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnTimerSet) && this.f121532a == ((OnTimerSet) obj).f121532a;
        }

        public int hashCode() {
            return Long.hashCode(this.f121532a);
        }

        public String toString() {
            return "OnTimerSet(timer=" + this.f121532a + ")";
        }
    }

    public /* synthetic */ StrictModeAccessViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StrictModeAccessViewEvent() {
    }
}
