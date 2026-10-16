package androidx.media3.extractor.metadata.scte35;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TimeSignalCommand extends SpliceCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f46540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f46541b;

    private TimeSignalCommand(long j3, long j4) {
        this.f46540a = j3;
        this.f46541b = j4;
    }

    static TimeSignalCommand d(ParsableByteArray parsableByteArray, long j3, TimestampAdjuster timestampAdjuster) {
        long jE = e(parsableByteArray, j3);
        return new TimeSignalCommand(jE, timestampAdjuster.b(jE));
    }

    static long e(ParsableByteArray parsableByteArray, long j3) {
        long jH = parsableByteArray.H();
        if ((128 & jH) != 0) {
            return 8589934591L & ((((jH & 1) << 32) | parsableByteArray.J()) + j3);
        }
        return -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.metadata.scte35.SpliceCommand
    public String toString() {
        return "SCTE-35 TimeSignalCommand { ptsTime=" + this.f46540a + ", playbackPositionUs= " + this.f46541b + " }";
    }
}
