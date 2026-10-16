package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AppEventDiskStore {
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    public static final AppEventDiskStore INSTANCE = new AppEventDiskStore();
    private static final String TAG = AppEventDiskStore.class.getName();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2";
        public static final Companion Companion = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public MovedClassObjectInputStream(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected ObjectStreamClass readClassDescriptor() throws ClassNotFoundException, IOException {
            ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();
            if (Intrinsics.areEqual(resultClassDescriptor.getName(), ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                resultClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            } else if (Intrinsics.areEqual(resultClassDescriptor.getName(), APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                resultClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV2.class);
            }
            Intrinsics.checkNotNullExpressionValue(resultClassDescriptor, "resultClassDescriptor");
            return resultClassDescriptor;
        }
    }

    private AppEventDiskStore() {
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x004d: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:78), block:B:24:0x004d */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b9 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #14 {, blocks: (B:4:0x0003, B:10:0x0030, B:61:0x00b9, B:15:0x003f, B:16:0x0042, B:38:0x006c, B:41:0x0077, B:45:0x0083, B:48:0x008e, B:50:0x0091, B:54:0x00a3, B:53:0x009c, B:55:0x00a4, B:58:0x00af, B:6:0x000b, B:9:0x002d, B:37:0x0065, B:44:0x007c, B:31:0x0057, B:32:0x005a), top: B:84:0x0003, inners: #0, #1, #4, #5, #10, #11 }] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            java.lang.Class<com.facebook.appevents.AppEventDiskStore> r0 = com.facebook.appevents.AppEventDiskStore.class
            monitor-enter(r0)
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch: java.lang.Throwable -> L3b
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L3b
            r2 = 0
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch: java.lang.Throwable -> L47 java.lang.ClassNotFoundException -> L5b java.io.IOException -> L60 java.io.FileNotFoundException -> La4
            java.lang.String r4 = "context.openFileInput(PERSISTED_EVENTS_FILENAME)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch: java.lang.Throwable -> L47 java.lang.ClassNotFoundException -> L5b java.io.IOException -> L60 java.io.FileNotFoundException -> La4
            com.facebook.appevents.AppEventDiskStore$MovedClassObjectInputStream r4 = new com.facebook.appevents.AppEventDiskStore$MovedClassObjectInputStream     // Catch: java.lang.Throwable -> L47 java.lang.ClassNotFoundException -> L5b java.io.IOException -> L60 java.io.FileNotFoundException -> La4
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L47 java.lang.ClassNotFoundException -> L5b java.io.IOException -> L60 java.io.FileNotFoundException -> La4
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L47 java.lang.ClassNotFoundException -> L5b java.io.IOException -> L60 java.io.FileNotFoundException -> La4
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L47 java.lang.ClassNotFoundException -> L5b java.io.IOException -> L60 java.io.FileNotFoundException -> La4
            java.lang.Object r3 = r4.readObject()     // Catch: java.lang.Throwable -> L51
            java.lang.String r5 = "null cannot be cast to non-null type com.facebook.appevents.PersistedEvents"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r5)     // Catch: java.lang.Throwable -> L51
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch: java.lang.Throwable -> L51
            kotlin.Unit r5 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L4f
            kotlin.io.CloseableKt.a(r4, r2)     // Catch: java.lang.Throwable -> L47 java.lang.ClassNotFoundException -> L49 java.io.IOException -> L4b java.io.FileNotFoundException -> L4d
            java.lang.String r2 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            r1.delete()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            goto Lb7
        L3b:
            r1 = move-exception
            goto Lc0
        L3e:
            r1 = move-exception
            java.lang.String r2 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> L3b
            goto L79
        L42:
            android.util.Log.w(r2, r4, r1)     // Catch: java.lang.Throwable -> L3b
            goto Lb7
        L47:
            r2 = move-exception
            goto L91
        L49:
            r2 = move-exception
            goto L65
        L4b:
            r2 = move-exception
            goto L7c
        L4d:
            r2 = r3
            goto La4
        L4f:
            r2 = move-exception
            goto L55
        L51:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L55:
            throw r2     // Catch: java.lang.Throwable -> L56
        L56:
            r5 = move-exception
            kotlin.io.CloseableKt.a(r4, r2)     // Catch: java.lang.Throwable -> L47 java.lang.ClassNotFoundException -> L49 java.io.IOException -> L4b java.io.FileNotFoundException -> L4d
            throw r5     // Catch: java.lang.Throwable -> L47 java.lang.ClassNotFoundException -> L49 java.io.IOException -> L4b java.io.FileNotFoundException -> L4d
        L5b:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
            goto L65
        L60:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
            goto L7c
        L65:
            java.lang.String r4 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> L47
            java.lang.String r5 = "Got unexpected exception while reading events: "
            android.util.Log.w(r4, r5, r2)     // Catch: java.lang.Throwable -> L47
            java.lang.String r2 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L76
            r1.delete()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L76
            goto Lb7
        L76:
            r1 = move-exception
            java.lang.String r2 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> L3b
        L79:
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            goto L42
        L7c:
            java.lang.String r4 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> L47
            java.lang.String r5 = "Got unexpected exception while reading events: "
            android.util.Log.w(r4, r5, r2)     // Catch: java.lang.Throwable -> L47
            java.lang.String r2 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L8d
            r1.delete()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L8d
            goto Lb7
        L8d:
            r1 = move-exception
            java.lang.String r2 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> L3b
            goto L79
        L91:
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L9b
            r1.delete()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L9b
            goto La3
        L9b:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r3, r4, r1)     // Catch: java.lang.Throwable -> L3b
        La3:
            throw r2     // Catch: java.lang.Throwable -> L3b
        La4:
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> Lae
            r1.delete()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> Lae
            goto Lb6
        Lae:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r3, r4, r1)     // Catch: java.lang.Throwable -> L3b
        Lb6:
            r3 = r2
        Lb7:
            if (r3 != 0) goto Lbe
            com.facebook.appevents.PersistedEvents r3 = new com.facebook.appevents.PersistedEvents     // Catch: java.lang.Throwable -> L3b
            r3.<init>()     // Catch: java.lang.Throwable -> L3b
        Lbe:
            monitor-exit(r0)
            return r3
        Lc0:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3b
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventDiskStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    @JvmStatic
    public static final void saveEventsToDisk$facebook_core_release(PersistedEvents persistedEvents) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
            try {
                objectOutputStream.writeObject(persistedEvents);
                Unit unit = Unit.f139807a;
                CloseableKt.a(objectOutputStream, null);
            } finally {
            }
        } catch (IOException e3) {
            Log.w(TAG, "Got unexpected exception while persisting events: ", e3);
            try {
                applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
            } catch (Exception unused) {
            }
        }
    }
}
