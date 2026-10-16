package com.google.firebase.remoteconfig;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

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
@DebugMetadata(c = "com.google.firebase.remoteconfig.RemoteConfigKt$configUpdates$1", f = "RemoteConfig.kt", l = {76}, m = "invokeSuspend")
final class RemoteConfigKt$configUpdates$1 extends SuspendLambda implements Function2<ProducerScope<? super ConfigUpdate>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f89666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f89667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FirebaseRemoteConfig f89668c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteConfigKt$configUpdates$1(FirebaseRemoteConfig firebaseRemoteConfig, Continuation continuation) {
        super(2, continuation);
        this.f89668c = firebaseRemoteConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(ConfigUpdateListenerRegistration configUpdateListenerRegistration) {
        configUpdateListenerRegistration.remove();
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RemoteConfigKt$configUpdates$1 remoteConfigKt$configUpdates$1 = new RemoteConfigKt$configUpdates$1(this.f89668c, continuation);
        remoteConfigKt$configUpdates$1.f89667b = obj;
        return remoteConfigKt$configUpdates$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f89666a;
        if (i3 == 0) {
            ResultKt.b(obj);
            ProducerScope producerScope = (ProducerScope) this.f89667b;
            FirebaseRemoteConfig firebaseRemoteConfig = this.f89668c;
            final ConfigUpdateListenerRegistration configUpdateListenerRegistrationH = firebaseRemoteConfig.h(new RemoteConfigKt$configUpdates$1$registration$1(firebaseRemoteConfig, producerScope));
            Intrinsics.checkNotNullExpressionValue(configUpdateListenerRegistrationH, "addOnConfigUpdateListener(...)");
            Function0 function0 = new Function0() { // from class: com.google.firebase.remoteconfig.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return RemoteConfigKt$configUpdates$1.y(configUpdateListenerRegistrationH);
                }
            };
            this.f89666a = 1;
            if (ProduceKt.a(producerScope, function0, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((RemoteConfigKt$configUpdates$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
