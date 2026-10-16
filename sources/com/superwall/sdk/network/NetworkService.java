package com.superwall.sdk.network;

import com.superwall.sdk.misc.Either;
import com.superwall.sdk.misc.Task_RetryingKt;
import com.superwall.sdk.network.session.CustomHttpUrlConnection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class NetworkService {
    /* JADX INFO: renamed from: get-rl3MWlM$default, reason: not valid java name */
    public static /* synthetic */ Object m1314getrl3MWlM$default(NetworkService networkService, String str, List list, boolean z2, String str2, int i3, Function1 function1, Duration duration, Continuation continuation, int i4, Object obj) throws Throwable {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get-rl3MWlM");
        }
        List list2 = (i4 & 2) != 0 ? null : list;
        boolean z3 = (i4 & 4) != 0 ? false : z2;
        String string = (i4 & 8) != 0 ? UUID.randomUUID().toString() : str2;
        int iRetryCount = (i4 & 16) != 0 ? NetworkConsts.INSTANCE.retryCount() : i3;
        Function1 function12 = (i4 & 32) != 0 ? null : function1;
        Duration duration2 = (i4 & 64) != 0 ? null : duration;
        CustomHttpUrlConnection customHttpUrlConnection = networkService.getCustomHttpUrlConnection();
        Intrinsics.needClassReification();
        NetworkService$getrl3MWlM$$inlined$request$1 networkService$getrl3MWlM$$inlined$request$1 = new NetworkService$getrl3MWlM$$inlined$request$1(customHttpUrlConnection, null, networkService, str, list2, string, z3, duration2);
        InlineMarker.c(0);
        Object objRetrying = Task_RetryingKt.retrying(iRetryCount, function12, networkService$getrl3MWlM$$inlined$request$1, continuation);
        InlineMarker.c(1);
        return objRetrying;
    }

    /* JADX INFO: renamed from: post-7Yrd8eY$default, reason: not valid java name */
    public static /* synthetic */ Object m1315post7Yrd8eY$default(NetworkService networkService, String str, boolean z2, byte[] bArr, String str2, int i3, Duration duration, Continuation continuation, int i4, Object obj) throws Throwable {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: post-7Yrd8eY");
        }
        boolean z3 = (i4 & 2) != 0 ? false : z2;
        byte[] bArr2 = (i4 & 4) != 0 ? null : bArr;
        String string = (i4 & 8) != 0 ? UUID.randomUUID().toString() : str2;
        int i5 = (i4 & 16) != 0 ? 6 : i3;
        Duration duration2 = (i4 & 32) != 0 ? null : duration;
        CustomHttpUrlConnection customHttpUrlConnection = networkService.getCustomHttpUrlConnection();
        Intrinsics.needClassReification();
        NetworkService$post7Yrd8eY$$inlined$request$default$1 networkService$post7Yrd8eY$$inlined$request$default$1 = new NetworkService$post7Yrd8eY$$inlined$request$default$1(customHttpUrlConnection, null, networkService, str, bArr2, string, z3, duration2);
        InlineMarker.c(0);
        Object objRetrying = Task_RetryingKt.retrying(i5, null, networkService$post7Yrd8eY$$inlined$request$default$1, continuation);
        InlineMarker.c(1);
        return objRetrying;
    }

    /* JADX INFO: renamed from: get-rl3MWlM, reason: not valid java name */
    public final /* synthetic */ <T> Object m1316getrl3MWlM(String str, List<URLQueryItem> list, boolean z2, String str2, int i3, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Duration duration, Continuation<? super Either<? extends T, NetworkError>> continuation) throws Throwable {
        CustomHttpUrlConnection customHttpUrlConnection = getCustomHttpUrlConnection();
        Intrinsics.needClassReification();
        NetworkService$getrl3MWlM$$inlined$request$1 networkService$getrl3MWlM$$inlined$request$1 = new NetworkService$getrl3MWlM$$inlined$request$1(customHttpUrlConnection, null, this, str, list, str2, z2, duration);
        InlineMarker.c(0);
        Object objRetrying = Task_RetryingKt.retrying(i3, function1, networkService$getrl3MWlM$$inlined$request$1, continuation);
        InlineMarker.c(1);
        return objRetrying;
    }

    public abstract CustomHttpUrlConnection getCustomHttpUrlConnection();

    public abstract String getHost();

    public abstract String getVersion();

    public abstract Object makeHeaders(boolean z2, String str, Continuation<? super Map<String, String>> continuation);

    /* JADX INFO: renamed from: post-7Yrd8eY, reason: not valid java name */
    public final /* synthetic */ <T> Object m1317post7Yrd8eY(String str, boolean z2, byte[] bArr, String str2, int i3, Duration duration, Continuation<? super Either<? extends T, NetworkError>> continuation) throws Throwable {
        CustomHttpUrlConnection customHttpUrlConnection = getCustomHttpUrlConnection();
        Intrinsics.needClassReification();
        NetworkService$post7Yrd8eY$$inlined$request$default$1 networkService$post7Yrd8eY$$inlined$request$default$1 = new NetworkService$post7Yrd8eY$$inlined$request$default$1(customHttpUrlConnection, null, this, str, bArr, str2, z2, duration);
        InlineMarker.c(0);
        Object objRetrying = Task_RetryingKt.retrying(i3, null, networkService$post7Yrd8eY$$inlined$request$default$1, continuation);
        InlineMarker.c(1);
        return objRetrying;
    }
}
