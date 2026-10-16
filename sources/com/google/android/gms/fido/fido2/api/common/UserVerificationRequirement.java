package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum UserVerificationRequirement implements Parcelable {
    USER_VERIFICATION_REQUIRED("required"),
    USER_VERIFICATION_PREFERRED("preferred"),
    USER_VERIFICATION_DISCOURAGED("discouraged");

    public static final Parcelable.Creator<UserVerificationRequirement> CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.fido.fido2.api.common.zzbb
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return UserVerificationRequirement.a(parcel.readString());
            } catch (zzbc e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i3) {
            return new UserVerificationRequirement[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72634a;

    UserVerificationRequirement(String str) {
        this.f72634a = str;
    }

    public static UserVerificationRequirement a(String str) throws zzbc {
        for (UserVerificationRequirement userVerificationRequirement : values()) {
            if (str.equals(userVerificationRequirement.f72634a)) {
                return userVerificationRequirement;
            }
        }
        throw new zzbc(str);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f72634a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f72634a);
    }
}
