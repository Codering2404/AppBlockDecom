package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class COSEAlgorithmIdentifier implements Parcelable {
    public static final Parcelable.Creator<COSEAlgorithmIdentifier> CREATOR = new zzp();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Algorithm f72501a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class UnsupportedAlgorithmIdentifierException extends Exception {
        public UnsupportedAlgorithmIdentifierException(int i3) {
            super("Algorithm with COSE value " + i3 + " not supported");
        }
    }

    COSEAlgorithmIdentifier(Algorithm algorithm) {
        this.f72501a = (Algorithm) Preconditions.m(algorithm);
    }

    public static COSEAlgorithmIdentifier a(int i3) throws UnsupportedAlgorithmIdentifierException {
        Algorithm algorithm;
        if (i3 == RSAAlgorithm.LEGACY_RS1.a()) {
            algorithm = RSAAlgorithm.RS1;
        } else {
            RSAAlgorithm[] rSAAlgorithmArrValues = RSAAlgorithm.values();
            int length = rSAAlgorithmArrValues.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    for (EC2Algorithm eC2Algorithm : EC2Algorithm.values()) {
                        if (eC2Algorithm.a() == i3) {
                            algorithm = eC2Algorithm;
                        }
                    }
                    throw new UnsupportedAlgorithmIdentifierException(i3);
                }
                RSAAlgorithm rSAAlgorithm = rSAAlgorithmArrValues[i4];
                if (rSAAlgorithm.a() == i3) {
                    algorithm = rSAAlgorithm;
                    break;
                }
                i4++;
            }
        }
        return new COSEAlgorithmIdentifier(algorithm);
    }

    public int c() {
        return this.f72501a.a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof COSEAlgorithmIdentifier) && this.f72501a.a() == ((COSEAlgorithmIdentifier) obj).f72501a.a();
    }

    public int hashCode() {
        return Objects.c(this.f72501a);
    }

    public final String toString() {
        return "COSEAlgorithmIdentifier{algorithm=" + String.valueOf(this.f72501a) + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f72501a.a());
    }
}
