package androidx.glance.session;

import android.content.Context;
import androidx.glance.EmittableWithChildren;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class Session {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Channel f39575b = ChannelKt.b(Api.BaseClientBuilder.API_PRIORITY_OTHER, null, null, 6, null);

    public Session(String str) {
        this.f39574a = str;
    }

    public final void a() {
        SendChannel.DefaultImpls.a(this.f39575b, null, 1, null);
    }

    public abstract EmittableWithChildren b();

    public final String c() {
        return this.f39574a;
    }

    public abstract Object d(Context context, EmittableWithChildren emittableWithChildren, Continuation continuation);

    public abstract Object e(Context context, Object obj, Continuation continuation);

    public abstract Function2 f(Context context);

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0098, code lost:
    
        if (r5.e(r2, r10, r0) == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0083 A[Catch: ClosedReceiveChannelException -> 0x009b, TRY_LEAVE, TryCatch #0 {ClosedReceiveChannelException -> 0x009b, blocks: (B:13:0x0038, B:22:0x0065, B:26:0x007b, B:28:0x0083, B:18:0x0057, B:21:0x005e), top: B:34:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0098 -> B:14:0x003b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(android.content.Context r8, kotlin.jvm.functions.Function1 r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.glance.session.Session$receiveEvents$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.glance.session.Session$receiveEvents$1 r0 = (androidx.glance.session.Session$receiveEvents$1) r0
            int r1 = r0.f39582h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39582h = r1
            goto L18
        L13:
            androidx.glance.session.Session$receiveEvents$1 r0 = new androidx.glance.session.Session$receiveEvents$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f39580f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f39582h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5b
            if (r2 == r4) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r8 = r0.f39579d
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r0.f39578c
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r2 = r0.f39577b
            android.content.Context r2 = (android.content.Context) r2
            java.lang.Object r5 = r0.f39576a
            androidx.glance.session.Session r5 = (androidx.glance.session.Session) r5
            kotlin.ResultKt.b(r10)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
        L3b:
            r10 = r8
            r8 = r2
            r2 = r5
            goto L65
        L3f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L47:
            java.lang.Object r8 = r0.f39579d
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r0.f39578c
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r2 = r0.f39577b
            android.content.Context r2 = (android.content.Context) r2
            java.lang.Object r5 = r0.f39576a
            androidx.glance.session.Session r5 = (androidx.glance.session.Session) r5
            kotlin.ResultKt.b(r10)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            goto L7b
        L5b:
            kotlin.ResultKt.b(r10)
            kotlinx.coroutines.channels.Channel r10 = r7.f39575b     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            kotlinx.coroutines.channels.ChannelIterator r10 = r10.iterator()     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            r2 = r7
        L65:
            r0.f39576a = r2     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            r0.f39577b = r8     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            r0.f39578c = r9     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            r0.f39579d = r10     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            r0.f39582h = r4     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            java.lang.Object r5 = r10.a(r0)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            if (r5 != r1) goto L76
            goto L9a
        L76:
            r6 = r2
            r2 = r8
            r8 = r10
            r10 = r5
            r5 = r6
        L7b:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            boolean r10 = r10.booleanValue()     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            if (r10 == 0) goto L9b
            java.lang.Object r10 = r8.next()     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            r9.invoke(r10)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            r0.f39576a = r5     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            r0.f39577b = r2     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            r0.f39578c = r9     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            r0.f39579d = r8     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            r0.f39582h = r3     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            java.lang.Object r10 = r5.e(r2, r10, r0)     // Catch: kotlinx.coroutines.channels.ClosedReceiveChannelException -> L9b
            if (r10 != r1) goto L3b
        L9a:
            return r1
        L9b:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.session.Session.g(android.content.Context, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    protected final Object h(Object obj, Continuation continuation) {
        Object objY = this.f39575b.y(obj, continuation);
        return objY == IntrinsicsKt.f() ? objY : Unit.f139807a;
    }
}
