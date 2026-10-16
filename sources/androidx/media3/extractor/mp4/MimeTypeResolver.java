package androidx.media3.extractor.mp4;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MimeTypeResolver {
    public static String a(Format format) {
        String str = format.f40632o;
        return MimeTypes.q(str) ? "video/mp4" : MimeTypes.n(str) ? "audio/mp4" : MimeTypes.o(str) ? Objects.equals(str, "image/heic") ? "image/heif" : Objects.equals(str, "image/avif") ? "image/avif" : "application/mp4" : "application/mp4";
    }

    public static String b(List list) {
        Iterator it = list.iterator();
        boolean z2 = false;
        String str = null;
        while (it.hasNext()) {
            String str2 = ((TrackSampleTable) it.next()).f46854a.f46825g.f40632o;
            if (MimeTypes.q(str2)) {
                return "video/mp4";
            }
            if (MimeTypes.n(str2)) {
                z2 = true;
            } else if (MimeTypes.o(str2)) {
                if (Objects.equals(str2, "image/heic")) {
                    str = "image/heif";
                } else if (Objects.equals(str2, "image/avif")) {
                    str = "image/avif";
                }
            }
        }
        return z2 ? "audio/mp4" : str != null ? str : "application/mp4";
    }
}
