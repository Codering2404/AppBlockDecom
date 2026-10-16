package dev.doubledot.doki.api.tasks;

import dev.doubledot.doki.api.extensions.ConstantsKt;
import dev.doubledot.doki.api.models.DokiManufacturer;
import dev.doubledot.doki.api.remote.DokiApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import retrofit2.HttpException;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public class DokiApi {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.i(new PropertyReference1Impl(Reflection.b(DokiApi.class), "dokiApiService", "getDokiApiService()Ldev/doubledot/doki/api/remote/DokiApiService;"))};
    private DokiApiCallback callback;
    private Disposable disposable;
    private final Lazy dokiApiService$delegate = LazyKt.b(new Function0<DokiApiService>() { // from class: dev.doubledot.doki.api.tasks.DokiApi$dokiApiService$2
        @Override // kotlin.jvm.functions.Function0
        public final DokiApiService invoke() {
            return DokiApiService.Companion.create();
        }
    });
    private boolean shouldFallback = true;

    public static /* synthetic */ void getManufacturer$default(DokiApi dokiApi, String str, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getManufacturer");
        }
        if ((i3 & 1) != 0) {
            str = ConstantsKt.getDONT_KILL_MY_APP_DEFAULT_MANUFACTURER();
        }
        dokiApi.getManufacturer(str);
    }

    public final void cancel() {
        Disposable disposable = this.disposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.disposable = null;
    }

    public final DokiApiCallback getCallback() {
        return this.callback;
    }

    public final Disposable getDisposable() {
        return this.disposable;
    }

    public final DokiApiService getDokiApiService() {
        Lazy lazy = this.dokiApiService$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (DokiApiService) lazy.getValue();
    }

    public final void getManufacturer(String manufacturer) {
        Intrinsics.checkParameterIsNotNull(manufacturer, "manufacturer");
        this.disposable = getDokiApiService().getManufacturer(manufacturer).v(Schedulers.a()).k(AndroidSchedulers.a()).s(new Consumer<DokiManufacturer>() { // from class: dev.doubledot.doki.api.tasks.DokiApi.getManufacturer.1
            @Override // io.reactivex.functions.Consumer
            public final void accept(DokiManufacturer result) {
                Intrinsics.checkParameterIsNotNull(result, "result");
                DokiApiCallback callback = DokiApi.this.getCallback();
                if (callback != null) {
                    callback.onSuccess(result);
                }
            }
        }, new Consumer<Throwable>() { // from class: dev.doubledot.doki.api.tasks.DokiApi.getManufacturer.2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Throwable th) {
                HttpException httpException = (HttpException) (!(th instanceof HttpException) ? null : th);
                if (httpException != null && httpException.a() == 404 && DokiApi.this.getShouldFallback()) {
                    DokiApi.this.getManufacturer(ConstantsKt.DONT_KILL_MY_APP_FALLBACK_MANUFACTURER);
                    DokiApi.this.setShouldFallback(false);
                } else {
                    DokiApiCallback callback = DokiApi.this.getCallback();
                    if (callback != null) {
                        callback.onError(th);
                    }
                }
            }
        });
        DokiApiCallback dokiApiCallback = this.callback;
        if (dokiApiCallback != null) {
            dokiApiCallback.onStart();
        }
    }

    public final boolean getShouldFallback() {
        return this.shouldFallback;
    }

    public final void setCallback(DokiApiCallback dokiApiCallback) {
        this.callback = dokiApiCallback;
    }

    public final void setDisposable(Disposable disposable) {
        this.disposable = disposable;
    }

    public final void setShouldFallback(boolean z2) {
        this.shouldFallback = z2;
    }
}
