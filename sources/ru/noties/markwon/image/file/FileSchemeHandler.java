package ru.noties.markwon.image.file;

import android.content.res.AssetManager;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import ru.noties.markwon.image.ImageItem;
import ru.noties.markwon.image.SchemeHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class FileSchemeHandler extends SchemeHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetManager f147386a;

    FileSchemeHandler(AssetManager assetManager) {
        this.f147386a = assetManager;
    }

    public static FileSchemeHandler b() {
        return new FileSchemeHandler(null);
    }

    public static FileSchemeHandler c(AssetManager assetManager) {
        return new FileSchemeHandler(assetManager);
    }

    @Override // ru.noties.markwon.image.SchemeHandler
    public ImageItem a(String str, Uri uri) {
        InputStream bufferedInputStream;
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.size() == 0) {
            return null;
        }
        boolean zEquals = "android_asset".equals(pathSegments.get(0));
        String lastPathSegment = uri.getLastPathSegment();
        if (!zEquals) {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(uri.getPath())));
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                bufferedInputStream = null;
            }
        } else if (this.f147386a != null) {
            StringBuilder sb = new StringBuilder();
            int size = pathSegments.size();
            for (int i3 = 1; i3 < size; i3++) {
                if (i3 != 1) {
                    sb.append('/');
                }
                sb.append(pathSegments.get(i3));
            }
            try {
                bufferedInputStream = this.f147386a.open(sb.toString());
            } catch (IOException e4) {
                e4.printStackTrace();
                bufferedInputStream = null;
            }
        } else {
            bufferedInputStream = null;
        }
        if (bufferedInputStream != null) {
            return new ImageItem(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(lastPathSegment)), bufferedInputStream);
        }
        return null;
    }
}
