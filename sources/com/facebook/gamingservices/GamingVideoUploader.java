package com.facebook.gamingservices;

import android.content.Context;
import android.net.Uri;
import com.facebook.GraphRequest;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GamingVideoUploader {
    private Context context;

    public GamingVideoUploader(Context context) {
        this.context = context;
    }

    public void uploadToMediaLibrary(String str, Uri uri) throws FileNotFoundException {
        uploadToMediaLibrary(str, uri, null);
    }

    public void uploadToMediaLibrary(String str, Uri uri, GraphRequest.OnProgressCallback onProgressCallback) throws FileNotFoundException {
        uploadToMediaLibrary(str, uri, false, onProgressCallback);
    }

    public void uploadToMediaLibrary(String str, Uri uri, boolean z2, GraphRequest.OnProgressCallback onProgressCallback) throws FileNotFoundException {
        ShareVideoContent shareVideoContentBuild = new ShareVideoContent.Builder().setVideo(new ShareVideo.Builder().setLocalUrl(uri).build()).setContentDescription(str).build();
        if (z2) {
            onProgressCallback = new OpenGamingMediaDialog(this.context, onProgressCallback);
        }
        VideoUploader.uploadAsyncWithProgressCallback(shareVideoContentBuild, onProgressCallback);
    }
}
