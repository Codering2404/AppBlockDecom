package ru.noties.markwon.image;

import android.graphics.Rect;
import com.facebook.appevents.UserDataStore;
import ru.noties.markwon.image.ImageSize;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ImageSizeResolverDef extends ImageSizeResolver {
    @Override // ru.noties.markwon.image.ImageSizeResolver
    public Rect a(ImageSize imageSize, Rect rect, int i3, float f3) {
        if (imageSize == null) {
            int iWidth = rect.width();
            if (iWidth > i3) {
                return new Rect(0, 0, i3, (int) ((rect.height() / (iWidth / i3)) + 0.5f));
            }
            return rect;
        }
        ImageSize.Dimension dimension = imageSize.f147374a;
        ImageSize.Dimension dimension2 = imageSize.f147375b;
        int iWidth2 = rect.width();
        int iHeight = rect.height();
        float f4 = iWidth2 / iHeight;
        if (dimension != null) {
            int iB = "%".equals(dimension.f147377b) ? (int) ((i3 * (dimension.f147376a / 100.0f)) + 0.5f) : b(dimension, iWidth2, f3);
            return new Rect(0, 0, iB, (dimension2 == null || "%".equals(dimension2.f147377b)) ? (int) ((iB / f4) + 0.5f) : b(dimension2, iHeight, f3));
        }
        if (dimension2 == null || "%".equals(dimension2.f147377b)) {
            return rect;
        }
        int iB2 = b(dimension2, iHeight, f3);
        return new Rect(0, 0, (int) ((iB2 * f4) + 0.5f), iB2);
    }

    protected int b(ImageSize.Dimension dimension, int i3, float f3) {
        return (int) ((UserDataStore.EMAIL.equals(dimension.f147377b) ? dimension.f147376a * f3 : dimension.f147376a) + 0.5f);
    }
}
