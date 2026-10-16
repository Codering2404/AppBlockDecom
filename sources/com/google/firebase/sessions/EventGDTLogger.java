package com.google.firebase.sessions;

import android.util.Log;
import com.facebook.GraphRequest;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Singleton
@Metadata
public final class EventGDTLogger implements EventGDTLoggerInterface {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f89953b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f89954a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public EventGDTLogger(Provider transportFactoryProvider) {
        Intrinsics.checkNotNullParameter(transportFactoryProvider, "transportFactoryProvider");
        this.f89954a = transportFactoryProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] c(SessionEvent sessionEvent) {
        String strB = SessionEvents.f90026a.c().b(sessionEvent);
        Intrinsics.checkNotNullExpressionValue(strB, "encode(...)");
        Log.d("FirebaseSessions", "Session Event Type: " + sessionEvent.b().name());
        byte[] bytes = strB.getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    @Override // com.google.firebase.sessions.EventGDTLoggerInterface
    public void a(SessionEvent sessionEvent) {
        Intrinsics.checkNotNullParameter(sessionEvent, "sessionEvent");
        ((TransportFactory) this.f89954a.get()).a("FIREBASE_APPQUALITY_SESSION", SessionEvent.class, Encoding.b(GraphRequest.FORMAT_JSON), new Transformer() { // from class: com.google.firebase.sessions.a
            @Override // com.google.android.datatransport.Transformer
            public final Object apply(Object obj) {
                return this.f90122a.c((SessionEvent) obj);
            }
        }).b(Event.f(sessionEvent));
    }
}
