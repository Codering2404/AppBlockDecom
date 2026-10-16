package androidx.media3.extractor.metadata.scte35;

import androidx.media3.common.util.ParsableByteArray;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SpliceScheduleCommand extends SpliceCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f46526a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ComponentSplice {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f46527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f46528b;

        private ComponentSplice(int i3, long j3) {
            this.f46527a = i3;
            this.f46528b = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Event {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f46529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f46530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f46531c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f46532d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f46533e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List f46534f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f46535g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f46536h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f46537i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f46538j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f46539k;

        private Event(long j3, boolean z2, boolean z3, boolean z4, List list, long j4, boolean z5, long j5, int i3, int i4, int i5) {
            this.f46529a = j3;
            this.f46530b = z2;
            this.f46531c = z3;
            this.f46532d = z4;
            this.f46534f = Collections.unmodifiableList(list);
            this.f46533e = j4;
            this.f46535g = z5;
            this.f46536h = j5;
            this.f46537i = i3;
            this.f46538j = i4;
            this.f46539k = i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Event b(ParsableByteArray parsableByteArray) {
            boolean z2;
            ArrayList arrayList;
            boolean z3;
            boolean z4;
            long j3;
            boolean z5;
            long j4;
            int i3;
            int i4;
            int iH;
            boolean z6;
            long J;
            long J2 = parsableByteArray.J();
            boolean z7 = true;
            if ((parsableByteArray.H() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                z2 = true;
            } else {
                z2 = true;
                z7 = false;
            }
            ArrayList arrayList2 = new ArrayList();
            if (z7) {
                arrayList = arrayList2;
                z3 = false;
                z4 = false;
                j3 = -9223372036854775807L;
                z5 = false;
                j4 = -9223372036854775807L;
                i3 = 0;
                i4 = 0;
                iH = 0;
            } else {
                int iH2 = parsableByteArray.H();
                boolean z8 = (iH2 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? z2 : false;
                boolean z9 = (iH2 & 64) != 0 ? z2 : false;
                boolean z10 = (iH2 & 32) != 0 ? z2 : false;
                long J3 = z9 ? parsableByteArray.J() : -9223372036854775807L;
                if (!z9) {
                    int iH3 = parsableByteArray.H();
                    ArrayList arrayList3 = new ArrayList(iH3);
                    int i5 = 0;
                    while (i5 < iH3) {
                        arrayList3.add(new ComponentSplice(parsableByteArray.H(), parsableByteArray.J()));
                        i5++;
                        iH3 = iH3;
                    }
                    arrayList2 = arrayList3;
                }
                if (z10) {
                    long jH = parsableByteArray.H();
                    boolean z11 = (128 & jH) != 0;
                    J = ((((jH & 1) << 32) | parsableByteArray.J()) * 1000) / 90;
                    z6 = z11;
                } else {
                    z6 = false;
                    J = -9223372036854775807L;
                }
                int iP = parsableByteArray.P();
                int iH4 = parsableByteArray.H();
                boolean z12 = z8;
                z5 = z6;
                z3 = z12;
                iH = parsableByteArray.H();
                long j5 = J3;
                i3 = iP;
                i4 = iH4;
                long j6 = J;
                arrayList = arrayList2;
                z4 = z9;
                j3 = j5;
                j4 = j6;
            }
            return new Event(J2, z7, z3, z4, arrayList, j3, z5, j4, i3, i4, iH);
        }
    }

    private SpliceScheduleCommand(List list) {
        this.f46526a = Collections.unmodifiableList(list);
    }

    static SpliceScheduleCommand d(ParsableByteArray parsableByteArray) {
        int iH = parsableByteArray.H();
        ArrayList arrayList = new ArrayList(iH);
        for (int i3 = 0; i3 < iH; i3++) {
            arrayList.add(Event.b(parsableByteArray));
        }
        return new SpliceScheduleCommand(arrayList);
    }
}
