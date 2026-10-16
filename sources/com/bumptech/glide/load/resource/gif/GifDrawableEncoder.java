package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GifDrawableEncoder implements ResourceEncoder<GifDrawable> {
    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy b(Options options) {
        return EncodeStrategy.SOURCE;
    }

    @Override // com.bumptech.glide.load.Encoder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(Resource resource, File file, Options options) throws Throwable {
        try {
            ByteBufferUtil.f(((GifDrawable) resource.get()).c(), file);
            return true;
        } catch (IOException e3) {
            if (!Log.isLoggable("GifEncoder", 5)) {
                return false;
            }
            Log.w("GifEncoder", "Failed to encode GIF drawable data", e3);
            return false;
        }
    }
}
