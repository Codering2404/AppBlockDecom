package com.google.firebase.remoteconfig;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.ChannelsKt;
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
public final class RemoteConfigKt$configUpdates$1$registration$1 implements ConfigUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ FirebaseRemoteConfig f89669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProducerScope f89670b;

    RemoteConfigKt$configUpdates$1$registration$1(FirebaseRemoteConfig firebaseRemoteConfig, ProducerScope producerScope) {
        this.f89669a = firebaseRemoteConfig;
        this.f89670b = producerScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ProducerScope producerScope, ConfigUpdate configUpdate) {
        ChannelsKt.w(producerScope, configUpdate);
    }

    @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
    public void a(final ConfigUpdate configUpdate) {
        Intrinsics.checkNotNullParameter(configUpdate, "configUpdate");
        FirebaseRemoteConfig firebaseRemoteConfig = this.f89669a;
        final ProducerScope producerScope = this.f89670b;
        firebaseRemoteConfig.u(new Runnable() { // from class: com.google.firebase.remoteconfig.k
            @Override // java.lang.Runnable
            public final void run() {
                RemoteConfigKt$configUpdates$1$registration$1.d(producerScope, configUpdate);
            }
        });
    }

    @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
    public void b(FirebaseRemoteConfigException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        CoroutineScopeKt.c(this.f89670b, "Error listening for config updates.", error);
    }
}
