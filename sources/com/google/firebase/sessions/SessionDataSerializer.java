package com.google.firebase.sessions;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;

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
public final class SessionDataSerializer implements Serializer<SessionData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SessionGenerator f90016a;

    public SessionDataSerializer(SessionGenerator sessionGenerator) {
        Intrinsics.checkNotNullParameter(sessionGenerator, "sessionGenerator");
        this.f90016a = sessionGenerator;
    }

    @Override // androidx.datastore.core.Serializer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SessionData getDefaultValue() {
        return new SessionData(this.f90016a.a(null), (Time) null, (Map) null, 6, (DefaultConstructorMarker) null);
    }

    @Override // androidx.datastore.core.Serializer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Object writeTo(SessionData sessionData, OutputStream outputStream, Continuation continuation) throws IOException {
        outputStream.write(StringsKt.C(Json.f142959d.b(SessionData.Companion.serializer(), sessionData)));
        return Unit.f139807a;
    }

    @Override // androidx.datastore.core.Serializer
    public Object readFrom(InputStream inputStream, Continuation continuation) throws CorruptionException {
        try {
            Json.Default r3 = Json.f142959d;
            String strB = StringsKt.B(ByteStreamsKt.c(inputStream));
            r3.a();
            return (SessionData) r3.d(SessionData.Companion.serializer(), strB);
        } catch (Exception e3) {
            throw new CorruptionException("Cannot parse session data", e3);
        }
    }
}
