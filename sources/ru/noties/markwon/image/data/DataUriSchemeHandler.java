package ru.noties.markwon.image.data;

import android.net.Uri;
import java.io.ByteArrayInputStream;
import ru.noties.markwon.image.ImageItem;
import ru.noties.markwon.image.SchemeHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class DataUriSchemeHandler extends SchemeHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DataUriParser f147384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataUriDecoder f147385b;

    DataUriSchemeHandler(DataUriParser dataUriParser, DataUriDecoder dataUriDecoder) {
        this.f147384a = dataUriParser;
        this.f147385b = dataUriDecoder;
    }

    public static DataUriSchemeHandler b() {
        return new DataUriSchemeHandler(DataUriParser.a(), DataUriDecoder.a());
    }

    @Override // ru.noties.markwon.image.SchemeHandler
    public ImageItem a(String str, Uri uri) {
        byte[] bArrB;
        if (!str.startsWith("data:")) {
            return null;
        }
        String strSubstring = str.substring(5);
        if (strSubstring.startsWith("//")) {
            strSubstring = strSubstring.substring(2);
        }
        DataUri dataUriB = this.f147384a.b(strSubstring);
        if (dataUriB == null || (bArrB = this.f147385b.b(dataUriB)) == null) {
            return null;
        }
        return new ImageItem(dataUriB.b(), new ByteArrayInputStream(bArrB));
    }
}
