package com.google.maps.android.compose;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "com.google.maps.android.compose.CameraPositionState", f = "CameraPositionState.kt", l = {324}, m = "animate")
final class CameraPositionState$animate$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f90609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f90610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f90611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f90612d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    /* synthetic */ Object f90613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ CameraPositionState f90614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f90615h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CameraPositionState$animate$1(CameraPositionState cameraPositionState, Continuation continuation) {
        super(continuation);
        this.f90614g = cameraPositionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f90613f = obj;
        this.f90615h |= Integer.MIN_VALUE;
        return this.f90614g.i(null, 0, this);
    }
}
