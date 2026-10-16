package com.facebook.gamingservices.cloudgaming;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.GamingMediaUploader;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AppToUserNotificationSender {
    private static Bundle getParameters() {
        Bundle bundle = new Bundle();
        bundle.putString("upload_source", "A2U");
        return bundle;
    }

    public static void scheduleAppToUserNotification(String str, String str2, Bitmap bitmap, int i3, String str3, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, bitmap, getParameters(), new MediaUploadCallback(str, str2, i3, str3, callback));
    }

    public static void scheduleAppToUserNotification(String str, String str2, File file, int i3, String str3, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, file, getParameters(), new MediaUploadCallback(str, str2, i3, str3, callback));
    }

    public static void scheduleAppToUserNotification(String str, String str2, Uri uri, int i3, String str3, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, uri, getParameters(), new MediaUploadCallback(str, str2, i3, str3, callback));
    }
}
