package androidx.media3.extractor.avi;

import androidx.media3.common.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ListChunk implements AviChunk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList f46328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f46329b;

    private ListChunk(int i3, ImmutableList immutableList) {
        this.f46329b = i3;
        this.f46328a = immutableList;
    }

    private static AviChunk a(int i3, int i4, ParsableByteArray parsableByteArray) {
        switch (i3) {
            case 1718776947:
                return StreamFormatChunk.d(i4, parsableByteArray);
            case 1751742049:
                return AviMainHeaderChunk.b(parsableByteArray);
            case 1752331379:
                return AviStreamHeaderChunk.c(parsableByteArray);
            case 1852994675:
                return StreamNameChunk.a(parsableByteArray);
            default:
                return null;
        }
    }

    public static ListChunk c(int i3, ParsableByteArray parsableByteArray) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int iG = parsableByteArray.g();
        int iB = -2;
        while (parsableByteArray.a() > 8) {
            int iU = parsableByteArray.u();
            int iF = parsableByteArray.f() + parsableByteArray.u();
            parsableByteArray.V(iF);
            AviChunk aviChunkC = iU == 1414744396 ? c(parsableByteArray.u(), parsableByteArray) : a(iU, iB, parsableByteArray);
            if (aviChunkC != null) {
                if (aviChunkC.getType() == 1752331379) {
                    iB = ((AviStreamHeaderChunk) aviChunkC).b();
                }
                builder.a(aviChunkC);
            }
            parsableByteArray.W(iF);
            parsableByteArray.V(iG);
        }
        return new ListChunk(i3, builder.m());
    }

    public AviChunk b(Class cls) {
        UnmodifiableIterator it = this.f46328a.iterator();
        while (it.hasNext()) {
            AviChunk aviChunk = (AviChunk) it.next();
            if (aviChunk.getClass() == cls) {
                return aviChunk;
            }
        }
        return null;
    }

    @Override // androidx.media3.extractor.avi.AviChunk
    public int getType() {
        return this.f46329b;
    }
}
