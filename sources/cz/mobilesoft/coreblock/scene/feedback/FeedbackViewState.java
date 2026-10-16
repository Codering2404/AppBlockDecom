package cz.mobilesoft.coreblock.scene.feedback;

import android.net.Uri;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.ContactReason;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
public final class FeedbackViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f102177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f102178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f102179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImmutableList f102180d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ContactReason f102181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f102182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f102183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f102184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Set f102185j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f102186k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f102187l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f102188m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f102189n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f102190o;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FeedbackValidationError {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FeedbackValidationError[] $VALUES;
        public static final FeedbackValidationError EmailsDoNotMatch = new FeedbackValidationError("EmailsDoNotMatch", 0);
        public static final FeedbackValidationError MissingSelectedReason = new FeedbackValidationError("MissingSelectedReason", 1);
        public static final FeedbackValidationError EmailIsInvalid = new FeedbackValidationError("EmailIsInvalid", 2);
        public static final FeedbackValidationError MessageIsEmpty = new FeedbackValidationError("MessageIsEmpty", 3);
        public static final FeedbackValidationError AttachmentSizeExceeded = new FeedbackValidationError("AttachmentSizeExceeded", 4);
        public static final FeedbackValidationError NoInternetConnection = new FeedbackValidationError("NoInternetConnection", 5);
        public static final FeedbackValidationError ApiError = new FeedbackValidationError("ApiError", 6);

        private static final /* synthetic */ FeedbackValidationError[] $values() {
            return new FeedbackValidationError[]{EmailsDoNotMatch, MissingSelectedReason, EmailIsInvalid, MessageIsEmpty, AttachmentSizeExceeded, NoInternetConnection, ApiError};
        }

        static {
            FeedbackValidationError[] feedbackValidationErrorArr$values = $values();
            $VALUES = feedbackValidationErrorArr$values;
            $ENTRIES = EnumEntriesKt.a(feedbackValidationErrorArr$values);
        }

        private FeedbackValidationError(String str, int i3) {
        }

        public static EnumEntries<FeedbackValidationError> getEntries() {
            return $ENTRIES;
        }

        public static FeedbackValidationError valueOf(String str) {
            return (FeedbackValidationError) Enum.valueOf(FeedbackValidationError.class, str);
        }

