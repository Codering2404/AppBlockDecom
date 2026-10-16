package ru.noties.markwon.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.InputStream;
import ru.noties.markwon.utils.DrawableUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ImageMediaDecoder extends MediaDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f147370a;

    ImageMediaDecoder(Resources resources) {
        this.f147370a = resources;
    }

    public static ImageMediaDecoder b(Resources resources) {
        return new ImageMediaDecoder(resources);
    }

    @Override // ru.noties.markwon.image.MediaDecoder
    public Drawable a(InputStream inputStream) {
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
        if (bitmapDecodeStream == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f147370a, bitmapDecodeStream);
        DrawableUtils.a(bitmapDrawable);
        return bitmapDrawable;
    }
}
