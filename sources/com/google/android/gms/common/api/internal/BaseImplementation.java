package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BaseImplementation {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ResultHolder<R> {
        void setFailedResult(Status status);

        void setResult(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class ApiMethodImpl<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> implements ResultHolder<R> {
        private final Api<?> api;
        private final Api.AnyClientKey<A> clientKey;

        protected ApiMethodImpl(Api api, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.n(googleApiClient, "GoogleApiClient must not be null"));
            Preconditions.n(api, "Api must not be null");
            this.clientKey = api.b();
            this.api = api;
        }

        private void c(RemoteException remoteException) {
            setFailedResult(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        protected abstract void doExecute(A a3) throws RemoteException;

        public final Api<?> getApi() {
            return this.api;
        }

        public final Api.AnyClientKey<A> getClientKey() {
            return this.clientKey;
        }

        public final void run(A a3) throws DeadObjectException {
            try {
                doExecute(a3);
            } catch (DeadObjectException e3) {
                c(e3);
                throw e3;
            } catch (RemoteException e4) {
                c(e4);
            }
        }

        @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
        public final void setFailedResult(Status status) {
            Preconditions.b(!status.w0(), "Failed result must not be success");
            Result resultCreateFailedResult = createFailedResult(status);
            setResult(resultCreateFailedResult);
            onSetFailedResult(resultCreateFailedResult);
        }

        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((Result) obj);
        }

        protected void onSetFailedResult(R r2) {
        }
    }
}
