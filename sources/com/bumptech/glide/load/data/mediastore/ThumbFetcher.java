package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.ExifOrientationStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ThumbFetcher implements DataFetcher<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f66295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThumbnailStreamOpener f66296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InputStream f66297c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ImageThumbnailQuery implements ThumbnailQuery {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String[] f66298b = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f66299a;

        ImageThumbnailQuery(ContentResolver contentResolver) {
            this.f66299a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor a(Uri uri) {
            return this.f66299a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f66298b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class VideoThumbnailQuery implements ThumbnailQuery {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String[] f66300b = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f66301a;

        VideoThumbnailQuery(ContentResolver contentResolver) {
            this.f66301a = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.mediastore.ThumbnailQuery
        public Cursor a(Uri uri) {
            return this.f66301a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f66300b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    ThumbFetcher(Uri uri, ThumbnailStreamOpener thumbnailStreamOpener) {
        this.f66295a = uri;
        this.f66296b = thumbnailStreamOpener;
    }

    private static ThumbFetcher c(Context context, Uri uri, ThumbnailQuery thumbnailQuery) {
        return new ThumbFetcher(uri, new ThumbnailStreamOpener(Glide.c(context).j().g(), thumbnailQuery, Glide.c(context).e(), context.getContentResolver()));
    }

    public static ThumbFetcher f(Context context, Uri uri) {
        return c(context, uri, new ImageThumbnailQuery(context.getContentResolver()));
    }

    public static ThumbFetcher g(Context context, Uri uri) {
        return c(context, uri, new VideoThumbnailQuery(context.getContentResolver()));
    }

    private InputStream h() throws Throwable {
        InputStream inputStreamD = this.f66296b.d(this.f66295a);
        int iA = inputStreamD != null ? this.f66296b.a(this.f66295a) : -1;
        return iA != -1 ? new ExifOrientationStream(inputStreamD, iA) : inputStreamD;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void b() {
        InputStream inputStream = this.f66297c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource d() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void e(Priority priority, DataFetcher.DataCallback dataCallback) throws Throwable {
        try {
            InputStream inputStreamH = h();
            this.f66297c = inputStreamH;
            dataCallback.f(inputStreamH);
        } catch (FileNotFoundException e3) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e3);
            }
            dataCallback.c(e3);
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }
}
