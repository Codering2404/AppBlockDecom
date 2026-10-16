package cz.mobilesoft.appblock.service.lock;

import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PopupDetectionTracker {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f94829g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f94830h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f94831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f94832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f94833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f94834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f94835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f94836f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PopupDetectionTracker(Function0 isFloatingWindowBlockingSupplier, Function0 isPopupBlockingSupportedSupplier) {
        Intrinsics.checkNotNullParameter(isFloatingWindowBlockingSupplier, "isFloatingWindowBlockingSupplier");
        Intrinsics.checkNotNullParameter(isPopupBlockingSupportedSupplier, "isPopupBlockingSupportedSupplier");
        this.f94831a = isFloatingWindowBlockingSupplier;
        this.f94832b = isPopupBlockingSupportedSupplier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b() {
        return RunnabilityHelper.f129617a.I();
    }

    public final boolean c(String currentForegroundPackage) {
        String str;
        Intrinsics.checkNotNullParameter(currentForegroundPackage, "currentForegroundPackage");
        if (((Boolean) this.f94832b.invoke()).booleanValue() && !((Boolean) this.f94831a.invoke()).booleanValue() && (str = this.f94833c) != null && Intrinsics.areEqual(str, currentForegroundPackage)) {
            if (!this.f94834d) {
                return true;
            }
            this.f94834d = false;
        }
        return false;
    }

    public final void d(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.f94833c = packageName;
    }

    public final boolean e(String applicationPackage, boolean z2, long j3) {
        Intrinsics.checkNotNullParameter(applicationPackage, "applicationPackage");
        if (!z2) {
            if (Intrinsics.areEqual(applicationPackage, this.f94835e)) {
                this.f94835e = null;
                this.f94836f = 0L;
            }
            return false;
        }
        if (Intrinsics.areEqual(applicationPackage, this.f94835e) && j3 < this.f94836f) {
            return true;
        }
        this.f94835e = applicationPackage;
        this.f94836f = j3 + 10000;
        return false;
    }

    public final void f(String str) {
        if (str == null || Intrinsics.areEqual(str, this.f94833c)) {
            return;
        }
        this.f94834d = true;
    }

    public /* synthetic */ PopupDetectionTracker(Function0 function0, Function0 function02, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i3 & 2) != 0 ? new Function0() { // from class: cz.mobilesoft.appblock.service.lock.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PopupDetectionTracker.b());
            }
        } : function02);
    }
}