        public static FeedbackValidationError[] values() {
            return (FeedbackValidationError[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class FreshdeskAttachment {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class MemoryFile extends FreshdeskAttachment {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f102191a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f102192b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final byte[] f102193c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MemoryFile(String name, long j3, byte[] bytes) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                this.f102191a = name;
                this.f102192b = j3;
                this.f102193c = bytes;
            }

            @Override // cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState.FreshdeskAttachment
            public String a() {
                return this.f102191a;
            }

            @Override // cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState.FreshdeskAttachment
            public long b() {
                return this.f102192b;
            }

            public final byte[] c() {
                return this.f102193c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!Intrinsics.areEqual(MemoryFile.class, obj != null ? obj.getClass() : null)) {
                    return false;
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState.FreshdeskAttachment.MemoryFile");
                MemoryFile memoryFile = (MemoryFile) obj;
                return Intrinsics.areEqual(a(), memoryFile.a()) && b() == memoryFile.b() && Arrays.equals(this.f102193c, memoryFile.f102193c);
            }

            public int hashCode() {
                return (((a().hashCode() * 31) + Long.hashCode(b())) * 31) + Arrays.hashCode(this.f102193c);
            }

            public String toString() {
                return "MemoryFile(name=" + this.f102191a + ", size=" + this.f102192b + ", bytes=" + Arrays.toString(this.f102193c) + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class TemporaryFile extends FreshdeskAttachment {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f102194a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f102195b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final File f102196c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TemporaryFile(String name, long j3, File file) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(file, "file");
                this.f102194a = name;
                this.f102195b = j3;
                this.f102196c = file;
            }

            @Override // cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState.FreshdeskAttachment
            public String a() {
                return this.f102194a;
            }

            @Override // cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState.FreshdeskAttachment
            public long b() {
                return this.f102195b;
            }

            public final File c() {
                return this.f102196c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof TemporaryFile)) {
                    return false;
                }
                TemporaryFile temporaryFile = (TemporaryFile) obj;
                return Intrinsics.areEqual(this.f102194a, temporaryFile.f102194a) && this.f102195b == temporaryFile.f102195b && Intrinsics.areEqual(this.f102196c, temporaryFile.f102196c);
            }

            public int hashCode() {
                return (((this.f102194a.hashCode() * 31) + Long.hashCode(this.f102195b)) * 31) + this.f102196c.hashCode();
            }

            public String toString() {
                return "TemporaryFile(name=" + this.f102194a + ", size=" + this.f102195b + ", file=" + this.f102196c + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class UriFile extends FreshdeskAttachment {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f102197a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f102198b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Uri f102199c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UriFile(String name, long j3, Uri uri) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(uri, "uri");
                this.f102197a = name;
                this.f102198b = j3;
                this.f102199c = uri;
            }

            @Override // cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState.FreshdeskAttachment
            public String a() {
                return this.f102197a;
            }

            @Override // cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState.FreshdeskAttachment
            public long b() {
                return this.f102198b;
            }

            public final Uri c() {
                return this.f102199c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UriFile)) {
                    return false;
                }
                UriFile uriFile = (UriFile) obj;
                return Intrinsics.areEqual(this.f102197a, uriFile.f102197a) && this.f102198b == uriFile.f102198b && Intrinsics.areEqual(this.f102199c, uriFile.f102199c);
            }

            public int hashCode() {
                return (((this.f102197a.hashCode() * 31) + Long.hashCode(this.f102198b)) * 31) + this.f102199c.hashCode();
            }

            public String toString() {
                return "UriFile(name=" + this.f102197a + ", size=" + this.f102198b + ", uri=" + this.f102199c + ")";
            }
        }

        public /* synthetic */ FreshdeskAttachment(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract String a();

        public abstract long b();

        private FreshdeskAttachment() {
        }
    }

    public FeedbackViewState(String message, String emailText, String confirmEmailText, ImmutableList attachments, ContactReason contactReason, boolean z2, boolean z3, int i3, Set validationErrors, List list, boolean z4, boolean z5, boolean z6, boolean z7) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(emailText, "emailText");
        Intrinsics.checkNotNullParameter(confirmEmailText, "confirmEmailText");
        Intrinsics.checkNotNullParameter(attachments, "attachments");
        Intrinsics.checkNotNullParameter(validationErrors, "validationErrors");
        this.f102177a = message;
        this.f102178b = emailText;
        this.f102179c = confirmEmailText;
        this.f102180d = attachments;
        this.f102181f = contactReason;
        this.f102182g = z2;
        this.f102183h = z3;
        this.f102184i = i3;
        this.f102185j = validationErrors;
        this.f102186k = list;
        this.f102187l = z4;
        this.f102188m = z5;
        this.f102189n = z6;
        this.f102190o = z7;
    }

