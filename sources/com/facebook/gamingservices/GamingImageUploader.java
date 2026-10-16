package com.facebook.gamingservices;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.google.common.cache.LSNn.vfptEEmYY;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GamingImageUploader {
    private static final String photoUploadEdge = "me/photos";
    private Context context;

    public GamingImageUploader(Context context) {
        this.context = context;
    }

    public void uploadToMediaLibrary(String str, Bitmap bitmap, boolean z2) {
        uploadToMediaLibrary(str, bitmap, z2, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String str, Bitmap bitmap, boolean z2, GraphRequest.Callback callback) {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), vfptEEmYY.nbKow, bitmap, str, (Bundle) null, z2 ? new OpenGamingMediaDialog(this.context, callback) : callback).executeAsync();
    }

    public void uploadToMediaLibrary(String str, File file, boolean z2) throws FileNotFoundException {
        uploadToMediaLibrary(str, file, z2, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String str, File file, boolean z2, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), "me/photos", file, str, (Bundle) null, z2 ? new OpenGamingMediaDialog(this.context, callback) : callback).executeAsync();
    }

    public void uploadToMediaLibrary(String str, Uri uri, boolean z2) throws FileNotFoundException {
        uploadToMediaLibrary(str, uri, z2, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String str, Uri uri, boolean z2, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), "me/photos", uri, str, (Bundle) null, z2 ? new OpenGamingMediaDialog(this.context, callback) : callback).executeAsync();
    }
}
