package androidx.media3.extractor.mp4;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.metadata.mp4.SlowMotionData;
import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SefReader {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Splitter f46810d = Splitter.f(':');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Splitter f46811e = Splitter.f('*');

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f46812a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f46813b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f46814c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DataReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f46815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f46816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f46817c;

        public DataReference(int i3, long j3, int i4) {
            this.f46815a = i3;
            this.f46816b = j3;
            this.f46817c = i4;
        }
    }

    private void a(ExtractorInput extractorInput, PositionHolder positionHolder) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        extractorInput.readFully(parsableByteArray.e(), 0, 8);
        this.f46814c = parsableByteArray.u() + 8;
        if (parsableByteArray.q() != 1397048916) {
            positionHolder.f46210a = 0L;
        } else {
            positionHolder.f46210a = extractorInput.getPosition() - ((long) (this.f46814c - 12));
            this.f46813b = 2;
        }
    }

    private static int b(String str) throws ParserException {
        str.getClass();
        switch (str) {
            case "SlowMotion_Data":
                return 2192;
            case "Super_SlowMotion_Edit_Data":
                return 2819;
            case "Super_SlowMotion_Data":
                return 2816;
            case "Super_SlowMotion_Deflickering_On":
                return 2820;
            case "Super_SlowMotion_BGM":
                return 2817;
            default:
                throw ParserException.a("Invalid SEF name", null);
        }
    }

    private void d(ExtractorInput extractorInput, PositionHolder positionHolder) {
        long length = extractorInput.getLength();
        int i3 = this.f46814c - 20;
        ParsableByteArray parsableByteArray = new ParsableByteArray(i3);
        extractorInput.readFully(parsableByteArray.e(), 0, i3);
        for (int i4 = 0; i4 < i3 / 12; i4++) {
            parsableByteArray.X(2);
            short sW = parsableByteArray.w();
            if (sW == 2192 || sW == 2816 || sW == 2817 || sW == 2819 || sW == 2820) {
                this.f46812a.add(new DataReference(sW, (length - ((long) this.f46814c)) - ((long) parsableByteArray.u()), parsableByteArray.u()));
            } else {
                parsableByteArray.X(8);
            }
        }
        if (this.f46812a.isEmpty()) {
            positionHolder.f46210a = 0L;
        } else {
            this.f46813b = 3;
            positionHolder.f46210a = ((DataReference) this.f46812a.get(0)).f46816b;
        }
    }

    private void e(ExtractorInput extractorInput, List list) throws ParserException {
        long position = extractorInput.getPosition();
        int length = (int) ((extractorInput.getLength() - extractorInput.getPosition()) - ((long) this.f46814c));
        ParsableByteArray parsableByteArray = new ParsableByteArray(length);
        extractorInput.readFully(parsableByteArray.e(), 0, length);
        for (int i3 = 0; i3 < this.f46812a.size(); i3++) {
            DataReference dataReference = (DataReference) this.f46812a.get(i3);
            parsableByteArray.W((int) (dataReference.f46816b - position));
            parsableByteArray.X(4);
            int iU = parsableByteArray.u();
            int iB = b(parsableByteArray.E(iU));
            int i4 = dataReference.f46817c - (iU + 8);
            if (iB == 2192) {
                list.add(f(parsableByteArray, i4));
            } else if (iB != 2816 && iB != 2817 && iB != 2819 && iB != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    private static SlowMotionData f(ParsableByteArray parsableByteArray, int i3) throws ParserException {
        ArrayList arrayList = new ArrayList();
        List listL = f46811e.l(parsableByteArray.E(i3));
        for (int i4 = 0; i4 < listL.size(); i4++) {
            List listL2 = f46810d.l((CharSequence) listL.get(i4));
            if (listL2.size() != 3) {
                throw ParserException.a(null, null);
            }
            try {
                arrayList.add(new SlowMotionData.Segment(Long.parseLong((String) listL2.get(0)), Long.parseLong((String) listL2.get(1)), 1 << (Integer.parseInt((String) listL2.get(2)) - 1)));
            } catch (NumberFormatException e3) {
                throw ParserException.a(null, e3);
            }
        }
        return new SlowMotionData(arrayList);
    }

    public int c(ExtractorInput extractorInput, PositionHolder positionHolder, List list) throws ParserException {
        int i3 = this.f46813b;
        long j3 = 0;
        if (i3 == 0) {
            long length = extractorInput.getLength();
            if (length != -1 && length >= 8) {
                j3 = length - 8;
            }
            positionHolder.f46210a = j3;
            this.f46813b = 1;
        } else if (i3 == 1) {
            a(extractorInput, positionHolder);
        } else if (i3 == 2) {
            d(extractorInput, positionHolder);
        } else {
            if (i3 != 3) {
                throw new IllegalStateException();
            }
            e(extractorInput, list);
            positionHolder.f46210a = 0L;
        }
        return 1;
    }

    public void g() {
        this.f46812a.clear();
        this.f46813b = 0;
    }
}
