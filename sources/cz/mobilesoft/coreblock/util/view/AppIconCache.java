package cz.mobilesoft.coreblock.util.view;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.facebook.internal.Utility;
import cz.mobilesoft.coreblock.LockieApplication;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AppIconCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f129940a = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.view.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AppIconCache.h();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f129941b = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable d(String str) {
        try {
            ApplicationInfo applicationInfo = g().getApplicationInfo(str, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            if (applicationInfo != null) {
                return g().getApplicationIcon(applicationInfo);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private final PackageManager g() {
        Object value = this.f129940a.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (PackageManager) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PackageManager h() {
        return LockieApplication.g().getPackageManager();
    }

    public final Drawable e(String packageName) {
        Drawable drawableD;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (!this.f129941b.containsKey(packageName) && (drawableD = d(packageName)) != null) {
            this.f129941b.put(packageName, drawableD);
        }
        return (Drawable) this.f129941b.get(packageName);
    }

    public final Object f(String str, Continuation continuation) {
        return BuildersKt.g(Dispatchers.b(), new AppIconCache$getCachedOrQuerySystemAsync$2(this, str, null), continuation);
    }
}
