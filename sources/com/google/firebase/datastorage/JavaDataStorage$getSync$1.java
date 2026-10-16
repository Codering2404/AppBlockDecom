package com.google.firebase.datastorage;

import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "com.google.firebase.datastorage.JavaDataStorage$getSync$1", f = "JavaDataStorage.kt", l = {104}, m = "invokeSuspend")
final class JavaDataStorage$getSync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f89116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ JavaDataStorage f89117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Preferences.Key f89118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Object f89119d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JavaDataStorage$getSync$1(JavaDataStorage javaDataStorage, Preferences.Key key, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f89117b = javaDataStorage;
        this.f89118c = key;
        this.f89119d = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new JavaDataStorage$getSync$1(this.f89117b, this.f89118c, this.f89119d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objC;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f89116a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow data = this.f89117b.f89104e.getData();
            this.f89116a = 1;
            obj = FlowKt.F(data, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Preferences preferences = (Preferences) obj;
        return (preferences == null || (objC = preferences.c(this.f89118c)) == null) ? this.f89119d : objC;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((JavaDataStorage$getSync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
