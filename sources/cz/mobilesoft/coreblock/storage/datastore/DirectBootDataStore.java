package cz.mobilesoft.coreblock.storage.datastore;

import android.content.Context;
import android.content.SharedPreferences;
import coil.target.Yb.oUcQRqOVfOC;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class DirectBootDataStore {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f124280d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f124281e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile DirectBootDataStore f124282f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f124283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableStateFlow f124284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StateFlow f124285c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DirectBootDataStore a(Context context) {
            DirectBootDataStore directBootDataStore;
            Intrinsics.checkNotNullParameter(context, "context");
            DirectBootDataStore directBootDataStore2 = DirectBootDataStore.f124282f;
            if (directBootDataStore2 != null) {
                return directBootDataStore2;
            }
            synchronized (this) {
                directBootDataStore = DirectBootDataStore.f124282f;
                if (directBootDataStore == null) {
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    directBootDataStore = new DirectBootDataStore(applicationContext, null);
                    DirectBootDataStore.f124282f = directBootDataStore;
                }
            }
            return directBootDataStore;
        }

        private Companion() {
        }

        public final boolean b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                return context.createDeviceProtectedStorageContext().getSharedPreferences("direct_boot_prefs", 0).getBoolean(oUcQRqOVfOC.LxHsiHJWNkgKpFu, false);
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public /* synthetic */ DirectBootDataStore(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public final StateFlow c() {
        return this.f124285c;
    }

    public final void d(boolean z2) {
        try {
            SharedPreferences sharedPrefs = this.f124283a;
            Intrinsics.checkNotNullExpressionValue(sharedPrefs, "sharedPrefs");
            SharedPreferences.Editor editorEdit = sharedPrefs.edit();
            editorEdit.putBoolean("init_overlay_enabled", z2);
            editorEdit.commit();
            this.f124284b.setValue(Boolean.valueOf(z2));
        } catch (Exception unused) {
        }
    }

    private DirectBootDataStore(Context context) {
        SharedPreferences sharedPreferences = context.createDeviceProtectedStorageContext().getSharedPreferences("direct_boot_prefs", 0);
        this.f124283a = sharedPreferences;
        MutableStateFlow mutableStateFlowA = StateFlowKt.a(Boolean.valueOf(sharedPreferences.getBoolean("init_overlay_enabled", false)));
        this.f124284b = mutableStateFlowA;
        this.f124285c = FlowKt.c(mutableStateFlowA);
    }
}
