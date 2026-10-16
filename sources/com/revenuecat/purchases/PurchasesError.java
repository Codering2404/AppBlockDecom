package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class PurchasesError implements Parcelable, Serializable {
    private static final long serialVersionUID = 81719171;
    private final PurchasesErrorCode code;
    private final String underlyingErrorMessage;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<PurchasesError> CREATOR = new Creator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<PurchasesError> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PurchasesError createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PurchasesError(PurchasesErrorCode.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PurchasesError[] newArray(int i3) {
            return new PurchasesError[i3];
        }
    }

    public PurchasesError(PurchasesErrorCode code, String str) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.code = code;
        this.underlyingErrorMessage = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(PurchasesError.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.PurchasesError");
        PurchasesError purchasesError = (PurchasesError) obj;
        return this.code == purchasesError.code && Intrinsics.areEqual(this.underlyingErrorMessage, purchasesError.underlyingErrorMessage);
    }

    public final PurchasesErrorCode getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.code.getDescription();
    }

    public final String getUnderlyingErrorMessage() {
        return this.underlyingErrorMessage;
    }

    public int hashCode() {
        int iHashCode = this.code.hashCode() * 31;
        String str = this.underlyingErrorMessage;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "PurchasesError(code=" + this.code + ", underlyingErrorMessage=" + this.underlyingErrorMessage + ", message='" + getMessage() + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.code.name());
        out.writeString(this.underlyingErrorMessage);
    }

    public /* synthetic */ PurchasesError(PurchasesErrorCode purchasesErrorCode, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(purchasesErrorCode, (i3 & 2) != 0 ? null : str);
    }
}
