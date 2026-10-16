package cz.mobilesoft.coreblock.scene.dev_events;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
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
public abstract class DevEventsViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CopyEventToClipboard extends DevEventsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AnswersHelper.Event f101658a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CopyEventToClipboard(AnswersHelper.Event event) {
            super(null);
            Intrinsics.checkNotNullParameter(event, "event");
            this.f101658a = event;
        }

        public final AnswersHelper.Event a() {
            return this.f101658a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CopyEventToClipboard) && Intrinsics.areEqual(this.f101658a, ((CopyEventToClipboard) obj).f101658a);
        }

        public int hashCode() {
            return this.f101658a.hashCode();
        }

        public String toString() {
            return "CopyEventToClipboard(event=" + this.f101658a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CopyEventsToClipboard extends DevEventsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CopyEventsToClipboard f101659a = new CopyEventsToClipboard();

        private CopyEventsToClipboard() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof CopyEventsToClipboard);
        }

        public int hashCode() {
            return 1539614244;
        }

        public String toString() {
            return "CopyEventsToClipboard";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnConfirmRowButtonClicked extends DevEventsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f101660a;

        public OnConfirmRowButtonClicked(boolean z2) {
            super(null);
            this.f101660a = z2;
        }

        public final boolean a() {
            return this.f101660a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnConfirmRowButtonClicked) && this.f101660a == ((OnConfirmRowButtonClicked) obj).f101660a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f101660a);
        }

        public String toString() {
            return "OnConfirmRowButtonClicked(confirm=" + this.f101660a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowConfirmRow extends DevEventsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowConfirmRow f101661a = new ShowConfirmRow();

        private ShowConfirmRow() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof ShowConfirmRow);
        }

        public int hashCode() {
            return 1336436512;
        }

        public String toString() {
            return "ShowConfirmRow";
        }
    }

    public /* synthetic */ DevEventsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DevEventsViewEvent() {
    }
}
