package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.android.volley.NetworkResponse;
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

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzgg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RequestQueue f77852a;

    zzgg(RequestQueue requestQueue) {
        this.f77852a = requestQueue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(TaskCompletionSource taskCompletionSource, VolleyError volleyError) {
        ApiException apiExceptionA;
        try {
            NetworkResponse networkResponse = volleyError.f57722a;
            if (networkResponse != null) {
                int i3 = networkResponse.f57676a;
                apiExceptionA = i3 != 400 ? i3 != 403 ? zzfu.a(volleyError) : new ApiException(new Status(9011, "The provided API key is invalid.")) : new ApiException(new Status(9012, "The provided parameters are invalid (did you include a max width or height?)."));
            }
            taskCompletionSource.trySetException(apiExceptionA);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(zzkm zzkmVar, TaskCompletionSource taskCompletionSource, Bitmap bitmap) {
        try {
            zzkmVar.b(bitmap);
            taskCompletionSource.trySetResult(zzkmVar.a());
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    public final Task b(zzgi zzgiVar, final zzkm zzkmVar) {
        String strD = zzgiVar.d();
        Map mapC = zzgiVar.c();
        CancellationToken cancellationTokenB = zzgiVar.b();
        final TaskCompletionSource taskCompletionSource = cancellationTokenB != null ? new TaskCompletionSource(cancellationTokenB) : new TaskCompletionSource();
        final zzgc zzgcVar = new zzgc(this, strD, new Response.Listener() { // from class: com.google.android.libraries.places.internal.zzge
            @Override // com.android.volley.Response.Listener
            public final /* synthetic */ void b(Object obj) {
                zzgg.e(zzkmVar, taskCompletionSource, (Bitmap) obj);
            }
        }, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, new Response.ErrorListener() { // from class: com.google.android.libraries.places.internal.zzgd
            @Override // com.android.volley.Response.ErrorListener
            public final /* synthetic */ void c(VolleyError volleyError) {
                zzgg.d(taskCompletionSource, volleyError);
            }
        }, mapC);
        if (cancellationTokenB != null) {
            cancellationTokenB.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzgf
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final /* synthetic */ void onCanceled() {
                    zzgcVar.c();
                }
            });
        }
        this.f77852a.a(zzgcVar);
        return taskCompletionSource.getTask();
    }
}
