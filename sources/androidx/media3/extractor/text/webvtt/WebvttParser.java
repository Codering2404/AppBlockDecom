package androidx.media3.extractor.text.webvtt;

import android.text.TextUtils;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.text.LegacySubtitleUtil;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class WebvttParser implements SubtitleParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f47325a = new ParsableByteArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WebvttCssParser f47326b = new WebvttCssParser();

    private static int d(ParsableByteArray parsableByteArray) {
        int i3 = -1;
        int iF = 0;
        while (i3 == -1) {
            iF = parsableByteArray.f();
            String strS = parsableByteArray.s();
            i3 = strS == null ? 0 : "STYLE".equals(strS) ? 2 : strS.startsWith("NOTE") ? 1 : 3;
        }
        parsableByteArray.W(iF);
        return i3;
    }

    private static void e(ParsableByteArray parsableByteArray) {
        while (!TextUtils.isEmpty(parsableByteArray.s())) {
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void a(byte[] bArr, int i3, int i4, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        WebvttCueInfo webvttCueInfoN;
        this.f47325a.U(bArr, i4 + i3);
        this.f47325a.W(i3);
        ArrayList arrayList = new ArrayList();
        try {
            WebvttParserUtil.d(this.f47325a);
            while (!TextUtils.isEmpty(this.f47325a.s())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int iD = d(this.f47325a);
                if (iD == 0) {
                    LegacySubtitleUtil.c(new WebvttSubtitle(arrayList2), outputOptions, consumer);
                    return;
                }
                if (iD == 1) {
                    e(this.f47325a);
                } else if (iD == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                    this.f47325a.s();
                    arrayList.addAll(this.f47326b.d(this.f47325a));
                } else if (iD == 3 && (webvttCueInfoN = WebvttCueParser.n(this.f47325a, arrayList)) != null) {
                    arrayList2.add(webvttCueInfoN);
                }
            }
        } catch (ParserException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public int c() {
        return 1;
    }
}
