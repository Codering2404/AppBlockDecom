package androidx.media3.extractor.metadata.scte35;

import androidx.media3.common.util.ParsableByteArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PrivateCommand extends SpliceCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f46504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f46505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f46506c;

    private PrivateCommand(long j3, byte[] bArr, long j4) {
        this.f46504a = j4;
        this.f46505b = j3;
        this.f46506c = bArr;
    }

    static PrivateCommand d(ParsableByteArray parsableByteArray, int i3, long j3) {
        long J = parsableByteArray.J();
        int i4 = i3 - 4;
        byte[] bArr = new byte[i4];
        parsableByteArray.l(bArr, 0, i4);
        return new PrivateCommand(J, bArr, j3);
    }

    @Override // androidx.media3.extractor.metadata.scte35.SpliceCommand
    public String toString() {
        return "SCTE-35 PrivateCommand { ptsAdjustment=" + this.f46504a + ", identifier= " + this.f46505b + " }";
    }
}
