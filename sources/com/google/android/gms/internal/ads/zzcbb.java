package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcbb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcbb> CREATOR = new zzcbc();
    ParcelFileDescriptor zza;
    private Parcelable zzb = null;
    private boolean zzc = true;

    public zzcbb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza = parcelFileDescriptor;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        final ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe;
        if (this.zza == null) {
            Parcel parcelObtain = Parcel.obtain();
            try {
                this.zzb.writeToParcel(parcelObtain, 0);
                final byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                ParcelFileDescriptor parcelFileDescriptor = null;
                try {
                    parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
                    autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
                } catch (IOException e3) {
                    e = e3;
                    autoCloseOutputStream = null;
                }
                try {
                    zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcba
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() throws Throwable {
                            DataOutputStream dataOutputStream;
                            Parcelable.Creator<zzcbb> creator = zzcbb.CREATOR;
                            byte[] bArr = bArrMarshall;
                            OutputStream outputStream = autoCloseOutputStream;
                            DataOutputStream dataOutputStream2 = null;
                            try {
                                try {
                                    dataOutputStream = new DataOutputStream(outputStream);
                                } catch (IOException e4) {
                                    e = e4;
                                }
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                dataOutputStream.writeInt(bArr.length);
                                dataOutputStream.write(bArr);
                                IOUtils.a(dataOutputStream);
                            } catch (IOException e5) {
                                e = e5;
                                dataOutputStream2 = dataOutputStream;
                                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                                com.google.android.gms.ads.internal.util.client.zzo.d("Error transporting the ad response", e);
                                com.google.android.gms.ads.internal.zzt.l().zzg(e, "LargeParcelTeleporter.pipeData.1");
                                if (dataOutputStream2 == null) {
                                    IOUtils.a(outputStream);
                                } else {
                                    IOUtils.a(dataOutputStream2);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                dataOutputStream2 = dataOutputStream;
                                if (dataOutputStream2 == null) {
                                    IOUtils.a(outputStream);
                                } else {
                                    IOUtils.a(dataOutputStream2);
                                }
                                throw th;
                            }
                        }
                    });
                    parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
                } catch (IOException e4) {
                    e = e4;
                    int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.d("Error transporting the ad response", e);
                    com.google.android.gms.ads.internal.zzt.l().zzg(e, "LargeParcelTeleporter.pipeData.2");
                    IOUtils.a(autoCloseOutputStream);
                }
                this.zza = parcelFileDescriptor;
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        }
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, this.zza, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final SafeParcelable zza(Parcelable.Creator creator) {
        if (this.zzc) {
            if (this.zza == null) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.c("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zza));
            try {
                try {
                    int i4 = dataInputStream.readInt();
                    byte[] bArr = new byte[i4];
                    dataInputStream.readFully(bArr, 0, i4);
                    IOUtils.a(dataInputStream);
                    Parcel parcelObtain = Parcel.obtain();
                    try {
                        parcelObtain.unmarshall(bArr, 0, i4);
                        parcelObtain.setDataPosition(0);
                        this.zzb = (Parcelable) creator.createFromParcel(parcelObtain);
                        parcelObtain.recycle();
                        this.zzc = false;
                    } catch (Throwable th) {
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (IOException e3) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.d("Could not read from parcel file descriptor", e3);
                    IOUtils.a(dataInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                IOUtils.a(dataInputStream);
                throw th2;
            }
        }
        return (SafeParcelable) this.zzb;
    }
}
