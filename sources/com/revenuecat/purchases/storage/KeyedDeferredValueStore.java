package com.revenuecat.purchases.storage;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class KeyedDeferredValueStore<H, T> {
    private final Map<H, Deferred<T>> deferred;
    private final Object lock;

    /* JADX WARN: Illegal instructions before constructor call */
    public KeyedDeferredValueStore() {
        DefaultConstructorMarker defaultConstructorMarker = null;
        this(defaultConstructorMarker, 1, defaultConstructorMarker);
    }

    private final Deferred<T> forgettingFailure(final H h3, Function0<? extends Deferred<? extends T>> function0) {
        Deferred<T> deferred = (Deferred) function0.invoke();
        deferred.invokeOnCompletion(new Function1<Throwable, Unit>(this) { // from class: com.revenuecat.purchases.storage.KeyedDeferredValueStore$forgettingFailure$1$1
            final /* synthetic */ KeyedDeferredValueStore<H, T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(Throwable th) {
                if (th != null) {
                    KeyedDeferredValueStore<H, T> keyedDeferredValueStore = this.this$0;
                    Object obj = h3;
                    synchronized (((KeyedDeferredValueStore) keyedDeferredValueStore).lock) {
                        keyedDeferredValueStore.getDeferred().remove(obj);
                        Unit unit = Unit.f139807a;
                    }
                }
            }
        });
        return deferred;
    }

    public final Map<H, Deferred<T>> getDeferred() {
        return this.deferred;
    }

    public final Deferred<T> getOrPut(H h3, Function0<? extends Deferred<? extends T>> task) {
        Deferred<T> deferredForgettingFailure;
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.lock) {
            deferredForgettingFailure = this.deferred.get(h3);
            if (deferredForgettingFailure == null) {
                deferredForgettingFailure = forgettingFailure(h3, task);
                this.deferred.put(h3, deferredForgettingFailure);
            }
        }
        return deferredForgettingFailure;
    }

    public KeyedDeferredValueStore(Object lock) {
        Intrinsics.checkNotNullParameter(lock, "lock");
        this.lock = lock;
        this.deferred = new LinkedHashMap();
    }

    public /* synthetic */ KeyedDeferredValueStore(Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Object() { // from class: com.revenuecat.purchases.storage.KeyedDeferredValueStore.1
        } : obj);
    }
}
