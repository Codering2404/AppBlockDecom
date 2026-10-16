package cz.mobilesoft.widgets;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.MultiProcessDataStoreFactory;
import androidx.datastore.core.Serializer;
import androidx.datastore.preferences.PreferenceDataStoreFile;
import androidx.glance.state.GlanceStateDefinition;
import cz.mobilesoft.widgets.AppBlockWidgetState;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.json.Json;

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
public final class AppBlockWidgetStateDefinition implements GlanceStateDefinition<AppBlockWidgetState> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WidgetDataProvider f133931b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static DataStore f133933d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppBlockWidgetStateDefinition f133930a = new AppBlockWidgetStateDefinition();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CoroutineScope f133932c = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)).plus(new AppBlockWidgetStateDefinition$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.u8)));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f133934e = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AppBlockWidgetStateSerializer implements Serializer<AppBlockWidgetState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AppBlockWidgetStateSerializer f133935a = new AppBlockWidgetStateSerializer();

        private AppBlockWidgetStateSerializer() {
        }

        @Override // androidx.datastore.core.Serializer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppBlockWidgetState getDefaultValue() {
            return new AppBlockWidgetState((AppBlockWidgetState.QuickBlockWidgetState) null, (AppBlockWidgetState.SchedulesWidgetState) null, false, 0, 15, (DefaultConstructorMarker) null);
        }

        @Override // androidx.datastore.core.Serializer
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object writeTo(AppBlockWidgetState appBlockWidgetState, OutputStream outputStream, Continuation continuation) {
            try {
                byte[] bytes = Json.f142959d.b(AppBlockWidgetState.Companion.serializer(), appBlockWidgetState).getBytes(Charsets.f140510b);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                outputStream.write(bytes);
                Unit unit = Unit.f139807a;
                CloseableKt.a(outputStream, null);
                return Unit.f139807a;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.a(outputStream, th);
                    throw th2;
                }
            }
        }

        @Override // androidx.datastore.core.Serializer
        public Object readFrom(InputStream inputStream, Continuation continuation) {
            try {
                Json.Default r3 = Json.f142959d;
                String strB = StringsKt.B(ByteStreamsKt.c(inputStream));
                r3.a();
                return (AppBlockWidgetState) r3.d(AppBlockWidgetState.Companion.serializer(), strB);
            } catch (Exception e3) {
                WidgetDataProvider widgetDataProvider = AppBlockWidgetStateDefinition.f133931b;
                if (widgetDataProvider != null) {
                    widgetDataProvider.o(e3);
                }
                return getDefaultValue();
            }
        }
    }

    private AppBlockWidgetStateDefinition() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File f(Context context) {
        return PreferenceDataStoreFile.a(context, "appBlockWidgetState");
    }

    @Override // androidx.glance.state.GlanceStateDefinition
    public Object a(Context context, String str, Continuation continuation) {
        return e(context);
    }

    @Override // androidx.glance.state.GlanceStateDefinition
    public File b(Context context, String fileKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileKey, "fileKey");
        return DataStoreFile.a(context, "appBlockWidgetState");
    }

    public final DataStore e(final Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        DataStore dataStore = f133933d;
        if (dataStore != null) {
            return dataStore;
        }
        DataStore dataStoreB = MultiProcessDataStoreFactory.b(MultiProcessDataStoreFactory.f35776a, AppBlockWidgetStateSerializer.f133935a, null, CollectionsKt.emptyList(), f133932c, new Function0() { // from class: cz.mobilesoft.widgets.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppBlockWidgetStateDefinition.f(context);
            }
        }, 2, null);
        WidgetApplication widgetApplication = dataStoreB instanceof WidgetApplication ? (WidgetApplication) dataStoreB : null;
        f133931b = widgetApplication != null ? widgetApplication.a() : null;
        f133933d = dataStoreB;
        return dataStoreB;
    }
}
