package com.facebook.messenger;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ShareToMessengerParamsBuilder {
    private Uri mExternalUri;
    private String mMetaData;
    private final String mMimeType;
    private final Uri mUri;

    ShareToMessengerParamsBuilder(Uri uri, String str) {
        this.mUri = uri;
        this.mMimeType = str;
    }

    public ShareToMessengerParams build() {
        return new ShareToMessengerParams(this);
    }

    public Uri getExternalUri() {
        return this.mExternalUri;
    }

    public String getMetaData() {
        return this.mMetaData;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public ShareToMessengerParamsBuilder setExternalUri(Uri uri) {
        this.mExternalUri = uri;
        return this;
    }

    public ShareToMessengerParamsBuilder setMetaData(String str) {
        this.mMetaData = str;
        return this;
    }
}
