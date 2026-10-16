package com.facebook.ads.androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.core.C04554v;
import com.facebook.ads.redexgen.core.C0779Ib;
import com.facebook.ads.redexgen.core.IZ;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new IZ();
    public final List<C0779Ib> A00;

    public SpliceScheduleCommand(Parcel parcel) {
        int i3 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add(C0779Ib.A00(parcel));
        }
        this.A00 = Collections.unmodifiableList(arrayList);
    }

    public /* synthetic */ SpliceScheduleCommand(Parcel parcel, IZ iz) {
        this(parcel);
    }

    public SpliceScheduleCommand(List<C0779Ib> list) {
        this.A00 = Collections.unmodifiableList(list);
    }

    public static SpliceScheduleCommand A00(C04554v c04554v) {
        int iA0I = c04554v.A0I();
        ArrayList arrayList = new ArrayList(iA0I);
        for (int i3 = 0; i3 < iA0I; i3++) {
            arrayList.add(C0779Ib.A02(c04554v));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int size = this.A00.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            this.A00.get(i4).A04(parcel);
        }
    }
}
