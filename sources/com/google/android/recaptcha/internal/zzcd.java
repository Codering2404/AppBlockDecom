package com.google.android.recaptcha.internal;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import kotlin.io.FilesKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcd {
    public zzcd(Context context) {
    }

    public static final byte[] zza(File file) throws GeneralSecurityException, IOException {
        return FilesKt.e(file);
    }

    public static final void zzb(File file, byte[] bArr) throws GeneralSecurityException, IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException("Unable to delete existing encrypted file");
        }
        FilesKt.h(file, bArr);
    }
}
