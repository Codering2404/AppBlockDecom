package com.facebook.ads.androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.core.AnonymousClass53;
import com.facebook.ads.redexgen.core.C04554v;
import com.facebook.ads.redexgen.core.C0780Ic;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static String[] A02 = {"fBCCr7VwDgvhDxdGkzRiY2TvWvmZmARS", "lBD0fDkRFVdGPYWDbMcaGx4cyXv4WEJh", "6y4HJXgmtxqVkaNMzYZBmSXA6CGxm4DJ", "vpsLDrGqE5zherZQZMMLL6G3cLRsG8Dm", "qp0fDGr3Nzl8ahCuvet6k2311zos", "c5cBfT4Hj52dvZvyRqGaKhWxL68ft04u", "OtVyWYxYdMxR9geYu5t1Sc80NPuk", "8DkmlbSWSEaEI0nee1I51BPAFd"};
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new C0780Ic();
    public final long A00;
    public final long A01;

    public TimeSignalCommand(long j3, long j4) {
        this.A01 = j3;
        this.A00 = j4;
    }

    public /* synthetic */ TimeSignalCommand(long j3, long j4, C0780Ic c0780Ic) {
        this(j3, j4);
    }

    public static long A00(C04554v c04554v, long j3) {
        long jA0I = c04554v.A0I();
        if ((128 & jA0I) == 0) {
            return -9223372036854775807L;
        }
        long firstByte = c04554v.A0Q();
        long j4 = (((1 & jA0I) << 32) | firstByte) + j3;
        if (A02[7].length() == 21) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[5] = "5vtaLYhnTEc2lUg08l0YEv2QqnnKhzp8";
        strArr[0] = "gGhCeZV4kOFdoFbuN1d60dh6MMvStMtQ";
        return j4 & 8589934591L;
    }

    public static TimeSignalCommand A01(C04554v c04554v, long j3, AnonymousClass53 anonymousClass53) {
        long jA00 = A00(c04554v, j3);
        return new TimeSignalCommand(jA00, anonymousClass53.A06(jA00));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.A01);
        parcel.writeLong(this.A00);
    }
}
