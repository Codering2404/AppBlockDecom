package com.google.android.gms.tasks;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class NativeOnCompleteListener implements OnCompleteListener<Object> {
    private final long zza;

    public NativeOnCompleteListener(long j3) {
        this.zza = j3;
    }

    public static void createAndAddCallback(Task<Object> task, long j3) {
        task.addOnCompleteListener(new NativeOnCompleteListener(j3));
    }

    public native void nativeOnComplete(long j3, Object obj, boolean z2, boolean z3, String str);

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task<Object> task) {
        Object result;
        String message;
        Exception exception;
        if (task.isSuccessful()) {
            result = task.getResult();
            message = null;
        } else if (task.isCanceled() || (exception = task.getException()) == null) {
            result = null;
            message = null;
        } else {
            message = exception.getMessage();
            result = null;
        }
        nativeOnComplete(this.zza, result, task.isSuccessful(), task.isCanceled(), message);
    }
}
