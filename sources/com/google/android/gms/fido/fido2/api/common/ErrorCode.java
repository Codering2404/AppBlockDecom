package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.ErrorCode;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum ErrorCode implements Parcelable {
    NOT_SUPPORTED_ERR(9),
    INVALID_STATE_ERR(11),
    SECURITY_ERR(18),
    NETWORK_ERR(19),
    ABORT_ERR(20),
    TIMEOUT_ERR(23),
    ENCODING_ERR(27),
    UNKNOWN_ERR(28),
    CONSTRAINT_ERR(29),
    DATA_ERR(30),
    NOT_ALLOWED_ERR(35),
    ATTESTATION_NOT_PRIVATE_ERR(36);

    public static final Parcelable.Creator<ErrorCode> CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.fido.fido2.api.common.zzw
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return ErrorCode.d(parcel.readInt());
            } catch (ErrorCode.UnsupportedErrorCodeException e3) {
                throw new IllegalArgumentException(e3);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i3) {
            return new ErrorCode[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72524a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class UnsupportedErrorCodeException extends Exception {
        public UnsupportedErrorCodeException(int i3) {
            super(String.format(Locale.US, "Error code %d is not supported", Integer.valueOf(i3)));
        }
    }

    ErrorCode(int i3) {
        this.f72524a = i3;
    }

    public static ErrorCode d(int i3) throws UnsupportedErrorCodeException {
        for (ErrorCode errorCode : values()) {
            if (i3 == errorCode.f72524a) {
                return errorCode;
            }
        }
        throw new UnsupportedErrorCodeException(i3);
    }

    public int c() {
        return this.f72524a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f72524a);
    }
}
