package androidx.media3.extractor.metadata.scte35;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SpliceInsertCommand extends SpliceCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f46510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f46511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f46512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f46513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f46514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f46515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f46516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f46517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f46518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f46519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f46520k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f46521l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f46522m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ComponentSplice {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f46523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f46524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f46525c;

        private ComponentSplice(int i3, long j3, long j4) {
            this.f46523a = i3;
            this.f46524b = j3;
            this.f46525c = j4;
        }
    }

    private SpliceInsertCommand(long j3, boolean z2, boolean z3, boolean z4, boolean z5, long j4, long j5, List list, boolean z6, long j6, int i3, int i4, int i5) {
        this.f46510a = j3;
        this.f46511b = z2;
        this.f46512c = z3;
        this.f46513d = z4;
        this.f46514e = z5;
        this.f46515f = j4;
        this.f46516g = j5;
        this.f46517h = Collections.unmodifiableList(list);
        this.f46518i = z6;
        this.f46519j = j6;
        this.f46520k = i3;
        this.f46521l = i4;
        this.f46522m = i5;
    }

    static SpliceInsertCommand d(ParsableByteArray parsableByteArray, long j3, TimestampAdjuster timestampAdjuster) {
        List list;
        long j4;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        int iH;
        int iH2;
        boolean z6;
        int i4;
        long jE;
        long J = parsableByteArray.J();
        boolean z7 = (parsableByteArray.H() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
        List list2 = Collections.EMPTY_LIST;
        long J2 = -9223372036854775807L;
        if (z7) {
            list = list2;
            j4 = -9223372036854775807L;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            i3 = 0;
            iH = 0;
            iH2 = 0;
        } else {
            int iH3 = parsableByteArray.H();
            boolean z8 = (iH3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
            boolean z9 = (iH3 & 64) != 0;
            boolean z10 = (iH3 & 32) != 0;
            boolean z11 = (iH3 & 16) != 0;
            long jE2 = (!z9 || z11) ? -9223372036854775807L : TimeSignalCommand.e(parsableByteArray, j3);
            if (!z9) {
                int iH4 = parsableByteArray.H();
                ArrayList arrayList = new ArrayList(iH4);
                int i5 = 0;
                while (i5 < iH4) {
                    int iH5 = parsableByteArray.H();
                    if (z11) {
                        i4 = iH4;
                        jE = -9223372036854775807L;
                    } else {
                        i4 = iH4;
                        jE = TimeSignalCommand.e(parsableByteArray, j3);
                    }
                    arrayList.add(new ComponentSplice(iH5, jE, timestampAdjuster.b(jE)));
                    i5++;
                    iH4 = i4;
                }
                list2 = arrayList;
            }
            if (z10) {
                long jH = parsableByteArray.H();
                boolean z12 = (128 & jH) != 0;
                J2 = ((((jH & 1) << 32) | parsableByteArray.J()) * 1000) / 90;
                z6 = z12;
            } else {
                z6 = false;
            }
            int iP = parsableByteArray.P();
            long j5 = jE2;
            j4 = J2;
            J2 = j5;
            iH = parsableByteArray.H();
            iH2 = parsableByteArray.H();
            i3 = iP;
            z5 = z6;
            z2 = z8;
            z3 = z9;
            list = list2;
            z4 = z11;
        }
        return new SpliceInsertCommand(J, z7, z2, z3, z4, J2, timestampAdjuster.b(J2), list, z5, j4, i3, iH, iH2);
    }

    @Override // androidx.media3.extractor.metadata.scte35.SpliceCommand
    public String toString() {
        return "SCTE-35 SpliceInsertCommand { programSplicePts=" + this.f46515f + ", programSplicePlaybackPositionUs= " + this.f46516g + " }";
    }
}
