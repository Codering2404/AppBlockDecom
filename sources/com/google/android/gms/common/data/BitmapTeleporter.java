package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zaa();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f71885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ParcelFileDescriptor f71886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f71887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap f71888d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f71889f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private File f71890g;

    BitmapTeleporter(int i3, ParcelFileDescriptor parcelFileDescriptor, int i4) {
        this.f71885a = i3;
        this.f71886b = parcelFileDescriptor;
        this.f71887c = i4;
    }

    private static final void M(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e3) {
            Log.w("BitmapTeleporter", "Could not close stream", e3);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        if (this.f71886b == null) {
            Bitmap bitmap = (Bitmap) Preconditions.m(this.f71888d);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(byteBufferAllocate);
            byte[] bArrArray = byteBufferAllocate.array();
            File file = this.f71890g;
            if (file == null) {
                throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
            }
            try {
                File fileCreateTempFile = File.createTempFile("teleporter", ".tmp", file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                    this.f71886b = ParcelFileDescriptor.open(fileCreateTempFile, 268435456);
                    fileCreateTempFile.delete();
                    DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));
                    try {
                        try {
                            dataOutputStream.writeInt(bArrArray.length);
                            dataOutputStream.writeInt(bitmap.getWidth());
                            dataOutputStream.writeInt(bitmap.getHeight());
                            dataOutputStream.writeUTF(bitmap.getConfig().toString());
                            dataOutputStream.write(bArrArray);
                        } catch (IOException e3) {
                            throw new IllegalStateException("Could not write into unlinked file", e3);
                        }
                    } finally {
                        M(dataOutputStream);
                    }
                } catch (FileNotFoundException unused) {
                    throw new IllegalStateException("Temporary file is somehow already deleted");
                }
            } catch (IOException e4) {
                throw new IllegalStateException("Could not create temporary file", e4);
            }
        }
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f71885a);
        SafeParcelWriter.E(parcel, 2, this.f71886b, i3 | 1, false);
        SafeParcelWriter.u(parcel, 3, this.f71887c);
        SafeParcelWriter.b(parcel, iA);
        this.f71886b = null;
    }
}
