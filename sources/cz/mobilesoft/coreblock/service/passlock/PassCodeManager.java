package cz.mobilesoft.coreblock.service.passlock;

import android.app.Activity;
import android.util.Log;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;

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
public final class PassCodeManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f123534e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f123535f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PassCodeDataStore f123536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f123537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f123538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoroutineScope f123539d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PassCodeManager(LockieApplication application, PassCodeDataStore dataStore) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        this.f123536a = dataStore;
        this.f123537b = application.k();
        this.f123538c = application.j();
        this.f123539d = CoroutinesHelperExtKt.a(Dispatchers.b());
    }

    private final Object e(Continuation continuation) {
        return FlowKt.D(this.f123536a.x(), continuation);
    }

    private final boolean f(Activity activity) {
        return this.f123538c.contains(activity.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean g(Activity activity) {
        if (!this.f123537b.contains(activity.getClass())) {
            PassLockExempt passLockExempt = activity instanceof PassLockExempt ? (PassLockExempt) activity : null;
            if (passLockExempt == null || !passLockExempt.g()) {
                return false;
            }
        }
        return true;
    }

    private final Object h(Continuation continuation) {
        return this.f123536a.B(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        BuildersKt__Builders_commonKt.d(this.f123539d, null, null, new PassCodeManager$setLastActiveMillis$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b1, code lost:
    
        if (r12 == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(android.app.Activity r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.passlock.PassCodeManager.l(android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void i(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!g(activity)) {
            k();
            return;
        }
        String str = Reflection.b(activity.getClass()).m() + " is ignored";
        String simpleName = PassCodeManager.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        Log.d(simpleName, str);
    }

    public final void j(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BuildersKt__Builders_commonKt.d(this.f123539d, null, null, new PassCodeManager$onActivityResumed$1(this, activity, null), 3, null);
    }
}
