package cz.mobilesoft.coreblock.scene.lockscreen;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.enums.ContactReason;
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
public abstract class LockViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockProviderInitFromActivityEvent extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LockScreenIntentState f105460a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockProviderInitFromActivityEvent(LockScreenIntentState intentData) {
            super(null);
            Intrinsics.checkNotNullParameter(intentData, "intentData");
            this.f105460a = intentData;
        }

        public final LockScreenIntentState a() {
            return this.f105460a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LockProviderInitFromActivityEvent) && Intrinsics.areEqual(this.f105460a, ((LockProviderInitFromActivityEvent) obj).f105460a);
        }

        public int hashCode() {
            return this.f105460a.hashCode();
        }

        public String toString() {
            return "LockProviderInitFromActivityEvent(intentData=" + this.f105460a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockProviderInitFromServiceEvent extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LockOverlayIntentState f105461a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockProviderInitFromServiceEvent(LockOverlayIntentState intentData) {
            super(null);
            Intrinsics.checkNotNullParameter(intentData, "intentData");
            this.f105461a = intentData;
        }

        public final LockOverlayIntentState a() {
            return this.f105461a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LockProviderInitFromServiceEvent) && Intrinsics.areEqual(this.f105461a, ((LockProviderInitFromServiceEvent) obj).f105461a);
        }

        public int hashCode() {
            return this.f105461a.hashCode();
        }

        public String toString() {
            return "LockProviderInitFromServiceEvent(intentData=" + this.f105461a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockScreenAllowThisAppClickEvent extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LockScreenAllowThisAppClickEvent f105462a = new LockScreenAllowThisAppClickEvent();

        private LockScreenAllowThisAppClickEvent() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof LockScreenAllowThisAppClickEvent);
        }

        public int hashCode() {
            return 672997649;
        }

        public String toString() {
            return "LockScreenAllowThisAppClickEvent";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockScreenAvailableSettingsClickEvent extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LockScreenAvailableSettingsClickEvent f105463a = new LockScreenAvailableSettingsClickEvent();

        private LockScreenAvailableSettingsClickEvent() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof LockScreenAvailableSettingsClickEvent);
        }

        public int hashCode() {
            return -1809796135;
        }

        public String toString() {
            return "LockScreenAvailableSettingsClickEvent";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockScreenBackToAppClickEvent extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LockScreenBackToAppClickEvent f105464a = new LockScreenBackToAppClickEvent();

        private LockScreenBackToAppClickEvent() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof LockScreenBackToAppClickEvent);
        }

        public int hashCode() {
            return 1646533132;
        }

        public String toString() {
            return "LockScreenBackToAppClickEvent";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockScreenBlockedAppIconClickEvent extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LockScreenBlockedAppIconClickEvent f105465a = new LockScreenBlockedAppIconClickEvent();

        private LockScreenBlockedAppIconClickEvent() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof LockScreenBlockedAppIconClickEvent);
        }

        public int hashCode() {
            return -1051643291;
        }

        public String toString() {
            return "LockScreenBlockedAppIconClickEvent";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockScreenCampaignCardClickEvent extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LockScreenCampaignCardClickEvent f105466a = new LockScreenCampaignCardClickEvent();

        private LockScreenCampaignCardClickEvent() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof LockScreenCampaignCardClickEvent);
        }

        public int hashCode() {
            return -2072696137;
        }

        public String toString() {
            return "LockScreenCampaignCardClickEvent";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockScreenCloseButtonClickEvent extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LockScreenCloseButtonClickEvent f105467a = new LockScreenCloseButtonClickEvent();

        private LockScreenCloseButtonClickEvent() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof LockScreenCloseButtonClickEvent);
        }

        public int hashCode() {
            return 668855255;
        }

        public String toString() {
            return "LockScreenCloseButtonClickEvent";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockScreenCustomBlockCreateNowClickEvent extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LockScreenCustomBlockCreateNowClickEvent f105470a = new LockScreenCustomBlockCreateNowClickEvent();

        private LockScreenCustomBlockCreateNowClickEvent() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof LockScreenCustomBlockCreateNowClickEvent);
        }

        public int hashCode() {
            return 203243509;
        }

        public String toString() {
            return "LockScreenCustomBlockCreateNowClickEvent";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockScreenExcludeBrowserClickEvent extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f105471a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockScreenExcludeBrowserClickEvent(String packageName) {
            super(null);
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            this.f105471a = packageName;
        }

        public final String a() {
            return this.f105471a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LockScreenExcludeBrowserClickEvent) && Intrinsics.areEqual(this.f105471a, ((LockScreenExcludeBrowserClickEvent) obj).f105471a);
        }

        public int hashCode() {
            return this.f105471a.hashCode();
        }

        public String toString() {
            return "LockScreenExcludeBrowserClickEvent(packageName=" + this.f105471a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockScreenInAppUpdateCardClickEvent extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LockScreenInAppUpdateCardClickEvent f105472a = new LockScreenInAppUpdateCardClickEvent();

        private LockScreenInAppUpdateCardClickEvent() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof LockScreenInAppUpdateCardClickEvent);
        }

        public int hashCode() {
            return 332853410;
        }

        public String toString() {
            return "LockScreenInAppUpdateCardClickEvent";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockScreenPopupCloseEvent extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f105473a;

        public LockScreenPopupCloseEvent(boolean z2) {
            super(null);
            this.f105473a = z2;
        }

        public final boolean a() {
            return this.f105473a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LockScreenPopupCloseEvent) && this.f105473a == ((LockScreenPopupCloseEvent) obj).f105473a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f105473a);
        }

        public String toString() {
            return "LockScreenPopupCloseEvent(closedWithFix=" + this.f105473a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockScreenRequestCloseEvent extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LockScreenRequestCloseEvent f105474a = new LockScreenRequestCloseEvent();

        private LockScreenRequestCloseEvent() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof LockScreenRequestCloseEvent);
        }

        public int hashCode() {
            return 1095702508;
        }

        public String toString() {
            return "LockScreenRequestCloseEvent";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnBackdoorDialogSuccess extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnBackdoorDialogSuccess f105475a = new OnBackdoorDialogSuccess();

        private OnBackdoorDialogSuccess() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnBackdoorDialogSuccess);
        }

        public int hashCode() {
            return 199928857;
        }

        public String toString() {
            return "OnBackdoorDialogSuccess";
        }
    }

    public /* synthetic */ LockViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LockViewEvent() {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LockScreenContactSupportClickEvent extends LockViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContactReason f105468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f105469b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LockScreenContactSupportClickEvent(ContactReason reason, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.f105468a = reason;
            this.f105469b = z2;
        }

        public final boolean a() {
            return this.f105469b;
        }

        public final ContactReason b() {
            return this.f105468a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LockScreenContactSupportClickEvent)) {
                return false;
            }
            LockScreenContactSupportClickEvent lockScreenContactSupportClickEvent = (LockScreenContactSupportClickEvent) obj;
            return this.f105468a == lockScreenContactSupportClickEvent.f105468a && this.f105469b == lockScreenContactSupportClickEvent.f105469b;
        }

        public int hashCode() {
            return (this.f105468a.hashCode() * 31) + Boolean.hashCode(this.f105469b);
        }

        public String toString() {
            return "LockScreenContactSupportClickEvent(reason=" + this.f105468a + ", logStrictModeBlockingReason=" + this.f105469b + ")";
        }

        public /* synthetic */ LockScreenContactSupportClickEvent(ContactReason contactReason, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(contactReason, (i3 & 2) != 0 ? false : z2);
        }
    }
}
