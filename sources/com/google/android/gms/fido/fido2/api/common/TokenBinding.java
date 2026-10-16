package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzbk;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TokenBinding extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TokenBinding> CREATOR = new zzaz();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TokenBinding f72620c = new TokenBinding(TokenBindingStatus.SUPPORTED.toString(), null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TokenBinding f72621d = new TokenBinding(TokenBindingStatus.NOT_SUPPORTED.toString(), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TokenBindingStatus f72622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72623b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum TokenBindingStatus implements Parcelable {
        PRESENT("present"),
        SUPPORTED("supported"),
        NOT_SUPPORTED("not-supported");

        public static final Parcelable.Creator<TokenBindingStatus> CREATOR = new zzay();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f72628a;

        TokenBindingStatus(String str) {
            this.f72628a = str;
        }

        public static TokenBindingStatus a(String str) throws UnsupportedTokenBindingStatusException {
            for (TokenBindingStatus tokenBindingStatus : values()) {
                if (str.equals(tokenBindingStatus.f72628a)) {
                    return tokenBindingStatus;
                }
            }
            throw new UnsupportedTokenBindingStatusException(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f72628a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f72628a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class UnsupportedTokenBindingStatusException extends Exception {
        public UnsupportedTokenBindingStatusException(String str) {
            super(String.format("TokenBindingStatus %s not supported", str));
        }
    }

    TokenBinding(String str, String str2) {
        Preconditions.m(str);
        try {
            this.f72622a = TokenBindingStatus.a(str);
            this.f72623b = str2;
        } catch (UnsupportedTokenBindingStatusException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public String M() {
        return this.f72623b;
    }

    public String N() {
        return this.f72622a.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenBinding)) {
            return false;
        }
        TokenBinding tokenBinding = (TokenBinding) obj;
        return zzbk.zza(this.f72622a, tokenBinding.f72622a) && zzbk.zza(this.f72623b, tokenBinding.f72623b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f72622a, this.f72623b});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, N(), false);
        SafeParcelWriter.G(parcel, 3, M(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
