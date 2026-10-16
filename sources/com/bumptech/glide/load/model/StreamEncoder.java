package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class StreamEncoder implements Encoder<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayPool f66764a;

    public StreamEncoder(ArrayPool arrayPool) {
        this.f66764a = arrayPool;
    }

    @Override // com.bumptech.glide.load.Encoder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, File file, Options options) throws Throwable {
        byte[] bArr = (byte[]) this.f66764a.c(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, byte[].class);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int i3 = inputStream.read(bArr);
                        if (i3 == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i3);
                    } catch (IOException e3) {
                        e = e3;
                        fileOutputStream = fileOutputStream2;
                        if (Log.isLoggable("StreamEncoder", 3)) {
                            Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        this.f66764a.put(bArr);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        this.f66764a.put(bArr);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
                this.f66764a.put(bArr);
                return true;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e = e4;
        }
    }
}
