package com.bumptech.glide.load.resource.bitmap;

import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ExifInterfaceImageHeaderParser implements ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public boolean b(ByteBuffer byteBuffer, ArrayPool arrayPool) {
        return false;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int c(ByteBuffer byteBuffer, ArrayPool arrayPool) {
        return e(ByteBufferUtil.g(byteBuffer), arrayPool);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType d(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int e(InputStream inputStream, ArrayPool arrayPool) {
        int iC = new ExifInterface(inputStream).c("Orientation", 1);
        if (iC == 0) {
            return -1;
        }
        return iC;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public boolean f(InputStream inputStream, ArrayPool arrayPool) {
        return false;
    }
}
