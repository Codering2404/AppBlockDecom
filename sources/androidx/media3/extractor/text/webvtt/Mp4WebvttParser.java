package androidx.media3.extractor.text.webvtt;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Mp4WebvttParser implements SubtitleParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f47276a = new ParsableByteArray();

    private static Cue d(ParsableByteArray parsableByteArray, int i3) {
        CharSequence charSequenceR = null;
        Cue.Builder builderP = null;
        while (i3 > 0) {
            Assertions.b(i3 >= 8, "Incomplete vtt cue box header found.");
            int iQ = parsableByteArray.q();
            int iQ2 = parsableByteArray.q();
            int i4 = iQ - 8;
            String strL = Util.L(parsableByteArray.e(), parsableByteArray.f(), i4);
            parsableByteArray.X(i4);
            i3 = (i3 - 8) - i4;
            if (iQ2 == 1937011815) {
                builderP = WebvttCueParser.p(strL);
            } else if (iQ2 == 1885436268) {
                charSequenceR = WebvttCueParser.r(null, strL.trim(), Collections.EMPTY_LIST);
            }
        }
        if (charSequenceR == null) {
            charSequenceR = "";
        }
        return builderP != null ? builderP.o(charSequenceR).a() : WebvttCueParser.m(charSequenceR);
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void a(byte[] bArr, int i3, int i4, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        this.f47276a.U(bArr, i4 + i3);
        this.f47276a.W(i3);
        ArrayList arrayList = new ArrayList();
        while (this.f47276a.a() > 0) {
            Assertions.b(this.f47276a.a() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
            int iQ = this.f47276a.q();
            if (this.f47276a.q() == 1987343459) {
                arrayList.add(d(this.f47276a, iQ - 8));
            } else {
                this.f47276a.X(iQ - 8);
            }
        }
        consumer.accept(new CuesWithTiming(arrayList, -9223372036854775807L, -9223372036854775807L));
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public int c() {
        return 2;
    }
}
