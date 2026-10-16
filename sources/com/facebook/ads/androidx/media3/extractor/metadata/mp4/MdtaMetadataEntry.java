package com.facebook.ads.androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.redexgen.core.C2208qI;
import com.facebook.ads.redexgen.core.C3E;
import com.facebook.ads.redexgen.core.C5C;
import com.facebook.ads.redexgen.core.IM;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class MdtaMetadataEntry implements Metadata.Entry {
    public static byte[] A04;
    public static String[] A05 = {"vi1I9CRdusR9OaQ73IhU0VuYAQE3JPGL", "aaPaOTNU2UwB2EPxZU6V6pdLQfW3q2ZN", "cNMGidnwzPmYHHMcqjEgA9zyn89XSS4i", "P", "P9rZmlchwJyRaPgTXoQm1OTIZlc4jW3D", "Srm5cyc3D2Bvnp8lTnaaETMhNrvRWpkC", "soHBe5cubenrEdU4cSgBG01poHSX3ae1", "VauPfgPsA5JB7q1Lz1RQs26dxgaS0pLj"};
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR;
    public final int A00;
    public final int A01;
    public final String A02;
    public final byte[] A03;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{7, -2, Ascii.SO, -5, -44, -70, 5, -1, 19, -41};
    }

    @Override // com.facebook.ads.androidx.media3.common.Metadata.Entry
    public final /* synthetic */ byte[] A9a() {
        return C3E.A01(this);
    }

    @Override // com.facebook.ads.androidx.media3.common.Metadata.Entry
    public final /* synthetic */ C2208qI A9b() {
        return C3E.A00(this);
    }

    static {
        A01();
        CREATOR = new IM();
    }

    public MdtaMetadataEntry(Parcel parcel) {
        this.A02 = (String) C5C.A0f(parcel.readString());
        this.A03 = (byte[]) C5C.A0f(parcel.createByteArray());
        this.A00 = parcel.readInt();
        this.A01 = parcel.readInt();
    }

    public /* synthetic */ MdtaMetadataEntry(Parcel parcel, IM im) {
        this(parcel);
    }

    public MdtaMetadataEntry(String str, byte[] bArr, int i3, int i4) {
        this.A02 = str;
        this.A03 = bArr;
        this.A00 = i3;
        this.A01 = i4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        boolean zEquals = this.A02.equals(mdtaMetadataEntry.A02);
        String[] strArr = A05;
        if (strArr[0].charAt(3) == strArr[7].charAt(3)) {
            throw new RuntimeException();
        }
        A05[4] = "ER0xmSd6UN1zW0bdX1OFC0qdco0m4mUZ";
        if (zEquals && Arrays.equals(this.A03, mdtaMetadataEntry.A03)) {
            int i3 = this.A00;
            int i4 = mdtaMetadataEntry.A00;
            String[] strArr2 = A05;
            if (strArr2[5].charAt(6) == strArr2[2].charAt(6)) {
                throw new RuntimeException();
            }
            A05[1] = "F56Xno7FqUwIc5sxnGwPweIkgWLWP8mz";
            if (i3 == i4 && this.A01 == mdtaMetadataEntry.A01) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A02.hashCode();
        int result2 = ((((17 * 31) + result) * 31) + Arrays.hashCode(this.A03)) * 31;
        int result3 = this.A00;
        return ((result2 + result3) * 31) + this.A01;
    }

    public final String toString() {
        return A00(0, 10, 99) + this.A02;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.A02);
        parcel.writeByteArray(this.A03);
        parcel.writeInt(this.A00);
        parcel.writeInt(this.A01);
    }
}
