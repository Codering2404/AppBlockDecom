package androidx.media3.extractor.metadata.flac;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import com.google.common.base.Ascii;
import com.google.common.primitives.Ints;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class VorbisComment implements Metadata.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46434b;

    public VorbisComment(String str, String str2) {
        this.f46433a = Ascii.g(str);
        this.f46434b = str2;
    }

    @Override // androidx.media3.common.Metadata.Entry
    public void b(MediaMetadata.Builder builder) {
        String str = this.f46433a;
        str.getClass();
        switch (str) {
            case "TOTALTRACKS":
                Integer numO = Ints.o(this.f46434b);
                if (numO != null) {
                    builder.s0(numO);
                    break;
                }
                break;
            case "TOTALDISCS":
                Integer numO2 = Ints.o(this.f46434b);
                if (numO2 != null) {
                    builder.r0(numO2);
                    break;
                }
                break;
            case "TRACKNUMBER":
                Integer numO3 = Ints.o(this.f46434b);
                if (numO3 != null) {
                    builder.t0(numO3);
                    break;
                }
                break;
            case "ALBUM":
                builder.P(this.f46434b);
                break;
            case "GENRE":
                builder.c0(this.f46434b);
                break;
            case "TITLE":
                builder.q0(this.f46434b);
                break;
            case "DESCRIPTION":
                builder.W(this.f46434b);
                break;
            case "DISCNUMBER":
                Integer numO4 = Ints.o(this.f46434b);
                if (numO4 != null) {
                    builder.X(numO4);
                    break;
                }
                break;
            case "ALBUMARTIST":
                builder.O(this.f46434b);
                break;
            case "ARTIST":
                builder.Q(this.f46434b);
                break;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            VorbisComment vorbisComment = (VorbisComment) obj;
            if (this.f46433a.equals(vorbisComment.f46433a) && this.f46434b.equals(vorbisComment.f46434b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f46433a.hashCode()) * 31) + this.f46434b.hashCode();
    }

    public String toString() {
        return "VC: " + this.f46433a + "=" + this.f46434b;
    }
}
