package androidx.media3.extractor.text.ssa;

import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import com.google.common.base.Ascii;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SsaDialogueFormat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f47139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f47141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f47142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f47143e;

    private SsaDialogueFormat(int i3, int i4, int i5, int i6, int i7) {
        this.f47139a = i3;
        this.f47140b = i4;
        this.f47141c = i5;
        this.f47142d = i6;
        this.f47143e = i7;
    }

    public static SsaDialogueFormat a(String str) {
        Assertions.a(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        for (int i7 = 0; i7 < strArrSplit.length; i7++) {
            String strE = Ascii.e(strArrSplit[i7].trim());
            strE.getClass();
            switch (strE) {
                case "end":
                    i4 = i7;
                    break;
                case "text":
                    i6 = i7;
                    break;
                case "start":
                    i3 = i7;
                    break;
                case "style":
                    i5 = i7;
                    break;
            }
        }
        if (i3 == -1 || i4 == -1 || i6 == -1) {
            return null;
        }
        return new SsaDialogueFormat(i3, i4, i5, i6, strArrSplit.length);
    }
}
