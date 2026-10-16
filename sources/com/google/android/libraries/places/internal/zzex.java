package com.google.android.libraries.places.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f77801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ListeningExecutorService f77802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ListenableFuture f77803c;

    public zzex(Context context, ListeningExecutorService backgroundExecutorService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(backgroundExecutorService, "backgroundExecutorService");
        this.f77801a = context;
        this.f77802b = backgroundExecutorService;
        ListenableFuture listenableFutureSubmit = backgroundExecutorService.submit(new Callable() { // from class: com.google.android.libraries.places.internal.zzew
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.f77800a.f77801a.getSharedPreferences("com.google.geo_sdk.PREFERENCES_FILE", 0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(listenableFutureSubmit, "submit(...)");
        this.f77803c = listenableFutureSubmit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        String string = sharedPreferences.getString("zb", "");
        return string == null ? "" : string;
    }

    public final ListenableFuture a() {
        final zzes zzesVar = zzes.f77796a;
        ListenableFuture listenableFutureH = Futures.h(this.f77803c, new Function() { // from class: com.google.android.libraries.places.internal.zzet
            @Override // com.google.common.base.Function
            public final /* synthetic */ Object apply(Object obj) {
                Function1 function1 = zzesVar;
                return zzex.f((SharedPreferences) obj);
            }
        }, this.f77802b);
        Intrinsics.checkNotNullExpressionValue(listenableFutureH, "transform(...)");
        return listenableFutureH;
    }

    public final void b(final String zwiebackCookie) {
        Intrinsics.checkNotNullParameter(zwiebackCookie, "zwiebackCookie");
        final Function1 function1 = new Function1() { // from class: com.google.android.libraries.places.internal.zzeu
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                SharedPreferences.Editor editorPutString;
                SharedPreferences sharedPreferences = (SharedPreferences) obj;
                Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                if (editorEdit == null || (editorPutString = editorEdit.putString("zb", zwiebackCookie)) == null) {
                    return null;
                }
                editorPutString.apply();
                return Unit.f139807a;
            }
        };
        Intrinsics.checkNotNullExpressionValue(Futures.h(this.f77803c, new Function() { // from class: com.google.android.libraries.places.internal.zzev
            @Override // com.google.common.base.Function
            public final /* synthetic */ Object apply(Object obj) {
                return (Unit) function1.invoke(obj);
            }
        }, this.f77802b), "transform(...)");
    }
}
