package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fido.fido2.api.common.Attachment;
import com.google.android.gms.fido.fido2.api.common.ResidentKeyRequirement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AuthenticatorSelectionCriteria extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthenticatorSelectionCriteria> CREATOR = new zzm();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Attachment f72488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Boolean f72489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final UserVerificationRequirement f72490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ResidentKeyRequirement f72491d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Attachment f72492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Boolean f72493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ResidentKeyRequirement f72494c;

        public AuthenticatorSelectionCriteria a() {
            Attachment attachment = this.f72492a;
            String string = attachment == null ? null : attachment.toString();
            Boolean bool = this.f72493b;
            ResidentKeyRequirement residentKeyRequirement = this.f72494c;
            return new AuthenticatorSelectionCriteria(string, bool, null, residentKeyRequirement == null ? null : residentKeyRequirement.toString());
        }

        public Builder b(Attachment attachment) {
            this.f72492a = attachment;
            return this;
        }

        public Builder c(Boolean bool) {
            this.f72493b = bool;
            return this;
        }

        public Builder d(ResidentKeyRequirement residentKeyRequirement) {
            this.f72494c = residentKeyRequirement;
            return this;
        }
    }

    AuthenticatorSelectionCriteria(String str, Boolean bool, String str2, String str3) {
        Attachment attachmentA;
        ResidentKeyRequirement residentKeyRequirementA = null;
        if (str == null) {
            attachmentA = null;
        } else {
            try {
                attachmentA = Attachment.a(str);
            } catch (Attachment.UnsupportedAttachmentException | ResidentKeyRequirement.UnsupportedResidentKeyRequirementException | zzbc e3) {
                throw new IllegalArgumentException(e3);
            }
        }
        this.f72488a = attachmentA;
        this.f72489b = bool;
        this.f72490c = str2 == null ? null : UserVerificationRequirement.a(str2);
        if (str3 != null) {
            residentKeyRequirementA = ResidentKeyRequirement.a(str3);
        }
        this.f72491d = residentKeyRequirementA;
    }

    public String M() {
        Attachment attachment = this.f72488a;
        if (attachment == null) {
            return null;
        }
        return attachment.toString();
    }

    public Boolean N() {
        return this.f72489b;
    }

    public ResidentKeyRequirement O() {
        ResidentKeyRequirement residentKeyRequirement = this.f72491d;
        if (residentKeyRequirement != null) {
            return residentKeyRequirement;
        }
        Boolean bool = this.f72489b;
        if (bool == null || !bool.booleanValue()) {
            return null;
        }
        return ResidentKeyRequirement.RESIDENT_KEY_REQUIRED;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthenticatorSelectionCriteria)) {
            return false;
        }
        AuthenticatorSelectionCriteria authenticatorSelectionCriteria = (AuthenticatorSelectionCriteria) obj;
        return Objects.b(this.f72488a, authenticatorSelectionCriteria.f72488a) && Objects.b(this.f72489b, authenticatorSelectionCriteria.f72489b) && Objects.b(this.f72490c, authenticatorSelectionCriteria.f72490c) && Objects.b(O(), authenticatorSelectionCriteria.O());
    }

    public String g0() {
        ResidentKeyRequirement residentKeyRequirementO = O();
        if (residentKeyRequirementO == null) {
            return null;
        }
        return residentKeyRequirementO.toString();
    }

    public int hashCode() {
        return Objects.c(this.f72488a, this.f72489b, this.f72490c, O());
    }

    public final String toString() {
        ResidentKeyRequirement residentKeyRequirement = this.f72491d;
        UserVerificationRequirement userVerificationRequirement = this.f72490c;
        return "AuthenticatorSelectionCriteria{\n attachment=" + String.valueOf(this.f72488a) + ", \n requireResidentKey=" + this.f72489b + ", \n requireUserVerification=" + String.valueOf(userVerificationRequirement) + ", \n residentKeyRequirement=" + String.valueOf(residentKeyRequirement) + "\n }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, M(), false);
        SafeParcelWriter.i(parcel, 3, N(), false);
        UserVerificationRequirement userVerificationRequirement = this.f72490c;
        SafeParcelWriter.G(parcel, 4, userVerificationRequirement == null ? null : userVerificationRequirement.toString(), false);
        SafeParcelWriter.G(parcel, 5, g0(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
