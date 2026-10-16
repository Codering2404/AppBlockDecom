package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ImageLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RequestQueue f57799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f57800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImageCache f57801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap f57802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap f57803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f57804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Runnable f57805g;

    /* JADX INFO: renamed from: com.android.volley.toolbox.ImageLoader$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements ImageListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f57806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f57807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f57808c;

        @Override // com.android.volley.toolbox.ImageLoader.ImageListener
        public void a(ImageContainer imageContainer, boolean z2) {
            if (imageContainer.d() != null) {
                this.f57807b.setImageBitmap(imageContainer.d());
                return;
            }
            int i3 = this.f57808c;
            if (i3 != 0) {
                this.f57807b.setImageResource(i3);
            }
        }

        @Override // com.android.volley.Response.ErrorListener
        public void c(VolleyError volleyError) {
            int i3 = this.f57806a;
            if (i3 != 0) {
                this.f57807b.setImageResource(i3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class BatchedImageRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Request f57814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bitmap f57815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private VolleyError f57816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f57817d;

        public BatchedImageRequest(Request request, ImageContainer imageContainer) {
            ArrayList arrayList = new ArrayList();
            this.f57817d = arrayList;
            this.f57814a = request;
            arrayList.add(imageContainer);
        }

        public void d(ImageContainer imageContainer) {
            this.f57817d.add(imageContainer);
        }

        public VolleyError e() {
            return this.f57816c;
        }

        public boolean f(ImageContainer imageContainer) {
            this.f57817d.remove(imageContainer);
            if (this.f57817d.size() != 0) {
                return false;
            }
            this.f57814a.c();
            return true;
        }

        public void g(VolleyError volleyError) {
            this.f57816c = volleyError;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ImageCache {
        void a(String str, Bitmap bitmap);

        Bitmap b(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public class ImageContainer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Bitmap f57818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ImageListener f57819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f57820c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f57821d;

        public ImageContainer(Bitmap bitmap, String str, String str2, ImageListener imageListener) {
            this.f57818a = bitmap;
            this.f57821d = str;
            this.f57820c = str2;
            this.f57819b = imageListener;
        }

        public void c() {
            Threads.a();
            if (this.f57819b == null) {
                return;
            }
            BatchedImageRequest batchedImageRequest = (BatchedImageRequest) ImageLoader.this.f57802d.get(this.f57820c);
            if (batchedImageRequest != null) {
                if (batchedImageRequest.f(this)) {
                    ImageLoader.this.f57802d.remove(this.f57820c);
                    return;
                }
                return;
            }
            BatchedImageRequest batchedImageRequest2 = (BatchedImageRequest) ImageLoader.this.f57803e.get(this.f57820c);
            if (batchedImageRequest2 != null) {
                batchedImageRequest2.f(this);
                if (batchedImageRequest2.f57817d.size() == 0) {
                    ImageLoader.this.f57803e.remove(this.f57820c);
                }
            }
        }

        public Bitmap d() {
            return this.f57818a;
        }

        public String e() {
            return this.f57821d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ImageListener extends Response.ErrorListener {
        void a(ImageContainer imageContainer, boolean z2);
    }

    private void d(String str, BatchedImageRequest batchedImageRequest) {
        this.f57803e.put(str, batchedImageRequest);
        if (this.f57805g == null) {
            Runnable runnable = new Runnable() { // from class: com.android.volley.toolbox.ImageLoader.4
                @Override // java.lang.Runnable
                public void run() {
                    for (BatchedImageRequest batchedImageRequest2 : ImageLoader.this.f57803e.values()) {
                        for (ImageContainer imageContainer : batchedImageRequest2.f57817d) {
                            if (imageContainer.f57819b != null) {
                                if (batchedImageRequest2.e() == null) {
                                    imageContainer.f57818a = batchedImageRequest2.f57815b;
                                    imageContainer.f57819b.a(imageContainer, false);
                                } else {
                                    imageContainer.f57819b.c(batchedImageRequest2.e());
                                }
                            }
                        }
                    }
                    ImageLoader.this.f57803e.clear();
                    ImageLoader.this.f57805g = null;
                }
            };
            this.f57805g = runnable;
            this.f57804f.postDelayed(runnable, this.f57800b);
        }
    }

    private static String f(String str, int i3, int i4, ImageView.ScaleType scaleType) {
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i3);
        sb.append("#H");
        sb.append(i4);
        sb.append("#S");
        sb.append(scaleType.ordinal());
        sb.append(str);
        return sb.toString();
    }

    public ImageContainer e(String str, ImageListener imageListener, int i3, int i4, ImageView.ScaleType scaleType) {
        Threads.a();
        String strF = f(str, i3, i4, scaleType);
        Bitmap bitmapB = this.f57801c.b(strF);
        if (bitmapB != null) {
            ImageContainer imageContainer = new ImageContainer(bitmapB, str, null, null);
            imageListener.a(imageContainer, true);
            return imageContainer;
        }
        ImageContainer imageContainer2 = new ImageContainer(null, str, strF, imageListener);
        imageListener.a(imageContainer2, true);
        BatchedImageRequest batchedImageRequest = (BatchedImageRequest) this.f57802d.get(strF);
        if (batchedImageRequest == null) {
            batchedImageRequest = (BatchedImageRequest) this.f57803e.get(strF);
        }
        if (batchedImageRequest != null) {
            batchedImageRequest.d(imageContainer2);
            return imageContainer2;
        }
        Request requestG = g(str, i3, i4, scaleType, strF);
        this.f57799a.a(requestG);
        this.f57802d.put(strF, new BatchedImageRequest(requestG, imageContainer2));
        return imageContainer2;
    }

    protected Request g(String str, int i3, int i4, ImageView.ScaleType scaleType, final String str2) {
        return new ImageRequest(str, new Response.Listener<Bitmap>() { // from class: com.android.volley.toolbox.ImageLoader.2
            @Override // com.android.volley.Response.Listener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void b(Bitmap bitmap) {
                ImageLoader.this.i(str2, bitmap);
            }
        }, i3, i4, scaleType, Bitmap.Config.RGB_565, new Response.ErrorListener() { // from class: com.android.volley.toolbox.ImageLoader.3
            @Override // com.android.volley.Response.ErrorListener
            public void c(VolleyError volleyError) {
                ImageLoader.this.h(str2, volleyError);
            }
        });
    }

    protected void h(String str, VolleyError volleyError) {
        BatchedImageRequest batchedImageRequest = (BatchedImageRequest) this.f57802d.remove(str);
        if (batchedImageRequest != null) {
            batchedImageRequest.g(volleyError);
            d(str, batchedImageRequest);
        }
    }

    protected void i(String str, Bitmap bitmap) {
        this.f57801c.a(str, bitmap);
        BatchedImageRequest batchedImageRequest = (BatchedImageRequest) this.f57802d.remove(str);
        if (batchedImageRequest != null) {
            batchedImageRequest.f57815b = bitmap;
            d(str, batchedImageRequest);
        }
    }
}
