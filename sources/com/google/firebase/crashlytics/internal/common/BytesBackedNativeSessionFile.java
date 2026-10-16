package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class BytesBackedNativeSessionFile implements NativeSessionFile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f88317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88319c;

    BytesBackedNativeSessionFile(String str, String str2, byte[] bArr) {
        this.f88318b = str;
        this.f88319c = str2;
        this.f88317a = bArr;
    }

    private byte[] c() {
        if (d()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(this.f88317a);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return byteArray;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private boolean d() {
        byte[] bArr = this.f88317a;
        return bArr == null || bArr.length == 0;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public CrashlyticsReport.FilesPayload.File a() {
        byte[] bArrC = c();
        if (bArrC == null) {
            return null;
        }
        return CrashlyticsReport.FilesPayload.File.a().b(bArrC).c(this.f88318b).a();
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public String b() {
        return this.f88319c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    public InputStream i() {
        if (d()) {
            return null;
        }
        return new ByteArrayInputStream(this.f88317a);
    }
}
