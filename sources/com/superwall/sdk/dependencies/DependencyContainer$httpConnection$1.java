package com.superwall.sdk.dependencies;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

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
@DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$httpConnection$1", f = "DependencyContainer.kt", l = {352}, m = "invokeSuspend")
final class DependencyContainer$httpConnection$1 extends SuspendLambda implements Function3<Boolean, String, Continuation<? super Map<String, ? extends String>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DependencyContainer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DependencyContainer$httpConnection$1(DependencyContainer dependencyContainer, Continuation<? super DependencyContainer$httpConnection$1> continuation) {
        super(3, continuation);
        this.this$0 = dependencyContainer;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Boolean) obj).booleanValue(), (String) obj2, (Continuation<? super Map<String, String>>) obj3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        boolean z2 = this.Z$0;
        String str = (String) this.L$0;
        DependencyContainer dependencyContainer = this.this$0;
        this.label = 1;
        Object objMakeHeaders = dependencyContainer.makeHeaders(z2, str, this);
        return objMakeHeaders == objF ? objF : objMakeHeaders;
    }

    public final Object invoke(boolean z2, String str, Continuation<? super Map<String, String>> continuation) {
        DependencyContainer$httpConnection$1 dependencyContainer$httpConnection$1 = new DependencyContainer$httpConnection$1(this.this$0, continuation);
        dependencyContainer$httpConnection$1.Z$0 = z2;
        dependencyContainer$httpConnection$1.L$0 = str;
        return dependencyContainer$httpConnection$1.invokeSuspend(Unit.f139807a);
    }
}
