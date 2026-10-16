package com.google.android.gms.internal.fido;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfo implements zzfn {
    zzfo() {
    }

    @Override // com.google.android.gms.internal.fido.zzfn
    public final StackTraceElement zza(Class cls, int i3) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String name = cls.getName();
        int i4 = 3;
        boolean z2 = false;
        while (true) {
            if (i4 >= stackTrace.length) {
                i4 = -1;
                break;
            }
            if (stackTrace[i4].getClassName().equals(name)) {
                z2 = true;
            } else {
                if (z2) {
                    break;
                }
                z2 = false;
            }
            i4++;
        }
        if (i4 != -1) {
            return stackTrace[i4];
        }
        return null;
    }
}
