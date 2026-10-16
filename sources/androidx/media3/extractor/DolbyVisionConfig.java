package androidx.media3.extractor;

import androidx.media3.common.util.ParsableByteArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DolbyVisionConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f46131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f46132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f46133c;

    private DolbyVisionConfig(int i3, int i4, String str) {
        this.f46131a = i3;
        this.f46132b = i4;
        this.f46133c = str;
    }

    public static DolbyVisionConfig a(ParsableByteArray parsableByteArray) {
        String str;
        parsableByteArray.X(2);
        int iH = parsableByteArray.H();
        int i3 = iH >> 1;
        int iH2 = ((parsableByteArray.H() >> 3) & 31) | ((iH & 1) << 5);
        if (i3 == 4 || i3 == 5 || i3 == 7 || i3 == 8) {
            str = "dvhe";
        } else if (i3 == 9) {
            str = "dvav";
        } else {
            if (i3 != 10) {
                return null;
            }
            str = "dav1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i3 < 10 ? ".0" : ".");
        sb.append(i3);
        sb.append(iH2 < 10 ? ".0" : ".");
        sb.append(iH2);
        return new DolbyVisionConfig(i3, iH2, sb.toString());
    }
}
