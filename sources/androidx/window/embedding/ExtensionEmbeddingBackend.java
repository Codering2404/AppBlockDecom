package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.core.util.Consumer;
import androidx.window.core.BuildConfig;
import androidx.window.core.VerificationMode;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import androidx.window.embedding.ExtensionEmbeddingBackend;
import androidx.window.embedding.SplitController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ExtensionEmbeddingBackend implements EmbeddingBackend {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f54207e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ReentrantLock f54208f = new ReentrantLock();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f54209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private EmbeddingInterfaceCompat f54210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CopyOnWriteArrayList f54211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EmbeddingCallbackImpl f54212d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Api31Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api31Impl f54213a = new Api31Impl();

        private Api31Impl() {
        }

        public final SplitController.SplitSupportStatus a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                PackageManager.Property property = context.getPackageManager().getProperty("android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED", context.getPackageName());
                Intrinsics.checkNotNullExpressionValue(property, "try {\n                co…OT_DECLARED\n            }");
                if (property.isBoolean()) {
                    return property.getBoolean() ? SplitController.SplitSupportStatus.f54271c : SplitController.SplitSupportStatus.f54272d;
                }
                if (BuildConfig.f54113a.a() == VerificationMode.LOG) {
                    Log.w("EmbeddingBackend", "android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED must have a boolean value");
                }
                return SplitController.SplitSupportStatus.f54273e;
            } catch (PackageManager.NameNotFoundException unused) {
                if (BuildConfig.f54113a.a() == VerificationMode.LOG) {
                    Log.w("EmbeddingBackend", "android.window.PROPERTY_ACTIVITY_EMBEDDING_SPLITS_ENABLED must be set and enabled in AndroidManifest.xml to use splits APIs.");
                }
                return SplitController.SplitSupportStatus.f54273e;
            } catch (Exception e3) {
                if (BuildConfig.f54113a.a() == VerificationMode.LOG) {
                    Log.e("EmbeddingBackend", "PackageManager.getProperty is not supported", e3);
                }
                return SplitController.SplitSupportStatus.f54273e;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class EmbeddingCallbackImpl implements EmbeddingInterfaceCompat.EmbeddingCallbackInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f54214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ExtensionEmbeddingBackend f54215b;

        @Override // androidx.window.embedding.EmbeddingInterfaceCompat.EmbeddingCallbackInterface
        public void a(List splitInfo) {
            Intrinsics.checkNotNullParameter(splitInfo, "splitInfo");
            this.f54214a = splitInfo;
            Iterator it = this.f54215b.f().iterator();
            while (it.hasNext()) {
                ((SplitListenerWrapper) it.next()).b(splitInfo);
            }
        }

        public final List b() {
            return this.f54214a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class RuleTracker {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SplitListenerWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Activity f54216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Executor f54217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Consumer f54218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List f54219d;

        public SplitListenerWrapper(Activity activity, Executor executor, Consumer callback) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(executor, "executor");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f54216a = activity;
            this.f54217b = executor;
            this.f54218c = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(SplitListenerWrapper this$0, List splitsWithActivity) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(splitsWithActivity, "$splitsWithActivity");
            this$0.f54218c.accept(splitsWithActivity);
        }

        public final void b(List splitInfoList) {
            Intrinsics.checkNotNullParameter(splitInfoList, "splitInfoList");
            final ArrayList arrayList = new ArrayList();
            for (Object obj : splitInfoList) {
                if (((SplitInfo) obj).a(this.f54216a)) {
                    arrayList.add(obj);
                }
            }
            if (Intrinsics.areEqual(arrayList, this.f54219d)) {
                return;
            }
            this.f54219d = arrayList;
            this.f54217b.execute(new Runnable() { // from class: androidx.window.embedding.b
                @Override // java.lang.Runnable
                public final void run() {
                    ExtensionEmbeddingBackend.SplitListenerWrapper.c(this.f54313a, arrayList);
                }
            });
        }

        public final Consumer d() {
            return this.f54218c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e() {
        return this.f54210b != null;
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public void a(Activity activity, Executor executor, Consumer callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ReentrantLock reentrantLock = f54208f;
        reentrantLock.lock();
        try {
            if (this.f54210b == null) {
                Log.v("EmbeddingBackend", "Extension not loaded, skipping callback registration.");
                callback.accept(CollectionsKt.emptyList());
                return;
            }
            SplitListenerWrapper splitListenerWrapper = new SplitListenerWrapper(activity, executor, callback);
            this.f54211c.add(splitListenerWrapper);
            if (this.f54212d.b() != null) {
                List listB = this.f54212d.b();
                Intrinsics.checkNotNull(listB);
                splitListenerWrapper.b(listB);
            } else {
                splitListenerWrapper.b(CollectionsKt.emptyList());
            }
            Unit unit = Unit.f139807a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public void b(Consumer consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        ReentrantLock reentrantLock = f54208f;
        reentrantLock.lock();
        try {
            Iterator it = this.f54211c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SplitListenerWrapper splitListenerWrapper = (SplitListenerWrapper) it.next();
                if (Intrinsics.areEqual(splitListenerWrapper.d(), consumer)) {
                    this.f54211c.remove(splitListenerWrapper);
                    break;
                }
            }
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final CopyOnWriteArrayList f() {
        return this.f54211c;
    }
}
