package com.google.firebase.sessions.api;

import com.google.firebase.sessions.SharedSessionRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class CrashEventReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CrashEventReceiver f90123a = new CrashEventReceiver();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SharedSessionRepository f90124b;

    private CrashEventReceiver() {
    }

    public static final void b() {
        try {
            if (f90124b == null) {
                f90123a.c(SharedSessionRepository.f90068a.a());
            }
            CrashEventReceiver crashEventReceiver = f90123a;
            if (crashEventReceiver.a().a()) {
                crashEventReceiver.a().b();
            }
        } catch (Exception unused) {
        }
    }

    public final SharedSessionRepository a() {
        SharedSessionRepository sharedSessionRepository = f90124b;
        if (sharedSessionRepository != null) {
            return sharedSessionRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharedSessionRepository");
        return null;
    }

    public final void c(SharedSessionRepository sharedSessionRepository) {
        Intrinsics.checkNotNullParameter(sharedSessionRepository, "<set-?>");
        f90124b = sharedSessionRepository;
    }
}
