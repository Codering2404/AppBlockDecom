package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
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
public abstract class PauseBlockingViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPremiumRequired extends PauseBlockingViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PremiumState f100112a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPremiumRequired(PremiumState premiumState) {
            super(null);
            Intrinsics.checkNotNullParameter(premiumState, "premiumState");
            this.f100112a = premiumState;
        }

        public final PremiumState a() {
            return this.f100112a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPremiumRequired) && Intrinsics.areEqual(this.f100112a, ((OnPremiumRequired) obj).f100112a);
        }

        public int hashCode() {
            return this.f100112a.hashCode();
        }

        public String toString() {
            return "OnPremiumRequired(premiumState=" + this.f100112a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnProfilePaused extends PauseBlockingViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Profile.PausedUntil f100113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f100114b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnProfilePaused(Profile.PausedUntil pausedUntil, long j3) {
            super(null);
            Intrinsics.checkNotNullParameter(pausedUntil, "pausedUntil");
            this.f100113a = pausedUntil;
            this.f100114b = j3;
        }

        public final Profile.PausedUntil a() {
            return this.f100113a;
        }

        public final long b() {
            return this.f100114b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnProfilePaused)) {
                return false;
            }
            OnProfilePaused onProfilePaused = (OnProfilePaused) obj;
            return Intrinsics.areEqual(this.f100113a, onProfilePaused.f100113a) && this.f100114b == onProfilePaused.f100114b;
        }

        public int hashCode() {
            return (this.f100113a.hashCode() * 31) + Long.hashCode(this.f100114b);
        }

        public String toString() {
            return "OnProfilePaused(pausedUntil=" + this.f100113a + ", profileId=" + this.f100114b + ")";
        }
    }

    public /* synthetic */ PauseBlockingViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PauseBlockingViewCommand() {
    }
}
