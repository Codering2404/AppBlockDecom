package cz.mobilesoft.coreblock.scene.strictmode3.access;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public abstract class StrictModeAccessViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAccessMethodConfirmed extends StrictModeAccessViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeAccessMethod f121519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f121520b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAccessMethodConfirmed(StrictModeAccessMethod accessMethod, List configurations) {
            super(null);
            Intrinsics.checkNotNullParameter(accessMethod, "accessMethod");
            Intrinsics.checkNotNullParameter(configurations, "configurations");
            this.f121519a = accessMethod;
            this.f121520b = configurations;
        }

        public final StrictModeAccessMethod a() {
            return this.f121519a;
        }

        public final List b() {
            return this.f121520b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnAccessMethodConfirmed)) {
                return false;
            }
            OnAccessMethodConfirmed onAccessMethodConfirmed = (OnAccessMethodConfirmed) obj;
            return this.f121519a == onAccessMethodConfirmed.f121519a && Intrinsics.areEqual(this.f121520b, onAccessMethodConfirmed.f121520b);
        }

        public int hashCode() {
            return (this.f121519a.hashCode() * 31) + this.f121520b.hashCode();
        }

        public String toString() {
            return "OnAccessMethodConfirmed(accessMethod=" + this.f121519a + ", configurations=" + this.f121520b + ")";
        }

        public /* synthetic */ OnAccessMethodConfirmed(StrictModeAccessMethod strictModeAccessMethod, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(strictModeAccessMethod, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowCooldownScreen extends StrictModeAccessViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowCooldownScreen f121521a = new ShowCooldownScreen();

        private ShowCooldownScreen() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowPinCodeScreen extends StrictModeAccessViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowPinCodeScreen f121522a = new ShowPinCodeScreen();

        private ShowPinCodeScreen() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowScheduleSelectScreen extends StrictModeAccessViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowScheduleSelectScreen f121523a = new ShowScheduleSelectScreen();

        private ShowScheduleSelectScreen() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowTimerScreen extends StrictModeAccessViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowTimerScreen f121524a = new ShowTimerScreen();

        private ShowTimerScreen() {
            super(null);
        }
    }

    public /* synthetic */ StrictModeAccessViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StrictModeAccessViewCommand() {
    }
}
