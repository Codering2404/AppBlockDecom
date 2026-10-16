package cz.mobilesoft.appblock.service;

import android.view.accessibility.AccessibilityNodeInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$dismissPipWindowOf$1$1$dismissed$1", f = "LockAccessibilityService.kt", l = {}, m = "invokeSuspend", v = 1)
final class LockAccessibilityService$dismissPipWindowOf$1$1$dismissed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockAccessibilityService f94284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f94285c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockAccessibilityService$dismissPipWindowOf$1$1$dismissed$1(LockAccessibilityService lockAccessibilityService, String str, Continuation continuation) {
        super(2, continuation);
        this.f94284b = lockAccessibilityService;
        this.f94285c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LockAccessibilityService$dismissPipWindowOf$1$1$dismissed$1(this.f94284b, this.f94285c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f94283a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        AccessibilityNodeInfo accessibilityNodeInfoP0 = this.f94284b.P0(this.f94285c);
        if (accessibilityNodeInfoP0 != null) {
            return Boxing.a(accessibilityNodeInfoP0.performAction(1048576));
        }
        return null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockAccessibilityService$dismissPipWindowOf$1$1$dismissed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
