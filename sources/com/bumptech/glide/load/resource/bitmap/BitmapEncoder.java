package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.BufferedOutputStream;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Option f66822b = Option.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Option f66823c = Option.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayPool f66824a;

    public BitmapEncoder(ArrayPool arrayPool) {
        this.f66824a = arrayPool;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.c(f66823c);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy b(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }

    @Override // com.bumptech.glide.load.Encoder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(Resource resource, File file, Options options) {
        boolean z2;
        FileOutputStream fileOutputStream;
        Bitmap bitmap = (Bitmap) resource.get();
        Bitmap.CompressFormat compressFormatD = d(bitmap, options);
        GlideTrace.d("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), compressFormatD);
        try {
            long jB = LogTime.b();
            int iIntValue = ((Integer) options.c(f66822b)).intValue();
            OutputStream bufferedOutputStream = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e3) {
                e = e3;
            }
            try {
                bufferedOutputStream = this.f66824a != null ? new BufferedOutputStream(fileOutputStream, this.f66824a) : fileOutputStream;
                bitmap.compress(compressFormatD, iIntValue, bufferedOutputStream);
                bufferedOutputStream.close();
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused) {
                }
                z2 = true;
            } catch (IOException e4) {
                e = e4;
                bufferedOutputStream = fileOutputStream;
                if (Log.isLoggable("BitmapEncoder", 3)) {
                    Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                z2 = false;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = fileOutputStream;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + compressFormatD + " of size " + Util.i(bitmap) + " in " + LogTime.a(jB) + ", options format: " + options.c(f66823c) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z2;
        } finally {
            GlideTrace.e();
        }
    }
}
