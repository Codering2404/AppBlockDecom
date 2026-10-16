package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public enum ErrorCode implements Parcelable {
    OK(0),
    OTHER_ERROR(1),
    BAD_REQUEST(2),
    CONFIGURATION_UNSUPPORTED(3),
    DEVICE_INELIGIBLE(4),
    TIMEOUT(5);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72725a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f72723i = ErrorCode.class.getSimpleName();
    public static final Parcelable.Creator<ErrorCode> CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.fido.u2f.api.common.zzc
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return ErrorCode.d(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i3) {
            return new ErrorCode[i3];
        }
    };

    ErrorCode(int i3) {
        this.f72725a = i3;
    }

    public static ErrorCode d(int i3) {
        for (ErrorCode errorCode : values()) {
            if (i3 == errorCode.f72725a) {
                return errorCode;
            }
        }
        return OTHER_ERROR;
    }

    public int c() {
        return this.f72725a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f72725a);
    }
}
