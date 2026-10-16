package cz.mobilesoft.coreblock.scene.feedback;

import android.net.Uri;
import androidx.glance.session.ecY.lisODU;
import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState;
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
public abstract class FeedbackViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAddAttachmentClicked extends FeedbackViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f102072a;

        public OnAddAttachmentClicked(Uri uri) {
            super(null);
            this.f102072a = uri;
        }

        public final Uri a() {
            return this.f102072a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnAddAttachmentClicked) && Intrinsics.areEqual(this.f102072a, ((OnAddAttachmentClicked) obj).f102072a);
        }

        public int hashCode() {
            Uri uri = this.f102072a;
            if (uri == null) {
                return 0;
            }
            return uri.hashCode();
        }

        public String toString() {
            return "OnAddAttachmentClicked(uri=" + this.f102072a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAttachmentRemoved extends FeedbackViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final FeedbackViewState.FreshdeskAttachment f102073a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnAttachmentRemoved(FeedbackViewState.FreshdeskAttachment attachment) {
            super(null);
            Intrinsics.checkNotNullParameter(attachment, "attachment");
            this.f102073a = attachment;
        }

        public final FeedbackViewState.FreshdeskAttachment a() {
            return this.f102073a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnAttachmentRemoved) && Intrinsics.areEqual(this.f102073a, ((OnAttachmentRemoved) obj).f102073a);
        }

        public int hashCode() {
            return this.f102073a.hashCode();
        }

        public String toString() {
            return "OnAttachmentRemoved(attachment=" + this.f102073a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEmailChanged extends FeedbackViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f102074a;

        public final String a() {
            return this.f102074a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnEmailChanged) && Intrinsics.areEqual(this.f102074a, ((OnEmailChanged) obj).f102074a);
        }

        public int hashCode() {
            return this.f102074a.hashCode();
        }

        public String toString() {
            return "OnEmailChanged(emailText=" + this.f102074a + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnEmailChanged(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, lisODU.PtvPqyXFnn);
            this.f102074a = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnEmailConfirmedChanged extends FeedbackViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f102075a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnEmailConfirmedChanged(String emailText) {
            super(null);
            Intrinsics.checkNotNullParameter(emailText, "emailText");
            this.f102075a = emailText;
        }

        public final String a() {
            return this.f102075a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnEmailConfirmedChanged) && Intrinsics.areEqual(this.f102075a, ((OnEmailConfirmedChanged) obj).f102075a);
        }

        public int hashCode() {
            return this.f102075a.hashCode();
        }

        public String toString() {
            return "OnEmailConfirmedChanged(emailText=" + this.f102075a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMessageChanged extends FeedbackViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f102076a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnMessageChanged(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.f102076a = message;
        }

        public final String a() {
            return this.f102076a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnMessageChanged) && Intrinsics.areEqual(this.f102076a, ((OnMessageChanged) obj).f102076a);
        }

        public int hashCode() {
            return this.f102076a.hashCode();
        }

        public String toString() {
            return "OnMessageChanged(message=" + this.f102076a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnReasonSelected extends FeedbackViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContactReason f102077a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnReasonSelected(ContactReason reason) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.f102077a = reason;
        }

        public final ContactReason a() {
            return this.f102077a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnReasonSelected) && this.f102077a == ((OnReasonSelected) obj).f102077a;
        }

        public int hashCode() {
            return this.f102077a.hashCode();
        }

        public String toString() {
            return KLAQHFCRAUejH.WZaxcRmuvgsPlo + this.f102077a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnRetryClicked extends FeedbackViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnRetryClicked f102078a = new OnRetryClicked();

        private OnRetryClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnRetryClicked);
        }

        public int hashCode() {
            return -1589796584;
        }

        public String toString() {
            return "OnRetryClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSendClicked extends FeedbackViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSendClicked f102079a = new OnSendClicked();

        private OnSendClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnSendClicked);
        }

        public int hashCode() {
            return -2027656282;
        }

        public String toString() {
            return "OnSendClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SaveEmergencyEntrance extends FeedbackViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SaveEmergencyEntrance f102080a = new SaveEmergencyEntrance();

        private SaveEmergencyEntrance() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof SaveEmergencyEntrance);
        }

        public int hashCode() {
            return 1706969328;
        }

        public String toString() {
            return "SaveEmergencyEntrance";
        }
    }

    public /* synthetic */ FeedbackViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private FeedbackViewEvent() {
    }
}
