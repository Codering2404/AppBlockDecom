package com.google.firebase.sessions.api;

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
@DebugMetadata(c = "com.google.firebase.sessions.api.FirebaseSessionsDependencies", f = "FirebaseSessionsDependencies.kt", l = {110}, m = "getRegisteredSubscribers$com_google_firebase_firebase_sessions")
final class FirebaseSessionsDependencies$getRegisteredSubscribers$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f90129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f90130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f90131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f90132d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f90133f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f90134g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    /* synthetic */ Object f90135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ FirebaseSessionsDependencies f90136i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f90137j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FirebaseSessionsDependencies$getRegisteredSubscribers$1(FirebaseSessionsDependencies firebaseSessionsDependencies, Continuation continuation) {
        super(continuation);
        this.f90136i = firebaseSessionsDependencies;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f90135h = obj;
        this.f90137j |= Integer.MIN_VALUE;
        return this.f90136i.c(this);
    }
}
