package com.google.firebase.sessions;

import java.util.Locale;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
@Singleton
@Metadata
public final class SessionGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimeProvider f90054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final UuidGenerator f90055b;

    public SessionGenerator(TimeProvider timeProvider, UuidGenerator uuidGenerator) {
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(uuidGenerator, "uuidGenerator");
        this.f90054a = timeProvider;
        this.f90055b = uuidGenerator;
    }

    private final String b() {
        String string = this.f90055b.next().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String lowerCase = StringsKt.O(string, "-", "", false, 4, null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final SessionDetails a(SessionDetails sessionDetails) {
        String strA;
        String strB = b();
        if (sessionDetails == null || (strA = sessionDetails.a()) == null) {
            strA = strB;
        }
        return new SessionDetails(strB, strA, sessionDetails != null ? sessionDetails.c() + 1 : 0, this.f90054a.a().b());
    }
}
