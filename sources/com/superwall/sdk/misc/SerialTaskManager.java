package com.superwall.sdk.misc;

import com.google.android.gms.common.api.Api;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

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
public final class SerialTaskManager {
    private final Channel<Function1<Continuation<? super Unit>, Object>> channel;
    private final CoroutineScope coroutineScope;

    /* JADX INFO: renamed from: com.superwall.sdk.misc.SerialTaskManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.misc.SerialTaskManager$1", f = "SerialTaskManager.kt", l = {17, 19}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SerialTaskManager.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
        
            if (r8.invoke(r7) == r0) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0080  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L28
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L16
                goto L5c
            L16:
                r8 = move-exception
                goto L65
            L18:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L20:
                java.lang.Object r1 = r7.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.b(r8)
                goto L43
            L28:
                kotlin.ResultKt.b(r8)
                com.superwall.sdk.misc.SerialTaskManager r8 = com.superwall.sdk.misc.SerialTaskManager.this
                kotlinx.coroutines.channels.Channel r8 = com.superwall.sdk.misc.SerialTaskManager.access$getChannel$p(r8)
                kotlinx.coroutines.channels.ChannelIterator r8 = r8.iterator()
            L35:
                r7.L$0 = r8
                r7.label = r3
                java.lang.Object r1 = r8.a(r7)
                if (r1 != r0) goto L40
                goto L5b
            L40:
                r6 = r1
                r1 = r8
                r8 = r6
            L43:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L80
                java.lang.Object r8 = r1.next()
                kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
                r7.L$0 = r1     // Catch: java.lang.Throwable -> L16
                r7.label = r2     // Catch: java.lang.Throwable -> L16
                java.lang.Object r8 = r8.invoke(r7)     // Catch: java.lang.Throwable -> L16
                if (r8 != r0) goto L5c
            L5b:
                return r0
            L5c:
                kotlin.Unit r8 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L16
                com.superwall.sdk.misc.Either$Success r4 = new com.superwall.sdk.misc.Either$Success     // Catch: java.lang.Throwable -> L16
                r4.<init>(r8)     // Catch: java.lang.Throwable -> L16
            L63:
                r8 = r1
                goto L35
            L65:
                boolean r4 = com.superwall.sdk.utilities.ErrorTrackingKt.shouldLog(r8)
                if (r4 == 0) goto L7a
                com.superwall.sdk.Superwall$Companion r4 = com.superwall.sdk.Superwall.Companion
                boolean r5 = r4.getInitialized()
                if (r5 == 0) goto L7a
                com.superwall.sdk.Superwall r4 = r4.getInstance()
                com.superwall.sdk.utilities.ErrorTrackingKt.trackError(r4, r8)
            L7a:
                com.superwall.sdk.misc.Either$Failure r4 = new com.superwall.sdk.misc.Either$Failure
                r4.<init>(r8)
                goto L63
            L80:
                kotlin.Unit r8 = kotlin.Unit.f139807a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.misc.SerialTaskManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SerialTaskManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void addTask(Function1<? super Continuation<? super Unit>, ? extends Object> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (ChannelResult.j(this.channel.h(task))) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.superwallCore, "SerialTaskManager: failed to enqueue task — channel closed", (Map) null, (Throwable) null, 24, (Object) null);
        }
    }

    public SerialTaskManager(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        this.channel = ChannelKt.b(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, null, 6, null);
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    public /* synthetic */ SerialTaskManager(CoroutineScope coroutineScope, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CoroutineScopeKt.a(Dispatchers.b()) : coroutineScope);
    }
}
