package androidx.media3.extractor.text;

import androidx.media3.common.util.Consumer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class LegacySubtitleUtil {
    private static int a(Subtitle subtitle, long j3) {
        if (j3 == -9223372036854775807L) {
            return 0;
        }
        int iA = subtitle.a(j3);
        if (iA == -1) {
            iA = subtitle.d();
        }
        return (iA <= 0 || subtitle.c(iA + (-1)) != j3) ? iA : iA - 1;
    }

    private static void b(Subtitle subtitle, int i3, Consumer consumer) {
        long jC = subtitle.c(i3);
        List listB = subtitle.b(jC);
        if (listB.isEmpty()) {
            return;
        }
        if (i3 == subtitle.d() - 1) {
            throw new IllegalStateException();
        }
        long jC2 = subtitle.c(i3 + 1) - subtitle.c(i3);
        if (jC2 > 0) {
            consumer.accept(new CuesWithTiming(listB, jC, jC2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(androidx.media3.extractor.text.Subtitle r11, androidx.media3.extractor.text.SubtitleParser.OutputOptions r12, androidx.media3.common.util.Consumer r13) {
        /*
            long r0 = r12.f46961a
            int r0 = a(r11, r0)
            long r1 = r12.f46961a
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L3a
            int r1 = r11.d()
            if (r0 >= r1) goto L3a
            long r3 = r12.f46961a
            java.util.List r6 = r11.b(r3)
            long r3 = r11.c(r0)
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L3a
            long r7 = r12.f46961a
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 >= 0) goto L3a
            androidx.media3.extractor.text.CuesWithTiming r5 = new androidx.media3.extractor.text.CuesWithTiming
            long r9 = r3 - r7
            r5.<init>(r6, r7, r9)
            r13.accept(r5)
            r1 = 1
            goto L3b
        L3a:
            r1 = r2
        L3b:
            r3 = r0
        L3c:
            int r4 = r11.d()
            if (r3 >= r4) goto L48
            b(r11, r3, r13)
            int r3 = r3 + 1
            goto L3c
        L48:
            boolean r3 = r12.f46962b
            if (r3 == 0) goto L74
            if (r1 == 0) goto L50
            int r0 = r0 + (-1)
        L50:
            if (r2 >= r0) goto L58
            b(r11, r2, r13)
            int r2 = r2 + 1
            goto L50
        L58:
            if (r1 == 0) goto L74
            androidx.media3.extractor.text.CuesWithTiming r3 = new androidx.media3.extractor.text.CuesWithTiming
            long r1 = r12.f46961a
            java.util.List r4 = r11.b(r1)
            long r5 = r11.c(r0)
            long r1 = r12.f46961a
            long r11 = r11.c(r0)
            long r7 = r1 - r11
            r3.<init>(r4, r5, r7)
            r13.accept(r3)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.LegacySubtitleUtil.c(androidx.media3.extractor.text.Subtitle, androidx.media3.extractor.text.SubtitleParser$OutputOptions, androidx.media3.common.util.Consumer):void");
    }
}
