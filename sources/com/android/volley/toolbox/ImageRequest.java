package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ImageRequest extends Request<Bitmap> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final Object f57823x = new Object();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Object f57824r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Response.Listener f57825s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Bitmap.Config f57826t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f57827u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f57828v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final ImageView.ScaleType f57829w;

    public ImageRequest(String str, Response.Listener listener, int i3, int i4, ImageView.ScaleType scaleType, Bitmap.Config config, Response.ErrorListener errorListener) {
        super(0, str, errorListener);
        this.f57824r = new Object();
        Q(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.f57825s = listener;
        this.f57826t = config;
        this.f57827u = i3;
        this.f57828v = i4;
        this.f57829w = scaleType;
    }

    private Response W(NetworkResponse networkResponse) {
        Bitmap bitmapDecodeByteArray;
        byte[] bArr = networkResponse.f57677b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f57827u == 0 && this.f57828v == 0) {
            options.inPreferredConfig = this.f57826t;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            int iY = Y(this.f57827u, this.f57828v, i3, i4, this.f57829w);
            int iY2 = Y(this.f57828v, this.f57827u, i4, i3, this.f57829w);
            options.inJustDecodeBounds = false;
            options.inSampleSize = X(i3, i4, iY, iY2);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iY || bitmapDecodeByteArray.getHeight() > iY2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iY, iY2, true);
                bitmapDecodeByteArray.recycle();
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        return bitmapDecodeByteArray == null ? Response.a(new ParseError(networkResponse)) : Response.c(bitmapDecodeByteArray, HttpHeaderParser.e(networkResponse));
    }

    static int X(int i3, int i4, int i5, int i6) {
        double dMin = Math.min(((double) i3) / ((double) i5), ((double) i4) / ((double) i6));
        float f3 = 1.0f;
        while (true) {
            float f4 = 2.0f * f3;
            if (f4 > dMin) {
                return (int) f3;
            }
            f3 = f4;
        }
    }

    private static int Y(int i3, int i4, int i5, int i6, ImageView.ScaleType scaleType) {
        if (i3 != 0 || i4 != 0) {
            if (scaleType != ImageView.ScaleType.FIT_XY) {
                if (i3 == 0) {
                    return (int) (((double) i5) * (((double) i4) / ((double) i6)));
                }
                if (i4 == 0) {
                    return i3;
                }
                double d3 = ((double) i6) / ((double) i5);
                if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                    double d4 = i4;
                    return ((double) i3) * d3 < d4 ? (int) (d4 / d3) : i3;
                }
                double d5 = i4;
                return ((double) i3) * d3 > d5 ? (int) (d5 / d3) : i3;
            }
            if (i3 != 0) {
                return i3;
            }
        }
        return i5;
    }

    @Override // com.android.volley.Request
    protected Response G(NetworkResponse networkResponse) {
        Response responseW;
        synchronized (f57823x) {
            try {
                try {
                    responseW = W(networkResponse);
                } catch (OutOfMemoryError e3) {
                    VolleyLog.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(networkResponse.f57677b.length), z());
                    return Response.a(new ParseError(e3));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return responseW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public void f(Bitmap bitmap) {
        Response.Listener listener;
        synchronized (this.f57824r) {
            listener = this.f57825s;
        }
        if (listener != null) {
            listener.b(bitmap);
        }
    }

    @Override // com.android.volley.Request
    public void c() {
        super.c();
        synchronized (this.f57824r) {
            this.f57825s = null;
        }
    }

    @Override // com.android.volley.Request
    public Request.Priority v() {
        return Request.Priority.LOW;
    }
}
