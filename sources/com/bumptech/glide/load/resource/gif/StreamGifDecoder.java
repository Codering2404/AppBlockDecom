package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f67007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ResourceDecoder f67008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayPool f67009c;

    public StreamGifDecoder(List list, ResourceDecoder resourceDecoder, ArrayPool arrayPool) {
        this.f67007a = list;
        this.f67008b = resourceDecoder;
        this.f67009c = arrayPool;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i3 = inputStream.read(bArr);
                if (i3 == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i3);
            }
        } catch (IOException e3) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e3);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Resource b(InputStream inputStream, int i3, int i4, Options options) {
        byte[] bArrE = e(inputStream);
        if (bArrE == null) {
            return null;
        }
        return this.f67008b.b(ByteBuffer.wrap(bArrE), i3, i4, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, Options options) {
        return !((Boolean) options.c(GifOptions.f67006b)).booleanValue() && ImageHeaderParserUtils.f(this.f67007a, inputStream, this.f67009c) == ImageHeaderParser.ImageType.GIF;
    }
}
