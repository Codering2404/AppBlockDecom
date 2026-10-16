package com.facebook.ads.internal.androidx.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.core.C0975Pt;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ViewPager$SavedState extends AbsSavedState {
    public static byte[] A03;
    public static final Parcelable.Creator<ViewPager$SavedState> CREATOR;
    public int A00;
    public Parcelable A01;
    public ClassLoader A02;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 126);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{34, 114, 109, 113, 107, 118, 107, 109, 108, 63, 69, 113, 98, 100, 110, 102, 109, 119, 83, 98, 100, 102, 113, Framer.STDIN_FRAME_PREFIX, 80, 98, 117, 102, 103, 80, 119, 98, 119, 102, Framer.EXIT_FRAME_PREFIX, 6};
    }

    static {
        A02();
        CREATOR = new C0975Pt();
    }

    public ViewPager$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
        this.A00 = parcel.readInt();
        this.A01 = parcel.readParcelable(classLoader);
        this.A02 = classLoader;
    }

    public ViewPager$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public final String toString() {
        return A01(10, 25, 125) + Integer.toHexString(System.identityHashCode(this)) + A01(0, 10, 124) + this.A00 + A01(35, 1, 5);
    }

    @Override // com.facebook.ads.internal.androidx.support.v4.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.A00);
        parcel.writeParcelable(this.A01, i3);
    }
}
