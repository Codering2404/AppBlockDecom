package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class UrlTileProvider implements TileProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f73266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f73267c;

    @Override // com.google.android.gms.maps.model.TileProvider
    public final Tile a(int i3, int i4, int i5) {
        URL urlB = b(i3, i4, i5);
        if (urlB == null) {
            return TileProvider.f73265a;
        }
        try {
            com.google.android.gms.internal.maps.zzf.zzb(4352);
            int i6 = this.f73266b;
            int i7 = this.f73267c;
            InputStream inputStream = urlB.openConnection().getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Preconditions.n(inputStream, "from must not be null.");
            Preconditions.n(byteArrayOutputStream, "to must not be null.");
            byte[] bArr = new byte[4096];
            while (true) {
                int i8 = inputStream.read(bArr);
                if (i8 == -1) {
                    Tile tile = new Tile(i6, i7, byteArrayOutputStream.toByteArray());
                    com.google.android.gms.internal.maps.zzf.zza();
                    return tile;
                }
                byteArrayOutputStream.write(bArr, 0, i8);
            }
        } catch (IOException unused) {
            com.google.android.gms.internal.maps.zzf.zza();
            return null;
        } catch (Throwable th) {
            com.google.android.gms.internal.maps.zzf.zza();
            throw th;
        }
    }

    public abstract URL b(int i3, int i4, int i5);
}
