package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CoroutineAdapterKt {
    public static final ListenableFuture b(final Deferred deferred, final Object obj) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        ListenableFuture listenableFutureA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.Resolver() { // from class: androidx.privacysandbox.ads.adservices.java.internal.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return CoroutineAdapterKt.d(deferred, obj, completer);
            }
        });
        Intrinsics.checkNotNullExpressionValue(listenableFutureA, "getFuture { completer ->…      }\n        tag\n    }");
        return listenableFutureA;
    }

    public static /* synthetic */ ListenableFuture c(Deferred deferred, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return b(deferred, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(final Deferred this_asListenableFuture, Object obj, final CallbackToFutureAdapter.Completer completer) {
        Intrinsics.checkNotNullParameter(this_asListenableFuture, "$this_asListenableFuture");
        Intrinsics.checkNotNullParameter(completer, "completer");
        this_asListenableFuture.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$asListenableFuture$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((Throwable) obj2);
                return Unit.f139807a;
            }

            public final void invoke(Throwable th) {
                if (th == null) {
                    completer.c(this_asListenableFuture.getCompleted());
                } else if (th instanceof CancellationException) {
                    completer.d();
                } else {
                    completer.f(th);
                }
            }
        });
        return obj;
    }
}
