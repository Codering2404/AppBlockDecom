package cz.mobilesoft.coreblock.usecase.timenudge;

import android.content.Context;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PickTimeNudgeNotificationMessageUseCase extends SuspendUseCase<Params, Message> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f127661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoreMultiProcessDataStore f127662b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Message {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f127663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f127664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f127665c;

        public Message(String titleKey, String title, String text) {
            Intrinsics.checkNotNullParameter(titleKey, "titleKey");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(text, "text");
            this.f127663a = titleKey;
            this.f127664b = title;
            this.f127665c = text;
        }

        public final String a() {
            return this.f127665c;
        }

        public final String b() {
            return this.f127664b;
        }

        public final String c() {
            return this.f127663a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Message)) {
                return false;
            }
            Message message = (Message) obj;
            return Intrinsics.areEqual(this.f127663a, message.f127663a) && Intrinsics.areEqual(this.f127664b, message.f127664b) && Intrinsics.areEqual(this.f127665c, message.f127665c);
        }

        public int hashCode() {
            return (((this.f127663a.hashCode() * 31) + this.f127664b.hashCode()) * 31) + this.f127665c.hashCode();
        }

        public String toString() {
            return "Message(titleKey=" + this.f127663a + ", title=" + this.f127664b + ", text=" + this.f127665c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Params f127666a = new Params();

        private Params() {
        }
    }

    public PickTimeNudgeNotificationMessageUseCase(Context context, CoreMultiProcessDataStore coreMultiProcessDataStore) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coreMultiProcessDataStore, "coreMultiProcessDataStore");
        this.f127661a = context;
        this.f127662b = coreMultiProcessDataStore;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(cz.mobilesoft.coreblock.usecase.timenudge.PickTimeNudgeNotificationMessageUseCase.Params r17, kotlin.coroutines.Continuation r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.timenudge.PickTimeNudgeNotificationMessageUseCase.a(cz.mobilesoft.coreblock.usecase.timenudge.PickTimeNudgeNotificationMessageUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
