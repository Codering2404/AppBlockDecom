package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final UriMatcher f66294f;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f66294f = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public StreamLocalUriFetcher(ContentResolver contentResolver, Uri uri, boolean z2) {
        super(contentResolver, uri, z2);
    }

    private InputStream j(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int iMatch = f66294f.match(uri);
        if (iMatch != 1) {
            if (iMatch == 3) {
                return k(contentResolver, uri);
            }
            if (iMatch != 5) {
                return (this.f66288a && MediaStoreUtil.d(uri) && MediaStoreUtil.c()) ? l(uri, contentResolver) : contentResolver.openInputStream(uri);
            }
        }
        Uri uriLookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uriLookupContact != null) {
            return k(contentResolver, uriLookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    private InputStream k(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    private InputStream l(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorH = MediaStoreUtil.h(uri, contentResolver);
        if (assetFileDescriptorH != null) {
            try {
                return assetFileDescriptorH.createInputStream();
            } catch (IOException e3) {
                try {
                    assetFileDescriptorH.close();
                } catch (Exception unused) {
                }
                throw ((FileNotFoundException) new FileNotFoundException("Unable to create stream").initCause(e3));
            }
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + uri);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class a() {
        return InputStream.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public InputStream f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream inputStreamJ = j(uri, contentResolver);
        if (inputStreamJ != null) {
            return inputStreamJ;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }
}
