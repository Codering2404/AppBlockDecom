package com.superwall.sdk.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AwaitUntilNetworkExistsKt {

    /* JADX INFO: renamed from: com.superwall.sdk.network.AwaitUntilNetworkExistsKt$awaitUntilNetworkExists$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.AwaitUntilNetworkExistsKt", f = "AwaitUntilNetworkExists.kt", l = {14, 16}, m = "awaitUntilNetworkExists")
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwaitUntilNetworkExistsKt.awaitUntilNetworkExists(null, 0L, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(r8, r0) == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitUntilNetworkExists(android.content.Context r7, long r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof com.superwall.sdk.network.AwaitUntilNetworkExistsKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            com.superwall.sdk.network.AwaitUntilNetworkExistsKt$awaitUntilNetworkExists$1 r0 = (com.superwall.sdk.network.AwaitUntilNetworkExistsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.network.AwaitUntilNetworkExistsKt$awaitUntilNetworkExists$1 r0 = new com.superwall.sdk.network.AwaitUntilNetworkExistsKt$awaitUntilNetworkExists$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r10)
            goto L63
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            long r7 = r0.J$0
            java.lang.Object r9 = r0.L$0
            android.content.Context r9 = (android.content.Context) r9
            kotlin.ResultKt.b(r10)
            r5 = r7
            r7 = r9
            r8 = r5
            goto L44
        L41:
            kotlin.ResultKt.b(r10)
        L44:
            boolean r10 = isNetworkAvailable(r7)
            if (r10 != 0) goto L57
            r0.L$0 = r7
            r0.J$0 = r8
            r0.label = r4
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r8, r0)
            if (r10 != r1) goto L44
            goto L62
        L57:
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.b(r8, r0)
            if (r7 != r1) goto L63
        L62:
            return r1
        L63:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.AwaitUntilNetworkExistsKt.awaitUntilNetworkExists(android.content.Context, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitUntilNetworkExists$default(Context context, long j3, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 1000;
        }
        return awaitUntilNetworkExists(context, j3, continuation);
    }

    private static final boolean hasNetworkPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
    }

    private static final boolean isNetworkAvailable(Context context) {
        NetworkCapabilities networkCapabilities;
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (!hasNetworkPermission(context)) {
            return true;
        }
        android.net.Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0);
    }
}
