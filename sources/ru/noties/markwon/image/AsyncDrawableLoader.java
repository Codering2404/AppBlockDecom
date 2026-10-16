package ru.noties.markwon.image;

import android.graphics.drawable.Drawable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AsyncDrawableLoader {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ExecutorService f147340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map f147341b = new HashMap(3);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Map f147342c = new HashMap(3);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        MediaDecoder f147343d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        DrawableProvider f147344e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        DrawableProvider f147345f;

        public Builder a(String str, SchemeHandler schemeHandler) {
            this.f147341b.put(str, schemeHandler);
            return this;
        }

        public Builder b(Collection collection, SchemeHandler schemeHandler) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                this.f147341b.put((String) it.next(), schemeHandler);
            }
            return this;
        }

        public AsyncDrawableLoader c() {
            if (this.f147341b.size() == 0 || (this.f147342c.size() == 0 && this.f147343d == null)) {
                return new AsyncDrawableLoaderNoOp();
            }
            if (this.f147340a == null) {
                this.f147340a = Executors.newCachedThreadPool();
            }
            return new AsyncDrawableLoaderImpl(this);
        }

        public Builder d(MediaDecoder mediaDecoder) {
            this.f147343d = mediaDecoder;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface DrawableProvider {
        Drawable a();
    }

    public abstract void a(String str);

    public abstract void b(String str, AsyncDrawable asyncDrawable);

    public abstract Drawable c();
}
