package androidx.media3.exoplayer.video;

import androidx.media3.container.ObuParser;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class Av1SampleDependencyParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObuParser.SequenceHeader f45663a;

    Av1SampleDependencyParser() {
    }

    private boolean a(ObuParser.Obu obu, boolean z2) {
        ObuParser.SequenceHeader sequenceHeader;
        ObuParser.FrameHeader frameHeaderB;
        int i3 = obu.f41755a;
        if (i3 == 2 || i3 == 15) {
            return true;
        }
        if (i3 != 3 || z2) {
            return ((i3 != 6 && i3 != 3) || (sequenceHeader = this.f45663a) == null || (frameHeaderB = ObuParser.FrameHeader.b(sequenceHeader, obu)) == null || frameHeaderB.a()) ? false : true;
        }
        return false;
    }

    private void e(List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (((ObuParser.Obu) list.get(i3)).f41755a == 1) {
                this.f45663a = ObuParser.SequenceHeader.a((ObuParser.Obu) list.get(i3));
            }
        }
    }

    public void b(ByteBuffer byteBuffer) {
        e(ObuParser.e(byteBuffer));
    }

    public void c() {
        this.f45663a = null;
    }

    public int d(ByteBuffer byteBuffer, boolean z2) {
        List listE = ObuParser.e(byteBuffer);
        e(listE);
        int size = listE.size() - 1;
        int i3 = 0;
        while (size >= 0 && a((ObuParser.Obu) listE.get(size), z2)) {
            if (((ObuParser.Obu) listE.get(size)).f41755a == 6 || ((ObuParser.Obu) listE.get(size)).f41755a == 3) {
                i3++;
            }
            size--;
        }
        return (i3 > 1 || size + 1 >= 8) ? byteBuffer.limit() : size >= 0 ? ((ObuParser.Obu) listE.get(size)).f41756b.limit() : byteBuffer.position();
    }
}
