package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ColorResourcesLoaderCreator {
    static ResourcesLoader a(Context context, Map map) {
        FileDescriptor fileDescriptorMemfd_create;
        try {
            byte[] bArrI = ColorResourcesTableCreator.i(context, map);
            Log.i("ColorResLoaderCreator", "Table created, length: " + bArrI.length);
            if (bArrI.length == 0) {
                return null;
            }
            try {
                fileDescriptorMemfd_create = Os.memfd_create("temp.arsc", 0);
                try {
                    if (fileDescriptorMemfd_create == null) {
                        Log.w("ColorResLoaderCreator", "Cannot create memory file descriptor.");
                        if (fileDescriptorMemfd_create == null) {
                            return null;
                        }
                        Os.close(fileDescriptorMemfd_create);
                        return null;
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(fileDescriptorMemfd_create);
                    try {
                        fileOutputStream.write(bArrI);
                        ParcelFileDescriptor parcelFileDescriptorDup = ParcelFileDescriptor.dup(fileDescriptorMemfd_create);
                        try {
                            h.a();
                            ResourcesLoader resourcesLoaderA = g.a();
                            resourcesLoaderA.addProvider(ResourcesProvider.loadFromTable(parcelFileDescriptorDup, null));
                            if (parcelFileDescriptorDup != null) {
                                parcelFileDescriptorDup.close();
                            }
                            fileOutputStream.close();
                            Os.close(fileDescriptorMemfd_create);
                            return resourcesLoaderA;
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileDescriptorMemfd_create != null) {
                        Os.close(fileDescriptorMemfd_create);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileDescriptorMemfd_create = null;
            }
        } catch (Exception e3) {
            Log.e("ColorResLoaderCreator", "Failed to create the ColorResourcesTableCreator.", e3);
            return null;
        }
    }
}
