package com.facebook.ads.redexgen.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.androidx.support.v4.view.AbsSavedState;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class PG implements Parcelable.ClassLoaderCreator<AbsSavedState> {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{Ascii.ETB, Ascii.EM, Ascii.DC4, 9, Ascii.SYN, -9, Ascii.CAN, 5, Ascii.CAN, 9, -60, 17, Ascii.EM, Ascii.ETB, Ascii.CAN, -60, 6, 9, -60, Ascii.DC2, Ascii.EM, Ascii.DLE, Ascii.DLE};
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final AbsSavedState createFromParcel(Parcel parcel) {
        return createFromParcel(parcel, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.ClassLoaderCreator
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        Parcelable superState = parcel.readParcelable(classLoader);
        if (superState == null) {
            return AbsSavedState.A02;
        }
        throw new IllegalStateException(A02(0, 23, 86));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: A04, reason: merged with bridge method [inline-methods] */
    public final AbsSavedState[] newArray(int i3) {
        return new AbsSavedState[i3];
    }
}
