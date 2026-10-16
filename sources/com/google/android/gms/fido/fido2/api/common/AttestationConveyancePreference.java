package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum AttestationConveyancePreference implements Parcelable {
    NONE(IntegrityManager.INTEGRITY_TYPE_NONE),
    INDIRECT("indirect"),
    DIRECT("direct");

    public static final Parcelable.Creator<AttestationConveyancePreference> CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.fido.fido2.api.common.zzb
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return AttestationConveyancePreference.a(parcel.readString());
            } catch (AttestationConveyancePreference.UnsupportedAttestationConveyancePreferenceException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i3) {
            return new AttestationConveyancePreference[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72445a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class UnsupportedAttestationConveyancePreferenceException extends Exception {
        public UnsupportedAttestationConveyancePreferenceException(String str) {
            super(String.format("Attestation conveyance preference %s not supported", str));
        }
    }

    AttestationConveyancePreference(String str) {
        this.f72445a = str;
    }

    public static AttestationConveyancePreference a(String str) throws UnsupportedAttestationConveyancePreferenceException {
        for (AttestationConveyancePreference attestationConveyancePreference : values()) {
            if (str.equals(attestationConveyancePreference.f72445a)) {
                return attestationConveyancePreference;
            }
        }
        throw new UnsupportedAttestationConveyancePreferenceException(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f72445a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f72445a);
    }
}