    public final FeedbackViewState a(String message, String emailText, String confirmEmailText, ImmutableList attachments, ContactReason contactReason, boolean z2, boolean z3, int i3, Set validationErrors, List list, boolean z4, boolean z5, boolean z6, boolean z7) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(emailText, "emailText");
        Intrinsics.checkNotNullParameter(confirmEmailText, "confirmEmailText");
        Intrinsics.checkNotNullParameter(attachments, "attachments");
        Intrinsics.checkNotNullParameter(validationErrors, "validationErrors");
        return new FeedbackViewState(message, emailText, confirmEmailText, attachments, contactReason, z2, z3, i3, validationErrors, list, z4, z5, z6, z7);
    }

    public final boolean c() {
        return this.f102187l;
    }

    public final ImmutableList d() {
        return this.f102180d;
    }

    public final String e() {
        return this.f102179c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedbackViewState)) {
            return false;
        }
        FeedbackViewState feedbackViewState = (FeedbackViewState) obj;
        return Intrinsics.areEqual(this.f102177a, feedbackViewState.f102177a) && Intrinsics.areEqual(this.f102178b, feedbackViewState.f102178b) && Intrinsics.areEqual(this.f102179c, feedbackViewState.f102179c) && Intrinsics.areEqual(this.f102180d, feedbackViewState.f102180d) && this.f102181f == feedbackViewState.f102181f && this.f102182g == feedbackViewState.f102182g && this.f102183h == feedbackViewState.f102183h && this.f102184i == feedbackViewState.f102184i && Intrinsics.areEqual(this.f102185j, feedbackViewState.f102185j) && Intrinsics.areEqual(this.f102186k, feedbackViewState.f102186k) && this.f102187l == feedbackViewState.f102187l && this.f102188m == feedbackViewState.f102188m && this.f102189n == feedbackViewState.f102189n && this.f102190o == feedbackViewState.f102190o;
    }

    public final String f() {
        return this.f102178b;
    }

    public final boolean g() {
        return this.f102182g;
    }

    public final boolean h() {
        return this.f102188m;
    }

    public int hashCode() {
        int iHashCode = ((((((this.f102177a.hashCode() * 31) + this.f102178b.hashCode()) * 31) + this.f102179c.hashCode()) * 31) + this.f102180d.hashCode()) * 31;
        ContactReason contactReason = this.f102181f;
        int iHashCode2 = (((((((((iHashCode + (contactReason == null ? 0 : contactReason.hashCode())) * 31) + Boolean.hashCode(this.f102182g)) * 31) + Boolean.hashCode(this.f102183h)) * 31) + Integer.hashCode(this.f102184i)) * 31) + this.f102185j.hashCode()) * 31;
        List list = this.f102186k;
        return ((((((((iHashCode2 + (list != null ? list.hashCode() : 0)) * 31) + Boolean.hashCode(this.f102187l)) * 31) + Boolean.hashCode(this.f102188m)) * 31) + Boolean.hashCode(this.f102189n)) * 31) + Boolean.hashCode(this.f102190o);
    }

    public final String i() {
        return this.f102177a;
    }

    public final ContactReason j() {
        return this.f102181f;
    }

    public final boolean k() {
        return this.f102183h;
    }

    public final List l() {
        return this.f102186k;
    }

    public final boolean m() {
        return this.f102189n;
    }

    public final Set n() {
        return this.f102185j;
    }

    public final int o() {
        return this.f102184i;
    }

    public final boolean p() {
        return this.f102190o;
    }

    public String toString() {
        return "FeedbackViewState(message=" + this.f102177a + ", emailText=" + this.f102178b + ", confirmEmailText=" + this.f102179c + ", attachments=" + this.f102180d + ", selectedContactReason=" + this.f102181f + ", finishedSuccessfully=" + this.f102182g + ", showLoading=" + this.f102183h + ", videoConversionProgress=" + this.f102184i + ", validationErrors=" + this.f102185j + ", topQuestions=" + this.f102186k + ", askForEmail=" + this.f102187l + ", hideEmergencyUnblock=" + this.f102188m + ", useNewEmergencyUnblocking=" + this.f102189n + ", isChatbotEnabled=" + this.f102190o + ")";
    }

    public /* synthetic */ FeedbackViewState(String str, String str2, String str3, ImmutableList immutableList, ContactReason contactReason, boolean z2, boolean z3, int i3, Set set, List list, boolean z4, boolean z5, boolean z6, boolean z7, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) == 0 ? str3 : "", (i4 & 8) != 0 ? ExtensionsKt.a() : immutableList, (i4 & 16) != 0 ? null : contactReason, (i4 & 32) != 0 ? false : z2, (i4 & 64) != 0 ? false : z3, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 0 : i3, (i4 & Function.MAX_NARGS) != 0 ? SetsKt.emptySet() : set, (i4 & 512) != 0 ? CollectionsKt.emptyList() : list, (i4 & 1024) != 0 ? false : z4, (i4 & 2048) != 0 ? false : z5, (i4 & 4096) != 0 ? false : z6, (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? false : z7);
    }
}
