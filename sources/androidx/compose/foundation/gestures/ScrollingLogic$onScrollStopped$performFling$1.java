package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$onScrollStopped$performFling$1", f = "Scrollable.kt", l = {748, 751, 754}, m = "invokeSuspend")
final class ScrollingLogic$onScrollStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f6175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f6176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ long f6177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ScrollingLogic f6178d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollingLogic$onScrollStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation continuation) {
        super(2, continuation);
        this.f6178d = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScrollingLogic$onScrollStopped$performFling$1 scrollingLogic$onScrollStopped$performFling$1 = new ScrollingLogic$onScrollStopped$performFling$1(this.f6178d, continuation);
        scrollingLogic$onScrollStopped$performFling$1.f6177c = ((Velocity) obj).o();
        return scrollingLogic$onScrollStopped$performFling$1;
    }

    public final Object h(long j3, Continuation continuation) {
        return ((ScrollingLogic$onScrollStopped$performFling$1) create(Velocity.b(j3), continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return h(((Velocity) obj).o(), (Continuation) obj2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
    
        if (r0 != r6) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r13.f6176b
            r1 = 3
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L35
            if (r0 == r3) goto L2e
            if (r0 == r2) goto L25
            if (r0 != r1) goto L1d
            long r0 = r13.f6175a
            long r2 = r13.f6177c
            kotlin.ResultKt.b(r14)
            r7 = r2
            r3 = r0
            r0 = r14
            goto L88
        L1d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L25:
            long r2 = r13.f6175a
            long r7 = r13.f6177c
            kotlin.ResultKt.b(r14)
            r0 = r14
            goto L68
        L2e:
            long r3 = r13.f6177c
            kotlin.ResultKt.b(r14)
            r0 = r14
            goto L4c
        L35:
            kotlin.ResultKt.b(r14)
            long r7 = r13.f6177c
            androidx.compose.foundation.gestures.ScrollingLogic r0 = r13.f6178d
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r0 = androidx.compose.foundation.gestures.ScrollingLogic.c(r0)
            r13.f6177c = r7
            r13.f6176b = r3
            java.lang.Object r0 = r0.c(r7, r13)
            if (r0 != r6) goto L4b
            goto L87
        L4b:
            r3 = r7
        L4c:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r7 = r0.o()
            long r7 = androidx.compose.ui.unit.Velocity.k(r3, r7)
            androidx.compose.foundation.gestures.ScrollingLogic r0 = r13.f6178d
            r13.f6177c = r3
            r13.f6175a = r7
            r13.f6176b = r2
            java.lang.Object r0 = r0.p(r7, r13)
            if (r0 != r6) goto L65
            goto L87
        L65:
            r11 = r7
            r7 = r3
            r2 = r11
        L68:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r9 = r0.o()
            androidx.compose.foundation.gestures.ScrollingLogic r0 = r13.f6178d
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r0 = androidx.compose.foundation.gestures.ScrollingLogic.c(r0)
            long r2 = androidx.compose.ui.unit.Velocity.k(r2, r9)
            r13.f6177c = r7
            r13.f6175a = r9
            r13.f6176b = r1
            r5 = r13
            r1 = r2
            r3 = r9
            java.lang.Object r0 = r0.a(r1, r3, r5)
            if (r0 != r6) goto L88
        L87:
            return r6
        L88:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r0 = r0.o()
            long r0 = androidx.compose.ui.unit.Velocity.k(r3, r0)
            long r0 = androidx.compose.ui.unit.Velocity.k(r7, r0)
            androidx.compose.ui.unit.Velocity r0 = androidx.compose.ui.unit.Velocity.b(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic$onScrollStopped$performFling$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
