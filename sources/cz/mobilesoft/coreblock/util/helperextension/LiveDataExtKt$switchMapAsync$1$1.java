package cz.mobilesoft.coreblock.util.helperextension;

import androidx.lifecycle.LiveDataScope;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.LiveDataExtKt$switchMapAsync$1$1", f = "LiveDataExt.kt", l = {17, 17}, m = "invokeSuspend", v = 1)
final class LiveDataExtKt$switchMapAsync$1$1 extends SuspendLambda implements Function2<LiveDataScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f128639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f128640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f128641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function2 f128642d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Object f128643f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LiveDataExtKt$switchMapAsync$1$1(Function2 function2, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f128642d = function2;
        this.f128643f = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LiveDataExtKt$switchMapAsync$1$1 liveDataExtKt$switchMapAsync$1$1 = new LiveDataExtKt$switchMapAsync$1$1(this.f128642d, this.f128643f, continuation);
        liveDataExtKt$switchMapAsync$1$1.f128641c = obj;
        return liveDataExtKt$switchMapAsync$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(LiveDataScope liveDataScope, Continuation continuation) {
        return ((LiveDataExtKt$switchMapAsync$1$1) create(liveDataScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
    
        if (r2.emit(r7, r6) == r1) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f128641c
            androidx.lifecycle.LiveDataScope r0 = (androidx.lifecycle.LiveDataScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r6.f128640b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L26
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            kotlin.ResultKt.b(r7)
            goto L51
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1e:
            java.lang.Object r2 = r6.f128639a
            androidx.lifecycle.LiveDataScope r2 = (androidx.lifecycle.LiveDataScope) r2
            kotlin.ResultKt.b(r7)
            goto L3f
        L26:
            kotlin.ResultKt.b(r7)
            kotlin.jvm.functions.Function2 r7 = r6.f128642d
            java.lang.Object r2 = r6.f128643f
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r6.f128641c = r5
            r6.f128639a = r0
            r6.f128640b = r4
            java.lang.Object r7 = r7.invoke(r2, r6)
            if (r7 != r1) goto L3e
            goto L50
        L3e:
            r2 = r0
        L3f:
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r6.f128641c = r0
            r0 = 0
            r6.f128639a = r0
            r6.f128640b = r3
            java.lang.Object r7 = r2.emit(r7, r6)
            if (r7 != r1) goto L51
        L50:
            return r1
        L51:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.helperextension.LiveDataExtKt$switchMapAsync$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
