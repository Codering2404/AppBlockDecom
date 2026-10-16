package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RemoteCreator<T> {
    private final String zza;
    private Object zzb;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    protected RemoteCreator(String str) {
        this.zza = str;
    }

    protected abstract Object getRemoteCreator(IBinder iBinder);

    protected final T getRemoteCreatorInstance(Context context) throws RemoteCreatorException {
        if (this.zzb == null) {
            Preconditions.m(context);
            Context contextE = GooglePlayServicesUtilLight.e(context);
            if (contextE == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.zzb = getRemoteCreator((IBinder) contextE.getClassLoader().loadClass(this.zza).newInstance());
            } catch (ClassNotFoundException e3) {
                throw new RemoteCreatorException("Could not load creator class.", e3);
            } catch (IllegalAccessException e4) {
                throw new RemoteCreatorException("Could not access creator.", e4);
            } catch (InstantiationException e5) {
                throw new RemoteCreatorException("Could not instantiate creator.", e5);
            }
        }
        return (T) this.zzb;
    }
}
