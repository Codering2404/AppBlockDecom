package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zacz extends com.google.android.gms.internal.base.zau {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zada f71818a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zacz(zada zadaVar, Looper looper) {
        super(looper);
        this.f71818a = zadaVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 == 1) {
                RuntimeException runtimeException = (RuntimeException) message.obj;
                Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: ".concat(String.valueOf(runtimeException.getMessage())));
                throw runtimeException;
            }
            Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + i3);
            return;
        }
        PendingResult pendingResult = (PendingResult) message.obj;
        synchronized (this.f71818a.f71824f) {
            try {
                zada zadaVar = (zada) Preconditions.m(this.f71818a.f71821b);
                if (pendingResult == null) {
                    zadaVar.l(new Status(13, "Transform returned null"));
                } else if (pendingResult instanceof zacp) {
                    zadaVar.l(((zacp) pendingResult).a());
                } else {
                    zadaVar.k(pendingResult);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
