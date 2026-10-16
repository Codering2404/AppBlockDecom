package androidx.media3.datasource;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DataSourceException extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f41822a;

    public DataSourceException(int i3) {
        this.f41822a = i3;
    }

    public static boolean a(IOException iOException) {
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof DataSourceException) && ((DataSourceException) cause).f41822a == 2008) {
                return true;
            }
        }
        return false;
    }

    public DataSourceException(Throwable th, int i3) {
        super(th);
        this.f41822a = i3;
    }

    public DataSourceException(String str, int i3) {
        super(str);
        this.f41822a = i3;
    }

    public DataSourceException(String str, Throwable th, int i3) {
        super(str, th);
        this.f41822a = i3;
    }
}
