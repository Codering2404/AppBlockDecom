package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.Attachment;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum Attachment implements Parcelable {
    PLATFORM("platform"),
    CROSS_PLATFORM("cross-platform");

    public static final Parcelable.Creator<Attachment> CREATOR = new Parcelable.Creator() { // from class: com.google.android.gms.fido.fido2.api.common.zza
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            try {
                return Attachment.a(parcel.readString());
            } catch (Attachment.UnsupportedAttachmentException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i3) {
            return new Attachment[i3];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72440a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class UnsupportedAttachmentException extends Exception {
        public UnsupportedAttachmentException(String str) {
            super(String.format("Attachment %s not supported", str));
        }
    }

    Attachment(String str) {
        this.f72440a = str;
    }

    public static Attachment a(String str) throws UnsupportedAttachmentException {
        for (Attachment attachment : values()) {
            if (str.equals(attachment.f72440a)) {
                return attachment;
            }
        }
        throw new UnsupportedAttachmentException(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f72440a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f72440a);
    }
}
