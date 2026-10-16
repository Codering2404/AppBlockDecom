package androidx.media3.extractor;

import android.net.Uri;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ExtractorsFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorsFactory f46150a = new ExtractorsFactory() { // from class: androidx.media3.extractor.c
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return ExtractorsFactory.e();
        }
    };

    static /* synthetic */ Extractor[] e() {
        return new Extractor[0];
    }

    default Extractor[] d(Uri uri, Map map) {
        return f();
    }

    Extractor[] f();

    default ExtractorsFactory a(SubtitleParser.Factory factory) {
        return this;
    }

    default ExtractorsFactory b(int i3) {
        return this;
    }

    default ExtractorsFactory c(boolean z2) {
        return this;
    }
}
