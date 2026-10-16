package cz.mobilesoft.coreblock.util;

import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.rest.response.ErrorBody;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class FailedWithError extends ViewModelState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Throwable f127869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f127870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ErrorBody f127871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f127872d;

    public FailedWithError(Throwable th, Integer num, ErrorBody errorBody, String str) {
        super(null);
        this.f127869a = th;
        this.f127870b = num;
        this.f127871c = errorBody;
        this.f127872d = str;
    }

    public final Throwable a() {
        return this.f127869a;
    }

    public final ErrorBody b() {
        return this.f127871c;
    }

    public final String c() {
        return this.f127872d;
    }

    public final String d() {
        ErrorBody errorBody = this.f127871c;
        Integer numValueOf = errorBody != null ? Integer.valueOf(errorBody.getCode()) : null;
        if (numValueOf != null && numValueOf.intValue() == 112) {
            String string = LockieApplication.g().getString(R.string.Ed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (numValueOf != null && numValueOf.intValue() == 110) {
            String string2 = LockieApplication.g().getString(R.string.Dd);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (numValueOf != null && numValueOf.intValue() == 1000) {
            String string3 = LockieApplication.g().getString(R.string.R7);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        if (numValueOf != null && numValueOf.intValue() == 1001) {
            String string4 = LockieApplication.g().getString(R.string.S7);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }
        if (numValueOf != null && numValueOf.intValue() == 1002) {
            String string5 = LockieApplication.g().getString(R.string.T7);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return string5;
        }
        if (numValueOf != null && numValueOf.intValue() == 102) {
            String string6 = LockieApplication.g().getString(R.string.yg);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            return string6;
        }
        String message = this.f127872d;
        if (message == null) {
            ErrorBody errorBody2 = this.f127871c;
            message = errorBody2 != null ? errorBody2.getMessage() : null;
            if (message == null) {
                Throwable th = this.f127869a;
                String message2 = th != null ? th.getMessage() : null;
                if (message2 != null) {
                    return message2;
                }
                String string7 = LockieApplication.g().getString(R.string.Vz);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                return string7;
            }
        }
        return message;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FailedWithError)) {
            return false;
        }
        FailedWithError failedWithError = (FailedWithError) obj;
        return Intrinsics.areEqual(this.f127869a, failedWithError.f127869a) && Intrinsics.areEqual(this.f127870b, failedWithError.f127870b) && Intrinsics.areEqual(this.f127871c, failedWithError.f127871c) && Intrinsics.areEqual(this.f127872d, failedWithError.f127872d);
    }

    public int hashCode() {
        Throwable th = this.f127869a;
        int iHashCode = (th == null ? 0 : th.hashCode()) * 31;
        Integer num = this.f127870b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        ErrorBody errorBody = this.f127871c;
        int iHashCode3 = (iHashCode2 + (errorBody == null ? 0 : errorBody.hashCode())) * 31;
        String str = this.f127872d;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "FailedWithError(error=" + this.f127869a + ", code=" + this.f127870b + YgVrd.YJzUYiNsQM + this.f127871c + ", errorStringCustom=" + this.f127872d + ")";
    }

    public /* synthetic */ FailedWithError(Throwable th, Integer num, ErrorBody errorBody, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : th, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : errorBody, (i3 & 8) != 0 ? null : str);
    }
}
