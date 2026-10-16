package com.google.android.play.core.ktx;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class AppUpdateManagerKtxKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(com.google.android.play.core.appupdate.AppUpdateManager r4, kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1
            if (r0 == 0) goto L13
            r0 = r5
            com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1 r0 = (com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1) r0
            int r1 = r0.f83082b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f83082b = r1
            goto L18
        L13:
            com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1 r0 = new com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestAppUpdateInfo$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f83081a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f83082b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L48
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r5)
            com.google.android.gms.tasks.Task r4 = r4.a()
            java.lang.String r5 = "appUpdateInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r0.f83082b = r3
            r5 = 0
            r2 = 2
            java.lang.Object r5 = c(r4, r5, r0, r2, r5)
            if (r5 != r1) goto L48
            return r1
        L48:
            java.lang.String r4 = "runTask(appUpdateInfo)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.ktx.AppUpdateManagerKtxKt.a(com.google.android.play.core.appupdate.AppUpdateManager, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object b(Task task, final Function0 function0, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$runTask$3$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(Throwable th) {
                function0.invoke();
            }
        });
        if (!task.isComplete()) {
            task.addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$runTask$3$2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    cancellableContinuationImpl.resumeWith(Result.b(obj));
                }
            });
            task.addOnFailureListener(new OnFailureListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$runTask$3$3
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exception) {
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    cancellableContinuationImpl.resumeWith(Result.b(ResultKt.a(exception)));
                }
            });
        } else if (task.isSuccessful()) {
            cancellableContinuationImpl.resumeWith(Result.b(task.getResult()));
        } else {
            Exception exception = task.getException();
            Intrinsics.checkNotNull(exception);
            cancellableContinuationImpl.resumeWith(Result.b(ResultKt.a(exception)));
        }
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static /* synthetic */ Object c(Task task, Function0 function0, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$runTask$2
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m373invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Object invoke() {
                    m373invoke();
                    return Unit.f139807a;
                }
            };
        }
        return b(task, function0, continuation);
    }

    public static final boolean d(SendChannel sendChannel, Object obj) {
        Intrinsics.checkNotNullParameter(sendChannel, "<this>");
        return ChannelResult.k(sendChannel.h(obj));
    }
}
