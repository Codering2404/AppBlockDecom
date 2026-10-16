package cz.mobilesoft.coreblock.scene.more.customBlockScreen;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
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
public abstract class CustomBlockingViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnConfigDeleted extends CustomBlockingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CustomBlockingScreenConfigEntity f107070a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnConfigDeleted(CustomBlockingScreenConfigEntity config) {
            super(null);
            Intrinsics.checkNotNullParameter(config, "config");
            this.f107070a = config;
        }

        public final CustomBlockingScreenConfigEntity a() {
            return this.f107070a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnConfigDeleted) && Intrinsics.areEqual(this.f107070a, ((OnConfigDeleted) obj).f107070a);
        }

        public int hashCode() {
            return this.f107070a.hashCode();
        }

        public String toString() {
            return "OnConfigDeleted(config=" + this.f107070a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnConfigSelected extends CustomBlockingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f107071a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnConfigSelected(String configId) {
            super(null);
            Intrinsics.checkNotNullParameter(configId, "configId");
            this.f107071a = configId;
        }

        public final String a() {
            return this.f107071a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnConfigSelected) && Intrinsics.areEqual(this.f107071a, ((OnConfigSelected) obj).f107071a);
        }

        public int hashCode() {
            return this.f107071a.hashCode();
        }

        public String toString() {
            return "OnConfigSelected(configId=" + this.f107071a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnConfigUpdated extends CustomBlockingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CustomBlockingScreenConfigEntity f107072a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnConfigUpdated(CustomBlockingScreenConfigEntity config) {
            super(null);
            Intrinsics.checkNotNullParameter(config, "config");
            this.f107072a = config;
        }

        public final CustomBlockingScreenConfigEntity a() {
            return this.f107072a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnConfigUpdated) && Intrinsics.areEqual(this.f107072a, ((OnConfigUpdated) obj).f107072a);
        }

        public int hashCode() {
            return this.f107072a.hashCode();
        }

        public String toString() {
            return "OnConfigUpdated(config=" + this.f107072a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEmojiUpdated extends CustomBlockingViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f107073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ScheduleEmoji f107074b;

        public final String a() {
            return this.f107073a;
        }

        public final ScheduleEmoji b() {
            return this.f107074b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnEmojiUpdated)) {
                return false;
            }
            OnEmojiUpdated onEmojiUpdated = (OnEmojiUpdated) obj;
            return Intrinsics.areEqual(this.f107073a, onEmojiUpdated.f107073a) && this.f107074b == onEmojiUpdated.f107074b;
        }

        public int hashCode() {
            return (this.f107073a.hashCode() * 31) + this.f107074b.hashCode();
        }

        public String toString() {
            return "OnEmojiUpdated(configId=" + this.f107073a + ", emoji=" + this.f107074b + ")";
        }
    }

    public /* synthetic */ CustomBlockingViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CustomBlockingViewEvent() {
    }
}
