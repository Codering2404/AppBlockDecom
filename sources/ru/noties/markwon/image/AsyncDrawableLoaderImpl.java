package ru.noties.markwon.image;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import ru.noties.markwon.image.AsyncDrawableLoader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class AsyncDrawableLoaderImpl extends AsyncDrawableLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f147346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f147347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f147348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MediaDecoder f147349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AsyncDrawableLoader.DrawableProvider f147350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AsyncDrawableLoader.DrawableProvider f147351f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f147353h = new HashMap(2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Handler f147352g = new Handler(Looper.getMainLooper());

    AsyncDrawableLoaderImpl(AsyncDrawableLoader.Builder builder) {
        this.f147346a = builder.f147340a;
        this.f147347b = builder.f147341b;
        this.f147348c = builder.f147342c;
        this.f147349d = builder.f147343d;
        this.f147350e = builder.f147344e;
        this.f147351f = builder.f147345f;
    }

    private Future j(final String str, AsyncDrawable asyncDrawable) {
        final WeakReference weakReference = new WeakReference(asyncDrawable);
        return this.f147346a.submit(new Runnable() { // from class: ru.noties.markwon.image.AsyncDrawableLoaderImpl.1
            @Override // java.lang.Runnable
            public void run() {
                final Drawable drawableA;
                Uri uri = Uri.parse(str);
                SchemeHandler schemeHandler = (SchemeHandler) AsyncDrawableLoaderImpl.this.f147347b.get(uri.getScheme());
                ImageItem imageItemA = schemeHandler != null ? schemeHandler.a(str, uri) : null;
                InputStream inputStreamB = imageItemA != null ? imageItemA.b() : null;
                if (inputStreamB != null) {
                    try {
                        MediaDecoder mediaDecoder = (MediaDecoder) AsyncDrawableLoaderImpl.this.f147348c.get(imageItemA.a());
                        if (mediaDecoder == null) {
                            mediaDecoder = AsyncDrawableLoaderImpl.this.f147349d;
                        }
                        drawableA = mediaDecoder != null ? mediaDecoder.a(inputStreamB) : null;
                        try {
                            inputStreamB.close();
                        } catch (IOException unused) {
                        }
                    } catch (Throwable th) {
                        try {
                            inputStreamB.close();
                        } catch (IOException unused2) {
                        }
                        throw th;
                    }
                } else {
                    drawableA = null;
                }
                if (drawableA == null) {
                    drawableA = AsyncDrawableLoaderImpl.this.f147351f != null ? AsyncDrawableLoaderImpl.this.f147351f.a() : null;
                }
                if (drawableA != null) {
                    AsyncDrawableLoaderImpl.this.f147352g.post(new Runnable() { // from class: ru.noties.markwon.image.AsyncDrawableLoaderImpl.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AsyncDrawable asyncDrawable2;
                            if (AsyncDrawableLoaderImpl.this.f147353h.remove(str) == null || (asyncDrawable2 = (AsyncDrawable) weakReference.get()) == null || !asyncDrawable2.d()) {
                                return;
                            }
                            asyncDrawable2.g(drawableA);
                        }
                    });
                } else {
                    AsyncDrawableLoaderImpl.this.f147353h.remove(str);
                }
            }
        });
    }

    @Override // ru.noties.markwon.image.AsyncDrawableLoader
    public void a(String str) {
        Future future = (Future) this.f147353h.remove(str);
        if (future != null) {
            future.cancel(true);
        }
    }

    @Override // ru.noties.markwon.image.AsyncDrawableLoader
    public void b(String str, AsyncDrawable asyncDrawable) {
        this.f147353h.put(str, j(str, asyncDrawable));
    }

    @Override // ru.noties.markwon.image.AsyncDrawableLoader
    public Drawable c() {
        AsyncDrawableLoader.DrawableProvider drawableProvider = this.f147350e;
        if (drawableProvider != null) {
            return drawableProvider.a();
        }
        return null;
    }
}
