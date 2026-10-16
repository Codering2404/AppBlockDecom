package cz.mobilesoft.coreblock.rest.response;

import com.facebook.internal.AnalyticsEvents;
import com.google.gson.annotations.SerializedName;
import cz.mobilesoft.coreblock.rest.ApiErrorCode;
import java.util.List;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ErrorBody {
    public static final int $stable = 8;

    @SerializedName("code")
    private final int code;

    @SerializedName("errors")
    private final List<String> errors;

    @SerializedName("message")
    private final String message;

    @SerializedName(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)
    private final String status;

    public ErrorBody(@ApiErrorCode int i3, String str, String str2, List<String> list) {
        this.code = i3;
        this.status = str;
        this.message = str2;
        this.errors = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ErrorBody copy$default(ErrorBody errorBody, int i3, String str, String str2, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = errorBody.code;
        }
        if ((i4 & 2) != 0) {
            str = errorBody.status;
        }
        if ((i4 & 4) != 0) {
            str2 = errorBody.message;
        }
        if ((i4 & 8) != 0) {
            list = errorBody.errors;
        }
        return errorBody.copy(i3, str, str2, list);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.message;
    }

    public final List<String> component4() {
        return this.errors;
    }

    public final ErrorBody copy(@ApiErrorCode int i3, String str, String str2, List<String> list) {
        return new ErrorBody(i3, str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorBody)) {
            return false;
        }
        ErrorBody errorBody = (ErrorBody) obj;
        return this.code == errorBody.code && Intrinsics.areEqual(this.status, errorBody.status) && Intrinsics.areEqual(this.message, errorBody.message) && Intrinsics.areEqual(this.errors, errorBody.errors);
    }

    public final int getCode() {
        return this.code;
    }

    public final List<String> getErrors() {
        return this.errors;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getShouldBeLogged() {
        return ApiErrorCode.f98449b.a(this.code);
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        String str = this.status;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.message;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.errors;
        return iHashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ErrorBody(code=" + this.code + ", status=" + this.status + ", message=" + this.message + ", errors=" + this.errors + ")";
    }

    public /* synthetic */ ErrorBody(int i3, String str, String str2, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? null : str2, (i4 & 8) != 0 ? null : list);
    }
}
