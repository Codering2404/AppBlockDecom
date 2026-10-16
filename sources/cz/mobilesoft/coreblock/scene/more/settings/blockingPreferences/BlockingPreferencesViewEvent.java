package cz.mobilesoft.coreblock.scene.more.settings.blockingPreferences;

import cz.mobilesoft.coreblock.base.ViewEvent;
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
public abstract class BlockingPreferencesViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAvailableSettingsClicked extends BlockingPreferencesViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAvailableSettingsClicked f108070a = new OnAvailableSettingsClicked();

        private OnAvailableSettingsClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnAvailableSettingsClicked);
        }

        public int hashCode() {
            return 636195180;
        }

        public String toString() {
            return "OnAvailableSettingsClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAvailableSettingsItemClicked extends BlockingPreferencesViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f108071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f108072b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAvailableSettingsItemClicked(String itemName, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(itemName, "itemName");
            this.f108071a = itemName;
            this.f108072b = z2;
        }

        public final String a() {
            return this.f108071a;
        }

        public final boolean b() {
            return this.f108072b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnAvailableSettingsItemClicked)) {
                return false;
            }
            OnAvailableSettingsItemClicked onAvailableSettingsItemClicked = (OnAvailableSettingsItemClicked) obj;
            return Intrinsics.areEqual(this.f108071a, onAvailableSettingsItemClicked.f108071a) && this.f108072b == onAvailableSettingsItemClicked.f108072b;
        }

        public int hashCode() {
            return (this.f108071a.hashCode() * 31) + Boolean.hashCode(this.f108072b);
        }

        public String toString() {
            return "OnAvailableSettingsItemClicked(itemName=" + this.f108071a + ", isConfirmation=" + this.f108072b + ")";
        }

        public /* synthetic */ OnAvailableSettingsItemClicked(String str, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? false : z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBlockAppUninstallClicked extends BlockingPreferencesViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnBlockAppUninstallClicked f108073a = new OnBlockAppUninstallClicked();

        private OnBlockAppUninstallClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnBlockAppUninstallClicked);
        }

        public int hashCode() {
            return 124514378;
        }

        public String toString() {
            return "OnBlockAppUninstallClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBlockPhoneStartupClicked extends BlockingPreferencesViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnBlockPhoneStartupClicked f108074a = new OnBlockPhoneStartupClicked();

        private OnBlockPhoneStartupClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnBlockPhoneStartupClicked);
        }

        public int hashCode() {
            return -288196836;
        }

        public String toString() {
            return "OnBlockPhoneStartupClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBlockPopupsClicked extends BlockingPreferencesViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnBlockPopupsClicked f108075a = new OnBlockPopupsClicked();

        private OnBlockPopupsClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnBlockPopupsClicked);
        }

        public int hashCode() {
            return -1552976124;
        }

        public String toString() {
            return "OnBlockPopupsClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLocationSwitchClicked extends BlockingPreferencesViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnLocationSwitchClicked f108076a = new OnLocationSwitchClicked();

        private OnLocationSwitchClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnLocationSwitchClicked);
        }

        public int hashCode() {
            return -1980245683;
        }

        public String toString() {
            return "OnLocationSwitchClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMindfulEditClicked extends BlockingPreferencesViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMindfulEditClicked f108077a = new OnMindfulEditClicked();

        private OnMindfulEditClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnMindfulEditClicked);
        }

        public int hashCode() {
            return -1287795837;
        }

        public String toString() {
            return "OnMindfulEditClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPopupBlockingPermissionGiven extends BlockingPreferencesViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPopupBlockingPermissionGiven f108078a = new OnPopupBlockingPermissionGiven();

        private OnPopupBlockingPermissionGiven() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnPopupBlockingPermissionGiven);
        }

        public int hashCode() {
            return -569758690;
        }

        public String toString() {
            return "OnPopupBlockingPermissionGiven";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSchedulePauseClicked extends BlockingPreferencesViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSchedulePauseClicked f108079a = new OnSchedulePauseClicked();

        private OnSchedulePauseClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnSchedulePauseClicked);
        }

        public int hashCode() {
            return 390250233;
        }

        public String toString() {
            return "OnSchedulePauseClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStrictDeactivationTimeConfirm extends BlockingPreferencesViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f108080a;

        public OnStrictDeactivationTimeConfirm(long j3) {
            super(null);
            this.f108080a = j3;
        }

        public final long a() {
            return this.f108080a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnStrictDeactivationTimeConfirm) && this.f108080a == ((OnStrictDeactivationTimeConfirm) obj).f108080a;
        }

        public int hashCode() {
            return Long.hashCode(this.f108080a);
        }

        public String toString() {
            return "OnStrictDeactivationTimeConfirm(deactivationTimeInMillis=" + this.f108080a + ")";
        }
    }

    public /* synthetic */ BlockingPreferencesViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BlockingPreferencesViewEvent() {
    }
}
