package com.google.firebase.datastorage;

import androidx.datastore.preferences.core.Preferences;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
@DebugMetadata(c = "com.google.firebase.datastorage.JavaDataStorage$getAllSync$1", f = "JavaDataStorage.kt", l = {170}, m = "invokeSuspend")
final class JavaDataStorage$getAllSync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<Preferences.Key<?>, ? extends Object>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f89114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ JavaDataStorage f89115b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JavaDataStorage$getAllSync$1(JavaDataStorage javaDataStorage, Continuation continuation) {
        super(2, continuation);
        this.f89115b = javaDataStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new JavaDataStorage$getAllSync$1(this.f89115b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Map mapA;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f89114a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow data = this.f89115b.f89104e.getData();
            this.f89114a = 1;
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
        return (preferences == null || (mapA = preferences.a()) == null) ? MapsKt.emptyMap() : mapA;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((JavaDataStorage$getAllSync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
