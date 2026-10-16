package com.google.android.libraries.places.internal;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RequestQueue f77845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzlc f77846b;

    zzga(RequestQueue requestQueue, zzlc zzlcVar) {
        this.f77845a = requestQueue;
        this.f77846b = zzlcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(TaskCompletionSource taskCompletionSource, VolleyError volleyError) {
        try {
            taskCompletionSource.trySetException(zzfu.a(volleyError));
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void b(Class cls, TaskCompletionSource taskCompletionSource, JSONObject jSONObject) {
        try {
            try {
                taskCompletionSource.trySetResult((zzgj) this.f77846b.a(jSONObject.toString(), cls));
            } catch (zzgk e3) {
                taskCompletionSource.trySetException(new ApiException(new Status(8, e3.getMessage())));
            }
        } catch (Error | RuntimeException e4) {
            zznb.b(e4);
            throw e4;
        }
    }

    public final Task a(zzgi zzgiVar, final Class cls) {
        String strD = zzgiVar.d();
        Map mapC = zzgiVar.c();
        CancellationToken cancellationTokenB = zzgiVar.b();
        final TaskCompletionSource taskCompletionSource = cancellationTokenB != null ? new TaskCompletionSource(cancellationTokenB) : new TaskCompletionSource();
        final zzfw zzfwVar = new zzfw(this, 0, strD, null, new Response.Listener() { // from class: com.google.android.libraries.places.internal.zzfy
            @Override // com.android.volley.Response.Listener
            public final /* synthetic */ void b(Object obj) {
                this.f77841a.b(cls, taskCompletionSource, (JSONObject) obj);
            }
        }, new Response.ErrorListener() { // from class: com.google.android.libraries.places.internal.zzfx
            @Override // com.android.volley.Response.ErrorListener
            public final /* synthetic */ void c(VolleyError volleyError) {
                zzga.d(taskCompletionSource, volleyError);
            }
        }, mapC);
        if (cancellationTokenB != null) {
            cancellationTokenB.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzfz
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final /* synthetic */ void onCanceled() {
                    zzfwVar.c();
                }
            });
        }
        this.f77845a.a(zzfwVar);
        return taskCompletionSource.getTask();
    }
}
